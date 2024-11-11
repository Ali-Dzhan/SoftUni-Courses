package org.gamestore.service.implementations;

import org.gamestore.data.entities.Game;
import org.gamestore.data.entities.User;
import org.gamestore.data.repositories.GameRepository;
import org.gamestore.service.GameService;
import org.gamestore.service.UserService;
import org.gamestore.service.dtos.GameCreateDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;

    private static final Pattern TRAILER_PATTERN = Pattern.compile("^[\\w-]{11}$");
    private static final Pattern THUMBNAIL_URL_PATTERN = Pattern.compile("^https?://.*");

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper, UserService userService) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    @Override
    public String addGame(GameCreateDto gameCreateDto) {
        if (gameCreateDto.getTitle().length() < 3 || gameCreateDto.getTitle().length() > 100 || !Character.isUpperCase(gameCreateDto.getTitle().charAt(0))) {
            return "Invalid title.";
        }
        if (gameCreateDto.getPrice().compareTo(BigDecimal.ZERO) <= 0 ||
                gameCreateDto.getSize() <= 0) {
            return "Price and size must be positive numbers.";
        }
        if (!TRAILER_PATTERN.matcher(gameCreateDto.getTrailer()).matches()) {
            return "Invalid trailer ID.";
        }
        if (!THUMBNAIL_URL_PATTERN.matcher(gameCreateDto.getThumbnailUrl()).matches()) {
            return "Invalid thumbnail URL.";
        }
        if (gameCreateDto.getDescription().length() < 20) {
            return "Description must be at least 20 characters.";
        }

        Game game = modelMapper.map(gameCreateDto, Game.class);
        gameRepository.save(game);

        return "Added " + game.getTitle();
    }

    @Override
    public String editGame(Integer id, BigDecimal price, Double size) {
        Optional<Game> gameOptional = gameRepository.findById(id);
        if (gameOptional.isEmpty()) {
            return "Game not found.";
        }

        Game game = gameOptional.get();
        if (price != null && price.compareTo(BigDecimal.ZERO) > 0) {
            game.setPrice(price);
        }
        if (size != null && size > 0) {
            game.setSize(size);
        }
        gameRepository.save(game);

        return "Edited " + game.getTitle();
    }

    @Override
    public String deleteGame(Integer id) {
        if (!gameRepository.existsById(id)) {
            return "Game not found.";
        }
        gameRepository.deleteById(id);
        return "Deleted game with ID " + id;
    }

    @Override
    public List<String> getAllGames() {
        return gameRepository.findAll().stream()
                .map(game -> game.getTitle() + " " + game.getPrice())
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Game> getGameDetails(String title) {
        return gameRepository.findByTitle(title);
    }

    @Override
    @Transactional
    public List<String> getOwnedGames() {
        User loggedInUser = userService.getLoggedInUser();
        if (loggedInUser == null) {
            return List.of("No user logged in.");
        }
        return loggedInUser.getGames().stream()
                .map(Game::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public String addToCart(String title) {
        User loggedInUser = userService.getLoggedInUser();
        if (loggedInUser == null) {
            return "No user logged in.";
        }

        Optional<Game> gameOptional = gameRepository.findByTitle(title);
        if (gameOptional.isEmpty()) {
            return "Game not found.";
        }

        Game game = gameOptional.get();
        if (loggedInUser.getGames().contains(game)) {
            return "User already owns the game.";
        }

        if (loggedInUser.getCart().contains(game)) {
            return "Game is already in the cart.";
        }

        loggedInUser.getCart().add(game);
        return game.getTitle() + " added to cart.";
    }

    @Override
    public String removeFromCart(String title) {
        User loggedInUser = userService.getLoggedInUser();
        if (loggedInUser == null) {
            return "No user logged in.";
        }

        Optional<Game> gameOptional = gameRepository.findByTitle(title);
        if (gameOptional.isEmpty()) {
            return "Game not found.";
        }

        Game game = gameOptional.get();
        if (!loggedInUser.getCart().contains(game)) {
            return "Game is not in the cart.";
        }

        loggedInUser.getCart().remove(game);
        return game.getTitle() + " removed from cart.";
    }

    @Override
    public String buyItems() {
        User loggedInUser = userService.getLoggedInUser();
        if (loggedInUser == null) {
            return "No user logged in.";
        }

        if (loggedInUser.getCart().isEmpty()) {
            return "No items in cart.";
        }

        StringBuilder result = new StringBuilder("Successfully bought games:\n");
        for (Game game : loggedInUser.getCart()) {
            loggedInUser.getGames().add(game);
            result.append("- ").append(game.getTitle()).append("\n");
        }

        loggedInUser.getCart().clear();
        return result.toString();
    }
}
