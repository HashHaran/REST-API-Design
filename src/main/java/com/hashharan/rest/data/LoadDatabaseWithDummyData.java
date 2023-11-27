package com.hashharan.rest.data;

import com.hashharan.rest.model.*;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.Date;

@Configuration
public class LoadDatabaseWithDummyData {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabaseWithDummyData.class);

    @Bean
    CommandLineRunner initDatabase(ProviderCrudRepository providerCrudRepository, ProductCrudRepository productCrudRepository, UserCrudRepository userCrudRepository, OrderCrudRepository orderCrudRepository, ModelMapper modelMapper) {
        return args -> {
            Provider provider1 = providerCrudRepository.save(new Provider(ProviderType.Bank, "IDFC First Bank", "Good bank for salary account", Date.from(Instant.ofEpochSecond(946684800))));  //Date is 01/01/2000
            Provider provider2 = providerCrudRepository.save(new Provider(ProviderType.NBFC, "Muthoot fincorp", "If you have gold you can go give it to them and forget it", Date.from(Instant.ofEpochSecond(946684800))));
            Provider provider3 = providerCrudRepository.save(new Provider(ProviderType.CooperativeSociety, "Amul milk bank", "Because milk matters", Date.from(Instant.ofEpochSecond(946684800))));
            log.info("Preloading" + provider1);
            log.info("Preloading" + provider2);
            log.info("Preloading" + provider3);

            Product product1 = productCrudRepository.save(new Product(modelMapper.map(provider1, ProviderDTO.class), InsuranceType.Home, "IDFC is the man of the smart people", true));
            Product product2 = productCrudRepository.save(new Product(modelMapper.map(provider2, ProviderDTO.class), InsuranceType.Car, "Muthoot is not just a muthoot but is a brand", false));
            Product product3 = productCrudRepository.save(new Product(modelMapper.map(provider3, ProviderDTO.class), InsuranceType.Travel, "Amul is not just amul but the man of the smart people", false));
            log.info("Preloading" + product1);
            log.info("Preloading" + product2);
            log.info("Preloading" + product3);

            User user1 = userCrudRepository.save(new User("Rishabh", "Pant", ""));
            User user2 = userCrudRepository.save(new User("Mahendrasingh", "Dhoni", ""));
            User user3 = userCrudRepository.save(new User("Rohit", "Sharma", ""));
            log.info("Preloading" + user1);
            log.info("Preloading" + user2);
            log.info("Preloading" + user3);

            Order order1 = orderCrudRepository.save(new Order(modelMapper.map(product2, ProductDTO.class), modelMapper.map(user1, UserDTO.class), OrderStatus.Pending));
            Order order2 = orderCrudRepository.save(new Order(modelMapper.map(product3, ProductDTO.class), modelMapper.map(user2, UserDTO.class), OrderStatus.Granted));
            Order order3 = orderCrudRepository.save(new Order(modelMapper.map(product1, ProductDTO.class), modelMapper.map(user3, UserDTO.class), OrderStatus.Expired));
            log.info("Preloading" + order1);
            log.info("Preloading" + order2);
            log.info("Preloading" + order3);
        };
    }
}
