package example

import com.thoughtworks.binding.dom

import scala.scalajs.js
import org.scalajs.dom.document

/**
  * Created by rendong on 17/1/3.
  */
object AnotherPage extends js.JSApp {
  @dom
  def render = {
    <div>
      <h1>This is another page</h1>
    </div>
  }

  override def main() = {
    dom.render(document.body, render)
  }
}
