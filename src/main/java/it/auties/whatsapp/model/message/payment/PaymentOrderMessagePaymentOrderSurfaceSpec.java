package it.auties.whatsapp.model.message.payment;

import it.auties.whatsapp.model.message.payment.PaymentOrderMessage.PaymentOrderSurface;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class PaymentOrderMessagePaymentOrderSurfaceSpec {
    public static Integer encode(PaymentOrderSurface protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<PaymentOrderSurface> decode(int index) {
        return Arrays.stream(PaymentOrderSurface.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(PaymentOrderSurface object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
