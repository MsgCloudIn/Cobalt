package it.auties.whatsapp.model.newsletter;

import it.auties.whatsapp.model.newsletter.NewsletterViewerRole;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class NewsletterViewerRoleSpec {
    public static Integer encode(NewsletterViewerRole protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<NewsletterViewerRole> decode(int index) {
        return Arrays.stream(NewsletterViewerRole.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(NewsletterViewerRole object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
