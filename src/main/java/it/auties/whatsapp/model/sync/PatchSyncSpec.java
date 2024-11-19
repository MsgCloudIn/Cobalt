package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.PatchSync;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class PatchSyncSpec {
    public static byte[] encode(PatchSync protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.sync.VersionSyncSpec.encode(protoInputObject.version()));
        if (protoInputObject.mutations() != null) {
            for (var mutationsEntry : protoInputObject.mutations()) { 
                outputStream.writeBytes(2, it.auties.whatsapp.model.sync.MutationSyncSpec.encode(mutationsEntry));
            }
        }
        outputStream.writeBytes(3, it.auties.whatsapp.model.sync.ExternalBlobReferenceSpec.encode(protoInputObject.externalMutations()));
        outputStream.writeBytes(4, protoInputObject.snapshotMac());
        outputStream.writeBytes(5, protoInputObject.patchMac());
        outputStream.writeBytes(6, it.auties.whatsapp.model.sync.KeyIdSpec.encode(protoInputObject.keyId()));
        outputStream.writeBytes(7, it.auties.whatsapp.model.sync.ExitCodeSpec.encode(protoInputObject.exitCode()));
        outputStream.writeUInt32(8, protoInputObject.deviceIndex());
        return outputStream.toByteArray();
    }

    public static PatchSync decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static PatchSync decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.sync.VersionSync version = null;
        java.util.List<it.auties.whatsapp.model.sync.MutationSync> mutations = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        it.auties.whatsapp.model.sync.ExternalBlobReference externalMutations = null;
        byte[] snapshotMac = null;
        byte[] patchMac = null;
        it.auties.whatsapp.model.sync.KeyId keyId = null;
        it.auties.whatsapp.model.sync.ExitCode exitCode = null;
        java.lang.Integer deviceIndex = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> version = it.auties.whatsapp.model.sync.VersionSyncSpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> mutations.add(it.auties.whatsapp.model.sync.MutationSyncSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 3 -> externalMutations = it.auties.whatsapp.model.sync.ExternalBlobReferenceSpec.decode(protoInputStream.lengthDelimitedStream());
                case 4 -> snapshotMac = protoInputStream.readBytes();
                case 5 -> patchMac = protoInputStream.readBytes();
                case 6 -> keyId = it.auties.whatsapp.model.sync.KeyIdSpec.decode(protoInputStream.lengthDelimitedStream());
                case 7 -> exitCode = it.auties.whatsapp.model.sync.ExitCodeSpec.decode(protoInputStream.lengthDelimitedStream());
                case 8 -> deviceIndex = protoInputStream.readInt32();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.PatchSync(version, mutations, externalMutations, snapshotMac, patchMac, keyId, exitCode, deviceIndex);
    }

    public static int sizeOf(PatchSync object) {
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
        var mutationsRepeatedField = object.mutations();
        if (mutationsRepeatedField != null) {
            for (var mutationsEntry : mutationsRepeatedField) { 
                if (mutationsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                    var mutationsEntrySerializedSize = it.auties.whatsapp.model.sync.MutationSyncSpec.sizeOf(mutationsEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(mutationsEntrySerializedSize);
                    protoSize += mutationsEntrySerializedSize;
                }
            }
        }
        var externalMutations = object.externalMutations();
        if (externalMutations != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            var externalMutationsSerializedSize = it.auties.whatsapp.model.sync.ExternalBlobReferenceSpec.sizeOf(externalMutations);
            protoSize += ProtobufOutputStream.getVarIntSize(externalMutationsSerializedSize);
            protoSize += externalMutationsSerializedSize;
        }
        var snapshotMac = object.snapshotMac();
        if (snapshotMac != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            protoSize += ProtobufOutputStream.getBytesSize(snapshotMac);
        }
        var patchMac = object.patchMac();
        if (patchMac != null) {
            protoSize += ProtobufOutputStream.getFieldSize(5, 2);
            protoSize += ProtobufOutputStream.getBytesSize(patchMac);
        }
        var keyId = object.keyId();
        if (keyId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(6, 2);
            var keyIdSerializedSize = it.auties.whatsapp.model.sync.KeyIdSpec.sizeOf(keyId);
            protoSize += ProtobufOutputStream.getVarIntSize(keyIdSerializedSize);
            protoSize += keyIdSerializedSize;
        }
        var exitCode = object.exitCode();
        if (exitCode != null) {
            protoSize += ProtobufOutputStream.getFieldSize(7, 2);
            var exitCodeSerializedSize = it.auties.whatsapp.model.sync.ExitCodeSpec.sizeOf(exitCode);
            protoSize += ProtobufOutputStream.getVarIntSize(exitCodeSerializedSize);
            protoSize += exitCodeSerializedSize;
        }
        var deviceIndex = object.deviceIndex();
        if (deviceIndex != null) {
            protoSize += ProtobufOutputStream.getFieldSize(8, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(deviceIndex);
        }
        return protoSize;
    }

}
