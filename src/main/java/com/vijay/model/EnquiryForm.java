package com.vijay.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
public class EnquiryForm {
    private String studentName;
    private Long phoNo;
    private String classMode;
    private String courseName;
    private String enquiryStatus;
    private Date createdDate;
}
