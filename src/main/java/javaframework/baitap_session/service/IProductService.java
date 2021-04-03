package javaframework.baitap_session.service;

import javaframework.baitap_session.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    ProductDTO findOne(Long id);
    List<ProductDTO> findAll();
}
