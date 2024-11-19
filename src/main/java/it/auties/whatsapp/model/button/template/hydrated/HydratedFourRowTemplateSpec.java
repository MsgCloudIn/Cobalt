package it.auties.whatsapp.model.button.template.hydrated;

import it.auties.whatsapp.model.button.template.hydrated.HydratedFourRowTemplate;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class HydratedFourRowTemplateSpec {
    public static byte[] encode(HydratedFourRowTemplate protoInputObject) {
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
        var titleText = protoInputObject.titleText();
        if (titleText != null) {
            var titleText0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(titleText);
            if (titleText0 != null) {
                var titleText1 = titleText0.text();
                if (titleText1 != null) {
                    outputStream.writeString(2, titleText1);
                }
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
        outputStream.writeString(6, protoInputObject.body());
        var footer = protoInputObject.footer();
        if (footer != null) {
            var footer0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(footer);
            if (footer0 != null) {
                outputStream.writeString(7, footer0);
            }
        }
        if (protoInputObject.hydratedButtons() != null) {
            for (var hydratedButtonsEntry : protoInputObject.hydratedButtons()) { 
                outputStream.writeBytes(8, it.auties.whatsapp.model.button.template.hydrated.HydratedTemplateButtonSpec.encode(hydratedButtonsEntry));
            }
        }
        outputStream.writeString(9, protoInputObject.templateId());
        return outputStream.toByteArray();
    }

    public static HydratedFourRowTemplate decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static HydratedFourRowTemplate decode(ProtobufInputStream protoInputStream) {
        java.util.Optional<it.auties.whatsapp.model.message.standard.DocumentMessage> titleDocument = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.button.template.hydrated.HydratedFourRowTemplateTextTitle> titleText = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.ImageMessage> titleImage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.VideoOrGifMessage> titleVideo = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.LocationMessage> titleLocation = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.lang.String body = null;
        java.util.Optional<java.lang.String> footer = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.List<it.auties.whatsapp.model.button.template.hydrated.HydratedTemplateButton> hydratedButtons = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        java.lang.String templateId = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> titleDocument = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.DocumentMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 2 -> titleText = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.button.template.hydrated.HydratedFourRowTemplateTextTitle.of(protoInputStream.readString()));
                case 3 -> titleImage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.ImageMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 4 -> titleVideo = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.VideoOrGifMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 5 -> titleLocation = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.LocationMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 6 -> body = protoInputStream.readString();
                case 7 -> footer = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 8 -> hydratedButtons.add(it.auties.whatsapp.model.button.template.hydrated.HydratedTemplateButtonSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 9 -> templateId = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.template.hydrated.HydratedFourRowTemplate(titleDocument, titleText, titleImage, titleVideo, titleLocation, body, footer, hydratedButtons, templateId);
    }

    public static int sizeOf(HydratedFourRowTemplate object) {
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
        var titleText = object.titleText();
        if (titleText != null) {
            var titleText0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(titleText);
            if (titleText0 != null) {
                var titleText1 = titleText0.text();
                if (titleText1 != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                    protoSize += ProtobufOutputStream.getStringSize(titleText1);
                }
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
        var body = object.body();
        if (body != null) {
            protoSize += ProtobufOutputStream.getFieldSize(6, 2);
            protoSize += ProtobufOutputStream.getStringSize(body);
        }
        var footer = object.footer();
        if (footer != null) {
            var footer0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(footer);
            if (footer0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(7, 2);
                protoSize += ProtobufOutputStream.getStringSize(footer0);
            }
        }
        var hydratedButtonsRepeatedField = object.hydratedButtons();
        if (hydratedButtonsRepeatedField != null) {
            for (var hydratedButtonsEntry : hydratedButtonsRepeatedField) { 
                if (hydratedButtonsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(8, 2);
                    var hydratedButtonsEntrySerializedSize = it.auties.whatsapp.model.button.template.hydrated.HydratedTemplateButtonSpec.sizeOf(hydratedButtonsEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(hydratedButtonsEntrySerializedSize);
                    protoSize += hydratedButtonsEntrySerializedSize;
                }
            }
        }
        var templateId = object.templateId();
        if (templateId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(9, 2);
            protoSize += ProtobufOutputStream.getStringSize(templateId);
        }
        return protoSize;
    }

}
