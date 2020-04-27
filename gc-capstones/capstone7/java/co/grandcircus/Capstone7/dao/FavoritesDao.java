package co.grandcircus.Capstone7.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.Capstone7.Entities.FavoriteRecipe;

public interface FavoritesDao extends JpaRepository<FavoriteRecipe, String> {
//	public Recipe findByUri(String uri);
}
