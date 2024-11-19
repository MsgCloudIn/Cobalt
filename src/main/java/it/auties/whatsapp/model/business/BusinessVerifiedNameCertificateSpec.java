package it.auties.whatsapp.model.business;

import it.auties.whatsapp.model.business.BusinessVerifiedNameCertificate;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class BusinessVerifiedNameCertificateSpec {
    public static byte[] encode(BusinessVerifiedNameCertificate protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, protoInputObject.encodedDetails());
        outputStream.writeBytes(2, protoInputObject.signature());
        outputStream.writeBytes(3, protoInputObject.serverSignature());
        return outputStream.toByteArray();
    }

    public static BusinessVerifiedNameCertificate decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static BusinessVerifiedNameCertificate decode(ProtobufInputStream protoInputStream) {
        byte[] encodedDetails = null;
        byte[] signature = null;
        byte[] serverSignature = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> encodedDetails = protoInputStream.readBytes();
                case 2 -> signature = protoInputStream.readBytes();
                case 3 -> serverSignature = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.business.BusinessVerifiedNameCertificate(encodedDetails, signature, serverSignature);
    }

    public static int sizeOf(BusinessVerifiedNameCertificate object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var encodedDetails = object.encodedDetails();
        if (encodedDetails != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getBytesSize(encodedDetails);
        }
        var signature = object.signature();
        if (signature != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(signature);
        }
        var serverSignature = object.serverSignature();
        if (serverSignature != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getBytesSize(serverSignature);
        }
        return protoSize;
    }

}
