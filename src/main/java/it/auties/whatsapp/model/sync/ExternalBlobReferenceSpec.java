package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.ExternalBlobReference;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ExternalBlobReferenceSpec {
    public static byte[] encode(ExternalBlobReference protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var mediaKey = protoInputObject.mediaKey();
        if (mediaKey != null) {
            var mediaKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaKey);
            if (mediaKey0 != null) {
                outputStream.writeBytes(1, mediaKey0);
            }
        }
        var mediaDirectPath = protoInputObject.mediaDirectPath();
        if (mediaDirectPath != null) {
            var mediaDirectPath0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaDirectPath);
            if (mediaDirectPath0 != null) {
                outputStream.writeString(2, mediaDirectPath0);
            }
        }
        var handle = protoInputObject.handle();
        if (handle != null) {
            var handle0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(handle);
            if (handle0 != null) {
                outputStream.writeString(3, handle0);
            }
        }
        var mediaSize = protoInputObject.mediaSize();
        if (mediaSize != null) {
            var mediaSize0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(mediaSize);
            if (mediaSize0 != null) {
                outputStream.writeUInt64(4, mediaSize0);
            }
        }
        var mediaSha256 = protoInputObject.mediaSha256();
        if (mediaSha256 != null) {
            var mediaSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaSha256);
            if (mediaSha2560 != null) {
                outputStream.writeBytes(5, mediaSha2560);
            }
        }
        var mediaEncryptedSha256 = protoInputObject.mediaEncryptedSha256();
        if (mediaEncryptedSha256 != null) {
            var mediaEncryptedSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaEncryptedSha256);
            if (mediaEncryptedSha2560 != null) {
                outputStream.writeBytes(6, mediaEncryptedSha2560);
            }
        }
        return outputStream.toByteArray();
    }

    public static ExternalBlobReference decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ExternalBlobReference decode(ProtobufInputStream protoInputStream) {
        byte[] mediaKey = null;
        java.lang.String mediaDirectPath = null;
        java.lang.String handle = null;
        long mediaSize = 0l;
        byte[] mediaSha256 = null;
        byte[] mediaEncryptedSha256 = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> mediaKey = protoInputStream.readBytes();
                case 2 -> mediaDirectPath = protoInputStream.readString();
                case 3 -> handle = protoInputStream.readString();
                case 4 -> mediaSize = protoInputStream.readInt64();
                case 5 -> mediaSha256 = protoInputStream.readBytes();
                case 6 -> mediaEncryptedSha256 = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.ExternalBlobReference(mediaKey, mediaDirectPath, handle, mediaSize, mediaSha256, mediaEncryptedSha256);
    }

    public static int sizeOf(ExternalBlobReference object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var mediaKey = object.mediaKey();
        if (mediaKey != null) {
            var mediaKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaKey);
            if (mediaKey0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getBytesSize(mediaKey0);
            }
        }
        var mediaDirectPath = object.mediaDirectPath();
        if (mediaDirectPath != null) {
            var mediaDirectPath0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaDirectPath);
            if (mediaDirectPath0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                protoSize += ProtobufOutputStream.getStringSize(mediaDirectPath0);
            }
        }
        var handle = object.handle();
        if (handle != null) {
            var handle0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(handle);
            if (handle0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                protoSize += ProtobufOutputStream.getStringSize(handle0);
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
        var mediaSha256 = object.mediaSha256();
        if (mediaSha256 != null) {
            var mediaSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaSha256);
            if (mediaSha2560 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                protoSize += ProtobufOutputStream.getBytesSize(mediaSha2560);
            }
        }
        var mediaEncryptedSha256 = object.mediaEncryptedSha256();
        if (mediaEncryptedSha256 != null) {
            var mediaEncryptedSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaEncryptedSha256);
            if (mediaEncryptedSha2560 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(6, 2);
                protoSize += ProtobufOutputStream.getBytesSize(mediaEncryptedSha2560);
            }
        }
        return protoSize;
    }

}
