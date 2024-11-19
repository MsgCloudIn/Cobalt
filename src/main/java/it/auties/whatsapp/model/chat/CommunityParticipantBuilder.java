package it.auties.whatsapp.model.chat;

public class CommunityParticipantBuilder {
    private it.auties.whatsapp.model.jid.Jid jid;

    public CommunityParticipantBuilder() {
        jid = null;
    }

    public CommunityParticipantBuilder jid(it.auties.whatsapp.model.jid.Jid jid) {
        this.jid = jid;
        return this;
    }

    public it.auties.whatsapp.model.chat.CommunityParticipant build() {
        return new it.auties.whatsapp.model.chat.CommunityParticipant(jid);
    }

}
