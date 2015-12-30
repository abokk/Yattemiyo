package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the JOB_HISTORY database table.
 *
 */
@Entity
@Table(name="JOB_HISTORY")
@NamedQuery(name="JobHistory.findAll", query="SELECT j FROM JobHistory j")
public class JobHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private JobHistory.JobHistoryPK id;

	@Column(name="DEPARTMENT_ID")
	private java.math.BigDecimal departmentId;

	@Temporal(TemporalType.DATE)
	@Column(name="END_DATE")
	private Date endDate;

	@Column(name="JOB_ID")
	private String jobId;

	public JobHistory() {
	}

	public JobHistoryPK getId() {
		return this.id;
	}

	public void setId(JobHistoryPK id) {
		this.id = id;
	}

	public java.math.BigDecimal getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(java.math.BigDecimal departmentId) {
		this.departmentId = departmentId;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	//

	@Embeddable
	public static class JobHistoryPK implements Serializable {
		//default serial version id, required for serializable classes.
		private static final long serialVersionUID = 1L;

		@Column(name="EMPLOYEE_ID", insertable=false, updatable=false)
		private long employeeId;

		@Temporal(TemporalType.DATE)
		@Column(name="START_DATE")
		private java.util.Date startDate;

		public JobHistoryPK() {
		}
		public long getEmployeeId() {
			return this.employeeId;
		}
		public void setEmployeeId(long employeeId) {
			this.employeeId = employeeId;
		}
		public java.util.Date getStartDate() {
			return this.startDate;
		}
		public void setStartDate(java.util.Date startDate) {
			this.startDate = startDate;
		}

		public boolean equals(Object other) {
			if (this == other) {
				return true;
			}
			if (!(other instanceof JobHistoryPK)) {
				return false;
			}
			JobHistoryPK castOther = (JobHistoryPK)other;
			return
				(this.employeeId == castOther.employeeId)
				&& this.startDate.equals(castOther.startDate);
		}

		public int hashCode() {
			final int prime = 31;
			int hash = 17;
			hash = hash * prime + ((int) (this.employeeId ^ (this.employeeId >>> 32)));
			hash = hash * prime + this.startDate.hashCode();

			return hash;
		}
	}
}