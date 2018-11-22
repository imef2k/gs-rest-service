package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hello.model.WordStatus;
import hello.service.WordStatusService;

@RestController
@RequestMapping("/words")
public class WordController {
	
	private final WordStatusService wordStatusService;
	
	@Autowired
	public WordController(WordStatusService wordStatusService) {
		this.wordStatusService = wordStatusService;
	}
	@GetMapping(value = "/{word:[A-Za-z]+}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<WordStatus> getWordStatus(@PathVariable String word) {
		return new ResponseEntity<>(wordStatusService.evaluateWordStatus(word), HttpStatus.OK);
	}
}
