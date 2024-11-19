package it.auties.whatsapp.model.message.button;

public class TemplateReplyMessageBuilder {
    private java.lang.String id;
    private java.lang.String buttonText;
    private it.auties.whatsapp.model.info.ContextInfo contextInfo;
    private int index;

    public TemplateReplyMessageBuilder() {
        id = null;
        buttonText = null;
        contextInfo = null;
        index = 0;
    }

    public TemplateReplyMessageBuilder id(java.lang.String id) {
        this.id = id;
        return this;
    }

    public TemplateReplyMessageBuilder buttonText(java.lang.String buttonText) {
        this.buttonText = buttonText;
        return this;
    }

    public TemplateReplyMessageBuilder contextInfo(it.auties.whatsapp.model.info.ContextInfo contextInfo) {
        this.contextInfo = contextInfo;
        return this;
    }

    public TemplateReplyMessageBuilder index(int index) {
        this.index = index;
        return this;
    }

    public it.auties.whatsapp.model.message.button.TemplateReplyMessage build() {
        return new it.auties.whatsapp.model.message.button.TemplateReplyMessage(id, buttonText, contextInfo, index);
    }

}
