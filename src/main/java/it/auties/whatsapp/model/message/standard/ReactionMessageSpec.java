package it.auties.whatsapp.model.message.standard;

import it.auties.whatsapp.model.message.standard.ReactionMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ReactionMessageSpec {
    public static byte[] encode(ReactionMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.message.model.ChatMessageKeySpec.encode(protoInputObject.key()));
        outputStream.writeString(2, protoInputObject.content());
        var groupingKey = protoInputObject.groupingKey();
        if (groupingKey != null) {
            var groupingKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(groupingKey);
            if (groupingKey0 != null) {
                outputStream.writeString(3, groupingKey0);
            }
        }
        outputStream.writeInt64(4, protoInputObject.timestampSeconds());
        return outputStream.toByteArray();
    }

    public static ReactionMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ReactionMessage decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.message.model.ChatMessageKey key = null;
        java.lang.String content = null;
        java.util.Optional<java.lang.String> groupingKey = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        long timestampSeconds = 0l;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> key = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> content = protoInputStream.readString();
                case 3 -> groupingKey = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 4 -> timestampSeconds = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.standard.ReactionMessage(key, content, groupingKey, timestampSeconds);
    }

    public static int sizeOf(ReactionMessage object) {
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
        var content = object.content();
        if (content != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(content);
        }
        var groupingKey = object.groupingKey();
        if (groupingKey != null) {
            var groupingKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(groupingKey);
            if (groupingKey0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                protoSize += ProtobufOutputStream.getStringSize(groupingKey0);
            }
        }
        var timestampSeconds = object.timestampSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(4, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(timestampSeconds);
        return protoSize;
    }

}
