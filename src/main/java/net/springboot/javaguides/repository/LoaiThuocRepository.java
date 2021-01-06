package net.springboot.javaguides.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.springboot.javaguides.entity.LoaiThuoc;


@Repository
public interface LoaiThuocRepository extends JpaRepository<LoaiThuoc, Long>{
	List<LoaiThuoc> findByTenThuoc(String tenThuoc);
}
