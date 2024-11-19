package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.AppStateSyncKeyId;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class AppStateSyncKeyIdSpec {
    public static byte[] encode(AppStateSyncKeyId protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, protoInputObject.keyId());
        return outputStream.toByteArray();
    }

    public static AppStateSyncKeyId decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static AppStateSyncKeyId decode(ProtobufInputStream protoInputStream) {
        byte[] keyId = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> keyId = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.AppStateSyncKeyId(keyId);
    }

    public static int sizeOf(AppStateSyncKeyId object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var keyId = object.keyId();
        if (keyId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getBytesSize(keyId);
        }
        return protoSize;
    }

}
