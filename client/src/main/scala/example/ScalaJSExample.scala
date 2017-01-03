package example

import com.thoughtworks.binding.Binding.Var
import com.thoughtworks.binding.dom
import org.scalajs.dom.document
import org.scalajs.dom.ext.Ajax
import org.scalajs.dom.raw.Event
import org.scalajs.jquery.jQuery

import scala.scalajs.concurrent.JSExecutionContext.Implicits.queue
import scala.scalajs.js
import scala.scalajs.js.JSON


object ScalaJSExample extends js.JSApp {


  /**
    * Ajax Request to server, updates data state with number
    * of requests to count.
    * @param data
    */
  def countRequest(data: Var[String]) = {
    val url = "http://localhost:9000/count"
    Ajax.get(url).onSuccess { case xhr =>
      data := JSON.parse(xhr.responseText).count.toString
    }
  }

  @dom
  def render = {
    val data = Var("")
    val input = <input class="prompt" type="text" placeholder="Search country..." />
    countRequest(data) // initial population
    <div>
      <div class="ui search">
        <div class="ui icon input">
          { input }
          <i class="search icon"></i>
        </div>
        <div class="results"></div>
      </div>
      <select class="ui search dropdown">
        <option>State</option>
        <option value="AL">Alabama</option>
        <option value="AK">Alaska</option>
        <option value="AZ">Arizona</option>
      </select>
      <button class="ui primary button" onclick={event: Event => countRequest(data) }>
        Boop
      </button>
      From Play: The server has been booped { data.bind } times. Shared Message: {shared.SharedMessages.itWorks}.
    </div>
  }

  def main(): Unit = {
    dom.render(document.body, render)
    import SemanticUI.jq2semantic
    //import js.JSConverters._
    //val content = List("China", "Canada", "USA")
    //  .map(country => mutable.HashMap("title" -> country).toJSDictionary)
    //  .toJSArray
    val content = js.Array("China", "Canada", "USA")
      .map(country => js.Dictionary("title" -> country))
    jQuery(".ui.search").search(js.Dynamic.literal(source = content))
    jQuery(".ui.dropdown").dropdown(js.Dynamic.literal(on = "hover"))
  }
}
