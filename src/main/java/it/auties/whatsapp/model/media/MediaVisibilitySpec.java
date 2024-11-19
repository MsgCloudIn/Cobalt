package it.auties.whatsapp.model.media;

import it.auties.whatsapp.model.media.MediaVisibility;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class MediaVisibilitySpec {
    public static Integer encode(MediaVisibility protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<MediaVisibility> decode(int index) {
        return Arrays.stream(MediaVisibility.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(MediaVisibility object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
