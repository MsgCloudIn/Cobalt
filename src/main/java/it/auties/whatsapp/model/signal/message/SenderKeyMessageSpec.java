package it.auties.whatsapp.model.signal.message;

import it.auties.whatsapp.model.signal.message.SenderKeyMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SenderKeyMessageSpec {
    public static byte[] encode(SenderKeyMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeUInt32(1, protoInputObject.id());
        outputStream.writeUInt32(2, protoInputObject.iteration());
        outputStream.writeBytes(3, protoInputObject.cipherText());
        return outputStream.toByteArray();
    }

    public static SenderKeyMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SenderKeyMessage decode(ProtobufInputStream protoInputStream) {
        java.lang.Integer id = null;
        java.lang.Integer iteration = null;
        byte[] cipherText = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> id = protoInputStream.readInt32();
                case 2 -> iteration = protoInputStream.readInt32();
                case 3 -> cipherText = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.message.SenderKeyMessage(id, iteration, cipherText);
    }

    public static int sizeOf(SenderKeyMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var id = object.id();
        if (id != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(id);
        }
        var iteration = object.iteration();
        if (iteration != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(iteration);
        }
        var cipherText = object.cipherText();
        if (cipherText != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getBytesSize(cipherText);
        }
        return protoSize;
    }

}
