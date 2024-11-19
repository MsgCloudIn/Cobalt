package it.auties.whatsapp.model.product;

import it.auties.whatsapp.model.product.Product;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ProductSpec {
    public static byte[] encode(Product protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.message.standard.ImageMessageSpec.encode(protoInputObject.image()));
        outputStream.writeString(2, protoInputObject.id());
        outputStream.writeString(3, protoInputObject.title());
        outputStream.writeString(4, protoInputObject.description());
        outputStream.writeString(5, protoInputObject.currencyCode());
        outputStream.writeInt64(6, protoInputObject.priceAmount1000());
        outputStream.writeString(7, protoInputObject.retailerId());
        outputStream.writeString(8, protoInputObject.url());
        outputStream.writeUInt32(9, protoInputObject.productImageCount());
        outputStream.writeString(11, protoInputObject.firstImageId());
        outputStream.writeInt64(12, protoInputObject.salePriceAmount1000());
        return outputStream.toByteArray();
    }

    public static Product decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static Product decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.message.standard.ImageMessage image = null;
        java.lang.String id = null;
        java.lang.String title = null;
        java.lang.String description = null;
        java.lang.String currencyCode = null;
        long priceAmount1000 = 0l;
        java.lang.String retailerId = null;
        java.lang.String url = null;
        int productImageCount = 0;
        java.lang.String firstImageId = null;
        long salePriceAmount1000 = 0l;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> image = it.auties.whatsapp.model.message.standard.ImageMessageSpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> id = protoInputStream.readString();
                case 3 -> title = protoInputStream.readString();
                case 4 -> description = protoInputStream.readString();
                case 5 -> currencyCode = protoInputStream.readString();
                case 6 -> priceAmount1000 = protoInputStream.readInt64();
                case 7 -> retailerId = protoInputStream.readString();
                case 8 -> url = protoInputStream.readString();
                case 9 -> productImageCount = protoInputStream.readInt32();
                case 11 -> firstImageId = protoInputStream.readString();
                case 12 -> salePriceAmount1000 = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.product.Product(image, id, title, description, currencyCode, priceAmount1000, retailerId, url, productImageCount, firstImageId, salePriceAmount1000);
    }

    public static int sizeOf(Product object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var image = object.image();
        if (image != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var imageSerializedSize = it.auties.whatsapp.model.message.standard.ImageMessageSpec.sizeOf(image);
            protoSize += ProtobufOutputStream.getVarIntSize(imageSerializedSize);
            protoSize += imageSerializedSize;
        }
        var id = object.id();
        if (id != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(id);
        }
        var title = object.title();
        if (title != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getStringSize(title);
        }
        var description = object.description();
        if (description != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            protoSize += ProtobufOutputStream.getStringSize(description);
        }
        var currencyCode = object.currencyCode();
        if (currencyCode != null) {
            protoSize += ProtobufOutputStream.getFieldSize(5, 2);
            protoSize += ProtobufOutputStream.getStringSize(currencyCode);
        }
        var priceAmount1000 = object.priceAmount1000();
        protoSize += ProtobufOutputStream.getFieldSize(6, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(priceAmount1000);
        var retailerId = object.retailerId();
        if (retailerId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(7, 2);
            protoSize += ProtobufOutputStream.getStringSize(retailerId);
        }
        var url = object.url();
        if (url != null) {
            protoSize += ProtobufOutputStream.getFieldSize(8, 2);
            protoSize += ProtobufOutputStream.getStringSize(url);
        }
        var productImageCount = object.productImageCount();
        protoSize += ProtobufOutputStream.getFieldSize(9, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(productImageCount);
        var firstImageId = object.firstImageId();
        if (firstImageId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(11, 2);
            protoSize += ProtobufOutputStream.getStringSize(firstImageId);
        }
        var salePriceAmount1000 = object.salePriceAmount1000();
        protoSize += ProtobufOutputStream.getFieldSize(12, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(salePriceAmount1000);
        return protoSize;
    }

}
