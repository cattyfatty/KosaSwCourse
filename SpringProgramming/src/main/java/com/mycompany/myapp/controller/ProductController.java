package com.mycompany.myapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.myapp.dto.Product;
import com.mycompany.myapp.service.ProductService;

@Controller
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/product/list")
	public String list(HttpServletRequest req) {
		logger.info("list()");
		
		List<Product> list = productService.getPage(1, 10);
		req.setAttribute("list", list);
		
		return "product/list";
	}
	
	@RequestMapping("/product/writeForm")
	public String writeForm() {
		logger.info("writeForm()");
		
		return "product/writeForm";
	}
	
	@RequestMapping("/product/write")
	public String write(String name, int price, int amount, String kind, String content) {
		logger.info("write()");
		
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		product.setAmount(amount);
		product.setKind(kind);
		product.setContent(content);
		
		productService.add(product);
		
		return "redirect:/product/list";
	}
}
