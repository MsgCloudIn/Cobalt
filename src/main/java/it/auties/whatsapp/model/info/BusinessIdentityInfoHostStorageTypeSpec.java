package it.auties.whatsapp.model.info;

import it.auties.whatsapp.model.info.BusinessIdentityInfo.HostStorageType;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class BusinessIdentityInfoHostStorageTypeSpec {
    public static Integer encode(HostStorageType protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<HostStorageType> decode(int index) {
        return Arrays.stream(HostStorageType.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(HostStorageType object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
