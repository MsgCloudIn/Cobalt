package it.auties.whatsapp.model.companion;

import it.auties.whatsapp.model.companion.CompanionHashState;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class CompanionHashStateSpec {
    public static byte[] encode(CompanionHashState protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, it.auties.whatsapp.model.sync.PatchTypeSpec.encode(protoInputObject.type()));
        outputStream.writeInt64(2, protoInputObject.version());
        outputStream.writeBytes(3, protoInputObject.hash());
        if (protoInputObject.indexValueMap() != null) {
            for (var indexValueMapEntry : protoInputObject.indexValueMap().entrySet()) { 
                var indexValueMapOutputStream = new ProtobufOutputStream(sizeOfIndexValueMap(indexValueMapEntry));
                indexValueMapOutputStream.writeString(1, indexValueMapEntry.getKey());
                indexValueMapOutputStream.writeBytes(2, indexValueMapEntry.getValue());
                outputStream.writeBytes(4, indexValueMapOutputStream.toByteArray());
            }
        }
        return outputStream.toByteArray();
    }

    public static CompanionHashState decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static CompanionHashState decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.sync.PatchType type = null;
        long version = 0l;
        byte[] hash = null;
        java.util.Map<java.lang.String,byte[]> indexValueMap = it.auties.protobuf.builtin.ProtobufMapMixin.newMap();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> type = it.auties.whatsapp.model.sync.PatchTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 2 -> version = protoInputStream.readInt64();
                case 3 -> hash = protoInputStream.readBytes();
                case 4 -> {
                    var indexValueMapInputStream = protoInputStream.lengthDelimitedStream();
                    java.lang.String indexValueMapKey = null;
                    byte[] indexValueMapValue = null;
                    while (indexValueMapInputStream.readTag()) {
                        switch (indexValueMapInputStream.index()) {
                            case 1 -> indexValueMapKey = indexValueMapInputStream.readString();
                            case 2 -> indexValueMapValue = indexValueMapInputStream.readBytes();
                        }
                    }
                    indexValueMap.put(indexValueMapKey, indexValueMapValue);
                }
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.companion.CompanionHashState(type, version, hash, indexValueMap);
    }

    public static int sizeOf(CompanionHashState object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var type = object.type();
        if (type != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var typeSerializedSize = it.auties.whatsapp.model.sync.PatchTypeSpec.sizeOf(type);
            protoSize += typeSerializedSize;
        }
        var version = object.version();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(version);
        var hash = object.hash();
        if (hash != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getBytesSize(hash);
        }
        var indexValueMapMapField = object.indexValueMap();
        if (indexValueMapMapField != null) {
            for (var indexValueMapMapEntry : indexValueMapMapField.entrySet()) { 
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                var indexValueMapMapEntrySize = sizeOfIndexValueMap(indexValueMapMapEntry);
                protoSize += ProtobufOutputStream.getVarIntSize(indexValueMapMapEntrySize);
                protoSize += indexValueMapMapEntrySize;
            }
        }
        return protoSize;
    }

    private static int sizeOfIndexValueMap(java.util.Map.Entry<java.lang.String, byte[]> object) {
        var protoSize = 0;
        var objectMapKey = object.getKey();
        protoSize += ProtobufOutputStream.getFieldSize(1, 2);
        protoSize += ProtobufOutputStream.getStringSize(objectMapKey);
        var indexValueMapMapValue = object.getValue();
        if (indexValueMapMapValue != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(indexValueMapMapValue);
        }
        return protoSize;
    }

}
