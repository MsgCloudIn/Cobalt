package it.auties.whatsapp.model.button.base;

import it.auties.whatsapp.model.button.base.ButtonRowOpaqueData;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ButtonRowOpaqueDataSpec {
    public static byte[] encode(ButtonRowOpaqueData protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var currentMessage = protoInputObject.currentMessage();
        if (currentMessage != null) {
            var currentMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(currentMessage);
            if (currentMessage0 != null) {
                outputStream.writeBytes(1, it.auties.whatsapp.model.button.base.ButtonOpaqueDataSpec.encode(currentMessage0));
            }
        }
        var quotedMessage = protoInputObject.quotedMessage();
        if (quotedMessage != null) {
            var quotedMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(quotedMessage);
            if (quotedMessage0 != null) {
                outputStream.writeBytes(2, it.auties.whatsapp.model.button.base.ButtonOpaqueDataSpec.encode(quotedMessage0));
            }
        }
        return outputStream.toByteArray();
    }

    public static ButtonRowOpaqueData decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ButtonRowOpaqueData decode(ProtobufInputStream protoInputStream) {
        java.util.Optional<it.auties.whatsapp.model.button.base.ButtonOpaqueData> currentMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.button.base.ButtonOpaqueData> quotedMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> currentMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.button.base.ButtonOpaqueDataSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 2 -> quotedMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.button.base.ButtonOpaqueDataSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.base.ButtonRowOpaqueData(currentMessage, quotedMessage);
    }

    public static int sizeOf(ButtonRowOpaqueData object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var currentMessage = object.currentMessage();
        if (currentMessage != null) {
            var currentMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(currentMessage);
            if (currentMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                var currentMessage0SerializedSize = it.auties.whatsapp.model.button.base.ButtonOpaqueDataSpec.sizeOf(currentMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(currentMessage0SerializedSize);
                protoSize += currentMessage0SerializedSize;
            }
        }
        var quotedMessage = object.quotedMessage();
        if (quotedMessage != null) {
            var quotedMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(quotedMessage);
            if (quotedMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                var quotedMessage0SerializedSize = it.auties.whatsapp.model.button.base.ButtonOpaqueDataSpec.sizeOf(quotedMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(quotedMessage0SerializedSize);
                protoSize += quotedMessage0SerializedSize;
            }
        }
        return protoSize;
    }

}
