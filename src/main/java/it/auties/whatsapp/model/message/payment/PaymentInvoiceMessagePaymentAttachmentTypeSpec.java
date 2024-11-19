package it.auties.whatsapp.model.message.payment;

import it.auties.whatsapp.model.message.payment.PaymentInvoiceMessage.PaymentAttachmentType;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class PaymentInvoiceMessagePaymentAttachmentTypeSpec {
    public static Integer encode(PaymentAttachmentType protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<PaymentAttachmentType> decode(int index) {
        return Arrays.stream(PaymentAttachmentType.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(PaymentAttachmentType object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
