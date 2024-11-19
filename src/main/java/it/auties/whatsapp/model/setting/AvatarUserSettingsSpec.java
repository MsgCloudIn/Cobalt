package it.auties.whatsapp.model.setting;

import it.auties.whatsapp.model.setting.AvatarUserSettings;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class AvatarUserSettingsSpec {
    public static byte[] encode(AvatarUserSettings protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.facebookId());
        outputStream.writeString(2, protoInputObject.password());
        return outputStream.toByteArray();
    }

    public static AvatarUserSettings decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static AvatarUserSettings decode(ProtobufInputStream protoInputStream) {
        java.lang.String facebookId = null;
        java.lang.String password = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> facebookId = protoInputStream.readString();
                case 2 -> password = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.setting.AvatarUserSettings(facebookId, password);
    }

    public static int sizeOf(AvatarUserSettings object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var facebookId = object.facebookId();
        if (facebookId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(facebookId);
        }
        var password = object.password();
        if (password != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(password);
        }
        return protoSize;
    }

}
