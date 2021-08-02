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
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingWithEmployerAndJobTitleDto;

@Service
public class JobPostingManager implements JobPostingService{

	private JobPostingDao jobPostingDao;
	
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public Result addJobPosting(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("İş ilanı başarıyla eklendi");
	}

	@Override
	public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getAllActiveJobPostings() {
		return new SuccessDataResult<List<JobPostingWithEmployerAndJobTitleDto>>(this.jobPostingDao.getAllActiveJobPostings(),
				"Sistemdeki tüm aktif iş ilanları başarıyla döndürüldü");
	}
	
	@Override
	public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getByEmployer_CompanyNameAndIsActive(String companyName) {
		return new SuccessDataResult<List<JobPostingWithEmployerAndJobTitleDto>>(this.jobPostingDao.getByEmployer_CompanyNameAndIsActive(companyName,"yes"),
				companyName + " adlı şirkete ait tüm aktif iş ilanları başarıyla listelenmiştir.");
	}

	@Override
	public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getAllSortedByDateASC() {
		Sort sort = Sort.by(Sort.Direction.ASC, "deadlineDate");
		return new SuccessDataResult<List<JobPostingWithEmployerAndJobTitleDto>>(this.jobPostingDao.getByIsActive("yes", sort));
	}

	@Override
	public DataResult<List<JobPostingWithEmployerAndJobTitleDto>> getAllSortedByDateDESC() {
		Sort sort = Sort.by(Sort.Direction.DESC, "deadlineDate");
		return new SuccessDataResult<List<JobPostingWithEmployerAndJobTitleDto>>(this.jobPostingDao.getByIsActive("yes", sort));
	}

	@Override
	@Transactional
	public Result deactivateJobPosting(int id) {
		this.jobPostingDao.deactiveJobPosting(id);
		return new SuccessResult("Başarıyla güncellendi.");
	}

}
