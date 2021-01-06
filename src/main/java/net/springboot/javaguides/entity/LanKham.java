package net.springboot.javaguides.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lankhams")
public class LanKham {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "ngayvao")
	public String ngayVao;
	
	@Column(name = "ngayra")
	public String ngayRa;
	
	@Column(name = "tenbenh")
	public String tenBenh;
	
	@Column(name = "tongtien")
	public float tongTien;

	public LanKham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LanKham(String ngayVao, String ngayRa, String tenBenh, float tongTien) {
		super();
		this.ngayVao = ngayVao;
		this.ngayRa = ngayRa;
		this.tenBenh = tenBenh;
		this.tongTien = tongTien;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNgayVao() {
		return ngayVao;
	}

	public void setNgayVao(String ngayVao) {
		this.ngayVao = ngayVao;
	}

	public String getNgayRa() {
		return ngayRa;
	}

	public void setNgayRa(String ngayRa) {
		this.ngayRa = ngayRa;
	}

	public String getTenBenh() {
		return tenBenh;
	}

	public void setTenBenh(String tenBenh) {
		this.tenBenh = tenBenh;
	}

	public float getTongTien() {
		return tongTien;
	}

	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}
	
	
}
