package com.projekt_koncowy.serwis_aukcyjny_marketplace.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "category_position")
    private String categoryPosition;

    @Column(name = "category_name", nullable = false, unique = true)
    private String categoryName;


    @Column(name = "description")
    private String description;

    @Column(name = "image")
    @Lob
    private byte[] image;

    @Column(name = "category_status")
    private String categoryStatus;

    @Column(name = "seo_category_name")
    private String seoCategoryName;

    @Column(name = "seo_description")
    private String seoDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private CategoryModel parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<CategoryModel> children;
}
