package it.auties.whatsapp.model.action;

import it.auties.whatsapp.model.action.StarAction;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class StarActionSpec {
    public static byte[] encode(StarAction protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBool(1, protoInputObject.starred());
        return outputStream.toByteArray();
    }

    public static StarAction decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static StarAction decode(ProtobufInputStream protoInputStream) {
        boolean starred = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> starred = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.action.StarAction(starred);
    }

    public static int sizeOf(StarAction object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var starred = object.starred();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += 1;
        return protoSize;
    }

}
