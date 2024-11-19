package it.auties.whatsapp.model.info;

public class DeviceContextInfoBuilder {
    private it.auties.whatsapp.model.sync.DeviceListMetadata deviceListMetadata;
    private int deviceListMetadataVersion;
    private byte[] paddingBytes;
    private byte[] messageSecret;

    public DeviceContextInfoBuilder() {
        deviceListMetadata = null;
        deviceListMetadataVersion = 0;
        paddingBytes = null;
        messageSecret = null;
    }

    public DeviceContextInfoBuilder deviceListMetadata(it.auties.whatsapp.model.sync.DeviceListMetadata deviceListMetadata) {
        this.deviceListMetadata = deviceListMetadata;
        return this;
    }

    public DeviceContextInfoBuilder deviceListMetadataVersion(int deviceListMetadataVersion) {
        this.deviceListMetadataVersion = deviceListMetadataVersion;
        return this;
    }

    public DeviceContextInfoBuilder paddingBytes(byte[] paddingBytes) {
        this.paddingBytes = paddingBytes;
        return this;
    }

    public DeviceContextInfoBuilder messageSecret(byte[] messageSecret) {
        this.messageSecret = messageSecret;
        return this;
    }

    public it.auties.whatsapp.model.info.DeviceContextInfo build() {
        return new it.auties.whatsapp.model.info.DeviceContextInfo(deviceListMetadata, deviceListMetadataVersion, paddingBytes, messageSecret);
    }

}
