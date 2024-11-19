package it.auties.whatsapp.model.newsletter;

import it.auties.whatsapp.model.newsletter.NewsletterReactionSettings;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class NewsletterReactionSettingsSpec {
    public static byte[] encode(NewsletterReactionSettings protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, it.auties.whatsapp.model.newsletter.NewsletterReactionSettingsTypeSpec.encode(protoInputObject.value()));
        if (protoInputObject.blockedCodes() != null) {
            for (var blockedCodesEntry : protoInputObject.blockedCodes()) { 
                outputStream.writeString(2, blockedCodesEntry);
            }
        }
        var enabledTimestampSeconds = protoInputObject.enabledTimestampSeconds();
        if (enabledTimestampSeconds != null) {
            var enabledTimestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(enabledTimestampSeconds);
            if (enabledTimestampSeconds0 != null) {
                outputStream.writeUInt64(3, enabledTimestampSeconds0);
            }
        }
        return outputStream.toByteArray();
    }

    public static NewsletterReactionSettings decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static NewsletterReactionSettings decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.newsletter.NewsletterReactionSettings.Type value = null;
        java.util.List<java.lang.String> blockedCodes = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        java.util.OptionalLong enabledTimestampSeconds = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptionalLong();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> value = it.auties.whatsapp.model.newsletter.NewsletterReactionSettingsTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 2 -> blockedCodes.add(protoInputStream.readString());
                case 3 -> enabledTimestampSeconds = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readInt64());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.newsletter.NewsletterReactionSettings(value, blockedCodes, enabledTimestampSeconds);
    }

    public static int sizeOf(NewsletterReactionSettings object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var value = object.value();
        if (value != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var valueSerializedSize = it.auties.whatsapp.model.newsletter.NewsletterReactionSettingsTypeSpec.sizeOf(value);
            protoSize += valueSerializedSize;
        }
        var blockedCodesRepeatedField = object.blockedCodes();
        if (blockedCodesRepeatedField != null) {
            for (var blockedCodesEntry : blockedCodesRepeatedField) { 
                if (blockedCodesEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                    protoSize += ProtobufOutputStream.getStringSize(blockedCodesEntry);
                }
            }
        }
        var enabledTimestampSeconds = object.enabledTimestampSeconds();
        if (enabledTimestampSeconds != null) {
            var enabledTimestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(enabledTimestampSeconds);
            if (enabledTimestampSeconds0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(enabledTimestampSeconds0);
            }
        }
        return protoSize;
    }

}
