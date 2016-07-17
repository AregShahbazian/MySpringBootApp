package com.myspingbootapp.domain.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "article_order_row")
@ApiModel(description = "An ArticleOrder belongs to exactly one Order, and is for exactly one Article")
public class ArticleOrderRow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(name = "article_order", nullable = false)
	@NotNull(message = "article_order can not be null")
	@ApiModelProperty(value = "The ArticleOrder to which the ArticleOrderRow belongs", required = true)
	@ManyToOne(cascade = CascadeType.ALL)
	private ArticleOrder article_order;

	@JoinColumn(name = "article", nullable = false)
	@NotNull(message = "article can not be null")
	@ApiModelProperty(value = "The Article which the articleOrder is for", required = true)
	@ManyToOne(cascade = CascadeType.ALL)
	private Article article;

	@Column(name = "amount", nullable = false)
	@Min(value = 1, message = "amount must be equal or grater than 1")
	@NotNull(message = "amount can not be null")
	@ApiModelProperty(value = "Title of the article", dataType = "java.lang.Integer", required = true)
	private Integer amount;

	public ArticleOrderRow() {
		super();
	}

	public ArticleOrderRow(Long id, ArticleOrder order, Article article, Integer amount) {
		super();
		this.id = id;
		this.article_order = order;
		this.article = article;
		this.amount = amount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ArticleOrder getOrder() {
		return article_order;
	}

	public void setOrder(ArticleOrder order) {
		this.article_order = order;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

}
