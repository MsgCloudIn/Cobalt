package it.auties.whatsapp.model.info;

import it.auties.whatsapp.model.info.BusinessAccountLinkInfo;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class BusinessAccountLinkInfoSpec {
    public static byte[] encode(BusinessAccountLinkInfo protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeUInt64(1, protoInputObject.businessId());
        outputStream.writeString(2, protoInputObject.phoneNumber());
        outputStream.writeUInt64(3, protoInputObject.issueTimeSeconds());
        outputStream.writeInt32(4, it.auties.whatsapp.model.info.BusinessAccountLinkInfoHostStorageTypeSpec.encode(protoInputObject.hostStorage()));
        outputStream.writeInt32(5, it.auties.whatsapp.model.info.BusinessAccountLinkInfoAccountTypeSpec.encode(protoInputObject.accountType()));
        return outputStream.toByteArray();
    }

    public static BusinessAccountLinkInfo decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static BusinessAccountLinkInfo decode(ProtobufInputStream protoInputStream) {
        long businessId = 0l;
        java.lang.String phoneNumber = null;
        long issueTimeSeconds = 0l;
        it.auties.whatsapp.model.info.BusinessAccountLinkInfo.HostStorageType hostStorage = null;
        it.auties.whatsapp.model.info.BusinessAccountLinkInfo.AccountType accountType = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> businessId = protoInputStream.readInt64();
                case 2 -> phoneNumber = protoInputStream.readString();
                case 3 -> issueTimeSeconds = protoInputStream.readInt64();
                case 4 -> hostStorage = it.auties.whatsapp.model.info.BusinessAccountLinkInfoHostStorageTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 5 -> accountType = it.auties.whatsapp.model.info.BusinessAccountLinkInfoAccountTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.info.BusinessAccountLinkInfo(businessId, phoneNumber, issueTimeSeconds, hostStorage, accountType);
    }

    public static int sizeOf(BusinessAccountLinkInfo object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var businessId = object.businessId();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(businessId);
        var phoneNumber = object.phoneNumber();
        if (phoneNumber != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(phoneNumber);
        }
        var issueTimeSeconds = object.issueTimeSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(issueTimeSeconds);
        var hostStorage = object.hostStorage();
        if (hostStorage != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            var hostStorageSerializedSize = it.auties.whatsapp.model.info.BusinessAccountLinkInfoHostStorageTypeSpec.sizeOf(hostStorage);
            protoSize += hostStorageSerializedSize;
        }
        var accountType = object.accountType();
        if (accountType != null) {
            protoSize += ProtobufOutputStream.getFieldSize(5, 2);
            var accountTypeSerializedSize = it.auties.whatsapp.model.info.BusinessAccountLinkInfoAccountTypeSpec.sizeOf(accountType);
            protoSize += accountTypeSerializedSize;
        }
        return protoSize;
    }

}
