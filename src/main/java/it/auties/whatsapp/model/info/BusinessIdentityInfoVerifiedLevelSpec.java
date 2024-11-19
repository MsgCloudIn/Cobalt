package it.auties.whatsapp.model.info;

import it.auties.whatsapp.model.info.BusinessIdentityInfo.VerifiedLevel;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class BusinessIdentityInfoVerifiedLevelSpec {
    public static Integer encode(VerifiedLevel protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<VerifiedLevel> decode(int index) {
        return Arrays.stream(VerifiedLevel.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(VerifiedLevel object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
