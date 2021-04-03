package javaframework.baitap_session.controller;

import javaframework.baitap_session.dto.ProductDTO;
import javaframework.baitap_session.service.Impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@RestController
public class AddToCartAPI {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/AddToCart", consumes = "application/json", produces = "application/json")
    @ResponseBody
    public List<ProductDTO> addToCart(HttpSession session, @RequestBody ProductDTO productDTO) {
        ProductDTO product = productService.findOne(productDTO.getId());
        product.setNumber(productDTO.getNumber());
        if (product != null) {
            if (session.getAttribute("ListProduct") == null) {
                List<ProductDTO> productDTOList = new ArrayList<>();
                productDTOList.add(product);
                session.setAttribute("ListProduct", productDTOList);
            } else {
                List<ProductDTO> productDTOList = (List<ProductDTO>) session.getAttribute("ListProduct");
                AtomicBoolean exist = new AtomicBoolean(false);
                productDTOList.forEach(p -> {
                    if ( p.getId() == product.getId()) {
                        p.setNumber(product.getNumber());
                        exist.set(true);
                    }
                });
                if( exist.get() == false) productDTOList.add(product);
                session.setAttribute("ListProduct", productDTOList);
            }
        }
        return (List<ProductDTO>) session.getAttribute("ListProduct");
    }
}
