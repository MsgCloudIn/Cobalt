package it.auties.whatsapp.model.action;

import it.auties.whatsapp.model.action.LabelAssociationAction;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class LabelAssociationActionSpec {
    public static byte[] encode(LabelAssociationAction protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBool(1, protoInputObject.labeled());
        return outputStream.toByteArray();
    }

    public static LabelAssociationAction decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static LabelAssociationAction decode(ProtobufInputStream protoInputStream) {
        boolean labeled = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> labeled = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.action.LabelAssociationAction(labeled);
    }

    public static int sizeOf(LabelAssociationAction object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var labeled = object.labeled();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += 1;
        return protoSize;
    }

}
