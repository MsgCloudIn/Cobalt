package it.auties.whatsapp.model.message.payment;

import it.auties.whatsapp.model.message.payment.PaymentOrderMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class PaymentOrderMessageSpec {
    public static byte[] encode(PaymentOrderMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.id());
        var thumbnail = protoInputObject.thumbnail();
        if (thumbnail != null) {
            var thumbnail0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnail);
            if (thumbnail0 != null) {
                outputStream.writeBytes(2, thumbnail0);
            }
        }
        outputStream.writeUInt32(3, protoInputObject.itemCount());
        outputStream.writeInt32(4, it.auties.whatsapp.model.message.payment.PaymentOrderMessageStatusSpec.encode(protoInputObject.status()));
        outputStream.writeInt32(5, it.auties.whatsapp.model.message.payment.PaymentOrderMessagePaymentOrderSurfaceSpec.encode(protoInputObject.surface()));
        var message = protoInputObject.message();
        if (message != null) {
            var message0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(message);
            if (message0 != null) {
                outputStream.writeString(6, message0);
            }
        }
        var title = protoInputObject.title();
        if (title != null) {
            var title0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(title);
            if (title0 != null) {
                outputStream.writeString(7, title0);
            }
        }
        var sellerId = protoInputObject.sellerId();
        if (sellerId != null) {
            var sellerId0 = sellerId.toString();
            if (sellerId0 != null) {
                outputStream.writeString(8, sellerId0);
            }
        }
        outputStream.writeString(9, protoInputObject.token());
        outputStream.writeUInt64(10, protoInputObject.amount());
        outputStream.writeString(11, protoInputObject.currency());
        var contextInfo = protoInputObject.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                outputStream.writeBytes(17, it.auties.whatsapp.model.info.ContextInfoSpec.encode(contextInfo0));
            }
        }
        return outputStream.toByteArray();
    }

    public static PaymentOrderMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static PaymentOrderMessage decode(ProtobufInputStream protoInputStream) {
        java.lang.String id = null;
        byte[] thumbnail = null;
        int itemCount = 0;
        it.auties.whatsapp.model.message.payment.PaymentOrderMessage.Status status = null;
        it.auties.whatsapp.model.message.payment.PaymentOrderMessage.PaymentOrderSurface surface = null;
        java.lang.String message = null;
        java.lang.String title = null;
        it.auties.whatsapp.model.jid.Jid sellerId = null;
        java.lang.String token = null;
        long amount = 0l;
        java.lang.String currency = null;
        it.auties.whatsapp.model.info.ContextInfo contextInfo = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> id = protoInputStream.readString();
                case 2 -> thumbnail = protoInputStream.readBytes();
                case 3 -> itemCount = protoInputStream.readInt32();
                case 4 -> status = it.auties.whatsapp.model.message.payment.PaymentOrderMessageStatusSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 5 -> surface = it.auties.whatsapp.model.message.payment.PaymentOrderMessagePaymentOrderSurfaceSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 6 -> message = protoInputStream.readString();
                case 7 -> title = protoInputStream.readString();
                case 8 -> sellerId = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 9 -> token = protoInputStream.readString();
                case 10 -> amount = protoInputStream.readInt64();
                case 11 -> currency = protoInputStream.readString();
                case 17 -> contextInfo = it.auties.whatsapp.model.info.ContextInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.payment.PaymentOrderMessage(id, thumbnail, itemCount, status, surface, message, title, sellerId, token, amount, currency, contextInfo);
    }

    public static int sizeOf(PaymentOrderMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var id = object.id();
        if (id != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(id);
        }
        var thumbnail = object.thumbnail();
        if (thumbnail != null) {
            var thumbnail0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnail);
            if (thumbnail0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                protoSize += ProtobufOutputStream.getBytesSize(thumbnail0);
            }
        }
        var itemCount = object.itemCount();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(itemCount);
        var status = object.status();
        if (status != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            var statusSerializedSize = it.auties.whatsapp.model.message.payment.PaymentOrderMessageStatusSpec.sizeOf(status);
            protoSize += statusSerializedSize;
        }
        var surface = object.surface();
        if (surface != null) {
            protoSize += ProtobufOutputStream.getFieldSize(5, 2);
            var surfaceSerializedSize = it.auties.whatsapp.model.message.payment.PaymentOrderMessagePaymentOrderSurfaceSpec.sizeOf(surface);
            protoSize += surfaceSerializedSize;
        }
        var message = object.message();
        if (message != null) {
            var message0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(message);
            if (message0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(6, 2);
                protoSize += ProtobufOutputStream.getStringSize(message0);
            }
        }
        var title = object.title();
        if (title != null) {
            var title0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(title);
            if (title0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(7, 2);
                protoSize += ProtobufOutputStream.getStringSize(title0);
            }
        }
        var sellerId = object.sellerId();
        if (sellerId != null) {
            var sellerId0 = sellerId.toString();
            if (sellerId0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(8, 2);
                protoSize += ProtobufOutputStream.getStringSize(sellerId0);
            }
        }
        var token = object.token();
        if (token != null) {
            protoSize += ProtobufOutputStream.getFieldSize(9, 2);
            protoSize += ProtobufOutputStream.getStringSize(token);
        }
        var amount = object.amount();
        protoSize += ProtobufOutputStream.getFieldSize(10, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(amount);
        var currency = object.currency();
        if (currency != null) {
            protoSize += ProtobufOutputStream.getFieldSize(11, 2);
            protoSize += ProtobufOutputStream.getStringSize(currency);
        }
        var contextInfo = object.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(17, 2);
                var contextInfo0SerializedSize = it.auties.whatsapp.model.info.ContextInfoSpec.sizeOf(contextInfo0);
                protoSize += ProtobufOutputStream.getVarIntSize(contextInfo0SerializedSize);
                protoSize += contextInfo0SerializedSize;
            }
        }
        return protoSize;
    }

}
