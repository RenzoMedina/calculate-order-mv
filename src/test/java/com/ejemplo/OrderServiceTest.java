/* 
package com.ejemplo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    private final OrderService service = new OrderService();

    @Test
    public void testWithoutDiscountAndStandardShipment() {
        double result = service.calculateTotal(100.0, false, false);
        assertEquals(110.0, result, 0.001);
    }

    @Test
    public void testWithDiscountAndStandardShipment() {
        double result = service.calculateTotal(100.0, true, false);
        assertEquals(100.0, result, 0.001);  // 100 - 10 + 10
    }

    @Test
    public void testWithoutDiscountAndExpressShipment() {
        double result = service.calculateTotal(100.0, false, true);
        assertEquals(120.0, result, 0.001);
    }

    @Test
    public void testWithDiscountAndExpressShipment() {
        double result = service.calculateTotal(100.0, true, true);
        assertEquals(110.0, result, 0.001); // 100 - 10 + 20
    }

    @Test
    public void testZeroSubtotal() {
        double result = service.calculateTotal(0.0, true, true);
        assertEquals(20.0, result, 0.001); // solo el costo de envío
    }

    @Test
    public void testNegativeSubtotal() {
        IllegalArgumentException exception = assertThrows(
IllegalArgumentException.class,() -> service.calculateTotal(-100.0, true, false));
assertEquals("Subtotal can't negative", exception.getMessage());
}
}
 */