package net.springboot.javaguides.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ytas")
public class YTa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "cmt")
	private String cmt;
	
	@Column(name = "ten")
	private String ten;
	
	@Column(name = "trinhdo")
	private String trinhDo;
	
	@Column(name = "thamnien")
	private String thamNien;
	
	@Column(name = "ngaysinh")
	private String ngaySinh;
	
	@Column(name = "diachi")
	private String diaChi;
	
	@Column(name = "sdt")
	private long sdt;

	public YTa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public YTa(String cmt,String ten, String trinhDo, String thamNien, String ngaySinh, String diaChi) {
		super();
		this.cmt = cmt;
		this.ten = ten;
		this.trinhDo = trinhDo;
		this.thamNien = thamNien;
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

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	public String getThamNien() {
		return thamNien;
	}

	public void setThamNien(String thamNien) {
		this.thamNien = thamNien;
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
