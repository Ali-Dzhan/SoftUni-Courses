package org.productshop.service.impls;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.productshop.data.entities.Category;
import org.productshop.data.entities.Product;
import org.productshop.data.entities.User;
import org.productshop.data.repos.CategoryRepository;
import org.productshop.data.repos.ProductRepository;
import org.productshop.data.repos.UserRepository;
import org.productshop.service.ProductService;
import org.productshop.service.dtos.ProductSeedJsonDto;
import org.productshop.service.utils.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ProductServiceImpl implements ProductService {
    private static final String JSON_PATH = "C:\\Users\\Ali\\ProductShop\\src\\main\\resources\\json\\products.json";

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository, CategoryRepository categoryRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
    }

    @Override
    public void seedProducts() throws IOException {
        String jsonSTR = String.join("", Files.readAllLines(Path.of(JSON_PATH)));
        ProductSeedJsonDto[] productSeedJsonDtos = this.gson.fromJson(jsonSTR, ProductSeedJsonDto[].class);
        for (ProductSeedJsonDto productSeedJsonDto : productSeedJsonDtos) {
            Product product = this.modelMapper.map(productSeedJsonDto, Product.class);
            product.setSeller(getRandomUser(true));
            product.setBuyer(getRandomUser(false));
            product.setCategories(getRandomCategory());

           this.productRepository.saveAndFlush(product);
        }
    }

    private Set<Category> getRandomCategory() {
        Set<Category> categories = new HashSet<>();
        int count = ThreadLocalRandom.current().nextInt(1, 4);

        for (int i = 0; i < count; i++) {
            int randomId = ThreadLocalRandom.current().nextInt(1, (int) (this.categoryRepository.count() + 1));
            Optional<Category> optionalCategory = this.categoryRepository.findById(randomId);

            optionalCategory.ifPresent(categories::add);
        }
        return categories;
    }

    private User getRandomUser(boolean flag) {
        int random = 0;
        if(flag){
           random = ThreadLocalRandom.current().nextInt(1, (int) (this.categoryRepository.count() + 1));

        } else {
            random = ThreadLocalRandom.current().nextInt(1, (int) (this.categoryRepository.count()));
        }
        return this.userRepository.findById(random).get();
    }
}

