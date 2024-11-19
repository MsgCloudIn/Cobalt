package it.auties.whatsapp.model.signal.auth;

public class SignedDeviceIdentityBuilder {
    private byte[] details;
    private byte[] accountSignatureKey;
    private byte[] accountSignature;
    private byte[] deviceSignature;

    public SignedDeviceIdentityBuilder() {
        details = null;
        accountSignatureKey = null;
        accountSignature = null;
        deviceSignature = null;
    }

    public SignedDeviceIdentityBuilder details(byte[] details) {
        this.details = details;
        return this;
    }

    public SignedDeviceIdentityBuilder accountSignatureKey(byte[] accountSignatureKey) {
        this.accountSignatureKey = accountSignatureKey;
        return this;
    }

    public SignedDeviceIdentityBuilder accountSignature(byte[] accountSignature) {
        this.accountSignature = accountSignature;
        return this;
    }

    public SignedDeviceIdentityBuilder deviceSignature(byte[] deviceSignature) {
        this.deviceSignature = deviceSignature;
        return this;
    }

    public it.auties.whatsapp.model.signal.auth.SignedDeviceIdentity build() {
        return new it.auties.whatsapp.model.signal.auth.SignedDeviceIdentity(details, accountSignatureKey, accountSignature, deviceSignature);
    }

}
