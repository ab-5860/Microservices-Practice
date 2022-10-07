package com.dailycodebuffer.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.dailycodebuffer.user.VO.Department;
import com.dailycodebuffer.user.VO.ResponseTemplateVO;
import com.dailycodebuffer.user.entity.Users;
import com.dailycodebuffer.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Users saveUser(Users user) {
        log.info("Inside saveUser method of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {

        log.info("Inside getUserWithDepartment method of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Users user = userRepository.findByUserId(userId);
        
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" +user.getDepartmentId(), Department.class);
        
        vo.setUser(user);
        vo.setDepartment(department);
    
        return vo;
    }



}
