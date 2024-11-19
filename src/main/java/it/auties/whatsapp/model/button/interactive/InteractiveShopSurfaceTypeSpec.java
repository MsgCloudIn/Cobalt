package it.auties.whatsapp.model.button.interactive;

import it.auties.whatsapp.model.button.interactive.InteractiveShop.SurfaceType;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class InteractiveShopSurfaceTypeSpec {
    public static Integer encode(SurfaceType protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<SurfaceType> decode(int index) {
        return Arrays.stream(SurfaceType.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(SurfaceType object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
