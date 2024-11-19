package it.auties.whatsapp.model.call;

import it.auties.whatsapp.model.call.CallStatus;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class CallStatusSpec {
    public static Integer encode(CallStatus protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<CallStatus> decode(int index) {
        return Arrays.stream(CallStatus.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(CallStatus object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
