package kodlamaio.hrms.business.concretes;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingStaffValidationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingStaffValidationDao;
import kodlamaio.hrms.entities.concretes.JobPostingStaffValidation;

@Service
public class JobPostingStaffValidationManager implements JobPostingStaffValidationService{

	private JobPostingStaffValidationDao jobPostingStaffValidationDao;
	private JobPostingDao jobPostingDao;
	
	@Autowired
	public JobPostingStaffValidationManager(JobPostingStaffValidationDao jobPostingStaffValidationDao, JobPostingDao jobPostingDao) {
		this.jobPostingStaffValidationDao = jobPostingStaffValidationDao;
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public DataResult<List<JobPostingStaffValidation>> getAll() {
		return new SuccessDataResult<List<JobPostingStaffValidation>>(this.jobPostingStaffValidationDao.getByIsVerified("no"),
				"Bütün validasyon bekleyen iş ilanları listelendi.");
	}

	@Override
	public Result add(JobPostingStaffValidation jobPostingStaffValidation) {
		return new SuccessResult("Bir validasyon eklendi.");
	}

	@Override
	@Transactional
	public Result verifyJobPosting(int id) {
		long millis=System.currentTimeMillis(); 
		Date currentDate = new Date(millis);
		this.jobPostingStaffValidationDao.verifyJobPosting(id,currentDate);
		return new SuccessResult("Başarıyla güncellendi.");
	}

	@Override
	@Transactional
	public Result deleteJobPosting(int jobPostingId) {
		this.jobPostingDao.deleteById(jobPostingId);
		return new SuccessResult(jobPostingId + " numaralı id'ye sahip iş ilanı silinmiştir.");
	}

}
