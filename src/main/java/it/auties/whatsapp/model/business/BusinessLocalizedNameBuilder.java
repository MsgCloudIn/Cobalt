package it.auties.whatsapp.model.business;

public class BusinessLocalizedNameBuilder {
    private java.lang.String lg;
    private java.lang.String lc;
    private java.lang.String name;

    public BusinessLocalizedNameBuilder() {
        lg = null;
        lc = null;
        name = null;
    }

    public BusinessLocalizedNameBuilder lg(java.lang.String lg) {
        this.lg = lg;
        return this;
    }

    public BusinessLocalizedNameBuilder lc(java.lang.String lc) {
        this.lc = lc;
        return this;
    }

    public BusinessLocalizedNameBuilder name(java.lang.String name) {
        this.name = name;
        return this;
    }

    public it.auties.whatsapp.model.business.BusinessLocalizedName build() {
        return new it.auties.whatsapp.model.business.BusinessLocalizedName(lg, lc, name);
    }

}
