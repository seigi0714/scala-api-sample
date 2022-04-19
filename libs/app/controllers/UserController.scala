package controllers

import domain.entities.User
import domain.repositories.UserRepository
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}
import services.UserService

import javax.inject.Inject

class UserController @Inject()(cc: ControllerComponents, userRepo: UserRepository) extends AbstractController(cc) {

  val userService = new UserService(userRepo)

  def find(userId: Int): Action[AnyContent] = Action {
    val user = userService.findUser(userId)
    Ok(
      Json.obj(
        "data" -> user.toJson
      )
    )
  }
}
