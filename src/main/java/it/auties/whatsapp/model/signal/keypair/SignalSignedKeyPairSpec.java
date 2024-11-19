package it.auties.whatsapp.model.signal.keypair;

import it.auties.whatsapp.model.signal.keypair.SignalSignedKeyPair;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SignalSignedKeyPairSpec {
    public static byte[] encode(SignalSignedKeyPair protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, protoInputObject.id());
        outputStream.writeBytes(2, it.auties.whatsapp.model.signal.keypair.SignalKeyPairSpec.encode(protoInputObject.keyPair()));
        outputStream.writeBytes(3, protoInputObject.signature());
        return outputStream.toByteArray();
    }

    public static SignalSignedKeyPair decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SignalSignedKeyPair decode(ProtobufInputStream protoInputStream) {
        int id = 0;
        it.auties.whatsapp.model.signal.keypair.SignalKeyPair keyPair = null;
        byte[] signature = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> id = protoInputStream.readInt32();
                case 2 -> keyPair = it.auties.whatsapp.model.signal.keypair.SignalKeyPairSpec.decode(protoInputStream.lengthDelimitedStream());
                case 3 -> signature = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.keypair.SignalSignedKeyPair(id, keyPair, signature);
    }

    public static int sizeOf(SignalSignedKeyPair object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var id = object.id();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(id);
        var keyPair = object.keyPair();
        if (keyPair != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var keyPairSerializedSize = it.auties.whatsapp.model.signal.keypair.SignalKeyPairSpec.sizeOf(keyPair);
            protoSize += ProtobufOutputStream.getVarIntSize(keyPairSerializedSize);
            protoSize += keyPairSerializedSize;
        }
        var signature = object.signature();
        if (signature != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getBytesSize(signature);
        }
        return protoSize;
    }

}
