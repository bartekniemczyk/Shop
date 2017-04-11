package com.bartek.dao.repository;

import com.bartek.dao.Cart;

/**
 * Created by Bartek on 10.04.2017.
 */
public interface CartDAO {
    Cart create(Cart cart);
    Cart read(int cartId);
    void update(int cartId, Cart cart);
    void delete(int cartId);

}
