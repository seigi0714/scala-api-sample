package controllers

import play.api.libs.json.{JsValue, Json}
import play.api.mvc._

import javax.inject.Inject

class HelloController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def hello(): Action[AnyContent] = Action {
    Ok("Hello World")
  }

  def helloJson(): Action[AnyContent] = Action {
    implicit request =>

      val id = request.getQueryString("id").get
      val json: JsValue = Json.obj(
        "hello" -> "world",
        "language" -> "scala",
        "id" -> id,
      )

      Ok(json)
  }
}
