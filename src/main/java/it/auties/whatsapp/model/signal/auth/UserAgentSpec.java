package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.UserAgent;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class UserAgentSpec {
    public static byte[] encode(UserAgent protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, it.auties.whatsapp.model.signal.auth.UserAgentPlatformTypeSpec.encode(protoInputObject.platform()));
        outputStream.writeBytes(2, it.auties.whatsapp.model.signal.auth.VersionSpec.encode(protoInputObject.appVersion()));
        outputStream.writeString(3, protoInputObject.mcc());
        outputStream.writeString(4, protoInputObject.mnc());
        outputStream.writeString(5, protoInputObject.osVersion());
        outputStream.writeString(6, protoInputObject.manufacturer());
        outputStream.writeString(7, protoInputObject.device());
        outputStream.writeString(8, protoInputObject.osBuildNumber());
        outputStream.writeString(9, protoInputObject.phoneId());
        outputStream.writeInt32(10, it.auties.whatsapp.model.signal.auth.UserAgentReleaseChannelSpec.encode(protoInputObject.releaseChannel()));
        outputStream.writeString(11, protoInputObject.localeLanguageIso6391());
        outputStream.writeString(12, protoInputObject.localeCountryIso31661Alpha2());
        outputStream.writeString(13, protoInputObject.deviceBoard());
        outputStream.writeInt32(15, it.auties.whatsapp.model.signal.auth.UserAgentDeviceTypeSpec.encode(protoInputObject.deviceType()));
        outputStream.writeString(16, protoInputObject.deviceModelType());
        return outputStream.toByteArray();
    }

    public static UserAgent decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static UserAgent decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.signal.auth.UserAgent.PlatformType platform = null;
        it.auties.whatsapp.model.signal.auth.Version appVersion = null;
        java.lang.String mcc = null;
        java.lang.String mnc = null;
        java.lang.String osVersion = null;
        java.lang.String manufacturer = null;
        java.lang.String device = null;
        java.lang.String osBuildNumber = null;
        java.lang.String phoneId = null;
        it.auties.whatsapp.model.signal.auth.UserAgent.ReleaseChannel releaseChannel = null;
        java.lang.String localeLanguageIso6391 = null;
        java.lang.String localeCountryIso31661Alpha2 = null;
        java.lang.String deviceBoard = null;
        it.auties.whatsapp.model.signal.auth.UserAgent.DeviceType deviceType = null;
        java.lang.String deviceModelType = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> platform = it.auties.whatsapp.model.signal.auth.UserAgentPlatformTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 2 -> appVersion = it.auties.whatsapp.model.signal.auth.VersionSpec.decode(protoInputStream.lengthDelimitedStream());
                case 3 -> mcc = protoInputStream.readString();
                case 4 -> mnc = protoInputStream.readString();
                case 5 -> osVersion = protoInputStream.readString();
                case 6 -> manufacturer = protoInputStream.readString();
                case 7 -> device = protoInputStream.readString();
                case 8 -> osBuildNumber = protoInputStream.readString();
                case 9 -> phoneId = protoInputStream.readString();
                case 10 -> releaseChannel = it.auties.whatsapp.model.signal.auth.UserAgentReleaseChannelSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 11 -> localeLanguageIso6391 = protoInputStream.readString();
                case 12 -> localeCountryIso31661Alpha2 = protoInputStream.readString();
                case 13 -> deviceBoard = protoInputStream.readString();
                case 15 -> deviceType = it.auties.whatsapp.model.signal.auth.UserAgentDeviceTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 16 -> deviceModelType = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.auth.UserAgent(platform, appVersion, mcc, mnc, osVersion, manufacturer, device, osBuildNumber, phoneId, releaseChannel, localeLanguageIso6391, localeCountryIso31661Alpha2, deviceBoard, deviceType, deviceModelType);
    }

    public static int sizeOf(UserAgent object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var platform = object.platform();
        if (platform != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var platformSerializedSize = it.auties.whatsapp.model.signal.auth.UserAgentPlatformTypeSpec.sizeOf(platform);
            protoSize += platformSerializedSize;
        }
        var appVersion = object.appVersion();
        if (appVersion != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var appVersionSerializedSize = it.auties.whatsapp.model.signal.auth.VersionSpec.sizeOf(appVersion);
            protoSize += ProtobufOutputStream.getVarIntSize(appVersionSerializedSize);
            protoSize += appVersionSerializedSize;
        }
        var mcc = object.mcc();
        if (mcc != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getStringSize(mcc);
        }
        var mnc = object.mnc();
        if (mnc != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            protoSize += ProtobufOutputStream.getStringSize(mnc);
        }
        var osVersion = object.osVersion();
        if (osVersion != null) {
            protoSize += ProtobufOutputStream.getFieldSize(5, 2);
            protoSize += ProtobufOutputStream.getStringSize(osVersion);
        }
        var manufacturer = object.manufacturer();
        if (manufacturer != null) {
            protoSize += ProtobufOutputStream.getFieldSize(6, 2);
            protoSize += ProtobufOutputStream.getStringSize(manufacturer);
        }
        var device = object.device();
        if (device != null) {
            protoSize += ProtobufOutputStream.getFieldSize(7, 2);
            protoSize += ProtobufOutputStream.getStringSize(device);
        }
        var osBuildNumber = object.osBuildNumber();
        if (osBuildNumber != null) {
            protoSize += ProtobufOutputStream.getFieldSize(8, 2);
            protoSize += ProtobufOutputStream.getStringSize(osBuildNumber);
        }
        var phoneId = object.phoneId();
        if (phoneId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(9, 2);
            protoSize += ProtobufOutputStream.getStringSize(phoneId);
        }
        var releaseChannel = object.releaseChannel();
        if (releaseChannel != null) {
            protoSize += ProtobufOutputStream.getFieldSize(10, 2);
            var releaseChannelSerializedSize = it.auties.whatsapp.model.signal.auth.UserAgentReleaseChannelSpec.sizeOf(releaseChannel);
            protoSize += releaseChannelSerializedSize;
        }
        var localeLanguageIso6391 = object.localeLanguageIso6391();
        if (localeLanguageIso6391 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(11, 2);
            protoSize += ProtobufOutputStream.getStringSize(localeLanguageIso6391);
        }
        var localeCountryIso31661Alpha2 = object.localeCountryIso31661Alpha2();
        if (localeCountryIso31661Alpha2 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(12, 2);
            protoSize += ProtobufOutputStream.getStringSize(localeCountryIso31661Alpha2);
        }
        var deviceBoard = object.deviceBoard();
        if (deviceBoard != null) {
            protoSize += ProtobufOutputStream.getFieldSize(13, 2);
            protoSize += ProtobufOutputStream.getStringSize(deviceBoard);
        }
        var deviceType = object.deviceType();
        if (deviceType != null) {
            protoSize += ProtobufOutputStream.getFieldSize(15, 2);
            var deviceTypeSerializedSize = it.auties.whatsapp.model.signal.auth.UserAgentDeviceTypeSpec.sizeOf(deviceType);
            protoSize += deviceTypeSerializedSize;
        }
        var deviceModelType = object.deviceModelType();
        if (deviceModelType != null) {
            protoSize += ProtobufOutputStream.getFieldSize(16, 2);
            protoSize += ProtobufOutputStream.getStringSize(deviceModelType);
        }
        return protoSize;
    }

}
