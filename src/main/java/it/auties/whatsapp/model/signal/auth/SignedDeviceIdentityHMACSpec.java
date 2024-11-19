package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.SignedDeviceIdentityHMAC;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SignedDeviceIdentityHMACSpec {
    public static byte[] encode(SignedDeviceIdentityHMAC protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, protoInputObject.details());
        outputStream.writeBytes(2, protoInputObject.hmac());
        return outputStream.toByteArray();
    }

    public static SignedDeviceIdentityHMAC decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SignedDeviceIdentityHMAC decode(ProtobufInputStream protoInputStream) {
        byte[] details = null;
        byte[] hmac = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> details = protoInputStream.readBytes();
                case 2 -> hmac = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.auth.SignedDeviceIdentityHMAC(details, hmac);
    }

    public static int sizeOf(SignedDeviceIdentityHMAC object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var details = object.details();
        if (details != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getBytesSize(details);
        }
        var hmac = object.hmac();
        if (hmac != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(hmac);
        }
        return protoSize;
    }

}
