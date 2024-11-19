package it.auties.whatsapp.model.message.standard;

import it.auties.whatsapp.model.message.standard.TextMessage.InviteLinkGroupType;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class TextMessageInviteLinkGroupTypeSpec {
    public static Integer encode(InviteLinkGroupType protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<InviteLinkGroupType> decode(int index) {
        return Arrays.stream(InviteLinkGroupType.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(InviteLinkGroupType object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
