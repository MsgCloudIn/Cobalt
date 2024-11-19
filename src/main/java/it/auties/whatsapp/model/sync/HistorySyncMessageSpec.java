package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.HistorySyncMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class HistorySyncMessageSpec {
    public static byte[] encode(HistorySyncMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.info.ChatMessageInfoSpec.encode(protoInputObject.messageInfo()));
        outputStream.writeUInt64(2, protoInputObject.messageOrderId());
        return outputStream.toByteArray();
    }

    public static HistorySyncMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static HistorySyncMessage decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.info.ChatMessageInfo messageInfo = null;
        long messageOrderId = 0l;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> messageInfo = it.auties.whatsapp.model.info.ChatMessageInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> messageOrderId = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.HistorySyncMessage(messageInfo, messageOrderId);
    }

    public static int sizeOf(HistorySyncMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var messageInfo = object.messageInfo();
        if (messageInfo != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var messageInfoSerializedSize = it.auties.whatsapp.model.info.ChatMessageInfoSpec.sizeOf(messageInfo);
            protoSize += ProtobufOutputStream.getVarIntSize(messageInfoSerializedSize);
            protoSize += messageInfoSerializedSize;
        }
        var messageOrderId = object.messageOrderId();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(messageOrderId);
        return protoSize;
    }

}
