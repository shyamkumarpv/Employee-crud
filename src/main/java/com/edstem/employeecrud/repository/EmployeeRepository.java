package com.edstem.employeecrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edstem.employeecrud.model.Employee;
import org.springframework.stereotype.Repository;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee ,Integer > {

    Optional<Employee> findById(int id);
}
