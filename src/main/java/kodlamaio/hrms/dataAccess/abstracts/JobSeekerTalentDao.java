package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeekerTalent;

public interface JobSeekerTalentDao extends JpaRepository<JobSeekerTalent, Integer>{

	List<JobSeekerTalent> getByJobSeekerCv_Id(int id);
	
}
