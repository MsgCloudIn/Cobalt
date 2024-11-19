package it.auties.whatsapp.model.action;

import it.auties.whatsapp.model.action.PrimaryVersionAction;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class PrimaryVersionActionSpec {
    public static byte[] encode(PrimaryVersionAction protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.version());
        return outputStream.toByteArray();
    }

    public static PrimaryVersionAction decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static PrimaryVersionAction decode(ProtobufInputStream protoInputStream) {
        java.lang.String version = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> version = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.action.PrimaryVersionAction(version);
    }

    public static int sizeOf(PrimaryVersionAction object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var version = object.version();
        if (version != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(version);
        }
        return protoSize;
    }

}
