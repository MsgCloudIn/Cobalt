package it.auties.whatsapp.model.message.button;

import it.auties.whatsapp.model.message.button.ListMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ListMessageSpec {
    public static byte[] encode(ListMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.title());
        var description = protoInputObject.description();
        if (description != null) {
            var description0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(description);
            if (description0 != null) {
                outputStream.writeString(2, description0);
            }
        }
        outputStream.writeString(3, protoInputObject.button());
        outputStream.writeInt32(4, it.auties.whatsapp.model.message.button.ListMessageTypeSpec.encode(protoInputObject.listType()));
        if (protoInputObject.sections() != null) {
            for (var sectionsEntry : protoInputObject.sections()) { 
                outputStream.writeBytes(5, it.auties.whatsapp.model.button.base.ButtonSectionSpec.encode(sectionsEntry));
            }
        }
        var productListInfo = protoInputObject.productListInfo();
        if (productListInfo != null) {
            var productListInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(productListInfo);
            if (productListInfo0 != null) {
                outputStream.writeBytes(6, it.auties.whatsapp.model.info.ProductListInfoSpec.encode(productListInfo0));
            }
        }
        var footer = protoInputObject.footer();
        if (footer != null) {
            var footer0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(footer);
            if (footer0 != null) {
                outputStream.writeString(7, footer0);
            }
        }
        var contextInfo = protoInputObject.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                outputStream.writeBytes(8, it.auties.whatsapp.model.info.ContextInfoSpec.encode(contextInfo0));
            }
        }
        return outputStream.toByteArray();
    }

    public static ListMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ListMessage decode(ProtobufInputStream protoInputStream) {
        java.lang.String title = null;
        java.lang.String description = null;
        java.lang.String button = null;
        it.auties.whatsapp.model.message.button.ListMessage.Type listType = null;
        java.util.List<it.auties.whatsapp.model.button.base.ButtonSection> sections = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        it.auties.whatsapp.model.info.ProductListInfo productListInfo = null;
        java.lang.String footer = null;
        it.auties.whatsapp.model.info.ContextInfo contextInfo = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> title = protoInputStream.readString();
                case 2 -> description = protoInputStream.readString();
                case 3 -> button = protoInputStream.readString();
                case 4 -> listType = it.auties.whatsapp.model.message.button.ListMessageTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 5 -> sections.add(it.auties.whatsapp.model.button.base.ButtonSectionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 6 -> productListInfo = it.auties.whatsapp.model.info.ProductListInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                case 7 -> footer = protoInputStream.readString();
                case 8 -> contextInfo = it.auties.whatsapp.model.info.ContextInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.button.ListMessage(title, description, button, listType, sections, productListInfo, footer, contextInfo);
    }

    public static int sizeOf(ListMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var title = object.title();
        if (title != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(title);
        }
        var description = object.description();
        if (description != null) {
            var description0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(description);
            if (description0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                protoSize += ProtobufOutputStream.getStringSize(description0);
            }
        }
        var button = object.button();
        if (button != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getStringSize(button);
        }
        var listType = object.listType();
        if (listType != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            var listTypeSerializedSize = it.auties.whatsapp.model.message.button.ListMessageTypeSpec.sizeOf(listType);
            protoSize += listTypeSerializedSize;
        }
        var sectionsRepeatedField = object.sections();
        if (sectionsRepeatedField != null) {
            for (var sectionsEntry : sectionsRepeatedField) { 
                if (sectionsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                    var sectionsEntrySerializedSize = it.auties.whatsapp.model.button.base.ButtonSectionSpec.sizeOf(sectionsEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(sectionsEntrySerializedSize);
                    protoSize += sectionsEntrySerializedSize;
                }
            }
        }
        var productListInfo = object.productListInfo();
        if (productListInfo != null) {
            var productListInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(productListInfo);
            if (productListInfo0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(6, 2);
                var productListInfo0SerializedSize = it.auties.whatsapp.model.info.ProductListInfoSpec.sizeOf(productListInfo0);
                protoSize += ProtobufOutputStream.getVarIntSize(productListInfo0SerializedSize);
                protoSize += productListInfo0SerializedSize;
            }
        }
        var footer = object.footer();
        if (footer != null) {
            var footer0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(footer);
            if (footer0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(7, 2);
                protoSize += ProtobufOutputStream.getStringSize(footer0);
            }
        }
        var contextInfo = object.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(8, 2);
                var contextInfo0SerializedSize = it.auties.whatsapp.model.info.ContextInfoSpec.sizeOf(contextInfo0);
                protoSize += ProtobufOutputStream.getVarIntSize(contextInfo0SerializedSize);
                protoSize += contextInfo0SerializedSize;
            }
        }
        return protoSize;
    }

}
