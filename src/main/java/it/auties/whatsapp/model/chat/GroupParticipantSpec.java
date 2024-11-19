package it.auties.whatsapp.model.chat;

import it.auties.whatsapp.model.chat.GroupParticipant;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class GroupParticipantSpec {
    public static byte[] encode(GroupParticipant protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var jid = protoInputObject.jid();
        if (jid != null) {
            var jid0 = jid.toString();
            if (jid0 != null) {
                outputStream.writeString(1, jid0);
            }
        }
        outputStream.writeInt32(2, it.auties.whatsapp.model.chat.GroupRoleSpec.encode(protoInputObject.role()));
        return outputStream.toByteArray();
    }

    public static GroupParticipant decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static GroupParticipant decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.jid.Jid jid = null;
        it.auties.whatsapp.model.chat.GroupRole role = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> jid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 2 -> role = it.auties.whatsapp.model.chat.GroupRoleSpec.decode(protoInputStream.readInt32()).orElse(null);
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.chat.GroupParticipant(jid, role);
    }

    public static int sizeOf(GroupParticipant object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var jid = object.jid();
        if (jid != null) {
            var jid0 = jid.toString();
            if (jid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(jid0);
            }
        }
        var role = object.role();
        if (role != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var roleSerializedSize = it.auties.whatsapp.model.chat.GroupRoleSpec.sizeOf(role);
            protoSize += roleSerializedSize;
        }
        return protoSize;
    }

}
