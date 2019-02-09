package com.example.demo.controller

import com.example.demo.model.HostModel
import com.example.demo.model.PersonModel
import com.example.demo.service.HostService
import com.example.demo.service.PersonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Controllers for writer datasource
 * @author tree
 */
@RestController
@RequestMapping("/writer")
class WriterController(
  private val hostService: HostService,
  private val personService: PersonService
) {
  @GetMapping("/host/select")
  fun selectWriterHost(): Mono<HostModel> = Mono.just(hostService.findWriterHost())

  @GetMapping("/person/select")
  fun selectWriterPerson(): Flux<List<PersonModel>> = Flux.just(personService.getWriterPersons())

  @GetMapping("/person/insert")
  fun insert(): Flux<Int> = Flux.just(personService.saveWriterPerson())

  @GetMapping("/person/update")
  fun update(): Flux<Int> = Flux.just(personService.editWriterPerson())

  @GetMapping("/person/delete")
  fun delete(): Flux<Int> = Flux.just(personService.removeWriterPerson())
}
