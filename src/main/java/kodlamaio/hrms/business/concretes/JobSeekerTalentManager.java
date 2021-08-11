package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerTalentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerTalentDao;
import kodlamaio.hrms.entities.concretes.JobSeekerTalent;

@Service
public class JobSeekerTalentManager implements JobSeekerTalentService{

	private JobSeekerTalentDao jobSeekerTalentDao;
	
	@Autowired
	public JobSeekerTalentManager(JobSeekerTalentDao jobSeekerTalentDao) {
		this.jobSeekerTalentDao = jobSeekerTalentDao;
	}

	@Override
	public Result add(JobSeekerTalent jobSeekerTalent) {
		this.jobSeekerTalentDao.save(jobSeekerTalent);
		return new SuccessResult("Yetenek eklendi.");
	}

	@Override
	public DataResult<List<JobSeekerTalent>> getAll() {
		return new SuccessDataResult<List<JobSeekerTalent>>(this.jobSeekerTalentDao.findAll(), "Bütün talentlar listelendi.");
	}

	@Override
	public DataResult<List<JobSeekerTalent>> getTalentsByCvId(int id) {
		return new SuccessDataResult<List<JobSeekerTalent>>(this.jobSeekerTalentDao.getByJobSeekerCv_Id(id) ,
				 id + " numaralı cv'ye ait bütün talentlar listelendi.");
	}

}
