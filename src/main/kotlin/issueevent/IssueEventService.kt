package br.com.lcv.issueevent

import br.com.lcv.erro.NaoEncontradoException
import br.com.lcv.issue.IssueRepository
import br.com.lcv.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class IssueEventService(@Autowired val issueEventRepository: IssueEventRepository,
						@Autowired val issueRepository: IssueRepository,
						@Autowired val userRepository: UserRepository) {
	
	@Transactional
	fun salvaIssueEvent(issueEvent: IssueEvent) : IssueEvent {
		val userBanco = userRepository.findByLogin(issueEvent.issue.user.login)
		if (userBanco != null) {
			issueEvent.issue.user = userBanco
		} else {
			userRepository.save(issueEvent.issue.user)
		}
		issueRepository.save(issueEvent.issue)
		return issueEventRepository.save(issueEvent)
	}

	fun getIssueEvents(number: Int) : List<IssueEvent> {
		val issues = issueEventRepository.findAllByIssueNumber(number)
		if (!issues.isEmpty()) {
			return issues
		}
		throw NaoEncontradoException("Issue events não encontrados")
	}
	
}