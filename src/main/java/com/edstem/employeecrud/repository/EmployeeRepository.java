package com.edstem.employeecrud.repository;

import com.edstem.employeecrud.contract.EmployeeRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface EmployeeRepository extends JpaRepository<EmployeeRequest, Integer> {

    Optional<EmployeeRequest> findById(int id);
}