package com.cbl.backend.model;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name = "LorryStock")
public class LorryStock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int LorryStockID;
	@NotEmpty
	@Column
	private LocalDateTime DateTime;
	@NotEmpty
	@Column(unique = true)
	private String LorryStockName;
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL, mappedBy = "LorryStock")
	private List<Product> Products;
	
	public int getLorryStockID() {
		return LorryStockID;
	}
	public void setLorryStockID(int lorryStockID) {
		LorryStockID = lorryStockID;
	}
	public LocalDateTime getDateTime() {
		return DateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		DateTime = dateTime;
	}
	public String getLorryStockName() {
		return LorryStockName;
	}
	public void setLorryStockName(String lorryStockName) {
		LorryStockName = lorryStockName;
	}
	public List<Product> getProduct() {
		return Products;
	}
	public void setProduct(List<Product> product) {
		Products = product;
	}
	
	@Override
	public String toString() {
		return "LorryStock [LorryStockID=" + LorryStockID + ", DatTime=" + DateTime + ", LorryStockName=" +
	LorryStockName + ", Products=" + Products+"]";
	}
}
