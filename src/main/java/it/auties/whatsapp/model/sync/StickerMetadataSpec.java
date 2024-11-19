package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.StickerMetadata;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class StickerMetadataSpec {
    public static byte[] encode(StickerMetadata protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.url());
        outputStream.writeBytes(2, protoInputObject.fileSha256());
        outputStream.writeBytes(3, protoInputObject.fileEncSha256());
        outputStream.writeBytes(4, protoInputObject.mediaKey());
        outputStream.writeString(5, protoInputObject.mimetype());
        outputStream.writeUInt32(6, protoInputObject.height());
        outputStream.writeUInt32(7, protoInputObject.width());
        outputStream.writeString(8, protoInputObject.directPath());
        outputStream.writeUInt64(9, protoInputObject.fileLength());
        outputStream.writeFloat(10, protoInputObject.weight());
        outputStream.writeInt64(11, protoInputObject.lastStickerSentTs());
        return outputStream.toByteArray();
    }

    public static StickerMetadata decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static StickerMetadata decode(ProtobufInputStream protoInputStream) {
        java.lang.String url = null;
        byte[] fileSha256 = null;
        byte[] fileEncSha256 = null;
        byte[] mediaKey = null;
        java.lang.String mimetype = null;
        int height = 0;
        int width = 0;
        java.lang.String directPath = null;
        long fileLength = 0l;
        float weight = 0f;
        long lastStickerSentTs = 0l;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> url = protoInputStream.readString();
                case 2 -> fileSha256 = protoInputStream.readBytes();
                case 3 -> fileEncSha256 = protoInputStream.readBytes();
                case 4 -> mediaKey = protoInputStream.readBytes();
                case 5 -> mimetype = protoInputStream.readString();
                case 6 -> height = protoInputStream.readInt32();
                case 7 -> width = protoInputStream.readInt32();
                case 8 -> directPath = protoInputStream.readString();
                case 9 -> fileLength = protoInputStream.readInt64();
                case 10 -> weight = protoInputStream.readFloat();
                case 11 -> lastStickerSentTs = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.StickerMetadata(url, fileSha256, fileEncSha256, mediaKey, mimetype, height, width, directPath, fileLength, weight, lastStickerSentTs);
    }

    public static int sizeOf(StickerMetadata object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var url = object.url();
        if (url != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(url);
        }
        var fileSha256 = object.fileSha256();
        if (fileSha256 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(fileSha256);
        }
        var fileEncSha256 = object.fileEncSha256();
        if (fileEncSha256 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getBytesSize(fileEncSha256);
        }
        var mediaKey = object.mediaKey();
        if (mediaKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            protoSize += ProtobufOutputStream.getBytesSize(mediaKey);
        }
        var mimetype = object.mimetype();
        if (mimetype != null) {
            protoSize += ProtobufOutputStream.getFieldSize(5, 2);
            protoSize += ProtobufOutputStream.getStringSize(mimetype);
        }
        var height = object.height();
        protoSize += ProtobufOutputStream.getFieldSize(6, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(height);
        var width = object.width();
        protoSize += ProtobufOutputStream.getFieldSize(7, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(width);
        var directPath = object.directPath();
        if (directPath != null) {
            protoSize += ProtobufOutputStream.getFieldSize(8, 2);
            protoSize += ProtobufOutputStream.getStringSize(directPath);
        }
        var fileLength = object.fileLength();
        protoSize += ProtobufOutputStream.getFieldSize(9, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(fileLength);
        var weight = object.weight();
        protoSize += ProtobufOutputStream.getFieldSize(10, 5);
        protoSize += 4;
        var lastStickerSentTs = object.lastStickerSentTs();
        protoSize += ProtobufOutputStream.getFieldSize(11, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(lastStickerSentTs);
        return protoSize;
    }

}
