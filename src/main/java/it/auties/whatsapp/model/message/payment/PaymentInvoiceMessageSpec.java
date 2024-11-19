package it.auties.whatsapp.model.message.payment;

import it.auties.whatsapp.model.message.payment.PaymentInvoiceMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class PaymentInvoiceMessageSpec {
    public static byte[] encode(PaymentInvoiceMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var note = protoInputObject.note();
        if (note != null) {
            var note0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(note);
            if (note0 != null) {
                outputStream.writeString(1, note0);
            }
        }
        outputStream.writeString(2, protoInputObject.token());
        var paymentAttachmentType = protoInputObject.paymentAttachmentType();
        if (paymentAttachmentType != null) {
            var paymentAttachmentType0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(paymentAttachmentType);
            if (paymentAttachmentType0 != null) {
                outputStream.writeInt32(3, it.auties.whatsapp.model.message.payment.PaymentInvoiceMessagePaymentAttachmentTypeSpec.encode(paymentAttachmentType0));
            }
        }
        var mimeType = protoInputObject.mimeType();
        if (mimeType != null) {
            var mimeType0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mimeType);
            if (mimeType0 != null) {
                outputStream.writeString(4, mimeType0);
            }
        }
        var mediaKey = protoInputObject.mediaKey();
        if (mediaKey != null) {
            var mediaKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaKey);
            if (mediaKey0 != null) {
                outputStream.writeBytes(5, mediaKey0);
            }
        }
        var mediaKeyTimestampSeconds = protoInputObject.mediaKeyTimestampSeconds();
        if (mediaKeyTimestampSeconds != null) {
            var mediaKeyTimestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(mediaKeyTimestampSeconds);
            if (mediaKeyTimestampSeconds0 != null) {
                outputStream.writeUInt64(6, mediaKeyTimestampSeconds0);
            }
        }
        var mediaSha256 = protoInputObject.mediaSha256();
        if (mediaSha256 != null) {
            var mediaSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaSha256);
            if (mediaSha2560 != null) {
                outputStream.writeBytes(7, mediaSha2560);
            }
        }
        var mediaEncryptedSha256 = protoInputObject.mediaEncryptedSha256();
        if (mediaEncryptedSha256 != null) {
            var mediaEncryptedSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaEncryptedSha256);
            if (mediaEncryptedSha2560 != null) {
                outputStream.writeBytes(8, mediaEncryptedSha2560);
            }
        }
        var mediaDirectPath = protoInputObject.mediaDirectPath();
        if (mediaDirectPath != null) {
            var mediaDirectPath0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaDirectPath);
            if (mediaDirectPath0 != null) {
                outputStream.writeString(9, mediaDirectPath0);
            }
        }
        var thumbnail = protoInputObject.thumbnail();
        if (thumbnail != null) {
            var thumbnail0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnail);
            if (thumbnail0 != null) {
                outputStream.writeBytes(10, thumbnail0);
            }
        }
        var contextInfo = protoInputObject.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                outputStream.writeBytes(17, it.auties.whatsapp.model.info.ContextInfoSpec.encode(contextInfo0));
            }
        }
        return outputStream.toByteArray();
    }

    public static PaymentInvoiceMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static PaymentInvoiceMessage decode(ProtobufInputStream protoInputStream) {
        java.lang.String note = null;
        java.lang.String token = null;
        it.auties.whatsapp.model.message.payment.PaymentInvoiceMessage.PaymentAttachmentType paymentAttachmentType = null;
        java.lang.String mimeType = null;
        byte[] mediaKey = null;
        java.lang.Long mediaKeyTimestampSeconds = null;
        byte[] mediaSha256 = null;
        byte[] mediaEncryptedSha256 = null;
        java.lang.String mediaDirectPath = null;
        byte[] thumbnail = null;
        it.auties.whatsapp.model.info.ContextInfo contextInfo = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> note = protoInputStream.readString();
                case 2 -> token = protoInputStream.readString();
                case 3 -> paymentAttachmentType = it.auties.whatsapp.model.message.payment.PaymentInvoiceMessagePaymentAttachmentTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 4 -> mimeType = protoInputStream.readString();
                case 5 -> mediaKey = protoInputStream.readBytes();
                case 6 -> mediaKeyTimestampSeconds = protoInputStream.readInt64();
                case 7 -> mediaSha256 = protoInputStream.readBytes();
                case 8 -> mediaEncryptedSha256 = protoInputStream.readBytes();
                case 9 -> mediaDirectPath = protoInputStream.readString();
                case 10 -> thumbnail = protoInputStream.readBytes();
                case 17 -> contextInfo = it.auties.whatsapp.model.info.ContextInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.payment.PaymentInvoiceMessage(note, token, paymentAttachmentType, mimeType, mediaKey, mediaKeyTimestampSeconds, mediaSha256, mediaEncryptedSha256, mediaDirectPath, thumbnail, contextInfo);
    }

    public static int sizeOf(PaymentInvoiceMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var note = object.note();
        if (note != null) {
            var note0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(note);
            if (note0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(note0);
            }
        }
        var token = object.token();
        if (token != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(token);
        }
        var paymentAttachmentType = object.paymentAttachmentType();
        if (paymentAttachmentType != null) {
            var paymentAttachmentType0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(paymentAttachmentType);
            if (paymentAttachmentType0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                var paymentAttachmentType0SerializedSize = it.auties.whatsapp.model.message.payment.PaymentInvoiceMessagePaymentAttachmentTypeSpec.sizeOf(paymentAttachmentType0);
                protoSize += paymentAttachmentType0SerializedSize;
            }
        }
        var mimeType = object.mimeType();
        if (mimeType != null) {
            var mimeType0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mimeType);
            if (mimeType0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                protoSize += ProtobufOutputStream.getStringSize(mimeType0);
            }
        }
        var mediaKey = object.mediaKey();
        if (mediaKey != null) {
            var mediaKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaKey);
            if (mediaKey0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                protoSize += ProtobufOutputStream.getBytesSize(mediaKey0);
            }
        }
        var mediaKeyTimestampSeconds = object.mediaKeyTimestampSeconds();
        if (mediaKeyTimestampSeconds != null) {
            var mediaKeyTimestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(mediaKeyTimestampSeconds);
            if (mediaKeyTimestampSeconds0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(6, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(mediaKeyTimestampSeconds0);
            }
        }
        var mediaSha256 = object.mediaSha256();
        if (mediaSha256 != null) {
            var mediaSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaSha256);
            if (mediaSha2560 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(7, 2);
                protoSize += ProtobufOutputStream.getBytesSize(mediaSha2560);
            }
        }
        var mediaEncryptedSha256 = object.mediaEncryptedSha256();
        if (mediaEncryptedSha256 != null) {
            var mediaEncryptedSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaEncryptedSha256);
            if (mediaEncryptedSha2560 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(8, 2);
                protoSize += ProtobufOutputStream.getBytesSize(mediaEncryptedSha2560);
            }
        }
        var mediaDirectPath = object.mediaDirectPath();
        if (mediaDirectPath != null) {
            var mediaDirectPath0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaDirectPath);
            if (mediaDirectPath0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(9, 2);
                protoSize += ProtobufOutputStream.getStringSize(mediaDirectPath0);
            }
        }
        var thumbnail = object.thumbnail();
        if (thumbnail != null) {
            var thumbnail0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnail);
            if (thumbnail0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(10, 2);
                protoSize += ProtobufOutputStream.getBytesSize(thumbnail0);
            }
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
