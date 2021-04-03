package javaframework.baitap_session.repository;

import javaframework.baitap_session.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepo extends CrudRepository<ProductEntity,Long> {
}
