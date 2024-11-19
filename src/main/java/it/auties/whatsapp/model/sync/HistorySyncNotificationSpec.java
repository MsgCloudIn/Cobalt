package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.HistorySyncNotification;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class HistorySyncNotificationSpec {
    public static byte[] encode(HistorySyncNotification protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var mediaSha256 = protoInputObject.mediaSha256();
        if (mediaSha256 != null) {
            var mediaSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaSha256);
            if (mediaSha2560 != null) {
                outputStream.writeBytes(1, mediaSha2560);
            }
        }
        var mediaSize = protoInputObject.mediaSize();
        if (mediaSize != null) {
            var mediaSize0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(mediaSize);
            if (mediaSize0 != null) {
                outputStream.writeUInt64(2, mediaSize0);
            }
        }
        var mediaKey = protoInputObject.mediaKey();
        if (mediaKey != null) {
            var mediaKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaKey);
            if (mediaKey0 != null) {
                outputStream.writeBytes(3, mediaKey0);
            }
        }
        var mediaEncryptedSha256 = protoInputObject.mediaEncryptedSha256();
        if (mediaEncryptedSha256 != null) {
            var mediaEncryptedSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaEncryptedSha256);
            if (mediaEncryptedSha2560 != null) {
                outputStream.writeBytes(4, mediaEncryptedSha2560);
            }
        }
        var mediaDirectPath = protoInputObject.mediaDirectPath();
        if (mediaDirectPath != null) {
            var mediaDirectPath0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaDirectPath);
            if (mediaDirectPath0 != null) {
                outputStream.writeString(5, mediaDirectPath0);
            }
        }
        outputStream.writeInt32(6, it.auties.whatsapp.model.sync.HistorySyncTypeSpec.encode(protoInputObject.syncType()));
        outputStream.writeUInt32(7, protoInputObject.chunkOrder());
        var originalMessageId = protoInputObject.originalMessageId();
        if (originalMessageId != null) {
            var originalMessageId0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(originalMessageId);
            if (originalMessageId0 != null) {
                outputStream.writeString(8, originalMessageId0);
            }
        }
        outputStream.writeUInt32(9, protoInputObject.progress());
        outputStream.writeInt64(10, protoInputObject.oldestMsgInChunkTimestampSec());
        var initialHistBootstrapInlinePayload = protoInputObject.initialHistBootstrapInlinePayload();
        if (initialHistBootstrapInlinePayload != null) {
            var initialHistBootstrapInlinePayload0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(initialHistBootstrapInlinePayload);
            if (initialHistBootstrapInlinePayload0 != null) {
                outputStream.writeBytes(11, initialHistBootstrapInlinePayload0);
            }
        }
        var peerDataRequestSessionId = protoInputObject.peerDataRequestSessionId();
        if (peerDataRequestSessionId != null) {
            var peerDataRequestSessionId0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(peerDataRequestSessionId);
            if (peerDataRequestSessionId0 != null) {
                outputStream.writeString(12, peerDataRequestSessionId0);
            }
        }
        return outputStream.toByteArray();
    }

    public static HistorySyncNotification decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static HistorySyncNotification decode(ProtobufInputStream protoInputStream) {
        byte[] mediaSha256 = null;
        java.lang.Long mediaSize = null;
        byte[] mediaKey = null;
        byte[] mediaEncryptedSha256 = null;
        java.lang.String mediaDirectPath = null;
        it.auties.whatsapp.model.sync.HistorySync.Type syncType = null;
        java.lang.Integer chunkOrder = null;
        java.lang.String originalMessageId = null;
        java.lang.Integer progress = null;
        long oldestMsgInChunkTimestampSec = 0l;
        byte[] initialHistBootstrapInlinePayload = null;
        java.lang.String peerDataRequestSessionId = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> mediaSha256 = protoInputStream.readBytes();
                case 2 -> mediaSize = protoInputStream.readInt64();
                case 3 -> mediaKey = protoInputStream.readBytes();
                case 4 -> mediaEncryptedSha256 = protoInputStream.readBytes();
                case 5 -> mediaDirectPath = protoInputStream.readString();
                case 6 -> syncType = it.auties.whatsapp.model.sync.HistorySyncTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 7 -> chunkOrder = protoInputStream.readInt32();
                case 8 -> originalMessageId = protoInputStream.readString();
                case 9 -> progress = protoInputStream.readInt32();
                case 10 -> oldestMsgInChunkTimestampSec = protoInputStream.readInt64();
                case 11 -> initialHistBootstrapInlinePayload = protoInputStream.readBytes();
                case 12 -> peerDataRequestSessionId = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.HistorySyncNotification(mediaSha256, mediaSize, mediaKey, mediaEncryptedSha256, mediaDirectPath, syncType, chunkOrder, originalMessageId, progress, oldestMsgInChunkTimestampSec, initialHistBootstrapInlinePayload, peerDataRequestSessionId);
    }

    public static int sizeOf(HistorySyncNotification object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var mediaSha256 = object.mediaSha256();
        if (mediaSha256 != null) {
            var mediaSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaSha256);
            if (mediaSha2560 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getBytesSize(mediaSha2560);
            }
        }
        var mediaSize = object.mediaSize();
        if (mediaSize != null) {
            var mediaSize0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(mediaSize);
            if (mediaSize0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(mediaSize0);
            }
        }
        var mediaKey = object.mediaKey();
        if (mediaKey != null) {
            var mediaKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaKey);
            if (mediaKey0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                protoSize += ProtobufOutputStream.getBytesSize(mediaKey0);
            }
        }
        var mediaEncryptedSha256 = object.mediaEncryptedSha256();
        if (mediaEncryptedSha256 != null) {
            var mediaEncryptedSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaEncryptedSha256);
            if (mediaEncryptedSha2560 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                protoSize += ProtobufOutputStream.getBytesSize(mediaEncryptedSha2560);
            }
        }
        var mediaDirectPath = object.mediaDirectPath();
        if (mediaDirectPath != null) {
            var mediaDirectPath0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaDirectPath);
            if (mediaDirectPath0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                protoSize += ProtobufOutputStream.getStringSize(mediaDirectPath0);
            }
        }
        var syncType = object.syncType();
        if (syncType != null) {
            protoSize += ProtobufOutputStream.getFieldSize(6, 2);
            var syncTypeSerializedSize = it.auties.whatsapp.model.sync.HistorySyncTypeSpec.sizeOf(syncType);
            protoSize += syncTypeSerializedSize;
        }
        var chunkOrder = object.chunkOrder();
        if (chunkOrder != null) {
            protoSize += ProtobufOutputStream.getFieldSize(7, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(chunkOrder);
        }
        var originalMessageId = object.originalMessageId();
        if (originalMessageId != null) {
            var originalMessageId0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(originalMessageId);
            if (originalMessageId0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(8, 2);
                protoSize += ProtobufOutputStream.getStringSize(originalMessageId0);
            }
        }
        var progress = object.progress();
        if (progress != null) {
            protoSize += ProtobufOutputStream.getFieldSize(9, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(progress);
        }
        var oldestMsgInChunkTimestampSec = object.oldestMsgInChunkTimestampSec();
        protoSize += ProtobufOutputStream.getFieldSize(10, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(oldestMsgInChunkTimestampSec);
        var initialHistBootstrapInlinePayload = object.initialHistBootstrapInlinePayload();
        if (initialHistBootstrapInlinePayload != null) {
            var initialHistBootstrapInlinePayload0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(initialHistBootstrapInlinePayload);
            if (initialHistBootstrapInlinePayload0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(11, 2);
                protoSize += ProtobufOutputStream.getBytesSize(initialHistBootstrapInlinePayload0);
            }
        }
        var peerDataRequestSessionId = object.peerDataRequestSessionId();
        if (peerDataRequestSessionId != null) {
            var peerDataRequestSessionId0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(peerDataRequestSessionId);
            if (peerDataRequestSessionId0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(12, 2);
                protoSize += ProtobufOutputStream.getStringSize(peerDataRequestSessionId0);
            }
        }
        return protoSize;
    }

}
