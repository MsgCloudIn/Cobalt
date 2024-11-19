package it.auties.whatsapp.model.chat;

import it.auties.whatsapp.model.chat.ChatPastParticipant;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ChatPastParticipantSpec {
    public static byte[] encode(ChatPastParticipant protoInputObject) {
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
        outputStream.writeInt32(2, it.auties.whatsapp.model.chat.ChatPastParticipantReasonSpec.encode(protoInputObject.reason()));
        outputStream.writeUInt64(3, protoInputObject.timestampSeconds());
        return outputStream.toByteArray();
    }

    public static ChatPastParticipant decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ChatPastParticipant decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.jid.Jid jid = null;
        it.auties.whatsapp.model.chat.ChatPastParticipant.Reason reason = null;
        long timestampSeconds = 0l;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> jid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 2 -> reason = it.auties.whatsapp.model.chat.ChatPastParticipantReasonSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 3 -> timestampSeconds = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.chat.ChatPastParticipant(jid, reason, timestampSeconds);
    }

    public static int sizeOf(ChatPastParticipant object) {
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
        var reason = object.reason();
        if (reason != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var reasonSerializedSize = it.auties.whatsapp.model.chat.ChatPastParticipantReasonSpec.sizeOf(reason);
            protoSize += reasonSerializedSize;
        }
        var timestampSeconds = object.timestampSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(timestampSeconds);
        return protoSize;
    }

}
