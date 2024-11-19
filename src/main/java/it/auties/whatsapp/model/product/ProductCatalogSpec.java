package it.auties.whatsapp.model.product;

import it.auties.whatsapp.model.product.ProductCatalog;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ProductCatalogSpec {
    public static byte[] encode(ProductCatalog protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.message.standard.ImageMessageSpec.encode(protoInputObject.catalogImage()));
        outputStream.writeString(2, protoInputObject.title());
        outputStream.writeString(3, protoInputObject.description());
        return outputStream.toByteArray();
    }

    public static ProductCatalog decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ProductCatalog decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.message.standard.ImageMessage catalogImage = null;
        java.lang.String title = null;
        java.lang.String description = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> catalogImage = it.auties.whatsapp.model.message.standard.ImageMessageSpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> title = protoInputStream.readString();
                case 3 -> description = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.product.ProductCatalog(catalogImage, title, description);
    }

    public static int sizeOf(ProductCatalog object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var catalogImage = object.catalogImage();
        if (catalogImage != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var catalogImageSerializedSize = it.auties.whatsapp.model.message.standard.ImageMessageSpec.sizeOf(catalogImage);
            protoSize += ProtobufOutputStream.getVarIntSize(catalogImageSerializedSize);
            protoSize += catalogImageSerializedSize;
        }
        var title = object.title();
        if (title != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(title);
        }
        var description = object.description();
        if (description != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getStringSize(description);
        }
        return protoSize;
    }

}
