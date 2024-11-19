package it.auties.whatsapp.model.chat;

import it.auties.whatsapp.model.chat.CommunityLinkedGroup;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class CommunityLinkedGroupSpec {
    public static byte[] encode(CommunityLinkedGroup protoInputObject) {
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
        var participants = protoInputObject.participants();
        if (participants != null) {
            var participants0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableInt(participants);
            if (participants0 != null) {
                outputStream.writeUInt32(2, participants0);
            }
        }
        return outputStream.toByteArray();
    }

    public static CommunityLinkedGroup decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static CommunityLinkedGroup decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.jid.Jid jid = null;
        java.lang.Integer participants = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> jid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 2 -> participants = protoInputStream.readInt32();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.chat.CommunityLinkedGroup(jid, participants);
    }

    public static int sizeOf(CommunityLinkedGroup object) {
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
        var participants = object.participants();
        if (participants != null) {
            var participants0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableInt(participants);
            if (participants0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(participants0);
            }
        }
        return protoSize;
    }

}
