package it.auties.whatsapp.model.message.button;

import it.auties.whatsapp.model.message.button.InteractiveResponseMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class InteractiveResponseMessageSpec {
    public static byte[] encode(InteractiveResponseMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.button.interactive.InteractiveBodySpec.encode(protoInputObject.body()));
        outputStream.writeBytes(2, it.auties.whatsapp.model.message.button.NativeFlowResponseMessageSpec.encode(protoInputObject.nativeFlowResponseMessage()));
        var contextInfo = protoInputObject.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                outputStream.writeBytes(15, it.auties.whatsapp.model.info.ContextInfoSpec.encode(contextInfo0));
            }
        }
        return outputStream.toByteArray();
    }

    public static InteractiveResponseMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static InteractiveResponseMessage decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.button.interactive.InteractiveBody body = null;
        it.auties.whatsapp.model.message.button.NativeFlowResponseMessage nativeFlowResponseMessage = null;
        it.auties.whatsapp.model.info.ContextInfo contextInfo = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> body = it.auties.whatsapp.model.button.interactive.InteractiveBodySpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> nativeFlowResponseMessage = it.auties.whatsapp.model.message.button.NativeFlowResponseMessageSpec.decode(protoInputStream.lengthDelimitedStream());
                case 15 -> contextInfo = it.auties.whatsapp.model.info.ContextInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.button.InteractiveResponseMessage(body, nativeFlowResponseMessage, contextInfo);
    }

    public static int sizeOf(InteractiveResponseMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var body = object.body();
        if (body != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var bodySerializedSize = it.auties.whatsapp.model.button.interactive.InteractiveBodySpec.sizeOf(body);
            protoSize += ProtobufOutputStream.getVarIntSize(bodySerializedSize);
            protoSize += bodySerializedSize;
        }
        var nativeFlowResponseMessage = object.nativeFlowResponseMessage();
        if (nativeFlowResponseMessage != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var nativeFlowResponseMessageSerializedSize = it.auties.whatsapp.model.message.button.NativeFlowResponseMessageSpec.sizeOf(nativeFlowResponseMessage);
            protoSize += ProtobufOutputStream.getVarIntSize(nativeFlowResponseMessageSerializedSize);
            protoSize += nativeFlowResponseMessageSerializedSize;
        }
        var contextInfo = object.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(15, 2);
                var contextInfo0SerializedSize = it.auties.whatsapp.model.info.ContextInfoSpec.sizeOf(contextInfo0);
                protoSize += ProtobufOutputStream.getVarIntSize(contextInfo0SerializedSize);
                protoSize += contextInfo0SerializedSize;
            }
        }
        return protoSize;
    }

}
