package it.auties.whatsapp.model.info;

import it.auties.whatsapp.model.info.PaymentInfo.TransactionStatus;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class PaymentInfoTransactionStatusSpec {
    public static Integer encode(TransactionStatus protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<TransactionStatus> decode(int index) {
        return Arrays.stream(TransactionStatus.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(TransactionStatus object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
