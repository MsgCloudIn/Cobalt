package it.auties.whatsapp.model.signal.keypair;

import it.auties.whatsapp.model.signal.keypair.SignalPreKeyPair;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SignalPreKeyPairSpec {
    public static byte[] encode(SignalPreKeyPair protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, protoInputObject.id());
        outputStream.writeBytes(2, protoInputObject.publicKey());
        outputStream.writeBytes(3, protoInputObject.privateKey());
        return outputStream.toByteArray();
    }

    public static SignalPreKeyPair decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SignalPreKeyPair decode(ProtobufInputStream protoInputStream) {
        int id = 0;
        byte[] publicKey = null;
        byte[] privateKey = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> id = protoInputStream.readInt32();
                case 2 -> publicKey = protoInputStream.readBytes();
                case 3 -> privateKey = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.keypair.SignalPreKeyPair(id, publicKey, privateKey);
    }

    public static int sizeOf(SignalPreKeyPair object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var id = object.id();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(id);
        var publicKey = object.publicKey();
        if (publicKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(publicKey);
        }
        var privateKey = object.privateKey();
        if (privateKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getBytesSize(privateKey);
        }
        return protoSize;
    }

}
