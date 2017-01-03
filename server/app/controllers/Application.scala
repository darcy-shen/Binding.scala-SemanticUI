package controllers

import javax.inject._

import play.api.libs.json.Json
import play.api.mvc._
import shared.SharedMessages

class Application @Inject() (webJarAssets: WebJarAssets) extends Controller {

  def index = Action {
    Ok(views.html.index(SharedMessages.itWorks, webJarAssets))
  }

  def another = Action {
    Ok(views.html.another(SharedMessages.itWorks, webJarAssets))
  }
}
