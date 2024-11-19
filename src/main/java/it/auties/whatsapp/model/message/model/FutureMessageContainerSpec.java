package it.auties.whatsapp.model.message.model;

import it.auties.whatsapp.model.message.model.FutureMessageContainer;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class FutureMessageContainerSpec {
    public static byte[] encode(FutureMessageContainer protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.message.model.MessageContainerSpec.encode(protoInputObject.content()));
        return outputStream.toByteArray();
    }

    public static FutureMessageContainer decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static FutureMessageContainer decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.message.model.MessageContainer content = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> content = it.auties.whatsapp.model.message.model.MessageContainerSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.model.FutureMessageContainer(content);
    }

    public static int sizeOf(FutureMessageContainer object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var content = object.content();
        if (content != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var contentSerializedSize = it.auties.whatsapp.model.message.model.MessageContainerSpec.sizeOf(content);
            protoSize += ProtobufOutputStream.getVarIntSize(contentSerializedSize);
            protoSize += contentSerializedSize;
        }
        return protoSize;
    }

}
