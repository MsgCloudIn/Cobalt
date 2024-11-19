package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.SignedDeviceIdentity;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SignedDeviceIdentitySpec {
    public static byte[] encode(SignedDeviceIdentity protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, protoInputObject.details());
        outputStream.writeBytes(2, protoInputObject.accountSignatureKey());
        outputStream.writeBytes(3, protoInputObject.accountSignature());
        outputStream.writeBytes(4, protoInputObject.deviceSignature());
        return outputStream.toByteArray();
    }

    public static SignedDeviceIdentity decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SignedDeviceIdentity decode(ProtobufInputStream protoInputStream) {
        byte[] details = null;
        byte[] accountSignatureKey = null;
        byte[] accountSignature = null;
        byte[] deviceSignature = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> details = protoInputStream.readBytes();
                case 2 -> accountSignatureKey = protoInputStream.readBytes();
                case 3 -> accountSignature = protoInputStream.readBytes();
                case 4 -> deviceSignature = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.auth.SignedDeviceIdentity(details, accountSignatureKey, accountSignature, deviceSignature);
    }

    public static int sizeOf(SignedDeviceIdentity object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var details = object.details();
        if (details != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getBytesSize(details);
        }
        var accountSignatureKey = object.accountSignatureKey();
        if (accountSignatureKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(accountSignatureKey);
        }
        var accountSignature = object.accountSignature();
        if (accountSignature != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getBytesSize(accountSignature);
        }
        var deviceSignature = object.deviceSignature();
        if (deviceSignature != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            protoSize += ProtobufOutputStream.getBytesSize(deviceSignature);
        }
        return protoSize;
    }

}
