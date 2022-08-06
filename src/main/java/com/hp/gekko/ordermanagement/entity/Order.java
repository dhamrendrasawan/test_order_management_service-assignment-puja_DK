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
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Setter

@Getter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "orders")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_info_id")
	private Long orderInfoId;

	@Column(name = "order_id")
	private String orderId;

	private String code;
	@CreationTimestamp

	@Column(updatable = false)
	Date createDate;

	@UpdateTimestamp
	@Column(updatable = false)
	Date updateDate;

	@ToString.Exclude
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Product.class)
	@JsonIgnore
	private List<Product> product;

	@OneToOne(cascade = CascadeType.MERGE)
	@JsonIgnore
	@JoinColumn(name = "customer_id_Fk", referencedColumnName = "customer_id")

	private Customer customer;

}
