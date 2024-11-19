package it.auties.whatsapp.model.info;

import it.auties.whatsapp.model.info.ExternalAdReplyInfo;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ExternalAdReplyInfoSpec {
    public static byte[] encode(ExternalAdReplyInfo protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var title = protoInputObject.title();
        if (title != null) {
            var title0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(title);
            if (title0 != null) {
                outputStream.writeString(1, title0);
            }
        }
        var body = protoInputObject.body();
        if (body != null) {
            var body0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(body);
            if (body0 != null) {
                outputStream.writeString(2, body0);
            }
        }
        var mediaType = protoInputObject.mediaType();
        if (mediaType != null) {
            var mediaType0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaType);
            if (mediaType0 != null) {
                outputStream.writeInt32(3, it.auties.whatsapp.model.info.ExternalAdReplyInfoMediaTypeSpec.encode(mediaType0));
            }
        }
        var thumbnailUrl = protoInputObject.thumbnailUrl();
        if (thumbnailUrl != null) {
            var thumbnailUrl0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnailUrl);
            if (thumbnailUrl0 != null) {
                outputStream.writeString(4, thumbnailUrl0);
            }
        }
        var mediaUrl = protoInputObject.mediaUrl();
        if (mediaUrl != null) {
            var mediaUrl0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaUrl);
            if (mediaUrl0 != null) {
                outputStream.writeString(5, mediaUrl0);
            }
        }
        var thumbnail = protoInputObject.thumbnail();
        if (thumbnail != null) {
            var thumbnail0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnail);
            if (thumbnail0 != null) {
                outputStream.writeBytes(6, thumbnail0);
            }
        }
        var sourceType = protoInputObject.sourceType();
        if (sourceType != null) {
            var sourceType0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(sourceType);
            if (sourceType0 != null) {
                outputStream.writeString(7, sourceType0);
            }
        }
        var sourceId = protoInputObject.sourceId();
        if (sourceId != null) {
            var sourceId0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(sourceId);
            if (sourceId0 != null) {
                outputStream.writeString(8, sourceId0);
            }
        }
        var sourceUrl = protoInputObject.sourceUrl();
        if (sourceUrl != null) {
            var sourceUrl0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(sourceUrl);
            if (sourceUrl0 != null) {
                outputStream.writeString(9, sourceUrl0);
            }
        }
        outputStream.writeBool(10, protoInputObject.containsAutoReply());
        outputStream.writeBool(11, protoInputObject.renderLargerThumbnail());
        outputStream.writeBool(12, protoInputObject.showAdAttribution());
        var ctwaClid = protoInputObject.ctwaClid();
        if (ctwaClid != null) {
            var ctwaClid0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(ctwaClid);
            if (ctwaClid0 != null) {
                outputStream.writeString(13, ctwaClid0);
            }
        }
        return outputStream.toByteArray();
    }

    public static ExternalAdReplyInfo decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ExternalAdReplyInfo decode(ProtobufInputStream protoInputStream) {
        java.util.Optional<java.lang.String> title = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> body = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.info.ExternalAdReplyInfo.MediaType> mediaType = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> thumbnailUrl = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> mediaUrl = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<byte[]> thumbnail = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> sourceType = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> sourceId = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> sourceUrl = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        boolean containsAutoReply = false;
        boolean renderLargerThumbnail = false;
        boolean showAdAttribution = false;
        java.util.Optional<java.lang.String> ctwaClid = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> title = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 2 -> body = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 3 -> mediaType = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.info.ExternalAdReplyInfoMediaTypeSpec.decode(protoInputStream.readInt32()).orElse(null));
                case 4 -> thumbnailUrl = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 5 -> mediaUrl = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 6 -> thumbnail = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readBytes());
                case 7 -> sourceType = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 8 -> sourceId = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 9 -> sourceUrl = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 10 -> containsAutoReply = protoInputStream.readBool();
                case 11 -> renderLargerThumbnail = protoInputStream.readBool();
                case 12 -> showAdAttribution = protoInputStream.readBool();
                case 13 -> ctwaClid = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.info.ExternalAdReplyInfo(title, body, mediaType, thumbnailUrl, mediaUrl, thumbnail, sourceType, sourceId, sourceUrl, containsAutoReply, renderLargerThumbnail, showAdAttribution, ctwaClid);
    }

    public static int sizeOf(ExternalAdReplyInfo object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var title = object.title();
        if (title != null) {
            var title0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(title);
            if (title0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(title0);
            }
        }
        var body = object.body();
        if (body != null) {
            var body0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(body);
            if (body0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                protoSize += ProtobufOutputStream.getStringSize(body0);
            }
        }
        var mediaType = object.mediaType();
        if (mediaType != null) {
            var mediaType0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaType);
            if (mediaType0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                var mediaType0SerializedSize = it.auties.whatsapp.model.info.ExternalAdReplyInfoMediaTypeSpec.sizeOf(mediaType0);
                protoSize += mediaType0SerializedSize;
            }
        }
        var thumbnailUrl = object.thumbnailUrl();
        if (thumbnailUrl != null) {
            var thumbnailUrl0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnailUrl);
            if (thumbnailUrl0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                protoSize += ProtobufOutputStream.getStringSize(thumbnailUrl0);
            }
        }
        var mediaUrl = object.mediaUrl();
        if (mediaUrl != null) {
            var mediaUrl0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaUrl);
            if (mediaUrl0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                protoSize += ProtobufOutputStream.getStringSize(mediaUrl0);
            }
        }
        var thumbnail = object.thumbnail();
        if (thumbnail != null) {
            var thumbnail0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnail);
            if (thumbnail0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(6, 2);
                protoSize += ProtobufOutputStream.getBytesSize(thumbnail0);
            }
        }
        var sourceType = object.sourceType();
        if (sourceType != null) {
            var sourceType0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(sourceType);
            if (sourceType0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(7, 2);
                protoSize += ProtobufOutputStream.getStringSize(sourceType0);
            }
        }
        var sourceId = object.sourceId();
        if (sourceId != null) {
            var sourceId0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(sourceId);
            if (sourceId0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(8, 2);
                protoSize += ProtobufOutputStream.getStringSize(sourceId0);
            }
        }
        var sourceUrl = object.sourceUrl();
        if (sourceUrl != null) {
            var sourceUrl0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(sourceUrl);
            if (sourceUrl0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(9, 2);
                protoSize += ProtobufOutputStream.getStringSize(sourceUrl0);
            }
        }
        var containsAutoReply = object.containsAutoReply();
        protoSize += ProtobufOutputStream.getFieldSize(10, 0);
        protoSize += 1;
        var renderLargerThumbnail = object.renderLargerThumbnail();
        protoSize += ProtobufOutputStream.getFieldSize(11, 0);
        protoSize += 1;
        var showAdAttribution = object.showAdAttribution();
        protoSize += ProtobufOutputStream.getFieldSize(12, 0);
        protoSize += 1;
        var ctwaClid = object.ctwaClid();
        if (ctwaClid != null) {
            var ctwaClid0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(ctwaClid);
            if (ctwaClid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(13, 2);
                protoSize += ProtobufOutputStream.getStringSize(ctwaClid0);
            }
        }
        return protoSize;
    }

}
