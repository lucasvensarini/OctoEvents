package br.com.lcv.issueevent

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IssueEventRepository : JpaRepository<IssueEvent, Long> {

	fun findAllByIssueNumber(number: Int) : List<IssueEvent>

}