package it.auties.whatsapp.model.button.base;

import it.auties.whatsapp.model.button.base.ButtonActionLink;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ButtonActionLinkSpec {
    public static byte[] encode(ButtonActionLink protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.url());
        outputStream.writeString(2, protoInputObject.buttonTitle());
        return outputStream.toByteArray();
    }

    public static ButtonActionLink decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ButtonActionLink decode(ProtobufInputStream protoInputStream) {
        java.lang.String url = null;
        java.lang.String buttonTitle = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> url = protoInputStream.readString();
                case 2 -> buttonTitle = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.base.ButtonActionLink(url, buttonTitle);
    }

    public static int sizeOf(ButtonActionLink object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var url = object.url();
        if (url != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(url);
        }
        var buttonTitle = object.buttonTitle();
        if (buttonTitle != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(buttonTitle);
        }
        return protoSize;
    }

}
