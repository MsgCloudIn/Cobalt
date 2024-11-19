package it.auties.whatsapp.model.message.standard;

public class GroupInviteMessageBuilder {
    private it.auties.whatsapp.model.jid.Jid group;
    private java.lang.String code;
    private long expirationSeconds;
    private java.lang.String groupName;
    private byte[] thumbnail;
    private java.lang.String caption;
    private it.auties.whatsapp.model.info.ContextInfo contextInfo;
    private it.auties.whatsapp.model.message.standard.GroupInviteMessage.Type groupType;

    public GroupInviteMessageBuilder() {
        group = null;
        code = null;
        expirationSeconds = 0l;
        groupName = null;
        thumbnail = null;
        caption = null;
        contextInfo = null;
        groupType = null;
    }

    public GroupInviteMessageBuilder group(it.auties.whatsapp.model.jid.Jid group) {
        this.group = group;
        return this;
    }

    public GroupInviteMessageBuilder code(java.lang.String code) {
        this.code = code;
        return this;
    }

    public GroupInviteMessageBuilder expirationSeconds(long expirationSeconds) {
        this.expirationSeconds = expirationSeconds;
        return this;
    }

    public GroupInviteMessageBuilder groupName(java.lang.String groupName) {
        this.groupName = groupName;
        return this;
    }

    public GroupInviteMessageBuilder thumbnail(byte[] thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public GroupInviteMessageBuilder caption(java.lang.String caption) {
        this.caption = caption;
        return this;
    }

    public GroupInviteMessageBuilder contextInfo(it.auties.whatsapp.model.info.ContextInfo contextInfo) {
        this.contextInfo = contextInfo;
        return this;
    }

    public GroupInviteMessageBuilder groupType(it.auties.whatsapp.model.message.standard.GroupInviteMessage.Type groupType) {
        this.groupType = groupType;
        return this;
    }

    public it.auties.whatsapp.model.message.standard.GroupInviteMessage build() {
        return new it.auties.whatsapp.model.message.standard.GroupInviteMessage(group, code, expirationSeconds, groupName, thumbnail, caption, contextInfo, groupType);
    }

}
