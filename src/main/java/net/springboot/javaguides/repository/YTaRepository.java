package net.springboot.javaguides.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.springboot.javaguides.entity.YTa;

@Repository
public interface YTaRepository extends JpaRepository<YTa, Long>{
	@Query(value = "select * from ytas yt where yt.ten like %:keyword%", nativeQuery = true)
	List<YTa> findByKeyword(@Param("keyword") String keyword);
}
