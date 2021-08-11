package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeekerSchool;

public interface JobSeekerSchoolDao extends JpaRepository<JobSeekerSchool, Integer> {

	List<JobSeekerSchool> getByJobSeekerCv_IdOrderByGraduatedAtDesc(int id);
	
}
