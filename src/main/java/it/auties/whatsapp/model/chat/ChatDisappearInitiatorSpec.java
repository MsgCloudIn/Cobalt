package it.auties.whatsapp.model.chat;

import it.auties.whatsapp.model.chat.ChatDisappear.Initiator;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class ChatDisappearInitiatorSpec {
    public static Integer encode(Initiator protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<Initiator> decode(int index) {
        return Arrays.stream(Initiator.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(Initiator object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
