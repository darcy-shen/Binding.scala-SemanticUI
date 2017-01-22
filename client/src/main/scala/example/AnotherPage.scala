package example

import com.thoughtworks.binding.Binding.{BindingSeq, Constants}
import com.thoughtworks.binding.{Binding, dom}

import scala.scalajs.js
import org.scalajs.dom.document
import example.component.autoBinding
import example.component.toHtml
import example.component.ButtonTag

/**
  * Created by rendong on 17/1/3.
  */

object AnotherPage extends js.JSApp {
  @dom
  def render = {
    <div>
      <h1>This is another page</h1>
      <Button foo="Hello, World"/>
    </div>
  }

  override def main() = {
    dom.render(document.body, render)
  }
}
