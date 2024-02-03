package com.vijay.service;

import com.vijay.entities.StudentEnqEntity;
import com.vijay.model.DashboardResponse;
import com.vijay.model.EnquiryForm;
import com.vijay.model.EnquirySearchCriteria;

import java.util.List;

public interface EnquiryService {


    public List<String> getCoursesName();
    public List<String> getEnqStatus();
    public DashboardResponse getDashBoardDtata(Integer userId);
    public boolean addEnquiry(EnquiryForm form);
    public List<StudentEnqEntity> getFilteredEnq(EnquirySearchCriteria criteria);
    public List<StudentEnqEntity> getEnquiries();


}
