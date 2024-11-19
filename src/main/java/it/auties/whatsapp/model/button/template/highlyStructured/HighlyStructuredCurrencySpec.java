package it.auties.whatsapp.model.button.template.highlyStructured;

import it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredCurrency;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class HighlyStructuredCurrencySpec {
    public static byte[] encode(HighlyStructuredCurrency protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.currencyCode());
        outputStream.writeInt64(2, protoInputObject.amount1000());
        return outputStream.toByteArray();
    }

    public static HighlyStructuredCurrency decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static HighlyStructuredCurrency decode(ProtobufInputStream protoInputStream) {
        java.lang.String currencyCode = null;
        long amount1000 = 0l;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> currencyCode = protoInputStream.readString();
                case 2 -> amount1000 = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredCurrency(currencyCode, amount1000);
    }

    public static int sizeOf(HighlyStructuredCurrency object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var currencyCode = object.currencyCode();
        if (currencyCode != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(currencyCode);
        }
        var amount1000 = object.amount1000();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(amount1000);
        return protoSize;
    }

}
