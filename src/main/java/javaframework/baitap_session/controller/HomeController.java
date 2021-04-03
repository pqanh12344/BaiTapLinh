package javaframework.baitap_session.controller;

import javaframework.baitap_session.dto.ProductDTO;
import javaframework.baitap_session.service.IProductService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/home")
    public String loadHome(Model model){
        model.addAttribute("products",productService.findAll());
        return "views/index";
    }

    @GetMapping("/detail-product")
    public String detailProduct(Model model, @RequestParam("id") Long id){
        model.addAttribute("Product",productService.findOne(id));
        return "views/detail";
    }

    @GetMapping("/shopping-cart")
    public String shoppingCart(HttpSession session, Model model){
        int sumNumber = 0;
        List<ProductDTO> productDTOList = (List<ProductDTO>) session.getAttribute("ListProduct");
        List<ProductDTO> productDTOList_Remove = new ArrayList<>();
        if( productDTOList != null) {
            for (ProductDTO p : productDTOList) {
                sumNumber += p.getNumber() * p.getPrice();
                if( p.getNumber() == 0) productDTOList_Remove.add(p);
            }
            productDTOList_Remove.forEach(p-> productDTOList.remove(p));
            model.addAttribute("ListProduct",productDTOList);
        }
        model.addAttribute("SumNumber",sumNumber);
        return "views/shop-cart";
    }
}
