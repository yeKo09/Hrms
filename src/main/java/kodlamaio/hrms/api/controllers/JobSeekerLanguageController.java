package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerLanguageService;
import kodlamaio.hrms.entities.concretes.JobSeekerLanguage;

@RestController
@RequestMapping("/api/jobseekerlanguage")
public class JobSeekerLanguageController {

	private JobSeekerLanguageService jobSeekerLanguageService;

	@Autowired
	public JobSeekerLanguageController(JobSeekerLanguageService jobSeekerLanguageService) {
		this.jobSeekerLanguageService = jobSeekerLanguageService;
	}
	
	@PostMapping("/addlanguage")
	public ResponseEntity<?> add(@Valid @RequestBody JobSeekerLanguage jobSeekerLanguage){
		return ResponseEntity.ok(this.jobSeekerLanguageService.add(jobSeekerLanguage));
	}
	
}
