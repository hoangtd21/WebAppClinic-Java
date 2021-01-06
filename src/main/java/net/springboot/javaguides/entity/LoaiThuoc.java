package net.springboot.javaguides.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loaithuocs")
public class LoaiThuoc {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "tenthuoc")
	private String tenThuoc;
	
	@Column(name = "soluong")
	private float soLuong;
	
	@Column(name = "giatien")
	private float giaTien;

	public LoaiThuoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoaiThuoc(long id, String tenThuoc, float soLuong, float giaTien) {
		super();
		this.tenThuoc = tenThuoc;
		this.soLuong = soLuong;
		this.giaTien = giaTien;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTenThuoc() {
		return tenThuoc;
	}

	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}

	public float getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(float soLuong) {
		this.soLuong = soLuong;
	}

	public float getGiaTien() {
		return giaTien;
	}

	public void setGiaTien(float giaTien) {
		this.giaTien = giaTien;
	}
		
}
