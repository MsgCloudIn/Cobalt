package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.PatchType;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class PatchTypeSpec {
    public static Integer encode(PatchType protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<PatchType> decode(int index) {
        return Arrays.stream(PatchType.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(PatchType object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
