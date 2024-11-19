package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.VersionSync;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class VersionSyncSpec {
    public static byte[] encode(VersionSync protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeUInt64(1, protoInputObject.version());
        return outputStream.toByteArray();
    }

    public static VersionSync decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static VersionSync decode(ProtobufInputStream protoInputStream) {
        java.lang.Long version = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> version = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.VersionSync(version);
    }

    public static int sizeOf(VersionSync object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var version = object.version();
        if (version != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(version);
        }
        return protoSize;
    }

}
