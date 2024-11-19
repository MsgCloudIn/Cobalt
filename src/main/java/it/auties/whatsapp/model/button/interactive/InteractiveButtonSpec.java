package it.auties.whatsapp.model.button.interactive;

import it.auties.whatsapp.model.button.interactive.InteractiveButton;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class InteractiveButtonSpec {
    public static byte[] encode(InteractiveButton protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.name());
        var parameters = protoInputObject.parameters();
        if (parameters != null) {
            var parameters0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(parameters);
            if (parameters0 != null) {
                outputStream.writeString(2, parameters0);
            }
        }
        return outputStream.toByteArray();
    }

    public static InteractiveButton decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static InteractiveButton decode(ProtobufInputStream protoInputStream) {
        java.lang.String name = null;
        java.util.Optional<java.lang.String> parameters = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> name = protoInputStream.readString();
                case 2 -> parameters = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.interactive.InteractiveButton(name, parameters);
    }

    public static int sizeOf(InteractiveButton object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var name = object.name();
        if (name != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(name);
        }
        var parameters = object.parameters();
        if (parameters != null) {
            var parameters0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(parameters);
            if (parameters0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                protoSize += ProtobufOutputStream.getStringSize(parameters0);
            }
        }
        return protoSize;
    }

}
