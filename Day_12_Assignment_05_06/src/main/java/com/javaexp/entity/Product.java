package com.javaexp.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends Auditable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double price;
	private String name;
	private Integer quantity;
	private String description;
	private Boolean isStock;
	private String barCode;
	
	//many to one
	@ManyToOne
	@JoinColumn(name="cat_id",nullable = false)
	private Category category;
	
	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<Review> reviews;
	
	
}
