package it.auties.whatsapp.model.sync;

public class KeyIdBuilder {
    private byte[] id;

    public KeyIdBuilder() {
        id = null;
    }

    public KeyIdBuilder id(byte[] id) {
        this.id = id;
        return this;
    }

    public it.auties.whatsapp.model.sync.KeyId build() {
        return new it.auties.whatsapp.model.sync.KeyId(id);
    }

}
