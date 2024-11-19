package it.auties.whatsapp.model.chat;

import it.auties.whatsapp.model.chat.Chat;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ChatSpec {
    public static byte[] encode(Chat protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var jid = protoInputObject.jid;
        if (jid != null) {
            var jid0 = jid.toString();
            if (jid0 != null) {
                outputStream.writeString(1, jid0);
            }
        }
        if (protoInputObject.historySyncMessages != null) {
            for (var historySyncMessagesEntry : protoInputObject.historySyncMessages) { 
                outputStream.writeBytes(2, it.auties.whatsapp.model.sync.HistorySyncMessageSpec.encode(historySyncMessagesEntry));
            }
        }
        var newJid = protoInputObject.newJid;
        if (newJid != null) {
            var newJid0 = newJid.toString();
            if (newJid0 != null) {
                outputStream.writeString(3, newJid0);
            }
        }
        var oldJid = protoInputObject.oldJid;
        if (oldJid != null) {
            var oldJid0 = oldJid.toString();
            if (oldJid0 != null) {
                outputStream.writeString(4, oldJid0);
            }
        }
        outputStream.writeUInt32(6, protoInputObject.unreadMessagesCount);
        outputStream.writeBool(8, protoInputObject.endOfHistoryTransfer);
        var ephemeralMessageDuration = protoInputObject.ephemeralMessageDuration;
        if (ephemeralMessageDuration != null) {
            var ephemeralMessageDuration0 = ephemeralMessageDuration.periodSeconds();
            outputStream.writeUInt32(9, ephemeralMessageDuration0);
        }
        outputStream.writeInt64(10, protoInputObject.ephemeralMessagesToggleTimeSeconds);
        outputStream.writeInt32(11, it.auties.whatsapp.model.chat.ChatEndOfHistoryTransferTypeSpec.encode(protoInputObject.endOfHistoryTransferType));
        outputStream.writeUInt64(12, protoInputObject.timestampSeconds);
        outputStream.writeString(13, protoInputObject.name);
        outputStream.writeBool(15, protoInputObject.notSpam);
        outputStream.writeBool(16, protoInputObject.archived);
        outputStream.writeBytes(17, it.auties.whatsapp.model.chat.ChatDisappearSpec.encode(protoInputObject.disappearInitiator));
        outputStream.writeBool(19, protoInputObject.markedAsUnread);
        outputStream.writeUInt32(24, protoInputObject.pinnedTimestampSeconds);
        var mute = protoInputObject.mute;
        if (mute != null) {
            var mute0 = mute.endTimeStamp();
            outputStream.writeUInt64(25, mute0);
        }
        outputStream.writeBytes(26, it.auties.whatsapp.model.chat.ChatWallpaperSpec.encode(protoInputObject.wallpaper));
        outputStream.writeInt32(27, it.auties.whatsapp.model.media.MediaVisibilitySpec.encode(protoInputObject.mediaVisibility));
        outputStream.writeBool(29, protoInputObject.suspended);
        outputStream.writeBool(30, protoInputObject.terminated);
        outputStream.writeBool(34, protoInputObject.support);
        outputStream.writeString(38, protoInputObject.displayName);
        var phoneJid = protoInputObject.phoneJid;
        if (phoneJid != null) {
            var phoneJid0 = phoneJid.toString();
            if (phoneJid0 != null) {
                outputStream.writeString(39, phoneJid0);
            }
        }
        outputStream.writeBool(40, protoInputObject.shareOwnPhoneNumber);
        outputStream.writeBool(41, protoInputObject.pnhDuplicateLidThread);
        var lid = protoInputObject.lid;
        if (lid != null) {
            var lid0 = lid.toString();
            if (lid0 != null) {
                outputStream.writeString(42, lid0);
            }
        }
        if (protoInputObject.presences != null) {
            for (var presencesEntry : protoInputObject.presences.entrySet()) { 
                var presencesOutputStream = new ProtobufOutputStream(sizeOfPresences(presencesEntry));
                var presences = presencesEntry.getKey();
                if (presences != null) {
                    var presences0 = presences.toString();
                    if (presences0 != null) {
                        presencesOutputStream.writeString(1, presences0);
                    }
                }
                presencesOutputStream.writeInt32(2, it.auties.whatsapp.model.contact.ContactStatusSpec.encode(presencesEntry.getValue()));
                outputStream.writeBytes(999, presencesOutputStream.toByteArray());
            }
        }
        return outputStream.toByteArray();
    }

    public static Chat decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static Chat decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.jid.Jid jid = null;
        it.auties.whatsapp.util.ConcurrentLinkedSet<it.auties.whatsapp.model.sync.HistorySyncMessage> historySyncMessages = new it.auties.whatsapp.util.ConcurrentLinkedSet();
        it.auties.whatsapp.model.jid.Jid newJid = null;
        it.auties.whatsapp.model.jid.Jid oldJid = null;
        int unreadMessagesCount = 0;
        boolean endOfHistoryTransfer = false;
        it.auties.whatsapp.model.chat.ChatEphemeralTimer ephemeralMessageDuration = null;
        long ephemeralMessagesToggleTimeSeconds = 0l;
        it.auties.whatsapp.model.chat.Chat.EndOfHistoryTransferType endOfHistoryTransferType = null;
        long timestampSeconds = 0l;
        java.lang.String name = null;
        boolean notSpam = false;
        boolean archived = false;
        it.auties.whatsapp.model.chat.ChatDisappear disappearInitiator = null;
        boolean markedAsUnread = false;
        int pinnedTimestampSeconds = 0;
        it.auties.whatsapp.model.chat.ChatMute mute = null;
        it.auties.whatsapp.model.chat.ChatWallpaper wallpaper = null;
        it.auties.whatsapp.model.media.MediaVisibility mediaVisibility = null;
        boolean suspended = false;
        boolean terminated = false;
        boolean support = false;
        java.lang.String displayName = null;
        it.auties.whatsapp.model.jid.Jid phoneJid = null;
        boolean shareOwnPhoneNumber = false;
        boolean pnhDuplicateLidThread = false;
        it.auties.whatsapp.model.jid.Jid lid = null;
        java.util.concurrent.ConcurrentHashMap<it.auties.whatsapp.model.jid.Jid,it.auties.whatsapp.model.contact.ContactStatus> presences = new java.util.concurrent.ConcurrentHashMap();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> jid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 2 -> historySyncMessages.add(it.auties.whatsapp.model.sync.HistorySyncMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 3 -> newJid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 4 -> oldJid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 6 -> unreadMessagesCount = protoInputStream.readInt32();
                case 8 -> endOfHistoryTransfer = protoInputStream.readBool();
                case 9 -> ephemeralMessageDuration = it.auties.whatsapp.model.chat.ChatEphemeralTimer.of(protoInputStream.readInt32());
                case 10 -> ephemeralMessagesToggleTimeSeconds = protoInputStream.readInt64();
                case 11 -> endOfHistoryTransferType = it.auties.whatsapp.model.chat.ChatEndOfHistoryTransferTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 12 -> timestampSeconds = protoInputStream.readInt64();
                case 13 -> name = protoInputStream.readString();
                case 15 -> notSpam = protoInputStream.readBool();
                case 16 -> archived = protoInputStream.readBool();
                case 17 -> disappearInitiator = it.auties.whatsapp.model.chat.ChatDisappearSpec.decode(protoInputStream.lengthDelimitedStream());
                case 19 -> markedAsUnread = protoInputStream.readBool();
                case 24 -> pinnedTimestampSeconds = protoInputStream.readInt32();
                case 25 -> mute = it.auties.whatsapp.model.chat.ChatMute.ofProtobuf(protoInputStream.readInt64());
                case 26 -> wallpaper = it.auties.whatsapp.model.chat.ChatWallpaperSpec.decode(protoInputStream.lengthDelimitedStream());
                case 27 -> mediaVisibility = it.auties.whatsapp.model.media.MediaVisibilitySpec.decode(protoInputStream.readInt32()).orElse(null);
                case 29 -> suspended = protoInputStream.readBool();
                case 30 -> terminated = protoInputStream.readBool();
                case 34 -> support = protoInputStream.readBool();
                case 38 -> displayName = protoInputStream.readString();
                case 39 -> phoneJid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 40 -> shareOwnPhoneNumber = protoInputStream.readBool();
                case 41 -> pnhDuplicateLidThread = protoInputStream.readBool();
                case 42 -> lid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 999 -> {
                    var presencesInputStream = protoInputStream.lengthDelimitedStream();
                    it.auties.whatsapp.model.jid.Jid presencesKey = null;
                    it.auties.whatsapp.model.contact.ContactStatus presencesValue = null;
                    while (presencesInputStream.readTag()) {
                        switch (presencesInputStream.index()) {
                            case 1 -> presencesKey = it.auties.whatsapp.model.jid.Jid.ofProtobuf(presencesInputStream.readString());
                            case 2 -> presencesValue = it.auties.whatsapp.model.contact.ContactStatusSpec.decode(presencesInputStream.readInt32()).orElse(null);
                        }
                    }
                    presences.put(presencesKey, presencesValue);
                }
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.chat.Chat(jid, historySyncMessages, newJid, oldJid, unreadMessagesCount, endOfHistoryTransfer, ephemeralMessageDuration, ephemeralMessagesToggleTimeSeconds, endOfHistoryTransferType, timestampSeconds, name, notSpam, archived, disappearInitiator, markedAsUnread, pinnedTimestampSeconds, mute, wallpaper, mediaVisibility, suspended, terminated, support, displayName, phoneJid, shareOwnPhoneNumber, pnhDuplicateLidThread, lid, presences);
    }

    public static int sizeOf(Chat object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var jid = object.jid;
        if (jid != null) {
            var jid0 = jid.toString();
            if (jid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(jid0);
            }
        }
        var historySyncMessagesRepeatedField = object.historySyncMessages;
        if (historySyncMessagesRepeatedField != null) {
            for (var historySyncMessagesEntry : historySyncMessagesRepeatedField) { 
                if (historySyncMessagesEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                    var historySyncMessagesEntrySerializedSize = it.auties.whatsapp.model.sync.HistorySyncMessageSpec.sizeOf(historySyncMessagesEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(historySyncMessagesEntrySerializedSize);
                    protoSize += historySyncMessagesEntrySerializedSize;
                }
            }
        }
        var newJid = object.newJid;
        if (newJid != null) {
            var newJid0 = newJid.toString();
            if (newJid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                protoSize += ProtobufOutputStream.getStringSize(newJid0);
            }
        }
        var oldJid = object.oldJid;
        if (oldJid != null) {
            var oldJid0 = oldJid.toString();
            if (oldJid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                protoSize += ProtobufOutputStream.getStringSize(oldJid0);
            }
        }
        var unreadMessagesCount = object.unreadMessagesCount;
        protoSize += ProtobufOutputStream.getFieldSize(6, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(unreadMessagesCount);
        var endOfHistoryTransfer = object.endOfHistoryTransfer;
        protoSize += ProtobufOutputStream.getFieldSize(8, 0);
        protoSize += 1;
        var ephemeralMessageDuration = object.ephemeralMessageDuration;
        if (ephemeralMessageDuration != null) {
            var ephemeralMessageDuration0 = ephemeralMessageDuration.periodSeconds();
            protoSize += ProtobufOutputStream.getFieldSize(9, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(ephemeralMessageDuration0);
        }
        var ephemeralMessagesToggleTimeSeconds = object.ephemeralMessagesToggleTimeSeconds;
        protoSize += ProtobufOutputStream.getFieldSize(10, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(ephemeralMessagesToggleTimeSeconds);
        var endOfHistoryTransferType = object.endOfHistoryTransferType;
        if (endOfHistoryTransferType != null) {
            protoSize += ProtobufOutputStream.getFieldSize(11, 2);
            var endOfHistoryTransferTypeSerializedSize = it.auties.whatsapp.model.chat.ChatEndOfHistoryTransferTypeSpec.sizeOf(endOfHistoryTransferType);
            protoSize += endOfHistoryTransferTypeSerializedSize;
        }
        var timestampSeconds = object.timestampSeconds;
        protoSize += ProtobufOutputStream.getFieldSize(12, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(timestampSeconds);
        var name = object.name;
        if (name != null) {
            protoSize += ProtobufOutputStream.getFieldSize(13, 2);
            protoSize += ProtobufOutputStream.getStringSize(name);
        }
        var notSpam = object.notSpam;
        protoSize += ProtobufOutputStream.getFieldSize(15, 0);
        protoSize += 1;
        var archived = object.archived;
        protoSize += ProtobufOutputStream.getFieldSize(16, 0);
        protoSize += 1;
        var disappearInitiator = object.disappearInitiator;
        if (disappearInitiator != null) {
            protoSize += ProtobufOutputStream.getFieldSize(17, 2);
            var disappearInitiatorSerializedSize = it.auties.whatsapp.model.chat.ChatDisappearSpec.sizeOf(disappearInitiator);
            protoSize += ProtobufOutputStream.getVarIntSize(disappearInitiatorSerializedSize);
            protoSize += disappearInitiatorSerializedSize;
        }
        var markedAsUnread = object.markedAsUnread;
        protoSize += ProtobufOutputStream.getFieldSize(19, 0);
        protoSize += 1;
        var pinnedTimestampSeconds = object.pinnedTimestampSeconds;
        protoSize += ProtobufOutputStream.getFieldSize(24, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(pinnedTimestampSeconds);
        var mute = object.mute;
        if (mute != null) {
            var mute0 = mute.endTimeStamp();
            protoSize += ProtobufOutputStream.getFieldSize(25, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(mute0);
        }
        var wallpaper = object.wallpaper;
        if (wallpaper != null) {
            protoSize += ProtobufOutputStream.getFieldSize(26, 2);
            var wallpaperSerializedSize = it.auties.whatsapp.model.chat.ChatWallpaperSpec.sizeOf(wallpaper);
            protoSize += ProtobufOutputStream.getVarIntSize(wallpaperSerializedSize);
            protoSize += wallpaperSerializedSize;
        }
        var mediaVisibility = object.mediaVisibility;
        if (mediaVisibility != null) {
            protoSize += ProtobufOutputStream.getFieldSize(27, 2);
            var mediaVisibilitySerializedSize = it.auties.whatsapp.model.media.MediaVisibilitySpec.sizeOf(mediaVisibility);
            protoSize += mediaVisibilitySerializedSize;
        }
        var suspended = object.suspended;
        protoSize += ProtobufOutputStream.getFieldSize(29, 0);
        protoSize += 1;
        var terminated = object.terminated;
        protoSize += ProtobufOutputStream.getFieldSize(30, 0);
        protoSize += 1;
        var support = object.support;
        protoSize += ProtobufOutputStream.getFieldSize(34, 0);
        protoSize += 1;
        var displayName = object.displayName;
        if (displayName != null) {
            protoSize += ProtobufOutputStream.getFieldSize(38, 2);
            protoSize += ProtobufOutputStream.getStringSize(displayName);
        }
        var phoneJid = object.phoneJid;
        if (phoneJid != null) {
            var phoneJid0 = phoneJid.toString();
            if (phoneJid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(39, 2);
                protoSize += ProtobufOutputStream.getStringSize(phoneJid0);
            }
        }
        var shareOwnPhoneNumber = object.shareOwnPhoneNumber;
        protoSize += ProtobufOutputStream.getFieldSize(40, 0);
        protoSize += 1;
        var pnhDuplicateLidThread = object.pnhDuplicateLidThread;
        protoSize += ProtobufOutputStream.getFieldSize(41, 0);
        protoSize += 1;
        var lid = object.lid;
        if (lid != null) {
            var lid0 = lid.toString();
            if (lid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(42, 2);
                protoSize += ProtobufOutputStream.getStringSize(lid0);
            }
        }
        var presencesMapField = object.presences;
        if (presencesMapField != null) {
            for (var presencesMapEntry : presencesMapField.entrySet()) { 
                protoSize += ProtobufOutputStream.getFieldSize(999, 2);
                var presencesMapEntrySize = sizeOfPresences(presencesMapEntry);
                protoSize += ProtobufOutputStream.getVarIntSize(presencesMapEntrySize);
                protoSize += presencesMapEntrySize;
            }
        }
        return protoSize;
    }

    private static int sizeOfPresences(java.util.Map.Entry<it.auties.whatsapp.model.jid.Jid, it.auties.whatsapp.model.contact.ContactStatus> object) {
        var protoSize = 0;
        var objectMapKey = object.getKey();
        var objectMapKey0 = objectMapKey.toString();
        if (objectMapKey0 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(objectMapKey0);
        }
        var presencesMapValue = object.getValue();
        if (presencesMapValue != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var presencesMapValueSerializedSize = it.auties.whatsapp.model.contact.ContactStatusSpec.sizeOf(presencesMapValue);
            protoSize += presencesMapValueSerializedSize;
        }
        return protoSize;
    }

}
