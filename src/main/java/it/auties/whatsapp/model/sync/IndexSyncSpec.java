package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.IndexSync;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class IndexSyncSpec {
    public static byte[] encode(IndexSync protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, protoInputObject.blob());
        return outputStream.toByteArray();
    }

    public static IndexSync decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static IndexSync decode(ProtobufInputStream protoInputStream) {
        byte[] blob = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> blob = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.IndexSync(blob);
    }

    public static int sizeOf(IndexSync object) {
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
