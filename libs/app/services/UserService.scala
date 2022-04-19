package services

import domain.entities.User
import domain.repositories.UserRepository

import javax.inject.Inject


class UserService @Inject()(userRepository: UserRepository) {
  def findUser(userId: Int): User = {
    userRepository.findById(userId)
  }
}
