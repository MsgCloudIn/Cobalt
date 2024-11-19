package it.auties.whatsapp.model.info;

import it.auties.whatsapp.model.info.PaymentInfo.Status;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class PaymentInfoStatusSpec {
    public static Integer encode(Status protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<Status> decode(int index) {
        return Arrays.stream(Status.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(Status object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
