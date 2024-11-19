package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.PhotoChange;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class PhotoChangeSpec {
    public static byte[] encode(PhotoChange protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, protoInputObject.oldPhoto());
        outputStream.writeBytes(2, protoInputObject.newPhoto());
        outputStream.writeUInt32(3, protoInputObject.newPhotoId());
        return outputStream.toByteArray();
    }

    public static PhotoChange decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static PhotoChange decode(ProtobufInputStream protoInputStream) {
        byte[] oldPhoto = null;
        byte[] newPhoto = null;
        java.lang.Integer newPhotoId = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> oldPhoto = protoInputStream.readBytes();
                case 2 -> newPhoto = protoInputStream.readBytes();
                case 3 -> newPhotoId = protoInputStream.readInt32();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.PhotoChange(oldPhoto, newPhoto, newPhotoId);
    }

    public static int sizeOf(PhotoChange object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var oldPhoto = object.oldPhoto();
        if (oldPhoto != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getBytesSize(oldPhoto);
        }
        var newPhoto = object.newPhoto();
        if (newPhoto != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(newPhoto);
        }
        var newPhotoId = object.newPhotoId();
        if (newPhotoId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(newPhotoId);
        }
        return protoSize;
    }

}
