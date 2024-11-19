package it.auties.whatsapp.model.privacy;

import it.auties.whatsapp.model.privacy.PrivacySettingValue;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class PrivacySettingValueSpec {
    public static Integer encode(PrivacySettingValue protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<PrivacySettingValue> decode(int index) {
        return Arrays.stream(PrivacySettingValue.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(PrivacySettingValue object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
