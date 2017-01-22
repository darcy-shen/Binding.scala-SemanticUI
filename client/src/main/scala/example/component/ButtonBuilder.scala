package example.component

import com.thoughtworks.binding.{Binding, dom}

/**
  * Created by rendong on 17/1/22.
  */
case class ButtonBuilder() {
  def render = this

  var foo: Binding[String] = _

  @dom def build = <button>{foo.bind}</button>
}



