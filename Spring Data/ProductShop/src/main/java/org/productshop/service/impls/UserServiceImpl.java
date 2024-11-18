package org.productshop.service.impls;

import com.google.gson.Gson;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.productshop.data.entities.Category;
import org.productshop.data.entities.User;
import org.productshop.data.repos.UserRepository;
import org.productshop.service.UserService;
import org.productshop.service.dtos.UserSeedJsonDto;
import org.productshop.service.utils.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final String JSON_PATH = "C:\\Users\\Ali\\ProductShop\\src\\main\\resources\\json\\users.json";

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
    }

    @Override
    public void userSeed() throws IOException {
        String jsonSTR = String.join("", Files.readAllLines(Path.of(JSON_PATH)));
        UserSeedJsonDto[] userSeedJsonDtos = this.gson.fromJson(jsonSTR, UserSeedJsonDto[].class);
        for (UserSeedJsonDto userSeedJsonDto : userSeedJsonDtos) {
            if(!this.validatorUtil.isValid(userSeedJsonDto)) {
                System.out.println(this.validatorUtil.validate(userSeedJsonDto)
                        .stream().map(ConstraintViolation::getMessage)
                        .collect(Collectors.joining()));
                continue;
            }
            this.userRepository.save(this.modelMapper.map(userSeedJsonDto, User.class));
        }
    }
}