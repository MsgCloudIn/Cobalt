package it.auties.whatsapp.model.message.standard;

import it.auties.whatsapp.model.message.standard.ContactsMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ContactsMessageSpec {
    public static byte[] encode(ContactsMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.name());
        if (protoInputObject.contacts() != null) {
            for (var contactsEntry : protoInputObject.contacts()) { 
                outputStream.writeBytes(2, it.auties.whatsapp.model.message.standard.ContactMessageSpec.encode(contactsEntry));
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

    public static ContactsMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ContactsMessage decode(ProtobufInputStream protoInputStream) {
        java.lang.String name = null;
        java.util.List<it.auties.whatsapp.model.message.standard.ContactMessage> contacts = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        it.auties.whatsapp.model.info.ContextInfo contextInfo = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> name = protoInputStream.readString();
                case 2 -> contacts.add(it.auties.whatsapp.model.message.standard.ContactMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 17 -> contextInfo = it.auties.whatsapp.model.info.ContextInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.standard.ContactsMessage(name, contacts, contextInfo);
    }

    public static int sizeOf(ContactsMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var name = object.name();
        if (name != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(name);
        }
        var contactsRepeatedField = object.contacts();
        if (contactsRepeatedField != null) {
            for (var contactsEntry : contactsRepeatedField) { 
                if (contactsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                    var contactsEntrySerializedSize = it.auties.whatsapp.model.message.standard.ContactMessageSpec.sizeOf(contactsEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(contactsEntrySerializedSize);
                    protoSize += contactsEntrySerializedSize;
                }
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
