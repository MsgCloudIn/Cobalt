package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.ActionMessageRangeSync;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ActionMessageRangeSyncSpec {
    public static byte[] encode(ActionMessageRangeSync protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt64(1, protoInputObject.lastMessageTimestamp());
        outputStream.writeInt64(2, protoInputObject.lastSystemMessageTimestamp());
        if (protoInputObject.messages() != null) {
            for (var messagesEntry : protoInputObject.messages()) { 
                outputStream.writeBytes(3, it.auties.whatsapp.model.sync.SyncActionMessageSpec.encode(messagesEntry));
            }
        }
        return outputStream.toByteArray();
    }

    public static ActionMessageRangeSync decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ActionMessageRangeSync decode(ProtobufInputStream protoInputStream) {
        java.lang.Long lastMessageTimestamp = null;
        java.lang.Long lastSystemMessageTimestamp = null;
        java.util.List<it.auties.whatsapp.model.sync.SyncActionMessage> messages = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> lastMessageTimestamp = protoInputStream.readInt64();
                case 2 -> lastSystemMessageTimestamp = protoInputStream.readInt64();
                case 3 -> messages.add(it.auties.whatsapp.model.sync.SyncActionMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.ActionMessageRangeSync(lastMessageTimestamp, lastSystemMessageTimestamp, messages);
    }

    public static int sizeOf(ActionMessageRangeSync object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var lastMessageTimestamp = object.lastMessageTimestamp();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(lastMessageTimestamp);
        var lastSystemMessageTimestamp = object.lastSystemMessageTimestamp();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(lastSystemMessageTimestamp);
        var messagesRepeatedField = object.messages();
        if (messagesRepeatedField != null) {
            for (var messagesEntry : messagesRepeatedField) { 
                if (messagesEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                    var messagesEntrySerializedSize = it.auties.whatsapp.model.sync.SyncActionMessageSpec.sizeOf(messagesEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(messagesEntrySerializedSize);
                    protoSize += messagesEntrySerializedSize;
                }
            }
        }
        return protoSize;
    }

}
