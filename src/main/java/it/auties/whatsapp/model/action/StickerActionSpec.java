package it.auties.whatsapp.model.action;

import it.auties.whatsapp.model.action.StickerAction;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class StickerActionSpec {
    public static byte[] encode(StickerAction protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.url());
        outputStream.writeBytes(2, protoInputObject.fileEncSha256());
        outputStream.writeBytes(3, protoInputObject.mediaKey());
        outputStream.writeString(4, protoInputObject.mimetype());
        outputStream.writeUInt32(5, protoInputObject.height());
        outputStream.writeUInt32(6, protoInputObject.width());
        outputStream.writeString(7, protoInputObject.directPath());
        outputStream.writeUInt64(8, protoInputObject.fileLength());
        outputStream.writeBool(9, protoInputObject.favorite());
        outputStream.writeUInt32(10, protoInputObject.deviceIdHint());
        return outputStream.toByteArray();
    }

    public static StickerAction decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static StickerAction decode(ProtobufInputStream protoInputStream) {
        java.lang.String url = null;
        byte[] fileEncSha256 = null;
        byte[] mediaKey = null;
        java.lang.String mimetype = null;
        int height = 0;
        int width = 0;
        java.lang.String directPath = null;
        long fileLength = 0l;
        boolean favorite = false;
        java.lang.Integer deviceIdHint = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> url = protoInputStream.readString();
                case 2 -> fileEncSha256 = protoInputStream.readBytes();
                case 3 -> mediaKey = protoInputStream.readBytes();
                case 4 -> mimetype = protoInputStream.readString();
                case 5 -> height = protoInputStream.readInt32();
                case 6 -> width = protoInputStream.readInt32();
                case 7 -> directPath = protoInputStream.readString();
                case 8 -> fileLength = protoInputStream.readInt64();
                case 9 -> favorite = protoInputStream.readBool();
                case 10 -> deviceIdHint = protoInputStream.readInt32();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.action.StickerAction(url, fileEncSha256, mediaKey, mimetype, height, width, directPath, fileLength, favorite, deviceIdHint);
    }

    public static int sizeOf(StickerAction object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var url = object.url();
        if (url != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(url);
        }
        var fileEncSha256 = object.fileEncSha256();
        if (fileEncSha256 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(fileEncSha256);
        }
        var mediaKey = object.mediaKey();
        if (mediaKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getBytesSize(mediaKey);
        }
        var mimetype = object.mimetype();
        if (mimetype != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            protoSize += ProtobufOutputStream.getStringSize(mimetype);
        }
        var height = object.height();
        protoSize += ProtobufOutputStream.getFieldSize(5, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(height);
        var width = object.width();
        protoSize += ProtobufOutputStream.getFieldSize(6, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(width);
        var directPath = object.directPath();
        if (directPath != null) {
            protoSize += ProtobufOutputStream.getFieldSize(7, 2);
            protoSize += ProtobufOutputStream.getStringSize(directPath);
        }
        var fileLength = object.fileLength();
        protoSize += ProtobufOutputStream.getFieldSize(8, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(fileLength);
        var favorite = object.favorite();
        protoSize += ProtobufOutputStream.getFieldSize(9, 0);
        protoSize += 1;
        var deviceIdHint = object.deviceIdHint();
        if (deviceIdHint != null) {
            protoSize += ProtobufOutputStream.getFieldSize(10, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(deviceIdHint);
        }
        return protoSize;
    }

}
