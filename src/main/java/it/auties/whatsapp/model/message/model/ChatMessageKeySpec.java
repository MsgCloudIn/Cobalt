package it.auties.whatsapp.model.message.model;

import it.auties.whatsapp.model.message.model.ChatMessageKey;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ChatMessageKeySpec {
    public static byte[] encode(ChatMessageKey protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var chatJid = protoInputObject.chatJid();
        if (chatJid != null) {
            var chatJid0 = chatJid.toString();
            if (chatJid0 != null) {
                outputStream.writeString(1, chatJid0);
            }
        }
        outputStream.writeBool(2, protoInputObject.fromMe());
        outputStream.writeString(3, protoInputObject.id());
        var senderJid = protoInputObject.senderJid();
        if (senderJid != null) {
            var senderJid0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(senderJid);
            if (senderJid0 != null) {
                var senderJid1 = senderJid0.toString();
                if (senderJid1 != null) {
                    outputStream.writeString(4, senderJid1);
                }
            }
        }
        return outputStream.toByteArray();
    }

    public static ChatMessageKey decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ChatMessageKey decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.jid.Jid chatJid = null;
        boolean fromMe = false;
        java.lang.String id = null;
        it.auties.whatsapp.model.jid.Jid senderJid = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> chatJid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 2 -> fromMe = protoInputStream.readBool();
                case 3 -> id = protoInputStream.readString();
                case 4 -> senderJid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.model.ChatMessageKey(chatJid, fromMe, id, senderJid);
    }

    public static int sizeOf(ChatMessageKey object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var chatJid = object.chatJid();
        if (chatJid != null) {
            var chatJid0 = chatJid.toString();
            if (chatJid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(chatJid0);
            }
        }
        var fromMe = object.fromMe();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += 1;
        var id = object.id();
        if (id != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getStringSize(id);
        }
        var senderJid = object.senderJid();
        if (senderJid != null) {
            var senderJid0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(senderJid);
            if (senderJid0 != null) {
                var senderJid1 = senderJid0.toString();
                if (senderJid1 != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                    protoSize += ProtobufOutputStream.getStringSize(senderJid1);
                }
            }
        }
        return protoSize;
    }

}
