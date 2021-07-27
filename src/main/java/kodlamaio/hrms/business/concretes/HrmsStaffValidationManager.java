package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.HrmsStaffValidationService;

@Service
public class HrmsStaffValidationManager implements HrmsStaffValidationService{

	@Override
	public boolean validate() {
		return true;
	}
	
}
