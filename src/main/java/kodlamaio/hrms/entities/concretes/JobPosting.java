package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_postings")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class JobPosting {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank
	@Column(name = "job_description")
	private String jobDescription;
	
	@Column(name = "minimum_wage")
	private int minimumWage;

	@Column(name = "maximum_wage")
	private int maximumWage;
	
	@Min(value = 1)
	@Max(value = 5)
	@NotNull
	@Column(name = "number_of_open_positions")
	private int numberOfOpenPositions;
	
	@FutureOrPresent()
	@NotNull
	@Column(name = "deadline_date")
	private LocalDate deadlineDate;
	
	@NotBlank
	@Column(name = "is_active")
	private String isActive;
	
	@FutureOrPresent
	@NotNull
	@Column(name = "created_at")
	private LocalDate createdAt;
	
	@ManyToOne()
	@JoinColumn(name = "job_title_id")
	private JobPosition jobPosition;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private Employer employer;
	
	@ManyToOne()
	@JoinColumn(name = "work_place_id")
	private WorkPlace workPlace;
	
	@ManyToOne()
	@JoinColumn(name = "work_time_id")
	private WorkTime workTime;
	
	@JsonIgnore
	@OneToOne(mappedBy = "jobPosting")
	private JobPostingStaffValidation jobPostingStaffValidation;
}
