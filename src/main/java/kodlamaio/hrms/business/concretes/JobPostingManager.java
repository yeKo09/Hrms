package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingStaffValidationDao;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.concretes.JobPostingStaffValidation;
import kodlamaio.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto;

@Service
public class JobPostingManager implements JobPostingService{

	private JobPostingDao jobPostingDao;
	private JobPostingStaffValidationDao jobPostingStaffValidationDao;
	
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao,JobPostingStaffValidationDao jobPostingStaffValidationDao) {
		this.jobPostingDao = jobPostingDao;
		this.jobPostingStaffValidationDao = jobPostingStaffValidationDao;
	}

	@Override
	public Result addJobPosting(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		this.jobPostingStaffValidationDao.save(new JobPostingStaffValidation((int) 0L,
				"no",null,jobPosting));
		return new SuccessResult("İş ilanı başarıyla eklendi");
	}

	@Override
	public DataResult<List<JobPosting>> getAllActiveJobPostings() {
		return new SuccessDataResult<List<JobPosting>>
		(this.jobPostingDao.getByIsActiveAndJobPostingStaffValidation_IsVerified("yes","yes"),
				"Sistemdeki tüm aktif iş ilanları başarıyla döndürüldü");
	}
	
	@Override
	public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getByCompanyNameDto(String companyName) {
		return new SuccessDataResult<List<JobPostingWithEmployerAndJobTitleDto>>
		(this.jobPostingDao.getByCompanyNameDto(companyName,"yes"),
				companyName + " adlı şirkete ait tüm aktif iş ilanları başarıyla listelenmiştir.");
	}

	@Override
	public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getAllSortedByDateDtoASC() {
		Sort sort = Sort.by(Sort.Direction.ASC, "deadlineDate");
		return new SuccessDataResult<List<JobPostingWithEmployerAndJobTitleDto>>
		(this.jobPostingDao.getAllSortedByDateDto("yes", sort));
	}

	@Override
	public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getAllSortedByDateDtoDESC() {
		Sort sort = Sort.by(Sort.Direction.DESC, "deadlineDate");
		return new SuccessDataResult<List<JobPostingWithEmployerAndJobTitleDto>>
		(this.jobPostingDao.getAllSortedByDateDto("yes", sort));
	}

	@Override
	@Transactional
	public Result deactivateJobPosting(int id) {
		this.jobPostingDao.deactiveJobPosting(id);
		return new SuccessResult("Başarıyla güncellendi.");
	}

	@Override
	public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getAllActiveJobPostingsWithDto() {
		return new SuccessDataResult<List<JobPostingWithEmployerAndJobTitleDto>>
		(this.jobPostingDao.getAllActiveJobPostingsDto(), "Bütün verify olmuş ve aktif olan iş ilanları dto şeklinde listelendi.");
	}

	@Override
	public DataResult<JobPosting> getById(int id) {
		return new SuccessDataResult<JobPosting>(this.jobPostingDao.getByIdAndIsActive(id,"yes"),
				id + " numaralı id'ye sahip iş ilanı getirilmiştir.");
	}

}
