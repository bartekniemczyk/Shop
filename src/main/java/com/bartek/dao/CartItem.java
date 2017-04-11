package com.bartek.dao;

import java.math.BigDecimal;

/**
 * Created by Bartek on 10.04.2017.
 */
public class CartItem {
    private Product product;
    private int quantity;
    private BigDecimal totalprice;
    public CartItem(){}
    public CartItem(Product product){
        super();
        this.product=product;
        this.quantity=1;
        this.totalprice=product.getUnitPrice();
    }
    public Product getProduct(){
        return product;
    }
    public void setProduct(Product product){
        this.product=product;
        this.updateTotalPrice();
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
        this.updateTotalPrice();
    }
    public BigDecimal getTotalprice(){
        return totalprice;
    }
    public void updateTotalPrice(){
        totalprice = this.product.getUnitPrice().multiply(new BigDecimal(this.quantity));
    }

    @Override
    public int hashCode() {
        final int prime =311;
        int result =1;
        result=prime*result+((product==null)?0:product.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj){
            return true;
        }if (obj==null){
            return false;
        }if (getClass()!=obj.getClass()){
            return false;
        }
        CartItem other =(CartItem)obj;
        if (product==null){
            if (other.product!=null){
                return false;
            }
        }else if ((!product.equals(other.product))){
            return false;
        }

        return true;
    }
}
