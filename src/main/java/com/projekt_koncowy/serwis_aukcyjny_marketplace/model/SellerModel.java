package com.projekt_koncowy.serwis_aukcyjny_marketplace.model;

import com.projekt_koncowy.serwis_aukcyjny_marketplace.enumTypes.AccountStatus;
import com.projekt_koncowy.serwis_aukcyjny_marketplace.enumTypes.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seller")
public class SellerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "seller_title")
    private String sellerTitle;

    @Column(name = "vat_number")
    private String vatNumber;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;


    @Column(name = "country")
    private String country;
    @Column(name = "zip-code")
    private String zipCode;

    @Column(name = "city")
    private String city;

    @Column(name = "street_with_number")
    private String streetWithNumber;

    @OneToMany(mappedBy = "seller")
    private List<ProductModel> products;
    @Column(name = "creation_Date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    @Column(name = "status")
    private String status;
    @Column(name = "logo_Url")
    private String logoUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type")
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_Status")
    private AccountStatus accountStatus;
}
