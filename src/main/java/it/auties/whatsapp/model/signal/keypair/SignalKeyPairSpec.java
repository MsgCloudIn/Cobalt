package it.auties.whatsapp.model.signal.keypair;

import it.auties.whatsapp.model.signal.keypair.SignalKeyPair;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SignalKeyPairSpec {
    public static byte[] encode(SignalKeyPair protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, protoInputObject.publicKey());
        outputStream.writeBytes(2, protoInputObject.privateKey());
        return outputStream.toByteArray();
    }

    public static SignalKeyPair decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SignalKeyPair decode(ProtobufInputStream protoInputStream) {
        byte[] publicKey = null;
        byte[] privateKey = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> publicKey = protoInputStream.readBytes();
                case 2 -> privateKey = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.keypair.SignalKeyPair(publicKey, privateKey);
    }

    public static int sizeOf(SignalKeyPair object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var publicKey = object.publicKey();
        if (publicKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getBytesSize(publicKey);
        }
        var privateKey = object.privateKey();
        if (privateKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(privateKey);
        }
        return protoSize;
    }

}
