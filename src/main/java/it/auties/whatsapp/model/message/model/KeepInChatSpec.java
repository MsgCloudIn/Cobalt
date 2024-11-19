package it.auties.whatsapp.model.message.model;

import it.auties.whatsapp.model.message.model.KeepInChat;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class KeepInChatSpec {
    public static byte[] encode(KeepInChat protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, it.auties.whatsapp.model.message.model.KeepInChatTypeSpec.encode(protoInputObject.keepType()));
        outputStream.writeInt64(2, protoInputObject.serverTimestampSeconds());
        outputStream.writeBytes(3, it.auties.whatsapp.model.message.model.ChatMessageKeySpec.encode(protoInputObject.key()));
        var deviceJid = protoInputObject.deviceJid();
        if (deviceJid != null) {
            var deviceJid0 = deviceJid.toString();
            if (deviceJid0 != null) {
                outputStream.writeString(4, deviceJid0);
            }
        }
        outputStream.writeInt64(5, protoInputObject.clientTimestampInMilliseconds());
        outputStream.writeInt64(6, protoInputObject.serverTimestampMilliseconds());
        return outputStream.toByteArray();
    }

    public static KeepInChat decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static KeepInChat decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.message.model.KeepInChatType keepType = null;
        long serverTimestampSeconds = 0l;
        it.auties.whatsapp.model.message.model.ChatMessageKey key = null;
        it.auties.whatsapp.model.jid.Jid deviceJid = null;
        long clientTimestampInMilliseconds = 0l;
        long serverTimestampMilliseconds = 0l;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> keepType = it.auties.whatsapp.model.message.model.KeepInChatTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 2 -> serverTimestampSeconds = protoInputStream.readInt64();
                case 3 -> key = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.decode(protoInputStream.lengthDelimitedStream());
                case 4 -> deviceJid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 5 -> clientTimestampInMilliseconds = protoInputStream.readInt64();
                case 6 -> serverTimestampMilliseconds = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.model.KeepInChat(keepType, serverTimestampSeconds, key, deviceJid, clientTimestampInMilliseconds, serverTimestampMilliseconds);
    }

    public static int sizeOf(KeepInChat object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var keepType = object.keepType();
        if (keepType != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var keepTypeSerializedSize = it.auties.whatsapp.model.message.model.KeepInChatTypeSpec.sizeOf(keepType);
            protoSize += keepTypeSerializedSize;
        }
        var serverTimestampSeconds = object.serverTimestampSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(serverTimestampSeconds);
        var key = object.key();
        if (key != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            var keySerializedSize = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.sizeOf(key);
            protoSize += ProtobufOutputStream.getVarIntSize(keySerializedSize);
            protoSize += keySerializedSize;
        }
        var deviceJid = object.deviceJid();
        if (deviceJid != null) {
            var deviceJid0 = deviceJid.toString();
            if (deviceJid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                protoSize += ProtobufOutputStream.getStringSize(deviceJid0);
            }
        }
        var clientTimestampInMilliseconds = object.clientTimestampInMilliseconds();
        protoSize += ProtobufOutputStream.getFieldSize(5, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(clientTimestampInMilliseconds);
        var serverTimestampMilliseconds = object.serverTimestampMilliseconds();
        protoSize += ProtobufOutputStream.getFieldSize(6, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(serverTimestampMilliseconds);
        return protoSize;
    }

}
