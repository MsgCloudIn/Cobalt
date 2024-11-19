package it.auties.whatsapp.model.message.standard;

import it.auties.whatsapp.model.message.standard.StickerMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class StickerMessageSpec {
    public static byte[] encode(StickerMessage protoInputObject) {
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
        var mediaSha256 = protoInputObject.mediaSha256();
        if (mediaSha256 != null) {
            var mediaSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaSha256);
            if (mediaSha2560 != null) {
                outputStream.writeBytes(2, mediaSha2560);
            }
        }
        var mediaEncryptedSha256 = protoInputObject.mediaEncryptedSha256();
        if (mediaEncryptedSha256 != null) {
            var mediaEncryptedSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaEncryptedSha256);
            if (mediaEncryptedSha2560 != null) {
                outputStream.writeBytes(3, mediaEncryptedSha2560);
            }
        }
        var mediaKey = protoInputObject.mediaKey();
        if (mediaKey != null) {
            var mediaKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaKey);
            if (mediaKey0 != null) {
                outputStream.writeBytes(4, mediaKey0);
            }
        }
        var mimetype = protoInputObject.mimetype();
        if (mimetype != null) {
            var mimetype0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mimetype);
            if (mimetype0 != null) {
                outputStream.writeString(5, mimetype0);
            }
        }
        var height = protoInputObject.height();
        if (height != null) {
            var height0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableInt(height);
            if (height0 != null) {
                outputStream.writeUInt32(6, height0);
            }
        }
        var width = protoInputObject.width();
        if (width != null) {
            var width0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableInt(width);
            if (width0 != null) {
                outputStream.writeUInt32(7, width0);
            }
        }
        var mediaDirectPath = protoInputObject.mediaDirectPath();
        if (mediaDirectPath != null) {
            var mediaDirectPath0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaDirectPath);
            if (mediaDirectPath0 != null) {
                outputStream.writeString(8, mediaDirectPath0);
            }
        }
        var mediaSize = protoInputObject.mediaSize();
        if (mediaSize != null) {
            var mediaSize0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(mediaSize);
            if (mediaSize0 != null) {
                outputStream.writeUInt64(9, mediaSize0);
            }
        }
        var mediaKeyTimestampSeconds = protoInputObject.mediaKeyTimestampSeconds();
        if (mediaKeyTimestampSeconds != null) {
            var mediaKeyTimestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(mediaKeyTimestampSeconds);
            if (mediaKeyTimestampSeconds0 != null) {
                outputStream.writeUInt64(10, mediaKeyTimestampSeconds0);
            }
        }
        var firstFrameLength = protoInputObject.firstFrameLength();
        if (firstFrameLength != null) {
            var firstFrameLength0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableInt(firstFrameLength);
            if (firstFrameLength0 != null) {
                outputStream.writeUInt32(11, firstFrameLength0);
            }
        }
        var firstFrameSidecar = protoInputObject.firstFrameSidecar();
        if (firstFrameSidecar != null) {
            var firstFrameSidecar0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(firstFrameSidecar);
            if (firstFrameSidecar0 != null) {
                outputStream.writeBytes(12, firstFrameSidecar0);
            }
        }
        outputStream.writeBool(13, protoInputObject.animated());
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
        var stickerSentTimestamp = protoInputObject.stickerSentTimestamp();
        if (stickerSentTimestamp != null) {
            var stickerSentTimestamp0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(stickerSentTimestamp);
            if (stickerSentTimestamp0 != null) {
                outputStream.writeInt64(18, stickerSentTimestamp0);
            }
        }
        outputStream.writeBool(19, protoInputObject.avatar());
        return outputStream.toByteArray();
    }

    public static StickerMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static StickerMessage decode(ProtobufInputStream protoInputStream) {
        java.lang.String mediaUrl = null;
        byte[] mediaSha256 = null;
        byte[] mediaEncryptedSha256 = null;
        byte[] mediaKey = null;
        java.lang.String mimetype = null;
        java.lang.Integer height = null;
        java.lang.Integer width = null;
        java.lang.String mediaDirectPath = null;
        java.lang.Long mediaSize = null;
        java.lang.Long mediaKeyTimestampSeconds = null;
        java.lang.Integer firstFrameLength = null;
        byte[] firstFrameSidecar = null;
        boolean animated = false;
        byte[] thumbnail = null;
        it.auties.whatsapp.model.info.ContextInfo contextInfo = null;
        java.lang.Long stickerSentTimestamp = null;
        boolean avatar = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> mediaUrl = protoInputStream.readString();
                case 2 -> mediaSha256 = protoInputStream.readBytes();
                case 3 -> mediaEncryptedSha256 = protoInputStream.readBytes();
                case 4 -> mediaKey = protoInputStream.readBytes();
                case 5 -> mimetype = protoInputStream.readString();
                case 6 -> height = protoInputStream.readInt32();
                case 7 -> width = protoInputStream.readInt32();
                case 8 -> mediaDirectPath = protoInputStream.readString();
                case 9 -> mediaSize = protoInputStream.readInt64();
                case 10 -> mediaKeyTimestampSeconds = protoInputStream.readInt64();
                case 11 -> firstFrameLength = protoInputStream.readInt32();
                case 12 -> firstFrameSidecar = protoInputStream.readBytes();
                case 13 -> animated = protoInputStream.readBool();
                case 16 -> thumbnail = protoInputStream.readBytes();
                case 17 -> contextInfo = it.auties.whatsapp.model.info.ContextInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                case 18 -> stickerSentTimestamp = protoInputStream.readInt64();
                case 19 -> avatar = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.standard.StickerMessage(mediaUrl, mediaSha256, mediaEncryptedSha256, mediaKey, mimetype, height, width, mediaDirectPath, mediaSize, mediaKeyTimestampSeconds, firstFrameLength, firstFrameSidecar, animated, thumbnail, contextInfo, stickerSentTimestamp, avatar);
    }

    public static int sizeOf(StickerMessage object) {
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
        var mediaSha256 = object.mediaSha256();
        if (mediaSha256 != null) {
            var mediaSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaSha256);
            if (mediaSha2560 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                protoSize += ProtobufOutputStream.getBytesSize(mediaSha2560);
            }
        }
        var mediaEncryptedSha256 = object.mediaEncryptedSha256();
        if (mediaEncryptedSha256 != null) {
            var mediaEncryptedSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaEncryptedSha256);
            if (mediaEncryptedSha2560 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                protoSize += ProtobufOutputStream.getBytesSize(mediaEncryptedSha2560);
            }
        }
        var mediaKey = object.mediaKey();
        if (mediaKey != null) {
            var mediaKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaKey);
            if (mediaKey0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                protoSize += ProtobufOutputStream.getBytesSize(mediaKey0);
            }
        }
        var mimetype = object.mimetype();
        if (mimetype != null) {
            var mimetype0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mimetype);
            if (mimetype0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                protoSize += ProtobufOutputStream.getStringSize(mimetype0);
            }
        }
        var height = object.height();
        if (height != null) {
            var height0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableInt(height);
            if (height0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(6, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(height0);
            }
        }
        var width = object.width();
        if (width != null) {
            var width0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableInt(width);
            if (width0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(7, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(width0);
            }
        }
        var mediaDirectPath = object.mediaDirectPath();
        if (mediaDirectPath != null) {
            var mediaDirectPath0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaDirectPath);
            if (mediaDirectPath0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(8, 2);
                protoSize += ProtobufOutputStream.getStringSize(mediaDirectPath0);
            }
        }
        var mediaSize = object.mediaSize();
        if (mediaSize != null) {
            var mediaSize0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(mediaSize);
            if (mediaSize0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(9, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(mediaSize0);
            }
        }
        var mediaKeyTimestampSeconds = object.mediaKeyTimestampSeconds();
        if (mediaKeyTimestampSeconds != null) {
            var mediaKeyTimestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(mediaKeyTimestampSeconds);
            if (mediaKeyTimestampSeconds0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(10, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(mediaKeyTimestampSeconds0);
            }
        }
        var firstFrameLength = object.firstFrameLength();
        if (firstFrameLength != null) {
            var firstFrameLength0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableInt(firstFrameLength);
            if (firstFrameLength0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(11, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(firstFrameLength0);
            }
        }
        var firstFrameSidecar = object.firstFrameSidecar();
        if (firstFrameSidecar != null) {
            var firstFrameSidecar0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(firstFrameSidecar);
            if (firstFrameSidecar0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(12, 2);
                protoSize += ProtobufOutputStream.getBytesSize(firstFrameSidecar0);
            }
        }
        var animated = object.animated();
        protoSize += ProtobufOutputStream.getFieldSize(13, 0);
        protoSize += 1;
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
        var stickerSentTimestamp = object.stickerSentTimestamp();
        if (stickerSentTimestamp != null) {
            var stickerSentTimestamp0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(stickerSentTimestamp);
            if (stickerSentTimestamp0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(18, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(stickerSentTimestamp0);
            }
        }
        var avatar = object.avatar();
        protoSize += ProtobufOutputStream.getFieldSize(19, 0);
        protoSize += 1;
        return protoSize;
    }

}
