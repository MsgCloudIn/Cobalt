package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.ClientPayload;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ClientPayloadSpec {
    public static byte[] encode(ClientPayload protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeUInt64(1, protoInputObject.username());
        outputStream.writeBool(3, protoInputObject.passive());
        outputStream.writeBytes(5, it.auties.whatsapp.model.signal.auth.UserAgentSpec.encode(protoInputObject.userAgent()));
        outputStream.writeBytes(6, it.auties.whatsapp.model.signal.auth.WebInfoSpec.encode(protoInputObject.webInfo()));
        outputStream.writeString(7, protoInputObject.pushName());
        outputStream.writeFixed32(9, protoInputObject.sessionId());
        outputStream.writeBool(10, protoInputObject.shortConnect());
        outputStream.writeInt32(12, it.auties.whatsapp.model.signal.auth.ClientPayloadClientPayloadConnectTypeSpec.encode(protoInputObject.connectType()));
        outputStream.writeInt32(13, it.auties.whatsapp.model.signal.auth.ClientPayloadClientPayloadConnectReasonSpec.encode(protoInputObject.connectReason()));
        if (protoInputObject.shards() != null) {
            for (var shardsEntry : protoInputObject.shards()) { 
                outputStream.writeInt32(14, shardsEntry);
            }
        }
        outputStream.writeBytes(15, it.auties.whatsapp.model.signal.auth.DNSSourceSpec.encode(protoInputObject.dnsSource()));
        outputStream.writeUInt32(16, protoInputObject.connectAttemptCount());
        outputStream.writeUInt32(18, protoInputObject.device());
        outputStream.writeBytes(19, it.auties.whatsapp.model.signal.auth.CompanionRegistrationDataSpec.encode(protoInputObject.regData()));
        outputStream.writeInt32(20, it.auties.whatsapp.model.signal.auth.ClientPayloadClientPayloadProductSpec.encode(protoInputObject.product()));
        outputStream.writeBytes(21, protoInputObject.fbCat());
        outputStream.writeBytes(22, protoInputObject.fbUserAgent());
        outputStream.writeBool(23, protoInputObject.oc());
        outputStream.writeInt32(24, protoInputObject.lc());
        outputStream.writeInt32(30, it.auties.whatsapp.model.signal.auth.ClientPayloadClientPayloadIOSAppExtensionSpec.encode(protoInputObject.iosAppExtension()));
        outputStream.writeUInt64(31, protoInputObject.fbAppId());
        outputStream.writeBytes(32, protoInputObject.fbDeviceId());
        outputStream.writeBool(33, protoInputObject.pull());
        return outputStream.toByteArray();
    }

    public static ClientPayload decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ClientPayload decode(ProtobufInputStream protoInputStream) {
        java.lang.Long username = null;
        java.lang.Boolean passive = null;
        it.auties.whatsapp.model.signal.auth.UserAgent userAgent = null;
        it.auties.whatsapp.model.signal.auth.WebInfo webInfo = null;
        java.lang.String pushName = null;
        java.lang.Integer sessionId = null;
        java.lang.Boolean shortConnect = null;
        it.auties.whatsapp.model.signal.auth.ClientPayload.ClientPayloadConnectType connectType = null;
        it.auties.whatsapp.model.signal.auth.ClientPayload.ClientPayloadConnectReason connectReason = null;
        java.util.List<java.lang.Integer> shards = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        it.auties.whatsapp.model.signal.auth.DNSSource dnsSource = null;
        java.lang.Integer connectAttemptCount = null;
        java.lang.Integer device = null;
        it.auties.whatsapp.model.signal.auth.CompanionRegistrationData regData = null;
        it.auties.whatsapp.model.signal.auth.ClientPayload.ClientPayloadProduct product = null;
        byte[] fbCat = null;
        byte[] fbUserAgent = null;
        java.lang.Boolean oc = null;
        java.lang.Integer lc = null;
        it.auties.whatsapp.model.signal.auth.ClientPayload.ClientPayloadIOSAppExtension iosAppExtension = null;
        java.lang.Long fbAppId = null;
        byte[] fbDeviceId = null;
        java.lang.Boolean pull = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> username = protoInputStream.readInt64();
                case 3 -> passive = protoInputStream.readBool();
                case 5 -> userAgent = it.auties.whatsapp.model.signal.auth.UserAgentSpec.decode(protoInputStream.lengthDelimitedStream());
                case 6 -> webInfo = it.auties.whatsapp.model.signal.auth.WebInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                case 7 -> pushName = protoInputStream.readString();
                case 9 -> sessionId = protoInputStream.readFixed32();
                case 10 -> shortConnect = protoInputStream.readBool();
                case 12 -> connectType = it.auties.whatsapp.model.signal.auth.ClientPayloadClientPayloadConnectTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 13 -> connectReason = it.auties.whatsapp.model.signal.auth.ClientPayloadClientPayloadConnectReasonSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 14 -> shards.add(protoInputStream.readInt32());
                case 15 -> dnsSource = it.auties.whatsapp.model.signal.auth.DNSSourceSpec.decode(protoInputStream.lengthDelimitedStream());
                case 16 -> connectAttemptCount = protoInputStream.readInt32();
                case 18 -> device = protoInputStream.readInt32();
                case 19 -> regData = it.auties.whatsapp.model.signal.auth.CompanionRegistrationDataSpec.decode(protoInputStream.lengthDelimitedStream());
                case 20 -> product = it.auties.whatsapp.model.signal.auth.ClientPayloadClientPayloadProductSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 21 -> fbCat = protoInputStream.readBytes();
                case 22 -> fbUserAgent = protoInputStream.readBytes();
                case 23 -> oc = protoInputStream.readBool();
                case 24 -> lc = protoInputStream.readInt32();
                case 30 -> iosAppExtension = it.auties.whatsapp.model.signal.auth.ClientPayloadClientPayloadIOSAppExtensionSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 31 -> fbAppId = protoInputStream.readInt64();
                case 32 -> fbDeviceId = protoInputStream.readBytes();
                case 33 -> pull = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.auth.ClientPayload(username, passive, userAgent, webInfo, pushName, sessionId, shortConnect, connectType, connectReason, shards, dnsSource, connectAttemptCount, device, regData, product, fbCat, fbUserAgent, oc, lc, iosAppExtension, fbAppId, fbDeviceId, pull);
    }

    public static int sizeOf(ClientPayload object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var username = object.username();
        if (username != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(username);
        }
        var passive = object.passive();
        if (passive != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 0);
            protoSize += 1;
        }
        var userAgent = object.userAgent();
        if (userAgent != null) {
            protoSize += ProtobufOutputStream.getFieldSize(5, 2);
            var userAgentSerializedSize = it.auties.whatsapp.model.signal.auth.UserAgentSpec.sizeOf(userAgent);
            protoSize += ProtobufOutputStream.getVarIntSize(userAgentSerializedSize);
            protoSize += userAgentSerializedSize;
        }
        var webInfo = object.webInfo();
        if (webInfo != null) {
            protoSize += ProtobufOutputStream.getFieldSize(6, 2);
            var webInfoSerializedSize = it.auties.whatsapp.model.signal.auth.WebInfoSpec.sizeOf(webInfo);
            protoSize += ProtobufOutputStream.getVarIntSize(webInfoSerializedSize);
            protoSize += webInfoSerializedSize;
        }
        var pushName = object.pushName();
        if (pushName != null) {
            protoSize += ProtobufOutputStream.getFieldSize(7, 2);
            protoSize += ProtobufOutputStream.getStringSize(pushName);
        }
        var sessionId = object.sessionId();
        if (sessionId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(9, 5);
            protoSize += 4;
        }
        var shortConnect = object.shortConnect();
        if (shortConnect != null) {
            protoSize += ProtobufOutputStream.getFieldSize(10, 0);
            protoSize += 1;
        }
        var connectType = object.connectType();
        if (connectType != null) {
            protoSize += ProtobufOutputStream.getFieldSize(12, 2);
            var connectTypeSerializedSize = it.auties.whatsapp.model.signal.auth.ClientPayloadClientPayloadConnectTypeSpec.sizeOf(connectType);
            protoSize += connectTypeSerializedSize;
        }
        var connectReason = object.connectReason();
        if (connectReason != null) {
            protoSize += ProtobufOutputStream.getFieldSize(13, 2);
            var connectReasonSerializedSize = it.auties.whatsapp.model.signal.auth.ClientPayloadClientPayloadConnectReasonSpec.sizeOf(connectReason);
            protoSize += connectReasonSerializedSize;
        }
        var shardsRepeatedField = object.shards();
        if (shardsRepeatedField != null) {
            for (var shardsEntry : shardsRepeatedField) { 
                if (shardsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(14, 0);
                    protoSize += ProtobufOutputStream.getVarIntSize(shardsEntry);
                }
            }
        }
        var dnsSource = object.dnsSource();
        if (dnsSource != null) {
            protoSize += ProtobufOutputStream.getFieldSize(15, 2);
            var dnsSourceSerializedSize = it.auties.whatsapp.model.signal.auth.DNSSourceSpec.sizeOf(dnsSource);
            protoSize += ProtobufOutputStream.getVarIntSize(dnsSourceSerializedSize);
            protoSize += dnsSourceSerializedSize;
        }
        var connectAttemptCount = object.connectAttemptCount();
        if (connectAttemptCount != null) {
            protoSize += ProtobufOutputStream.getFieldSize(16, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(connectAttemptCount);
        }
        var device = object.device();
        if (device != null) {
            protoSize += ProtobufOutputStream.getFieldSize(18, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(device);
        }
        var regData = object.regData();
        if (regData != null) {
            protoSize += ProtobufOutputStream.getFieldSize(19, 2);
            var regDataSerializedSize = it.auties.whatsapp.model.signal.auth.CompanionRegistrationDataSpec.sizeOf(regData);
            protoSize += ProtobufOutputStream.getVarIntSize(regDataSerializedSize);
            protoSize += regDataSerializedSize;
        }
        var product = object.product();
        if (product != null) {
            protoSize += ProtobufOutputStream.getFieldSize(20, 2);
            var productSerializedSize = it.auties.whatsapp.model.signal.auth.ClientPayloadClientPayloadProductSpec.sizeOf(product);
            protoSize += productSerializedSize;
        }
        var fbCat = object.fbCat();
        if (fbCat != null) {
            protoSize += ProtobufOutputStream.getFieldSize(21, 2);
            protoSize += ProtobufOutputStream.getBytesSize(fbCat);
        }
        var fbUserAgent = object.fbUserAgent();
        if (fbUserAgent != null) {
            protoSize += ProtobufOutputStream.getFieldSize(22, 2);
            protoSize += ProtobufOutputStream.getBytesSize(fbUserAgent);
        }
        var oc = object.oc();
        if (oc != null) {
            protoSize += ProtobufOutputStream.getFieldSize(23, 0);
            protoSize += 1;
        }
        var lc = object.lc();
        if (lc != null) {
            protoSize += ProtobufOutputStream.getFieldSize(24, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(lc);
        }
        var iosAppExtension = object.iosAppExtension();
        if (iosAppExtension != null) {
            protoSize += ProtobufOutputStream.getFieldSize(30, 2);
            var iosAppExtensionSerializedSize = it.auties.whatsapp.model.signal.auth.ClientPayloadClientPayloadIOSAppExtensionSpec.sizeOf(iosAppExtension);
            protoSize += iosAppExtensionSerializedSize;
        }
        var fbAppId = object.fbAppId();
        if (fbAppId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(31, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(fbAppId);
        }
        var fbDeviceId = object.fbDeviceId();
        if (fbDeviceId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(32, 2);
            protoSize += ProtobufOutputStream.getBytesSize(fbDeviceId);
        }
        var pull = object.pull();
        if (pull != null) {
            protoSize += ProtobufOutputStream.getFieldSize(33, 0);
            protoSize += 1;
        }
        return protoSize;
    }

}
