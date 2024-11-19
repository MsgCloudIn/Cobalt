package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.CompanionProperties;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class CompanionPropertiesSpec {
    public static byte[] encode(CompanionProperties protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.os());
        outputStream.writeBytes(2, it.auties.whatsapp.model.signal.auth.VersionSpec.encode(protoInputObject.version()));
        outputStream.writeInt32(3, it.auties.whatsapp.model.signal.auth.CompanionPropertiesPlatformTypeSpec.encode(protoInputObject.platformType()));
        outputStream.writeBool(4, protoInputObject.requireFullSync());
        outputStream.writeBytes(5, it.auties.whatsapp.model.sync.HistorySyncConfigSpec.encode(protoInputObject.historySyncConfig()));
        return outputStream.toByteArray();
    }

    public static CompanionProperties decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static CompanionProperties decode(ProtobufInputStream protoInputStream) {
        java.lang.String os = null;
        it.auties.whatsapp.model.signal.auth.Version version = null;
        it.auties.whatsapp.model.signal.auth.CompanionProperties.PlatformType platformType = null;
        boolean requireFullSync = false;
        it.auties.whatsapp.model.sync.HistorySyncConfig historySyncConfig = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> os = protoInputStream.readString();
                case 2 -> version = it.auties.whatsapp.model.signal.auth.VersionSpec.decode(protoInputStream.lengthDelimitedStream());
                case 3 -> platformType = it.auties.whatsapp.model.signal.auth.CompanionPropertiesPlatformTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 4 -> requireFullSync = protoInputStream.readBool();
                case 5 -> historySyncConfig = it.auties.whatsapp.model.sync.HistorySyncConfigSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.auth.CompanionProperties(os, version, platformType, requireFullSync, historySyncConfig);
    }

    public static int sizeOf(CompanionProperties object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var os = object.os();
        if (os != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(os);
        }
        var version = object.version();
        if (version != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var versionSerializedSize = it.auties.whatsapp.model.signal.auth.VersionSpec.sizeOf(version);
            protoSize += ProtobufOutputStream.getVarIntSize(versionSerializedSize);
            protoSize += versionSerializedSize;
        }
        var platformType = object.platformType();
        if (platformType != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            var platformTypeSerializedSize = it.auties.whatsapp.model.signal.auth.CompanionPropertiesPlatformTypeSpec.sizeOf(platformType);
            protoSize += platformTypeSerializedSize;
        }
        var requireFullSync = object.requireFullSync();
        protoSize += ProtobufOutputStream.getFieldSize(4, 0);
        protoSize += 1;
        var historySyncConfig = object.historySyncConfig();
        if (historySyncConfig != null) {
            protoSize += ProtobufOutputStream.getFieldSize(5, 2);
            var historySyncConfigSerializedSize = it.auties.whatsapp.model.sync.HistorySyncConfigSpec.sizeOf(historySyncConfig);
            protoSize += ProtobufOutputStream.getVarIntSize(historySyncConfigSerializedSize);
            protoSize += historySyncConfigSerializedSize;
        }
        return protoSize;
    }

}
