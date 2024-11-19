package it.auties.whatsapp.model.message.server;

import it.auties.whatsapp.model.message.server.StickerSyncRMRMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class StickerSyncRMRMessageSpec {
    public static byte[] encode(StickerSyncRMRMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        if (protoInputObject.hash() != null) {
            for (var hashEntry : protoInputObject.hash()) { 
                outputStream.writeString(1, hashEntry);
            }
        }
        outputStream.writeString(2, protoInputObject.rmrSource());
        outputStream.writeInt64(3, protoInputObject.requestTimestamp());
        return outputStream.toByteArray();
    }

    public static StickerSyncRMRMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static StickerSyncRMRMessage decode(ProtobufInputStream protoInputStream) {
        java.util.List<java.lang.String> hash = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        java.lang.String rmrSource = null;
        long requestTimestamp = 0l;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> hash.add(protoInputStream.readString());
                case 2 -> rmrSource = protoInputStream.readString();
                case 3 -> requestTimestamp = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.server.StickerSyncRMRMessage(hash, rmrSource, requestTimestamp);
    }

    public static int sizeOf(StickerSyncRMRMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var hashRepeatedField = object.hash();
        if (hashRepeatedField != null) {
            for (var hashEntry : hashRepeatedField) { 
                if (hashEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                    protoSize += ProtobufOutputStream.getStringSize(hashEntry);
                }
            }
        }
        var rmrSource = object.rmrSource();
        if (rmrSource != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(rmrSource);
        }
        var requestTimestamp = object.requestTimestamp();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(requestTimestamp);
        return protoSize;
    }

}
