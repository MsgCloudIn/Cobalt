package it.auties.whatsapp.model.message.standard;

import it.auties.whatsapp.model.message.standard.AudioMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class AudioMessageSpec {
    public static byte[] encode(AudioMessage protoInputObject) {
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
        outputStream.writeBool(6, protoInputObject.voiceMessage());
        var mediaKey = protoInputObject.mediaKey();
        if (mediaKey != null) {
            var mediaKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaKey);
            if (mediaKey0 != null) {
                outputStream.writeBytes(7, mediaKey0);
            }
        }
        var mediaEncryptedSha256 = protoInputObject.mediaEncryptedSha256();
        if (mediaEncryptedSha256 != null) {
            var mediaEncryptedSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaEncryptedSha256);
            if (mediaEncryptedSha2560 != null) {
                outputStream.writeBytes(8, mediaEncryptedSha2560);
            }
        }
        var mediaDirectPath = protoInputObject.mediaDirectPath();
        if (mediaDirectPath != null) {
            var mediaDirectPath0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaDirectPath);
            if (mediaDirectPath0 != null) {
                outputStream.writeString(9, mediaDirectPath0);
            }
        }
        var mediaKeyTimestampSeconds = protoInputObject.mediaKeyTimestampSeconds();
        if (mediaKeyTimestampSeconds != null) {
            var mediaKeyTimestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(mediaKeyTimestampSeconds);
            if (mediaKeyTimestampSeconds0 != null) {
                outputStream.writeInt64(10, mediaKeyTimestampSeconds0);
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
        var waveform = protoInputObject.waveform();
        if (waveform != null) {
            var waveform0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(waveform);
            if (waveform0 != null) {
                outputStream.writeBytes(19, waveform0);
            }
        }
        outputStream.writeFixed32(20, protoInputObject.backgroundArgb());
        return outputStream.toByteArray();
    }

    public static AudioMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static AudioMessage decode(ProtobufInputStream protoInputStream) {
        java.lang.String mediaUrl = null;
        java.lang.String mimetype = null;
        byte[] mediaSha256 = null;
        java.lang.Long mediaSize = null;
        java.lang.Integer duration = null;
        boolean voiceMessage = false;
        byte[] mediaKey = null;
        byte[] mediaEncryptedSha256 = null;
        java.lang.String mediaDirectPath = null;
        java.lang.Long mediaKeyTimestampSeconds = null;
        it.auties.whatsapp.model.info.ContextInfo contextInfo = null;
        byte[] streamingSidecar = null;
        byte[] waveform = null;
        java.lang.Integer backgroundArgb = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> mediaUrl = protoInputStream.readString();
                case 2 -> mimetype = protoInputStream.readString();
                case 3 -> mediaSha256 = protoInputStream.readBytes();
                case 4 -> mediaSize = protoInputStream.readInt64();
                case 5 -> duration = protoInputStream.readInt32();
                case 6 -> voiceMessage = protoInputStream.readBool();
                case 7 -> mediaKey = protoInputStream.readBytes();
                case 8 -> mediaEncryptedSha256 = protoInputStream.readBytes();
                case 9 -> mediaDirectPath = protoInputStream.readString();
                case 10 -> mediaKeyTimestampSeconds = protoInputStream.readInt64();
                case 17 -> contextInfo = it.auties.whatsapp.model.info.ContextInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                case 18 -> streamingSidecar = protoInputStream.readBytes();
                case 19 -> waveform = protoInputStream.readBytes();
                case 20 -> backgroundArgb = protoInputStream.readFixed32();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.standard.AudioMessage(mediaUrl, mimetype, mediaSha256, mediaSize, duration, voiceMessage, mediaKey, mediaEncryptedSha256, mediaDirectPath, mediaKeyTimestampSeconds, contextInfo, streamingSidecar, waveform, backgroundArgb);
    }

    public static int sizeOf(AudioMessage object) {
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
        var voiceMessage = object.voiceMessage();
        protoSize += ProtobufOutputStream.getFieldSize(6, 0);
        protoSize += 1;
        var mediaKey = object.mediaKey();
        if (mediaKey != null) {
            var mediaKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaKey);
            if (mediaKey0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(7, 2);
                protoSize += ProtobufOutputStream.getBytesSize(mediaKey0);
            }
        }
        var mediaEncryptedSha256 = object.mediaEncryptedSha256();
        if (mediaEncryptedSha256 != null) {
            var mediaEncryptedSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaEncryptedSha256);
            if (mediaEncryptedSha2560 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(8, 2);
                protoSize += ProtobufOutputStream.getBytesSize(mediaEncryptedSha2560);
            }
        }
        var mediaDirectPath = object.mediaDirectPath();
        if (mediaDirectPath != null) {
            var mediaDirectPath0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaDirectPath);
            if (mediaDirectPath0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(9, 2);
                protoSize += ProtobufOutputStream.getStringSize(mediaDirectPath0);
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
        var waveform = object.waveform();
        if (waveform != null) {
            var waveform0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(waveform);
            if (waveform0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(19, 2);
                protoSize += ProtobufOutputStream.getBytesSize(waveform0);
            }
        }
        var backgroundArgb = object.backgroundArgb();
        if (backgroundArgb != null) {
            protoSize += ProtobufOutputStream.getFieldSize(20, 5);
            protoSize += 4;
        }
        return protoSize;
    }

}
