package it.auties.whatsapp.model.message.standard;

import it.auties.whatsapp.model.message.standard.TextMessage.FontType;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class TextMessageFontTypeSpec {
    public static Integer encode(FontType protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<FontType> decode(int index) {
        return Arrays.stream(FontType.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(FontType object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
