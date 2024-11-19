package it.auties.whatsapp.model.setting;

import it.auties.whatsapp.model.setting.LocaleSettings;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class LocaleSettingsSpec {
    public static byte[] encode(LocaleSettings protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.locale());
        return outputStream.toByteArray();
    }

    public static LocaleSettings decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static LocaleSettings decode(ProtobufInputStream protoInputStream) {
        java.lang.String locale = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> locale = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.setting.LocaleSettings(locale);
    }

    public static int sizeOf(LocaleSettings object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var locale = object.locale();
        if (locale != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(locale);
        }
        return protoSize;
    }

}
