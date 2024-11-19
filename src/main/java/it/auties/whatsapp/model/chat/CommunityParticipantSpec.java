package it.auties.whatsapp.model.chat;

import it.auties.whatsapp.model.chat.CommunityParticipant;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class CommunityParticipantSpec {
    public static byte[] encode(CommunityParticipant protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var jid = protoInputObject.jid();
        if (jid != null) {
            var jid0 = jid.toString();
            if (jid0 != null) {
                outputStream.writeString(3, jid0);
            }
        }
        return outputStream.toByteArray();
    }

    public static CommunityParticipant decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static CommunityParticipant decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.jid.Jid jid = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 3 -> jid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.chat.CommunityParticipant(jid);
    }

    public static int sizeOf(CommunityParticipant object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var jid = object.jid();
        if (jid != null) {
            var jid0 = jid.toString();
            if (jid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                protoSize += ProtobufOutputStream.getStringSize(jid0);
            }
        }
        return protoSize;
    }

}
