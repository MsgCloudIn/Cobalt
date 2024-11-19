package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.RecentEmojiWeight;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class RecentEmojiWeightSpec {
    public static byte[] encode(RecentEmojiWeight protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.emoji());
        outputStream.writeFloat(2, protoInputObject.weight());
        return outputStream.toByteArray();
    }

    public static RecentEmojiWeight decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static RecentEmojiWeight decode(ProtobufInputStream protoInputStream) {
        java.lang.String emoji = null;
        java.lang.Float weight = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> emoji = protoInputStream.readString();
                case 2 -> weight = protoInputStream.readFloat();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.RecentEmojiWeight(emoji, weight);
    }

    public static int sizeOf(RecentEmojiWeight object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var emoji = object.emoji();
        if (emoji != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(emoji);
        }
        var weight = object.weight();
        if (weight != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 5);
            protoSize += 4;
        }
        return protoSize;
    }

}
