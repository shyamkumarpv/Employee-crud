package com.edstem.employeecrud.repository;

import com.edstem.employeecrud.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findById(int id);
}