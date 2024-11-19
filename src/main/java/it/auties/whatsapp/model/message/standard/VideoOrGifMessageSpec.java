package it.auties.whatsapp.model.message.standard;

import it.auties.whatsapp.model.message.standard.VideoOrGifMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class VideoOrGifMessageSpec {
    public static byte[] encode(VideoOrGifMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var mediaUrl = protoInputObject.mediaUrl();
        if (mediaUrl != null) {
            var mediaUrl0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaUrl);
            if (mediaUrl0 != null) {
                outputStream.writeString(1, mediaUrl0);
            }
        }
        var mimetype = protoInputObject.mimetype();
        if (mimetype != null) {
            var mimetype0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mimetype);
            if (mimetype0 != null) {
                outputStream.writeString(2, mimetype0);
            }
        }
        var mediaSha256 = protoInputObject.mediaSha256();
        if (mediaSha256 != null) {
            var mediaSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaSha256);
            if (mediaSha2560 != null) {
                outputStream.writeBytes(3, mediaSha2560);
            }
        }
        var mediaSize = protoInputObject.mediaSize();
        if (mediaSize != null) {
            var mediaSize0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(mediaSize);
            if (mediaSize0 != null) {
                outputStream.writeUInt64(4, mediaSize0);
            }
        }
        var duration = protoInputObject.duration();
        if (duration != null) {
            var duration0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableInt(duration);
            if (duration0 != null) {
                outputStream.writeUInt32(5, duration0);
            }
        }
        var mediaKey = protoInputObject.mediaKey();
        if (mediaKey != null) {
            var mediaKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaKey);
            if (mediaKey0 != null) {
                outputStream.writeBytes(6, mediaKey0);
            }
        }
        var caption = protoInputObject.caption();
        if (caption != null) {
            var caption0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(caption);
            if (caption0 != null) {
                outputStream.writeString(7, caption0);
            }
        }
        outputStream.writeBool(8, protoInputObject.gifPlayback());
        var height = protoInputObject.height();
        if (height != null) {
            var height0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableInt(height);
            if (height0 != null) {
                outputStream.writeUInt32(9, height0);
            }
        }
        var width = protoInputObject.width();
        if (width != null) {
            var width0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableInt(width);
            if (width0 != null) {
                outputStream.writeUInt32(10, width0);
            }
        }
        var mediaEncryptedSha256 = protoInputObject.mediaEncryptedSha256();
        if (mediaEncryptedSha256 != null) {
            var mediaEncryptedSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaEncryptedSha256);
            if (mediaEncryptedSha2560 != null) {
                outputStream.writeBytes(11, mediaEncryptedSha2560);
            }
        }
        if (protoInputObject.interactiveAnnotations() != null) {
            for (var interactiveAnnotationsEntry : protoInputObject.interactiveAnnotations()) { 
                outputStream.writeBytes(12, it.auties.whatsapp.model.button.interactive.InteractiveLocationAnnotationSpec.encode(interactiveAnnotationsEntry));
            }
        }
        var mediaDirectPath = protoInputObject.mediaDirectPath();
        if (mediaDirectPath != null) {
            var mediaDirectPath0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaDirectPath);
            if (mediaDirectPath0 != null) {
                outputStream.writeString(13, mediaDirectPath0);
            }
        }
        var mediaKeyTimestampSeconds = protoInputObject.mediaKeyTimestampSeconds();
        if (mediaKeyTimestampSeconds != null) {
            var mediaKeyTimestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(mediaKeyTimestampSeconds);
            if (mediaKeyTimestampSeconds0 != null) {
                outputStream.writeInt64(14, mediaKeyTimestampSeconds0);
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
        var streamingSidecar = protoInputObject.streamingSidecar();
        if (streamingSidecar != null) {
            var streamingSidecar0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(streamingSidecar);
            if (streamingSidecar0 != null) {
                outputStream.writeBytes(18, streamingSidecar0);
            }
        }
        var gifAttribution = protoInputObject.gifAttribution();
        if (gifAttribution != null) {
            var gifAttribution0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(gifAttribution);
            if (gifAttribution0 != null) {
                outputStream.writeInt32(19, it.auties.whatsapp.model.message.standard.VideoOrGifMessageAttributionSpec.encode(gifAttribution0));
            }
        }
        outputStream.writeBool(20, protoInputObject.viewOnce());
        var thumbnailDirectPath = protoInputObject.thumbnailDirectPath();
        if (thumbnailDirectPath != null) {
            var thumbnailDirectPath0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnailDirectPath);
            if (thumbnailDirectPath0 != null) {
                outputStream.writeString(21, thumbnailDirectPath0);
            }
        }
        var thumbnailSha256 = protoInputObject.thumbnailSha256();
        if (thumbnailSha256 != null) {
            var thumbnailSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnailSha256);
            if (thumbnailSha2560 != null) {
                outputStream.writeBytes(22, thumbnailSha2560);
            }
        }
        var thumbnailEncSha256 = protoInputObject.thumbnailEncSha256();
        if (thumbnailEncSha256 != null) {
            var thumbnailEncSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnailEncSha256);
            if (thumbnailEncSha2560 != null) {
                outputStream.writeBytes(23, thumbnailEncSha2560);
            }
        }
        var staticUrl = protoInputObject.staticUrl();
        if (staticUrl != null) {
            var staticUrl0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(staticUrl);
            if (staticUrl0 != null) {
                outputStream.writeString(24, staticUrl0);
            }
        }
        return outputStream.toByteArray();
    }

    public static VideoOrGifMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static VideoOrGifMessage decode(ProtobufInputStream protoInputStream) {
        java.lang.String mediaUrl = null;
        java.lang.String mimetype = null;
        byte[] mediaSha256 = null;
        java.lang.Long mediaSize = null;
        java.lang.Integer duration = null;
        byte[] mediaKey = null;
        java.lang.String caption = null;
        boolean gifPlayback = false;
        java.lang.Integer height = null;
        java.lang.Integer width = null;
        byte[] mediaEncryptedSha256 = null;
        java.util.List<it.auties.whatsapp.model.button.interactive.InteractiveLocationAnnotation> interactiveAnnotations = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        java.lang.String mediaDirectPath = null;
        long mediaKeyTimestampSeconds = 0l;
        byte[] thumbnail = null;
        it.auties.whatsapp.model.info.ContextInfo contextInfo = null;
        byte[] streamingSidecar = null;
        it.auties.whatsapp.model.message.standard.VideoOrGifMessage.Attribution gifAttribution = null;
        boolean viewOnce = false;
        java.lang.String thumbnailDirectPath = null;
        byte[] thumbnailSha256 = null;
        byte[] thumbnailEncSha256 = null;
        java.lang.String staticUrl = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> mediaUrl = protoInputStream.readString();
                case 2 -> mimetype = protoInputStream.readString();
                case 3 -> mediaSha256 = protoInputStream.readBytes();
                case 4 -> mediaSize = protoInputStream.readInt64();
                case 5 -> duration = protoInputStream.readInt32();
                case 6 -> mediaKey = protoInputStream.readBytes();
                case 7 -> caption = protoInputStream.readString();
                case 8 -> gifPlayback = protoInputStream.readBool();
                case 9 -> height = protoInputStream.readInt32();
                case 10 -> width = protoInputStream.readInt32();
                case 11 -> mediaEncryptedSha256 = protoInputStream.readBytes();
                case 12 -> interactiveAnnotations.add(it.auties.whatsapp.model.button.interactive.InteractiveLocationAnnotationSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 13 -> mediaDirectPath = protoInputStream.readString();
                case 14 -> mediaKeyTimestampSeconds = protoInputStream.readInt64();
                case 16 -> thumbnail = protoInputStream.readBytes();
                case 17 -> contextInfo = it.auties.whatsapp.model.info.ContextInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                case 18 -> streamingSidecar = protoInputStream.readBytes();
                case 19 -> gifAttribution = it.auties.whatsapp.model.message.standard.VideoOrGifMessageAttributionSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 20 -> viewOnce = protoInputStream.readBool();
                case 21 -> thumbnailDirectPath = protoInputStream.readString();
                case 22 -> thumbnailSha256 = protoInputStream.readBytes();
                case 23 -> thumbnailEncSha256 = protoInputStream.readBytes();
                case 24 -> staticUrl = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.standard.VideoOrGifMessage(mediaUrl, mimetype, mediaSha256, mediaSize, duration, mediaKey, caption, gifPlayback, height, width, mediaEncryptedSha256, interactiveAnnotations, mediaDirectPath, mediaKeyTimestampSeconds, thumbnail, contextInfo, streamingSidecar, gifAttribution, viewOnce, thumbnailDirectPath, thumbnailSha256, thumbnailEncSha256, staticUrl);
    }

    public static int sizeOf(VideoOrGifMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var mediaUrl = object.mediaUrl();
        if (mediaUrl != null) {
            var mediaUrl0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaUrl);
            if (mediaUrl0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(mediaUrl0);
            }
        }
        var mimetype = object.mimetype();
        if (mimetype != null) {
            var mimetype0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mimetype);
            if (mimetype0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                protoSize += ProtobufOutputStream.getStringSize(mimetype0);
            }
        }
        var mediaSha256 = object.mediaSha256();
        if (mediaSha256 != null) {
            var mediaSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaSha256);
            if (mediaSha2560 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                protoSize += ProtobufOutputStream.getBytesSize(mediaSha2560);
            }
        }
        var mediaSize = object.mediaSize();
        if (mediaSize != null) {
            var mediaSize0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(mediaSize);
            if (mediaSize0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(mediaSize0);
            }
        }
        var duration = object.duration();
        if (duration != null) {
            var duration0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableInt(duration);
            if (duration0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(duration0);
            }
        }
        var mediaKey = object.mediaKey();
        if (mediaKey != null) {
            var mediaKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaKey);
            if (mediaKey0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(6, 2);
                protoSize += ProtobufOutputStream.getBytesSize(mediaKey0);
            }
        }
        var caption = object.caption();
        if (caption != null) {
            var caption0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(caption);
            if (caption0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(7, 2);
                protoSize += ProtobufOutputStream.getStringSize(caption0);
            }
        }
        var gifPlayback = object.gifPlayback();
        protoSize += ProtobufOutputStream.getFieldSize(8, 0);
        protoSize += 1;
        var height = object.height();
        if (height != null) {
            var height0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableInt(height);
            if (height0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(9, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(height0);
            }
        }
        var width = object.width();
        if (width != null) {
            var width0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableInt(width);
            if (width0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(10, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(width0);
            }
        }
        var mediaEncryptedSha256 = object.mediaEncryptedSha256();
        if (mediaEncryptedSha256 != null) {
            var mediaEncryptedSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaEncryptedSha256);
            if (mediaEncryptedSha2560 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(11, 2);
                protoSize += ProtobufOutputStream.getBytesSize(mediaEncryptedSha2560);
            }
        }
        var interactiveAnnotationsRepeatedField = object.interactiveAnnotations();
        if (interactiveAnnotationsRepeatedField != null) {
            for (var interactiveAnnotationsEntry : interactiveAnnotationsRepeatedField) { 
                if (interactiveAnnotationsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(12, 2);
                    var interactiveAnnotationsEntrySerializedSize = it.auties.whatsapp.model.button.interactive.InteractiveLocationAnnotationSpec.sizeOf(interactiveAnnotationsEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(interactiveAnnotationsEntrySerializedSize);
                    protoSize += interactiveAnnotationsEntrySerializedSize;
                }
            }
        }
        var mediaDirectPath = object.mediaDirectPath();
        if (mediaDirectPath != null) {
            var mediaDirectPath0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaDirectPath);
            if (mediaDirectPath0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(13, 2);
                protoSize += ProtobufOutputStream.getStringSize(mediaDirectPath0);
            }
        }
        var mediaKeyTimestampSeconds = object.mediaKeyTimestampSeconds();
        if (mediaKeyTimestampSeconds != null) {
            var mediaKeyTimestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(mediaKeyTimestampSeconds);
            if (mediaKeyTimestampSeconds0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(14, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(mediaKeyTimestampSeconds0);
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
        var streamingSidecar = object.streamingSidecar();
        if (streamingSidecar != null) {
            var streamingSidecar0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(streamingSidecar);
            if (streamingSidecar0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(18, 2);
                protoSize += ProtobufOutputStream.getBytesSize(streamingSidecar0);
            }
        }
        var gifAttribution = object.gifAttribution();
        if (gifAttribution != null) {
            var gifAttribution0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(gifAttribution);
            if (gifAttribution0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(19, 2);
                var gifAttribution0SerializedSize = it.auties.whatsapp.model.message.standard.VideoOrGifMessageAttributionSpec.sizeOf(gifAttribution0);
                protoSize += gifAttribution0SerializedSize;
            }
        }
        var viewOnce = object.viewOnce();
        protoSize += ProtobufOutputStream.getFieldSize(20, 0);
        protoSize += 1;
        var thumbnailDirectPath = object.thumbnailDirectPath();
        if (thumbnailDirectPath != null) {
            var thumbnailDirectPath0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnailDirectPath);
            if (thumbnailDirectPath0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(21, 2);
                protoSize += ProtobufOutputStream.getStringSize(thumbnailDirectPath0);
            }
        }
        var thumbnailSha256 = object.thumbnailSha256();
        if (thumbnailSha256 != null) {
            var thumbnailSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnailSha256);
            if (thumbnailSha2560 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(22, 2);
                protoSize += ProtobufOutputStream.getBytesSize(thumbnailSha2560);
            }
        }
        var thumbnailEncSha256 = object.thumbnailEncSha256();
        if (thumbnailEncSha256 != null) {
            var thumbnailEncSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnailEncSha256);
            if (thumbnailEncSha2560 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(23, 2);
                protoSize += ProtobufOutputStream.getBytesSize(thumbnailEncSha2560);
            }
        }
        var staticUrl = object.staticUrl();
        if (staticUrl != null) {
            var staticUrl0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(staticUrl);
            if (staticUrl0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(24, 2);
                protoSize += ProtobufOutputStream.getStringSize(staticUrl0);
            }
        }
        return protoSize;
    }

}
