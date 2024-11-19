package it.auties.whatsapp.model.signal.keypair;

public class SignalPreKeyPairBuilder {
    private int id;
    private byte[] publicKey;
    private byte[] privateKey;

    public SignalPreKeyPairBuilder() {
        id = 0;
        publicKey = null;
        privateKey = null;
    }

    public SignalPreKeyPairBuilder id(int id) {
        this.id = id;
        return this;
    }

    public SignalPreKeyPairBuilder publicKey(byte[] publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    public SignalPreKeyPairBuilder privateKey(byte[] privateKey) {
        this.privateKey = privateKey;
        return this;
    }

    public it.auties.whatsapp.model.signal.keypair.SignalPreKeyPair build() {
        return new it.auties.whatsapp.model.signal.keypair.SignalPreKeyPair(id, publicKey, privateKey);
    }

}
