package it.auties.whatsapp.model.button.template.hsm;

import it.auties.whatsapp.model.button.template.hsm.HighlyStructuredURLButton;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class HighlyStructuredURLButtonSpec {
    public static byte[] encode(HighlyStructuredURLButton protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessageSpec.encode(protoInputObject.text()));
        outputStream.writeBytes(2, it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessageSpec.encode(protoInputObject.url()));
        return outputStream.toByteArray();
    }

    public static HighlyStructuredURLButton decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static HighlyStructuredURLButton decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessage text = null;
        it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessage url = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> text = it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessageSpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> url = it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessageSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.template.hsm.HighlyStructuredURLButton(text, url);
    }

    public static int sizeOf(HighlyStructuredURLButton object) {
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
        var url = object.url();
        if (url != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var urlSerializedSize = it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessageSpec.sizeOf(url);
            protoSize += ProtobufOutputStream.getVarIntSize(urlSerializedSize);
            protoSize += urlSerializedSize;
        }
        return protoSize;
    }

}
