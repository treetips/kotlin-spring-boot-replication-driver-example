package com.example.demo.service

import com.example.demo.model.HostModel
import com.example.demo.repository.HostRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * Host service
 * @author tree
 */
@Service
class HostService(
  private val hostRepository: HostRepository
) {
  /**
   * get host of writer
   * @return HostModel
   */
  fun findWriterHost(): HostModel = hostRepository.findOne()

  /**
   * get host of reader
   * @return HostModel
   */
  @Transactional(readOnly = true)
  fun findReaderHost(): HostModel = hostRepository.findOne()
}
