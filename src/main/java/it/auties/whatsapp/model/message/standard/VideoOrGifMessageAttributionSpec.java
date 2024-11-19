package it.auties.whatsapp.model.message.standard;

import it.auties.whatsapp.model.message.standard.VideoOrGifMessage.Attribution;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class VideoOrGifMessageAttributionSpec {
    public static Integer encode(Attribution protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<Attribution> decode(int index) {
        return Arrays.stream(Attribution.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(Attribution object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
