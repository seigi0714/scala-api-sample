package infra

import domain.entities.{Name, User, UserId}
import domain.repositories.{UserRepository => UserRepositoryInterface}

import java.time.LocalDate

class UserRepository extends UserRepositoryInterface {
  override def findById(id: Int): User = {
    val birthDay = LocalDate.now().minusYears(30)
    User(id = UserId(id), userName = Name(firstName = "nakamura", lastName = "seigi"), birthDay = birthDay)
  }
}
