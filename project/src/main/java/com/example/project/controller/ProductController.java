package com.example.project.controller;

import java.util.List;

import com.example.project.domain.Product;
import com.example.project.service.ProductService;
import com.example.project.service.ReadExcelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ReadExcelService read;

	@GetMapping(value = "/list")
	public ResponseEntity<List<Product>> list() {
		return ResponseEntity.ok(productService.list());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> getById(@PathVariable Integer id) {
		return ResponseEntity.ok(productService.findById(id));
	}

	@PostMapping(value = "/upload/{id}")
	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file, @PathVariable Integer id) {
		return new ResponseEntity<>(productService.upload(file, id), HttpStatus.OK);
	}

	@PostMapping(value = "xlsx_to_db")
	public ResponseEntity<String> xlsxToDb() {
		// Product entity = new Product();
		// productService.saveBatch(entity);
		return ResponseEntity.ok(read.read());
	}

	// @PutMapping(value = "/id")
	// public ResponseEntity<Product> update(@RequestBody ProductRequestCreate
	// product, @PathVariable Integer id) {
	// return ResponseEntity.ok(productService.updateProduct(product, id));
	// }
}