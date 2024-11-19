package it.auties.whatsapp.model.action;

import it.auties.whatsapp.model.action.QuickReplyAction;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class QuickReplyActionSpec {
    public static byte[] encode(QuickReplyAction protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.shortcut());
        outputStream.writeString(2, protoInputObject.message());
        if (protoInputObject.keywords() != null) {
            for (var keywordsEntry : protoInputObject.keywords()) { 
                outputStream.writeString(3, keywordsEntry);
            }
        }
        outputStream.writeInt32(4, protoInputObject.count());
        outputStream.writeBool(5, protoInputObject.deleted());
        return outputStream.toByteArray();
    }

    public static QuickReplyAction decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static QuickReplyAction decode(ProtobufInputStream protoInputStream) {
        java.lang.String shortcut = null;
        java.lang.String message = null;
        java.util.List<java.lang.String> keywords = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        int count = 0;
        boolean deleted = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> shortcut = protoInputStream.readString();
                case 2 -> message = protoInputStream.readString();
                case 3 -> keywords.add(protoInputStream.readString());
                case 4 -> count = protoInputStream.readInt32();
                case 5 -> deleted = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.action.QuickReplyAction(shortcut, message, keywords, count, deleted);
    }

    public static int sizeOf(QuickReplyAction object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var shortcut = object.shortcut();
        if (shortcut != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(shortcut);
        }
        var message = object.message();
        if (message != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(message);
        }
        var keywordsRepeatedField = object.keywords();
        if (keywordsRepeatedField != null) {
            for (var keywordsEntry : keywordsRepeatedField) { 
                if (keywordsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                    protoSize += ProtobufOutputStream.getStringSize(keywordsEntry);
                }
            }
        }
        var count = object.count();
        protoSize += ProtobufOutputStream.getFieldSize(4, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(count);
        var deleted = object.deleted();
        protoSize += ProtobufOutputStream.getFieldSize(5, 0);
        protoSize += 1;
        return protoSize;
    }

}
