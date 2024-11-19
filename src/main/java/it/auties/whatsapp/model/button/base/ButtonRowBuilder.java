package it.auties.whatsapp.model.button.base;

public class ButtonRowBuilder {
    private java.lang.String title;
    private java.lang.String description;
    private java.lang.String id;

    public ButtonRowBuilder() {
        title = null;
        description = null;
        id = null;
    }

    public ButtonRowBuilder title(java.lang.String title) {
        this.title = title;
        return this;
    }

    public ButtonRowBuilder description(java.lang.String description) {
        this.description = description;
        return this;
    }

    public ButtonRowBuilder id(java.lang.String id) {
        this.id = id;
        return this;
    }

    public it.auties.whatsapp.model.button.base.ButtonRow build() {
        return new it.auties.whatsapp.model.button.base.ButtonRow(title, description, id);
    }

}
