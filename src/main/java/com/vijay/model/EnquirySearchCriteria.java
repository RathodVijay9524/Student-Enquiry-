package com.vijay.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class EnquirySearchCriteria {
    private String classMode;
    private String courseName;
    private String enquiryStatus;
}
