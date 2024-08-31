package de.ait_tr.g_36_shop.service.interfaces;

import de.ait_tr.g_36_shop.domain.entity.Cart;
import de.ait_tr.g_36_shop.domain.entity.Product;
import java.math.BigDecimal;
import java.util.List;

public interface CartService {

  Cart save(Cart cart);
  List<Cart> getAllProductsFromCart();
  Cart getById(long id);
  void removeProductFromCart(Cart cart, Product product);
  void removeAllProductsFromCart(Cart cart);
  BigDecimal getCartTotalPrice(Cart cart, Product product);
  BigDecimal getCartAveragePrice(Cart cart, Product product);
}

/**
 * Добавить продукт в корзину (если активный)
 * • Получение всех продуктов, находящихся в корзине (активных)
 * • Удалить продукт из корзины по его идентификатору
 * • Полная очистка корзины (удаление всех продуктов)
 * • Получение общей стоимости корзины (активных продуктов)
 * • Получение средней стоимости товара в корзине (из активных продуктов
 */