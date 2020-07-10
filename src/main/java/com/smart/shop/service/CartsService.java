package com.smart.shop.service;

import com.smart.shop.domain.entity.Carts;
import com.smart.shop.domain.entity.Product;

import java.util.List;

public interface CartsService {

    int add(int mid, int quantity,Product product);

    List<Carts> list(int mid);

    int update(int mid, int cartId);

    int delete(List<Integer> ids);
}
