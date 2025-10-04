package com.rest.api.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="Employee_Details")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_Id")
    private int empId;

    @Column(name = "emp_Name")
    private String empName;

    @Column(name = "emp_Location")
    private String empLocation;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private JobDetails jobDetails;

    public Employee() {}

    public Employee(int empId, String empName, String empLocation, JobDetails jobDetails) {
        this.empId = empId;
        this.empName = empName;
        this.empLocation = empLocation;
        this.jobDetails = jobDetails;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpLocation() {
        return empLocation;
    }

    public void setEmpLocation(String empLocation) {
        this.empLocation = empLocation;
    }

    public JobDetails getJobDetails() {
        return jobDetails;
    }

    public void setJobDetails(JobDetails jobDetails) {
        this.jobDetails = jobDetails;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empLocation='" + empLocation + '\'' +
                ", jobDetails=" + jobDetails +
                '}';
    }
}
