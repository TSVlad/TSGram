package ru.tsvlad.tsgram.chatservice.config

import com.nimbusds.jose.shaded.json.JSONArray
import com.nimbusds.jose.shaded.json.JSONObject
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity.OAuth2ResourceServerSpec
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverter
import org.springframework.security.web.server.SecurityWebFilterChain
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.stream.Collectors

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
class SecurityConfig {
    @Bean
    fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain? {
        return http
            .csrf().disable()
            .authorizeExchange()
            .anyExchange().permitAll()
            .and().oauth2ResourceServer { resourceServerConfigurer: OAuth2ResourceServerSpec ->
                resourceServerConfigurer
                    .jwt { jwtConfigurer: OAuth2ResourceServerSpec.JwtSpec ->
                        jwtConfigurer
                            .jwtAuthenticationConverter(jwtAuthenticationConverter())
                    }
            }
            .build()
    }

    @Bean
    fun jwtAuthenticationConverter(): Converter<Jwt, Mono<AbstractAuthenticationToken>> {
        val reactiveJwtAuthenticationConverter = ReactiveJwtAuthenticationConverter()
        reactiveJwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter())
        return reactiveJwtAuthenticationConverter
    }

    @Bean
    fun jwtGrantedAuthoritiesConverter(): Converter<Jwt, Flux<GrantedAuthority>> {
        val converter = object : Converter<Jwt, Flux<GrantedAuthority>> {
            override fun convert(jwt: Jwt): Flux<GrantedAuthority> {
                if (jwt.getClaim<Any?>("realm_access") == null) {
                    return Flux.empty<GrantedAuthority?>()
                }
                val realmAccess = jwt.getClaim<JSONObject>("realm_access")
                if (realmAccess["roles"] == null) {
                    return Flux.empty<GrantedAuthority?>()
                }
                val roles = realmAccess["roles"] as JSONArray?
                val keycloakAuthorities = roles!!.stream()
                    .map { role: Any ->
                        SimpleGrantedAuthority(
                            role.toString()
                        )
                    }.collect(Collectors.toList())
                return Flux.fromIterable(keycloakAuthorities)
            }
        }

        return converter;
    }
}