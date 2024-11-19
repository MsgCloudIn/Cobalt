package it.auties.whatsapp.api;

import it.auties.whatsapp.api.MediaProxySetting;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class MediaProxySettingSpec {
    public static Integer encode(MediaProxySetting protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<MediaProxySetting> decode(int index) {
        return Arrays.stream(MediaProxySetting.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(MediaProxySetting object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
