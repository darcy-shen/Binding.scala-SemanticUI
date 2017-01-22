package example

import com.thoughtworks.binding.Binding.{BindingSeq, Constants}
import com.thoughtworks.binding.{Binding, dom}

import scala.scalajs.js
import org.scalajs.dom.document
import org.scalajs.dom.raw.Node

/**
  * Created by rendong on 17/1/3.
  */
case class MyComponentBuilder() {

  def render = this

  var foo: Binding[String] = _

  @dom def build = <button>{foo.bind}</button>

}



object AnotherPage extends js.JSApp {
  implicit def autoBinding[A](a: A): Binding[A] = Binding(a)

  implicit final class CustomTags(x: dom.Runtime.TagsAndTags2.type) {

    def MyComponent() = MyComponentBuilder()

  }

  implicit def toHtml(x: MyComponentBuilder): BindingSeq[Node] = {
    Constants(x.build).mapBinding(identity)
  }

  @dom
  def render = {
    <div>
      <h1>This is another page</h1>
      <MyComponent foo="Hello, World"/>
    </div>
  }

  override def main() = {
    dom.render(document.body, render)
  }
}
