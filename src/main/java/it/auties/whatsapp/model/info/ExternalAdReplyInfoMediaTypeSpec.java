package it.auties.whatsapp.model.info;

import it.auties.whatsapp.model.info.ExternalAdReplyInfo.MediaType;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class ExternalAdReplyInfoMediaTypeSpec {
    public static Integer encode(MediaType protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<MediaType> decode(int index) {
        return Arrays.stream(MediaType.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(MediaType object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
