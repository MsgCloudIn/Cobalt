package it.auties.whatsapp.model.message.button;

import it.auties.whatsapp.model.message.button.ListResponseMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ListResponseMessageSpec {
    public static byte[] encode(ListResponseMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.title());
        outputStream.writeInt32(2, it.auties.whatsapp.model.message.button.ListResponseMessageTypeSpec.encode(protoInputObject.listType()));
        outputStream.writeBytes(3, it.auties.whatsapp.model.button.base.SingleSelectReplyButtonSpec.encode(protoInputObject.reply()));
        var contextInfo = protoInputObject.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                outputStream.writeBytes(4, it.auties.whatsapp.model.info.ContextInfoSpec.encode(contextInfo0));
            }
        }
        var description = protoInputObject.description();
        if (description != null) {
            var description0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(description);
            if (description0 != null) {
                outputStream.writeString(5, description0);
            }
        }
        return outputStream.toByteArray();
    }

    public static ListResponseMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ListResponseMessage decode(ProtobufInputStream protoInputStream) {
        java.lang.String title = null;
        it.auties.whatsapp.model.message.button.ListResponseMessage.Type listType = null;
        it.auties.whatsapp.model.button.base.SingleSelectReplyButton reply = null;
        it.auties.whatsapp.model.info.ContextInfo contextInfo = null;
        java.lang.String description = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> title = protoInputStream.readString();
                case 2 -> listType = it.auties.whatsapp.model.message.button.ListResponseMessageTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 3 -> reply = it.auties.whatsapp.model.button.base.SingleSelectReplyButtonSpec.decode(protoInputStream.lengthDelimitedStream());
                case 4 -> contextInfo = it.auties.whatsapp.model.info.ContextInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                case 5 -> description = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.button.ListResponseMessage(title, listType, reply, contextInfo, description);
    }

    public static int sizeOf(ListResponseMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var title = object.title();
        if (title != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(title);
        }
        var listType = object.listType();
        if (listType != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var listTypeSerializedSize = it.auties.whatsapp.model.message.button.ListResponseMessageTypeSpec.sizeOf(listType);
            protoSize += listTypeSerializedSize;
        }
        var reply = object.reply();
        if (reply != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            var replySerializedSize = it.auties.whatsapp.model.button.base.SingleSelectReplyButtonSpec.sizeOf(reply);
            protoSize += ProtobufOutputStream.getVarIntSize(replySerializedSize);
            protoSize += replySerializedSize;
        }
        var contextInfo = object.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                var contextInfo0SerializedSize = it.auties.whatsapp.model.info.ContextInfoSpec.sizeOf(contextInfo0);
                protoSize += ProtobufOutputStream.getVarIntSize(contextInfo0SerializedSize);
                protoSize += contextInfo0SerializedSize;
            }
        }
        var description = object.description();
        if (description != null) {
            var description0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(description);
            if (description0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                protoSize += ProtobufOutputStream.getStringSize(description0);
            }
        }
        return protoSize;
    }

}
