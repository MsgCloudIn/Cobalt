package it.auties.whatsapp.model.button.template.hydrated;

import it.auties.whatsapp.model.button.template.hydrated.HydratedCallButton;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class HydratedCallButtonSpec {
    public static byte[] encode(HydratedCallButton protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.text());
        outputStream.writeString(2, protoInputObject.phoneNumber());
        return outputStream.toByteArray();
    }

    public static HydratedCallButton decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static HydratedCallButton decode(ProtobufInputStream protoInputStream) {
        java.lang.String text = null;
        java.lang.String phoneNumber = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> text = protoInputStream.readString();
                case 2 -> phoneNumber = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.template.hydrated.HydratedCallButton(text, phoneNumber);
    }

    public static int sizeOf(HydratedCallButton object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var text = object.text();
        if (text != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(text);
        }
        var phoneNumber = object.phoneNumber();
        if (phoneNumber != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(phoneNumber);
        }
        return protoSize;
    }

}
