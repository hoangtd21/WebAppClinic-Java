package net.springboot.javaguides.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.springboot.javaguides.entity.LanKham;

@Repository
public interface LanKhamRepository extends JpaRepository<LanKham, Long>{
	List<LanKham> findByTenBenh(String tenBenh);
}
