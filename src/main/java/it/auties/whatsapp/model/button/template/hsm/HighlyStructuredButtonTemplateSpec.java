package it.auties.whatsapp.model.button.template.hsm;

import it.auties.whatsapp.model.button.template.hsm.HighlyStructuredButtonTemplate;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class HighlyStructuredButtonTemplateSpec {
    public static byte[] encode(HighlyStructuredButtonTemplate protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var highlyStructuredQuickReplyButton = protoInputObject.highlyStructuredQuickReplyButton();
        if (highlyStructuredQuickReplyButton != null) {
            var highlyStructuredQuickReplyButton0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(highlyStructuredQuickReplyButton);
            if (highlyStructuredQuickReplyButton0 != null) {
                outputStream.writeBytes(1, it.auties.whatsapp.model.button.template.hsm.HighlyStructuredQuickReplyButtonSpec.encode(highlyStructuredQuickReplyButton0));
            }
        }
        var highlyStructuredUrlButton = protoInputObject.highlyStructuredUrlButton();
        if (highlyStructuredUrlButton != null) {
            var highlyStructuredUrlButton0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(highlyStructuredUrlButton);
            if (highlyStructuredUrlButton0 != null) {
                outputStream.writeBytes(2, it.auties.whatsapp.model.button.template.hsm.HighlyStructuredURLButtonSpec.encode(highlyStructuredUrlButton0));
            }
        }
        var highlyStructuredCallButton = protoInputObject.highlyStructuredCallButton();
        if (highlyStructuredCallButton != null) {
            var highlyStructuredCallButton0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(highlyStructuredCallButton);
            if (highlyStructuredCallButton0 != null) {
                outputStream.writeBytes(3, it.auties.whatsapp.model.button.template.hsm.HighlyStructuredCallButtonSpec.encode(highlyStructuredCallButton0));
            }
        }
        outputStream.writeUInt32(4, protoInputObject.index());
        return outputStream.toByteArray();
    }

    public static HighlyStructuredButtonTemplate decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static HighlyStructuredButtonTemplate decode(ProtobufInputStream protoInputStream) {
        java.util.Optional<it.auties.whatsapp.model.button.template.hsm.HighlyStructuredQuickReplyButton> highlyStructuredQuickReplyButton = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.button.template.hsm.HighlyStructuredURLButton> highlyStructuredUrlButton = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.button.template.hsm.HighlyStructuredCallButton> highlyStructuredCallButton = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        int index = 0;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> highlyStructuredQuickReplyButton = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.button.template.hsm.HighlyStructuredQuickReplyButtonSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 2 -> highlyStructuredUrlButton = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.button.template.hsm.HighlyStructuredURLButtonSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 3 -> highlyStructuredCallButton = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.button.template.hsm.HighlyStructuredCallButtonSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 4 -> index = protoInputStream.readInt32();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.template.hsm.HighlyStructuredButtonTemplate(highlyStructuredQuickReplyButton, highlyStructuredUrlButton, highlyStructuredCallButton, index);
    }

    public static int sizeOf(HighlyStructuredButtonTemplate object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var highlyStructuredQuickReplyButton = object.highlyStructuredQuickReplyButton();
        if (highlyStructuredQuickReplyButton != null) {
            var highlyStructuredQuickReplyButton0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(highlyStructuredQuickReplyButton);
            if (highlyStructuredQuickReplyButton0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                var highlyStructuredQuickReplyButton0SerializedSize = it.auties.whatsapp.model.button.template.hsm.HighlyStructuredQuickReplyButtonSpec.sizeOf(highlyStructuredQuickReplyButton0);
                protoSize += ProtobufOutputStream.getVarIntSize(highlyStructuredQuickReplyButton0SerializedSize);
                protoSize += highlyStructuredQuickReplyButton0SerializedSize;
            }
        }
        var highlyStructuredUrlButton = object.highlyStructuredUrlButton();
        if (highlyStructuredUrlButton != null) {
            var highlyStructuredUrlButton0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(highlyStructuredUrlButton);
            if (highlyStructuredUrlButton0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                var highlyStructuredUrlButton0SerializedSize = it.auties.whatsapp.model.button.template.hsm.HighlyStructuredURLButtonSpec.sizeOf(highlyStructuredUrlButton0);
                protoSize += ProtobufOutputStream.getVarIntSize(highlyStructuredUrlButton0SerializedSize);
                protoSize += highlyStructuredUrlButton0SerializedSize;
            }
        }
        var highlyStructuredCallButton = object.highlyStructuredCallButton();
        if (highlyStructuredCallButton != null) {
            var highlyStructuredCallButton0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(highlyStructuredCallButton);
            if (highlyStructuredCallButton0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                var highlyStructuredCallButton0SerializedSize = it.auties.whatsapp.model.button.template.hsm.HighlyStructuredCallButtonSpec.sizeOf(highlyStructuredCallButton0);
                protoSize += ProtobufOutputStream.getVarIntSize(highlyStructuredCallButton0SerializedSize);
                protoSize += highlyStructuredCallButton0SerializedSize;
            }
        }
        var index = object.index();
        protoSize += ProtobufOutputStream.getFieldSize(4, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(index);
        return protoSize;
    }

}
