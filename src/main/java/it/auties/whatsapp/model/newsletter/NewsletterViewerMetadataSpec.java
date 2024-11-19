package it.auties.whatsapp.model.newsletter;

import it.auties.whatsapp.model.newsletter.NewsletterViewerMetadata;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class NewsletterViewerMetadataSpec {
    public static byte[] encode(NewsletterViewerMetadata protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBool(1, protoInputObject.mute());
        outputStream.writeInt32(2, it.auties.whatsapp.model.newsletter.NewsletterViewerRoleSpec.encode(protoInputObject.role()));
        return outputStream.toByteArray();
    }

    public static NewsletterViewerMetadata decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static NewsletterViewerMetadata decode(ProtobufInputStream protoInputStream) {
        boolean mute = false;
        it.auties.whatsapp.model.newsletter.NewsletterViewerRole role = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> mute = protoInputStream.readBool();
                case 2 -> role = it.auties.whatsapp.model.newsletter.NewsletterViewerRoleSpec.decode(protoInputStream.readInt32()).orElse(null);
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.newsletter.NewsletterViewerMetadata(mute, role);
    }

    public static int sizeOf(NewsletterViewerMetadata object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var mute = object.mute();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += 1;
        var role = object.role();
        if (role != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var roleSerializedSize = it.auties.whatsapp.model.newsletter.NewsletterViewerRoleSpec.sizeOf(role);
            protoSize += roleSerializedSize;
        }
        return protoSize;
    }

}
