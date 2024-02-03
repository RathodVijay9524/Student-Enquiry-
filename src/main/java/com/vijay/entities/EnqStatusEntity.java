package com.vijay.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="enq_status_tbl")
public class EnqStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer statusId;
    private String statusName;

}
