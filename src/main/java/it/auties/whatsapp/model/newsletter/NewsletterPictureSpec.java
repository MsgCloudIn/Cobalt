package it.auties.whatsapp.model.newsletter;

import it.auties.whatsapp.model.newsletter.NewsletterPicture;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class NewsletterPictureSpec {
    public static byte[] encode(NewsletterPicture protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.id());
        outputStream.writeString(2, protoInputObject.type());
        outputStream.writeString(3, protoInputObject.directPath());
        return outputStream.toByteArray();
    }

    public static NewsletterPicture decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static NewsletterPicture decode(ProtobufInputStream protoInputStream) {
        java.lang.String id = null;
        java.lang.String type = null;
        java.lang.String directPath = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> id = protoInputStream.readString();
                case 2 -> type = protoInputStream.readString();
                case 3 -> directPath = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.newsletter.NewsletterPicture(id, type, directPath);
    }

    public static int sizeOf(NewsletterPicture object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var id = object.id();
        if (id != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(id);
        }
        var type = object.type();
        if (type != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(type);
        }
        var directPath = object.directPath();
        if (directPath != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getStringSize(directPath);
        }
        return protoSize;
    }

}
