package com.guimaraes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "Songs")
public class SongsEntity {

	@Id
	private long id;

	@Column
	private long playListId;

}
