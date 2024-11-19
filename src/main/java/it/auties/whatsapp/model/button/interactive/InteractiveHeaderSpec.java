package it.auties.whatsapp.model.button.interactive;

import it.auties.whatsapp.model.button.interactive.InteractiveHeader;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class InteractiveHeaderSpec {
    public static byte[] encode(InteractiveHeader protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.title());
        var subtitle = protoInputObject.subtitle();
        if (subtitle != null) {
            var subtitle0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(subtitle);
            if (subtitle0 != null) {
                outputStream.writeString(2, subtitle0);
            }
        }
        var attachmentDocument = protoInputObject.attachmentDocument();
        if (attachmentDocument != null) {
            var attachmentDocument0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(attachmentDocument);
            if (attachmentDocument0 != null) {
                outputStream.writeBytes(3, it.auties.whatsapp.model.message.standard.DocumentMessageSpec.encode(attachmentDocument0));
            }
        }
        var attachmentImage = protoInputObject.attachmentImage();
        if (attachmentImage != null) {
            var attachmentImage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(attachmentImage);
            if (attachmentImage0 != null) {
                outputStream.writeBytes(4, it.auties.whatsapp.model.message.standard.ImageMessageSpec.encode(attachmentImage0));
            }
        }
        outputStream.writeBool(5, protoInputObject.mediaAttachment());
        var attachmentThumbnail = protoInputObject.attachmentThumbnail();
        if (attachmentThumbnail != null) {
            var attachmentThumbnail0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(attachmentThumbnail);
            if (attachmentThumbnail0 != null) {
                var attachmentThumbnail1 = attachmentThumbnail0.thumbnail();
                if (attachmentThumbnail1 != null) {
                    outputStream.writeBytes(6, attachmentThumbnail1);
                }
            }
        }
        var attachmentVideo = protoInputObject.attachmentVideo();
        if (attachmentVideo != null) {
            var attachmentVideo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(attachmentVideo);
            if (attachmentVideo0 != null) {
                outputStream.writeBytes(7, it.auties.whatsapp.model.message.standard.VideoOrGifMessageSpec.encode(attachmentVideo0));
            }
        }
        return outputStream.toByteArray();
    }

    public static InteractiveHeader decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static InteractiveHeader decode(ProtobufInputStream protoInputStream) {
        java.lang.String title = null;
        java.util.Optional<java.lang.String> subtitle = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.DocumentMessage> attachmentDocument = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.ImageMessage> attachmentImage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        boolean mediaAttachment = false;
        java.util.Optional<it.auties.whatsapp.model.button.interactive.InteractiveHeaderThumbnail> attachmentThumbnail = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.VideoOrGifMessage> attachmentVideo = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> title = protoInputStream.readString();
                case 2 -> subtitle = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 3 -> attachmentDocument = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.DocumentMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 4 -> attachmentImage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.ImageMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 5 -> mediaAttachment = protoInputStream.readBool();
                case 6 -> attachmentThumbnail = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.button.interactive.InteractiveHeaderThumbnail.of(protoInputStream.readBytes()));
                case 7 -> attachmentVideo = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.VideoOrGifMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.interactive.InteractiveHeader(title, subtitle, attachmentDocument, attachmentImage, mediaAttachment, attachmentThumbnail, attachmentVideo);
    }

    public static int sizeOf(InteractiveHeader object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var title = object.title();
        if (title != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(title);
        }
        var subtitle = object.subtitle();
        if (subtitle != null) {
            var subtitle0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(subtitle);
            if (subtitle0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                protoSize += ProtobufOutputStream.getStringSize(subtitle0);
            }
        }
        var attachmentDocument = object.attachmentDocument();
        if (attachmentDocument != null) {
            var attachmentDocument0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(attachmentDocument);
            if (attachmentDocument0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                var attachmentDocument0SerializedSize = it.auties.whatsapp.model.message.standard.DocumentMessageSpec.sizeOf(attachmentDocument0);
                protoSize += ProtobufOutputStream.getVarIntSize(attachmentDocument0SerializedSize);
                protoSize += attachmentDocument0SerializedSize;
            }
        }
        var attachmentImage = object.attachmentImage();
        if (attachmentImage != null) {
            var attachmentImage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(attachmentImage);
            if (attachmentImage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                var attachmentImage0SerializedSize = it.auties.whatsapp.model.message.standard.ImageMessageSpec.sizeOf(attachmentImage0);
                protoSize += ProtobufOutputStream.getVarIntSize(attachmentImage0SerializedSize);
                protoSize += attachmentImage0SerializedSize;
            }
        }
        var mediaAttachment = object.mediaAttachment();
        protoSize += ProtobufOutputStream.getFieldSize(5, 0);
        protoSize += 1;
        var attachmentThumbnail = object.attachmentThumbnail();
        if (attachmentThumbnail != null) {
            var attachmentThumbnail0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(attachmentThumbnail);
            if (attachmentThumbnail0 != null) {
                var attachmentThumbnail1 = attachmentThumbnail0.thumbnail();
                if (attachmentThumbnail1 != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(6, 2);
                    protoSize += ProtobufOutputStream.getBytesSize(attachmentThumbnail1);
                }
            }
        }
        var attachmentVideo = object.attachmentVideo();
        if (attachmentVideo != null) {
            var attachmentVideo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(attachmentVideo);
            if (attachmentVideo0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(7, 2);
                var attachmentVideo0SerializedSize = it.auties.whatsapp.model.message.standard.VideoOrGifMessageSpec.sizeOf(attachmentVideo0);
                protoSize += ProtobufOutputStream.getVarIntSize(attachmentVideo0SerializedSize);
                protoSize += attachmentVideo0SerializedSize;
            }
        }
        return protoSize;
    }

}
