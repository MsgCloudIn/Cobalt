package it.auties.whatsapp.model.message.button;

import it.auties.whatsapp.model.message.button.InteractiveMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class InteractiveMessageSpec {
    public static byte[] encode(InteractiveMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var header = protoInputObject.header();
        if (header != null) {
            var header0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(header);
            if (header0 != null) {
                outputStream.writeBytes(1, it.auties.whatsapp.model.button.interactive.InteractiveHeaderSpec.encode(header0));
            }
        }
        var body = protoInputObject.body();
        if (body != null) {
            var body0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(body);
            if (body0 != null) {
                outputStream.writeBytes(2, it.auties.whatsapp.model.button.interactive.InteractiveBodySpec.encode(body0));
            }
        }
        var footer = protoInputObject.footer();
        if (footer != null) {
            var footer0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(footer);
            if (footer0 != null) {
                outputStream.writeBytes(3, it.auties.whatsapp.model.button.interactive.InteractiveFooterSpec.encode(footer0));
            }
        }
        var contentShop = protoInputObject.contentShop();
        if (contentShop != null) {
            var contentShop0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contentShop);
            if (contentShop0 != null) {
                outputStream.writeBytes(4, it.auties.whatsapp.model.button.interactive.InteractiveShopSpec.encode(contentShop0));
            }
        }
        var contentCollection = protoInputObject.contentCollection();
        if (contentCollection != null) {
            var contentCollection0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contentCollection);
            if (contentCollection0 != null) {
                outputStream.writeBytes(5, it.auties.whatsapp.model.button.interactive.InteractiveCollectionSpec.encode(contentCollection0));
            }
        }
        var contentNativeFlow = protoInputObject.contentNativeFlow();
        if (contentNativeFlow != null) {
            var contentNativeFlow0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contentNativeFlow);
            if (contentNativeFlow0 != null) {
                outputStream.writeBytes(6, it.auties.whatsapp.model.button.interactive.InteractiveNativeFlowSpec.encode(contentNativeFlow0));
            }
        }
        var contextInfo = protoInputObject.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                outputStream.writeBytes(15, it.auties.whatsapp.model.info.ContextInfoSpec.encode(contextInfo0));
            }
        }
        return outputStream.toByteArray();
    }

    public static InteractiveMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static InteractiveMessage decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.button.interactive.InteractiveHeader header = null;
        it.auties.whatsapp.model.button.interactive.InteractiveBody body = null;
        it.auties.whatsapp.model.button.interactive.InteractiveFooter footer = null;
        it.auties.whatsapp.model.button.interactive.InteractiveShop contentShop = null;
        it.auties.whatsapp.model.button.interactive.InteractiveCollection contentCollection = null;
        it.auties.whatsapp.model.button.interactive.InteractiveNativeFlow contentNativeFlow = null;
        it.auties.whatsapp.model.info.ContextInfo contextInfo = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> header = it.auties.whatsapp.model.button.interactive.InteractiveHeaderSpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> body = it.auties.whatsapp.model.button.interactive.InteractiveBodySpec.decode(protoInputStream.lengthDelimitedStream());
                case 3 -> footer = it.auties.whatsapp.model.button.interactive.InteractiveFooterSpec.decode(protoInputStream.lengthDelimitedStream());
                case 4 -> contentShop = it.auties.whatsapp.model.button.interactive.InteractiveShopSpec.decode(protoInputStream.lengthDelimitedStream());
                case 5 -> contentCollection = it.auties.whatsapp.model.button.interactive.InteractiveCollectionSpec.decode(protoInputStream.lengthDelimitedStream());
                case 6 -> contentNativeFlow = it.auties.whatsapp.model.button.interactive.InteractiveNativeFlowSpec.decode(protoInputStream.lengthDelimitedStream());
                case 15 -> contextInfo = it.auties.whatsapp.model.info.ContextInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.button.InteractiveMessage(header, body, footer, contentShop, contentCollection, contentNativeFlow, contextInfo);
    }

    public static int sizeOf(InteractiveMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var header = object.header();
        if (header != null) {
            var header0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(header);
            if (header0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                var header0SerializedSize = it.auties.whatsapp.model.button.interactive.InteractiveHeaderSpec.sizeOf(header0);
                protoSize += ProtobufOutputStream.getVarIntSize(header0SerializedSize);
                protoSize += header0SerializedSize;
            }
        }
        var body = object.body();
        if (body != null) {
            var body0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(body);
            if (body0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                var body0SerializedSize = it.auties.whatsapp.model.button.interactive.InteractiveBodySpec.sizeOf(body0);
                protoSize += ProtobufOutputStream.getVarIntSize(body0SerializedSize);
                protoSize += body0SerializedSize;
            }
        }
        var footer = object.footer();
        if (footer != null) {
            var footer0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(footer);
            if (footer0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                var footer0SerializedSize = it.auties.whatsapp.model.button.interactive.InteractiveFooterSpec.sizeOf(footer0);
                protoSize += ProtobufOutputStream.getVarIntSize(footer0SerializedSize);
                protoSize += footer0SerializedSize;
            }
        }
        var contentShop = object.contentShop();
        if (contentShop != null) {
            var contentShop0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contentShop);
            if (contentShop0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                var contentShop0SerializedSize = it.auties.whatsapp.model.button.interactive.InteractiveShopSpec.sizeOf(contentShop0);
                protoSize += ProtobufOutputStream.getVarIntSize(contentShop0SerializedSize);
                protoSize += contentShop0SerializedSize;
            }
        }
        var contentCollection = object.contentCollection();
        if (contentCollection != null) {
            var contentCollection0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contentCollection);
            if (contentCollection0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                var contentCollection0SerializedSize = it.auties.whatsapp.model.button.interactive.InteractiveCollectionSpec.sizeOf(contentCollection0);
                protoSize += ProtobufOutputStream.getVarIntSize(contentCollection0SerializedSize);
                protoSize += contentCollection0SerializedSize;
            }
        }
        var contentNativeFlow = object.contentNativeFlow();
        if (contentNativeFlow != null) {
            var contentNativeFlow0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contentNativeFlow);
            if (contentNativeFlow0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(6, 2);
                var contentNativeFlow0SerializedSize = it.auties.whatsapp.model.button.interactive.InteractiveNativeFlowSpec.sizeOf(contentNativeFlow0);
                protoSize += ProtobufOutputStream.getVarIntSize(contentNativeFlow0SerializedSize);
                protoSize += contentNativeFlow0SerializedSize;
            }
        }
        var contextInfo = object.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(15, 2);
                var contextInfo0SerializedSize = it.auties.whatsapp.model.info.ContextInfoSpec.sizeOf(contextInfo0);
                protoSize += ProtobufOutputStream.getVarIntSize(contextInfo0SerializedSize);
                protoSize += contextInfo0SerializedSize;
            }
        }
        return protoSize;
    }

}
