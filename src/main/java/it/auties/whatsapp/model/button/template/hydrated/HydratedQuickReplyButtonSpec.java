package it.auties.whatsapp.model.button.template.hydrated;

import it.auties.whatsapp.model.button.template.hydrated.HydratedQuickReplyButton;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class HydratedQuickReplyButtonSpec {
    public static byte[] encode(HydratedQuickReplyButton protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.text());
        outputStream.writeString(2, protoInputObject.id());
        return outputStream.toByteArray();
    }

    public static HydratedQuickReplyButton decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static HydratedQuickReplyButton decode(ProtobufInputStream protoInputStream) {
        java.lang.String text = null;
        java.lang.String id = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> text = protoInputStream.readString();
                case 2 -> id = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.template.hydrated.HydratedQuickReplyButton(text, id);
    }

    public static int sizeOf(HydratedQuickReplyButton object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var text = object.text();
        if (text != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(text);
        }
        var id = object.id();
        if (id != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(id);
        }
        return protoSize;
    }

}
