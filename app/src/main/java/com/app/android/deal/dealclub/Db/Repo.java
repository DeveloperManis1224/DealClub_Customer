package com.app.android.deal.dealclub.Db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
@Entity(tableName = "offers")
public class Repo {
    @PrimaryKey(autoGenerate = true)
    public int Id ;

    public String productId;
    public String productName;
    public String percentage;
    public String validFrom;
    public String validTill;
    public String productDescription;

    public Repo(int id, String productId,
                String productName, String percentage,
                String validFrom, String validTill,
                String productDescription) {
        Id = id;
        this.productId = productId;
        this.productName = productName;
        this.percentage = percentage;
        this.validFrom = validFrom;
        this.validTill = validTill;
        this.productDescription = productDescription;
    }
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getValidTill() {
        return validTill;
    }

    public void setValidTill(String validTill) {
        this.validTill = validTill;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
