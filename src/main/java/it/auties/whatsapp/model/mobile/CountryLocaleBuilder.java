package it.auties.whatsapp.model.mobile;

public class CountryLocaleBuilder {
    private java.lang.String languageValue;
    private java.lang.String languageCode;
    private java.lang.String separator;

    public CountryLocaleBuilder() {
        languageValue = null;
        languageCode = null;
        separator = null;
    }

    public CountryLocaleBuilder languageValue(java.lang.String languageValue) {
        this.languageValue = languageValue;
        return this;
    }

    public CountryLocaleBuilder languageCode(java.lang.String languageCode) {
        this.languageCode = languageCode;
        return this;
    }

    public CountryLocaleBuilder separator(java.lang.String separator) {
        this.separator = separator;
        return this;
    }

    public it.auties.whatsapp.model.mobile.CountryLocale build() {
        return new it.auties.whatsapp.model.mobile.CountryLocale(languageValue, languageCode, separator);
    }

}
