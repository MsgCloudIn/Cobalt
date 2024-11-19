package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.ClientFinish;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ClientFinishSpec {
    public static byte[] encode(ClientFinish protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, protoInputObject._static());
        outputStream.writeBytes(2, protoInputObject.payload());
        return outputStream.toByteArray();
    }

    public static ClientFinish decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ClientFinish decode(ProtobufInputStream protoInputStream) {
        byte[] _static = null;
        byte[] payload = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> _static = protoInputStream.readBytes();
                case 2 -> payload = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.auth.ClientFinish(_static, payload);
    }

    public static int sizeOf(ClientFinish object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var _static = object._static();
        if (_static != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getBytesSize(_static);
        }
        var payload = object.payload();
        if (payload != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(payload);
        }
        return protoSize;
    }

}
