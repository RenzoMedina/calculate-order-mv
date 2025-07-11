package com.ejemplo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class OrderServiceMockTest {
    
    @Test
    void testWithMockDiscount(){
        //Arange
        DiscountService buster = mock(DiscountService.class);
        when(buster.getRate("SALES10")).thenReturn(0.10);
        OrderService service = new OrderService(buster);
        //Act
        double total = service.calculateTotal(100,"SALES10", true);

        //Assert
        assertEquals(110.0, total);
    }
}
