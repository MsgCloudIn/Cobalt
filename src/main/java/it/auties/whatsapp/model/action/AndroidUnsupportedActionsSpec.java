package it.auties.whatsapp.model.action;

import it.auties.whatsapp.model.action.AndroidUnsupportedActions;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class AndroidUnsupportedActionsSpec {
    public static byte[] encode(AndroidUnsupportedActions protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBool(1, protoInputObject.allowed());
        return outputStream.toByteArray();
    }

    public static AndroidUnsupportedActions decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static AndroidUnsupportedActions decode(ProtobufInputStream protoInputStream) {
        boolean allowed = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> allowed = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.action.AndroidUnsupportedActions(allowed);
    }

    public static int sizeOf(AndroidUnsupportedActions object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var allowed = object.allowed();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += 1;
        return protoSize;
    }

}
