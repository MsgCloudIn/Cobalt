package it.auties.whatsapp.model.chat;

import it.auties.whatsapp.model.chat.ChatEphemeralTimer;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class ChatEphemeralTimerSpec {
    public static Integer encode(ChatEphemeralTimer protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<ChatEphemeralTimer> decode(int index) {
        return Arrays.stream(ChatEphemeralTimer.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(ChatEphemeralTimer object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
