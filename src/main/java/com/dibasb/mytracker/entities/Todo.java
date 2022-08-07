package com.dibasb.mytracker.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Todo {

	@Id
	@GeneratedValue
	private int id;

	private String user;

	@Column(name = "description")
	private String desc;

	private Date targetDate;

	private boolean isDone;

}
