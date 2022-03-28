package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Employee;


@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
	// get emp by name
	Employee findByEmpName(String name);
	Employee findBySalary(double salary);
	
	@Query(value="select employee.* from employee join employee_skill on employee.emp_id=employee_skill.emp_id join skill on employee_skill.skill_id=skill.id where skill.id=:id", nativeQuery=true)
	List<Employee> getAllEmpBasedOnSkillId(@Param("id") int skillId);
}
