package co.grandcircus.Capstone7;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import co.grandcircus.Capstone7.Entities.*;

public class HitsResponse {
	@JsonProperty("hits")
	private List<Recipe> recipes;
	
	
	//TODO: print out recipes;
}
