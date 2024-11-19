package it.auties.whatsapp.model.mobile;

import it.auties.whatsapp.model.mobile.CountryLocale;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class CountryLocaleSpec {
    public static byte[] encode(CountryLocale protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.languageValue());
        outputStream.writeString(2, protoInputObject.languageCode());
        outputStream.writeString(3, protoInputObject.separator());
        return outputStream.toByteArray();
    }

    public static CountryLocale decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static CountryLocale decode(ProtobufInputStream protoInputStream) {
        java.lang.String languageValue = null;
        java.lang.String languageCode = null;
        java.lang.String separator = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> languageValue = protoInputStream.readString();
                case 2 -> languageCode = protoInputStream.readString();
                case 3 -> separator = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.mobile.CountryLocale(languageValue, languageCode, separator);
    }

    public static int sizeOf(CountryLocale object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var languageValue = object.languageValue();
        if (languageValue != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(languageValue);
        }
        var languageCode = object.languageCode();
        if (languageCode != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(languageCode);
        }
        var separator = object.separator();
        if (separator != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getStringSize(separator);
        }
        return protoSize;
    }

}
