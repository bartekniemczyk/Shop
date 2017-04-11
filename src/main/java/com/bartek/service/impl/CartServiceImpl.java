package com.bartek.service.impl;

import com.bartek.dao.Cart;
import com.bartek.dao.repository.CartDAO;
import com.bartek.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Bartek on 10.04.2017.
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDAO cartDAO;
    @Override
    public Cart create(Cart cart) {
        return cartDAO.create(cart);
    }

    @Override
    public Cart read(int cartId) {
        return cartDAO.read(cartId);
    }

    @Override
    public void update(int cartId, Cart cart) {
cartDAO.update(cartId,cart);
    }

    @Override
    public void delete(int cartId) {
cartDAO.delete(cartId);
    }
}
