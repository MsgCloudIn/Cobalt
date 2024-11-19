package it.auties.whatsapp.model.message.server;

public class SenderKeyDistributionMessageBuilder {
    private java.lang.String groupId;
    private byte[] data;

    public SenderKeyDistributionMessageBuilder() {
        groupId = null;
        data = null;
    }

    public SenderKeyDistributionMessageBuilder groupId(java.lang.String groupId) {
        this.groupId = groupId;
        return this;
    }

    public SenderKeyDistributionMessageBuilder data(byte[] data) {
        this.data = data;
        return this;
    }

    public it.auties.whatsapp.model.message.server.SenderKeyDistributionMessage build() {
        return new it.auties.whatsapp.model.message.server.SenderKeyDistributionMessage(groupId, data);
    }

}
