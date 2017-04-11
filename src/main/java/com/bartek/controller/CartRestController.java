package com.bartek.controller;

import com.bartek.dao.Cart;
import com.bartek.dao.CartItem;
import com.bartek.dao.Product;
import com.bartek.service.CartService;
import com.bartek.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.Contended;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Bartek on 10.04.2017.
 */
@RestController
@RequestMapping("rest/cart")
public class CartRestController {
    @Autowired
    private CartService cartService;
    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    Cart create(@RequestBody Cart cart) {
        return cartService.create(cart);
    }

    @RequestMapping(value = "/{cartID}", method = RequestMethod.GET)
    public
    @ResponseBody
    Cart read(@PathVariable(value = "cartId") int cartId) {
        return cartService.read(cartId);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "cartId") int cartId, @RequestBody Cart cart) {
        cartService.update(cartId, cart);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "cartId") int cartId) {
        cartService.delete(cartId);
    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "productId") int productId, HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        Cart cart = cartService.read(new Integer(sessionId));
        if (cart==null){
            cart=cartService.create(new Cart(new Integer(sessionId)));
        }
        Product product = productService.getProductByID(productId);
        if(product==null){
            // TODO throw new IllegalArgumentException(new Product)
        }
cart.addCartItem(new CartItem(product));
    cartService.update(new Integer(sessionId), cart);
    }
    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable int productId, HttpServletRequest request){
        String sessionId=request.getSession(true).getId();
        Cart cart = cartService.read(new Integer(sessionId));
        if (cart==null){
            cart=cartService.create(new Cart(new Integer(sessionId)));
        }
        Product product=productService.getProductByID(productId);
        cart.removeCartItem(new CartItem(product));
        cartService.update(new Integer(sessionId),cart);
    }
}
