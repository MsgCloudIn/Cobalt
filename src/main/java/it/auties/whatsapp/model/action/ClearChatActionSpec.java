package it.auties.whatsapp.model.action;

import it.auties.whatsapp.model.action.ClearChatAction;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ClearChatActionSpec {
    public static byte[] encode(ClearChatAction protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var messageRange = protoInputObject.messageRange();
        if (messageRange != null) {
            var messageRange0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(messageRange);
            if (messageRange0 != null) {
                outputStream.writeBytes(1, it.auties.whatsapp.model.sync.ActionMessageRangeSyncSpec.encode(messageRange0));
            }
        }
        return outputStream.toByteArray();
    }

    public static ClearChatAction decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ClearChatAction decode(ProtobufInputStream protoInputStream) {
        java.util.Optional<it.auties.whatsapp.model.sync.ActionMessageRangeSync> messageRange = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> messageRange = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.sync.ActionMessageRangeSyncSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.action.ClearChatAction(messageRange);
    }

    public static int sizeOf(ClearChatAction object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var messageRange = object.messageRange();
        if (messageRange != null) {
            var messageRange0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(messageRange);
            if (messageRange0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                var messageRange0SerializedSize = it.auties.whatsapp.model.sync.ActionMessageRangeSyncSpec.sizeOf(messageRange0);
                protoSize += ProtobufOutputStream.getVarIntSize(messageRange0SerializedSize);
                protoSize += messageRange0SerializedSize;
            }
        }
        return protoSize;
    }

}
