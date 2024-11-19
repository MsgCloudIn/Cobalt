package it.auties.whatsapp.model.action;

import it.auties.whatsapp.model.action.AgentAction;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class AgentActionSpec {
    public static byte[] encode(AgentAction protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var name = protoInputObject.name();
        if (name != null) {
            var name0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(name);
            if (name0 != null) {
                outputStream.writeString(1, name0);
            }
        }
        outputStream.writeInt32(2, protoInputObject.deviceId());
        outputStream.writeBool(3, protoInputObject.deleted());
        return outputStream.toByteArray();
    }

    public static AgentAction decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static AgentAction decode(ProtobufInputStream protoInputStream) {
        java.util.Optional<java.lang.String> name = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        int deviceId = 0;
        boolean deleted = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> name = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 2 -> deviceId = protoInputStream.readInt32();
                case 3 -> deleted = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.action.AgentAction(name, deviceId, deleted);
    }

    public static int sizeOf(AgentAction object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var name = object.name();
        if (name != null) {
            var name0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(name);
            if (name0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(name0);
            }
        }
        var deviceId = object.deviceId();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(deviceId);
        var deleted = object.deleted();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += 1;
        return protoSize;
    }

}
