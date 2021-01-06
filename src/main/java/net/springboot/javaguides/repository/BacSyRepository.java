package net.springboot.javaguides.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import net.springboot.javaguides.entity.BacSy;

@Repository
public interface BacSyRepository extends JpaRepository<BacSy, Long> {
	//List<BacSy> findByCmt(String cmt);
	@Query(value = "select * from bacsys bs where bs.ten like %:keyword%", nativeQuery = true)
	List<BacSy> findByKeyword(@Param("keyword") String keyword);
}
