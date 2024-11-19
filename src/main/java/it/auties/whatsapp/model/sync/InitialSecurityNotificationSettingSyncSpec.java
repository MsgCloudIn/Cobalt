package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.InitialSecurityNotificationSettingSync;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class InitialSecurityNotificationSettingSyncSpec {
    public static byte[] encode(InitialSecurityNotificationSettingSync protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBool(1, protoInputObject.securityNotificationEnabled());
        return outputStream.toByteArray();
    }

    public static InitialSecurityNotificationSettingSync decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static InitialSecurityNotificationSettingSync decode(ProtobufInputStream protoInputStream) {
        boolean securityNotificationEnabled = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> securityNotificationEnabled = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.InitialSecurityNotificationSettingSync(securityNotificationEnabled);
    }

    public static int sizeOf(InitialSecurityNotificationSettingSync object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var securityNotificationEnabled = object.securityNotificationEnabled();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += 1;
        return protoSize;
    }

}
