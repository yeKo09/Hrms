package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seeker_schools")
public class JobSeekerSchool {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "school_name")
	@NotBlank
	private String schoolName;
	
	@Column(name = "department_name")
	@NotBlank
	private String departmentName;
	
	@Column(name = "started_at")
	@NotNull
	private String schoolStartedAt;
	
	@Column(name = "graduated_at")
	private String graduatedAt;
	
	@ManyToOne()
	@JoinColumn(name = "cv_id", referencedColumnName = "id")
	private JobSeekerCv jobSeekerCv;
	
	

}
