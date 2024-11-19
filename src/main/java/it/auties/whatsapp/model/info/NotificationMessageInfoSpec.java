package it.auties.whatsapp.model.info;

import it.auties.whatsapp.model.info.NotificationMessageInfo;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class NotificationMessageInfoSpec {
    public static byte[] encode(NotificationMessageInfo protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.message.model.ChatMessageKeySpec.encode(protoInputObject.key()));
        outputStream.writeBytes(2, it.auties.whatsapp.model.message.model.MessageContainerSpec.encode(protoInputObject.message()));
        outputStream.writeUInt64(3, protoInputObject.messageTimestampSeconds());
        var participant = protoInputObject.participant();
        if (participant != null) {
            var participant0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(participant);
            if (participant0 != null) {
                outputStream.writeString(4, participant0);
            }
        }
        return outputStream.toByteArray();
    }

    public static NotificationMessageInfo decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static NotificationMessageInfo decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.message.model.ChatMessageKey key = null;
        it.auties.whatsapp.model.message.model.MessageContainer message = null;
        long messageTimestampSeconds = 0l;
        java.util.Optional<java.lang.String> participant = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> key = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> message = it.auties.whatsapp.model.message.model.MessageContainerSpec.decode(protoInputStream.lengthDelimitedStream());
                case 3 -> messageTimestampSeconds = protoInputStream.readInt64();
                case 4 -> participant = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.info.NotificationMessageInfo(key, message, messageTimestampSeconds, participant);
    }

    public static int sizeOf(NotificationMessageInfo object) {
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
        var message = object.message();
        if (message != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var messageSerializedSize = it.auties.whatsapp.model.message.model.MessageContainerSpec.sizeOf(message);
            protoSize += ProtobufOutputStream.getVarIntSize(messageSerializedSize);
            protoSize += messageSerializedSize;
        }
        var messageTimestampSeconds = object.messageTimestampSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(messageTimestampSeconds);
        var participant = object.participant();
        if (participant != null) {
            var participant0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(participant);
            if (participant0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                protoSize += ProtobufOutputStream.getStringSize(participant0);
            }
        }
        return protoSize;
    }

}
