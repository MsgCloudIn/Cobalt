package it.auties.whatsapp.model.info;

import it.auties.whatsapp.model.info.ChatMessageInfo.StubType;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class ChatMessageInfoStubTypeSpec {
    public static Integer encode(StubType protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<StubType> decode(int index) {
        return Arrays.stream(StubType.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(StubType object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
