package it.auties.whatsapp.model.newsletter;

import it.auties.whatsapp.model.newsletter.NewsletterReaction;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class NewsletterReactionSpec {
    public static byte[] encode(NewsletterReaction protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.content());
        outputStream.writeUInt64(2, protoInputObject.count());
        outputStream.writeBool(3, protoInputObject.fromMe());
        return outputStream.toByteArray();
    }

    public static NewsletterReaction decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static NewsletterReaction decode(ProtobufInputStream protoInputStream) {
        java.lang.String content = null;
        long count = 0l;
        boolean fromMe = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> content = protoInputStream.readString();
                case 2 -> count = protoInputStream.readInt64();
                case 3 -> fromMe = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.newsletter.NewsletterReaction(content, count, fromMe);
    }

    public static int sizeOf(NewsletterReaction object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var content = object.content();
        if (content != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(content);
        }
        var count = object.count();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(count);
        var fromMe = object.fromMe();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += 1;
        return protoSize;
    }

}
