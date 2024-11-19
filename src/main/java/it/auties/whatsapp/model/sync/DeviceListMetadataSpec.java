package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.DeviceListMetadata;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class DeviceListMetadataSpec {
    public static byte[] encode(DeviceListMetadata protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, protoInputObject.senderKeyHash());
        outputStream.writeUInt64(2, protoInputObject.senderTimestamp());
        if (protoInputObject.senderKeyIndexes() != null) {
            for (var senderKeyIndexesEntry : protoInputObject.senderKeyIndexes()) { 
                outputStream.writeUInt32(3, senderKeyIndexesEntry);
            }
        }
        outputStream.writeBytes(8, protoInputObject.recipientKeyHash());
        outputStream.writeUInt64(9, protoInputObject.recipientTimestamp());
        if (protoInputObject.recipientKeyIndexes() != null) {
            for (var recipientKeyIndexesEntry : protoInputObject.recipientKeyIndexes()) { 
                outputStream.writeUInt32(10, recipientKeyIndexesEntry);
            }
        }
        return outputStream.toByteArray();
    }

    public static DeviceListMetadata decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static DeviceListMetadata decode(ProtobufInputStream protoInputStream) {
        byte[] senderKeyHash = null;
        java.lang.Long senderTimestamp = null;
        java.util.List<java.lang.Integer> senderKeyIndexes = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        byte[] recipientKeyHash = null;
        java.lang.Long recipientTimestamp = null;
        java.util.List<java.lang.Integer> recipientKeyIndexes = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> senderKeyHash = protoInputStream.readBytes();
                case 2 -> senderTimestamp = protoInputStream.readInt64();
                case 3 -> senderKeyIndexes.addAll(protoInputStream.readInt32Packed());
                case 8 -> recipientKeyHash = protoInputStream.readBytes();
                case 9 -> recipientTimestamp = protoInputStream.readInt64();
                case 10 -> recipientKeyIndexes.addAll(protoInputStream.readInt32Packed());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.DeviceListMetadata(senderKeyHash, senderTimestamp, senderKeyIndexes, recipientKeyHash, recipientTimestamp, recipientKeyIndexes);
    }

    public static int sizeOf(DeviceListMetadata object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var senderKeyHash = object.senderKeyHash();
        if (senderKeyHash != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getBytesSize(senderKeyHash);
        }
        var senderTimestamp = object.senderTimestamp();
        if (senderTimestamp != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(senderTimestamp);
        }
        var senderKeyIndexesRepeatedField = object.senderKeyIndexes();
        if (senderKeyIndexesRepeatedField != null) {
            for (var senderKeyIndexesEntry : senderKeyIndexesRepeatedField) { 
                if (senderKeyIndexesEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(3, 0);
                    protoSize += ProtobufOutputStream.getVarIntSize(senderKeyIndexesEntry);
                }
            }
        }
        var recipientKeyHash = object.recipientKeyHash();
        if (recipientKeyHash != null) {
            protoSize += ProtobufOutputStream.getFieldSize(8, 2);
            protoSize += ProtobufOutputStream.getBytesSize(recipientKeyHash);
        }
        var recipientTimestamp = object.recipientTimestamp();
        if (recipientTimestamp != null) {
            protoSize += ProtobufOutputStream.getFieldSize(9, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(recipientTimestamp);
        }
        var recipientKeyIndexesRepeatedField = object.recipientKeyIndexes();
        if (recipientKeyIndexesRepeatedField != null) {
            for (var recipientKeyIndexesEntry : recipientKeyIndexesRepeatedField) { 
                if (recipientKeyIndexesEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(10, 0);
                    protoSize += ProtobufOutputStream.getVarIntSize(recipientKeyIndexesEntry);
                }
            }
        }
        return protoSize;
    }

}
