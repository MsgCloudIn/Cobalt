package it.auties.whatsapp.model.action;

import it.auties.whatsapp.model.action.NuxAction;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class NuxActionSpec {
    public static byte[] encode(NuxAction protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBool(1, protoInputObject.acknowledged());
        return outputStream.toByteArray();
    }

    public static NuxAction decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static NuxAction decode(ProtobufInputStream protoInputStream) {
        boolean acknowledged = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> acknowledged = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.action.NuxAction(acknowledged);
    }

    public static int sizeOf(NuxAction object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var acknowledged = object.acknowledged();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += 1;
        return protoSize;
    }

}
