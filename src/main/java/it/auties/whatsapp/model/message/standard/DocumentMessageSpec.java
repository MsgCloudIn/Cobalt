package it.auties.whatsapp.model.message.standard;

import it.auties.whatsapp.model.message.standard.DocumentMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class DocumentMessageSpec {
    public static byte[] encode(DocumentMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.mediaUrl);
        outputStream.writeString(2, protoInputObject.mimetype);
        outputStream.writeString(3, protoInputObject.title);
        outputStream.writeBytes(4, protoInputObject.mediaSha256);
        outputStream.writeUInt64(5, protoInputObject.mediaSize);
        outputStream.writeUInt32(6, protoInputObject.pageCount);
        outputStream.writeBytes(7, protoInputObject.mediaKey);
        outputStream.writeString(8, protoInputObject.fileName);
        outputStream.writeBytes(9, protoInputObject.mediaEncryptedSha256);
        outputStream.writeString(10, protoInputObject.mediaDirectPath);
        outputStream.writeUInt64(11, protoInputObject.mediaKeyTimestampSeconds);
        outputStream.writeBool(12, protoInputObject.contactVcard);
        outputStream.writeString(13, protoInputObject.thumbnailDirectPath);
        outputStream.writeBytes(14, protoInputObject.thumbnailSha256);
        outputStream.writeBytes(15, protoInputObject.thumbnailEncSha256);
        outputStream.writeBytes(16, protoInputObject.thumbnail);
        outputStream.writeBytes(17, it.auties.whatsapp.model.info.ContextInfoSpec.encode(protoInputObject.contextInfo));
        outputStream.writeUInt32(18, protoInputObject.thumbnailHeight);
        outputStream.writeUInt32(19, protoInputObject.thumbnailWidth);
        outputStream.writeString(20, protoInputObject.caption);
        return outputStream.toByteArray();
    }

    public static DocumentMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static DocumentMessage decode(ProtobufInputStream protoInputStream) {
        java.lang.String mediaUrl = null;
        java.lang.String mimetype = null;
        java.lang.String title = null;
        byte[] mediaSha256 = null;
        java.lang.Long mediaSize = null;
        java.lang.Integer pageCount = null;
        byte[] mediaKey = null;
        java.lang.String fileName = null;
        byte[] mediaEncryptedSha256 = null;
        java.lang.String mediaDirectPath = null;
        java.lang.Long mediaKeyTimestampSeconds = null;
        boolean contactVcard = false;
        java.lang.String thumbnailDirectPath = null;
        byte[] thumbnailSha256 = null;
        byte[] thumbnailEncSha256 = null;
        byte[] thumbnail = null;
        it.auties.whatsapp.model.info.ContextInfo contextInfo = null;
        java.lang.Integer thumbnailHeight = null;
        java.lang.Integer thumbnailWidth = null;
        java.lang.String caption = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> mediaUrl = protoInputStream.readString();
                case 2 -> mimetype = protoInputStream.readString();
                case 3 -> title = protoInputStream.readString();
                case 4 -> mediaSha256 = protoInputStream.readBytes();
                case 5 -> mediaSize = protoInputStream.readInt64();
                case 6 -> pageCount = protoInputStream.readInt32();
                case 7 -> mediaKey = protoInputStream.readBytes();
                case 8 -> fileName = protoInputStream.readString();
                case 9 -> mediaEncryptedSha256 = protoInputStream.readBytes();
                case 10 -> mediaDirectPath = protoInputStream.readString();
                case 11 -> mediaKeyTimestampSeconds = protoInputStream.readInt64();
                case 12 -> contactVcard = protoInputStream.readBool();
                case 13 -> thumbnailDirectPath = protoInputStream.readString();
                case 14 -> thumbnailSha256 = protoInputStream.readBytes();
                case 15 -> thumbnailEncSha256 = protoInputStream.readBytes();
                case 16 -> thumbnail = protoInputStream.readBytes();
                case 17 -> contextInfo = it.auties.whatsapp.model.info.ContextInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                case 18 -> thumbnailHeight = protoInputStream.readInt32();
                case 19 -> thumbnailWidth = protoInputStream.readInt32();
                case 20 -> caption = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.standard.DocumentMessage(mediaUrl, mimetype, title, mediaSha256, mediaSize, pageCount, mediaKey, fileName, mediaEncryptedSha256, mediaDirectPath, mediaKeyTimestampSeconds, contactVcard, thumbnailDirectPath, thumbnailSha256, thumbnailEncSha256, thumbnail, contextInfo, thumbnailHeight, thumbnailWidth, caption);
    }

    public static int sizeOf(DocumentMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var mediaUrl = object.mediaUrl;
        if (mediaUrl != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(mediaUrl);
        }
        var mimetype = object.mimetype;
        if (mimetype != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(mimetype);
        }
        var title = object.title;
        if (title != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getStringSize(title);
        }
        var mediaSha256 = object.mediaSha256;
        if (mediaSha256 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            protoSize += ProtobufOutputStream.getBytesSize(mediaSha256);
        }
        var mediaSize = object.mediaSize;
        if (mediaSize != null) {
            protoSize += ProtobufOutputStream.getFieldSize(5, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(mediaSize);
        }
        var pageCount = object.pageCount;
        if (pageCount != null) {
            protoSize += ProtobufOutputStream.getFieldSize(6, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(pageCount);
        }
        var mediaKey = object.mediaKey;
        if (mediaKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(7, 2);
            protoSize += ProtobufOutputStream.getBytesSize(mediaKey);
        }
        var fileName = object.fileName;
        if (fileName != null) {
            protoSize += ProtobufOutputStream.getFieldSize(8, 2);
            protoSize += ProtobufOutputStream.getStringSize(fileName);
        }
        var mediaEncryptedSha256 = object.mediaEncryptedSha256;
        if (mediaEncryptedSha256 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(9, 2);
            protoSize += ProtobufOutputStream.getBytesSize(mediaEncryptedSha256);
        }
        var mediaDirectPath = object.mediaDirectPath;
        if (mediaDirectPath != null) {
            protoSize += ProtobufOutputStream.getFieldSize(10, 2);
            protoSize += ProtobufOutputStream.getStringSize(mediaDirectPath);
        }
        var mediaKeyTimestampSeconds = object.mediaKeyTimestampSeconds;
        if (mediaKeyTimestampSeconds != null) {
            protoSize += ProtobufOutputStream.getFieldSize(11, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(mediaKeyTimestampSeconds);
        }
        var contactVcard = object.contactVcard;
        protoSize += ProtobufOutputStream.getFieldSize(12, 0);
        protoSize += 1;
        var thumbnailDirectPath = object.thumbnailDirectPath;
        if (thumbnailDirectPath != null) {
            protoSize += ProtobufOutputStream.getFieldSize(13, 2);
            protoSize += ProtobufOutputStream.getStringSize(thumbnailDirectPath);
        }
        var thumbnailSha256 = object.thumbnailSha256;
        if (thumbnailSha256 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(14, 2);
            protoSize += ProtobufOutputStream.getBytesSize(thumbnailSha256);
        }
        var thumbnailEncSha256 = object.thumbnailEncSha256;
        if (thumbnailEncSha256 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(15, 2);
            protoSize += ProtobufOutputStream.getBytesSize(thumbnailEncSha256);
        }
        var thumbnail = object.thumbnail;
        if (thumbnail != null) {
            protoSize += ProtobufOutputStream.getFieldSize(16, 2);
            protoSize += ProtobufOutputStream.getBytesSize(thumbnail);
        }
        var contextInfo = object.contextInfo;
        if (contextInfo != null) {
            protoSize += ProtobufOutputStream.getFieldSize(17, 2);
            var contextInfoSerializedSize = it.auties.whatsapp.model.info.ContextInfoSpec.sizeOf(contextInfo);
            protoSize += ProtobufOutputStream.getVarIntSize(contextInfoSerializedSize);
            protoSize += contextInfoSerializedSize;
        }
        var thumbnailHeight = object.thumbnailHeight;
        if (thumbnailHeight != null) {
            protoSize += ProtobufOutputStream.getFieldSize(18, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(thumbnailHeight);
        }
        var thumbnailWidth = object.thumbnailWidth;
        if (thumbnailWidth != null) {
            protoSize += ProtobufOutputStream.getFieldSize(19, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(thumbnailWidth);
        }
        var caption = object.caption;
        if (caption != null) {
            protoSize += ProtobufOutputStream.getFieldSize(20, 2);
            protoSize += ProtobufOutputStream.getStringSize(caption);
        }
        return protoSize;
    }

}
