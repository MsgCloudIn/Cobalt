package it.auties.whatsapp.model.chat;

import it.auties.whatsapp.model.chat.ChatPastParticipant.Reason;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class ChatPastParticipantReasonSpec {
    public static Integer encode(Reason protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<Reason> decode(int index) {
        return Arrays.stream(Reason.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(Reason object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
