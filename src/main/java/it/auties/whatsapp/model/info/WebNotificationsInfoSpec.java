package it.auties.whatsapp.model.info;

import it.auties.whatsapp.model.info.WebNotificationsInfo;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class WebNotificationsInfoSpec {
    public static byte[] encode(WebNotificationsInfo protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeUInt64(2, protoInputObject.timestampSeconds());
        outputStream.writeUInt32(3, protoInputObject.unreadChats());
        outputStream.writeUInt32(4, protoInputObject.notifyMessageCount());
        if (protoInputObject.notifyMessages() != null) {
            for (var notifyMessagesEntry : protoInputObject.notifyMessages()) { 
                outputStream.writeBytes(5, it.auties.whatsapp.model.info.ChatMessageInfoSpec.encode(notifyMessagesEntry));
            }
        }
        return outputStream.toByteArray();
    }

    public static WebNotificationsInfo decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static WebNotificationsInfo decode(ProtobufInputStream protoInputStream) {
        long timestampSeconds = 0l;
        int unreadChats = 0;
        int notifyMessageCount = 0;
        java.util.List<it.auties.whatsapp.model.info.ChatMessageInfo> notifyMessages = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 2 -> timestampSeconds = protoInputStream.readInt64();
                case 3 -> unreadChats = protoInputStream.readInt32();
                case 4 -> notifyMessageCount = protoInputStream.readInt32();
                case 5 -> notifyMessages.add(it.auties.whatsapp.model.info.ChatMessageInfoSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.info.WebNotificationsInfo(timestampSeconds, unreadChats, notifyMessageCount, notifyMessages);
    }

    public static int sizeOf(WebNotificationsInfo object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var timestampSeconds = object.timestampSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(timestampSeconds);
        var unreadChats = object.unreadChats();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(unreadChats);
        var notifyMessageCount = object.notifyMessageCount();
        protoSize += ProtobufOutputStream.getFieldSize(4, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(notifyMessageCount);
        var notifyMessagesRepeatedField = object.notifyMessages();
        if (notifyMessagesRepeatedField != null) {
            for (var notifyMessagesEntry : notifyMessagesRepeatedField) { 
                if (notifyMessagesEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                    var notifyMessagesEntrySerializedSize = it.auties.whatsapp.model.info.ChatMessageInfoSpec.sizeOf(notifyMessagesEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(notifyMessagesEntrySerializedSize);
                    protoSize += notifyMessagesEntrySerializedSize;
                }
            }
        }
        return protoSize;
    }

}
