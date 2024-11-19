package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.UserAgent.DeviceType;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class UserAgentDeviceTypeSpec {
    public static Integer encode(DeviceType protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<DeviceType> decode(int index) {
        return Arrays.stream(DeviceType.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(DeviceType object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
