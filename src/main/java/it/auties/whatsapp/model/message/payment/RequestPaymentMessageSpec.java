package it.auties.whatsapp.model.message.payment;

import it.auties.whatsapp.model.message.payment.RequestPaymentMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class RequestPaymentMessageSpec {
    public static byte[] encode(RequestPaymentMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.currency());
        outputStream.writeUInt64(2, protoInputObject.amount1000());
        var requestFrom = protoInputObject.requestFrom();
        if (requestFrom != null) {
            var requestFrom0 = requestFrom.toString();
            if (requestFrom0 != null) {
                outputStream.writeString(3, requestFrom0);
            }
        }
        var noteMessage = protoInputObject.noteMessage();
        if (noteMessage != null) {
            var noteMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(noteMessage);
            if (noteMessage0 != null) {
                outputStream.writeBytes(4, it.auties.whatsapp.model.message.model.MessageContainerSpec.encode(noteMessage0));
            }
        }
        outputStream.writeUInt64(5, protoInputObject.expiryTimestampSeconds());
        outputStream.writeBytes(6, it.auties.whatsapp.model.payment.PaymentMoneySpec.encode(protoInputObject.amount()));
        var background = protoInputObject.background();
        if (background != null) {
            var background0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(background);
            if (background0 != null) {
                outputStream.writeBytes(7, it.auties.whatsapp.model.payment.PaymentBackgroundSpec.encode(background0));
            }
        }
        return outputStream.toByteArray();
    }

    public static RequestPaymentMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static RequestPaymentMessage decode(ProtobufInputStream protoInputStream) {
        java.lang.String currency = null;
        long amount1000 = 0l;
        it.auties.whatsapp.model.jid.Jid requestFrom = null;
        java.util.Optional<it.auties.whatsapp.model.message.model.MessageContainer> noteMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        long expiryTimestampSeconds = 0l;
        it.auties.whatsapp.model.payment.PaymentMoney amount = null;
        java.util.Optional<it.auties.whatsapp.model.payment.PaymentBackground> background = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> currency = protoInputStream.readString();
                case 2 -> amount1000 = protoInputStream.readInt64();
                case 3 -> requestFrom = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 4 -> noteMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.model.MessageContainerSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 5 -> expiryTimestampSeconds = protoInputStream.readInt64();
                case 6 -> amount = it.auties.whatsapp.model.payment.PaymentMoneySpec.decode(protoInputStream.lengthDelimitedStream());
                case 7 -> background = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.payment.PaymentBackgroundSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.payment.RequestPaymentMessage(currency, amount1000, requestFrom, noteMessage, expiryTimestampSeconds, amount, background);
    }

    public static int sizeOf(RequestPaymentMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var currency = object.currency();
        if (currency != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(currency);
        }
        var amount1000 = object.amount1000();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(amount1000);
        var requestFrom = object.requestFrom();
        if (requestFrom != null) {
            var requestFrom0 = requestFrom.toString();
            if (requestFrom0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                protoSize += ProtobufOutputStream.getStringSize(requestFrom0);
            }
        }
        var noteMessage = object.noteMessage();
        if (noteMessage != null) {
            var noteMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(noteMessage);
            if (noteMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                var noteMessage0SerializedSize = it.auties.whatsapp.model.message.model.MessageContainerSpec.sizeOf(noteMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(noteMessage0SerializedSize);
                protoSize += noteMessage0SerializedSize;
            }
        }
        var expiryTimestampSeconds = object.expiryTimestampSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(5, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(expiryTimestampSeconds);
        var amount = object.amount();
        if (amount != null) {
            protoSize += ProtobufOutputStream.getFieldSize(6, 2);
            var amountSerializedSize = it.auties.whatsapp.model.payment.PaymentMoneySpec.sizeOf(amount);
            protoSize += ProtobufOutputStream.getVarIntSize(amountSerializedSize);
            protoSize += amountSerializedSize;
        }
        var background = object.background();
        if (background != null) {
            var background0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(background);
            if (background0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(7, 2);
                var background0SerializedSize = it.auties.whatsapp.model.payment.PaymentBackgroundSpec.sizeOf(background0);
                protoSize += ProtobufOutputStream.getVarIntSize(background0SerializedSize);
                protoSize += background0SerializedSize;
            }
        }
        return protoSize;
    }

}
