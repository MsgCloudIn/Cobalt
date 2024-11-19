package it.auties.whatsapp.model.signal.auth;

public class NoiseCertificateBuilder {
    private byte[] details;
    private byte[] signature;

    public NoiseCertificateBuilder() {
        details = null;
        signature = null;
    }

    public NoiseCertificateBuilder details(byte[] details) {
        this.details = details;
        return this;
    }

    public NoiseCertificateBuilder signature(byte[] signature) {
        this.signature = signature;
        return this;
    }

    public it.auties.whatsapp.model.signal.auth.NoiseCertificate build() {
        return new it.auties.whatsapp.model.signal.auth.NoiseCertificate(details, signature);
    }

}
