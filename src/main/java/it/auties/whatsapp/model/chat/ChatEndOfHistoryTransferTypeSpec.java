package it.auties.whatsapp.model.chat;

import it.auties.whatsapp.model.chat.Chat.EndOfHistoryTransferType;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class ChatEndOfHistoryTransferTypeSpec {
    public static Integer encode(EndOfHistoryTransferType protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<EndOfHistoryTransferType> decode(int index) {
        return Arrays.stream(EndOfHistoryTransferType.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(EndOfHistoryTransferType object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
