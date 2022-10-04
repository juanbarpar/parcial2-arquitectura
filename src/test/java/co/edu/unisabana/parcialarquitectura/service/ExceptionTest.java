package co.edu.unisabana.parcialarquitectura.service;

import co.edu.unisabana.parcialarquitectura.repository.Database;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class ExceptionTest {

  @InjectMocks
  IllegalSaleException service;
  @Test
  public void Given_same_vendor_and_buyer_When_makePurchase_Then_IllegalSaleException() {

    Throwable exception = assertThrows(IllegalSaleException.class, () -> {
      throw new IllegalSaleException(2,2);
    });
    assertEquals("No es permitido realizar la venta al mismo vendedor2 y comprador 2", exception.getMessage());
  }

}