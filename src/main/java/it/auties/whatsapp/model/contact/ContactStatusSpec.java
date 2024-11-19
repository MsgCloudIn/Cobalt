package it.auties.whatsapp.model.contact;

import it.auties.whatsapp.model.contact.ContactStatus;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class ContactStatusSpec {
    public static Integer encode(ContactStatus protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<ContactStatus> decode(int index) {
        return Arrays.stream(ContactStatus.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(ContactStatus object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
