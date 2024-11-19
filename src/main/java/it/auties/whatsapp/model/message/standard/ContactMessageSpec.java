package it.auties.whatsapp.model.message.standard;

import it.auties.whatsapp.model.message.standard.ContactMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ContactMessageSpec {
    public static byte[] encode(ContactMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.name());
        var vcard = protoInputObject.vcard();
        if (vcard != null) {
            var vcard0 = vcard.toVcard();
            if (vcard0 != null) {
                outputStream.writeString(16, vcard0);
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

    public static ContactMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ContactMessage decode(ProtobufInputStream protoInputStream) {
        java.lang.String name = null;
        it.auties.whatsapp.model.contact.ContactCard vcard = null;
        it.auties.whatsapp.model.info.ContextInfo contextInfo = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> name = protoInputStream.readString();
                case 16 -> vcard = it.auties.whatsapp.model.contact.ContactCard.ofNullable(protoInputStream.readString());
                case 17 -> contextInfo = it.auties.whatsapp.model.info.ContextInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.standard.ContactMessage(name, vcard, contextInfo);
    }

    public static int sizeOf(ContactMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var name = object.name();
        if (name != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(name);
        }
        var vcard = object.vcard();
        if (vcard != null) {
            var vcard0 = vcard.toVcard();
            if (vcard0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(16, 2);
                protoSize += ProtobufOutputStream.getStringSize(vcard0);
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
