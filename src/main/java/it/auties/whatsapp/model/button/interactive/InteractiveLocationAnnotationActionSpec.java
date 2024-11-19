package it.auties.whatsapp.model.button.interactive;

import it.auties.whatsapp.model.button.interactive.InteractiveLocationAnnotation.Action;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class InteractiveLocationAnnotationActionSpec {
    public static Integer encode(Action protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<Action> decode(int index) {
        return Arrays.stream(Action.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(Action object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
