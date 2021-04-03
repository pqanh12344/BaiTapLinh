package javaframework.baitap_session.service.Impl;

import javaframework.baitap_session.converter.ProductConverter;
import javaframework.baitap_session.dto.ProductDTO;
import javaframework.baitap_session.entity.ProductEntity;
import javaframework.baitap_session.repository.IProductRepo;
import javaframework.baitap_session.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepo productRepo;

    @Autowired
    private ProductConverter productConverter;

    @Override
    public ProductDTO findOne(Long id) {
        if( id != null) {
            Optional<ProductEntity> entity = productRepo.findById(id);
            return productConverter.toDto(entity);
        }
        return null;
    }

    @Override
    public List<ProductDTO> findAll() {
        Iterable entityList = productRepo.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        entityList.forEach((Object e) -> productDTOList.add(productConverter.toDto((ProductEntity) e)));
        return productDTOList;
    }
}
