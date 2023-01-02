package com.app.hai.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "items_category")
@Data
public class ItemsCatModel {
    @Id
    private String itemName;
    private String itemCat;
    private String itemCatImageUrl;
}
