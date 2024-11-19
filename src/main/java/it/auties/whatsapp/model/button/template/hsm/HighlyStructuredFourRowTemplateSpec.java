package it.auties.whatsapp.model.button.template.hsm;

import it.auties.whatsapp.model.button.template.hsm.HighlyStructuredFourRowTemplate;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class HighlyStructuredFourRowTemplateSpec {
    public static byte[] encode(HighlyStructuredFourRowTemplate protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var titleDocument = protoInputObject.titleDocument();
        if (titleDocument != null) {
            var titleDocument0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(titleDocument);
            if (titleDocument0 != null) {
                outputStream.writeBytes(1, it.auties.whatsapp.model.message.standard.DocumentMessageSpec.encode(titleDocument0));
            }
        }
        var titleHighlyStructured = protoInputObject.titleHighlyStructured();
        if (titleHighlyStructured != null) {
            var titleHighlyStructured0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(titleHighlyStructured);
            if (titleHighlyStructured0 != null) {
                outputStream.writeBytes(2, it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessageSpec.encode(titleHighlyStructured0));
            }
        }
        var titleImage = protoInputObject.titleImage();
        if (titleImage != null) {
            var titleImage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(titleImage);
            if (titleImage0 != null) {
                outputStream.writeBytes(3, it.auties.whatsapp.model.message.standard.ImageMessageSpec.encode(titleImage0));
            }
        }
        var titleVideo = protoInputObject.titleVideo();
        if (titleVideo != null) {
            var titleVideo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(titleVideo);
            if (titleVideo0 != null) {
                outputStream.writeBytes(4, it.auties.whatsapp.model.message.standard.VideoOrGifMessageSpec.encode(titleVideo0));
            }
        }
        var titleLocation = protoInputObject.titleLocation();
        if (titleLocation != null) {
            var titleLocation0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(titleLocation);
            if (titleLocation0 != null) {
                outputStream.writeBytes(5, it.auties.whatsapp.model.message.standard.LocationMessageSpec.encode(titleLocation0));
            }
        }
        outputStream.writeBytes(6, it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessageSpec.encode(protoInputObject.content()));
        var footer = protoInputObject.footer();
        if (footer != null) {
            var footer0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(footer);
            if (footer0 != null) {
                outputStream.writeBytes(7, it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessageSpec.encode(footer0));
            }
        }
        if (protoInputObject.buttons() != null) {
            for (var buttonsEntry : protoInputObject.buttons()) { 
                outputStream.writeBytes(8, it.auties.whatsapp.model.button.template.hsm.HighlyStructuredButtonTemplateSpec.encode(buttonsEntry));
            }
        }
        return outputStream.toByteArray();
    }

    public static HighlyStructuredFourRowTemplate decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static HighlyStructuredFourRowTemplate decode(ProtobufInputStream protoInputStream) {
        java.util.Optional<it.auties.whatsapp.model.message.standard.DocumentMessage> titleDocument = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessage> titleHighlyStructured = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.ImageMessage> titleImage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.VideoOrGifMessage> titleVideo = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.LocationMessage> titleLocation = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessage content = null;
        java.util.Optional<it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessage> footer = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.List<it.auties.whatsapp.model.button.template.hsm.HighlyStructuredButtonTemplate> buttons = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> titleDocument = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.DocumentMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 2 -> titleHighlyStructured = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 3 -> titleImage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.ImageMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 4 -> titleVideo = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.VideoOrGifMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 5 -> titleLocation = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.LocationMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 6 -> content = it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessageSpec.decode(protoInputStream.lengthDelimitedStream());
                case 7 -> footer = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 8 -> buttons.add(it.auties.whatsapp.model.button.template.hsm.HighlyStructuredButtonTemplateSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.template.hsm.HighlyStructuredFourRowTemplate(titleDocument, titleHighlyStructured, titleImage, titleVideo, titleLocation, content, footer, buttons);
    }

    public static int sizeOf(HighlyStructuredFourRowTemplate object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var titleDocument = object.titleDocument();
        if (titleDocument != null) {
            var titleDocument0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(titleDocument);
            if (titleDocument0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                var titleDocument0SerializedSize = it.auties.whatsapp.model.message.standard.DocumentMessageSpec.sizeOf(titleDocument0);
                protoSize += ProtobufOutputStream.getVarIntSize(titleDocument0SerializedSize);
                protoSize += titleDocument0SerializedSize;
            }
        }
        var titleHighlyStructured = object.titleHighlyStructured();
        if (titleHighlyStructured != null) {
            var titleHighlyStructured0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(titleHighlyStructured);
            if (titleHighlyStructured0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                var titleHighlyStructured0SerializedSize = it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessageSpec.sizeOf(titleHighlyStructured0);
                protoSize += ProtobufOutputStream.getVarIntSize(titleHighlyStructured0SerializedSize);
                protoSize += titleHighlyStructured0SerializedSize;
            }
        }
        var titleImage = object.titleImage();
        if (titleImage != null) {
            var titleImage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(titleImage);
            if (titleImage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                var titleImage0SerializedSize = it.auties.whatsapp.model.message.standard.ImageMessageSpec.sizeOf(titleImage0);
                protoSize += ProtobufOutputStream.getVarIntSize(titleImage0SerializedSize);
                protoSize += titleImage0SerializedSize;
            }
        }
        var titleVideo = object.titleVideo();
        if (titleVideo != null) {
            var titleVideo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(titleVideo);
            if (titleVideo0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                var titleVideo0SerializedSize = it.auties.whatsapp.model.message.standard.VideoOrGifMessageSpec.sizeOf(titleVideo0);
                protoSize += ProtobufOutputStream.getVarIntSize(titleVideo0SerializedSize);
                protoSize += titleVideo0SerializedSize;
            }
        }
        var titleLocation = object.titleLocation();
        if (titleLocation != null) {
            var titleLocation0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(titleLocation);
            if (titleLocation0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                var titleLocation0SerializedSize = it.auties.whatsapp.model.message.standard.LocationMessageSpec.sizeOf(titleLocation0);
                protoSize += ProtobufOutputStream.getVarIntSize(titleLocation0SerializedSize);
                protoSize += titleLocation0SerializedSize;
            }
        }
        var content = object.content();
        if (content != null) {
            protoSize += ProtobufOutputStream.getFieldSize(6, 2);
            var contentSerializedSize = it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessageSpec.sizeOf(content);
            protoSize += ProtobufOutputStream.getVarIntSize(contentSerializedSize);
            protoSize += contentSerializedSize;
        }
        var footer = object.footer();
        if (footer != null) {
            var footer0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(footer);
            if (footer0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(7, 2);
                var footer0SerializedSize = it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessageSpec.sizeOf(footer0);
                protoSize += ProtobufOutputStream.getVarIntSize(footer0SerializedSize);
                protoSize += footer0SerializedSize;
            }
        }
        var buttonsRepeatedField = object.buttons();
        if (buttonsRepeatedField != null) {
            for (var buttonsEntry : buttonsRepeatedField) { 
                if (buttonsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(8, 2);
                    var buttonsEntrySerializedSize = it.auties.whatsapp.model.button.template.hsm.HighlyStructuredButtonTemplateSpec.sizeOf(buttonsEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(buttonsEntrySerializedSize);
                    protoSize += buttonsEntrySerializedSize;
                }
            }
        }
        return protoSize;
    }

}
