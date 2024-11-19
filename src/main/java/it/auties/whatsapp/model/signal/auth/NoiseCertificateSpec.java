package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.NoiseCertificate;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class NoiseCertificateSpec {
    public static byte[] encode(NoiseCertificate protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, protoInputObject.details());
        outputStream.writeBytes(2, protoInputObject.signature());
        return outputStream.toByteArray();
    }

    public static NoiseCertificate decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static NoiseCertificate decode(ProtobufInputStream protoInputStream) {
        byte[] details = null;
        byte[] signature = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> details = protoInputStream.readBytes();
                case 2 -> signature = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.auth.NoiseCertificate(details, signature);
    }

    public static int sizeOf(NoiseCertificate object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var details = object.details();
        if (details != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getBytesSize(details);
        }
        var signature = object.signature();
        if (signature != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(signature);
        }
        return protoSize;
    }

}
