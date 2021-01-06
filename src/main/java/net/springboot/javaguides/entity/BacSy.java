package net.springboot.javaguides.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bacsys")
public class BacSy {

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
	
	@Column(name = "trinhdo")
	private String trinhDo;
	
	@Column(name = "bacnghe")
	private String bacNghe;
	
	@Column(name = "thamnien")
	private String thamNien;
	
	@Column(name = "chuyenmon")
	private String chuyenMon;

	public BacSy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BacSy(String cmt, String ten, String ngaySinh, String diaChi, String trinhDo, String bacNghe,
			String thamNien, String chuyenMon) {
		super();
		this.cmt = cmt;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.trinhDo = trinhDo;
		this.bacNghe = bacNghe;
		this.thamNien = thamNien;
		this.chuyenMon = chuyenMon;
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

	public String getBacNghe() {
		return bacNghe;
	}

	public void setBacNghe(String bacNghe) {
		this.bacNghe = bacNghe;
	}

	public String getThamNien() {
		return thamNien;
	}

	public void setThamNien(String thamNien) {
		this.thamNien = thamNien;
	}

	public String getChuyenMon() {
		return chuyenMon;
	}

	public void setChuyenMon(String chuyenMon) {
		this.chuyenMon = chuyenMon;
	}
	
	
	
}
