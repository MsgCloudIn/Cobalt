package it.auties.whatsapp.model.signal.sender;

import it.auties.whatsapp.model.signal.sender.SenderMessageKey;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SenderMessageKeySpec {
    public static byte[] encode(SenderMessageKey protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, protoInputObject.iteration());
        outputStream.writeBytes(2, protoInputObject.seed());
        outputStream.writeBytes(3, protoInputObject.iv());
        outputStream.writeBytes(4, protoInputObject.cipherKey());
        return outputStream.toByteArray();
    }

    public static SenderMessageKey decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SenderMessageKey decode(ProtobufInputStream protoInputStream) {
        int iteration = 0;
        byte[] seed = null;
        byte[] iv = null;
        byte[] cipherKey = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> iteration = protoInputStream.readInt32();
                case 2 -> seed = protoInputStream.readBytes();
                case 3 -> iv = protoInputStream.readBytes();
                case 4 -> cipherKey = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.sender.SenderMessageKey(iteration, seed, iv, cipherKey);
    }

    public static int sizeOf(SenderMessageKey object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var iteration = object.iteration();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(iteration);
        var seed = object.seed();
        if (seed != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(seed);
        }
        var iv = object.iv();
        if (iv != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getBytesSize(iv);
        }
        var cipherKey = object.cipherKey();
        if (cipherKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            protoSize += ProtobufOutputStream.getBytesSize(cipherKey);
        }
        return protoSize;
    }

}
