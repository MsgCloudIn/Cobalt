package it.auties.whatsapp.model.button.template.hsm;

import it.auties.whatsapp.model.button.template.hsm.HighlyStructuredButton.Type;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class HighlyStructuredButtonTypeSpec {
    public static Integer encode(Type protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<Type> decode(int index) {
        return Arrays.stream(Type.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(Type object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
