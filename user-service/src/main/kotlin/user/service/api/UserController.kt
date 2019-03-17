package user.service.api

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import user.service.domain.User
import user.service.repository.UserRepository


@Controller("/api")
class UserController(val repository: UserRepository) {

  @Get("/{id}")
  fun detail(id: Long): Mono<User> = Mono.fromCallable(repository.findById(id))
      .subscribeOn(Schedulers.elastic())

}