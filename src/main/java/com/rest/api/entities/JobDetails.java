package com.rest.api.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="Job_Details")
public class JobDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "job_Id")
    private int jobId;

    @Column(name = "job_Title")
    private String jobTitle;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "experience")
    private int experience;

    @OneToOne(mappedBy = "jobDetails")
    @JsonBackReference
    private Employee employee;

    public JobDetails() {}

    public JobDetails(int jobId, String jobTitle, BigDecimal salary, int experience) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.salary = salary;
        this.experience = experience;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "JobDetails{" +
                "jobId=" + jobId +
                ", jobTitle='" + jobTitle + '\'' +
                ", salary=" + salary +
                ", experience=" + experience +
                '}';
    }
}
