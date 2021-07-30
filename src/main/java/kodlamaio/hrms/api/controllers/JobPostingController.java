package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;

@RestController
@RequestMapping("/api/jobposting")
public class JobPostingController {

	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingController(JobPostingService jobPostingService) {
		this.jobPostingService = jobPostingService;
	}
	
	@PostMapping("/addJobPosting")
	public Result addJobPosting(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.addJobPosting(jobPosting);
	}
	
	@GetMapping("/getAllActiveJobPostings")
	public DataResult<List<JobPosting>> getAllActiveJobPostings(){
		return this.jobPostingService.getAllActiveJobPostings();
	}
	
	@GetMapping("/getByCompanyNameAndIsActive")
	public DataResult<List<JobPosting>> getByEmployer_CompanyNameAndIsActive(@RequestParam String companyName){
		return this.jobPostingService.getByEmployer_CompanyNameAndIsActive(companyName);
	}
	
	@GetMapping("/getAllSortedByDateASC")
	public DataResult<List<JobPosting>> getAllSortedByDateASC(){
		return this.jobPostingService.getAllSortedByDateASC();
	}
	
	@GetMapping("/getAllSortedByDateDESC")
	public DataResult<List<JobPosting>> getAllSortedByDateDESC(){
		return this.jobPostingService.getAllSortedByDateDESC();
	}
	
	@PutMapping("/deactivateJobPosting")
	public Result deactiveJobPosting(@RequestParam int id) {
		return this.jobPostingService.deactivateJobPosting(id);
	}
}
