package it.auties.whatsapp.model.message.standard;

public class ContactMessageBuilder {
    private java.lang.String name;
    private it.auties.whatsapp.model.contact.ContactCard vcard;
    private it.auties.whatsapp.model.info.ContextInfo contextInfo;

    public ContactMessageBuilder() {
        name = null;
        vcard = null;
        contextInfo = null;
    }

    public ContactMessageBuilder name(java.lang.String name) {
        this.name = name;
        return this;
    }

    public ContactMessageBuilder vcard(it.auties.whatsapp.model.contact.ContactCard vcard) {
        this.vcard = vcard;
        return this;
    }

    public ContactMessageBuilder contextInfo(it.auties.whatsapp.model.info.ContextInfo contextInfo) {
        this.contextInfo = contextInfo;
        return this;
    }

    public it.auties.whatsapp.model.message.standard.ContactMessage build() {
        return new it.auties.whatsapp.model.message.standard.ContactMessage(name, vcard, contextInfo);
    }

}
