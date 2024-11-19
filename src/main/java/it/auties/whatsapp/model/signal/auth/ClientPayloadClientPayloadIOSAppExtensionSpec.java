package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.ClientPayload.ClientPayloadIOSAppExtension;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class ClientPayloadClientPayloadIOSAppExtensionSpec {
    public static Integer encode(ClientPayloadIOSAppExtension protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<ClientPayloadIOSAppExtension> decode(int index) {
        return Arrays.stream(ClientPayloadIOSAppExtension.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(ClientPayloadIOSAppExtension object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
