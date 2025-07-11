
package com.ejemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;

public class OrderServiceTest {

    private DiscountService repository;
    private OrderService service;

    @BeforeEach
    public void setup() {
        repository = mock(DiscountService.class);
        service = new OrderService(repository);
    }

    @Test
    public void testWithoutDiscountAndStandardShipment() {
        when(repository.getRate(null)).thenReturn(0.0);

        double result = service.calculateTotal(100.0, null, false);
        assertEquals(110.0, result, 0.001);
    }

    @Test
    public void testWithDiscountAndStandardShipment() {
        when(repository.getRate("SALES10")).thenReturn(0.10);

        double result = service.calculateTotal(100.0, "SALES10", false);
        assertEquals(100.0, result, 0.001); // 100 - 10 + 10
    }

    @Test
    public void testWithDiscountAndExpressShipment() {
        when(repository.getRate("SALES10")).thenReturn(0.10);

        double result = service.calculateTotal(200.0, "SALES10", true);
        assertEquals(200.0 * 0.9 + 20.0, result, 0.001); // 180 + 20 = 200
    }

    @Test
    public void testWithUnknownDiscountCode() {
        when(repository.getRate("UNKNOWN")).thenReturn(0.0);

        double result = service.calculateTotal(50.0, "UNKNOWN", true);
        assertEquals(50.0 + 20.0, result, 0.001); // sin descuento
    }

    @Test
    public void testZeroSubtotal() {
        when(repository.getRate("SALES10")).thenReturn(0.10);

        double result = service.calculateTotal(0.0, "SALES10", false);
        assertEquals(10.0, result, 0.001); // solo envío estándar
    }

    @Test
    public void testNegativeSubtotalThrowsException() {
        when(repository.getRate("SALES10")).thenReturn(0.10);

        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> service.calculateTotal(-50.0, "SALES10", true)
        );
        assertEquals("Subtotal can't negative", exception.getMessage());
    }

}
