package com.example.demo.repository

import com.example.demo.model.PersonModel
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

/**
 * Person repository
 * @author tree
 */
@Suppress("SqlDialectInspection", "SqlNoDataSourceInspection")
@Repository
class PersonRepository(
  private val jdbcTemplate: JdbcTemplate
) {
  /**
   * get all persons
   * @return persons
   */
  fun findAll(): List<PersonModel> = jdbcTemplate.query("select id, name from person") { rs, _ ->
    PersonModel(id = rs.getInt("id"), name = rs.getString("name"))
  }

  /**
   * add person
   * @return insert number
   */
  fun insert(name: String): Int = jdbcTemplate.update("insert into person values (?, ?)", null, name)

  /**
   * update person name
   * @param name person name
   * @return update number
   */
  fun update(name: String): Int = jdbcTemplate.update("update person set name = ? limit 1", name)

  /**
   * delete person
   * @param name person name
   * @return delete number
   */
  fun delete(name: String): Int = jdbcTemplate.update("delete from person limit 1")
}
