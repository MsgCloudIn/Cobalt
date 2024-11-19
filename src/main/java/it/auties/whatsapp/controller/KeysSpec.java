package it.auties.whatsapp.controller;

import it.auties.whatsapp.controller.Keys;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class KeysSpec {
    public static byte[] encode(Keys protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var uuid = protoInputObject.uuid;
        if (uuid != null) {
            var uuid0 = it.auties.protobuf.builtin.ProtobufUUIDMixin.toValue(uuid);
            if (uuid0 != null) {
                outputStream.writeString(1, uuid0);
            }
        }
        var phoneNumber = protoInputObject.phoneNumber();
        if (phoneNumber != null) {
            var phoneNumber0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(phoneNumber);
            if (phoneNumber0 != null) {
                var phoneNumber1 = phoneNumber0.number();
                outputStream.writeUInt64(2, phoneNumber1);
            }
        }
        outputStream.writeInt32(3, it.auties.whatsapp.api.ClientTypeSpec.encode(protoInputObject.clientType));
        if (protoInputObject.alias != null) {
            for (var aliasEntry : protoInputObject.alias) { 
                outputStream.writeString(4, aliasEntry);
            }
        }
        outputStream.writeInt32(5, protoInputObject.registrationId);
        outputStream.writeBytes(6, it.auties.whatsapp.model.signal.keypair.SignalKeyPairSpec.encode(protoInputObject.noiseKeyPair));
        outputStream.writeBytes(7, it.auties.whatsapp.model.signal.keypair.SignalKeyPairSpec.encode(protoInputObject.ephemeralKeyPair));
        outputStream.writeBytes(8, it.auties.whatsapp.model.signal.keypair.SignalKeyPairSpec.encode(protoInputObject.identityKeyPair));
        outputStream.writeBytes(9, it.auties.whatsapp.model.signal.keypair.SignalKeyPairSpec.encode(protoInputObject.companionKeyPair));
        outputStream.writeBytes(10, it.auties.whatsapp.model.signal.keypair.SignalSignedKeyPairSpec.encode(protoInputObject.signedKeyPair));
        outputStream.writeBytes(11, protoInputObject.signedKeyIndex);
        outputStream.writeUInt64(12, protoInputObject.signedKeyIndexTimestamp);
        if (protoInputObject.preKeys != null) {
            for (var preKeysEntry : protoInputObject.preKeys) { 
                outputStream.writeBytes(13, it.auties.whatsapp.model.signal.keypair.SignalPreKeyPairSpec.encode(preKeysEntry));
            }
        }
        outputStream.writeString(14, protoInputObject.fdid);
        outputStream.writeBytes(15, protoInputObject.deviceId);
        var advertisingId = protoInputObject.advertisingId;
        if (advertisingId != null) {
            var advertisingId0 = it.auties.protobuf.builtin.ProtobufUUIDMixin.toValue(advertisingId);
            if (advertisingId0 != null) {
                outputStream.writeString(26, advertisingId0);
            }
        }
        outputStream.writeBytes(16, protoInputObject.identityId);
        outputStream.writeBytes(27, protoInputObject.backupToken);
        outputStream.writeBytes(17, it.auties.whatsapp.model.signal.auth.SignedDeviceIdentitySpec.encode(protoInputObject.companionIdentity));
        if (protoInputObject.senderKeys != null) {
            for (var senderKeysEntry : protoInputObject.senderKeys.entrySet()) { 
                var senderKeysOutputStream = new ProtobufOutputStream(sizeOfSenderKeys(senderKeysEntry));
                var senderKeys = senderKeysEntry.getKey();
                if (senderKeys != null) {
                    var senderKeys0 = senderKeys.toString();
                    if (senderKeys0 != null) {
                        senderKeysOutputStream.writeString(1, senderKeys0);
                    }
                }
                senderKeysOutputStream.writeBytes(2, it.auties.whatsapp.model.signal.sender.SenderKeyRecordSpec.encode(senderKeysEntry.getValue()));
                outputStream.writeBytes(18, senderKeysOutputStream.toByteArray());
            }
        }
        if (protoInputObject.appStateKeys != null) {
            for (var appStateKeysEntry : protoInputObject.appStateKeys) { 
                outputStream.writeBytes(19, it.auties.whatsapp.model.companion.CompanionSyncKeySpec.encode(appStateKeysEntry));
            }
        }
        if (protoInputObject.sessions != null) {
            for (var sessionsEntry : protoInputObject.sessions.entrySet()) { 
                var sessionsOutputStream = new ProtobufOutputStream(sizeOfSessions(sessionsEntry));
                var sessions = sessionsEntry.getKey();
                if (sessions != null) {
                    var sessions0 = sessions.toString();
                    if (sessions0 != null) {
                        sessionsOutputStream.writeString(1, sessions0);
                    }
                }
                sessionsOutputStream.writeBytes(2, it.auties.whatsapp.model.signal.session.SessionSpec.encode(sessionsEntry.getValue()));
                outputStream.writeBytes(20, sessionsOutputStream.toByteArray());
            }
        }
        if (protoInputObject.hashStates != null) {
            for (var hashStatesEntry : protoInputObject.hashStates.entrySet()) { 
                var hashStatesOutputStream = new ProtobufOutputStream(sizeOfHashStates(hashStatesEntry));
                hashStatesOutputStream.writeString(1, hashStatesEntry.getKey());
                hashStatesOutputStream.writeBytes(2, it.auties.whatsapp.model.companion.CompanionHashStateSpec.encode(hashStatesEntry.getValue()));
                outputStream.writeBytes(21, hashStatesOutputStream.toByteArray());
            }
        }
        if (protoInputObject.groupsPreKeys != null) {
            for (var groupsPreKeysEntry : protoInputObject.groupsPreKeys.entrySet()) { 
                var groupsPreKeysOutputStream = new ProtobufOutputStream(sizeOfGroupsPreKeys(groupsPreKeysEntry));
                var groupsPreKeys = groupsPreKeysEntry.getKey();
                if (groupsPreKeys != null) {
                    var groupsPreKeys0 = groupsPreKeys.toString();
                    if (groupsPreKeys0 != null) {
                        groupsPreKeysOutputStream.writeString(1, groupsPreKeys0);
                    }
                }
                groupsPreKeysOutputStream.writeBytes(2, it.auties.whatsapp.model.signal.sender.SenderPreKeysSpec.encode(groupsPreKeysEntry.getValue()));
                outputStream.writeBytes(22, groupsPreKeysOutputStream.toByteArray());
            }
        }
        outputStream.writeBool(23, protoInputObject.registered);
        outputStream.writeBool(24, protoInputObject.businessCertificate);
        outputStream.writeBool(25, protoInputObject.initialAppSync);
        return outputStream.toByteArray();
    }

    public static Keys decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static Keys decode(ProtobufInputStream protoInputStream) {
        java.util.UUID uuid = null;
        it.auties.whatsapp.model.mobile.PhoneNumber phoneNumber = null;
        it.auties.whatsapp.api.ClientType clientType = null;
        java.util.Collection<java.lang.String> alias = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newCollection();
        java.lang.Integer registrationId = null;
        it.auties.whatsapp.model.signal.keypair.SignalKeyPair noiseKeyPair = null;
        it.auties.whatsapp.model.signal.keypair.SignalKeyPair ephemeralKeyPair = null;
        it.auties.whatsapp.model.signal.keypair.SignalKeyPair identityKeyPair = null;
        it.auties.whatsapp.model.signal.keypair.SignalKeyPair companionKeyPair = null;
        it.auties.whatsapp.model.signal.keypair.SignalSignedKeyPair signedKeyPair = null;
        byte[] signedKeyIndex = null;
        java.lang.Long signedKeyIndexTimestamp = null;
        java.util.List<it.auties.whatsapp.model.signal.keypair.SignalPreKeyPair> preKeys = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        java.lang.String fdid = null;
        byte[] deviceId = null;
        java.util.UUID advertisingId = null;
        byte[] identityId = null;
        byte[] backupToken = null;
        it.auties.whatsapp.model.signal.auth.SignedDeviceIdentity companionIdentity = null;
        java.util.Map<it.auties.whatsapp.model.signal.sender.SenderKeyName,it.auties.whatsapp.model.signal.sender.SenderKeyRecord> senderKeys = it.auties.protobuf.builtin.ProtobufMapMixin.newMap();
        java.util.List<it.auties.whatsapp.model.companion.CompanionSyncKey> appStateKeys = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        java.util.concurrent.ConcurrentMap<it.auties.whatsapp.model.signal.session.SessionAddress,it.auties.whatsapp.model.signal.session.Session> sessions = it.auties.protobuf.builtin.ProtobufMapMixin.newConcurrentMap();
        java.util.concurrent.ConcurrentMap<java.lang.String,it.auties.whatsapp.model.companion.CompanionHashState> hashStates = it.auties.protobuf.builtin.ProtobufMapMixin.newConcurrentMap();
        java.util.concurrent.ConcurrentMap<it.auties.whatsapp.model.jid.Jid,it.auties.whatsapp.model.signal.sender.SenderPreKeys> groupsPreKeys = it.auties.protobuf.builtin.ProtobufMapMixin.newConcurrentMap();
        boolean registered = false;
        boolean businessCertificate = false;
        boolean initialAppSync = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> uuid = it.auties.protobuf.builtin.ProtobufUUIDMixin.ofNullable(protoInputStream.readString());
                case 2 -> phoneNumber = it.auties.whatsapp.model.mobile.PhoneNumber.of(protoInputStream.readInt64());
                case 3 -> clientType = it.auties.whatsapp.api.ClientTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 4 -> alias.add(protoInputStream.readString());
                case 5 -> registrationId = protoInputStream.readInt32();
                case 6 -> noiseKeyPair = it.auties.whatsapp.model.signal.keypair.SignalKeyPairSpec.decode(protoInputStream.lengthDelimitedStream());
                case 7 -> ephemeralKeyPair = it.auties.whatsapp.model.signal.keypair.SignalKeyPairSpec.decode(protoInputStream.lengthDelimitedStream());
                case 8 -> identityKeyPair = it.auties.whatsapp.model.signal.keypair.SignalKeyPairSpec.decode(protoInputStream.lengthDelimitedStream());
                case 9 -> companionKeyPair = it.auties.whatsapp.model.signal.keypair.SignalKeyPairSpec.decode(protoInputStream.lengthDelimitedStream());
                case 10 -> signedKeyPair = it.auties.whatsapp.model.signal.keypair.SignalSignedKeyPairSpec.decode(protoInputStream.lengthDelimitedStream());
                case 11 -> signedKeyIndex = protoInputStream.readBytes();
                case 12 -> signedKeyIndexTimestamp = protoInputStream.readInt64();
                case 13 -> preKeys.add(it.auties.whatsapp.model.signal.keypair.SignalPreKeyPairSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 14 -> fdid = protoInputStream.readString();
                case 15 -> deviceId = protoInputStream.readBytes();
                case 26 -> advertisingId = it.auties.protobuf.builtin.ProtobufUUIDMixin.ofNullable(protoInputStream.readString());
                case 16 -> identityId = protoInputStream.readBytes();
                case 27 -> backupToken = protoInputStream.readBytes();
                case 17 -> companionIdentity = it.auties.whatsapp.model.signal.auth.SignedDeviceIdentitySpec.decode(protoInputStream.lengthDelimitedStream());
                case 18 -> {
                    var senderKeysInputStream = protoInputStream.lengthDelimitedStream();
                    it.auties.whatsapp.model.signal.sender.SenderKeyName senderKeysKey = null;
                    it.auties.whatsapp.model.signal.sender.SenderKeyRecord senderKeysValue = null;
                    while (senderKeysInputStream.readTag()) {
                        switch (senderKeysInputStream.index()) {
                            case 1 -> senderKeysKey = it.auties.whatsapp.model.signal.sender.SenderKeyName.of(senderKeysInputStream.readString());
                            case 2 -> senderKeysValue = it.auties.whatsapp.model.signal.sender.SenderKeyRecordSpec.decode(senderKeysInputStream.lengthDelimitedStream());
                        }
                    }
                    senderKeys.put(senderKeysKey, senderKeysValue);
                }
                case 19 -> appStateKeys.add(it.auties.whatsapp.model.companion.CompanionSyncKeySpec.decode(protoInputStream.lengthDelimitedStream()));
                case 20 -> {
                    var sessionsInputStream = protoInputStream.lengthDelimitedStream();
                    it.auties.whatsapp.model.signal.session.SessionAddress sessionsKey = null;
                    it.auties.whatsapp.model.signal.session.Session sessionsValue = null;
                    while (sessionsInputStream.readTag()) {
                        switch (sessionsInputStream.index()) {
                            case 1 -> sessionsKey = it.auties.whatsapp.model.signal.session.SessionAddress.of(sessionsInputStream.readString());
                            case 2 -> sessionsValue = it.auties.whatsapp.model.signal.session.SessionSpec.decode(sessionsInputStream.lengthDelimitedStream());
                        }
                    }
                    sessions.put(sessionsKey, sessionsValue);
                }
                case 21 -> {
                    var hashStatesInputStream = protoInputStream.lengthDelimitedStream();
                    java.lang.String hashStatesKey = null;
                    it.auties.whatsapp.model.companion.CompanionHashState hashStatesValue = null;
                    while (hashStatesInputStream.readTag()) {
                        switch (hashStatesInputStream.index()) {
                            case 1 -> hashStatesKey = hashStatesInputStream.readString();
                            case 2 -> hashStatesValue = it.auties.whatsapp.model.companion.CompanionHashStateSpec.decode(hashStatesInputStream.lengthDelimitedStream());
                        }
                    }
                    hashStates.put(hashStatesKey, hashStatesValue);
                }
                case 22 -> {
                    var groupsPreKeysInputStream = protoInputStream.lengthDelimitedStream();
                    it.auties.whatsapp.model.jid.Jid groupsPreKeysKey = null;
                    it.auties.whatsapp.model.signal.sender.SenderPreKeys groupsPreKeysValue = null;
                    while (groupsPreKeysInputStream.readTag()) {
                        switch (groupsPreKeysInputStream.index()) {
                            case 1 -> groupsPreKeysKey = it.auties.whatsapp.model.jid.Jid.ofProtobuf(groupsPreKeysInputStream.readString());
                            case 2 -> groupsPreKeysValue = it.auties.whatsapp.model.signal.sender.SenderPreKeysSpec.decode(groupsPreKeysInputStream.lengthDelimitedStream());
                        }
                    }
                    groupsPreKeys.put(groupsPreKeysKey, groupsPreKeysValue);
                }
                case 23 -> registered = protoInputStream.readBool();
                case 24 -> businessCertificate = protoInputStream.readBool();
                case 25 -> initialAppSync = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.controller.Keys(uuid, phoneNumber, clientType, alias, registrationId, noiseKeyPair, ephemeralKeyPair, identityKeyPair, companionKeyPair, signedKeyPair, signedKeyIndex, signedKeyIndexTimestamp, preKeys, fdid, deviceId, advertisingId, identityId, backupToken, companionIdentity, senderKeys, appStateKeys, sessions, hashStates, groupsPreKeys, registered, businessCertificate, initialAppSync);
    }

    public static int sizeOf(Keys object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var uuid = object.uuid;
        if (uuid != null) {
            var uuid0 = it.auties.protobuf.builtin.ProtobufUUIDMixin.toValue(uuid);
            if (uuid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(uuid0);
            }
        }
        var phoneNumber = object.phoneNumber();
        if (phoneNumber != null) {
            var phoneNumber0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(phoneNumber);
            if (phoneNumber0 != null) {
                var phoneNumber1 = phoneNumber0.number();
                protoSize += ProtobufOutputStream.getFieldSize(2, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(phoneNumber1);
            }
        }
        var clientType = object.clientType;
        if (clientType != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            var clientTypeSerializedSize = it.auties.whatsapp.api.ClientTypeSpec.sizeOf(clientType);
            protoSize += clientTypeSerializedSize;
        }
        var aliasRepeatedField = object.alias;
        if (aliasRepeatedField != null) {
            for (var aliasEntry : aliasRepeatedField) { 
                if (aliasEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                    protoSize += ProtobufOutputStream.getStringSize(aliasEntry);
                }
            }
        }
        var registrationId = object.registrationId;
        if (registrationId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(5, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(registrationId);
        }
        var noiseKeyPair = object.noiseKeyPair;
        if (noiseKeyPair != null) {
            protoSize += ProtobufOutputStream.getFieldSize(6, 2);
            var noiseKeyPairSerializedSize = it.auties.whatsapp.model.signal.keypair.SignalKeyPairSpec.sizeOf(noiseKeyPair);
            protoSize += ProtobufOutputStream.getVarIntSize(noiseKeyPairSerializedSize);
            protoSize += noiseKeyPairSerializedSize;
        }
        var ephemeralKeyPair = object.ephemeralKeyPair;
        if (ephemeralKeyPair != null) {
            protoSize += ProtobufOutputStream.getFieldSize(7, 2);
            var ephemeralKeyPairSerializedSize = it.auties.whatsapp.model.signal.keypair.SignalKeyPairSpec.sizeOf(ephemeralKeyPair);
            protoSize += ProtobufOutputStream.getVarIntSize(ephemeralKeyPairSerializedSize);
            protoSize += ephemeralKeyPairSerializedSize;
        }
        var identityKeyPair = object.identityKeyPair;
        if (identityKeyPair != null) {
            protoSize += ProtobufOutputStream.getFieldSize(8, 2);
            var identityKeyPairSerializedSize = it.auties.whatsapp.model.signal.keypair.SignalKeyPairSpec.sizeOf(identityKeyPair);
            protoSize += ProtobufOutputStream.getVarIntSize(identityKeyPairSerializedSize);
            protoSize += identityKeyPairSerializedSize;
        }
        var companionKeyPair = object.companionKeyPair;
        if (companionKeyPair != null) {
            protoSize += ProtobufOutputStream.getFieldSize(9, 2);
            var companionKeyPairSerializedSize = it.auties.whatsapp.model.signal.keypair.SignalKeyPairSpec.sizeOf(companionKeyPair);
            protoSize += ProtobufOutputStream.getVarIntSize(companionKeyPairSerializedSize);
            protoSize += companionKeyPairSerializedSize;
        }
        var signedKeyPair = object.signedKeyPair;
        if (signedKeyPair != null) {
            protoSize += ProtobufOutputStream.getFieldSize(10, 2);
            var signedKeyPairSerializedSize = it.auties.whatsapp.model.signal.keypair.SignalSignedKeyPairSpec.sizeOf(signedKeyPair);
            protoSize += ProtobufOutputStream.getVarIntSize(signedKeyPairSerializedSize);
            protoSize += signedKeyPairSerializedSize;
        }
        var signedKeyIndex = object.signedKeyIndex;
        if (signedKeyIndex != null) {
            protoSize += ProtobufOutputStream.getFieldSize(11, 2);
            protoSize += ProtobufOutputStream.getBytesSize(signedKeyIndex);
        }
        var signedKeyIndexTimestamp = object.signedKeyIndexTimestamp;
        if (signedKeyIndexTimestamp != null) {
            protoSize += ProtobufOutputStream.getFieldSize(12, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(signedKeyIndexTimestamp);
        }
        var preKeysRepeatedField = object.preKeys;
        if (preKeysRepeatedField != null) {
            for (var preKeysEntry : preKeysRepeatedField) { 
                if (preKeysEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(13, 2);
                    var preKeysEntrySerializedSize = it.auties.whatsapp.model.signal.keypair.SignalPreKeyPairSpec.sizeOf(preKeysEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(preKeysEntrySerializedSize);
                    protoSize += preKeysEntrySerializedSize;
                }
            }
        }
        var fdid = object.fdid;
        if (fdid != null) {
            protoSize += ProtobufOutputStream.getFieldSize(14, 2);
            protoSize += ProtobufOutputStream.getStringSize(fdid);
        }
        var deviceId = object.deviceId;
        if (deviceId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(15, 2);
            protoSize += ProtobufOutputStream.getBytesSize(deviceId);
        }
        var advertisingId = object.advertisingId;
        if (advertisingId != null) {
            var advertisingId0 = it.auties.protobuf.builtin.ProtobufUUIDMixin.toValue(advertisingId);
            if (advertisingId0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(26, 2);
                protoSize += ProtobufOutputStream.getStringSize(advertisingId0);
            }
        }
        var identityId = object.identityId;
        if (identityId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(16, 2);
            protoSize += ProtobufOutputStream.getBytesSize(identityId);
        }
        var backupToken = object.backupToken;
        if (backupToken != null) {
            protoSize += ProtobufOutputStream.getFieldSize(27, 2);
            protoSize += ProtobufOutputStream.getBytesSize(backupToken);
        }
        var companionIdentity = object.companionIdentity;
        if (companionIdentity != null) {
            protoSize += ProtobufOutputStream.getFieldSize(17, 2);
            var companionIdentitySerializedSize = it.auties.whatsapp.model.signal.auth.SignedDeviceIdentitySpec.sizeOf(companionIdentity);
            protoSize += ProtobufOutputStream.getVarIntSize(companionIdentitySerializedSize);
            protoSize += companionIdentitySerializedSize;
        }
        var senderKeysMapField = object.senderKeys;
        if (senderKeysMapField != null) {
            for (var senderKeysMapEntry : senderKeysMapField.entrySet()) { 
                protoSize += ProtobufOutputStream.getFieldSize(18, 2);
                var senderKeysMapEntrySize = sizeOfSenderKeys(senderKeysMapEntry);
                protoSize += ProtobufOutputStream.getVarIntSize(senderKeysMapEntrySize);
                protoSize += senderKeysMapEntrySize;
            }
        }
        var appStateKeysRepeatedField = object.appStateKeys;
        if (appStateKeysRepeatedField != null) {
            for (var appStateKeysEntry : appStateKeysRepeatedField) { 
                if (appStateKeysEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(19, 2);
                    var appStateKeysEntrySerializedSize = it.auties.whatsapp.model.companion.CompanionSyncKeySpec.sizeOf(appStateKeysEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(appStateKeysEntrySerializedSize);
                    protoSize += appStateKeysEntrySerializedSize;
                }
            }
        }
        var sessionsMapField = object.sessions;
        if (sessionsMapField != null) {
            for (var sessionsMapEntry : sessionsMapField.entrySet()) { 
                protoSize += ProtobufOutputStream.getFieldSize(20, 2);
                var sessionsMapEntrySize = sizeOfSessions(sessionsMapEntry);
                protoSize += ProtobufOutputStream.getVarIntSize(sessionsMapEntrySize);
                protoSize += sessionsMapEntrySize;
            }
        }
        var hashStatesMapField = object.hashStates;
        if (hashStatesMapField != null) {
            for (var hashStatesMapEntry : hashStatesMapField.entrySet()) { 
                protoSize += ProtobufOutputStream.getFieldSize(21, 2);
                var hashStatesMapEntrySize = sizeOfHashStates(hashStatesMapEntry);
                protoSize += ProtobufOutputStream.getVarIntSize(hashStatesMapEntrySize);
                protoSize += hashStatesMapEntrySize;
            }
        }
        var groupsPreKeysMapField = object.groupsPreKeys;
        if (groupsPreKeysMapField != null) {
            for (var groupsPreKeysMapEntry : groupsPreKeysMapField.entrySet()) { 
                protoSize += ProtobufOutputStream.getFieldSize(22, 2);
                var groupsPreKeysMapEntrySize = sizeOfGroupsPreKeys(groupsPreKeysMapEntry);
                protoSize += ProtobufOutputStream.getVarIntSize(groupsPreKeysMapEntrySize);
                protoSize += groupsPreKeysMapEntrySize;
            }
        }
        var registered = object.registered;
        protoSize += ProtobufOutputStream.getFieldSize(23, 0);
        protoSize += 1;
        var businessCertificate = object.businessCertificate;
        protoSize += ProtobufOutputStream.getFieldSize(24, 0);
        protoSize += 1;
        var initialAppSync = object.initialAppSync;
        protoSize += ProtobufOutputStream.getFieldSize(25, 0);
        protoSize += 1;
        return protoSize;
    }

    private static int sizeOfSenderKeys(java.util.Map.Entry<it.auties.whatsapp.model.signal.sender.SenderKeyName, it.auties.whatsapp.model.signal.sender.SenderKeyRecord> object) {
        var protoSize = 0;
        var objectMapKey = object.getKey();
        var objectMapKey0 = objectMapKey.toString();
        if (objectMapKey0 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(objectMapKey0);
        }
        var senderKeysMapValue = object.getValue();
        if (senderKeysMapValue != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var senderKeysMapValueSerializedSize = it.auties.whatsapp.model.signal.sender.SenderKeyRecordSpec.sizeOf(senderKeysMapValue);
            protoSize += ProtobufOutputStream.getVarIntSize(senderKeysMapValueSerializedSize);
            protoSize += senderKeysMapValueSerializedSize;
        }
        return protoSize;
    }

    private static int sizeOfSessions(java.util.Map.Entry<it.auties.whatsapp.model.signal.session.SessionAddress, it.auties.whatsapp.model.signal.session.Session> object) {
        var protoSize = 0;
        var objectMapKey = object.getKey();
        var objectMapKey0 = objectMapKey.toString();
        if (objectMapKey0 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(objectMapKey0);
        }
        var sessionsMapValue = object.getValue();
        if (sessionsMapValue != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var sessionsMapValueSerializedSize = it.auties.whatsapp.model.signal.session.SessionSpec.sizeOf(sessionsMapValue);
            protoSize += ProtobufOutputStream.getVarIntSize(sessionsMapValueSerializedSize);
            protoSize += sessionsMapValueSerializedSize;
        }
        return protoSize;
    }

    private static int sizeOfHashStates(java.util.Map.Entry<java.lang.String, it.auties.whatsapp.model.companion.CompanionHashState> object) {
        var protoSize = 0;
        var objectMapKey = object.getKey();
        protoSize += ProtobufOutputStream.getFieldSize(1, 2);
        protoSize += ProtobufOutputStream.getStringSize(objectMapKey);
        var hashStatesMapValue = object.getValue();
        if (hashStatesMapValue != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var hashStatesMapValueSerializedSize = it.auties.whatsapp.model.companion.CompanionHashStateSpec.sizeOf(hashStatesMapValue);
            protoSize += ProtobufOutputStream.getVarIntSize(hashStatesMapValueSerializedSize);
            protoSize += hashStatesMapValueSerializedSize;
        }
        return protoSize;
    }

    private static int sizeOfGroupsPreKeys(java.util.Map.Entry<it.auties.whatsapp.model.jid.Jid, it.auties.whatsapp.model.signal.sender.SenderPreKeys> object) {
        var protoSize = 0;
        var objectMapKey = object.getKey();
        var objectMapKey0 = objectMapKey.toString();
        if (objectMapKey0 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(objectMapKey0);
        }
        var groupsPreKeysMapValue = object.getValue();
        if (groupsPreKeysMapValue != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var groupsPreKeysMapValueSerializedSize = it.auties.whatsapp.model.signal.sender.SenderPreKeysSpec.sizeOf(groupsPreKeysMapValue);
            protoSize += ProtobufOutputStream.getVarIntSize(groupsPreKeysMapValueSerializedSize);
            protoSize += groupsPreKeysMapValueSerializedSize;
        }
        return protoSize;
    }

}
