package it.auties.whatsapp.model.product;

public class ProductListHeaderImageBuilder {
    private java.lang.String id;
    private byte[] thumbnail;

    public ProductListHeaderImageBuilder() {
        id = null;
        thumbnail = null;
    }

    public ProductListHeaderImageBuilder id(java.lang.String id) {
        this.id = id;
        return this;
    }

    public ProductListHeaderImageBuilder thumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public it.auties.whatsapp.model.product.ProductListHeaderImage build() {
        return new it.auties.whatsapp.model.product.ProductListHeaderImage(id, thumbnail);
    }

}
