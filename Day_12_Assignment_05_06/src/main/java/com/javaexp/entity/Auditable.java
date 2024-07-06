package com.javaexp.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class Auditable {

	
	@CreatedBy
	@Column(updatable = false)
	private String createdBy;
	
	@CreatedDate
	@Column(updatable = false)
	private LocalDateTime localDateTime;
	
	@LastModifiedBy
	@Column(insertable = false)
	private String lastModifedBy;
	
	@LastModifiedDate
	@Column(insertable = false)
	private LocalDateTime lastModifedDateTime;
}
