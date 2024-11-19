package it.auties.whatsapp.model.message.standard;

import it.auties.whatsapp.model.message.standard.GroupInviteMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class GroupInviteMessageSpec {
    public static byte[] encode(GroupInviteMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var group = protoInputObject.group();
        if (group != null) {
            var group0 = group.toString();
            if (group0 != null) {
                outputStream.writeString(1, group0);
            }
        }
        outputStream.writeString(2, protoInputObject.code());
        outputStream.writeUInt64(3, protoInputObject.expirationSeconds());
        outputStream.writeString(4, protoInputObject.groupName());
        var thumbnail = protoInputObject.thumbnail();
        if (thumbnail != null) {
            var thumbnail0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnail);
            if (thumbnail0 != null) {
                outputStream.writeBytes(5, thumbnail0);
            }
        }
        var caption = protoInputObject.caption();
        if (caption != null) {
            var caption0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(caption);
            if (caption0 != null) {
                outputStream.writeString(6, caption0);
            }
        }
        var contextInfo = protoInputObject.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                outputStream.writeBytes(7, it.auties.whatsapp.model.info.ContextInfoSpec.encode(contextInfo0));
            }
        }
        outputStream.writeInt32(8, it.auties.whatsapp.model.message.standard.GroupInviteMessageTypeSpec.encode(protoInputObject.groupType()));
        return outputStream.toByteArray();
    }

    public static GroupInviteMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static GroupInviteMessage decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.jid.Jid group = null;
        java.lang.String code = null;
        long expirationSeconds = 0l;
        java.lang.String groupName = null;
        byte[] thumbnail = null;
        java.lang.String caption = null;
        it.auties.whatsapp.model.info.ContextInfo contextInfo = null;
        it.auties.whatsapp.model.message.standard.GroupInviteMessage.Type groupType = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> group = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 2 -> code = protoInputStream.readString();
                case 3 -> expirationSeconds = protoInputStream.readInt64();
                case 4 -> groupName = protoInputStream.readString();
                case 5 -> thumbnail = protoInputStream.readBytes();
                case 6 -> caption = protoInputStream.readString();
                case 7 -> contextInfo = it.auties.whatsapp.model.info.ContextInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                case 8 -> groupType = it.auties.whatsapp.model.message.standard.GroupInviteMessageTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.standard.GroupInviteMessage(group, code, expirationSeconds, groupName, thumbnail, caption, contextInfo, groupType);
    }

    public static int sizeOf(GroupInviteMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var group = object.group();
        if (group != null) {
            var group0 = group.toString();
            if (group0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(group0);
            }
        }
        var code = object.code();
        if (code != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(code);
        }
        var expirationSeconds = object.expirationSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(expirationSeconds);
        var groupName = object.groupName();
        if (groupName != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            protoSize += ProtobufOutputStream.getStringSize(groupName);
        }
        var thumbnail = object.thumbnail();
        if (thumbnail != null) {
            var thumbnail0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnail);
            if (thumbnail0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                protoSize += ProtobufOutputStream.getBytesSize(thumbnail0);
            }
        }
        var caption = object.caption();
        if (caption != null) {
            var caption0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(caption);
            if (caption0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(6, 2);
                protoSize += ProtobufOutputStream.getStringSize(caption0);
            }
        }
        var contextInfo = object.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(7, 2);
                var contextInfo0SerializedSize = it.auties.whatsapp.model.info.ContextInfoSpec.sizeOf(contextInfo0);
                protoSize += ProtobufOutputStream.getVarIntSize(contextInfo0SerializedSize);
                protoSize += contextInfo0SerializedSize;
            }
        }
        var groupType = object.groupType();
        if (groupType != null) {
            protoSize += ProtobufOutputStream.getFieldSize(8, 2);
            var groupTypeSerializedSize = it.auties.whatsapp.model.message.standard.GroupInviteMessageTypeSpec.sizeOf(groupType);
            protoSize += groupTypeSerializedSize;
        }
        return protoSize;
    }

}
