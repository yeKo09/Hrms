package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerSchoolDao;
import kodlamaio.hrms.entities.concretes.JobSeekerSchool;

@Service
public class JobSeekerSchoolManager implements JobSeekerSchoolService{
	
	private JobSeekerSchoolDao jobSeekerSchoolDao;
	
	@Autowired
	public JobSeekerSchoolManager(JobSeekerSchoolDao jobSeekerSchoolDao) {
		this.jobSeekerSchoolDao = jobSeekerSchoolDao;
	}

	@Override
	public Result add(JobSeekerSchool jobSeekerSchool) {
		this.jobSeekerSchoolDao.save(jobSeekerSchool);
		return new SuccessResult("Okul eklendi.");
	}

	@Override
	public DataResult<List<JobSeekerSchool>> getAll() {
		return new SuccessDataResult<List<JobSeekerSchool>>(this.jobSeekerSchoolDao.findAll(), "Bütün cv'lere ait okullar listelendi.");
	}

	@Override
	public DataResult<List<JobSeekerSchool>> getSchoolsByCvIdDesc(int id) {
		List<JobSeekerSchool> newList = this.jobSeekerSchoolDao.getByJobSeekerCv_IdOrderByGraduatedAtDesc(id);
		for (JobSeekerSchool jobSeekerSchool : newList) {
			if(jobSeekerSchool.getGraduatedAt() == null) {
				jobSeekerSchool.setGraduatedAt("Devam ediyor");
			}
		}
		return new SuccessDataResult<List<JobSeekerSchool>>(newList, id + " numaralı cv'ye ait okul bilgileri listelendi");
	}
	
}
