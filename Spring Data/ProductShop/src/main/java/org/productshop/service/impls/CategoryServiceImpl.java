package org.productshop.service.impls;

import com.google.gson.Gson;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.productshop.data.entities.Category;
import org.productshop.data.repos.CategoryRepository;
import org.productshop.service.CategoryService;
import org.productshop.service.dtos.CategorySeedJsonDto;
import org.productshop.service.utils.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String JSON_PATH = "C:\\Users\\Ali\\ProductShop\\src\\main\\resources\\json\\categories.json";

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
    }

    @Override
    public void seedCategories() throws IOException {
        String jsonSTR = String.join("", Files.readAllLines(Path.of(JSON_PATH)));
        CategorySeedJsonDto[] categorySeedJsonDtos = this.gson.fromJson(jsonSTR, CategorySeedJsonDto[].class);
        for (CategorySeedJsonDto categorySeedJsonDto : categorySeedJsonDtos) {
            if(!this.validatorUtil.isValid(categorySeedJsonDto)) {
                System.out.println(this.validatorUtil.validate(categorySeedJsonDto)
                        .stream().map(ConstraintViolation::getMessage)
                        .collect(Collectors.joining()));
                continue;
            }
            this.categoryRepository.save(this.modelMapper.map(categorySeedJsonDto, Category.class));
        }
    }
}
