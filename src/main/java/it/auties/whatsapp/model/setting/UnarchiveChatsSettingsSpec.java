package it.auties.whatsapp.model.setting;

import it.auties.whatsapp.model.setting.UnarchiveChatsSettings;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class UnarchiveChatsSettingsSpec {
    public static byte[] encode(UnarchiveChatsSettings protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBool(1, protoInputObject.unarchiveChats());
        return outputStream.toByteArray();
    }

    public static UnarchiveChatsSettings decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static UnarchiveChatsSettings decode(ProtobufInputStream protoInputStream) {
        boolean unarchiveChats = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> unarchiveChats = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.setting.UnarchiveChatsSettings(unarchiveChats);
    }

    public static int sizeOf(UnarchiveChatsSettings object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var unarchiveChats = object.unarchiveChats();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += 1;
        return protoSize;
    }

}
