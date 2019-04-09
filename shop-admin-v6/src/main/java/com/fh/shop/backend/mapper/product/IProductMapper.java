package com.fh.shop.backend.mapper.product;

import com.fh.shop.backend.po.product.Product;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IProductMapper {


	public Integer addProduct(Product product);


	public List<Product> queryProductList(Product product);


	public void deleteProduct(Integer id);

	public Product toUpdateProduct(Integer id);


	public void updateProduct(Product product);


	public void deleteAll(List<Integer> idsList);

	public Long countProduct(Product product);

    List<Product> productList(Product product);

    Integer selectMaxId();

	List<Product> queryProductApi();
}
