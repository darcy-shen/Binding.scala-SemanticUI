package example

import com.thoughtworks.binding.Binding.{BindingSeq, Constants}
import com.thoughtworks.binding.{Binding, dom}

import scala.scalajs.js
import org.scalajs.dom.document
import com.sadhen.binding.component.tag.Pagination
import com.sadhen.binding.component._

/**
  * Created by rendong on 17/1/3.
  */

object AnotherPage extends js.JSApp {
  @dom
  def render = {
    <div>
      <Pagination simple={true} />
    </div>
  }

  override def main() = {
    dom.render(document.body, render)
  }
}
