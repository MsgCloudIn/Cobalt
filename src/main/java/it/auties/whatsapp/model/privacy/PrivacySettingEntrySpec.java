package it.auties.whatsapp.model.privacy;

import it.auties.whatsapp.model.privacy.PrivacySettingEntry;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class PrivacySettingEntrySpec {
    public static byte[] encode(PrivacySettingEntry protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, it.auties.whatsapp.model.privacy.PrivacySettingTypeSpec.encode(protoInputObject.type()));
        outputStream.writeInt32(2, it.auties.whatsapp.model.privacy.PrivacySettingValueSpec.encode(protoInputObject.value()));
        if (protoInputObject.excluded() != null) {
            for (var excludedEntry : protoInputObject.excluded()) { 
                var excluded = excludedEntry;
                if (excluded != null) {
                    var excluded0 = excluded.toString();
                    if (excluded0 != null) {
                        outputStream.writeString(3, excluded0);
                    }
                }
            }
        }
        return outputStream.toByteArray();
    }

    public static PrivacySettingEntry decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static PrivacySettingEntry decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.privacy.PrivacySettingType type = null;
        it.auties.whatsapp.model.privacy.PrivacySettingValue value = null;
        java.util.List<it.auties.whatsapp.model.jid.Jid> excluded = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> type = it.auties.whatsapp.model.privacy.PrivacySettingTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 2 -> value = it.auties.whatsapp.model.privacy.PrivacySettingValueSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 3 -> excluded.add(it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.privacy.PrivacySettingEntry(type, value, excluded);
    }

    public static int sizeOf(PrivacySettingEntry object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var type = object.type();
        if (type != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var typeSerializedSize = it.auties.whatsapp.model.privacy.PrivacySettingTypeSpec.sizeOf(type);
            protoSize += typeSerializedSize;
        }
        var value = object.value();
        if (value != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var valueSerializedSize = it.auties.whatsapp.model.privacy.PrivacySettingValueSpec.sizeOf(value);
            protoSize += valueSerializedSize;
        }
        var excludedRepeatedField = object.excluded();
        if (excludedRepeatedField != null) {
            for (var excludedEntry : excludedRepeatedField) { 
                if (excludedEntry != null) {
                    var excludedEntry0 = excludedEntry.toString();
                    if (excludedEntry0 != null) {
                        protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                        protoSize += ProtobufOutputStream.getStringSize(excludedEntry0);
                    }
                }
            }
        }
        return protoSize;
    }

}
