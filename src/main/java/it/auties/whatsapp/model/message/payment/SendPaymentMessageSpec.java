package it.auties.whatsapp.model.message.payment;

import it.auties.whatsapp.model.message.payment.SendPaymentMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SendPaymentMessageSpec {
    public static byte[] encode(SendPaymentMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var noteMessage = protoInputObject.noteMessage();
        if (noteMessage != null) {
            var noteMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(noteMessage);
            if (noteMessage0 != null) {
                outputStream.writeBytes(2, it.auties.whatsapp.model.message.model.MessageContainerSpec.encode(noteMessage0));
            }
        }
        outputStream.writeBytes(3, it.auties.whatsapp.model.message.model.ChatMessageKeySpec.encode(protoInputObject.requestMessageKey()));
        var background = protoInputObject.background();
        if (background != null) {
            var background0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(background);
            if (background0 != null) {
                outputStream.writeBytes(4, it.auties.whatsapp.model.payment.PaymentBackgroundSpec.encode(background0));
            }
        }
        return outputStream.toByteArray();
    }

    public static SendPaymentMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SendPaymentMessage decode(ProtobufInputStream protoInputStream) {
        java.util.Optional<it.auties.whatsapp.model.message.model.MessageContainer> noteMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        it.auties.whatsapp.model.message.model.ChatMessageKey requestMessageKey = null;
        java.util.Optional<it.auties.whatsapp.model.payment.PaymentBackground> background = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 2 -> noteMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.model.MessageContainerSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 3 -> requestMessageKey = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.decode(protoInputStream.lengthDelimitedStream());
                case 4 -> background = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.payment.PaymentBackgroundSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.payment.SendPaymentMessage(noteMessage, requestMessageKey, background);
    }

    public static int sizeOf(SendPaymentMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var noteMessage = object.noteMessage();
        if (noteMessage != null) {
            var noteMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(noteMessage);
            if (noteMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                var noteMessage0SerializedSize = it.auties.whatsapp.model.message.model.MessageContainerSpec.sizeOf(noteMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(noteMessage0SerializedSize);
                protoSize += noteMessage0SerializedSize;
            }
        }
        var requestMessageKey = object.requestMessageKey();
        if (requestMessageKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            var requestMessageKeySerializedSize = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.sizeOf(requestMessageKey);
            protoSize += ProtobufOutputStream.getVarIntSize(requestMessageKeySerializedSize);
            protoSize += requestMessageKeySerializedSize;
        }
        var background = object.background();
        if (background != null) {
            var background0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(background);
            if (background0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                var background0SerializedSize = it.auties.whatsapp.model.payment.PaymentBackgroundSpec.sizeOf(background0);
                protoSize += ProtobufOutputStream.getVarIntSize(background0SerializedSize);
                protoSize += background0SerializedSize;
            }
        }
        return protoSize;
    }

}
