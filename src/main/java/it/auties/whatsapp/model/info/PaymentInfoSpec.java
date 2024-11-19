package it.auties.whatsapp.model.info;

import it.auties.whatsapp.model.info.PaymentInfo;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class PaymentInfoSpec {
    public static byte[] encode(PaymentInfo protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, it.auties.whatsapp.model.info.PaymentInfoCurrencySpec.encode(protoInputObject.currencyDeprecated()));
        outputStream.writeUInt64(2, protoInputObject.amount1000());
        var receiverJid = protoInputObject.receiverJid();
        if (receiverJid != null) {
            var receiverJid0 = receiverJid.toString();
            if (receiverJid0 != null) {
                outputStream.writeString(3, receiverJid0);
            }
        }
        outputStream.writeInt32(4, it.auties.whatsapp.model.info.PaymentInfoStatusSpec.encode(protoInputObject.status()));
        outputStream.writeUInt64(5, protoInputObject.transactionTimestampSeconds());
        outputStream.writeBytes(6, it.auties.whatsapp.model.message.model.ChatMessageKeySpec.encode(protoInputObject.requestMessageKey()));
        outputStream.writeUInt64(7, protoInputObject.expiryTimestampSeconds());
        outputStream.writeBool(8, protoInputObject.futureProofed());
        outputStream.writeString(9, protoInputObject.currency());
        outputStream.writeInt32(10, it.auties.whatsapp.model.info.PaymentInfoTransactionStatusSpec.encode(protoInputObject.transactionStatus()));
        outputStream.writeBool(11, protoInputObject.useNoviFormat());
        outputStream.writeBytes(12, it.auties.whatsapp.model.payment.PaymentMoneySpec.encode(protoInputObject.primaryAmount()));
        outputStream.writeBytes(13, it.auties.whatsapp.model.payment.PaymentMoneySpec.encode(protoInputObject.exchangeAmount()));
        return outputStream.toByteArray();
    }

    public static PaymentInfo decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static PaymentInfo decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.info.PaymentInfo.Currency currencyDeprecated = null;
        long amount1000 = 0l;
        it.auties.whatsapp.model.jid.Jid receiverJid = null;
        it.auties.whatsapp.model.info.PaymentInfo.Status status = null;
        long transactionTimestampSeconds = 0l;
        it.auties.whatsapp.model.message.model.ChatMessageKey requestMessageKey = null;
        long expiryTimestampSeconds = 0l;
        boolean futureProofed = false;
        java.lang.String currency = null;
        it.auties.whatsapp.model.info.PaymentInfo.TransactionStatus transactionStatus = null;
        boolean useNoviFormat = false;
        it.auties.whatsapp.model.payment.PaymentMoney primaryAmount = null;
        it.auties.whatsapp.model.payment.PaymentMoney exchangeAmount = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> currencyDeprecated = it.auties.whatsapp.model.info.PaymentInfoCurrencySpec.decode(protoInputStream.readInt32()).orElse(null);
                case 2 -> amount1000 = protoInputStream.readInt64();
                case 3 -> receiverJid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 4 -> status = it.auties.whatsapp.model.info.PaymentInfoStatusSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 5 -> transactionTimestampSeconds = protoInputStream.readInt64();
                case 6 -> requestMessageKey = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.decode(protoInputStream.lengthDelimitedStream());
                case 7 -> expiryTimestampSeconds = protoInputStream.readInt64();
                case 8 -> futureProofed = protoInputStream.readBool();
                case 9 -> currency = protoInputStream.readString();
                case 10 -> transactionStatus = it.auties.whatsapp.model.info.PaymentInfoTransactionStatusSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 11 -> useNoviFormat = protoInputStream.readBool();
                case 12 -> primaryAmount = it.auties.whatsapp.model.payment.PaymentMoneySpec.decode(protoInputStream.lengthDelimitedStream());
                case 13 -> exchangeAmount = it.auties.whatsapp.model.payment.PaymentMoneySpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.info.PaymentInfo(currencyDeprecated, amount1000, receiverJid, status, transactionTimestampSeconds, requestMessageKey, expiryTimestampSeconds, futureProofed, currency, transactionStatus, useNoviFormat, primaryAmount, exchangeAmount);
    }

    public static int sizeOf(PaymentInfo object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var currencyDeprecated = object.currencyDeprecated();
        if (currencyDeprecated != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var currencyDeprecatedSerializedSize = it.auties.whatsapp.model.info.PaymentInfoCurrencySpec.sizeOf(currencyDeprecated);
            protoSize += currencyDeprecatedSerializedSize;
        }
        var amount1000 = object.amount1000();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(amount1000);
        var receiverJid = object.receiverJid();
        if (receiverJid != null) {
            var receiverJid0 = receiverJid.toString();
            if (receiverJid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                protoSize += ProtobufOutputStream.getStringSize(receiverJid0);
            }
        }
        var status = object.status();
        if (status != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            var statusSerializedSize = it.auties.whatsapp.model.info.PaymentInfoStatusSpec.sizeOf(status);
            protoSize += statusSerializedSize;
        }
        var transactionTimestampSeconds = object.transactionTimestampSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(5, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(transactionTimestampSeconds);
        var requestMessageKey = object.requestMessageKey();
        if (requestMessageKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(6, 2);
            var requestMessageKeySerializedSize = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.sizeOf(requestMessageKey);
            protoSize += ProtobufOutputStream.getVarIntSize(requestMessageKeySerializedSize);
            protoSize += requestMessageKeySerializedSize;
        }
        var expiryTimestampSeconds = object.expiryTimestampSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(7, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(expiryTimestampSeconds);
        var futureProofed = object.futureProofed();
        protoSize += ProtobufOutputStream.getFieldSize(8, 0);
        protoSize += 1;
        var currency = object.currency();
        if (currency != null) {
            protoSize += ProtobufOutputStream.getFieldSize(9, 2);
            protoSize += ProtobufOutputStream.getStringSize(currency);
        }
        var transactionStatus = object.transactionStatus();
        if (transactionStatus != null) {
            protoSize += ProtobufOutputStream.getFieldSize(10, 2);
            var transactionStatusSerializedSize = it.auties.whatsapp.model.info.PaymentInfoTransactionStatusSpec.sizeOf(transactionStatus);
            protoSize += transactionStatusSerializedSize;
        }
        var useNoviFormat = object.useNoviFormat();
        protoSize += ProtobufOutputStream.getFieldSize(11, 0);
        protoSize += 1;
        var primaryAmount = object.primaryAmount();
        if (primaryAmount != null) {
            protoSize += ProtobufOutputStream.getFieldSize(12, 2);
            var primaryAmountSerializedSize = it.auties.whatsapp.model.payment.PaymentMoneySpec.sizeOf(primaryAmount);
            protoSize += ProtobufOutputStream.getVarIntSize(primaryAmountSerializedSize);
            protoSize += primaryAmountSerializedSize;
        }
        var exchangeAmount = object.exchangeAmount();
        if (exchangeAmount != null) {
            protoSize += ProtobufOutputStream.getFieldSize(13, 2);
            var exchangeAmountSerializedSize = it.auties.whatsapp.model.payment.PaymentMoneySpec.sizeOf(exchangeAmount);
            protoSize += ProtobufOutputStream.getVarIntSize(exchangeAmountSerializedSize);
            protoSize += exchangeAmountSerializedSize;
        }
        return protoSize;
    }

}
