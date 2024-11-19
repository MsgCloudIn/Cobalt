package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.CompanionRegistrationData;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class CompanionRegistrationDataSpec {
    public static byte[] encode(CompanionRegistrationData protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, protoInputObject.eRegid());
        outputStream.writeBytes(2, protoInputObject.eKeytype());
        outputStream.writeBytes(3, protoInputObject.eIdent());
        outputStream.writeBytes(4, protoInputObject.eSkeyId());
        outputStream.writeBytes(5, protoInputObject.eSkeyVal());
        outputStream.writeBytes(6, protoInputObject.eSkeySig());
        outputStream.writeBytes(7, protoInputObject.buildHash());
        outputStream.writeBytes(8, protoInputObject.companionProps());
        return outputStream.toByteArray();
    }

    public static CompanionRegistrationData decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static CompanionRegistrationData decode(ProtobufInputStream protoInputStream) {
        byte[] eRegid = null;
        byte[] eKeytype = null;
        byte[] eIdent = null;
        byte[] eSkeyId = null;
        byte[] eSkeyVal = null;
        byte[] eSkeySig = null;
        byte[] buildHash = null;
        byte[] companionProps = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> eRegid = protoInputStream.readBytes();
                case 2 -> eKeytype = protoInputStream.readBytes();
                case 3 -> eIdent = protoInputStream.readBytes();
                case 4 -> eSkeyId = protoInputStream.readBytes();
                case 5 -> eSkeyVal = protoInputStream.readBytes();
                case 6 -> eSkeySig = protoInputStream.readBytes();
                case 7 -> buildHash = protoInputStream.readBytes();
                case 8 -> companionProps = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.auth.CompanionRegistrationData(eRegid, eKeytype, eIdent, eSkeyId, eSkeyVal, eSkeySig, buildHash, companionProps);
    }

    public static int sizeOf(CompanionRegistrationData object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var eRegid = object.eRegid();
        if (eRegid != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getBytesSize(eRegid);
        }
        var eKeytype = object.eKeytype();
        if (eKeytype != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(eKeytype);
        }
        var eIdent = object.eIdent();
        if (eIdent != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getBytesSize(eIdent);
        }
        var eSkeyId = object.eSkeyId();
        if (eSkeyId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            protoSize += ProtobufOutputStream.getBytesSize(eSkeyId);
        }
        var eSkeyVal = object.eSkeyVal();
        if (eSkeyVal != null) {
            protoSize += ProtobufOutputStream.getFieldSize(5, 2);
            protoSize += ProtobufOutputStream.getBytesSize(eSkeyVal);
        }
        var eSkeySig = object.eSkeySig();
        if (eSkeySig != null) {
            protoSize += ProtobufOutputStream.getFieldSize(6, 2);
            protoSize += ProtobufOutputStream.getBytesSize(eSkeySig);
        }
        var buildHash = object.buildHash();
        if (buildHash != null) {
            protoSize += ProtobufOutputStream.getFieldSize(7, 2);
            protoSize += ProtobufOutputStream.getBytesSize(buildHash);
        }
        var companionProps = object.companionProps();
        if (companionProps != null) {
            protoSize += ProtobufOutputStream.getFieldSize(8, 2);
            protoSize += ProtobufOutputStream.getBytesSize(companionProps);
        }
        return protoSize;
    }

}
