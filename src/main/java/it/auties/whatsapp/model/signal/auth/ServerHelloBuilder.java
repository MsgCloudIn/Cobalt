package it.auties.whatsapp.model.signal.auth;

public class ServerHelloBuilder {
    private byte[] ephemeral;
    private byte[] staticText;
    private byte[] payload;

    public ServerHelloBuilder() {
        ephemeral = null;
        staticText = null;
        payload = null;
    }

    public ServerHelloBuilder ephemeral(byte[] ephemeral) {
        this.ephemeral = ephemeral;
        return this;
    }

    public ServerHelloBuilder staticText(byte[] staticText) {
        this.staticText = staticText;
        return this;
    }

    public ServerHelloBuilder payload(byte[] payload) {
        this.payload = payload;
        return this;
    }

    public it.auties.whatsapp.model.signal.auth.ServerHello build() {
        return new it.auties.whatsapp.model.signal.auth.ServerHello(ephemeral, staticText, payload);
    }

}
