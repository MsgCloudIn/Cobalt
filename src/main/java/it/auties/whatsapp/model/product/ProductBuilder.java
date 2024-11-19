package it.auties.whatsapp.model.product;

public class ProductBuilder {
    private it.auties.whatsapp.model.message.standard.ImageMessage image;
    private java.lang.String id;
    private java.lang.String title;
    private java.lang.String description;
    private java.lang.String currencyCode;
    private long priceAmount1000;
    private java.lang.String retailerId;
    private java.lang.String url;
    private int productImageCount;
    private java.lang.String firstImageId;
    private long salePriceAmount1000;

    public ProductBuilder() {
        image = null;
        id = null;
        title = null;
        description = null;
        currencyCode = null;
        priceAmount1000 = 0l;
        retailerId = null;
        url = null;
        productImageCount = 0;
        firstImageId = null;
        salePriceAmount1000 = 0l;
    }

    public ProductBuilder image(it.auties.whatsapp.model.message.standard.ImageMessage image) {
        this.image = image;
        return this;
    }

    public ProductBuilder id(java.lang.String id) {
        this.id = id;
        return this;
    }

    public ProductBuilder title(java.lang.String title) {
        this.title = title;
        return this;
    }

    public ProductBuilder description(java.lang.String description) {
        this.description = description;
        return this;
    }

    public ProductBuilder currencyCode(java.lang.String currencyCode) {
        this.currencyCode = currencyCode;
        return this;
    }

    public ProductBuilder priceAmount1000(long priceAmount1000) {
        this.priceAmount1000 = priceAmount1000;
        return this;
    }

    public ProductBuilder retailerId(java.lang.String retailerId) {
        this.retailerId = retailerId;
        return this;
    }

    public ProductBuilder url(java.lang.String url) {
        this.url = url;
        return this;
    }

    public ProductBuilder productImageCount(int productImageCount) {
        this.productImageCount = productImageCount;
        return this;
    }

    public ProductBuilder firstImageId(java.lang.String firstImageId) {
        this.firstImageId = firstImageId;
        return this;
    }

    public ProductBuilder salePriceAmount1000(long salePriceAmount1000) {
        this.salePriceAmount1000 = salePriceAmount1000;
        return this;
    }

    public it.auties.whatsapp.model.product.Product build() {
        return new it.auties.whatsapp.model.product.Product(image, id, title, description, currencyCode, priceAmount1000, retailerId, url, productImageCount, firstImageId, salePriceAmount1000);
    }

}
