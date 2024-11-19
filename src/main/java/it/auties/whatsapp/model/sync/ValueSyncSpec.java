package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.ValueSync;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ValueSyncSpec {
    public static byte[] encode(ValueSync protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, protoInputObject.blob());
        return outputStream.toByteArray();
    }

    public static ValueSync decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ValueSync decode(ProtobufInputStream protoInputStream) {
        byte[] blob = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> blob = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.ValueSync(blob);
    }

    public static int sizeOf(ValueSync object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var blob = object.blob();
        if (blob != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getBytesSize(blob);
        }
        return protoSize;
    }

}
