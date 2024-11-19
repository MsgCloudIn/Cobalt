package it.auties.whatsapp.model.message.model;

import it.auties.whatsapp.model.message.model.KeepInChatType;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class KeepInChatTypeSpec {
    public static Integer encode(KeepInChatType protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<KeepInChatType> decode(int index) {
        return Arrays.stream(KeepInChatType.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(KeepInChatType object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
