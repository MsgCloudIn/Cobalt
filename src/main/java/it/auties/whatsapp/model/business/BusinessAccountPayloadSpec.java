package it.auties.whatsapp.model.business;

import it.auties.whatsapp.model.business.BusinessAccountPayload;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class BusinessAccountPayloadSpec {
    public static byte[] encode(BusinessAccountPayload protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.business.BusinessVerifiedNameCertificateSpec.encode(protoInputObject.certificate()));
        outputStream.writeBytes(2, protoInputObject.info());
        return outputStream.toByteArray();
    }

    public static BusinessAccountPayload decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static BusinessAccountPayload decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.business.BusinessVerifiedNameCertificate certificate = null;
        byte[] info = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> certificate = it.auties.whatsapp.model.business.BusinessVerifiedNameCertificateSpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> info = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.business.BusinessAccountPayload(certificate, info);
    }

    public static int sizeOf(BusinessAccountPayload object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var certificate = object.certificate();
        if (certificate != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var certificateSerializedSize = it.auties.whatsapp.model.business.BusinessVerifiedNameCertificateSpec.sizeOf(certificate);
            protoSize += ProtobufOutputStream.getVarIntSize(certificateSerializedSize);
            protoSize += certificateSerializedSize;
        }
        var info = object.info();
        if (info != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(info);
        }
        return protoSize;
    }

}
