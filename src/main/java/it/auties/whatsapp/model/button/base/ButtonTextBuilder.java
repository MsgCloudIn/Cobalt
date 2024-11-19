package it.auties.whatsapp.model.button.base;

public class ButtonTextBuilder {
    private java.lang.String content;

    public ButtonTextBuilder() {
        content = null;
    }

    public ButtonTextBuilder content(java.lang.String content) {
        this.content = content;
        return this;
    }

    public it.auties.whatsapp.model.button.base.ButtonText build() {
        return new it.auties.whatsapp.model.button.base.ButtonText(content);
    }

}
