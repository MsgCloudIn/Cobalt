package it.auties.whatsapp.model.button.base;

import it.auties.whatsapp.model.button.base.Button;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ButtonSpec {
    public static byte[] encode(Button protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.id());
        var bodyText = protoInputObject.bodyText();
        if (bodyText != null) {
            var bodyText0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(bodyText);
            if (bodyText0 != null) {
                outputStream.writeBytes(2, it.auties.whatsapp.model.button.base.ButtonTextSpec.encode(bodyText0));
            }
        }
        var bodyNativeFlow = protoInputObject.bodyNativeFlow();
        if (bodyNativeFlow != null) {
            var bodyNativeFlow0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(bodyNativeFlow);
            if (bodyNativeFlow0 != null) {
                outputStream.writeBytes(4, it.auties.whatsapp.model.info.NativeFlowInfoSpec.encode(bodyNativeFlow0));
            }
        }
        outputStream.writeInt32(3, it.auties.whatsapp.model.button.base.ButtonBodyTypeSpec.encode(protoInputObject.bodyType()));
        return outputStream.toByteArray();
    }

    public static Button decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static Button decode(ProtobufInputStream protoInputStream) {
        java.lang.String id = null;
        java.util.Optional<it.auties.whatsapp.model.button.base.ButtonText> bodyText = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.info.NativeFlowInfo> bodyNativeFlow = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        it.auties.whatsapp.model.button.base.ButtonBody.Type bodyType = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> id = protoInputStream.readString();
                case 2 -> bodyText = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.button.base.ButtonTextSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 4 -> bodyNativeFlow = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.info.NativeFlowInfoSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 3 -> bodyType = it.auties.whatsapp.model.button.base.ButtonBodyTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.base.Button(id, bodyText, bodyNativeFlow, bodyType);
    }

    public static int sizeOf(Button object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var id = object.id();
        if (id != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(id);
        }
        var bodyText = object.bodyText();
        if (bodyText != null) {
            var bodyText0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(bodyText);
            if (bodyText0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                var bodyText0SerializedSize = it.auties.whatsapp.model.button.base.ButtonTextSpec.sizeOf(bodyText0);
                protoSize += ProtobufOutputStream.getVarIntSize(bodyText0SerializedSize);
                protoSize += bodyText0SerializedSize;
            }
        }
        var bodyNativeFlow = object.bodyNativeFlow();
        if (bodyNativeFlow != null) {
            var bodyNativeFlow0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(bodyNativeFlow);
            if (bodyNativeFlow0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                var bodyNativeFlow0SerializedSize = it.auties.whatsapp.model.info.NativeFlowInfoSpec.sizeOf(bodyNativeFlow0);
                protoSize += ProtobufOutputStream.getVarIntSize(bodyNativeFlow0SerializedSize);
                protoSize += bodyNativeFlow0SerializedSize;
            }
        }
        var bodyType = object.bodyType();
        if (bodyType != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            var bodyTypeSerializedSize = it.auties.whatsapp.model.button.base.ButtonBodyTypeSpec.sizeOf(bodyType);
            protoSize += bodyTypeSerializedSize;
        }
        return protoSize;
    }

}
