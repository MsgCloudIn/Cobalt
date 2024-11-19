package it.auties.whatsapp.model.setting;

import it.auties.whatsapp.model.setting.SecurityNotificationSettings;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SecurityNotificationSettingsSpec {
    public static byte[] encode(SecurityNotificationSettings protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBool(1, protoInputObject.showNotification());
        return outputStream.toByteArray();
    }

    public static SecurityNotificationSettings decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SecurityNotificationSettings decode(ProtobufInputStream protoInputStream) {
        boolean showNotification = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> showNotification = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.setting.SecurityNotificationSettings(showNotification);
    }

    public static int sizeOf(SecurityNotificationSettings object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var showNotification = object.showNotification();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += 1;
        return protoSize;
    }

}
