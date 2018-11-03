package br.com.lcv.issueevent

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/issues", "application/json")
class IssueEventController(@Autowired val issueEventService: IssueEventService) {
	
	@PostMapping("/events")
	fun salvaIssueEvent(@RequestBody issueEvent: IssueEvent) : ResponseEntity<IssueEvent> {
		return ResponseEntity.status(HttpStatus.CREATED).body(issueEventService.salvaIssueEvent(issueEvent));
	}

	@GetMapping("/{number}/events")
	fun getIssueEvents(@PathVariable number: Int) : ResponseEntity<List<IssueEvent>> {
		return ResponseEntity.status(HttpStatus.OK).body(issueEventService.getIssueEvents(number));
	}

}