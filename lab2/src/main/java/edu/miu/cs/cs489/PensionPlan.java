package edu.miu.cs.cs489;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PensionPlan {
    private String planReferenceNumber;
    private LocalDate enrollmentDate; // null if not enrolled
    private Double monthlyContribution;

    public PensionPlan() {}

    public PensionPlan(String planReferenceNumber, LocalDate enrollmentDate, Double monthlyContribution) {
        this.planReferenceNumber = planReferenceNumber;
        this.enrollmentDate = enrollmentDate;
        this.monthlyContribution = monthlyContribution;
    }

    public String getPlanReferenceNumber() { return planReferenceNumber; }
    public void setPlanReferenceNumber(String planReferenceNumber) { this.planReferenceNumber = planReferenceNumber; }

    public LocalDate getEnrollmentDate() { return enrollmentDate; }
    public void setEnrollmentDate(LocalDate enrollmentDate) { this.enrollmentDate = enrollmentDate; }

    public Double getMonthlyContribution() { return monthlyContribution; }
    public void setMonthlyContribution(Double monthlyContribution) { this.monthlyContribution = monthlyContribution; }
}
