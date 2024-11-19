package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.SnapshotSync;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SnapshotSyncSpec {
    public static byte[] encode(SnapshotSync protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.sync.VersionSyncSpec.encode(protoInputObject.version()));
        if (protoInputObject.records() != null) {
            for (var recordsEntry : protoInputObject.records()) { 
                outputStream.writeBytes(2, it.auties.whatsapp.model.sync.RecordSyncSpec.encode(recordsEntry));
            }
        }
        outputStream.writeBytes(3, protoInputObject.mac());
        outputStream.writeBytes(4, it.auties.whatsapp.model.sync.KeyIdSpec.encode(protoInputObject.keyId()));
        return outputStream.toByteArray();
    }

    public static SnapshotSync decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SnapshotSync decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.sync.VersionSync version = null;
        java.util.List<it.auties.whatsapp.model.sync.RecordSync> records = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        byte[] mac = null;
        it.auties.whatsapp.model.sync.KeyId keyId = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> version = it.auties.whatsapp.model.sync.VersionSyncSpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> records.add(it.auties.whatsapp.model.sync.RecordSyncSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 3 -> mac = protoInputStream.readBytes();
                case 4 -> keyId = it.auties.whatsapp.model.sync.KeyIdSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.SnapshotSync(version, records, mac, keyId);
    }

    public static int sizeOf(SnapshotSync object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var version = object.version();
        if (version != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var versionSerializedSize = it.auties.whatsapp.model.sync.VersionSyncSpec.sizeOf(version);
            protoSize += ProtobufOutputStream.getVarIntSize(versionSerializedSize);
            protoSize += versionSerializedSize;
        }
        var recordsRepeatedField = object.records();
        if (recordsRepeatedField != null) {
            for (var recordsEntry : recordsRepeatedField) { 
                if (recordsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                    var recordsEntrySerializedSize = it.auties.whatsapp.model.sync.RecordSyncSpec.sizeOf(recordsEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(recordsEntrySerializedSize);
                    protoSize += recordsEntrySerializedSize;
                }
            }
        }
        var mac = object.mac();
        if (mac != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getBytesSize(mac);
        }
        var keyId = object.keyId();
        if (keyId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            var keyIdSerializedSize = it.auties.whatsapp.model.sync.KeyIdSpec.sizeOf(keyId);
            protoSize += ProtobufOutputStream.getVarIntSize(keyIdSerializedSize);
            protoSize += keyIdSerializedSize;
        }
        return protoSize;
    }

}
