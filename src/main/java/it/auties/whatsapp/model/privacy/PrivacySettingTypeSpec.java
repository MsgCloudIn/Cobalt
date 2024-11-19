package it.auties.whatsapp.model.privacy;

import it.auties.whatsapp.model.privacy.PrivacySettingType;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class PrivacySettingTypeSpec {
    public static Integer encode(PrivacySettingType protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<PrivacySettingType> decode(int index) {
        return Arrays.stream(PrivacySettingType.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(PrivacySettingType object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
