package it.auties.whatsapp.model.signal.keypair;

public class SignalKeyPairBuilder {
    private byte[] publicKey;
    private byte[] privateKey;

    public SignalKeyPairBuilder() {
        publicKey = null;
        privateKey = null;
    }

    public SignalKeyPairBuilder publicKey(byte[] publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    public SignalKeyPairBuilder privateKey(byte[] privateKey) {
        this.privateKey = privateKey;
        return this;
    }

    public it.auties.whatsapp.model.signal.keypair.SignalKeyPair build() {
        return new it.auties.whatsapp.model.signal.keypair.SignalKeyPair(publicKey, privateKey);
    }

}
