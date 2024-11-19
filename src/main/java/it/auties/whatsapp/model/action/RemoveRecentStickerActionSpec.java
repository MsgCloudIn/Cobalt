package it.auties.whatsapp.model.action;

import it.auties.whatsapp.model.action.RemoveRecentStickerAction;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class RemoveRecentStickerActionSpec {
    public static byte[] encode(RemoveRecentStickerAction protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt64(1, protoInputObject.lastStickerSentTimestampSeconds());
        return outputStream.toByteArray();
    }

    public static RemoveRecentStickerAction decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static RemoveRecentStickerAction decode(ProtobufInputStream protoInputStream) {
        long lastStickerSentTimestampSeconds = 0l;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> lastStickerSentTimestampSeconds = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.action.RemoveRecentStickerAction(lastStickerSentTimestampSeconds);
    }

    public static int sizeOf(RemoveRecentStickerAction object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var lastStickerSentTimestampSeconds = object.lastStickerSentTimestampSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(lastStickerSentTimestampSeconds);
        return protoSize;
    }

}
