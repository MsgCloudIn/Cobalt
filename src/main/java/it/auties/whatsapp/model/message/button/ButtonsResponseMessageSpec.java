package it.auties.whatsapp.model.message.button;

import it.auties.whatsapp.model.message.button.ButtonsResponseMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ButtonsResponseMessageSpec {
    public static byte[] encode(ButtonsResponseMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.buttonId());
        var buttonText = protoInputObject.buttonText();
        if (buttonText != null) {
            var buttonText0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(buttonText);
            if (buttonText0 != null) {
                outputStream.writeString(2, buttonText0);
            }
        }
        var contextInfo = protoInputObject.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                outputStream.writeBytes(3, it.auties.whatsapp.model.info.ContextInfoSpec.encode(contextInfo0));
            }
        }
        outputStream.writeInt32(4, it.auties.whatsapp.model.message.button.ButtonsResponseMessageResponseTypeSpec.encode(protoInputObject.responseType()));
        return outputStream.toByteArray();
    }

    public static ButtonsResponseMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ButtonsResponseMessage decode(ProtobufInputStream protoInputStream) {
        java.lang.String buttonId = null;
        java.lang.String buttonText = null;
        it.auties.whatsapp.model.info.ContextInfo contextInfo = null;
        it.auties.whatsapp.model.message.button.ButtonsResponseMessage.ResponseType responseType = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> buttonId = protoInputStream.readString();
                case 2 -> buttonText = protoInputStream.readString();
                case 3 -> contextInfo = it.auties.whatsapp.model.info.ContextInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                case 4 -> responseType = it.auties.whatsapp.model.message.button.ButtonsResponseMessageResponseTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.button.ButtonsResponseMessage(buttonId, buttonText, contextInfo, responseType);
    }

    public static int sizeOf(ButtonsResponseMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var buttonId = object.buttonId();
        if (buttonId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(buttonId);
        }
        var buttonText = object.buttonText();
        if (buttonText != null) {
            var buttonText0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(buttonText);
            if (buttonText0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                protoSize += ProtobufOutputStream.getStringSize(buttonText0);
            }
        }
        var contextInfo = object.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                var contextInfo0SerializedSize = it.auties.whatsapp.model.info.ContextInfoSpec.sizeOf(contextInfo0);
                protoSize += ProtobufOutputStream.getVarIntSize(contextInfo0SerializedSize);
                protoSize += contextInfo0SerializedSize;
            }
        }
        var responseType = object.responseType();
        if (responseType != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            var responseTypeSerializedSize = it.auties.whatsapp.model.message.button.ButtonsResponseMessageResponseTypeSpec.sizeOf(responseType);
            protoSize += responseTypeSerializedSize;
        }
        return protoSize;
    }

}
