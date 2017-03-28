package com.bartek.domain.repository.impl;

import com.bartek.domain.Product;
import com.bartek.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bartek on 22.03.2017.
 */
@Repository
public class InMemoryProductRepository implements ProductRepository {
    private List<Product> listOfProducts = new ArrayList<Product>();
    public InMemoryProductRepository(){
        Product iphone= new Product("P1234","iPhone 5s",new BigDecimal(500));
        iphone.setDescription("Apple iPhone 5s, smartfon z 4-calowym wyświetlaczem i 8-megapikselowym aparatem");
        iphone.setCategory("Smart Phone");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(1000);

        Product laptop_dell= new Product("P1235","Dell Inspiron",new BigDecimal(700));
        laptop_dell.setDescription("Dell Inspiron, s15 calowy laptop(czarny) z procesorem intel Core 7 generacji.");
        laptop_dell.setCategory("Laptop");
        laptop_dell.setManufacturer("Dell");
        laptop_dell.setUnitsInStock(1000);

        Product tablet_nexus= new Product("P1236","Nexus 7",new BigDecimal(300));
        tablet_nexus.setDescription("Google Nexus 7 jest najlżejszym 7-calowym tabletem z 4-rdzeniowym procesorem Qualcomm Snapdragon™ S4 Pro");
        tablet_nexus.setCategory("Tablet");
        tablet_nexus.setManufacturer("Google");
        tablet_nexus.setUnitsInStock(1000);

        listOfProducts.add(iphone);
        listOfProducts.add(laptop_dell);
        listOfProducts.add(tablet_nexus);

    }

    public List<Product> getAllProducts() {
        return listOfProducts;
    }
}
