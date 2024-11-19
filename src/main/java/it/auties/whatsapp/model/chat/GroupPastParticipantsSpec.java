package it.auties.whatsapp.model.chat;

import it.auties.whatsapp.model.chat.GroupPastParticipants;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class GroupPastParticipantsSpec {
    public static byte[] encode(GroupPastParticipants protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var groupJid = protoInputObject.groupJid();
        if (groupJid != null) {
            var groupJid0 = groupJid.toString();
            if (groupJid0 != null) {
                outputStream.writeString(1, groupJid0);
            }
        }
        if (protoInputObject.pastParticipants() != null) {
            for (var pastParticipantsEntry : protoInputObject.pastParticipants()) { 
                outputStream.writeBytes(2, it.auties.whatsapp.model.chat.ChatPastParticipantSpec.encode(pastParticipantsEntry));
            }
        }
        return outputStream.toByteArray();
    }

    public static GroupPastParticipants decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static GroupPastParticipants decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.jid.Jid groupJid = null;
        java.util.List<it.auties.whatsapp.model.chat.ChatPastParticipant> pastParticipants = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> groupJid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 2 -> pastParticipants.add(it.auties.whatsapp.model.chat.ChatPastParticipantSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.chat.GroupPastParticipants(groupJid, pastParticipants);
    }

    public static int sizeOf(GroupPastParticipants object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var groupJid = object.groupJid();
        if (groupJid != null) {
            var groupJid0 = groupJid.toString();
            if (groupJid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(groupJid0);
            }
        }
        var pastParticipantsRepeatedField = object.pastParticipants();
        if (pastParticipantsRepeatedField != null) {
            for (var pastParticipantsEntry : pastParticipantsRepeatedField) { 
                if (pastParticipantsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                    var pastParticipantsEntrySerializedSize = it.auties.whatsapp.model.chat.ChatPastParticipantSpec.sizeOf(pastParticipantsEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(pastParticipantsEntrySerializedSize);
                    protoSize += pastParticipantsEntrySerializedSize;
                }
            }
        }
        return protoSize;
    }

}
