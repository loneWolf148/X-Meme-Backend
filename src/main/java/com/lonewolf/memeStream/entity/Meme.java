package com.lonewolf.memeStream.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModelProperty.AccessMode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p>
 * This class acts as Meme Entity - corresponds to "memes" table in Database
 * </p>
 * 
 * @author Subham Das
 * @version 1.0
 * @see {@link com.lonewolf.memeStream.controller.MemeController}
 * @see {@link com.lonewolf.memeStream.repository.MemeRepositroy}
 */
@ApiModel
@ToString
@Entity
@Table(name = "memes")
public class Meme {

	@ApiModelProperty(accessMode = AccessMode.READ_ONLY, notes = "Unique ID Identifying Each Meme", example = "1")
	@Getter
	@Id
	@Column(name = "meme_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ApiModelProperty(accessMode = AccessMode.READ_WRITE, notes = "Uploader of Meme", example = "John Doe")
	@Getter
	@Setter
	@Column(name = "meme_owner", nullable = false)
	private String name;

	@ApiModelProperty(accessMode = AccessMode.READ_WRITE, notes = "Caption of Meme", example = "This is a Meme Caption")
	@Getter
	@Setter
	@Column(name = "meme_caption", nullable = false)
	private String caption;

	@ApiModelProperty(accessMode = AccessMode.READ_WRITE, notes = "URL Address of Meme", example = "https://angular.io/assets/images/logos/angular/angular.png")
	@Getter
	@Setter
	@Column(name = "meme_url", nullable = false)
	private String url;
}
