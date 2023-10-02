package com.BilgeAdam.Microservices.Payroll.Repositories;

import com.BilgeAdam.Microservices.Payroll.Entities.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Long> {

}
