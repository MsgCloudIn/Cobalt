package it.auties.whatsapp.api;

import it.auties.whatsapp.api.ClientType;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class ClientTypeSpec {
    public static Integer encode(ClientType protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<ClientType> decode(int index) {
        return Arrays.stream(ClientType.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(ClientType object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
