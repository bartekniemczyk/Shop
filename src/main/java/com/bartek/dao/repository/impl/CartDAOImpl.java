package com.bartek.dao.repository.impl;

import com.bartek.dao.Cart;
import com.bartek.dao.repository.CartDAO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bartek on 10.04.2017.
 */
@Repository
public class CartDAOImpl implements CartDAO{

    private Map<Integer, Cart> listOfCarts;
    public CartDAOImpl(){
      listOfCarts=new HashMap<Integer, Cart>();
    }

    @Override
    public Cart create(Cart cart) {
        if (listOfCarts.keySet().contains(cart.getCartId())){
            throw new IllegalArgumentException(String.format("Nie można utworzyć koszyka,ten koszyk już istniej"));
        }listOfCarts.put(cart.getCartId(),cart);
        return cart;
    }

    @Override
    public Cart read(int cartId) {
        return listOfCarts.get(cartId);
    }

    @Override
    public void update(int cartId, Cart cart) {
if (!listOfCarts.keySet().contains(cartId)){
    throw new IllegalArgumentException(String.format("Nie można zaktualizowac koszyka, ten koszyk juz istnieje"));

}listOfCarts.put(cartId,cart);
    }

    @Override
    public void delete(int cartId) {
        if (!listOfCarts.keySet().contains(cartId)){
            throw new IllegalArgumentException(String.format("Nie można zusunąć koszyka, ten koszyk nie istnieje"));

        }listOfCarts.remove(cartId);

    }
}
