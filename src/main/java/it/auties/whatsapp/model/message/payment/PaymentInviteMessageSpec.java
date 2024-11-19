package it.auties.whatsapp.model.message.payment;

import it.auties.whatsapp.model.message.payment.PaymentInviteMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class PaymentInviteMessageSpec {
    public static byte[] encode(PaymentInviteMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, it.auties.whatsapp.model.message.payment.PaymentInviteMessageServiceTypeSpec.encode(protoInputObject.serviceType()));
        var expiryTimestamp = protoInputObject.expiryTimestamp();
        if (expiryTimestamp != null) {
            var expiryTimestamp0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(expiryTimestamp);
            if (expiryTimestamp0 != null) {
                outputStream.writeUInt64(2, expiryTimestamp0);
            }
        }
        return outputStream.toByteArray();
    }

    public static PaymentInviteMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static PaymentInviteMessage decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.message.payment.PaymentInviteMessage.ServiceType serviceType = null;
        java.util.OptionalLong expiryTimestamp = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptionalLong();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> serviceType = it.auties.whatsapp.model.message.payment.PaymentInviteMessageServiceTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 2 -> expiryTimestamp = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readInt64());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.payment.PaymentInviteMessage(serviceType, expiryTimestamp);
    }

    public static int sizeOf(PaymentInviteMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var serviceType = object.serviceType();
        if (serviceType != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var serviceTypeSerializedSize = it.auties.whatsapp.model.message.payment.PaymentInviteMessageServiceTypeSpec.sizeOf(serviceType);
            protoSize += serviceTypeSerializedSize;
        }
        var expiryTimestamp = object.expiryTimestamp();
        if (expiryTimestamp != null) {
            var expiryTimestamp0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(expiryTimestamp);
            if (expiryTimestamp0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(expiryTimestamp0);
            }
        }
        return protoSize;
    }

}
