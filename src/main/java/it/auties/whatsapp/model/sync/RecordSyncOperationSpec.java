package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.RecordSync.Operation;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class RecordSyncOperationSpec {
    public static Integer encode(Operation protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<Operation> decode(int index) {
        return Arrays.stream(Operation.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(Operation object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
