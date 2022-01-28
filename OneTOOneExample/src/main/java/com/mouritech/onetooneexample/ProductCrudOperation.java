package com.mouritech.onetooneexample;

import com.mouritech.onetooneexample.dao.ProductDao;
import com.mouritech.onetooneexample.model.Product;
import com.mouritech.onetooneexample.model.Product_Details;

public class ProductCrudOperation {
public static void main(String[] args) {
	
	Product p = new Product("pen",47.4,"blue",8789333L);
	Product_Details pd =  new Product_Details( "bluePen","Readpen");
	p.setProduct_details(pd);
	
	ProductDao pdao = new ProductDao();
	pdao.productSave(p);
}


}
