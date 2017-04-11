package com.bartek.dao;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Bartek on 22.03.2017.
 */
@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @Column(name = "PRODUCTID")
    private int productId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "UNITPRICE")
    private BigDecimal unitPrice;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "MANUFACTURER")
    private String manufacturer;
    @Column(name = "CATEGORY")
    private String category;
    @Column(name = "UNITSINSTOCK")
    private long unitsInStock;



    public Product() {
        super();
    }

    public Product(int productId, String name, BigDecimal unitPrice) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;

    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setUnitsInStock(long unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public long getUnitsInStock() {
        return unitsInStock;
    }


    @Override
    public String toString() {
        return "Produkt[productId=" + productId+", nazwa="+ name +"]";
    }
}
