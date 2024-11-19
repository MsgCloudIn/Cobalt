package it.auties.whatsapp.model.info;

import it.auties.whatsapp.model.info.BusinessIdentityInfo;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class BusinessIdentityInfoSpec {
    public static byte[] encode(BusinessIdentityInfo protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, it.auties.whatsapp.model.info.BusinessIdentityInfoVerifiedLevelSpec.encode(protoInputObject.level()));
        outputStream.writeBytes(2, it.auties.whatsapp.model.business.BusinessVerifiedNameCertificateSpec.encode(protoInputObject.certificate()));
        outputStream.writeBool(3, protoInputObject.signed());
        outputStream.writeBool(4, protoInputObject.revoked());
        outputStream.writeInt32(5, it.auties.whatsapp.model.info.BusinessIdentityInfoHostStorageTypeSpec.encode(protoInputObject.hostStorage()));
        outputStream.writeInt32(6, it.auties.whatsapp.model.info.BusinessIdentityInfoActorsTypeSpec.encode(protoInputObject.actualActors()));
        outputStream.writeUInt64(7, protoInputObject.privacyModeTimestampSeconds());
        outputStream.writeUInt64(8, protoInputObject.featureControls());
        return outputStream.toByteArray();
    }

    public static BusinessIdentityInfo decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static BusinessIdentityInfo decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.info.BusinessIdentityInfo.VerifiedLevel level = null;
        it.auties.whatsapp.model.business.BusinessVerifiedNameCertificate certificate = null;
        boolean signed = false;
        boolean revoked = false;
        it.auties.whatsapp.model.info.BusinessIdentityInfo.HostStorageType hostStorage = null;
        it.auties.whatsapp.model.info.BusinessIdentityInfo.ActorsType actualActors = null;
        long privacyModeTimestampSeconds = 0l;
        long featureControls = 0l;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> level = it.auties.whatsapp.model.info.BusinessIdentityInfoVerifiedLevelSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 2 -> certificate = it.auties.whatsapp.model.business.BusinessVerifiedNameCertificateSpec.decode(protoInputStream.lengthDelimitedStream());
                case 3 -> signed = protoInputStream.readBool();
                case 4 -> revoked = protoInputStream.readBool();
                case 5 -> hostStorage = it.auties.whatsapp.model.info.BusinessIdentityInfoHostStorageTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 6 -> actualActors = it.auties.whatsapp.model.info.BusinessIdentityInfoActorsTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 7 -> privacyModeTimestampSeconds = protoInputStream.readInt64();
                case 8 -> featureControls = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.info.BusinessIdentityInfo(level, certificate, signed, revoked, hostStorage, actualActors, privacyModeTimestampSeconds, featureControls);
    }

    public static int sizeOf(BusinessIdentityInfo object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var level = object.level();
        if (level != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var levelSerializedSize = it.auties.whatsapp.model.info.BusinessIdentityInfoVerifiedLevelSpec.sizeOf(level);
            protoSize += levelSerializedSize;
        }
        var certificate = object.certificate();
        if (certificate != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var certificateSerializedSize = it.auties.whatsapp.model.business.BusinessVerifiedNameCertificateSpec.sizeOf(certificate);
            protoSize += ProtobufOutputStream.getVarIntSize(certificateSerializedSize);
            protoSize += certificateSerializedSize;
        }
        var signed = object.signed();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += 1;
        var revoked = object.revoked();
        protoSize += ProtobufOutputStream.getFieldSize(4, 0);
        protoSize += 1;
        var hostStorage = object.hostStorage();
        if (hostStorage != null) {
            protoSize += ProtobufOutputStream.getFieldSize(5, 2);
            var hostStorageSerializedSize = it.auties.whatsapp.model.info.BusinessIdentityInfoHostStorageTypeSpec.sizeOf(hostStorage);
            protoSize += hostStorageSerializedSize;
        }
        var actualActors = object.actualActors();
        if (actualActors != null) {
            protoSize += ProtobufOutputStream.getFieldSize(6, 2);
            var actualActorsSerializedSize = it.auties.whatsapp.model.info.BusinessIdentityInfoActorsTypeSpec.sizeOf(actualActors);
            protoSize += actualActorsSerializedSize;
        }
        var privacyModeTimestampSeconds = object.privacyModeTimestampSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(7, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(privacyModeTimestampSeconds);
        var featureControls = object.featureControls();
        protoSize += ProtobufOutputStream.getFieldSize(8, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(featureControls);
        return protoSize;
    }

}
