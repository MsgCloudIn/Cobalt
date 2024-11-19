package it.auties.whatsapp.model.info;

public class AdReplyInfoBuilder {
    private java.lang.String advertiserName;
    private it.auties.whatsapp.model.info.AdReplyInfo.MediaType mediaType;
    private java.util.Optional<byte[]> thumbnail;
    private java.util.Optional<java.lang.String> caption;

    public AdReplyInfoBuilder() {
        advertiserName = null;
        mediaType = null;
        thumbnail = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        caption = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
    }

    public AdReplyInfoBuilder advertiserName(java.lang.String advertiserName) {
        this.advertiserName = advertiserName;
        return this;
    }

    public AdReplyInfoBuilder mediaType(it.auties.whatsapp.model.info.AdReplyInfo.MediaType mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    public AdReplyInfoBuilder thumbnail(byte[] thumbnail) {
        this.thumbnail = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(thumbnail);
        return this;
    }

    public AdReplyInfoBuilder caption(java.lang.String caption) {
        this.caption = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(caption);
        return this;
    }

    public it.auties.whatsapp.model.info.AdReplyInfo build() {
        return new it.auties.whatsapp.model.info.AdReplyInfo(advertiserName, mediaType, thumbnail, caption);
    }

}
