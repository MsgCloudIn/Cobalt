package it.auties.whatsapp.model.payment;

import it.auties.whatsapp.model.payment.PaymentBackground.PaymentBackgroundType;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class PaymentBackgroundPaymentBackgroundTypeSpec {
    public static Integer encode(PaymentBackgroundType protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<PaymentBackgroundType> decode(int index) {
        return Arrays.stream(PaymentBackgroundType.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(PaymentBackgroundType object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
