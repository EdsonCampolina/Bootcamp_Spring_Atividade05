package com.devsuperior.movieflix.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.devsuperior.movieflix.entities.Movie;

public class MovieDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String title;

	private String subTitle;

	private Integer year;

	private String imgUrl;

	private String synopsis;

	private GenreDTO genre;

	private List<ReviewDTO> reviews;

	public MovieDTO() {
	}

	public MovieDTO(Long id, String title, String subTitle, Integer year, String imgUrl, String synopsis,
			GenreDTO genre) {
		super();
		this.id = id;
		this.title = title;
		this.subTitle = subTitle;
		this.year = year;
		this.imgUrl = imgUrl;
		this.synopsis = synopsis;
		this.genre = genre;
	}

	public MovieDTO(Movie movie) {
		this.id = movie.getId();
		this.title = movie.getTitle();
		this.subTitle = movie.getSubTitle();
		this.year = movie.getYear();
		this.imgUrl = movie.getImgUrl();
		this.synopsis = movie.getSynopsis();
		this.genre = new GenreDTO(movie.getGenre());

		List<ReviewDTO> reviews = movie.getReviews().stream().map(r -> new ReviewDTO(r)).collect(Collectors.toList());
		this.setReviews(reviews);
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

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public GenreDTO getGenre() {
		return genre;
	}

	public void setGenre(GenreDTO genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieDTO other = (MovieDTO) obj;
		return Objects.equals(id, other.id);
	}

	public List<ReviewDTO> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewDTO> reviews) {
		this.reviews = reviews;
	}

}