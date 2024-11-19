package it.auties.whatsapp.model.action;

import it.auties.whatsapp.model.action.MuteAction;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class MuteActionSpec {
    public static byte[] encode(MuteAction protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBool(1, protoInputObject.muted());
        var muteEndTimestampSeconds = protoInputObject.muteEndTimestampSeconds();
        if (muteEndTimestampSeconds != null) {
            var muteEndTimestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(muteEndTimestampSeconds);
            if (muteEndTimestampSeconds0 != null) {
                outputStream.writeInt64(2, muteEndTimestampSeconds0);
            }
        }
        outputStream.writeBool(3, protoInputObject.autoMuted());
        return outputStream.toByteArray();
    }

    public static MuteAction decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static MuteAction decode(ProtobufInputStream protoInputStream) {
        boolean muted = false;
        java.util.OptionalLong muteEndTimestampSeconds = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptionalLong();
        boolean autoMuted = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> muted = protoInputStream.readBool();
                case 2 -> muteEndTimestampSeconds = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readInt64());
                case 3 -> autoMuted = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.action.MuteAction(muted, muteEndTimestampSeconds, autoMuted);
    }

    public static int sizeOf(MuteAction object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var muted = object.muted();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += 1;
        var muteEndTimestampSeconds = object.muteEndTimestampSeconds();
        if (muteEndTimestampSeconds != null) {
            var muteEndTimestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(muteEndTimestampSeconds);
            if (muteEndTimestampSeconds0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(muteEndTimestampSeconds0);
            }
        }
        var autoMuted = object.autoMuted();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += 1;
        return protoSize;
    }

}
