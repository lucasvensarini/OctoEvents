package br.com.lcv.issue

import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.JpaRepository

@Repository
interface IssueRepository : JpaRepository<Issue, Long>