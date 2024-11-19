package it.auties.whatsapp.model.button.interactive;

public class InteractiveFooterBuilder {
    private java.lang.String content;

    public InteractiveFooterBuilder() {
        content = null;
    }

    public InteractiveFooterBuilder content(java.lang.String content) {
        this.content = content;
        return this;
    }

    public it.auties.whatsapp.model.button.interactive.InteractiveFooter build() {
        return new it.auties.whatsapp.model.button.interactive.InteractiveFooter(content);
    }

}
