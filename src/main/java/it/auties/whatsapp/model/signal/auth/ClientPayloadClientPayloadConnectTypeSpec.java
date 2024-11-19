package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.ClientPayload.ClientPayloadConnectType;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class ClientPayloadClientPayloadConnectTypeSpec {
    public static Integer encode(ClientPayloadConnectType protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<ClientPayloadConnectType> decode(int index) {
        return Arrays.stream(ClientPayloadConnectType.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(ClientPayloadConnectType object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
