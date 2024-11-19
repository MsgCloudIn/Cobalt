package it.auties.whatsapp.model.signal.auth;

public class SignedDeviceIdentityHMACBuilder {
    private byte[] details;
    private byte[] hmac;

    public SignedDeviceIdentityHMACBuilder() {
        details = null;
        hmac = null;
    }

    public SignedDeviceIdentityHMACBuilder details(byte[] details) {
        this.details = details;
        return this;
    }

    public SignedDeviceIdentityHMACBuilder hmac(byte[] hmac) {
        this.hmac = hmac;
        return this;
    }

    public it.auties.whatsapp.model.signal.auth.SignedDeviceIdentityHMAC build() {
        return new it.auties.whatsapp.model.signal.auth.SignedDeviceIdentityHMAC(details, hmac);
    }

}
