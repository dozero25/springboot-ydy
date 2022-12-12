package com.study.springboot202210ydy.web.controller;


import com.study.springboot202210ydy.web.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductTestController {
    @GetMapping("/product/addition")
    public String loadAddition(){

        return "product/product_add";
    }

//    @PostMapping("/api/product")
//    public String registerProduct(HttpServletRequest request){
//        System.out.println(request.getParameter("price"));
//        return "product/product_view";
//    }

//    @PostMapping("/api/product")
//    public String registerProduct(@RequestParam String productCode,
//                                  @RequestParam String productName,
//                                  @RequestParam("price") int p,
//                                  @RequestParam int stock){
//        System.out.println(productName);
//        System.out.println(p);
//        return "product/product_view";
//    }

    @PostMapping ("/api/product")
    public String registerProduct(Model model, ProductDto productDto){
        model.addAttribute("productDto", productDto);
        System.out.println(productDto);
        return "product/product_view";
    }

    @GetMapping("/product/addition2")
    public String loadAddition2(){
        return "product/product_add2";
    }

    @ResponseBody
    @PostMapping("/api/product/2")
    public String registerProduct(@RequestBody ProductDto productDto){
        System.out.println(productDto);
        return "텍스트 데이터 응답";
    }
}
