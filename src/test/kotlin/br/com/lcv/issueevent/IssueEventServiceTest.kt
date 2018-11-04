package br.com.lcv.issueevent

import br.com.lcv.erro.NaoEncontradoException
import br.com.lcv.issue.Issue
import br.com.lcv.issue.IssueRepository
import br.com.lcv.user.User
import br.com.lcv.user.UserRepository
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
class IssueEventServiceTest {

    @MockBean
    private lateinit var issueEventRepository: IssueEventRepository

    @MockBean
    private lateinit var issueRepository: IssueRepository

    @MockBean
    private lateinit var userRepository: UserRepository

    @Test
    fun deveRetornarListaIssueEvents() {
        val issueEvent = criaIssueEvent()
        whenever(issueEventRepository.findAllByIssueNumber(any())).thenReturn(listOf(issueEvent))
        val issueEventService = IssueEventService(issueEventRepository, issueRepository, userRepository)
        val issueEvents = issueEventService.getIssueEvents(2)
        assertThat(issueEvents.size).isEqualTo(1)
    }

    @Test(expected = NaoEncontradoException::class)
    fun deveLancarNaoEncontradoException() {
        whenever(issueEventRepository.findAllByIssueNumber(any())).thenReturn(arrayListOf())
        val issueEventService = IssueEventService(issueEventRepository, issueRepository, userRepository)
        issueEventService.getIssueEvents(5)

    }

    fun criaIssueEvent(): IssueEvent {
        val user = User(login = "Codertocat")

        val issue = Issue(url = "https://api.github.com/repos/Codertocat/Hello-World/issues/2",
                number = 2, title = "Spelling error in the README file", state = "open", user = user,
                createdAt = "2018-05-30T20:18:32Z", body = "teste")

        return IssueEvent(action = "created", issue = issue)
    }

}