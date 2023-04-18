package com.projekt_koncowy.serwis_aukcyjny_marketplace.model;

import com.projekt_koncowy.serwis_aukcyjny_marketplace.enumTypes.AuctionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_title")
    private String productTitle;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryModel categoryModel;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private SellerModel seller;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ImageModel> images;
    @Enumerated(EnumType.STRING)
    @Column(name = "auction_type")
    private AuctionType auctionType;
    @Column(name = "location")
    private String location;
    @Column(name = "minimum_bid")
    private BigDecimal minimumBid;
    @Column(name = "buy_now_price")
    private BigDecimal buyNowPrice;
    @Column(name = "listing_start_time")
    private LocalDateTime listingStartTime;
    @Column(name = "listing_end_time")
    private LocalDateTime listingEndTime;
    @Column(name = "views_count")
    private int viewsCount;


}
