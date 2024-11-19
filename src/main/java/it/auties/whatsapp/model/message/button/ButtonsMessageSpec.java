package it.auties.whatsapp.model.message.button;

import it.auties.whatsapp.model.message.button.ButtonsMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ButtonsMessageSpec {
    public static byte[] encode(ButtonsMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var headerText = protoInputObject.headerText();
        if (headerText != null) {
            var headerText0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(headerText);
            if (headerText0 != null) {
                var headerText1 = headerText0.text();
                if (headerText1 != null) {
                    outputStream.writeString(1, headerText1);
                }
            }
        }
        var headerDocument = protoInputObject.headerDocument();
        if (headerDocument != null) {
            var headerDocument0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(headerDocument);
            if (headerDocument0 != null) {
                outputStream.writeBytes(2, it.auties.whatsapp.model.message.standard.DocumentMessageSpec.encode(headerDocument0));
            }
        }
        var headerImage = protoInputObject.headerImage();
        if (headerImage != null) {
            var headerImage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(headerImage);
            if (headerImage0 != null) {
                outputStream.writeBytes(3, it.auties.whatsapp.model.message.standard.ImageMessageSpec.encode(headerImage0));
            }
        }
        var headerVideo = protoInputObject.headerVideo();
        if (headerVideo != null) {
            var headerVideo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(headerVideo);
            if (headerVideo0 != null) {
                outputStream.writeBytes(4, it.auties.whatsapp.model.message.standard.VideoOrGifMessageSpec.encode(headerVideo0));
            }
        }
        var headerLocation = protoInputObject.headerLocation();
        if (headerLocation != null) {
            var headerLocation0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(headerLocation);
            if (headerLocation0 != null) {
                outputStream.writeBytes(5, it.auties.whatsapp.model.message.standard.LocationMessageSpec.encode(headerLocation0));
            }
        }
        var body = protoInputObject.body();
        if (body != null) {
            var body0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(body);
            if (body0 != null) {
                outputStream.writeString(6, body0);
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
        if (protoInputObject.buttons() != null) {
            for (var buttonsEntry : protoInputObject.buttons()) { 
                outputStream.writeBytes(9, it.auties.whatsapp.model.button.base.ButtonSpec.encode(buttonsEntry));
            }
        }
        outputStream.writeInt32(10, it.auties.whatsapp.model.message.button.ButtonsMessageHeaderTypeSpec.encode(protoInputObject.headerType()));
        return outputStream.toByteArray();
    }

    public static ButtonsMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ButtonsMessage decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.message.button.ButtonsMessageHeaderText headerText = null;
        it.auties.whatsapp.model.message.standard.DocumentMessage headerDocument = null;
        it.auties.whatsapp.model.message.standard.ImageMessage headerImage = null;
        it.auties.whatsapp.model.message.standard.VideoOrGifMessage headerVideo = null;
        it.auties.whatsapp.model.message.standard.LocationMessage headerLocation = null;
        java.lang.String body = null;
        java.lang.String footer = null;
        it.auties.whatsapp.model.info.ContextInfo contextInfo = null;
        java.util.List<it.auties.whatsapp.model.button.base.Button> buttons = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        it.auties.whatsapp.model.message.button.ButtonsMessageHeader.Type headerType = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> headerText = it.auties.whatsapp.model.message.button.ButtonsMessageHeaderText.of(protoInputStream.readString());
                case 2 -> headerDocument = it.auties.whatsapp.model.message.standard.DocumentMessageSpec.decode(protoInputStream.lengthDelimitedStream());
                case 3 -> headerImage = it.auties.whatsapp.model.message.standard.ImageMessageSpec.decode(protoInputStream.lengthDelimitedStream());
                case 4 -> headerVideo = it.auties.whatsapp.model.message.standard.VideoOrGifMessageSpec.decode(protoInputStream.lengthDelimitedStream());
                case 5 -> headerLocation = it.auties.whatsapp.model.message.standard.LocationMessageSpec.decode(protoInputStream.lengthDelimitedStream());
                case 6 -> body = protoInputStream.readString();
                case 7 -> footer = protoInputStream.readString();
                case 8 -> contextInfo = it.auties.whatsapp.model.info.ContextInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                case 9 -> buttons.add(it.auties.whatsapp.model.button.base.ButtonSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 10 -> headerType = it.auties.whatsapp.model.message.button.ButtonsMessageHeaderTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.button.ButtonsMessage(headerText, headerDocument, headerImage, headerVideo, headerLocation, body, footer, contextInfo, buttons, headerType);
    }

    public static int sizeOf(ButtonsMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var headerText = object.headerText();
        if (headerText != null) {
            var headerText0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(headerText);
            if (headerText0 != null) {
                var headerText1 = headerText0.text();
                if (headerText1 != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                    protoSize += ProtobufOutputStream.getStringSize(headerText1);
                }
            }
        }
        var headerDocument = object.headerDocument();
        if (headerDocument != null) {
            var headerDocument0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(headerDocument);
            if (headerDocument0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                var headerDocument0SerializedSize = it.auties.whatsapp.model.message.standard.DocumentMessageSpec.sizeOf(headerDocument0);
                protoSize += ProtobufOutputStream.getVarIntSize(headerDocument0SerializedSize);
                protoSize += headerDocument0SerializedSize;
            }
        }
        var headerImage = object.headerImage();
        if (headerImage != null) {
            var headerImage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(headerImage);
            if (headerImage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                var headerImage0SerializedSize = it.auties.whatsapp.model.message.standard.ImageMessageSpec.sizeOf(headerImage0);
                protoSize += ProtobufOutputStream.getVarIntSize(headerImage0SerializedSize);
                protoSize += headerImage0SerializedSize;
            }
        }
        var headerVideo = object.headerVideo();
        if (headerVideo != null) {
            var headerVideo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(headerVideo);
            if (headerVideo0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                var headerVideo0SerializedSize = it.auties.whatsapp.model.message.standard.VideoOrGifMessageSpec.sizeOf(headerVideo0);
                protoSize += ProtobufOutputStream.getVarIntSize(headerVideo0SerializedSize);
                protoSize += headerVideo0SerializedSize;
            }
        }
        var headerLocation = object.headerLocation();
        if (headerLocation != null) {
            var headerLocation0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(headerLocation);
            if (headerLocation0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                var headerLocation0SerializedSize = it.auties.whatsapp.model.message.standard.LocationMessageSpec.sizeOf(headerLocation0);
                protoSize += ProtobufOutputStream.getVarIntSize(headerLocation0SerializedSize);
                protoSize += headerLocation0SerializedSize;
            }
        }
        var body = object.body();
        if (body != null) {
            var body0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(body);
            if (body0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(6, 2);
                protoSize += ProtobufOutputStream.getStringSize(body0);
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
        var buttonsRepeatedField = object.buttons();
        if (buttonsRepeatedField != null) {
            for (var buttonsEntry : buttonsRepeatedField) { 
                if (buttonsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(9, 2);
                    var buttonsEntrySerializedSize = it.auties.whatsapp.model.button.base.ButtonSpec.sizeOf(buttonsEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(buttonsEntrySerializedSize);
                    protoSize += buttonsEntrySerializedSize;
                }
            }
        }
        var headerType = object.headerType();
        if (headerType != null) {
            protoSize += ProtobufOutputStream.getFieldSize(10, 2);
            var headerTypeSerializedSize = it.auties.whatsapp.model.message.button.ButtonsMessageHeaderTypeSpec.sizeOf(headerType);
            protoSize += headerTypeSerializedSize;
        }
        return protoSize;
    }

}
