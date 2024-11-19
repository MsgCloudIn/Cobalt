package it.auties.whatsapp.model.business;

public class BusinessCategoryBuilder {
    private java.lang.String id;
    private java.lang.String name;

    public BusinessCategoryBuilder() {
        id = null;
        name = null;
    }

    public BusinessCategoryBuilder id(java.lang.String id) {
        this.id = id;
        return this;
    }

    public BusinessCategoryBuilder name(java.lang.String name) {
        this.name = name;
        return this;
    }

    public it.auties.whatsapp.model.business.BusinessCategory build() {
        return new it.auties.whatsapp.model.business.BusinessCategory(id, name);
    }

}
