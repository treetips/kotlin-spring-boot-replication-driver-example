package com.example.demo.repository

import com.example.demo.model.HostModel
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

/**
 * Host repository
 * @author tree
 */
@Suppress("SqlDialectInspection", "SqlNoDataSourceInspection")
@Repository
class HostRepository(
  private val jdbcTemplate: JdbcTemplate
) {
  /**
   * get host
   * @return HostModel
   */
  fun findOne(): HostModel = jdbcTemplate.query("select name from host") { rs, _ ->
    HostModel(name = rs.getString("name"))
  }.first()
}
