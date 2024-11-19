package it.auties.whatsapp.model.button.template.hydrated;

import it.auties.whatsapp.model.button.template.hydrated.HydratedURLButton;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class HydratedURLButtonSpec {
    public static byte[] encode(HydratedURLButton protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.text());
        outputStream.writeString(2, protoInputObject.url());
        return outputStream.toByteArray();
    }

    public static HydratedURLButton decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static HydratedURLButton decode(ProtobufInputStream protoInputStream) {
        java.lang.String text = null;
        java.lang.String url = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> text = protoInputStream.readString();
                case 2 -> url = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.template.hydrated.HydratedURLButton(text, url);
    }

    public static int sizeOf(HydratedURLButton object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var text = object.text();
        if (text != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(text);
        }
        var url = object.url();
        if (url != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(url);
        }
        return protoSize;
    }

}
