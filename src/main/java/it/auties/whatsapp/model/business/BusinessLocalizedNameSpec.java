package it.auties.whatsapp.model.business;

import it.auties.whatsapp.model.business.BusinessLocalizedName;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class BusinessLocalizedNameSpec {
    public static byte[] encode(BusinessLocalizedName protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.lg());
        outputStream.writeString(2, protoInputObject.lc());
        outputStream.writeString(3, protoInputObject.name());
        return outputStream.toByteArray();
    }

    public static BusinessLocalizedName decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static BusinessLocalizedName decode(ProtobufInputStream protoInputStream) {
        java.lang.String lg = null;
        java.lang.String lc = null;
        java.lang.String name = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> lg = protoInputStream.readString();
                case 2 -> lc = protoInputStream.readString();
                case 3 -> name = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.business.BusinessLocalizedName(lg, lc, name);
    }

    public static int sizeOf(BusinessLocalizedName object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var lg = object.lg();
        if (lg != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(lg);
        }
        var lc = object.lc();
        if (lc != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(lc);
        }
        var name = object.name();
        if (name != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getStringSize(name);
        }
        return protoSize;
    }

}
