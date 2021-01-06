package net.springboot.javaguides.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "benhnhans")
public class BenhNhan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "cmt")
	private String cmt;
	
	@Column(name = "ten")
	private String ten;
		
	@Column(name = "ngaysinh")
	private String ngaySinh;
	
	@Column(name = "diachi")
	private String diaChi;
	
	@Column(name = "sdt")
	private long sdt;

	public BenhNhan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BenhNhan(String cmt, String ten, String ngaySinh, String diaChi) {
		super();
		this.cmt = cmt;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
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

	public long getSdt() {
		return sdt;
	}

	public void setSdt(long sdt) {
		this.sdt = sdt;
	}
	
	
	
	
}
