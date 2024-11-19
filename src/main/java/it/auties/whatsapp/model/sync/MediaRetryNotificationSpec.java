package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.MediaRetryNotification;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class MediaRetryNotificationSpec {
    public static byte[] encode(MediaRetryNotification protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.stanzaId());
        var directPath = protoInputObject.directPath();
        if (directPath != null) {
            var directPath0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(directPath);
            if (directPath0 != null) {
                outputStream.writeString(2, directPath0);
            }
        }
        outputStream.writeInt32(3, it.auties.whatsapp.model.sync.MediaRetryNotificationMediaRetryNotificationResultTypeSpec.encode(protoInputObject.result()));
        return outputStream.toByteArray();
    }

    public static MediaRetryNotification decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static MediaRetryNotification decode(ProtobufInputStream protoInputStream) {
        java.lang.String stanzaId = null;
        java.util.Optional<java.lang.String> directPath = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        it.auties.whatsapp.model.sync.MediaRetryNotification.MediaRetryNotificationResultType result = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> stanzaId = protoInputStream.readString();
                case 2 -> directPath = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 3 -> result = it.auties.whatsapp.model.sync.MediaRetryNotificationMediaRetryNotificationResultTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.MediaRetryNotification(stanzaId, directPath, result);
    }

    public static int sizeOf(MediaRetryNotification object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var stanzaId = object.stanzaId();
        if (stanzaId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(stanzaId);
        }
        var directPath = object.directPath();
        if (directPath != null) {
            var directPath0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(directPath);
            if (directPath0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                protoSize += ProtobufOutputStream.getStringSize(directPath0);
            }
        }
        var result = object.result();
        if (result != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            var resultSerializedSize = it.auties.whatsapp.model.sync.MediaRetryNotificationMediaRetryNotificationResultTypeSpec.sizeOf(result);
            protoSize += resultSerializedSize;
        }
        return protoSize;
    }

}
