package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerExperienceService;
import kodlamaio.hrms.entities.concretes.JobSeekerExperience;

@RestController
@RequestMapping("/api/jobseekerexperience")
public class JobSeekerExperienceController {
	
	private JobSeekerExperienceService jobSeekerExperienceService;

	@Autowired
	public JobSeekerExperienceController(JobSeekerExperienceService jobSeekerExperienceService) {
		this.jobSeekerExperienceService = jobSeekerExperienceService;
	}
	
	@PostMapping("/addjobexperience")
	public ResponseEntity<?> add(@Valid @RequestBody JobSeekerExperience jobSeekerExperience){
		return ResponseEntity.ok(this.jobSeekerExperienceService.add(jobSeekerExperience));
	}
	
	
	
}
