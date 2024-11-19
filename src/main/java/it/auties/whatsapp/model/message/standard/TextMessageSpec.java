package it.auties.whatsapp.model.message.standard;

import it.auties.whatsapp.model.message.standard.TextMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class TextMessageSpec {
    public static byte[] encode(TextMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.text());
        var matchedText = protoInputObject.matchedText();
        if (matchedText != null) {
            var matchedText0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(matchedText);
            if (matchedText0 != null) {
                outputStream.writeString(2, matchedText0);
            }
        }
        var canonicalUrl = protoInputObject.canonicalUrl();
        if (canonicalUrl != null) {
            var canonicalUrl0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(canonicalUrl);
            if (canonicalUrl0 != null) {
                outputStream.writeString(4, canonicalUrl0);
            }
        }
        var description = protoInputObject.description();
        if (description != null) {
            var description0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(description);
            if (description0 != null) {
                outputStream.writeString(5, description0);
            }
        }
        var title = protoInputObject.title();
        if (title != null) {
            var title0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(title);
            if (title0 != null) {
                outputStream.writeString(6, title0);
            }
        }
        outputStream.writeFixed32(7, protoInputObject.textArgb());
        var backgroundArgb = protoInputObject.backgroundArgb();
        if (backgroundArgb != null) {
            var backgroundArgb0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableInt(backgroundArgb);
            if (backgroundArgb0 != null) {
                outputStream.writeFixed32(8, backgroundArgb0);
            }
        }
        var font = protoInputObject.font();
        if (font != null) {
            var font0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(font);
            if (font0 != null) {
                outputStream.writeInt32(9, it.auties.whatsapp.model.message.standard.TextMessageFontTypeSpec.encode(font0));
            }
        }
        var previewType = protoInputObject.previewType();
        if (previewType != null) {
            var previewType0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(previewType);
            if (previewType0 != null) {
                outputStream.writeInt32(10, it.auties.whatsapp.model.message.standard.TextMessagePreviewTypeSpec.encode(previewType0));
            }
        }
        var thumbnail = protoInputObject.thumbnail();
        if (thumbnail != null) {
            var thumbnail0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnail);
            if (thumbnail0 != null) {
                outputStream.writeBytes(16, thumbnail0);
            }
        }
        var contextInfo = protoInputObject.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                outputStream.writeBytes(17, it.auties.whatsapp.model.info.ContextInfoSpec.encode(contextInfo0));
            }
        }
        outputStream.writeBool(18, protoInputObject.doNotPlayInline());
        var thumbnailDirectPath = protoInputObject.thumbnailDirectPath();
        if (thumbnailDirectPath != null) {
            var thumbnailDirectPath0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnailDirectPath);
            if (thumbnailDirectPath0 != null) {
                outputStream.writeString(19, thumbnailDirectPath0);
            }
        }
        var thumbnailSha256 = protoInputObject.thumbnailSha256();
        if (thumbnailSha256 != null) {
            var thumbnailSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnailSha256);
            if (thumbnailSha2560 != null) {
                outputStream.writeBytes(20, thumbnailSha2560);
            }
        }
        var thumbnailEncSha256 = protoInputObject.thumbnailEncSha256();
        if (thumbnailEncSha256 != null) {
            var thumbnailEncSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnailEncSha256);
            if (thumbnailEncSha2560 != null) {
                outputStream.writeBytes(21, thumbnailEncSha2560);
            }
        }
        var mediaKey = protoInputObject.mediaKey();
        if (mediaKey != null) {
            var mediaKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaKey);
            if (mediaKey0 != null) {
                outputStream.writeBytes(22, mediaKey0);
            }
        }
        var mediaKeyTimestampSeconds = protoInputObject.mediaKeyTimestampSeconds();
        if (mediaKeyTimestampSeconds != null) {
            var mediaKeyTimestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(mediaKeyTimestampSeconds);
            if (mediaKeyTimestampSeconds0 != null) {
                outputStream.writeInt64(23, mediaKeyTimestampSeconds0);
            }
        }
        var thumbnailHeight = protoInputObject.thumbnailHeight();
        if (thumbnailHeight != null) {
            var thumbnailHeight0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableInt(thumbnailHeight);
            if (thumbnailHeight0 != null) {
                outputStream.writeUInt32(24, thumbnailHeight0);
            }
        }
        var thumbnailWidth = protoInputObject.thumbnailWidth();
        if (thumbnailWidth != null) {
            var thumbnailWidth0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableInt(thumbnailWidth);
            if (thumbnailWidth0 != null) {
                outputStream.writeUInt32(25, thumbnailWidth0);
            }
        }
        var inviteLinkGroupType = protoInputObject.inviteLinkGroupType();
        if (inviteLinkGroupType != null) {
            var inviteLinkGroupType0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(inviteLinkGroupType);
            if (inviteLinkGroupType0 != null) {
                outputStream.writeInt32(26, it.auties.whatsapp.model.message.standard.TextMessageInviteLinkGroupTypeSpec.encode(inviteLinkGroupType0));
            }
        }
        var inviteLinkParentGroupSubjectV2 = protoInputObject.inviteLinkParentGroupSubjectV2();
        if (inviteLinkParentGroupSubjectV2 != null) {
            var inviteLinkParentGroupSubjectV20 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(inviteLinkParentGroupSubjectV2);
            if (inviteLinkParentGroupSubjectV20 != null) {
                outputStream.writeString(27, inviteLinkParentGroupSubjectV20);
            }
        }
        var inviteLinkParentGroupThumbnailV2 = protoInputObject.inviteLinkParentGroupThumbnailV2();
        if (inviteLinkParentGroupThumbnailV2 != null) {
            var inviteLinkParentGroupThumbnailV20 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(inviteLinkParentGroupThumbnailV2);
            if (inviteLinkParentGroupThumbnailV20 != null) {
                outputStream.writeBytes(28, inviteLinkParentGroupThumbnailV20);
            }
        }
        var inviteLinkGroupTypeV2 = protoInputObject.inviteLinkGroupTypeV2();
        if (inviteLinkGroupTypeV2 != null) {
            var inviteLinkGroupTypeV20 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(inviteLinkGroupTypeV2);
            if (inviteLinkGroupTypeV20 != null) {
                outputStream.writeInt32(29, it.auties.whatsapp.model.message.standard.TextMessageInviteLinkGroupTypeSpec.encode(inviteLinkGroupTypeV20));
            }
        }
        outputStream.writeBool(30, protoInputObject.viewOnce());
        return outputStream.toByteArray();
    }

    public static TextMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static TextMessage decode(ProtobufInputStream protoInputStream) {
        java.lang.String text = null;
        java.lang.String matchedText = null;
        java.lang.String canonicalUrl = null;
        java.lang.String description = null;
        java.lang.String title = null;
        java.lang.Integer textArgb = null;
        java.lang.Integer backgroundArgb = null;
        it.auties.whatsapp.model.message.standard.TextMessage.FontType font = null;
        it.auties.whatsapp.model.message.standard.TextMessage.PreviewType previewType = null;
        byte[] thumbnail = null;
        it.auties.whatsapp.model.info.ContextInfo contextInfo = null;
        boolean doNotPlayInline = false;
        java.lang.String thumbnailDirectPath = null;
        byte[] thumbnailSha256 = null;
        byte[] thumbnailEncSha256 = null;
        byte[] mediaKey = null;
        java.lang.Long mediaKeyTimestampSeconds = null;
        java.lang.Integer thumbnailHeight = null;
        java.lang.Integer thumbnailWidth = null;
        it.auties.whatsapp.model.message.standard.TextMessage.InviteLinkGroupType inviteLinkGroupType = null;
        java.lang.String inviteLinkParentGroupSubjectV2 = null;
        byte[] inviteLinkParentGroupThumbnailV2 = null;
        it.auties.whatsapp.model.message.standard.TextMessage.InviteLinkGroupType inviteLinkGroupTypeV2 = null;
        boolean viewOnce = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> text = protoInputStream.readString();
                case 2 -> matchedText = protoInputStream.readString();
                case 4 -> canonicalUrl = protoInputStream.readString();
                case 5 -> description = protoInputStream.readString();
                case 6 -> title = protoInputStream.readString();
                case 7 -> textArgb = protoInputStream.readFixed32();
                case 8 -> backgroundArgb = protoInputStream.readFixed32();
                case 9 -> font = it.auties.whatsapp.model.message.standard.TextMessageFontTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 10 -> previewType = it.auties.whatsapp.model.message.standard.TextMessagePreviewTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 16 -> thumbnail = protoInputStream.readBytes();
                case 17 -> contextInfo = it.auties.whatsapp.model.info.ContextInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                case 18 -> doNotPlayInline = protoInputStream.readBool();
                case 19 -> thumbnailDirectPath = protoInputStream.readString();
                case 20 -> thumbnailSha256 = protoInputStream.readBytes();
                case 21 -> thumbnailEncSha256 = protoInputStream.readBytes();
                case 22 -> mediaKey = protoInputStream.readBytes();
                case 23 -> mediaKeyTimestampSeconds = protoInputStream.readInt64();
                case 24 -> thumbnailHeight = protoInputStream.readInt32();
                case 25 -> thumbnailWidth = protoInputStream.readInt32();
                case 26 -> inviteLinkGroupType = it.auties.whatsapp.model.message.standard.TextMessageInviteLinkGroupTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 27 -> inviteLinkParentGroupSubjectV2 = protoInputStream.readString();
                case 28 -> inviteLinkParentGroupThumbnailV2 = protoInputStream.readBytes();
                case 29 -> inviteLinkGroupTypeV2 = it.auties.whatsapp.model.message.standard.TextMessageInviteLinkGroupTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 30 -> viewOnce = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.standard.TextMessage(text, matchedText, canonicalUrl, description, title, textArgb, backgroundArgb, font, previewType, thumbnail, contextInfo, doNotPlayInline, thumbnailDirectPath, thumbnailSha256, thumbnailEncSha256, mediaKey, mediaKeyTimestampSeconds, thumbnailHeight, thumbnailWidth, inviteLinkGroupType, inviteLinkParentGroupSubjectV2, inviteLinkParentGroupThumbnailV2, inviteLinkGroupTypeV2, viewOnce);
    }

    public static int sizeOf(TextMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var text = object.text();
        if (text != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(text);
        }
        var matchedText = object.matchedText();
        if (matchedText != null) {
            var matchedText0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(matchedText);
            if (matchedText0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                protoSize += ProtobufOutputStream.getStringSize(matchedText0);
            }
        }
        var canonicalUrl = object.canonicalUrl();
        if (canonicalUrl != null) {
            var canonicalUrl0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(canonicalUrl);
            if (canonicalUrl0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                protoSize += ProtobufOutputStream.getStringSize(canonicalUrl0);
            }
        }
        var description = object.description();
        if (description != null) {
            var description0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(description);
            if (description0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                protoSize += ProtobufOutputStream.getStringSize(description0);
            }
        }
        var title = object.title();
        if (title != null) {
            var title0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(title);
            if (title0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(6, 2);
                protoSize += ProtobufOutputStream.getStringSize(title0);
            }
        }
        var textArgb = object.textArgb();
        if (textArgb != null) {
            protoSize += ProtobufOutputStream.getFieldSize(7, 5);
            protoSize += 4;
        }
        var backgroundArgb = object.backgroundArgb();
        if (backgroundArgb != null) {
            var backgroundArgb0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableInt(backgroundArgb);
            if (backgroundArgb0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(8, 5);
                protoSize += 4;
            }
        }
        var font = object.font();
        if (font != null) {
            var font0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(font);
            if (font0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(9, 2);
                var font0SerializedSize = it.auties.whatsapp.model.message.standard.TextMessageFontTypeSpec.sizeOf(font0);
                protoSize += font0SerializedSize;
            }
        }
        var previewType = object.previewType();
        if (previewType != null) {
            var previewType0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(previewType);
            if (previewType0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(10, 2);
                var previewType0SerializedSize = it.auties.whatsapp.model.message.standard.TextMessagePreviewTypeSpec.sizeOf(previewType0);
                protoSize += previewType0SerializedSize;
            }
        }
        var thumbnail = object.thumbnail();
        if (thumbnail != null) {
            var thumbnail0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnail);
            if (thumbnail0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(16, 2);
                protoSize += ProtobufOutputStream.getBytesSize(thumbnail0);
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
        var doNotPlayInline = object.doNotPlayInline();
        protoSize += ProtobufOutputStream.getFieldSize(18, 0);
        protoSize += 1;
        var thumbnailDirectPath = object.thumbnailDirectPath();
        if (thumbnailDirectPath != null) {
            var thumbnailDirectPath0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnailDirectPath);
            if (thumbnailDirectPath0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(19, 2);
                protoSize += ProtobufOutputStream.getStringSize(thumbnailDirectPath0);
            }
        }
        var thumbnailSha256 = object.thumbnailSha256();
        if (thumbnailSha256 != null) {
            var thumbnailSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnailSha256);
            if (thumbnailSha2560 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(20, 2);
                protoSize += ProtobufOutputStream.getBytesSize(thumbnailSha2560);
            }
        }
        var thumbnailEncSha256 = object.thumbnailEncSha256();
        if (thumbnailEncSha256 != null) {
            var thumbnailEncSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnailEncSha256);
            if (thumbnailEncSha2560 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(21, 2);
                protoSize += ProtobufOutputStream.getBytesSize(thumbnailEncSha2560);
            }
        }
        var mediaKey = object.mediaKey();
        if (mediaKey != null) {
            var mediaKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaKey);
            if (mediaKey0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(22, 2);
                protoSize += ProtobufOutputStream.getBytesSize(mediaKey0);
            }
        }
        var mediaKeyTimestampSeconds = object.mediaKeyTimestampSeconds();
        if (mediaKeyTimestampSeconds != null) {
            var mediaKeyTimestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(mediaKeyTimestampSeconds);
            if (mediaKeyTimestampSeconds0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(23, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(mediaKeyTimestampSeconds0);
            }
        }
        var thumbnailHeight = object.thumbnailHeight();
        if (thumbnailHeight != null) {
            var thumbnailHeight0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableInt(thumbnailHeight);
            if (thumbnailHeight0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(24, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(thumbnailHeight0);
            }
        }
        var thumbnailWidth = object.thumbnailWidth();
        if (thumbnailWidth != null) {
            var thumbnailWidth0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableInt(thumbnailWidth);
            if (thumbnailWidth0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(25, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(thumbnailWidth0);
            }
        }
        var inviteLinkGroupType = object.inviteLinkGroupType();
        if (inviteLinkGroupType != null) {
            var inviteLinkGroupType0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(inviteLinkGroupType);
            if (inviteLinkGroupType0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(26, 2);
                var inviteLinkGroupType0SerializedSize = it.auties.whatsapp.model.message.standard.TextMessageInviteLinkGroupTypeSpec.sizeOf(inviteLinkGroupType0);
                protoSize += inviteLinkGroupType0SerializedSize;
            }
        }
        var inviteLinkParentGroupSubjectV2 = object.inviteLinkParentGroupSubjectV2();
        if (inviteLinkParentGroupSubjectV2 != null) {
            var inviteLinkParentGroupSubjectV20 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(inviteLinkParentGroupSubjectV2);
            if (inviteLinkParentGroupSubjectV20 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(27, 2);
                protoSize += ProtobufOutputStream.getStringSize(inviteLinkParentGroupSubjectV20);
            }
        }
        var inviteLinkParentGroupThumbnailV2 = object.inviteLinkParentGroupThumbnailV2();
        if (inviteLinkParentGroupThumbnailV2 != null) {
            var inviteLinkParentGroupThumbnailV20 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(inviteLinkParentGroupThumbnailV2);
            if (inviteLinkParentGroupThumbnailV20 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(28, 2);
                protoSize += ProtobufOutputStream.getBytesSize(inviteLinkParentGroupThumbnailV20);
            }
        }
        var inviteLinkGroupTypeV2 = object.inviteLinkGroupTypeV2();
        if (inviteLinkGroupTypeV2 != null) {
            var inviteLinkGroupTypeV20 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(inviteLinkGroupTypeV2);
            if (inviteLinkGroupTypeV20 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(29, 2);
                var inviteLinkGroupTypeV20SerializedSize = it.auties.whatsapp.model.message.standard.TextMessageInviteLinkGroupTypeSpec.sizeOf(inviteLinkGroupTypeV20);
                protoSize += inviteLinkGroupTypeV20SerializedSize;
            }
        }
        var viewOnce = object.viewOnce();
        protoSize += ProtobufOutputStream.getFieldSize(30, 0);
        protoSize += 1;
        return protoSize;
    }

}
