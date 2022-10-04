package co.edu.unisabana.parcialarquitectura.service;

import co.edu.unisabana.parcialarquitectura.repository.Database;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BuyTest {

  private final Buy service = new Buy(new Database());


  @Test
  public void Given_same_vendor_and_buyer_When_makePurchase_Then_IllegalSaleException() {

    Throwable exception = assertThrows(IllegalSaleException.class, () -> {
      service.makePurchase(2, 2, "Books");
    });
    assertEquals("No es permitido realizar la venta al mismo vendedor2 y comprador 2", exception.getMessage());

  }
  @Test
  public void Given_a_vendor_and_a_different_buyer_When_makePurchase_Then_product_sold() {
    service.makePurchase(2, 3, "Books");
    assertEquals("Product sold", service.makePurchase(2, 3, "Books"));
  }

  @Test
  public void Given_a_vendor_and_a_different_buyer_but_a_null_item_When_makePurchase_Then_sale_was_not_possible() {
    assertEquals("The sale was not possible", service.makePurchase(2, 3, null));
  }
  @Test
  public void Given_a_vendor_and_a_different_buyer_but_0_buyerCode_When_makePurchase_Then_sale_was_not_possible() {
    assertEquals("The sale was not possible", service.makePurchase(2, 0, "Books"));
  }
  @Test
  public void Given_a_vendor_and_a_different_buyer_but_item_is_empty_When_makePurchase_Then_sale_was_not_possible() {
    assertEquals("The sale was not possible", service.makePurchase(2, 3, ""));
  }

}