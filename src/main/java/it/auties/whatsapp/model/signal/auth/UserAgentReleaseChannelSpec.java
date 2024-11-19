package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.UserAgent.ReleaseChannel;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class UserAgentReleaseChannelSpec {
    public static Integer encode(ReleaseChannel protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<ReleaseChannel> decode(int index) {
        return Arrays.stream(ReleaseChannel.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(ReleaseChannel object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
