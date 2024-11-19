package it.auties.whatsapp.model.button.template.hydrated;

public class HydratedURLButtonBuilder {
    private java.lang.String text;
    private java.lang.String url;

    public HydratedURLButtonBuilder() {
        text = null;
        url = null;
    }

    public HydratedURLButtonBuilder text(java.lang.String text) {
        this.text = text;
        return this;
    }

    public HydratedURLButtonBuilder url(java.lang.String url) {
        this.url = url;
        return this;
    }

    public it.auties.whatsapp.model.button.template.hydrated.HydratedURLButton build() {
        return new it.auties.whatsapp.model.button.template.hydrated.HydratedURLButton(text, url);
    }

}
