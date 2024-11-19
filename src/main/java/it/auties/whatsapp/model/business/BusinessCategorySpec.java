package it.auties.whatsapp.model.business;

import it.auties.whatsapp.model.business.BusinessCategory;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class BusinessCategorySpec {
    public static byte[] encode(BusinessCategory protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.id());
        outputStream.writeString(2, protoInputObject.name());
        return outputStream.toByteArray();
    }

    public static BusinessCategory decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static BusinessCategory decode(ProtobufInputStream protoInputStream) {
        java.lang.String id = null;
        java.lang.String name = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> id = protoInputStream.readString();
                case 2 -> name = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.business.BusinessCategory(id, name);
    }

    public static int sizeOf(BusinessCategory object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var id = object.id();
        if (id != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(id);
        }
        var name = object.name();
        if (name != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(name);
        }
        return protoSize;
    }

}
