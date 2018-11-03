package br.com.lcv.issueevent

import br.com.lcv.issue.Issue
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
data class IssueEvent(@Id @GeneratedValue @JsonIgnore val id: Long? = null,
					  val action: String,
					  @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "issue_id")
					  @JsonIgnoreProperties("hibernateLazyInitializer", "handler") val issue: Issue)