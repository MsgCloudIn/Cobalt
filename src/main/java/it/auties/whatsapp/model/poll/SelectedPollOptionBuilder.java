package it.auties.whatsapp.model.poll;

public class SelectedPollOptionBuilder {
    private it.auties.whatsapp.model.jid.Jid jid;
    private java.lang.String name;

    public SelectedPollOptionBuilder() {
        jid = null;
        name = null;
    }

    public SelectedPollOptionBuilder jid(it.auties.whatsapp.model.jid.Jid jid) {
        this.jid = jid;
        return this;
    }

    public SelectedPollOptionBuilder name(java.lang.String name) {
        this.name = name;
        return this;
    }

    public it.auties.whatsapp.model.poll.SelectedPollOption build() {
        return new it.auties.whatsapp.model.poll.SelectedPollOption(jid, name);
    }

}
