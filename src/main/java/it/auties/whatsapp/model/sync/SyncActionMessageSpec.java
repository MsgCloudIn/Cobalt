package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.SyncActionMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SyncActionMessageSpec {
    public static byte[] encode(SyncActionMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.message.model.ChatMessageKeySpec.encode(protoInputObject.key()));
        outputStream.writeInt64(2, protoInputObject.timestamp());
        return outputStream.toByteArray();
    }

    public static SyncActionMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SyncActionMessage decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.message.model.ChatMessageKey key = null;
        java.lang.Long timestamp = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> key = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> timestamp = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.SyncActionMessage(key, timestamp);
    }

    public static int sizeOf(SyncActionMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var key = object.key();
        if (key != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var keySerializedSize = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.sizeOf(key);
            protoSize += ProtobufOutputStream.getVarIntSize(keySerializedSize);
            protoSize += keySerializedSize;
        }
        var timestamp = object.timestamp();
        if (timestamp != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(timestamp);
        }
        return protoSize;
    }

}
