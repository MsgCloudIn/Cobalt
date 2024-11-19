package it.auties.whatsapp.model.message.server;

import it.auties.whatsapp.model.message.server.ProtocolMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ProtocolMessageSpec {
    public static byte[] encode(ProtocolMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var key = protoInputObject.key();
        if (key != null) {
            var key0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(key);
            if (key0 != null) {
                outputStream.writeBytes(1, it.auties.whatsapp.model.message.model.ChatMessageKeySpec.encode(key0));
            }
        }
        outputStream.writeInt32(2, it.auties.whatsapp.model.message.server.ProtocolMessageTypeSpec.encode(protoInputObject.protocolType()));
        outputStream.writeUInt64(4, protoInputObject.ephemeralExpiration());
        outputStream.writeUInt64(5, protoInputObject.ephemeralSettingTimestampSeconds());
        var historySyncNotification = protoInputObject.historySyncNotification();
        if (historySyncNotification != null) {
            var historySyncNotification0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(historySyncNotification);
            if (historySyncNotification0 != null) {
                outputStream.writeBytes(6, it.auties.whatsapp.model.sync.HistorySyncNotificationSpec.encode(historySyncNotification0));
            }
        }
        var appStateSyncKeyShare = protoInputObject.appStateSyncKeyShare();
        if (appStateSyncKeyShare != null) {
            var appStateSyncKeyShare0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(appStateSyncKeyShare);
            if (appStateSyncKeyShare0 != null) {
                outputStream.writeBytes(7, it.auties.whatsapp.model.sync.AppStateSyncKeyShareSpec.encode(appStateSyncKeyShare0));
            }
        }
        var appStateSyncKeyRequest = protoInputObject.appStateSyncKeyRequest();
        if (appStateSyncKeyRequest != null) {
            var appStateSyncKeyRequest0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(appStateSyncKeyRequest);
            if (appStateSyncKeyRequest0 != null) {
                outputStream.writeBytes(8, it.auties.whatsapp.model.sync.AppStateSyncKeyRequestSpec.encode(appStateSyncKeyRequest0));
            }
        }
        var initialSecurityNotificationSettingSync = protoInputObject.initialSecurityNotificationSettingSync();
        if (initialSecurityNotificationSettingSync != null) {
            var initialSecurityNotificationSettingSync0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(initialSecurityNotificationSettingSync);
            if (initialSecurityNotificationSettingSync0 != null) {
                outputStream.writeBytes(9, it.auties.whatsapp.model.sync.InitialSecurityNotificationSettingSyncSpec.encode(initialSecurityNotificationSettingSync0));
            }
        }
        var appStateFatalExceptionNotification = protoInputObject.appStateFatalExceptionNotification();
        if (appStateFatalExceptionNotification != null) {
            var appStateFatalExceptionNotification0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(appStateFatalExceptionNotification);
            if (appStateFatalExceptionNotification0 != null) {
                outputStream.writeBytes(10, it.auties.whatsapp.model.sync.AppStateFatalExceptionNotificationSpec.encode(appStateFatalExceptionNotification0));
            }
        }
        var disappearingMode = protoInputObject.disappearingMode();
        if (disappearingMode != null) {
            var disappearingMode0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(disappearingMode);
            if (disappearingMode0 != null) {
                outputStream.writeBytes(11, it.auties.whatsapp.model.chat.ChatDisappearSpec.encode(disappearingMode0));
            }
        }
        var editedMessage = protoInputObject.editedMessage();
        if (editedMessage != null) {
            var editedMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(editedMessage);
            if (editedMessage0 != null) {
                outputStream.writeBytes(14, it.auties.whatsapp.model.message.model.MessageContainerSpec.encode(editedMessage0));
            }
        }
        outputStream.writeInt64(15, protoInputObject.timestampMilliseconds());
        return outputStream.toByteArray();
    }

    public static ProtocolMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ProtocolMessage decode(ProtobufInputStream protoInputStream) {
        java.util.Optional<it.auties.whatsapp.model.message.model.ChatMessageKey> key = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        it.auties.whatsapp.model.message.server.ProtocolMessage.Type protocolType = null;
        long ephemeralExpiration = 0l;
        long ephemeralSettingTimestampSeconds = 0l;
        java.util.Optional<it.auties.whatsapp.model.sync.HistorySyncNotification> historySyncNotification = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.sync.AppStateSyncKeyShare> appStateSyncKeyShare = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.sync.AppStateSyncKeyRequest> appStateSyncKeyRequest = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.sync.InitialSecurityNotificationSettingSync> initialSecurityNotificationSettingSync = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.sync.AppStateFatalExceptionNotification> appStateFatalExceptionNotification = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.chat.ChatDisappear> disappearingMode = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.model.MessageContainer> editedMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        long timestampMilliseconds = 0l;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> key = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.model.ChatMessageKeySpec.decode(protoInputStream.lengthDelimitedStream()));
                case 2 -> protocolType = it.auties.whatsapp.model.message.server.ProtocolMessageTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 4 -> ephemeralExpiration = protoInputStream.readInt64();
                case 5 -> ephemeralSettingTimestampSeconds = protoInputStream.readInt64();
                case 6 -> historySyncNotification = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.sync.HistorySyncNotificationSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 7 -> appStateSyncKeyShare = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.sync.AppStateSyncKeyShareSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 8 -> appStateSyncKeyRequest = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.sync.AppStateSyncKeyRequestSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 9 -> initialSecurityNotificationSettingSync = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.sync.InitialSecurityNotificationSettingSyncSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 10 -> appStateFatalExceptionNotification = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.sync.AppStateFatalExceptionNotificationSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 11 -> disappearingMode = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.chat.ChatDisappearSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 14 -> editedMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.model.MessageContainerSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 15 -> timestampMilliseconds = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.server.ProtocolMessage(key, protocolType, ephemeralExpiration, ephemeralSettingTimestampSeconds, historySyncNotification, appStateSyncKeyShare, appStateSyncKeyRequest, initialSecurityNotificationSettingSync, appStateFatalExceptionNotification, disappearingMode, editedMessage, timestampMilliseconds);
    }

    public static int sizeOf(ProtocolMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var key = object.key();
        if (key != null) {
            var key0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(key);
            if (key0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                var key0SerializedSize = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.sizeOf(key0);
                protoSize += ProtobufOutputStream.getVarIntSize(key0SerializedSize);
                protoSize += key0SerializedSize;
            }
        }
        var protocolType = object.protocolType();
        if (protocolType != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var protocolTypeSerializedSize = it.auties.whatsapp.model.message.server.ProtocolMessageTypeSpec.sizeOf(protocolType);
            protoSize += protocolTypeSerializedSize;
        }
        var ephemeralExpiration = object.ephemeralExpiration();
        protoSize += ProtobufOutputStream.getFieldSize(4, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(ephemeralExpiration);
        var ephemeralSettingTimestampSeconds = object.ephemeralSettingTimestampSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(5, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(ephemeralSettingTimestampSeconds);
        var historySyncNotification = object.historySyncNotification();
        if (historySyncNotification != null) {
            var historySyncNotification0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(historySyncNotification);
            if (historySyncNotification0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(6, 2);
                var historySyncNotification0SerializedSize = it.auties.whatsapp.model.sync.HistorySyncNotificationSpec.sizeOf(historySyncNotification0);
                protoSize += ProtobufOutputStream.getVarIntSize(historySyncNotification0SerializedSize);
                protoSize += historySyncNotification0SerializedSize;
            }
        }
        var appStateSyncKeyShare = object.appStateSyncKeyShare();
        if (appStateSyncKeyShare != null) {
            var appStateSyncKeyShare0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(appStateSyncKeyShare);
            if (appStateSyncKeyShare0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(7, 2);
                var appStateSyncKeyShare0SerializedSize = it.auties.whatsapp.model.sync.AppStateSyncKeyShareSpec.sizeOf(appStateSyncKeyShare0);
                protoSize += ProtobufOutputStream.getVarIntSize(appStateSyncKeyShare0SerializedSize);
                protoSize += appStateSyncKeyShare0SerializedSize;
            }
        }
        var appStateSyncKeyRequest = object.appStateSyncKeyRequest();
        if (appStateSyncKeyRequest != null) {
            var appStateSyncKeyRequest0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(appStateSyncKeyRequest);
            if (appStateSyncKeyRequest0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(8, 2);
                var appStateSyncKeyRequest0SerializedSize = it.auties.whatsapp.model.sync.AppStateSyncKeyRequestSpec.sizeOf(appStateSyncKeyRequest0);
                protoSize += ProtobufOutputStream.getVarIntSize(appStateSyncKeyRequest0SerializedSize);
                protoSize += appStateSyncKeyRequest0SerializedSize;
            }
        }
        var initialSecurityNotificationSettingSync = object.initialSecurityNotificationSettingSync();
        if (initialSecurityNotificationSettingSync != null) {
            var initialSecurityNotificationSettingSync0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(initialSecurityNotificationSettingSync);
            if (initialSecurityNotificationSettingSync0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(9, 2);
                var initialSecurityNotificationSettingSync0SerializedSize = it.auties.whatsapp.model.sync.InitialSecurityNotificationSettingSyncSpec.sizeOf(initialSecurityNotificationSettingSync0);
                protoSize += ProtobufOutputStream.getVarIntSize(initialSecurityNotificationSettingSync0SerializedSize);
                protoSize += initialSecurityNotificationSettingSync0SerializedSize;
            }
        }
        var appStateFatalExceptionNotification = object.appStateFatalExceptionNotification();
        if (appStateFatalExceptionNotification != null) {
            var appStateFatalExceptionNotification0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(appStateFatalExceptionNotification);
            if (appStateFatalExceptionNotification0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(10, 2);
                var appStateFatalExceptionNotification0SerializedSize = it.auties.whatsapp.model.sync.AppStateFatalExceptionNotificationSpec.sizeOf(appStateFatalExceptionNotification0);
                protoSize += ProtobufOutputStream.getVarIntSize(appStateFatalExceptionNotification0SerializedSize);
                protoSize += appStateFatalExceptionNotification0SerializedSize;
            }
        }
        var disappearingMode = object.disappearingMode();
        if (disappearingMode != null) {
            var disappearingMode0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(disappearingMode);
            if (disappearingMode0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(11, 2);
                var disappearingMode0SerializedSize = it.auties.whatsapp.model.chat.ChatDisappearSpec.sizeOf(disappearingMode0);
                protoSize += ProtobufOutputStream.getVarIntSize(disappearingMode0SerializedSize);
                protoSize += disappearingMode0SerializedSize;
            }
        }
        var editedMessage = object.editedMessage();
        if (editedMessage != null) {
            var editedMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(editedMessage);
            if (editedMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(14, 2);
                var editedMessage0SerializedSize = it.auties.whatsapp.model.message.model.MessageContainerSpec.sizeOf(editedMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(editedMessage0SerializedSize);
                protoSize += editedMessage0SerializedSize;
            }
        }
        var timestampMilliseconds = object.timestampMilliseconds();
        protoSize += ProtobufOutputStream.getFieldSize(15, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(timestampMilliseconds);
        return protoSize;
    }

}
