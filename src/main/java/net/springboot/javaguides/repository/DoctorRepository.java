package net.springboot.javaguides.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.springboot.javaguides.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	@Query(value = "select from doctors dt where dt.ten like %:keyword%", nativeQuery = true)
	List<Doctor> findByKeyword(@Param("keyword") String keyword);
}