package it.auties.whatsapp.model.product;

import it.auties.whatsapp.model.product.ProductListHeaderImage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ProductListHeaderImageSpec {
    public static byte[] encode(ProductListHeaderImage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.id());
        outputStream.writeBytes(2, protoInputObject.thumbnail());
        return outputStream.toByteArray();
    }

    public static ProductListHeaderImage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ProductListHeaderImage decode(ProtobufInputStream protoInputStream) {
        java.lang.String id = null;
        byte[] thumbnail = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> id = protoInputStream.readString();
                case 2 -> thumbnail = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.product.ProductListHeaderImage(id, thumbnail);
    }

    public static int sizeOf(ProductListHeaderImage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var id = object.id();
        if (id != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(id);
        }
        var thumbnail = object.thumbnail();
        if (thumbnail != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(thumbnail);
        }
        return protoSize;
    }

}
