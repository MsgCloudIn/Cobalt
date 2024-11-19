package it.auties.whatsapp.model.business;

import it.auties.whatsapp.model.business.BusinessPrivacyStatus;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class BusinessPrivacyStatusSpec {
    public static Integer encode(BusinessPrivacyStatus protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<BusinessPrivacyStatus> decode(int index) {
        return Arrays.stream(BusinessPrivacyStatus.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(BusinessPrivacyStatus object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
