package com.vijay.model;

import lombok.Data;

import java.util.List;


@Data
public class DashboardResponse {

    private Integer userId;
    private String email;
    private String name;
    private Integer enqCnt;
    private Integer enrolledCnt;
    private Integer lostCnt;

}
