package it.auties.whatsapp.model.button.template.hydrated;

import it.auties.whatsapp.model.button.template.hydrated.HydratedTemplateButton;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class HydratedTemplateButtonSpec {
    public static byte[] encode(HydratedTemplateButton protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.button.template.hydrated.HydratedQuickReplyButtonSpec.encode(protoInputObject.quickReplyButton()));
        outputStream.writeBytes(2, it.auties.whatsapp.model.button.template.hydrated.HydratedURLButtonSpec.encode(protoInputObject.urlButton()));
        outputStream.writeBytes(3, it.auties.whatsapp.model.button.template.hydrated.HydratedCallButtonSpec.encode(protoInputObject.callButton()));
        outputStream.writeUInt32(4, protoInputObject.index());
        return outputStream.toByteArray();
    }

    public static HydratedTemplateButton decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static HydratedTemplateButton decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.button.template.hydrated.HydratedQuickReplyButton quickReplyButton = null;
        it.auties.whatsapp.model.button.template.hydrated.HydratedURLButton urlButton = null;
        it.auties.whatsapp.model.button.template.hydrated.HydratedCallButton callButton = null;
        int index = 0;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> quickReplyButton = it.auties.whatsapp.model.button.template.hydrated.HydratedQuickReplyButtonSpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> urlButton = it.auties.whatsapp.model.button.template.hydrated.HydratedURLButtonSpec.decode(protoInputStream.lengthDelimitedStream());
                case 3 -> callButton = it.auties.whatsapp.model.button.template.hydrated.HydratedCallButtonSpec.decode(protoInputStream.lengthDelimitedStream());
                case 4 -> index = protoInputStream.readInt32();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.template.hydrated.HydratedTemplateButton(quickReplyButton, urlButton, callButton, index);
    }

    public static int sizeOf(HydratedTemplateButton object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var quickReplyButton = object.quickReplyButton();
        if (quickReplyButton != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var quickReplyButtonSerializedSize = it.auties.whatsapp.model.button.template.hydrated.HydratedQuickReplyButtonSpec.sizeOf(quickReplyButton);
            protoSize += ProtobufOutputStream.getVarIntSize(quickReplyButtonSerializedSize);
            protoSize += quickReplyButtonSerializedSize;
        }
        var urlButton = object.urlButton();
        if (urlButton != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var urlButtonSerializedSize = it.auties.whatsapp.model.button.template.hydrated.HydratedURLButtonSpec.sizeOf(urlButton);
            protoSize += ProtobufOutputStream.getVarIntSize(urlButtonSerializedSize);
            protoSize += urlButtonSerializedSize;
        }
        var callButton = object.callButton();
        if (callButton != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            var callButtonSerializedSize = it.auties.whatsapp.model.button.template.hydrated.HydratedCallButtonSpec.sizeOf(callButton);
            protoSize += ProtobufOutputStream.getVarIntSize(callButtonSerializedSize);
            protoSize += callButtonSerializedSize;
        }
        var index = object.index();
        protoSize += ProtobufOutputStream.getFieldSize(4, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(index);
        return protoSize;
    }

}
