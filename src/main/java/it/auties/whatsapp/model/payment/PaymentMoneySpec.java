package it.auties.whatsapp.model.payment;

import it.auties.whatsapp.model.payment.PaymentMoney;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class PaymentMoneySpec {
    public static byte[] encode(PaymentMoney protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt64(1, protoInputObject.money());
        outputStream.writeUInt32(2, protoInputObject.offset());
        outputStream.writeString(3, protoInputObject.currencyCode());
        return outputStream.toByteArray();
    }

    public static PaymentMoney decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static PaymentMoney decode(ProtobufInputStream protoInputStream) {
        long money = 0l;
        int offset = 0;
        java.lang.String currencyCode = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> money = protoInputStream.readInt64();
                case 2 -> offset = protoInputStream.readInt32();
                case 3 -> currencyCode = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.payment.PaymentMoney(money, offset, currencyCode);
    }

    public static int sizeOf(PaymentMoney object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var money = object.money();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(money);
        var offset = object.offset();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(offset);
        var currencyCode = object.currencyCode();
        if (currencyCode != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getStringSize(currencyCode);
        }
        return protoSize;
    }

}
