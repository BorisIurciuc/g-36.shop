package de.ait_tr.g_36.controller;

import de.ait_tr.g_36.domain.entity.Cart;
import de.ait_tr.g_36.domain.entity.Product;
import de.ait_tr.g_36.service.interfaces.CartService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 14/08/2024 g-36.shop * @author Boris Iurciuc (cohort36)
 */
public class CartController {

  private final CartService service;

  public CartController(CartService service) {
    this.service = service;
  }

  @PostMapping
  public Cart save(@RequestBody Cart cart) {
    return service.save(cart);
  }

  @GetMapping
  public List<Cart> get(@RequestParam(required = false) Long id) {
    //TODO обращаемся к серверу
    if (id == null) {
      return service.getAllProductsFromCart();
    } else {
      Cart cart = service.getById(id);
      return cart == null ? null : List.of(cart);
    }
  }
  }
