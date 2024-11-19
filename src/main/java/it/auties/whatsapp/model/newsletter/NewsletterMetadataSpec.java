package it.auties.whatsapp.model.newsletter;

import it.auties.whatsapp.model.newsletter.NewsletterMetadata;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class NewsletterMetadataSpec {
    public static byte[] encode(NewsletterMetadata protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var name = protoInputObject.name();
        if (name != null) {
            var name0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(name);
            if (name0 != null) {
                outputStream.writeBytes(1, it.auties.whatsapp.model.newsletter.NewsletterNameSpec.encode(name0));
            }
        }
        var description = protoInputObject.description();
        if (description != null) {
            var description0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(description);
            if (description0 != null) {
                outputStream.writeBytes(2, it.auties.whatsapp.model.newsletter.NewsletterDescriptionSpec.encode(description0));
            }
        }
        var picture = protoInputObject.picture();
        if (picture != null) {
            var picture0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(picture);
            if (picture0 != null) {
                outputStream.writeBytes(3, it.auties.whatsapp.model.newsletter.NewsletterPictureSpec.encode(picture0));
            }
        }
        var handle = protoInputObject.handle();
        if (handle != null) {
            var handle0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(handle);
            if (handle0 != null) {
                outputStream.writeString(4, handle0);
            }
        }
        var settings = protoInputObject.settings();
        if (settings != null) {
            var settings0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(settings);
            if (settings0 != null) {
                outputStream.writeBytes(5, it.auties.whatsapp.model.newsletter.NewsletterSettingsSpec.encode(settings0));
            }
        }
        var invite = protoInputObject.invite();
        if (invite != null) {
            var invite0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(invite);
            if (invite0 != null) {
                outputStream.writeString(6, invite0);
            }
        }
        var verification = protoInputObject.verification();
        if (verification != null) {
            var verification0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(verification);
            if (verification0 != null) {
                outputStream.writeBool(7, verification0);
            }
        }
        var creationTimestampSeconds = protoInputObject.creationTimestampSeconds();
        if (creationTimestampSeconds != null) {
            var creationTimestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(creationTimestampSeconds);
            if (creationTimestampSeconds0 != null) {
                outputStream.writeUInt64(8, creationTimestampSeconds0);
            }
        }
        return outputStream.toByteArray();
    }

    public static NewsletterMetadata decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static NewsletterMetadata decode(ProtobufInputStream protoInputStream) {
        java.util.Optional<it.auties.whatsapp.model.newsletter.NewsletterName> name = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.newsletter.NewsletterDescription> description = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.newsletter.NewsletterPicture> picture = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> handle = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.newsletter.NewsletterSettings> settings = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> invite = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.Boolean> verification = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.OptionalLong creationTimestampSeconds = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptionalLong();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> name = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.newsletter.NewsletterNameSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 2 -> description = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.newsletter.NewsletterDescriptionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 3 -> picture = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.newsletter.NewsletterPictureSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 4 -> handle = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 5 -> settings = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.newsletter.NewsletterSettingsSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 6 -> invite = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 7 -> verification = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readBool());
                case 8 -> creationTimestampSeconds = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readInt64());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.newsletter.NewsletterMetadata(name, description, picture, handle, settings, invite, verification, creationTimestampSeconds);
    }

    public static int sizeOf(NewsletterMetadata object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var name = object.name();
        if (name != null) {
            var name0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(name);
            if (name0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                var name0SerializedSize = it.auties.whatsapp.model.newsletter.NewsletterNameSpec.sizeOf(name0);
                protoSize += ProtobufOutputStream.getVarIntSize(name0SerializedSize);
                protoSize += name0SerializedSize;
            }
        }
        var description = object.description();
        if (description != null) {
            var description0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(description);
            if (description0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                var description0SerializedSize = it.auties.whatsapp.model.newsletter.NewsletterDescriptionSpec.sizeOf(description0);
                protoSize += ProtobufOutputStream.getVarIntSize(description0SerializedSize);
                protoSize += description0SerializedSize;
            }
        }
        var picture = object.picture();
        if (picture != null) {
            var picture0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(picture);
            if (picture0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                var picture0SerializedSize = it.auties.whatsapp.model.newsletter.NewsletterPictureSpec.sizeOf(picture0);
                protoSize += ProtobufOutputStream.getVarIntSize(picture0SerializedSize);
                protoSize += picture0SerializedSize;
            }
        }
        var handle = object.handle();
        if (handle != null) {
            var handle0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(handle);
            if (handle0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                protoSize += ProtobufOutputStream.getStringSize(handle0);
            }
        }
        var settings = object.settings();
        if (settings != null) {
            var settings0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(settings);
            if (settings0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                var settings0SerializedSize = it.auties.whatsapp.model.newsletter.NewsletterSettingsSpec.sizeOf(settings0);
                protoSize += ProtobufOutputStream.getVarIntSize(settings0SerializedSize);
                protoSize += settings0SerializedSize;
            }
        }
        var invite = object.invite();
        if (invite != null) {
            var invite0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(invite);
            if (invite0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(6, 2);
                protoSize += ProtobufOutputStream.getStringSize(invite0);
            }
        }
        var verification = object.verification();
        if (verification != null) {
            var verification0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(verification);
            if (verification0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(7, 0);
                protoSize += 1;
            }
        }
        var creationTimestampSeconds = object.creationTimestampSeconds();
        if (creationTimestampSeconds != null) {
            var creationTimestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(creationTimestampSeconds);
            if (creationTimestampSeconds0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(8, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(creationTimestampSeconds0);
            }
        }
        return protoSize;
    }

}
