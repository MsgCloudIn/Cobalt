package it.auties.whatsapp.model.media;

import it.auties.whatsapp.model.media.MediaData;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class MediaDataSpec {
    public static byte[] encode(MediaData protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.localPath());
        return outputStream.toByteArray();
    }

    public static MediaData decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static MediaData decode(ProtobufInputStream protoInputStream) {
        java.lang.String localPath = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> localPath = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.media.MediaData(localPath);
    }

    public static int sizeOf(MediaData object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var localPath = object.localPath();
        if (localPath != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(localPath);
        }
        return protoSize;
    }

}
