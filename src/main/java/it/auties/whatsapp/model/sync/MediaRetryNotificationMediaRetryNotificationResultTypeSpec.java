package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.MediaRetryNotification.MediaRetryNotificationResultType;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class MediaRetryNotificationMediaRetryNotificationResultTypeSpec {
    public static Integer encode(MediaRetryNotificationResultType protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<MediaRetryNotificationResultType> decode(int index) {
        return Arrays.stream(MediaRetryNotificationResultType.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(MediaRetryNotificationResultType object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
