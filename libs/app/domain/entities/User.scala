package domain.entities

import Helper.DateHelper
import play.api.libs.json.{JsValue, Json, Writes}

import java.time.LocalDate

case class User(
                 val id: UserId,
                 val userName: Name,
                 val birthDay: LocalDate
               ) {
  def changeOwnerName(newName: Name): User = {
    copy(userName = newName)
  }

  def age(): Int = {
    DateHelper().calcAge(birthDay)
  }

  def toJson: JsValue = {
    Json.obj(
      "id" -> id.id,
      "userName" -> userName.fullName(),
      "age" -> age()
    )
  }
}

case class UserId(val id: Int)

case class Name(val firstName: String, val lastName: String) {
  def fullName(): String = {
    firstName + " " + lastName
  }
}

