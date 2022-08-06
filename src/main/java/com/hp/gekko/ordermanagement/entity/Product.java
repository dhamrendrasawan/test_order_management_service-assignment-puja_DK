package com.hp.gekko.ordermanagement.entity;

import javax.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Setter
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Products")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long productId;

	private String name;
	private Long quantity;
	private BigDecimal price;
	@CreationTimestamp
	@Column(updatable = false)
	Date createDate;

	@UpdateTimestamp
	@Column(updatable = false)
	Date updateDate;

	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Order.class, cascade = { CascadeType.MERGE,
			CascadeType.PERSIST })
	@JsonIgnore
	@JoinColumn(name = "orderId", referencedColumnName = "order_id")
	private Order order;

}
