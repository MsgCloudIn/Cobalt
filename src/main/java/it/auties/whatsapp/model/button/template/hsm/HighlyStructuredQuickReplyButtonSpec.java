package it.auties.whatsapp.model.button.template.hsm;

import it.auties.whatsapp.model.button.template.hsm.HighlyStructuredQuickReplyButton;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class HighlyStructuredQuickReplyButtonSpec {
    public static byte[] encode(HighlyStructuredQuickReplyButton protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessageSpec.encode(protoInputObject.text()));
        outputStream.writeString(2, protoInputObject.id());
        return outputStream.toByteArray();
    }

    public static HighlyStructuredQuickReplyButton decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static HighlyStructuredQuickReplyButton decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessage text = null;
        java.lang.String id = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> text = it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessageSpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> id = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.template.hsm.HighlyStructuredQuickReplyButton(text, id);
    }

    public static int sizeOf(HighlyStructuredQuickReplyButton object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var text = object.text();
        if (text != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var textSerializedSize = it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessageSpec.sizeOf(text);
            protoSize += ProtobufOutputStream.getVarIntSize(textSerializedSize);
            protoSize += textSerializedSize;
        }
        var id = object.id();
        if (id != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(id);
        }
        return protoSize;
    }

}
