package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.WebInfo;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class WebInfoSpec {
    public static byte[] encode(WebInfo protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.refToken());
        outputStream.writeString(2, protoInputObject.version());
        outputStream.writeBytes(3, it.auties.whatsapp.model.signal.auth.WebPayloadSpec.encode(protoInputObject.webPayload()));
        outputStream.writeInt32(4, it.auties.whatsapp.model.signal.auth.WebInfoPlatformSpec.encode(protoInputObject.webSubPlatform()));
        return outputStream.toByteArray();
    }

    public static WebInfo decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static WebInfo decode(ProtobufInputStream protoInputStream) {
        java.lang.String refToken = null;
        java.lang.String version = null;
        it.auties.whatsapp.model.signal.auth.WebPayload webPayload = null;
        it.auties.whatsapp.model.signal.auth.WebInfo.Platform webSubPlatform = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> refToken = protoInputStream.readString();
                case 2 -> version = protoInputStream.readString();
                case 3 -> webPayload = it.auties.whatsapp.model.signal.auth.WebPayloadSpec.decode(protoInputStream.lengthDelimitedStream());
                case 4 -> webSubPlatform = it.auties.whatsapp.model.signal.auth.WebInfoPlatformSpec.decode(protoInputStream.readInt32()).orElse(null);
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.auth.WebInfo(refToken, version, webPayload, webSubPlatform);
    }

    public static int sizeOf(WebInfo object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var refToken = object.refToken();
        if (refToken != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(refToken);
        }
        var version = object.version();
        if (version != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(version);
        }
        var webPayload = object.webPayload();
        if (webPayload != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            var webPayloadSerializedSize = it.auties.whatsapp.model.signal.auth.WebPayloadSpec.sizeOf(webPayload);
            protoSize += ProtobufOutputStream.getVarIntSize(webPayloadSerializedSize);
            protoSize += webPayloadSerializedSize;
        }
        var webSubPlatform = object.webSubPlatform();
        if (webSubPlatform != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            var webSubPlatformSerializedSize = it.auties.whatsapp.model.signal.auth.WebInfoPlatformSpec.sizeOf(webSubPlatform);
            protoSize += webSubPlatformSerializedSize;
        }
        return protoSize;
    }

}
