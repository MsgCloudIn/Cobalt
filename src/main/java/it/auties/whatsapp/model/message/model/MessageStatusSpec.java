package it.auties.whatsapp.model.message.model;

import it.auties.whatsapp.model.message.model.MessageStatus;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class MessageStatusSpec {
    public static Integer encode(MessageStatus protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<MessageStatus> decode(int index) {
        return Arrays.stream(MessageStatus.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(MessageStatus object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
