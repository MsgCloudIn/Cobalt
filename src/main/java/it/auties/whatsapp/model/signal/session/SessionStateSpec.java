package it.auties.whatsapp.model.signal.session;

import it.auties.whatsapp.model.signal.session.SessionState;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SessionStateSpec {
    public static byte[] encode(SessionState protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, protoInputObject.version());
        outputStream.writeInt32(2, protoInputObject.registrationId());
        outputStream.writeBytes(3, protoInputObject.baseKey());
        outputStream.writeBytes(4, protoInputObject.remoteIdentityKey());
        if (protoInputObject.chains() != null) {
            for (var chainsEntry : protoInputObject.chains().entrySet()) { 
                var chainsOutputStream = new ProtobufOutputStream(sizeOfChains(chainsEntry));
                chainsOutputStream.writeString(1, chainsEntry.getKey());
                chainsOutputStream.writeBytes(2, it.auties.whatsapp.model.signal.session.SessionChainSpec.encode(chainsEntry.getValue()));
                outputStream.writeBytes(5, chainsOutputStream.toByteArray());
            }
        }
        outputStream.writeBytes(6, protoInputObject.rootKey());
        outputStream.writeBytes(7, it.auties.whatsapp.model.signal.session.SessionPreKeySpec.encode(protoInputObject.pendingPreKey()));
        outputStream.writeBytes(8, it.auties.whatsapp.model.signal.keypair.SignalKeyPairSpec.encode(protoInputObject.ephemeralKeyPair()));
        outputStream.writeBytes(9, protoInputObject.lastRemoteEphemeralKey());
        outputStream.writeInt32(10, protoInputObject.previousCounter());
        outputStream.writeBool(11, protoInputObject.closed());
        return outputStream.toByteArray();
    }

    public static SessionState decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SessionState decode(ProtobufInputStream protoInputStream) {
        int version = 0;
        int registrationId = 0;
        byte[] baseKey = null;
        byte[] remoteIdentityKey = null;
        java.util.concurrent.ConcurrentHashMap<java.lang.String,it.auties.whatsapp.model.signal.session.SessionChain> chains = new java.util.concurrent.ConcurrentHashMap();
        byte[] rootKey = null;
        it.auties.whatsapp.model.signal.session.SessionPreKey pendingPreKey = null;
        it.auties.whatsapp.model.signal.keypair.SignalKeyPair ephemeralKeyPair = null;
        byte[] lastRemoteEphemeralKey = null;
        int previousCounter = 0;
        boolean closed = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> version = protoInputStream.readInt32();
                case 2 -> registrationId = protoInputStream.readInt32();
                case 3 -> baseKey = protoInputStream.readBytes();
                case 4 -> remoteIdentityKey = protoInputStream.readBytes();
                case 5 -> {
                    var chainsInputStream = protoInputStream.lengthDelimitedStream();
                    java.lang.String chainsKey = null;
                    it.auties.whatsapp.model.signal.session.SessionChain chainsValue = null;
                    while (chainsInputStream.readTag()) {
                        switch (chainsInputStream.index()) {
                            case 1 -> chainsKey = chainsInputStream.readString();
                            case 2 -> chainsValue = it.auties.whatsapp.model.signal.session.SessionChainSpec.decode(chainsInputStream.lengthDelimitedStream());
                        }
                    }
                    chains.put(chainsKey, chainsValue);
                }
                case 6 -> rootKey = protoInputStream.readBytes();
                case 7 -> pendingPreKey = it.auties.whatsapp.model.signal.session.SessionPreKeySpec.decode(protoInputStream.lengthDelimitedStream());
                case 8 -> ephemeralKeyPair = it.auties.whatsapp.model.signal.keypair.SignalKeyPairSpec.decode(protoInputStream.lengthDelimitedStream());
                case 9 -> lastRemoteEphemeralKey = protoInputStream.readBytes();
                case 10 -> previousCounter = protoInputStream.readInt32();
                case 11 -> closed = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.session.SessionState(version, registrationId, baseKey, remoteIdentityKey, chains, rootKey, pendingPreKey, ephemeralKeyPair, lastRemoteEphemeralKey, previousCounter, closed);
    }

    public static int sizeOf(SessionState object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var version = object.version();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(version);
        var registrationId = object.registrationId();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(registrationId);
        var baseKey = object.baseKey();
        if (baseKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getBytesSize(baseKey);
        }
        var remoteIdentityKey = object.remoteIdentityKey();
        if (remoteIdentityKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            protoSize += ProtobufOutputStream.getBytesSize(remoteIdentityKey);
        }
        var chainsMapField = object.chains();
        if (chainsMapField != null) {
            for (var chainsMapEntry : chainsMapField.entrySet()) { 
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                var chainsMapEntrySize = sizeOfChains(chainsMapEntry);
                protoSize += ProtobufOutputStream.getVarIntSize(chainsMapEntrySize);
                protoSize += chainsMapEntrySize;
            }
        }
        var rootKey = object.rootKey();
        if (rootKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(6, 2);
            protoSize += ProtobufOutputStream.getBytesSize(rootKey);
        }
        var pendingPreKey = object.pendingPreKey();
        if (pendingPreKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(7, 2);
            var pendingPreKeySerializedSize = it.auties.whatsapp.model.signal.session.SessionPreKeySpec.sizeOf(pendingPreKey);
            protoSize += ProtobufOutputStream.getVarIntSize(pendingPreKeySerializedSize);
            protoSize += pendingPreKeySerializedSize;
        }
        var ephemeralKeyPair = object.ephemeralKeyPair();
        if (ephemeralKeyPair != null) {
            protoSize += ProtobufOutputStream.getFieldSize(8, 2);
            var ephemeralKeyPairSerializedSize = it.auties.whatsapp.model.signal.keypair.SignalKeyPairSpec.sizeOf(ephemeralKeyPair);
            protoSize += ProtobufOutputStream.getVarIntSize(ephemeralKeyPairSerializedSize);
            protoSize += ephemeralKeyPairSerializedSize;
        }
        var lastRemoteEphemeralKey = object.lastRemoteEphemeralKey();
        if (lastRemoteEphemeralKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(9, 2);
            protoSize += ProtobufOutputStream.getBytesSize(lastRemoteEphemeralKey);
        }
        var previousCounter = object.previousCounter();
        protoSize += ProtobufOutputStream.getFieldSize(10, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(previousCounter);
        var closed = object.closed();
        protoSize += ProtobufOutputStream.getFieldSize(11, 0);
        protoSize += 1;
        return protoSize;
    }

    private static int sizeOfChains(java.util.Map.Entry<java.lang.String, it.auties.whatsapp.model.signal.session.SessionChain> object) {
        var protoSize = 0;
        var objectMapKey = object.getKey();
        protoSize += ProtobufOutputStream.getFieldSize(1, 2);
        protoSize += ProtobufOutputStream.getStringSize(objectMapKey);
        var chainsMapValue = object.getValue();
        if (chainsMapValue != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var chainsMapValueSerializedSize = it.auties.whatsapp.model.signal.session.SessionChainSpec.sizeOf(chainsMapValue);
            protoSize += ProtobufOutputStream.getVarIntSize(chainsMapValueSerializedSize);
            protoSize += chainsMapValueSerializedSize;
        }
        return protoSize;
    }

}
