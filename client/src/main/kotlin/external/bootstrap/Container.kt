@file:JsModule("react-bootstrap/Container")
@file:JsNonModule

package external.bootstrap

import react.ComponentClass
import react.PropsWithClassName

@JsName("default")
external val Container : ComponentClass<ContainerProps>

external interface ContainerProps : PropsWithClassName  {
    var fluid: Boolean
}
