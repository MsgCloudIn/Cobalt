package it.auties.whatsapp.model.message.server;

public class DeviceSyncMessageBuilder {
    private byte[] serializedXmlBytes;

    public DeviceSyncMessageBuilder() {
        serializedXmlBytes = null;
    }

    public DeviceSyncMessageBuilder serializedXmlBytes(byte[] serializedXmlBytes) {
        this.serializedXmlBytes = serializedXmlBytes;
        return this;
    }

    public it.auties.whatsapp.model.message.server.DeviceSyncMessage build() {
        return new it.auties.whatsapp.model.message.server.DeviceSyncMessage(serializedXmlBytes);
    }

}
