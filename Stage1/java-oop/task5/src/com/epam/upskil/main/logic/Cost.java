package com.epam.upskil.main.logic;

import com.epam.upskil.main.content.Packaging;
import com.epam.upskil.main.content.Product;
import java.util.ArrayList;

public class Cost {
    private double price;

    public Cost(ArrayList<Product> products, Packaging packaging){

        for (Product product : products) {
            if (product != null)
                price += product.getPrice();
        }
        if (packaging != null)
            price += packaging.getPrice();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
