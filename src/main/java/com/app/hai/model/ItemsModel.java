package com.app.hai.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "items_list")
@Data
public class ItemsModel {
    @Id
    private String itemBrandName;
    private String itemName;
    private String price;
    private String itemImageUrl;
    private String itemsSold;
}
