package it.auties.whatsapp.model.message.payment;

import it.auties.whatsapp.model.message.payment.CancelPaymentRequestMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class CancelPaymentRequestMessageSpec {
    public static byte[] encode(CancelPaymentRequestMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.message.model.ChatMessageKeySpec.encode(protoInputObject.key()));
        return outputStream.toByteArray();
    }

    public static CancelPaymentRequestMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static CancelPaymentRequestMessage decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.message.model.ChatMessageKey key = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> key = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.payment.CancelPaymentRequestMessage(key);
    }

    public static int sizeOf(CancelPaymentRequestMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var key = object.key();
        if (key != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var keySerializedSize = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.sizeOf(key);
            protoSize += ProtobufOutputStream.getVarIntSize(keySerializedSize);
            protoSize += keySerializedSize;
        }
        return protoSize;
    }

}
