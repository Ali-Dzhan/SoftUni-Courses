package org.gamestore.service;

import org.gamestore.data.entities.Game;
import org.gamestore.service.dtos.GameCreateDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface GameService {
    String addGame(GameCreateDto gameCreateDto);
    String editGame(Integer id, BigDecimal price, Double size);
    String deleteGame(Integer id);

    List<String> getAllGames();
    Optional<Game> getGameDetails(String title);
    List<String> getOwnedGames();

    String addToCart(String title);
    String removeFromCart(String title);
    String buyItems();
}
