package it.auties.whatsapp.model.button.base;

import it.auties.whatsapp.model.button.base.ButtonRow;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ButtonRowSpec {
    public static byte[] encode(ButtonRow protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.title());
        outputStream.writeString(2, protoInputObject.description());
        outputStream.writeString(3, protoInputObject.id());
        return outputStream.toByteArray();
    }

    public static ButtonRow decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ButtonRow decode(ProtobufInputStream protoInputStream) {
        java.lang.String title = null;
        java.lang.String description = null;
        java.lang.String id = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> title = protoInputStream.readString();
                case 2 -> description = protoInputStream.readString();
                case 3 -> id = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.base.ButtonRow(title, description, id);
    }

    public static int sizeOf(ButtonRow object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var title = object.title();
        if (title != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(title);
        }
        var description = object.description();
        if (description != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(description);
        }
        var id = object.id();
        if (id != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getStringSize(id);
        }
        return protoSize;
    }

}
