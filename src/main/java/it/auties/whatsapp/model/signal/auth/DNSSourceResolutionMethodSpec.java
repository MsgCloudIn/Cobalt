package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.DNSSource.ResolutionMethod;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class DNSSourceResolutionMethodSpec {
    public static Integer encode(ResolutionMethod protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<ResolutionMethod> decode(int index) {
        return Arrays.stream(ResolutionMethod.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(ResolutionMethod object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
