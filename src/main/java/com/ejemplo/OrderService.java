package com.ejemplo;

public class OrderService {
    
    private DiscountService discountService;

    public OrderService(DiscountService discountService){
        this.discountService = discountService;
    }

    public double calculateTotal(double subtotal, String discountCode, boolean expressShipment){
        if (subtotal < 0 ){
            throw new IllegalArgumentException("Subtotal can't negative");
        }
        double discount = discountService.getRate(discountCode);
        double shipment = expressShipment ? 20.0 : 10.0;
        return (subtotal * (1 - discount)) + shipment;
    }
}
