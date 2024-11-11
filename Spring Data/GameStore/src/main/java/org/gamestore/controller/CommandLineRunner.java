package org.gamestore.controller;

import org.gamestore.data.entities.Game;
import org.gamestore.service.GameService;
import org.gamestore.service.UserService;
import org.gamestore.service.dtos.GameCreateDto;
import org.gamestore.service.dtos.UserCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Component

public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public CommandLineRunner(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        while (!(line = reader.readLine()).equals("stop")){
            String[] tokens = line.split("\\|");
            String command = "";

            switch (tokens[0]) {
                // User commands
                case "RegisterUser":
                    command = this.userService.registerUser(new UserCreateDto(tokens[1], tokens[2], tokens[3], tokens[4]));
                    break;

                case "LoginUser":
                    command = userService.loginUser(tokens[1], tokens[2]);
                    break;

                case "Logout":
                    command = userService.logout();
                    break;

                // Game commands
                case "AddGame":
                    GameCreateDto gameCreateDto = new GameCreateDto(
                            tokens[1],
                            new BigDecimal(tokens[2]),
                            Double.parseDouble(tokens[3]),
                            tokens[4],
                            tokens[5],
                            tokens[6],
                            LocalDate.parse(tokens[7], formatter)
                    );
                    command = gameService.addGame(gameCreateDto);
                    break;

                case "EditGame":
                    command = gameService.editGame(
                            Integer.parseInt(tokens[1]),
                            tokens.length > 2 ? new BigDecimal(tokens[2].split("=")[1]) : null,
                            tokens.length > 3 ? Double.parseDouble(tokens[3].split("=")[1]) : null
                    );
                    break;

                case "DeleteGame":
                    command = gameService.deleteGame(Integer.parseInt(tokens[1]));
                    break;

                // View Commands
                case "AllGames":
                    gameService.getAllGames().forEach(System.out::println);
                    break;

                case "DetailGame":
                    Optional<Game> gameDetails = gameService.getGameDetails(tokens[1]);
                    if (gameDetails.isPresent()) {
                        Game game = gameDetails.get();
                        System.out.printf("Title: %s%nPrice: %.2f%nDescription: %s%nRelease date: %s%n",
                                game.getTitle(), game.getPrice(), game.getDescription(), game.getReleaseDate());
                    } else {
                        System.out.println("Game not found.");
                    }
                    break;

                case "OwnedGames":
                    gameService.getOwnedGames().forEach(System.out::println);
                    break;

                    // Cart commands

                case "AddItem":
                    System.out.println(gameService.addToCart(tokens[1]));
                    break;

                case "RemoveItem":
                    System.out.println(gameService.removeFromCart(tokens[1]));
                    break;

                case "BuyItem":
                    System.out.println(gameService.buyItems());
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + tokens[0]);
            }

            if (!command.isEmpty()) {
                System.out.println(command);
            }
        }
    }
}
