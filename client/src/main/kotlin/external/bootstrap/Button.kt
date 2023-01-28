@file:JsModule("react-bootstrap/Button") //import Button from 'react-bootstrap/Button';

@file:JsNonModule

package external.bootstrap

import react.ComponentClass
import react.Props

@JsName("default") //export default external.getButton
external val Button : ComponentClass<ButtonProps>
external interface ButtonProps : Props {
    var variant: String
}