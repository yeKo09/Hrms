package kodlamaio.hrms.business.concretes;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.VerifyEmailService;
import kodlamaio.hrms.core.JobSeekerCheckService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerCheckService jobSeekerCheckService;
	private JobSeekerDao jobSeekerDao;
	private VerifyEmailService verifyEmailService;
	
	@Autowired
	public JobSeekerManager(JobSeekerCheckService jobSeekerCheckService,JobSeekerDao jobSeekerDao,VerifyEmailService verifyEmailService) {
		this.jobSeekerCheckService = jobSeekerCheckService;
		this.jobSeekerDao = jobSeekerDao;
		this.verifyEmailService = verifyEmailService;
	}
	
	@Override
	public Result signUp(JobSeeker jobSeeker) throws NumberFormatException, RemoteException {
		if(!this.jobSeekerCheckService.checkIfRealJobSeeker(jobSeeker)) {
			return new ErrorResult("Kimlik doğrulamanız doğru değil.");
		}
		if(!this.jobSeekerDao.findByNationalityId(jobSeeker.getNationalityId()).isEmpty()) {
			return new ErrorResult("Kullanmak istediğiniz TC kimlik numarası başka bir kişi tarafından kullanılmaktadır");
		}else if(!this.jobSeekerDao.findByEmailAddress(jobSeeker.getEmailAddress()).isEmpty()) {
			return new ErrorResult("Kullanmak istediğiniz e-mail adresi başka bir kişi tarafından kullanılmaktadır.");
		}
		if (this.verifyEmailService.verifyEmailAddress(jobSeeker.getEmailAddress())) {
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("İş arayan olarak sisteme başarıyla kaydedildi.");
		}
		return new ErrorResult();
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "İş arayanlar listesi başarıyla döndürüldü.");
	}

}
