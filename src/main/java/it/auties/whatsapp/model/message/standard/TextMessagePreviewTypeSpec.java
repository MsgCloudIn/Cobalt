package it.auties.whatsapp.model.message.standard;

import it.auties.whatsapp.model.message.standard.TextMessage.PreviewType;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class TextMessagePreviewTypeSpec {
    public static Integer encode(PreviewType protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<PreviewType> decode(int index) {
        return Arrays.stream(PreviewType.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(PreviewType object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
