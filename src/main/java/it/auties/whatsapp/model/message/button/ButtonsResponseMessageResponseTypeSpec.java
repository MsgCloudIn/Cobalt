package it.auties.whatsapp.model.message.button;

import it.auties.whatsapp.model.message.button.ButtonsResponseMessage.ResponseType;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class ButtonsResponseMessageResponseTypeSpec {
    public static Integer encode(ResponseType protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<ResponseType> decode(int index) {
        return Arrays.stream(ResponseType.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(ResponseType object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
