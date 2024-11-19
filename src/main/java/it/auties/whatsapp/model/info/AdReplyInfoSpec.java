package it.auties.whatsapp.model.info;

import it.auties.whatsapp.model.info.AdReplyInfo;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class AdReplyInfoSpec {
    public static byte[] encode(AdReplyInfo protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.advertiserName());
        outputStream.writeInt32(2, it.auties.whatsapp.model.info.AdReplyInfoMediaTypeSpec.encode(protoInputObject.mediaType()));
        var thumbnail = protoInputObject.thumbnail();
        if (thumbnail != null) {
            var thumbnail0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnail);
            if (thumbnail0 != null) {
                outputStream.writeBytes(16, thumbnail0);
            }
        }
        var caption = protoInputObject.caption();
        if (caption != null) {
            var caption0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(caption);
            if (caption0 != null) {
                outputStream.writeString(17, caption0);
            }
        }
        return outputStream.toByteArray();
    }

    public static AdReplyInfo decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static AdReplyInfo decode(ProtobufInputStream protoInputStream) {
        java.lang.String advertiserName = null;
        it.auties.whatsapp.model.info.AdReplyInfo.MediaType mediaType = null;
        java.util.Optional<byte[]> thumbnail = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> caption = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> advertiserName = protoInputStream.readString();
                case 2 -> mediaType = it.auties.whatsapp.model.info.AdReplyInfoMediaTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 16 -> thumbnail = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readBytes());
                case 17 -> caption = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.info.AdReplyInfo(advertiserName, mediaType, thumbnail, caption);
    }

    public static int sizeOf(AdReplyInfo object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var advertiserName = object.advertiserName();
        if (advertiserName != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(advertiserName);
        }
        var mediaType = object.mediaType();
        if (mediaType != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var mediaTypeSerializedSize = it.auties.whatsapp.model.info.AdReplyInfoMediaTypeSpec.sizeOf(mediaType);
            protoSize += mediaTypeSerializedSize;
        }
        var thumbnail = object.thumbnail();
        if (thumbnail != null) {
            var thumbnail0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnail);
            if (thumbnail0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(16, 2);
                protoSize += ProtobufOutputStream.getBytesSize(thumbnail0);
            }
        }
        var caption = object.caption();
        if (caption != null) {
            var caption0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(caption);
            if (caption0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(17, 2);
                protoSize += ProtobufOutputStream.getStringSize(caption0);
            }
        }
        return protoSize;
    }

}
