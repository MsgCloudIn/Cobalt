package it.auties.whatsapp.model.product;

import it.auties.whatsapp.model.product.ProductSection;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ProductSectionSpec {
    public static byte[] encode(ProductSection protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.title());
        if (protoInputObject.products() != null) {
            for (var productsEntry : protoInputObject.products()) { 
                outputStream.writeBytes(2, it.auties.whatsapp.model.product.ProductSectionEntrySpec.encode(productsEntry));
            }
        }
        return outputStream.toByteArray();
    }

    public static ProductSection decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ProductSection decode(ProtobufInputStream protoInputStream) {
        java.lang.String title = null;
        java.util.List<it.auties.whatsapp.model.product.ProductSectionEntry> products = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> title = protoInputStream.readString();
                case 2 -> products.add(it.auties.whatsapp.model.product.ProductSectionEntrySpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.product.ProductSection(title, products);
    }

    public static int sizeOf(ProductSection object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var title = object.title();
        if (title != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(title);
        }
        var productsRepeatedField = object.products();
        if (productsRepeatedField != null) {
            for (var productsEntry : productsRepeatedField) { 
                if (productsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                    var productsEntrySerializedSize = it.auties.whatsapp.model.product.ProductSectionEntrySpec.sizeOf(productsEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(productsEntrySerializedSize);
                    protoSize += productsEntrySerializedSize;
                }
            }
        }
        return protoSize;
    }

}
