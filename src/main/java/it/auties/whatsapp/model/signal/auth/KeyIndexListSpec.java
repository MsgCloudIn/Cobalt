package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.KeyIndexList;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class KeyIndexListSpec {
    public static byte[] encode(KeyIndexList protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeUInt32(1, protoInputObject.rawId());
        outputStream.writeUInt64(2, protoInputObject.timestamp());
        outputStream.writeUInt32(3, protoInputObject.currentIndex());
        if (protoInputObject.validIndexes() != null) {
            for (var validIndexesEntry : protoInputObject.validIndexes()) { 
                outputStream.writeUInt32(4, validIndexesEntry);
            }
        }
        return outputStream.toByteArray();
    }

    public static KeyIndexList decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static KeyIndexList decode(ProtobufInputStream protoInputStream) {
        int rawId = 0;
        long timestamp = 0l;
        int currentIndex = 0;
        java.util.List<java.lang.Integer> validIndexes = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> rawId = protoInputStream.readInt32();
                case 2 -> timestamp = protoInputStream.readInt64();
                case 3 -> currentIndex = protoInputStream.readInt32();
                case 4 -> validIndexes.add(protoInputStream.readInt32());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.auth.KeyIndexList(rawId, timestamp, currentIndex, validIndexes);
    }

    public static int sizeOf(KeyIndexList object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var rawId = object.rawId();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(rawId);
        var timestamp = object.timestamp();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(timestamp);
        var currentIndex = object.currentIndex();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(currentIndex);
        var validIndexesRepeatedField = object.validIndexes();
        if (validIndexesRepeatedField != null) {
            for (var validIndexesEntry : validIndexesRepeatedField) { 
                if (validIndexesEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(4, 0);
                    protoSize += ProtobufOutputStream.getVarIntSize(validIndexesEntry);
                }
            }
        }
        return protoSize;
    }

}
