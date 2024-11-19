package it.auties.whatsapp.model.product;

import it.auties.whatsapp.model.product.ProductSectionEntry;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ProductSectionEntrySpec {
    public static byte[] encode(ProductSectionEntry protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.id());
        return outputStream.toByteArray();
    }

    public static ProductSectionEntry decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ProductSectionEntry decode(ProtobufInputStream protoInputStream) {
        java.lang.String id = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> id = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.product.ProductSectionEntry(id);
    }

    public static int sizeOf(ProductSectionEntry object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var id = object.id();
        if (id != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(id);
        }
        return protoSize;
    }

}
