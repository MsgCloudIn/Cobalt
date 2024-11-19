package it.auties.whatsapp.model.companion;

import it.auties.whatsapp.model.companion.CompanionDevice;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class CompanionDeviceSpec {
    public static byte[] encode(CompanionDevice protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.model());
        outputStream.writeString(2, protoInputObject.manufacturer());
        outputStream.writeInt32(3, it.auties.whatsapp.model.signal.auth.UserAgentPlatformTypeSpec.encode(protoInputObject.platform()));
        var appVersion = protoInputObject.appVersion();
        if (appVersion != null) {
            var appVersion0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(appVersion);
            if (appVersion0 != null) {
                outputStream.writeBytes(4, it.auties.whatsapp.model.signal.auth.VersionSpec.encode(appVersion0));
            }
        }
        outputStream.writeBytes(5, it.auties.whatsapp.model.signal.auth.VersionSpec.encode(protoInputObject.osVersion()));
        outputStream.writeString(6, protoInputObject.osBuildNumber());
        outputStream.writeString(8, protoInputObject.modelId());
        outputStream.writeInt32(9, it.auties.whatsapp.api.ClientTypeSpec.encode(protoInputObject.clientType()));
        return outputStream.toByteArray();
    }

    public static CompanionDevice decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static CompanionDevice decode(ProtobufInputStream protoInputStream) {
        java.lang.String model = null;
        java.lang.String manufacturer = null;
        it.auties.whatsapp.model.signal.auth.UserAgent.PlatformType platform = null;
        it.auties.whatsapp.model.signal.auth.Version appVersion = null;
        it.auties.whatsapp.model.signal.auth.Version osVersion = null;
        java.lang.String osBuildNumber = null;
        java.lang.String modelId = null;
        it.auties.whatsapp.api.ClientType clientType = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> model = protoInputStream.readString();
                case 2 -> manufacturer = protoInputStream.readString();
                case 3 -> platform = it.auties.whatsapp.model.signal.auth.UserAgentPlatformTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 4 -> appVersion = it.auties.whatsapp.model.signal.auth.VersionSpec.decode(protoInputStream.lengthDelimitedStream());
                case 5 -> osVersion = it.auties.whatsapp.model.signal.auth.VersionSpec.decode(protoInputStream.lengthDelimitedStream());
                case 6 -> osBuildNumber = protoInputStream.readString();
                case 8 -> modelId = protoInputStream.readString();
                case 9 -> clientType = it.auties.whatsapp.api.ClientTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.companion.CompanionDevice(model, manufacturer, platform, appVersion, osVersion, osBuildNumber, modelId, clientType);
    }

    public static int sizeOf(CompanionDevice object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var model = object.model();
        if (model != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(model);
        }
        var manufacturer = object.manufacturer();
        if (manufacturer != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(manufacturer);
        }
        var platform = object.platform();
        if (platform != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            var platformSerializedSize = it.auties.whatsapp.model.signal.auth.UserAgentPlatformTypeSpec.sizeOf(platform);
            protoSize += platformSerializedSize;
        }
        var appVersion = object.appVersion();
        if (appVersion != null) {
            var appVersion0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(appVersion);
            if (appVersion0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                var appVersion0SerializedSize = it.auties.whatsapp.model.signal.auth.VersionSpec.sizeOf(appVersion0);
                protoSize += ProtobufOutputStream.getVarIntSize(appVersion0SerializedSize);
                protoSize += appVersion0SerializedSize;
            }
        }
        var osVersion = object.osVersion();
        if (osVersion != null) {
            protoSize += ProtobufOutputStream.getFieldSize(5, 2);
            var osVersionSerializedSize = it.auties.whatsapp.model.signal.auth.VersionSpec.sizeOf(osVersion);
            protoSize += ProtobufOutputStream.getVarIntSize(osVersionSerializedSize);
            protoSize += osVersionSerializedSize;
        }
        var osBuildNumber = object.osBuildNumber();
        if (osBuildNumber != null) {
            protoSize += ProtobufOutputStream.getFieldSize(6, 2);
            protoSize += ProtobufOutputStream.getStringSize(osBuildNumber);
        }
        var modelId = object.modelId();
        if (modelId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(8, 2);
            protoSize += ProtobufOutputStream.getStringSize(modelId);
        }
        var clientType = object.clientType();
        if (clientType != null) {
            protoSize += ProtobufOutputStream.getFieldSize(9, 2);
            var clientTypeSerializedSize = it.auties.whatsapp.api.ClientTypeSpec.sizeOf(clientType);
            protoSize += clientTypeSerializedSize;
        }
        return protoSize;
    }

}
