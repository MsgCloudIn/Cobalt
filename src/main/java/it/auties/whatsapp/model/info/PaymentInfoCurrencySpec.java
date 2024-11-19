package it.auties.whatsapp.model.info;

import it.auties.whatsapp.model.info.PaymentInfo.Currency;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class PaymentInfoCurrencySpec {
    public static Integer encode(Currency protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<Currency> decode(int index) {
        return Arrays.stream(Currency.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(Currency object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
