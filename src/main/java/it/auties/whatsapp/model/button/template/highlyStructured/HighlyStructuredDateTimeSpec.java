package it.auties.whatsapp.model.button.template.highlyStructured;

import it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTime;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class HighlyStructuredDateTimeSpec {
    public static byte[] encode(HighlyStructuredDateTime protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var dateComponent = protoInputObject.dateComponent();
        if (dateComponent != null) {
            var dateComponent0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(dateComponent);
            if (dateComponent0 != null) {
                outputStream.writeBytes(1, it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeComponentSpec.encode(dateComponent0));
            }
        }
        var dateUnixEpoch = protoInputObject.dateUnixEpoch();
        if (dateUnixEpoch != null) {
            var dateUnixEpoch0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(dateUnixEpoch);
            if (dateUnixEpoch0 != null) {
                outputStream.writeBytes(2, it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeUnixEpochSpec.encode(dateUnixEpoch0));
            }
        }
        return outputStream.toByteArray();
    }

    public static HighlyStructuredDateTime decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static HighlyStructuredDateTime decode(ProtobufInputStream protoInputStream) {
        java.util.Optional<it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeComponent> dateComponent = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeUnixEpoch> dateUnixEpoch = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> dateComponent = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeComponentSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 2 -> dateUnixEpoch = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeUnixEpochSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTime(dateComponent, dateUnixEpoch);
    }

    public static int sizeOf(HighlyStructuredDateTime object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var dateComponent = object.dateComponent();
        if (dateComponent != null) {
            var dateComponent0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(dateComponent);
            if (dateComponent0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                var dateComponent0SerializedSize = it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeComponentSpec.sizeOf(dateComponent0);
                protoSize += ProtobufOutputStream.getVarIntSize(dateComponent0SerializedSize);
                protoSize += dateComponent0SerializedSize;
            }
        }
        var dateUnixEpoch = object.dateUnixEpoch();
        if (dateUnixEpoch != null) {
            var dateUnixEpoch0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(dateUnixEpoch);
            if (dateUnixEpoch0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                var dateUnixEpoch0SerializedSize = it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeUnixEpochSpec.sizeOf(dateUnixEpoch0);
                protoSize += ProtobufOutputStream.getVarIntSize(dateUnixEpoch0SerializedSize);
                protoSize += dateUnixEpoch0SerializedSize;
            }
        }
        return protoSize;
    }

}
