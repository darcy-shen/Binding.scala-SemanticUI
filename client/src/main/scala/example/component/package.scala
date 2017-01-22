package example

import com.thoughtworks.binding.Binding.{BindingSeq, Constants}
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.raw.Node

/**
  * Created by rendong on 17/1/22.
  */
package object component {
  implicit def autoBinding[A](a: A): Binding[A] = Binding(a)

  implicit final class ButtonTag(x: dom.Runtime.TagsAndTags2.type) {

    def Button = ButtonBuilder()

  }

  implicit def toHtml(x: ButtonBuilder): BindingSeq[Node] = {
    Constants(x.build).mapBinding(identity)
  }
}
