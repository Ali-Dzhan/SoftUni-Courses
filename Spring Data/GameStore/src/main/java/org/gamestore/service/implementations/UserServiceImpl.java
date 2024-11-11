package org.gamestore.service.implementations;

import org.gamestore.data.entities.User;
import org.gamestore.data.repositories.UserRepository;
import org.gamestore.service.UserService;
import org.gamestore.service.dtos.UserCreateDto;
import org.hibernate.Hibernate;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    private User loggedInUser = null;

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$");

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String registerUser(UserCreateDto userCreateDto) {
        if (!EMAIL_PATTERN.matcher(userCreateDto.getEmail()).matches()) {
            return "Incorrect email.";
        }
        if (!PASSWORD_PATTERN.matcher(userCreateDto.getPassword()).matches()) {
            return "Password must be at least 6 characters and contain at least one uppercase, one lowercase letter, and one digit.";
        }
        if (!userCreateDto.getPassword().equals(userCreateDto.getConfirmPassword())) {
            return "Passwords do not match.";
        }
        if (userRepository.findByEmail(userCreateDto.getEmail()).isPresent()) {
            return "Email already registered.";
        }

        User user = modelMapper.map(userCreateDto, User.class);
        if (userRepository.count() == 0) {
            user.setAdmin(true);
        }
        userRepository.save(user);
        return String.format("%s was registered", user.getFullName());
    }

    @Override
    public String loginUser(String email, String password) {
        if (loggedInUser != null) {
            return "A user is already logged in.";
        }

        return userRepository.findByEmail(email)
                .filter(user -> user.getPassword().equals(password))
                .map(user -> {
                    loggedInUser = user;
                    return String.format("Successfully logged in %s", user.getFullName());
                })
                .orElse("Incorrect username / password.");
    }

    @Override
    public String logout() {
        if (loggedInUser == null) {
            return "Cannot log out. No user was logged in.";
        }
        String name = loggedInUser.getFullName();
        loggedInUser = null;
        return String.format("User %s successfully logged out", name);
    }

    @Override
    public User getLoggedInUser() {
        if (loggedInUser != null) {
            Hibernate.initialize(loggedInUser.getGames());
        }
        return loggedInUser;
    }
}
