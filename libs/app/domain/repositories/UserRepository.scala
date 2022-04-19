package domain.repositories

import domain.entities.User

trait UserRepository {
  def findById(id: Int): User
}
