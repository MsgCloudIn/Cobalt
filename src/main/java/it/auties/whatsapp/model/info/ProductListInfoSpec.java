package it.auties.whatsapp.model.info;

import it.auties.whatsapp.model.info.ProductListInfo;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ProductListInfoSpec {
    public static byte[] encode(ProductListInfo protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        if (protoInputObject.productSections() != null) {
            for (var productSectionsEntry : protoInputObject.productSections()) { 
                outputStream.writeBytes(1, it.auties.whatsapp.model.product.ProductSectionSpec.encode(productSectionsEntry));
            }
        }
        outputStream.writeBytes(2, it.auties.whatsapp.model.product.ProductListHeaderImageSpec.encode(protoInputObject.headerImage()));
        var seller = protoInputObject.seller();
        if (seller != null) {
            var seller0 = seller.toString();
            if (seller0 != null) {
                outputStream.writeString(3, seller0);
            }
        }
        return outputStream.toByteArray();
    }

    public static ProductListInfo decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ProductListInfo decode(ProtobufInputStream protoInputStream) {
        java.util.List<it.auties.whatsapp.model.product.ProductSection> productSections = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        it.auties.whatsapp.model.product.ProductListHeaderImage headerImage = null;
        it.auties.whatsapp.model.jid.Jid seller = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> productSections.add(it.auties.whatsapp.model.product.ProductSectionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 2 -> headerImage = it.auties.whatsapp.model.product.ProductListHeaderImageSpec.decode(protoInputStream.lengthDelimitedStream());
                case 3 -> seller = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.info.ProductListInfo(productSections, headerImage, seller);
    }

    public static int sizeOf(ProductListInfo object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var productSectionsRepeatedField = object.productSections();
        if (productSectionsRepeatedField != null) {
            for (var productSectionsEntry : productSectionsRepeatedField) { 
                if (productSectionsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                    var productSectionsEntrySerializedSize = it.auties.whatsapp.model.product.ProductSectionSpec.sizeOf(productSectionsEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(productSectionsEntrySerializedSize);
                    protoSize += productSectionsEntrySerializedSize;
                }
            }
        }
        var headerImage = object.headerImage();
        if (headerImage != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var headerImageSerializedSize = it.auties.whatsapp.model.product.ProductListHeaderImageSpec.sizeOf(headerImage);
            protoSize += ProtobufOutputStream.getVarIntSize(headerImageSerializedSize);
            protoSize += headerImageSerializedSize;
        }
        var seller = object.seller();
        if (seller != null) {
            var seller0 = seller.toString();
            if (seller0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                protoSize += ProtobufOutputStream.getStringSize(seller0);
            }
        }
        return protoSize;
    }

}
