package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.entity.Product;
import com.spring.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;

	@RequestMapping("/")	
	public ModelAndView home(Model model) {
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProduct", listProducts);		
		return new ModelAndView("index");
	}
	
	@RequestMapping("/index")
	public ModelAndView viewHome() {
		return new ModelAndView("index");
	}

	@RequestMapping("/add")
	public String insertProduct() {
		return "product";
	}

	@PostMapping("/save")
	public String saveProduct(@ModelAttribute("product") Product product) {
		if (product.getId() == null)
			service.save(product);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public ModelAndView updateProduct(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("updateProduct");
		Product p = service.getOne(id);
		mv.addObject("product", p);
		return mv;
	}

	@GetMapping("/getone/{id}")
	public Product findOne(@PathVariable Long id) {
		return service.getOne(id);
	}

	@PostMapping("/update")
	public String updateProduct(@ModelAttribute("product") Product product) {
		Product p = new Product();
		if (product.getId() != 0) {
			p.setId(product.getId());
			p.setName(product.getName());
			p.setBrand(product.getBrand());
			p.setMade(product.getMade());
			p.setPrice(product.getPrice());
			p.setPhone(product.getPhone());
			service.update(p);
			return "redirect:/";
		} else {
			return new ModelAndView().toString();
		}		
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		if (service.getOne(id) != null)
			service.delete(id);
		return "redirect:/";
	}

	@RequestMapping("/search")
	public ModelAndView searchProduct(Model model, @RequestParam String search) {
		try {
			if (search != null) {
				List<Product> searchList = service.searchProduct(search);
				model.addAttribute("search_List", searchList);
				return new ModelAndView("ProductList");
			} else {
				return new ModelAndView("/");
			}
		} catch (Exception e) {
			return new ModelAndView(e.toString());
		}
	}
	
	// sorting with pagination
	@GetMapping("/sorting")
	public ModelAndView getAllProductSort(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "5") Integer pageSize,@RequestParam(defaultValue = "id") String sortBy){
		ModelAndView model=new ModelAndView("ProductList");
		List<Product> sortList=service.getAllProductSort(pageNo,pageSize,sortBy);		
		model.addObject("search_List", sortList);
		//return new ResponseEntity<List<Product>>(sortList, new HttpHeaders(),HttpStatus.OK);	
		return model;
	}
	
	//pagination
	@GetMapping("/paging/{id}")
	public ModelAndView getPage(@PathVariable("id") Integer page,Model model) {
		Integer pageSize=5;
		List<Product> pageList=service.getPage(page,pageSize);
		//ModelAndView ml=new ModelAndView("index");
		model.addAttribute("listProduct", pageList);
		return viewHome();
	}
	
	// multiSorting 
	@PostMapping("/multisort")
	public ModelAndView multiSort(@RequestParam("flag") Boolean flag,Model model) {
		model.addAttribute("listProduct", service.multiSort(flag));
		return viewHome();
	}
		
}
