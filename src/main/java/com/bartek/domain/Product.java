package com.bartek.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by Bartek on 22.03.2017.
 */
@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @Column(name = "PRODUCTID")
    private String productId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "UNITPRICE")
    private BigDecimal unitPrice;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "MANUFACTURER")
    private String manufacturer;
    @Column(name ="CATEGORY" )
    private String category;
    @Column(name = "UNITSINSTOCK")
    private long unitsInStock;
    private long unitsInOrder;
    private boolean discontinued;
    private String condition;

    public Product() {
        super();
    }

    public Product(String productId, String name, BigDecimal unitPrice) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;

    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
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

    public void setUnitsInOrder(long unitsInOrder) {
        this.unitsInOrder = unitsInOrder;
    }

    public long getUnitsInOrder() {
        return unitsInOrder;
    }

    public void setDiscontinued(boolean discontinued) {
        this.discontinued = discontinued;
    }

    public boolean getDiscontinued() {
        return discontinued;
    }
    public void setCondition(String condition){
        this.condition=condition;
    }
    public String getCondition(){
        return condition;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if (obj==null) return false;
        if (getClass()!=obj.getClass()) return false;
        Product other =(Product) obj;
        if (productId==null) return false;
        else if (!productId.equals(other.productId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        final int prime =31;
        int result =1;
        result=prime*result+((productId==null)?0:productId.hashCode());

        return result;
    }

    @Override
    public String toString() {
        return "Produkt[productId=" + productId+", nazwa="+ name +"]";
    }
}
