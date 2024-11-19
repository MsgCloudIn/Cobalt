package it.auties.whatsapp.model.chat;

import it.auties.whatsapp.model.chat.ChatWallpaper;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ChatWallpaperSpec {
    public static byte[] encode(ChatWallpaper protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.filename());
        outputStream.writeUInt32(2, protoInputObject.opacity());
        return outputStream.toByteArray();
    }

    public static ChatWallpaper decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ChatWallpaper decode(ProtobufInputStream protoInputStream) {
        java.lang.String filename = null;
        int opacity = 0;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> filename = protoInputStream.readString();
                case 2 -> opacity = protoInputStream.readInt32();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.chat.ChatWallpaper(filename, opacity);
    }

    public static int sizeOf(ChatWallpaper object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var filename = object.filename();
        if (filename != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(filename);
        }
        var opacity = object.opacity();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(opacity);
        return protoSize;
    }

}
