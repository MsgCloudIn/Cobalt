package it.auties.whatsapp.model.sync;

public class ActionDataSyncBuilder {
    private byte[] index;
    private it.auties.whatsapp.model.sync.ActionValueSync value;
    private byte[] padding;
    private java.lang.Integer version;

    public ActionDataSyncBuilder() {
        index = null;
        value = null;
        padding = null;
        version = null;
    }

    public ActionDataSyncBuilder index(byte[] index) {
        this.index = index;
        return this;
    }

    public ActionDataSyncBuilder value(it.auties.whatsapp.model.sync.ActionValueSync value) {
        this.value = value;
        return this;
    }

    public ActionDataSyncBuilder padding(byte[] padding) {
        this.padding = padding;
        return this;
    }

    public ActionDataSyncBuilder version(java.lang.Integer version) {
        this.version = version;
        return this;
    }

    public it.auties.whatsapp.model.sync.ActionDataSync build() {
        return new it.auties.whatsapp.model.sync.ActionDataSync(index, value, padding, version);
    }

}
