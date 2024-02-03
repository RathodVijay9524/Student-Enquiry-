package com.vijay.repo;

import com.vijay.entities.CourseEntity;
import com.vijay.entities.EnqStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnqStatusRepo extends JpaRepository<EnqStatusEntity, Integer> {


}
