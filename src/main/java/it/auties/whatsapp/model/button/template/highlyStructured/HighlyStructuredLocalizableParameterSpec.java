package it.auties.whatsapp.model.button.template.highlyStructured;

import it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredLocalizableParameter;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class HighlyStructuredLocalizableParameterSpec {
    public static byte[] encode(HighlyStructuredLocalizableParameter protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.defaultValue());
        var parameterCurrency = protoInputObject.parameterCurrency();
        if (parameterCurrency != null) {
            var parameterCurrency0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(parameterCurrency);
            if (parameterCurrency0 != null) {
                outputStream.writeBytes(2, it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredCurrencySpec.encode(parameterCurrency0));
            }
        }
        var parameterDateTime = protoInputObject.parameterDateTime();
        if (parameterDateTime != null) {
            var parameterDateTime0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(parameterDateTime);
            if (parameterDateTime0 != null) {
                outputStream.writeBytes(3, it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeSpec.encode(parameterDateTime0));
            }
        }
        return outputStream.toByteArray();
    }

    public static HighlyStructuredLocalizableParameter decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static HighlyStructuredLocalizableParameter decode(ProtobufInputStream protoInputStream) {
        java.lang.String defaultValue = null;
        java.util.Optional<it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredCurrency> parameterCurrency = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTime> parameterDateTime = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> defaultValue = protoInputStream.readString();
                case 2 -> parameterCurrency = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredCurrencySpec.decode(protoInputStream.lengthDelimitedStream()));
                case 3 -> parameterDateTime = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredLocalizableParameter(defaultValue, parameterCurrency, parameterDateTime);
    }

    public static int sizeOf(HighlyStructuredLocalizableParameter object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var defaultValue = object.defaultValue();
        if (defaultValue != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(defaultValue);
        }
        var parameterCurrency = object.parameterCurrency();
        if (parameterCurrency != null) {
            var parameterCurrency0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(parameterCurrency);
            if (parameterCurrency0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                var parameterCurrency0SerializedSize = it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredCurrencySpec.sizeOf(parameterCurrency0);
                protoSize += ProtobufOutputStream.getVarIntSize(parameterCurrency0SerializedSize);
                protoSize += parameterCurrency0SerializedSize;
            }
        }
        var parameterDateTime = object.parameterDateTime();
        if (parameterDateTime != null) {
            var parameterDateTime0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(parameterDateTime);
            if (parameterDateTime0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                var parameterDateTime0SerializedSize = it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredDateTimeSpec.sizeOf(parameterDateTime0);
                protoSize += ProtobufOutputStream.getVarIntSize(parameterDateTime0SerializedSize);
                protoSize += parameterDateTime0SerializedSize;
            }
        }
        return protoSize;
    }

}
