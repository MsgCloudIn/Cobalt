package it.auties.whatsapp.model.info;

import it.auties.whatsapp.model.info.BusinessAccountLinkInfo.AccountType;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class BusinessAccountLinkInfoAccountTypeSpec {
    public static Integer encode(AccountType protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<AccountType> decode(int index) {
        return Arrays.stream(AccountType.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(AccountType object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
