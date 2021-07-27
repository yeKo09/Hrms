package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.HrmsStaffValidationService;
import kodlamaio.hrms.business.abstracts.VerifyEmailService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private VerifyEmailService verifyEmailService;
	private HrmsStaffValidationService hrmsStaffValidationService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao,VerifyEmailService verifyEmailService, HrmsStaffValidationService hrmsStaffValidationService) {
		this.employerDao = employerDao;
		this.verifyEmailService = verifyEmailService;
		this.hrmsStaffValidationService = hrmsStaffValidationService;
	}


	@Override
	public Result signUp(Employer employer) {
		
		if(!this.employerDao.findByEmailAddress(employer.getEmailAddress()).isEmpty()) {
			return new ErrorResult("Kullanmaya çalıştığınız email adresi başka bir kişi tarafından kullanılmaktadır.");
		}
		
		if(this.verifyEmailService.verifyEmailAddress(employer.getEmailAddress()) && 
				this.hrmsStaffValidationService.validate()) {
			this.employerDao.save(employer);
			return new SuccessResult("Başarıyla bir employer kaydedildi.");
		}
		return new ErrorResult();
		
	}


	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Başarıyla employer listesi döndürüldü.");
	}

}
