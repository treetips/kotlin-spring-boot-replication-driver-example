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
 * Controllers for reader datasource
 * @author tree
 */
@RestController
@RequestMapping("/reader")
class ReaderController(
  private val hostService: HostService,
  private val personService: PersonService
) {
  @GetMapping("/host/select")
  fun selectReaderHost(): Mono<HostModel> = Mono.just(hostService.findReaderHost())

  @GetMapping("/person/select")
  fun selectWriterHost(): Flux<List<PersonModel>> = Flux.just(personService.getReaderPersons())
}
