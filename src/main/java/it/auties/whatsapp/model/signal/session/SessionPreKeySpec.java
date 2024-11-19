package it.auties.whatsapp.model.signal.session;

import it.auties.whatsapp.model.signal.session.SessionPreKey;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SessionPreKeySpec {
    public static byte[] encode(SessionPreKey protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, protoInputObject.preKeyId());
        outputStream.writeBytes(2, protoInputObject.baseKey());
        outputStream.writeInt32(3, protoInputObject.signedKeyId());
        return outputStream.toByteArray();
    }

    public static SessionPreKey decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SessionPreKey decode(ProtobufInputStream protoInputStream) {
        java.lang.Integer preKeyId = null;
        byte[] baseKey = null;
        int signedKeyId = 0;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> preKeyId = protoInputStream.readInt32();
                case 2 -> baseKey = protoInputStream.readBytes();
                case 3 -> signedKeyId = protoInputStream.readInt32();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.session.SessionPreKey(preKeyId, baseKey, signedKeyId);
    }

    public static int sizeOf(SessionPreKey object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var preKeyId = object.preKeyId();
        if (preKeyId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(preKeyId);
        }
        var baseKey = object.baseKey();
        if (baseKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(baseKey);
        }
        var signedKeyId = object.signedKeyId();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(signedKeyId);
        return protoSize;
    }

}
