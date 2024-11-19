package it.auties.whatsapp.model.chat;

import it.auties.whatsapp.model.chat.GroupRole;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class GroupRoleSpec {
    public static Integer encode(GroupRole protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<GroupRole> decode(int index) {
        return Arrays.stream(GroupRole.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(GroupRole object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
