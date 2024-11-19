package it.auties.whatsapp.model.action;

import it.auties.whatsapp.model.action.ChatAssignmentAction;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ChatAssignmentActionSpec {
    public static byte[] encode(ChatAssignmentAction protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var deviceAgentId = protoInputObject.deviceAgentId();
        if (deviceAgentId != null) {
            var deviceAgentId0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(deviceAgentId);
            if (deviceAgentId0 != null) {
                outputStream.writeString(1, deviceAgentId0);
            }
        }
        return outputStream.toByteArray();
    }

    public static ChatAssignmentAction decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ChatAssignmentAction decode(ProtobufInputStream protoInputStream) {
        java.util.Optional<java.lang.String> deviceAgentId = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> deviceAgentId = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.action.ChatAssignmentAction(deviceAgentId);
    }

    public static int sizeOf(ChatAssignmentAction object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var deviceAgentId = object.deviceAgentId();
        if (deviceAgentId != null) {
            var deviceAgentId0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(deviceAgentId);
            if (deviceAgentId0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(deviceAgentId0);
            }
        }
        return protoSize;
    }

}
