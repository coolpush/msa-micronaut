package user.service.repository

import user.service.domain.User
import java.util.concurrent.Callable
import javax.inject.Singleton


@Singleton
class UserRepository {

  fun findById(id: Long): Callable<User> {
    return Callable { User(id, "Leonardo", "1234") }
  }
}