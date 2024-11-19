package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.ClientPayload.ClientPayloadConnectReason;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class ClientPayloadClientPayloadConnectReasonSpec {
    public static Integer encode(ClientPayloadConnectReason protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<ClientPayloadConnectReason> decode(int index) {
        return Arrays.stream(ClientPayloadConnectReason.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(ClientPayloadConnectReason object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
