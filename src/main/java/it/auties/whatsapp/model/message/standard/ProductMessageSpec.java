package it.auties.whatsapp.model.message.standard;

import it.auties.whatsapp.model.message.standard.ProductMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ProductMessageSpec {
    public static byte[] encode(ProductMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.product.ProductSpec.encode(protoInputObject.product()));
        var businessOwnerJid = protoInputObject.businessOwnerJid();
        if (businessOwnerJid != null) {
            var businessOwnerJid0 = businessOwnerJid.toString();
            if (businessOwnerJid0 != null) {
                outputStream.writeString(2, businessOwnerJid0);
            }
        }
        outputStream.writeBytes(4, it.auties.whatsapp.model.product.ProductCatalogSpec.encode(protoInputObject.catalog()));
        var body = protoInputObject.body();
        if (body != null) {
            var body0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(body);
            if (body0 != null) {
                outputStream.writeString(5, body0);
            }
        }
        var footer = protoInputObject.footer();
        if (footer != null) {
            var footer0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(footer);
            if (footer0 != null) {
                outputStream.writeString(6, footer0);
            }
        }
        var contextInfo = protoInputObject.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                outputStream.writeBytes(17, it.auties.whatsapp.model.info.ContextInfoSpec.encode(contextInfo0));
            }
        }
        return outputStream.toByteArray();
    }

    public static ProductMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ProductMessage decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.product.Product product = null;
        it.auties.whatsapp.model.jid.Jid businessOwnerJid = null;
        it.auties.whatsapp.model.product.ProductCatalog catalog = null;
        java.lang.String body = null;
        java.lang.String footer = null;
        it.auties.whatsapp.model.info.ContextInfo contextInfo = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> product = it.auties.whatsapp.model.product.ProductSpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> businessOwnerJid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 4 -> catalog = it.auties.whatsapp.model.product.ProductCatalogSpec.decode(protoInputStream.lengthDelimitedStream());
                case 5 -> body = protoInputStream.readString();
                case 6 -> footer = protoInputStream.readString();
                case 17 -> contextInfo = it.auties.whatsapp.model.info.ContextInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.standard.ProductMessage(product, businessOwnerJid, catalog, body, footer, contextInfo);
    }

    public static int sizeOf(ProductMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var product = object.product();
        if (product != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var productSerializedSize = it.auties.whatsapp.model.product.ProductSpec.sizeOf(product);
            protoSize += ProtobufOutputStream.getVarIntSize(productSerializedSize);
            protoSize += productSerializedSize;
        }
        var businessOwnerJid = object.businessOwnerJid();
        if (businessOwnerJid != null) {
            var businessOwnerJid0 = businessOwnerJid.toString();
            if (businessOwnerJid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                protoSize += ProtobufOutputStream.getStringSize(businessOwnerJid0);
            }
        }
        var catalog = object.catalog();
        if (catalog != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            var catalogSerializedSize = it.auties.whatsapp.model.product.ProductCatalogSpec.sizeOf(catalog);
            protoSize += ProtobufOutputStream.getVarIntSize(catalogSerializedSize);
            protoSize += catalogSerializedSize;
        }
        var body = object.body();
        if (body != null) {
            var body0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(body);
            if (body0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                protoSize += ProtobufOutputStream.getStringSize(body0);
            }
        }
        var footer = object.footer();
        if (footer != null) {
            var footer0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(footer);
            if (footer0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(6, 2);
                protoSize += ProtobufOutputStream.getStringSize(footer0);
            }
        }
        var contextInfo = object.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(17, 2);
                var contextInfo0SerializedSize = it.auties.whatsapp.model.info.ContextInfoSpec.sizeOf(contextInfo0);
                protoSize += ProtobufOutputStream.getVarIntSize(contextInfo0SerializedSize);
                protoSize += contextInfo0SerializedSize;
            }
        }
        return protoSize;
    }

}
