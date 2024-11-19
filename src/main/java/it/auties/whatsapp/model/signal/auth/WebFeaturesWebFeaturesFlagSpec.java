package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class WebFeaturesWebFeaturesFlagSpec {
    public static Integer encode(WebFeaturesFlag protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<WebFeaturesFlag> decode(int index) {
        return Arrays.stream(WebFeaturesFlag.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(WebFeaturesFlag object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
