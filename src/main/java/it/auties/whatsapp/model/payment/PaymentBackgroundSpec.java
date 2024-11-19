package it.auties.whatsapp.model.payment;

import it.auties.whatsapp.model.payment.PaymentBackground;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class PaymentBackgroundSpec {
    public static byte[] encode(PaymentBackground protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.id());
        outputStream.writeUInt64(2, protoInputObject.mediaSize());
        outputStream.writeUInt32(3, protoInputObject.width());
        outputStream.writeUInt32(4, protoInputObject.height());
        outputStream.writeString(5, protoInputObject.mimetype());
        outputStream.writeFixed32(6, protoInputObject.placeholderArgb());
        outputStream.writeFixed32(7, protoInputObject.textArgb());
        outputStream.writeFixed32(8, protoInputObject.subtextArgb());
        var mediaData = protoInputObject.mediaData();
        if (mediaData != null) {
            var mediaData0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaData);
            if (mediaData0 != null) {
                outputStream.writeBytes(9, it.auties.whatsapp.model.payment.PaymentMediaDataSpec.encode(mediaData0));
            }
        }
        outputStream.writeInt32(10, it.auties.whatsapp.model.payment.PaymentBackgroundPaymentBackgroundTypeSpec.encode(protoInputObject.type()));
        return outputStream.toByteArray();
    }

    public static PaymentBackground decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static PaymentBackground decode(ProtobufInputStream protoInputStream) {
        java.lang.String id = null;
        long mediaSize = 0l;
        int width = 0;
        int height = 0;
        java.lang.String mimetype = null;
        int placeholderArgb = 0;
        int textArgb = 0;
        int subtextArgb = 0;
        java.util.Optional<it.auties.whatsapp.model.payment.PaymentMediaData> mediaData = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        it.auties.whatsapp.model.payment.PaymentBackground.PaymentBackgroundType type = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> id = protoInputStream.readString();
                case 2 -> mediaSize = protoInputStream.readInt64();
                case 3 -> width = protoInputStream.readInt32();
                case 4 -> height = protoInputStream.readInt32();
                case 5 -> mimetype = protoInputStream.readString();
                case 6 -> placeholderArgb = protoInputStream.readFixed32();
                case 7 -> textArgb = protoInputStream.readFixed32();
                case 8 -> subtextArgb = protoInputStream.readFixed32();
                case 9 -> mediaData = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.payment.PaymentMediaDataSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 10 -> type = it.auties.whatsapp.model.payment.PaymentBackgroundPaymentBackgroundTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.payment.PaymentBackground(id, mediaSize, width, height, mimetype, placeholderArgb, textArgb, subtextArgb, mediaData, type);
    }

    public static int sizeOf(PaymentBackground object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var id = object.id();
        if (id != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(id);
        }
        var mediaSize = object.mediaSize();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(mediaSize);
        var width = object.width();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(width);
        var height = object.height();
        protoSize += ProtobufOutputStream.getFieldSize(4, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(height);
        var mimetype = object.mimetype();
        if (mimetype != null) {
            protoSize += ProtobufOutputStream.getFieldSize(5, 2);
            protoSize += ProtobufOutputStream.getStringSize(mimetype);
        }
        var placeholderArgb = object.placeholderArgb();
        protoSize += ProtobufOutputStream.getFieldSize(6, 5);
        protoSize += 4;
        var textArgb = object.textArgb();
        protoSize += ProtobufOutputStream.getFieldSize(7, 5);
        protoSize += 4;
        var subtextArgb = object.subtextArgb();
        protoSize += ProtobufOutputStream.getFieldSize(8, 5);
        protoSize += 4;
        var mediaData = object.mediaData();
        if (mediaData != null) {
            var mediaData0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaData);
            if (mediaData0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(9, 2);
                var mediaData0SerializedSize = it.auties.whatsapp.model.payment.PaymentMediaDataSpec.sizeOf(mediaData0);
                protoSize += ProtobufOutputStream.getVarIntSize(mediaData0SerializedSize);
                protoSize += mediaData0SerializedSize;
            }
        }
        var type = object.type();
        if (type != null) {
            protoSize += ProtobufOutputStream.getFieldSize(10, 2);
            var typeSerializedSize = it.auties.whatsapp.model.payment.PaymentBackgroundPaymentBackgroundTypeSpec.sizeOf(type);
            protoSize += typeSerializedSize;
        }
        return protoSize;
    }

}
