package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.ClientHello;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ClientHelloSpec {
    public static byte[] encode(ClientHello protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, protoInputObject.ephemeral());
        outputStream.writeBytes(2, protoInputObject._static());
        outputStream.writeBytes(3, protoInputObject.payload());
        return outputStream.toByteArray();
    }

    public static ClientHello decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ClientHello decode(ProtobufInputStream protoInputStream) {
        byte[] ephemeral = null;
        byte[] _static = null;
        byte[] payload = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> ephemeral = protoInputStream.readBytes();
                case 2 -> _static = protoInputStream.readBytes();
                case 3 -> payload = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.auth.ClientHello(ephemeral, _static, payload);
    }

    public static int sizeOf(ClientHello object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var ephemeral = object.ephemeral();
        if (ephemeral != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getBytesSize(ephemeral);
        }
        var _static = object._static();
        if (_static != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(_static);
        }
        var payload = object.payload();
        if (payload != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getBytesSize(payload);
        }
        return protoSize;
    }

}
