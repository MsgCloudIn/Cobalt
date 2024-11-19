package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.AppStateSyncKeyFingerprint;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class AppStateSyncKeyFingerprintSpec {
    public static byte[] encode(AppStateSyncKeyFingerprint protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeUInt32(1, protoInputObject.rawId());
        outputStream.writeUInt32(2, protoInputObject.currentIndex());
        if (protoInputObject.deviceIndexes() != null) {
            for (var deviceIndexesEntry : protoInputObject.deviceIndexes()) { 
                outputStream.writeUInt32(3, deviceIndexesEntry);
            }
        }
        return outputStream.toByteArray();
    }

    public static AppStateSyncKeyFingerprint decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static AppStateSyncKeyFingerprint decode(ProtobufInputStream protoInputStream) {
        java.lang.Integer rawId = null;
        java.lang.Integer currentIndex = null;
        java.util.List<java.lang.Integer> deviceIndexes = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> rawId = protoInputStream.readInt32();
                case 2 -> currentIndex = protoInputStream.readInt32();
                case 3 -> deviceIndexes.addAll(protoInputStream.readInt32Packed());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.AppStateSyncKeyFingerprint(rawId, currentIndex, deviceIndexes);
    }

    public static int sizeOf(AppStateSyncKeyFingerprint object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var rawId = object.rawId();
        if (rawId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(rawId);
        }
        var currentIndex = object.currentIndex();
        if (currentIndex != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(currentIndex);
        }
        var deviceIndexesRepeatedField = object.deviceIndexes();
        if (deviceIndexesRepeatedField != null) {
            for (var deviceIndexesEntry : deviceIndexesRepeatedField) { 
                if (deviceIndexesEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(3, 0);
                    protoSize += ProtobufOutputStream.getVarIntSize(deviceIndexesEntry);
                }
            }
        }
        return protoSize;
    }

}
