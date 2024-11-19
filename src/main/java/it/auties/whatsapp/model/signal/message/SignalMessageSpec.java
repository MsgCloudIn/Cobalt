package it.auties.whatsapp.model.signal.message;

import it.auties.whatsapp.model.signal.message.SignalMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SignalMessageSpec {
    public static byte[] encode(SignalMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, protoInputObject.ephemeralPublicKey());
        outputStream.writeUInt32(2, protoInputObject.counter());
        outputStream.writeUInt32(3, protoInputObject.previousCounter());
        outputStream.writeBytes(4, protoInputObject.ciphertext());
        return outputStream.toByteArray();
    }

    public static SignalMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SignalMessage decode(ProtobufInputStream protoInputStream) {
        byte[] ephemeralPublicKey = null;
        java.lang.Integer counter = null;
        java.lang.Integer previousCounter = null;
        byte[] ciphertext = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> ephemeralPublicKey = protoInputStream.readBytes();
                case 2 -> counter = protoInputStream.readInt32();
                case 3 -> previousCounter = protoInputStream.readInt32();
                case 4 -> ciphertext = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.message.SignalMessage(ephemeralPublicKey, counter, previousCounter, ciphertext);
    }

    public static int sizeOf(SignalMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var ephemeralPublicKey = object.ephemeralPublicKey();
        if (ephemeralPublicKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getBytesSize(ephemeralPublicKey);
        }
        var counter = object.counter();
        if (counter != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(counter);
        }
        var previousCounter = object.previousCounter();
        if (previousCounter != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(previousCounter);
        }
        var ciphertext = object.ciphertext();
        if (ciphertext != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            protoSize += ProtobufOutputStream.getBytesSize(ciphertext);
        }
        return protoSize;
    }

}
