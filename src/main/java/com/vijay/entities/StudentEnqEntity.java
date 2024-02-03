package com.vijay.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="enquries_tbl")
public class StudentEnqEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer enquiryId;
    private String studentName;

    private Long phoNo;
    private String classMode;
    private String CourseName;
    private String enquiryStatus;
    @CreationTimestamp
    private Date createdDate;
    @UpdateTimestamp
    private Date updatedDate;
    @ManyToOne
    @JoinColumn(name="user_id")
    private UserDtlsEntity user;

}
