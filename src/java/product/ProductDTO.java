/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

/**
 *
 * @author hd
 */
public class ProductDTO {
    private String mobileId;
    private String description;
    private double price;
    private String mobileName;
    private String mobileBrand;
    private int quantity;
    private double sale;
    private String image;
    private String formattedPrice;

    public String getFormattedPrice() {
        return formattedPrice;
    }

    public void setFormattedPrice(String formattedPrice) {
        this.formattedPrice = formattedPrice;
    }

    public ProductDTO(String mobileId, String description, double price, String mobileName, String mobileBrand, int quantity, double sale,String image) {
        this.mobileId = mobileId;
        this.description = description;
        this.price = price;
        this.mobileName = mobileName;
        this.mobileBrand = mobileBrand;
        this.quantity = quantity;
        this.sale=sale;
        this.image=image;
        
    }
    public double newPrice() {
        return this.price*(1-this.sale);
    }

  

    public ProductDTO() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMobileName() {
        return mobileName;
    }

    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMobileBrand() {
        return mobileBrand;
    }

    public void setMobileBrand(String mobileBrand) {
        this.mobileBrand = mobileBrand;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }





}