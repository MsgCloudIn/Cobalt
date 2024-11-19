package it.auties.whatsapp.model.signal.sender;

import it.auties.whatsapp.model.signal.sender.SenderChainKey;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SenderChainKeySpec {
    public static byte[] encode(SenderChainKey protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, protoInputObject.iteration());
        outputStream.writeBytes(2, protoInputObject.seed());
        return outputStream.toByteArray();
    }

    public static SenderChainKey decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SenderChainKey decode(ProtobufInputStream protoInputStream) {
        int iteration = 0;
        byte[] seed = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> iteration = protoInputStream.readInt32();
                case 2 -> seed = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.sender.SenderChainKey(iteration, seed);
    }

    public static int sizeOf(SenderChainKey object) {
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
        return protoSize;
    }

}
