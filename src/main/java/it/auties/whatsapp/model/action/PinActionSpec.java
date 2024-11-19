package it.auties.whatsapp.model.action;

import it.auties.whatsapp.model.action.PinAction;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class PinActionSpec {
    public static byte[] encode(PinAction protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBool(1, protoInputObject.pinned());
        return outputStream.toByteArray();
    }

    public static PinAction decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static PinAction decode(ProtobufInputStream protoInputStream) {
        boolean pinned = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> pinned = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.action.PinAction(pinned);
    }

    public static int sizeOf(PinAction object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var pinned = object.pinned();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += 1;
        return protoSize;
    }

}
