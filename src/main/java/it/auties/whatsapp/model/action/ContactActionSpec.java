package it.auties.whatsapp.model.action;

import it.auties.whatsapp.model.action.ContactAction;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ContactActionSpec {
    public static byte[] encode(ContactAction protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var fullName = protoInputObject.fullName();
        if (fullName != null) {
            var fullName0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(fullName);
            if (fullName0 != null) {
                outputStream.writeString(1, fullName0);
            }
        }
        var firstName = protoInputObject.firstName();
        if (firstName != null) {
            var firstName0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(firstName);
            if (firstName0 != null) {
                outputStream.writeString(2, firstName0);
            }
        }
        var lidJid = protoInputObject.lidJid();
        if (lidJid != null) {
            var lidJid0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(lidJid);
            if (lidJid0 != null) {
                outputStream.writeString(3, lidJid0);
            }
        }
        return outputStream.toByteArray();
    }

    public static ContactAction decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ContactAction decode(ProtobufInputStream protoInputStream) {
        java.util.Optional<java.lang.String> fullName = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> firstName = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> lidJid = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> fullName = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 2 -> firstName = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 3 -> lidJid = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.action.ContactAction(fullName, firstName, lidJid);
    }

    public static int sizeOf(ContactAction object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var fullName = object.fullName();
        if (fullName != null) {
            var fullName0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(fullName);
            if (fullName0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(fullName0);
            }
        }
        var firstName = object.firstName();
        if (firstName != null) {
            var firstName0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(firstName);
            if (firstName0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                protoSize += ProtobufOutputStream.getStringSize(firstName0);
            }
        }
        var lidJid = object.lidJid();
        if (lidJid != null) {
            var lidJid0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(lidJid);
            if (lidJid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                protoSize += ProtobufOutputStream.getStringSize(lidJid0);
            }
        }
        return protoSize;
    }

}
