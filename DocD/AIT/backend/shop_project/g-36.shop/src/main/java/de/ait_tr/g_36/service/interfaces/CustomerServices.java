package de.ait_tr.g_36.service.interfaces;

import de.ait_tr.g_36.domain.entity.Customer;
import de.ait_tr.g_36.domain.entity.Product;
import java.math.BigDecimal;
import java.util.List;

/**
 * Функционал сервиса покупателей.
 * • +Сохранить покупателя в базе данных(присохранениипокупательавтоматическисчитаетсяактивным).
 * • +Вернуть всех покупателейизбазыданных(активных).
 * • +Вернуть одногопокупателяизбазыданныхпоегоидентификатору(если он активен).
 * • +Изменить одногопокупателявбазеданныхпоегоидентификатору.
 * • +Удалить покупателяизбазыданныхпоегоидентификатору.
 * • +Удалить покупателяизбазыданныхпоегоимени.
 * • +Восстановить удалённогопокупателявбазеданныхпоегоидентификатору.
 * • +Вернуть общееколичествопокупателейвбазеданных(активных).
 * • +Вернуть стоимостькорзиныпокупателяпоегоидентификатору(если он активен).
 * • +Вернуть среднююстоимостьпродуктавкорзинепокупателяпоегоидентификатору(если он активен)
 * • +Добавить товар  корзину покупателя по их идентификаторам(если оба активны)
 * • +Удалить товаризкорзиныпокупателяпоихидентификаторам
 * • +Полностью очиститькорзинупокупателяпоегоидентификатору(если он активен
 */

public interface CustomerServices {

  Customer saveCustomer(Customer customer);
  List<Customer> getAllCustomers();
  Customer getCustomerById(Long id);
  Customer updateCustomer(Customer customer);
  void deleteCustomerById(Long id);
  void deleteCustomerByName(String name);
  void restoreCustomer(Long id);
  long getAllActiveCustomersQuantity();
  BigDecimal getCustomerCartPriceTotalById(Long id);
  BigDecimal getCustomerCartPriceAverageById(Long id);
  Customer addProductToCart(Customer customer);
  void deleteProductByIdFromCart(Customer customer);
  void deleteProductsAllFromCart(Customer customer);
}
