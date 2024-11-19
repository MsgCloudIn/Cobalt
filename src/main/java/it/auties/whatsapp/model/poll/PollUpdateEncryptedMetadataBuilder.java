package it.auties.whatsapp.model.poll;

public class PollUpdateEncryptedMetadataBuilder {
    private byte[] payload;
    private byte[] iv;

    public PollUpdateEncryptedMetadataBuilder() {
        payload = null;
        iv = null;
    }

    public PollUpdateEncryptedMetadataBuilder payload(byte[] payload) {
        this.payload = payload;
        return this;
    }

    public PollUpdateEncryptedMetadataBuilder iv(byte[] iv) {
        this.iv = iv;
        return this;
    }

    public it.auties.whatsapp.model.poll.PollUpdateEncryptedMetadata build() {
        return new it.auties.whatsapp.model.poll.PollUpdateEncryptedMetadata(payload, iv);
    }

}
