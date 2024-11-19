package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.UserAgent.PlatformType;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class UserAgentPlatformTypeSpec {
    public static Integer encode(PlatformType protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<PlatformType> decode(int index) {
        return Arrays.stream(PlatformType.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(PlatformType object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
