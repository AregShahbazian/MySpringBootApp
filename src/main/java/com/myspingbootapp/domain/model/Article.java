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
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "article")
@ApiModel(description = "An Article has exactly one User (owner)")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", nullable = false)
	@Length(max = 128, message = "title can not exceed 128 characters")
	@NotNull(message = "title can not be null")
	@ApiModelProperty(value = "Title of the article", dataType = "java.lang.String", required = true)
	private String title;

	@JoinColumn(name = "owner", nullable = false)
	@NotNull(message = "owner can not be null")
	@ApiModelProperty(value = "Owner of the article", required = true)
	@ManyToOne(cascade = CascadeType.ALL)
	private User owner;

	public Article() {
		super();
	}

	public Article(Long id, String title, User owner) {
		super();
		this.id = id;
		this.title = title;
		this.owner = owner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

}
