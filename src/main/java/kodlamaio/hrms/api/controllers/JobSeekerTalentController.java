package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerTalentService;
import kodlamaio.hrms.entities.concretes.JobSeekerTalent;

@RestController
@RequestMapping("/api/jobseekertalent")
public class JobSeekerTalentController {

	private JobSeekerTalentService jobSeekerTalentService;

	@Autowired
	public JobSeekerTalentController(JobSeekerTalentService jobSeekerTalentService) {
		this.jobSeekerTalentService = jobSeekerTalentService;
	}
	
	@PostMapping("/addtalent")
	public ResponseEntity<?> add(@Valid @RequestBody JobSeekerTalent jobSeekerTalent){
		return ResponseEntity.ok(this.jobSeekerTalentService.add(jobSeekerTalent));
	}
	
	
}
