package com.vijay.runners;

import com.vijay.entities.CourseEntity;
import com.vijay.entities.EnqStatusEntity;
import com.vijay.repo.CourseRepo;
import com.vijay.repo.EnqStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    private EnqStatusRepo enqStatusRepo;


    @Autowired
    private CourseRepo courseRepo;
    @Override
    public void run(ApplicationArguments args) throws Exception {
       courseRepo.deleteAll();
        CourseEntity c1=new CourseEntity();
        c1.setCourseName("Java");
        CourseEntity c2=new CourseEntity();
        c2.setCourseName("PHP");
        CourseEntity c3=new CourseEntity();
        c3.setCourseName(".Net");
        courseRepo.saveAll(Arrays.asList(c1, c2, c3));
        enqStatusRepo.deleteAll();

        EnqStatusEntity s1=new EnqStatusEntity();
        s1.setStatusName("New");
        EnqStatusEntity s2=new EnqStatusEntity();
        s2.setStatusName("Lost");
        EnqStatusEntity s3=new EnqStatusEntity();
        s3.setStatusName("Enrolled");
        enqStatusRepo.saveAll(Arrays.asList(s1,s2,s3));
    }
}
