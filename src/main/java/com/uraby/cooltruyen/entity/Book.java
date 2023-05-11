package com.uraby.cooltruyen.entity;

import java.util.Collection;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Book {
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;

	@ManyToMany(mappedBy = "books")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Collection<Category> categories;

	@ManyToMany(mappedBy = "books")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Collection<Author> authors;

}
