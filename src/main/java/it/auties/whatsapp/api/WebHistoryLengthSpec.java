package it.auties.whatsapp.api;

import it.auties.whatsapp.api.WebHistoryLength;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class WebHistoryLengthSpec {
    public static byte[] encode(WebHistoryLength protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, protoInputObject.size());
        return outputStream.toByteArray();
    }

    public static WebHistoryLength decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static WebHistoryLength decode(ProtobufInputStream protoInputStream) {
        int size = 0;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> size = protoInputStream.readInt32();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.api.WebHistoryLength(size);
    }

    public static int sizeOf(WebHistoryLength object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var size = object.size();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(size);
        return protoSize;
    }

}
