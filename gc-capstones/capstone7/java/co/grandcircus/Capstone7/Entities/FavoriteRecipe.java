package co.grandcircus.Capstone7.Entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class FavoriteRecipe{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String url;
	@JsonProperty("label")
	private String lbl;
	@JsonProperty("image")
	private String img;
	@JsonProperty("source")
	private String src;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLbl() {
		return lbl;
	}
	public void setLbl(String lbl) {
		this.lbl = lbl;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}

	
}
