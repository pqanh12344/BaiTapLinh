package javaframework.baitap_session.converter;

import javaframework.baitap_session.dto.ProductDTO;
import javaframework.baitap_session.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductConverter {
    public ProductDTO toDto(Optional<ProductEntity> entity) {
        ProductDTO result = new ProductDTO();
        result.setId(entity.get().getId());
        result.setName(entity.get().getName());
        result.setPrice(entity.get().getPrice());
        result.setImage(entity.get().getImage());
        return result;
    }

    public ProductDTO toDto(ProductEntity entity) {
        ProductDTO result = new ProductDTO();
        result.setId(entity.getId());
        result.setName(entity.getName());
        result.setPrice(entity.getPrice());
        result.setImage(entity.getImage());
        return result;
    }
}
