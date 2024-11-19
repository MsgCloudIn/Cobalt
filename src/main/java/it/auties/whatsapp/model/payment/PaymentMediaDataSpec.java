package it.auties.whatsapp.model.payment;

import it.auties.whatsapp.model.payment.PaymentMediaData;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class PaymentMediaDataSpec {
    public static byte[] encode(PaymentMediaData protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, protoInputObject.mediaKey());
        outputStream.writeInt64(2, protoInputObject.mediaKeyTimestamp());
        outputStream.writeBytes(3, protoInputObject.mediaSha256());
        outputStream.writeBytes(4, protoInputObject.mediaEncryptedSha256());
        outputStream.writeString(5, protoInputObject.mediaDirectPath());
        return outputStream.toByteArray();
    }

    public static PaymentMediaData decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static PaymentMediaData decode(ProtobufInputStream protoInputStream) {
        byte[] mediaKey = null;
        long mediaKeyTimestamp = 0l;
        byte[] mediaSha256 = null;
        byte[] mediaEncryptedSha256 = null;
        java.lang.String mediaDirectPath = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> mediaKey = protoInputStream.readBytes();
                case 2 -> mediaKeyTimestamp = protoInputStream.readInt64();
                case 3 -> mediaSha256 = protoInputStream.readBytes();
                case 4 -> mediaEncryptedSha256 = protoInputStream.readBytes();
                case 5 -> mediaDirectPath = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.payment.PaymentMediaData(mediaKey, mediaKeyTimestamp, mediaSha256, mediaEncryptedSha256, mediaDirectPath);
    }

    public static int sizeOf(PaymentMediaData object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var mediaKey = object.mediaKey();
        if (mediaKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getBytesSize(mediaKey);
        }
        var mediaKeyTimestamp = object.mediaKeyTimestamp();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(mediaKeyTimestamp);
        var mediaSha256 = object.mediaSha256();
        if (mediaSha256 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getBytesSize(mediaSha256);
        }
        var mediaEncryptedSha256 = object.mediaEncryptedSha256();
        if (mediaEncryptedSha256 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            protoSize += ProtobufOutputStream.getBytesSize(mediaEncryptedSha256);
        }
        var mediaDirectPath = object.mediaDirectPath();
        if (mediaDirectPath != null) {
            protoSize += ProtobufOutputStream.getFieldSize(5, 2);
            protoSize += ProtobufOutputStream.getStringSize(mediaDirectPath);
        }
        return protoSize;
    }

}
