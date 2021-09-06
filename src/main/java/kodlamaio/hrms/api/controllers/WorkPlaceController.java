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

import kodlamaio.hrms.business.abstracts.WorkPlaceService;
import kodlamaio.hrms.entities.concretes.WorkPlace;

@RestController
@RequestMapping("/api/workplace")
@CrossOrigin
public class WorkPlaceController {

	private WorkPlaceService workPlaceService;

	@Autowired
	public WorkPlaceController(WorkPlaceService workPlaceService) {
		this.workPlaceService = workPlaceService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(this.workPlaceService.getAll());
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody @Valid WorkPlace workPlace){
		return ResponseEntity.ok(this.workPlaceService.add(workPlace));
	}
	
}
