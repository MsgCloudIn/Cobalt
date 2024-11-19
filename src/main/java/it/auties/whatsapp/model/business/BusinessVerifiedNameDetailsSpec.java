package it.auties.whatsapp.model.business;

import it.auties.whatsapp.model.business.BusinessVerifiedNameDetails;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class BusinessVerifiedNameDetailsSpec {
    public static byte[] encode(BusinessVerifiedNameDetails protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeUInt64(1, protoInputObject.serial());
        outputStream.writeString(2, protoInputObject.issuer());
        outputStream.writeString(4, protoInputObject.name());
        if (protoInputObject.localizedNames() != null) {
            for (var localizedNamesEntry : protoInputObject.localizedNames()) { 
                outputStream.writeBytes(8, it.auties.whatsapp.model.business.BusinessLocalizedNameSpec.encode(localizedNamesEntry));
            }
        }
        outputStream.writeUInt64(10, protoInputObject.issueTimeSeconds());
        return outputStream.toByteArray();
    }

    public static BusinessVerifiedNameDetails decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static BusinessVerifiedNameDetails decode(ProtobufInputStream protoInputStream) {
        long serial = 0l;
        java.lang.String issuer = null;
        java.lang.String name = null;
        java.util.List<it.auties.whatsapp.model.business.BusinessLocalizedName> localizedNames = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        long issueTimeSeconds = 0l;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> serial = protoInputStream.readInt64();
                case 2 -> issuer = protoInputStream.readString();
                case 4 -> name = protoInputStream.readString();
                case 8 -> localizedNames.add(it.auties.whatsapp.model.business.BusinessLocalizedNameSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 10 -> issueTimeSeconds = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.business.BusinessVerifiedNameDetails(serial, issuer, name, localizedNames, issueTimeSeconds);
    }

    public static int sizeOf(BusinessVerifiedNameDetails object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var serial = object.serial();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(serial);
        var issuer = object.issuer();
        if (issuer != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(issuer);
        }
        var name = object.name();
        if (name != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            protoSize += ProtobufOutputStream.getStringSize(name);
        }
        var localizedNamesRepeatedField = object.localizedNames();
        if (localizedNamesRepeatedField != null) {
            for (var localizedNamesEntry : localizedNamesRepeatedField) { 
                if (localizedNamesEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(8, 2);
                    var localizedNamesEntrySerializedSize = it.auties.whatsapp.model.business.BusinessLocalizedNameSpec.sizeOf(localizedNamesEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(localizedNamesEntrySerializedSize);
                    protoSize += localizedNamesEntrySerializedSize;
                }
            }
        }
        var issueTimeSeconds = object.issueTimeSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(10, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(issueTimeSeconds);
        return protoSize;
    }

}
