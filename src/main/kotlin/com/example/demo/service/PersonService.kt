package com.example.demo.service

import com.example.demo.model.PersonModel
import com.example.demo.repository.PersonRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Person service
 * @author tree
 */
@Service
class PersonService(
  private val personRepository: PersonRepository
) {
  /**
   * get person of writer datasource
   * @return persons
   */
  @Transactional
  fun getWriterPersons(): List<PersonModel> = personRepository.findAll()

  /**
   * get person of reader datasource
   * @return persons
   */
  @Transactional(readOnly = true)
  fun getReaderPersons(): List<PersonModel> = personRepository.findAll()

  /**
   * insert person of writer datasource
   * @return insert number
   */
  @Transactional
  fun saveWriterPerson(): Int = personRepository.insert(name = "writer")

  /**
   * insert person of reader datasource
   * @return insert number
   */
  @Transactional(readOnly = true)
  fun saveReaderPerson(): Int = personRepository.insert(name = "reader")

  /**
   * update person of writer datasource
   * @return update number
   */
  @Transactional
  fun editWriterPerson(): Int = personRepository.update(name = "writer updated")

  /**
   * update person of reader datasource
   * @return update number
   */
  @Transactional(readOnly = true)
  fun editReaderPerson(): Int = personRepository.update(name = "reader")

  /**
   * delete person of writer datasource
   * @return delete count
   */
  @Transactional
  fun removeWriterPerson(): Int = personRepository.delete(name = "writer")

  /**
   * delete person of reader datasource
   * @return delete count
   */
  @Transactional(readOnly = true)
  fun removeReaderPerson(): Int = personRepository.delete(name = "reader")
}
