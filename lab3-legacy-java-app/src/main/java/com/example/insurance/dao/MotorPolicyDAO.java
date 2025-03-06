package com.example.insurance.dao;

import com.example.insurance.model.MotorPolicy;
import java.util.List;

public interface MotorPolicyDAO {
    void save(MotorPolicy policy);
    MotorPolicy findById(Long id);
    List<MotorPolicy> findAll();
    void update(MotorPolicy policy);
    void delete(Long id);
    MotorPolicy findByPolicyNumber(String policyNumber);
}