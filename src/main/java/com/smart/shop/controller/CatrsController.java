package com.smart.shop.controller;

import com.smart.shop.domain.entity.Carts;
import com.smart.shop.domain.entity.Product;
import com.smart.shop.service.CartsService;
import com.smart.shop.utils.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 结果集
 */
@RestController
@RequestMapping("/carts")
public class CatrsController {

    @Resource
    CartsService cartsService;
    /**
     * 查询用户购物车的商品信息
     * 修改购物的数量
     * 添加购物车
     * 删除商品信息
     * 批量删除 多条记录
     */

    /**
     * 过滤器 AOP的思想
     * 查询用户购物车的商品信息
     */
    @GetMapping("/list/{mid}")
    public ResponseEntity<List<Carts>> list(@PathVariable() int mid) {
        try {

            List<Carts> list = cartsService.list(mid);
            return ResponseEntity.success(list);
        } catch (Exception ex) {
            return ResponseEntity.error();
        }
    }


    /**
     * 修改购物车的数量
     * 用户ID
     * 购物车主键
     *
     * @return
     */
    @PostMapping("/update")
    public ResponseEntity<Integer> update(int mid, int cartId) {
        try {
            int update = cartsService.update(mid, cartId);
            return ResponseEntity.success(update);
        } catch (Exception e) {
            return ResponseEntity.error();
        }
    }


    /**
     * 该用户如果已经添加过该商品，更新数量
     * 如果没有购买过，添加该条记录
     *
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<Integer> addCarts(int mid, int quantity, Product product) {
        try {
            int count = cartsService.add(mid, quantity, product);
            return ResponseEntity.success(count);
        } catch (Exception e) {
            return ResponseEntity.error();
        }
    }

    @DeleteMapping("/del")
    public ResponseEntity<Integer> delete(@RequestParam List<Integer> ids) {
        try {
            int count = cartsService.delete(ids);
            return ResponseEntity.success(count);
        } catch (Exception e) {
            return ResponseEntity.error();
        }

    }

}
