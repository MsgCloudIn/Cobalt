package it.auties.whatsapp.model.message.button;

public class ListMessageBuilder {
    private java.lang.String title;
    private java.lang.String description;
    private java.lang.String button;
    private it.auties.whatsapp.model.message.button.ListMessage.Type listType;
    private java.util.List<it.auties.whatsapp.model.button.base.ButtonSection> sections;
    private it.auties.whatsapp.model.info.ProductListInfo productListInfo;
    private java.lang.String footer;
    private it.auties.whatsapp.model.info.ContextInfo contextInfo;

    public ListMessageBuilder() {
        title = null;
        description = null;
        button = null;
        listType = null;
        sections = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        productListInfo = null;
        footer = null;
        contextInfo = null;
    }

    public ListMessageBuilder title(java.lang.String title) {
        this.title = title;
        return this;
    }

    public ListMessageBuilder description(java.lang.String description) {
        this.description = description;
        return this;
    }

    public ListMessageBuilder button(java.lang.String button) {
        this.button = button;
        return this;
    }

    public ListMessageBuilder listType(it.auties.whatsapp.model.message.button.ListMessage.Type listType) {
        this.listType = listType;
        return this;
    }

    public ListMessageBuilder sections(java.util.List<it.auties.whatsapp.model.button.base.ButtonSection> sections) {
        this.sections = sections;
        return this;
    }

    public ListMessageBuilder productListInfo(it.auties.whatsapp.model.info.ProductListInfo productListInfo) {
        this.productListInfo = productListInfo;
        return this;
    }

    public ListMessageBuilder footer(java.lang.String footer) {
        this.footer = footer;
        return this;
    }

    public ListMessageBuilder contextInfo(it.auties.whatsapp.model.info.ContextInfo contextInfo) {
        this.contextInfo = contextInfo;
        return this;
    }

    public it.auties.whatsapp.model.message.button.ListMessage build() {
        return new it.auties.whatsapp.model.message.button.ListMessage(title, description, button, listType, sections, productListInfo, footer, contextInfo);
    }

}
