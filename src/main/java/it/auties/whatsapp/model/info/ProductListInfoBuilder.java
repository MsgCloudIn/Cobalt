package it.auties.whatsapp.model.info;

public class ProductListInfoBuilder {
    private java.util.List<it.auties.whatsapp.model.product.ProductSection> productSections;
    private it.auties.whatsapp.model.product.ProductListHeaderImage headerImage;
    private it.auties.whatsapp.model.jid.Jid seller;

    public ProductListInfoBuilder() {
        productSections = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        headerImage = null;
        seller = null;
    }

    public ProductListInfoBuilder productSections(java.util.List<it.auties.whatsapp.model.product.ProductSection> productSections) {
        this.productSections = productSections;
        return this;
    }

    public ProductListInfoBuilder headerImage(it.auties.whatsapp.model.product.ProductListHeaderImage headerImage) {
        this.headerImage = headerImage;
        return this;
    }

    public ProductListInfoBuilder seller(it.auties.whatsapp.model.jid.Jid seller) {
        this.seller = seller;
        return this;
    }

    public it.auties.whatsapp.model.info.ProductListInfo build() {
        return new it.auties.whatsapp.model.info.ProductListInfo(productSections, headerImage, seller);
    }

}
