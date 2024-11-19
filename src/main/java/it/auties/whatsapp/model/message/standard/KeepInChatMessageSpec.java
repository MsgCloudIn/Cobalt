package it.auties.whatsapp.model.message.standard;

import it.auties.whatsapp.model.message.standard.KeepInChatMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class KeepInChatMessageSpec {
    public static byte[] encode(KeepInChatMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.message.model.ChatMessageKeySpec.encode(protoInputObject.key()));
        outputStream.writeInt32(2, it.auties.whatsapp.model.message.model.KeepInChatTypeSpec.encode(protoInputObject.keepType()));
        outputStream.writeInt64(3, protoInputObject.timestampMilliseconds());
        return outputStream.toByteArray();
    }

    public static KeepInChatMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static KeepInChatMessage decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.message.model.ChatMessageKey key = null;
        it.auties.whatsapp.model.message.model.KeepInChatType keepType = null;
        long timestampMilliseconds = 0l;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> key = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> keepType = it.auties.whatsapp.model.message.model.KeepInChatTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 3 -> timestampMilliseconds = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.standard.KeepInChatMessage(key, keepType, timestampMilliseconds);
    }

    public static int sizeOf(KeepInChatMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var key = object.key();
        if (key != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var keySerializedSize = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.sizeOf(key);
            protoSize += ProtobufOutputStream.getVarIntSize(keySerializedSize);
            protoSize += keySerializedSize;
        }
        var keepType = object.keepType();
        if (keepType != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var keepTypeSerializedSize = it.auties.whatsapp.model.message.model.KeepInChatTypeSpec.sizeOf(keepType);
            protoSize += keepTypeSerializedSize;
        }
        var timestampMilliseconds = object.timestampMilliseconds();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(timestampMilliseconds);
        return protoSize;
    }

}
