package com.projekt_koncowy.serwis_aukcyjny_marketplace.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "images")
public class ImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "thumbnailUrl")
    private String thumbnailUrl;

    @Column(name = "image")
    @Lob
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductModel product;

    @OneToOne
    @JoinColumn(name = "category_id")
    private CategoryModel categoryModel;

    @OneToOne
    @JoinColumn(name = "seller_id")
    private SellerModel sellerModel;


}
