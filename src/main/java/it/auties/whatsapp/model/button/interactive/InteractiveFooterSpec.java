package it.auties.whatsapp.model.button.interactive;

import it.auties.whatsapp.model.button.interactive.InteractiveFooter;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class InteractiveFooterSpec {
    public static byte[] encode(InteractiveFooter protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.content());
        return outputStream.toByteArray();
    }

    public static InteractiveFooter decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static InteractiveFooter decode(ProtobufInputStream protoInputStream) {
        java.lang.String content = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> content = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.interactive.InteractiveFooter(content);
    }

    public static int sizeOf(InteractiveFooter object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var content = object.content();
        if (content != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(content);
        }
        return protoSize;
    }

}
