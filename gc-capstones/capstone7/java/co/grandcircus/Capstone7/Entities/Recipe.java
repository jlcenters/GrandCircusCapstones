package co.grandcircus.Capstone7.Entities;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Recipe {

	private String uri;
	private String url;
	private List<Ingredient> ingredients;
	@JsonProperty("label")
	private String lbl;
	@JsonProperty("image")
	private String img;
	@JsonProperty("source")
	private String src;
	private Double yield;
	@JsonProperty("dietLabels")
	private List<String> dietLbl;
	@JsonProperty("healthLabels")
	private List<String> healthLbl;
	private List<String> ingredientLines;
	private Double calories;
	@JsonProperty("totalTime")
	private Double time;
// TODO: see private Boolean isFav;
	// Negated? Use (Id != null) test??
	
	
	
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
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
	public Double getYield() {
		return yield;
	}
	public void setYield(Double yield) {
		this.yield = yield;
	}
	public List<String> getDietLbl() {
		return dietLbl;
	}
	public void setDietLbl(List<String> dietLbl) {
		this.dietLbl = dietLbl;
	}
	public List<String> getHealthLbl() {
		return healthLbl;
	}
	public void setHealthLbl(List<String> healthLbl) {
		this.healthLbl = healthLbl;
	}
	public List<String> getIngredientLines() {
		return ingredientLines;
	}
	public void setIngredientLines(List<String> ingredientLines) {
		this.ingredientLines = ingredientLines;
	}
	public Double getCalories() {
		return calories;
	}
	public void setCalories(Double calories) {
		this.calories = calories;
	}
	public Double getTime() {
		return time;
	}
	public void setTime(Double time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Recipe [uri=" + uri + ", url=" + url + ", ingredients=" + ingredients + ", lbl=" + lbl + ", img=" + img
				+ ", src=" + src + ", yield=" + yield + ", dietLbl=" + dietLbl + ", healthLbl=" + healthLbl
				+ ", ingredientLines=" + ingredientLines + ", calories=" + calories + ", time=" + time + "]";
	}

}
