package it.auties.whatsapp.model.business;

public class BusinessVerifiedNameCertificateBuilder {
    private byte[] encodedDetails;
    private byte[] signature;
    private byte[] serverSignature;

    public BusinessVerifiedNameCertificateBuilder() {
        encodedDetails = null;
        signature = null;
        serverSignature = null;
    }

    public BusinessVerifiedNameCertificateBuilder encodedDetails(byte[] encodedDetails) {
        this.encodedDetails = encodedDetails;
        return this;
    }

    public BusinessVerifiedNameCertificateBuilder signature(byte[] signature) {
        this.signature = signature;
        return this;
    }

    public BusinessVerifiedNameCertificateBuilder serverSignature(byte[] serverSignature) {
        this.serverSignature = serverSignature;
        return this;
    }

    public it.auties.whatsapp.model.business.BusinessVerifiedNameCertificate build() {
        return new it.auties.whatsapp.model.business.BusinessVerifiedNameCertificate(encodedDetails, signature, serverSignature);
    }

}
