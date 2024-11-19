package it.auties.whatsapp.model.message.button;

import it.auties.whatsapp.model.message.button.TemplateReplyMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class TemplateReplyMessageSpec {
    public static byte[] encode(TemplateReplyMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.id());
        outputStream.writeString(2, protoInputObject.buttonText());
        var contextInfo = protoInputObject.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                outputStream.writeBytes(3, it.auties.whatsapp.model.info.ContextInfoSpec.encode(contextInfo0));
            }
        }
        outputStream.writeUInt32(4, protoInputObject.index());
        return outputStream.toByteArray();
    }

    public static TemplateReplyMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static TemplateReplyMessage decode(ProtobufInputStream protoInputStream) {
        java.lang.String id = null;
        java.lang.String buttonText = null;
        it.auties.whatsapp.model.info.ContextInfo contextInfo = null;
        int index = 0;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> id = protoInputStream.readString();
                case 2 -> buttonText = protoInputStream.readString();
                case 3 -> contextInfo = it.auties.whatsapp.model.info.ContextInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                case 4 -> index = protoInputStream.readInt32();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.button.TemplateReplyMessage(id, buttonText, contextInfo, index);
    }

    public static int sizeOf(TemplateReplyMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var id = object.id();
        if (id != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(id);
        }
        var buttonText = object.buttonText();
        if (buttonText != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(buttonText);
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
        var index = object.index();
        protoSize += ProtobufOutputStream.getFieldSize(4, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(index);
        return protoSize;
    }

}
