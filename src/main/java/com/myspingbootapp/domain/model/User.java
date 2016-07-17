package com.myspingbootapp.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "user")
@ApiModel(description = "A User has zero or more articles, and zero or more orders.")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username", nullable = false)
	@Length(max = 32, message = "username can not exceed 32 characters")
	@NotNull(message = "username can not be null")
	@ApiModelProperty(value = "Username of the user", dataType = "java.lang.String", required = true)
	private String username;

	@ApiModelProperty(value = "Articles created by the user")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	private Set<Article> articles;// TOOD: try: initialize with new

	@ApiModelProperty(value = "Orders placed by the user")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<ArticleOrder> orders;
	
	public User() {
		super();
	}

	public User(Long id, String username, Set<Article> articles, Set<ArticleOrder> orders) {
		super();
		this.id = id;
		this.username = username;
		this.articles = articles;
		this.orders = orders;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Article> getArticles() {
		return articles;
	}

	public void setArticles(Set<Article> articles) {
		this.articles = articles;
	}

	public Set<ArticleOrder> getOrders() {
		return orders;
	}

	public void setOrders(Set<ArticleOrder> orders) {
		this.orders = orders;
	}

}
