package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkTimeService;
import kodlamaio.hrms.entities.concretes.WorkTime;

@RestController
@RequestMapping("/api/worktime")
@CrossOrigin
public class WorkTimeController {

	private WorkTimeService	workTimeService;

	@Autowired
	public WorkTimeController(WorkTimeService workTimeService) {
		this.workTimeService = workTimeService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.workTimeService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody @Valid WorkTime workTime){
		return ResponseEntity.ok(this.workTimeService.add(workTime));
	}
	
}
