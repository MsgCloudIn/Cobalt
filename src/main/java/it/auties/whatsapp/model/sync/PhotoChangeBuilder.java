package it.auties.whatsapp.model.sync;

public class PhotoChangeBuilder {
    private byte[] oldPhoto;
    private byte[] newPhoto;
    private java.lang.Integer newPhotoId;

    public PhotoChangeBuilder() {
        oldPhoto = null;
        newPhoto = null;
        newPhotoId = null;
    }

    public PhotoChangeBuilder oldPhoto(byte[] oldPhoto) {
        this.oldPhoto = oldPhoto;
        return this;
    }

    public PhotoChangeBuilder newPhoto(byte[] newPhoto) {
        this.newPhoto = newPhoto;
        return this;
    }

    public PhotoChangeBuilder newPhotoId(java.lang.Integer newPhotoId) {
        this.newPhotoId = newPhotoId;
        return this;
    }

    public it.auties.whatsapp.model.sync.PhotoChange build() {
        return new it.auties.whatsapp.model.sync.PhotoChange(oldPhoto, newPhoto, newPhotoId);
    }

}
