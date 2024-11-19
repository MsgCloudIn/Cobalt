package it.auties.whatsapp.model.action;

import it.auties.whatsapp.model.action.UserStatusMuteAction;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class UserStatusMuteActionSpec {
    public static byte[] encode(UserStatusMuteAction protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBool(1, protoInputObject.muted());
        return outputStream.toByteArray();
    }

    public static UserStatusMuteAction decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static UserStatusMuteAction decode(ProtobufInputStream protoInputStream) {
        boolean muted = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> muted = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.action.UserStatusMuteAction(muted);
    }

    public static int sizeOf(UserStatusMuteAction object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var muted = object.muted();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += 1;
        return protoSize;
    }

}
