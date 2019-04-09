package com.fh.shop.backend.mapper.product;

import java.util.List;

import com.fh.shop.backend.po.product.Product;

public interface IProductMapper {

	public void addProduct(Product product);

	public List<Product> listProduct(Product product);
	
	public void deleteProductID(Integer id);

	public void deleteBatchProduct(List<Integer> idList);

	public Product findproduct(Integer id);

	public void updateProduct(Product product);

	public Long findProductListCount(Product product);



}
