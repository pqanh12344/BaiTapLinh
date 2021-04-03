package javaframework.baitap_session.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product")
public class ProductEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "name")
        private String name;

        @Column(name = "price")
        private int price;

        @Column(name = "image")
        private String image;
}
