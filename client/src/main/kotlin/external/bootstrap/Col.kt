@file:JsModule("react-bootstrap/Col")
@file:JsNonModule

package external.bootstrap

import react.ComponentClass
import react.PropsWithClassName

@JsName("default")
external val Col: ComponentClass<ColProps>

external interface ColProps : PropsWithClassName {
    var xs: Int
    var sm: Int
    var md: Int
    var lg: Int
    var xl: Int
    var xxl: Int
}