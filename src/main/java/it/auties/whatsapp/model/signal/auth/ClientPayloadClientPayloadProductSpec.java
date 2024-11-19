package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.ClientPayload.ClientPayloadProduct;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class ClientPayloadClientPayloadProductSpec {
    public static Integer encode(ClientPayloadProduct protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<ClientPayloadProduct> decode(int index) {
        return Arrays.stream(ClientPayloadProduct.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(ClientPayloadProduct object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
