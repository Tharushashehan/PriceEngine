package com.engine.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.engine.repository.StringPrefixedSequenceIdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Transaction")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true, ignoreUnknown = true)
public class Transaction implements Serializable {
	
	@Id @Getter @Setter	
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "TRANSACTION_SEQ")
	@GenericGenerator(
	        name = "TRANSACTION_SEQ", 
	        strategy = "com.engine.repository.StringPrefixedSequenceIdGenerator", 
	        parameters = {
	            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
	            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "TRAN-"),
	            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String id;  

	@Getter @Setter	@Column(name = "product_ID", nullable = false)
	private String   product_ID;
	@Getter @Setter	@Column(name = "product_name", nullable = false)
	private String   product_name;
	@Getter @Setter	@Column(name = "no_of_units", nullable = false)
	private Integer   no_of_units;
	@Getter @Setter	@Column(name = "total_price", nullable = false)
	private Double   total_price;
	
	@Getter @Setter	@Column(name = "created_at", nullable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Getter @Setter	@Column(name = "updated_at", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
    
    @Getter @Setter	@Column(name = "status_code", nullable = true)
    private boolean status_code = true;
}
