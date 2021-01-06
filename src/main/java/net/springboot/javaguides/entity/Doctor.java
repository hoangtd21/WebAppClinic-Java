package net.springboot.javaguides.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "cmt")
	private String cmt;
	
	@Column(name = "ten")
	private String ten;
	
	@Column(name = "ngaySinh")
	private String ngaySinh;
	
	@Column(name = "diaChi")
	private String diaChi;
	
	@Column(name = "trinhDo")
	private String trinhDo;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(String cmt, String ten, String ngaySinh, String diaChi, String trinhDo) {
		super();
		this.cmt = cmt;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.trinhDo = trinhDo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCmt() {
		return cmt;
	}

	public void setCmt(String cmt) {
		this.cmt = cmt;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}
	
	
	
}

