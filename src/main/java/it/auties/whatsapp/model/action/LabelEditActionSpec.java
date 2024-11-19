package it.auties.whatsapp.model.action;

import it.auties.whatsapp.model.action.LabelEditAction;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class LabelEditActionSpec {
    public static byte[] encode(LabelEditAction protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.name());
        outputStream.writeInt32(2, protoInputObject.color());
        outputStream.writeInt32(3, protoInputObject.id());
        outputStream.writeBool(4, protoInputObject.deleted());
        return outputStream.toByteArray();
    }

    public static LabelEditAction decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static LabelEditAction decode(ProtobufInputStream protoInputStream) {
        java.lang.String name = null;
        int color = 0;
        int id = 0;
        boolean deleted = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> name = protoInputStream.readString();
                case 2 -> color = protoInputStream.readInt32();
                case 3 -> id = protoInputStream.readInt32();
                case 4 -> deleted = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.action.LabelEditAction(name, color, id, deleted);
    }

    public static int sizeOf(LabelEditAction object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var name = object.name();
        if (name != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(name);
        }
        var color = object.color();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(color);
        var id = object.id();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(id);
        var deleted = object.deleted();
        protoSize += ProtobufOutputStream.getFieldSize(4, 0);
        protoSize += 1;
        return protoSize;
    }

}
