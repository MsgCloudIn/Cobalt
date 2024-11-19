package it.auties.whatsapp.model.action;

public class StickerActionBuilder {
    private java.lang.String url;
    private byte[] fileEncSha256;
    private byte[] mediaKey;
    private java.lang.String mimetype;
    private int height;
    private int width;
    private java.lang.String directPath;
    private long fileLength;
    private boolean favorite;
    private java.lang.Integer deviceIdHint;

    public StickerActionBuilder() {
        url = null;
        fileEncSha256 = null;
        mediaKey = null;
        mimetype = null;
        height = 0;
        width = 0;
        directPath = null;
        fileLength = 0l;
        favorite = false;
        deviceIdHint = null;
    }

    public StickerActionBuilder url(java.lang.String url) {
        this.url = url;
        return this;
    }

    public StickerActionBuilder fileEncSha256(byte[] fileEncSha256) {
        this.fileEncSha256 = fileEncSha256;
        return this;
    }

    public StickerActionBuilder mediaKey(byte[] mediaKey) {
        this.mediaKey = mediaKey;
        return this;
    }

    public StickerActionBuilder mimetype(java.lang.String mimetype) {
        this.mimetype = mimetype;
        return this;
    }

    public StickerActionBuilder height(int height) {
        this.height = height;
        return this;
    }

    public StickerActionBuilder width(int width) {
        this.width = width;
        return this;
    }

    public StickerActionBuilder directPath(java.lang.String directPath) {
        this.directPath = directPath;
        return this;
    }

    public StickerActionBuilder fileLength(long fileLength) {
        this.fileLength = fileLength;
        return this;
    }

    public StickerActionBuilder favorite(boolean favorite) {
        this.favorite = favorite;
        return this;
    }

    public StickerActionBuilder deviceIdHint(java.lang.Integer deviceIdHint) {
        this.deviceIdHint = deviceIdHint;
        return this;
    }

    public it.auties.whatsapp.model.action.StickerAction build() {
        return new it.auties.whatsapp.model.action.StickerAction(url, fileEncSha256, mediaKey, mimetype, height, width, directPath, fileLength, favorite, deviceIdHint);
    }

}
