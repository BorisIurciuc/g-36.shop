package de.ait_tr.g_36.service;

import de.ait_tr.g_36.domain.entity.Cart;
import de.ait_tr.g_36.domain.entity.Product;
import de.ait_tr.g_36.service.interfaces.CartService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * 14/08/2024 g-36.shop
 *
 * @author Boris Iurciuc (cohort36)
 */
@Service
public class CartServiceImpl implements CartService {

  @Override
  public Cart save(Cart cart) {
    return null;
  }

  @Override
  public List<Cart> getAllProductsFromCart() {
    return List.of();
  }

  @Override
  public Cart getById(long id) {
    return null;
  }

  @Override
  public void removeProductFromCart(Cart cart, Product product) {

  }

  @Override
  public void removeAllProductsFromCart(Cart cart) {

  }

  @Override
  public BigDecimal getCartTotalPrice(Cart cart, Product product) {
    return null;
  }

  @Override
  public BigDecimal getCartAveragePrice(Cart cart, Product product) {
    return null;
  }
}
