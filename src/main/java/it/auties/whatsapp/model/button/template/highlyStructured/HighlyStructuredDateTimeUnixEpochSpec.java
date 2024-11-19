package it.auties.whatsapp.model.button.template.highlyStructured;

import it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeUnixEpoch;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class HighlyStructuredDateTimeUnixEpochSpec {
    public static byte[] encode(HighlyStructuredDateTimeUnixEpoch protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt64(1, protoInputObject.timestampSeconds());
        return outputStream.toByteArray();
    }

    public static HighlyStructuredDateTimeUnixEpoch decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static HighlyStructuredDateTimeUnixEpoch decode(ProtobufInputStream protoInputStream) {
        long timestampSeconds = 0l;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> timestampSeconds = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeUnixEpoch(timestampSeconds);
    }

    public static int sizeOf(HighlyStructuredDateTimeUnixEpoch object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var timestampSeconds = object.timestampSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(timestampSeconds);
        return protoSize;
    }

}
