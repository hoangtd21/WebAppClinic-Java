package net.springboot.javaguides.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import net.springboot.javaguides.entity.BenhNhan;

@Repository
public interface BenhNhanRepository extends JpaRepository<BenhNhan, Long>{
	@Query(value = "select * from benhnhans bn where bn.ten like %:keyword%", nativeQuery = true)
	List<BenhNhan> findByKeyword(@Param("keyword") String keyword);
}