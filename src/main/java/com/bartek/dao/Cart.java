package com.bartek.dao;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bartek on 10.04.2017.
 */
public class Cart {
    private int cartId=0;
    private Map<Integer, CartItem> cartItems;
    private BigDecimal grandTotal;
    public Cart() {
        cartItems = new HashMap<>();
        grandTotal= new BigDecimal(0);
    }
    public Cart(int cartId){
        this();
        this.cartId= cartId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Map<Integer, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Integer, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }
    public void addCartItem(CartItem item){
        int productId= item.getProduct().getProductId();
        if (cartItems.containsKey(productId)){
            CartItem exisitingCartItem= cartItems.get(productId);
            exisitingCartItem.setQuantity(exisitingCartItem.getQuantity()+item.getQuantity());
            cartItems.put(productId,exisitingCartItem);
        }else cartItems.put(productId,item);
    updateGrandTotal();
    }
    public void removeCartItem(CartItem item){
        int productId = item.getProduct().getProductId();
        cartItems.remove(productId);
        updateGrandTotal();
    }
    public void updateGrandTotal(){
        grandTotal= new BigDecimal(0);
        for (CartItem item:cartItems.values()){
            grandTotal=grandTotal.add(item.getTotalprice());
        }

    }

    @Override
    public int hashCode() {
        final int prime = 71;
        int result= 1;
        result= prime*result+((cartId==0)? 0:cartId);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj){
            return true;
        }
        if (obj==null){
            return false;
        }if (getClass()!=obj.getClass()){
            return false;
        }
        Cart other =(Cart)obj;
        if (cartId==0){
            if (other.cartId!=0){
                return false;
            }
        }else if (cartId!=other.cartId)
            return false;

        return true;
    }
}
