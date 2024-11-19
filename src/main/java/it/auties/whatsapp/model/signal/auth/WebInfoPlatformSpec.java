package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.WebInfo.Platform;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class WebInfoPlatformSpec {
    public static Integer encode(Platform protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<Platform> decode(int index) {
        return Arrays.stream(Platform.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(Platform object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
