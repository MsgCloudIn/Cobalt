package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.SignedKeyIndexList;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SignedKeyIndexListSpec {
    public static byte[] encode(SignedKeyIndexList protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, protoInputObject.details());
        outputStream.writeBytes(2, protoInputObject.accountSignature());
        return outputStream.toByteArray();
    }

    public static SignedKeyIndexList decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SignedKeyIndexList decode(ProtobufInputStream protoInputStream) {
        byte[] details = null;
        byte[] accountSignature = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> details = protoInputStream.readBytes();
                case 2 -> accountSignature = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.auth.SignedKeyIndexList(details, accountSignature);
    }

    public static int sizeOf(SignedKeyIndexList object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var details = object.details();
        if (details != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getBytesSize(details);
        }
        var accountSignature = object.accountSignature();
        if (accountSignature != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(accountSignature);
        }
        return protoSize;
    }

}
