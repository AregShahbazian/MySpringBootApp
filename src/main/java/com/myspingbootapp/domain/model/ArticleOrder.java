package com.myspingbootapp.domain.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "article_order")
@ApiModel(description = "An Order has one or more ArticleOrders, and exacly one user")
public class ArticleOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ApiModelProperty(value = "The articleOrderRows of this order")
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "article_order")
	private Set<ArticleOrderRow> articleOrderRows;

	@JoinColumn(name = "user", nullable = false)
	@NotNull(message = "user can not be null")
	@ApiModelProperty(value = "The user who placed the order", required = true)
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;

	public ArticleOrder() {
		super();
	}

	public ArticleOrder(Long id, Set<ArticleOrderRow> articleOrderRows, User user) {
		super();
		this.id = id;
		this.articleOrderRows = articleOrderRows;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<ArticleOrderRow> getArticleOrderRows() {
		return articleOrderRows;
	}

	public void setArticleOrderRows(Set<ArticleOrderRow> articleOrderRows) {
		this.articleOrderRows = articleOrderRows;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
