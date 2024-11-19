package it.auties.whatsapp.model.newsletter;

import it.auties.whatsapp.model.newsletter.NewsletterSettings;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class NewsletterSettingsSpec {
    public static byte[] encode(NewsletterSettings protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.newsletter.NewsletterReactionSettingsSpec.encode(protoInputObject.reactionCodes()));
        return outputStream.toByteArray();
    }

    public static NewsletterSettings decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static NewsletterSettings decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.newsletter.NewsletterReactionSettings reactionCodes = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> reactionCodes = it.auties.whatsapp.model.newsletter.NewsletterReactionSettingsSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.newsletter.NewsletterSettings(reactionCodes);
    }

    public static int sizeOf(NewsletterSettings object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var reactionCodes = object.reactionCodes();
        if (reactionCodes != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var reactionCodesSerializedSize = it.auties.whatsapp.model.newsletter.NewsletterReactionSettingsSpec.sizeOf(reactionCodes);
            protoSize += ProtobufOutputStream.getVarIntSize(reactionCodesSerializedSize);
            protoSize += reactionCodesSerializedSize;
        }
        return protoSize;
    }

}
