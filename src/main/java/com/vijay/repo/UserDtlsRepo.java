package com.vijay.repo;

import com.vijay.entities.UserDtlsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDtlsRepo extends JpaRepository<UserDtlsEntity, Integer> {

   public UserDtlsEntity findByEmail(String email);
   public UserDtlsEntity findByEmailAndPwd(String email,String pwd);
}
