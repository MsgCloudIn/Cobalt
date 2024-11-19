package it.auties.whatsapp.model.contact;

import it.auties.whatsapp.model.contact.Contact;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ContactSpec {
    public static byte[] encode(Contact protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var jid = protoInputObject.jid();
        if (jid != null) {
            var jid0 = jid.toString();
            if (jid0 != null) {
                outputStream.writeString(1, jid0);
            }
        }
        var chosenName = protoInputObject.chosenName();
        if (chosenName != null) {
            var chosenName0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(chosenName);
            if (chosenName0 != null) {
                outputStream.writeString(2, chosenName0);
            }
        }
        var fullName = protoInputObject.fullName();
        if (fullName != null) {
            var fullName0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(fullName);
            if (fullName0 != null) {
                outputStream.writeString(3, fullName0);
            }
        }
        var shortName = protoInputObject.shortName();
        if (shortName != null) {
            var shortName0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(shortName);
            if (shortName0 != null) {
                outputStream.writeString(4, shortName0);
            }
        }
        outputStream.writeInt32(5, it.auties.whatsapp.model.contact.ContactStatusSpec.encode(protoInputObject.lastKnownPresence()));
        var lastSeenSeconds = protoInputObject.lastSeenSeconds();
        if (lastSeenSeconds != null) {
            var lastSeenSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(lastSeenSeconds);
            if (lastSeenSeconds0 != null) {
                outputStream.writeUInt64(6, lastSeenSeconds0);
            }
        }
        outputStream.writeBool(7, protoInputObject.blocked());
        return outputStream.toByteArray();
    }

    public static Contact decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static Contact decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.jid.Jid jid = null;
        java.lang.String chosenName = null;
        java.lang.String fullName = null;
        java.lang.String shortName = null;
        it.auties.whatsapp.model.contact.ContactStatus lastKnownPresence = null;
        java.lang.Long lastSeenSeconds = null;
        boolean blocked = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> jid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 2 -> chosenName = protoInputStream.readString();
                case 3 -> fullName = protoInputStream.readString();
                case 4 -> shortName = protoInputStream.readString();
                case 5 -> lastKnownPresence = it.auties.whatsapp.model.contact.ContactStatusSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 6 -> lastSeenSeconds = protoInputStream.readInt64();
                case 7 -> blocked = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.contact.Contact(jid, chosenName, fullName, shortName, lastKnownPresence, lastSeenSeconds, blocked);
    }

    public static int sizeOf(Contact object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var jid = object.jid();
        if (jid != null) {
            var jid0 = jid.toString();
            if (jid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(jid0);
            }
        }
        var chosenName = object.chosenName();
        if (chosenName != null) {
            var chosenName0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(chosenName);
            if (chosenName0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                protoSize += ProtobufOutputStream.getStringSize(chosenName0);
            }
        }
        var fullName = object.fullName();
        if (fullName != null) {
            var fullName0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(fullName);
            if (fullName0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                protoSize += ProtobufOutputStream.getStringSize(fullName0);
            }
        }
        var shortName = object.shortName();
        if (shortName != null) {
            var shortName0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(shortName);
            if (shortName0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                protoSize += ProtobufOutputStream.getStringSize(shortName0);
            }
        }
        var lastKnownPresence = object.lastKnownPresence();
        if (lastKnownPresence != null) {
            protoSize += ProtobufOutputStream.getFieldSize(5, 2);
            var lastKnownPresenceSerializedSize = it.auties.whatsapp.model.contact.ContactStatusSpec.sizeOf(lastKnownPresence);
            protoSize += lastKnownPresenceSerializedSize;
        }
        var lastSeenSeconds = object.lastSeenSeconds();
        if (lastSeenSeconds != null) {
            var lastSeenSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(lastSeenSeconds);
            if (lastSeenSeconds0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(6, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(lastSeenSeconds0);
            }
        }
        var blocked = object.blocked();
        protoSize += ProtobufOutputStream.getFieldSize(7, 0);
        protoSize += 1;
        return protoSize;
    }

}
