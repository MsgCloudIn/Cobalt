package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.KeyExpiration;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class KeyExpirationSpec {
    public static byte[] encode(KeyExpiration protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, protoInputObject.expiredKeyEpoch());
        return outputStream.toByteArray();
    }

    public static KeyExpiration decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static KeyExpiration decode(ProtobufInputStream protoInputStream) {
        java.lang.Integer expiredKeyEpoch = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> expiredKeyEpoch = protoInputStream.readInt32();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.KeyExpiration(expiredKeyEpoch);
    }

    public static int sizeOf(KeyExpiration object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var expiredKeyEpoch = object.expiredKeyEpoch();
        if (expiredKeyEpoch != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(expiredKeyEpoch);
        }
        return protoSize;
    }

}
