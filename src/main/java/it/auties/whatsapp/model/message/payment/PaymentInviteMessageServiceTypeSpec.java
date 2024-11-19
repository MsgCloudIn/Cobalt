package it.auties.whatsapp.model.message.payment;

import it.auties.whatsapp.model.message.payment.PaymentInviteMessage.ServiceType;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class PaymentInviteMessageServiceTypeSpec {
    public static Integer encode(ServiceType protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<ServiceType> decode(int index) {
        return Arrays.stream(ServiceType.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(ServiceType object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
