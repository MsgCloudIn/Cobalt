package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.HistorySync;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;
import java.util.Objects;

public class HistorySyncSpec {
    public static byte[] encode(HistorySync protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        Objects.requireNonNull(protoInputObject.syncType(), "Missing required property: syncType");
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, it.auties.whatsapp.model.sync.HistorySyncTypeSpec.encode(protoInputObject.syncType()));
        if (protoInputObject.conversations() != null) {
            for (var conversationsEntry : protoInputObject.conversations()) { 
                outputStream.writeBytes(2, it.auties.whatsapp.model.chat.ChatSpec.encode(conversationsEntry));
            }
        }
        if (protoInputObject.statusV3Messages() != null) {
            for (var statusV3MessagesEntry : protoInputObject.statusV3Messages()) { 
                outputStream.writeBytes(3, it.auties.whatsapp.model.info.ChatMessageInfoSpec.encode(statusV3MessagesEntry));
            }
        }
        outputStream.writeUInt32(5, protoInputObject.chunkOrder());
        outputStream.writeUInt32(6, protoInputObject.progress());
        if (protoInputObject.pushNames() != null) {
            for (var pushNamesEntry : protoInputObject.pushNames()) { 
                outputStream.writeBytes(7, it.auties.whatsapp.model.sync.PushNameSpec.encode(pushNamesEntry));
            }
        }
        outputStream.writeBytes(8, it.auties.whatsapp.model.setting.GlobalSettingsSpec.encode(protoInputObject.globalSettings()));
        outputStream.writeBytes(9, protoInputObject.threadIdUserSecret());
        outputStream.writeUInt32(10, protoInputObject.threadDsTimeframeOffset());
        if (protoInputObject.recentStickers() != null) {
            for (var recentStickersEntry : protoInputObject.recentStickers()) { 
                outputStream.writeBytes(11, it.auties.whatsapp.model.sync.StickerMetadataSpec.encode(recentStickersEntry));
            }
        }
        if (protoInputObject.pastParticipants() != null) {
            for (var pastParticipantsEntry : protoInputObject.pastParticipants()) { 
                outputStream.writeBytes(12, it.auties.whatsapp.model.chat.GroupPastParticipantsSpec.encode(pastParticipantsEntry));
            }
        }
        return outputStream.toByteArray();
    }

    public static HistorySync decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static HistorySync decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.sync.HistorySync.Type syncType = null;
        java.util.List<it.auties.whatsapp.model.chat.Chat> conversations = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        java.util.List<it.auties.whatsapp.model.info.ChatMessageInfo> statusV3Messages = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        int chunkOrder = 0;
        java.lang.Integer progress = null;
        java.util.List<it.auties.whatsapp.model.sync.PushName> pushNames = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        it.auties.whatsapp.model.setting.GlobalSettings globalSettings = null;
        byte[] threadIdUserSecret = null;
        int threadDsTimeframeOffset = 0;
        java.util.List<it.auties.whatsapp.model.sync.StickerMetadata> recentStickers = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        java.util.List<it.auties.whatsapp.model.chat.GroupPastParticipants> pastParticipants = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> syncType = it.auties.whatsapp.model.sync.HistorySyncTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 2 -> conversations.add(it.auties.whatsapp.model.chat.ChatSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 3 -> statusV3Messages.add(it.auties.whatsapp.model.info.ChatMessageInfoSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 5 -> chunkOrder = protoInputStream.readInt32();
                case 6 -> progress = protoInputStream.readInt32();
                case 7 -> pushNames.add(it.auties.whatsapp.model.sync.PushNameSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 8 -> globalSettings = it.auties.whatsapp.model.setting.GlobalSettingsSpec.decode(protoInputStream.lengthDelimitedStream());
                case 9 -> threadIdUserSecret = protoInputStream.readBytes();
                case 10 -> threadDsTimeframeOffset = protoInputStream.readInt32();
                case 11 -> recentStickers.add(it.auties.whatsapp.model.sync.StickerMetadataSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 12 -> pastParticipants.add(it.auties.whatsapp.model.chat.GroupPastParticipantsSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        Objects.requireNonNull(syncType, "Missing required property: syncType");
        return new it.auties.whatsapp.model.sync.HistorySync(syncType, conversations, statusV3Messages, chunkOrder, progress, pushNames, globalSettings, threadIdUserSecret, threadDsTimeframeOffset, recentStickers, pastParticipants);
    }

    public static int sizeOf(HistorySync object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var syncType = object.syncType();
        protoSize += ProtobufOutputStream.getFieldSize(1, 2);
        var syncTypeSerializedSize = it.auties.whatsapp.model.sync.HistorySyncTypeSpec.sizeOf(syncType);
        protoSize += syncTypeSerializedSize;
        var conversationsRepeatedField = object.conversations();
        if (conversationsRepeatedField != null) {
            for (var conversationsEntry : conversationsRepeatedField) { 
                if (conversationsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                    var conversationsEntrySerializedSize = it.auties.whatsapp.model.chat.ChatSpec.sizeOf(conversationsEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(conversationsEntrySerializedSize);
                    protoSize += conversationsEntrySerializedSize;
                }
            }
        }
        var statusV3MessagesRepeatedField = object.statusV3Messages();
        if (statusV3MessagesRepeatedField != null) {
            for (var statusV3MessagesEntry : statusV3MessagesRepeatedField) { 
                if (statusV3MessagesEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                    var statusV3MessagesEntrySerializedSize = it.auties.whatsapp.model.info.ChatMessageInfoSpec.sizeOf(statusV3MessagesEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(statusV3MessagesEntrySerializedSize);
                    protoSize += statusV3MessagesEntrySerializedSize;
                }
            }
        }
        var chunkOrder = object.chunkOrder();
        protoSize += ProtobufOutputStream.getFieldSize(5, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(chunkOrder);
        var progress = object.progress();
        if (progress != null) {
            protoSize += ProtobufOutputStream.getFieldSize(6, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(progress);
        }
        var pushNamesRepeatedField = object.pushNames();
        if (pushNamesRepeatedField != null) {
            for (var pushNamesEntry : pushNamesRepeatedField) { 
                if (pushNamesEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(7, 2);
                    var pushNamesEntrySerializedSize = it.auties.whatsapp.model.sync.PushNameSpec.sizeOf(pushNamesEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(pushNamesEntrySerializedSize);
                    protoSize += pushNamesEntrySerializedSize;
                }
            }
        }
        var globalSettings = object.globalSettings();
        if (globalSettings != null) {
            protoSize += ProtobufOutputStream.getFieldSize(8, 2);
            var globalSettingsSerializedSize = it.auties.whatsapp.model.setting.GlobalSettingsSpec.sizeOf(globalSettings);
            protoSize += ProtobufOutputStream.getVarIntSize(globalSettingsSerializedSize);
            protoSize += globalSettingsSerializedSize;
        }
        var threadIdUserSecret = object.threadIdUserSecret();
        if (threadIdUserSecret != null) {
            protoSize += ProtobufOutputStream.getFieldSize(9, 2);
            protoSize += ProtobufOutputStream.getBytesSize(threadIdUserSecret);
        }
        var threadDsTimeframeOffset = object.threadDsTimeframeOffset();
        protoSize += ProtobufOutputStream.getFieldSize(10, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(threadDsTimeframeOffset);
        var recentStickersRepeatedField = object.recentStickers();
        if (recentStickersRepeatedField != null) {
            for (var recentStickersEntry : recentStickersRepeatedField) { 
                if (recentStickersEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(11, 2);
                    var recentStickersEntrySerializedSize = it.auties.whatsapp.model.sync.StickerMetadataSpec.sizeOf(recentStickersEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(recentStickersEntrySerializedSize);
                    protoSize += recentStickersEntrySerializedSize;
                }
            }
        }
        var pastParticipantsRepeatedField = object.pastParticipants();
        if (pastParticipantsRepeatedField != null) {
            for (var pastParticipantsEntry : pastParticipantsRepeatedField) { 
                if (pastParticipantsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(12, 2);
                    var pastParticipantsEntrySerializedSize = it.auties.whatsapp.model.chat.GroupPastParticipantsSpec.sizeOf(pastParticipantsEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(pastParticipantsEntrySerializedSize);
                    protoSize += pastParticipantsEntrySerializedSize;
                }
            }
        }
        return protoSize;
    }

}
