package javaframework.baitap_session.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ProductDTO {
    private Long id;
    private String name;
    private int price;
    private String image;
    private int number;
}
