package ru.itmo.service;

import ru.itmo.model.Product;

import javax.ejb.Remote;

@Remote
public interface ProductInterface {
    boolean addEmployee(Product product);
}
