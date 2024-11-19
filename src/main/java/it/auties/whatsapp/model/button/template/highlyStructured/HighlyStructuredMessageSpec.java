package it.auties.whatsapp.model.button.template.highlyStructured;

import it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class HighlyStructuredMessageSpec {
    public static byte[] encode(HighlyStructuredMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.namespace());
        outputStream.writeString(2, protoInputObject.elementName());
        if (protoInputObject.params() != null) {
            for (var paramsEntry : protoInputObject.params()) { 
                outputStream.writeString(3, paramsEntry);
            }
        }
        var fallbackLg = protoInputObject.fallbackLg();
        if (fallbackLg != null) {
            var fallbackLg0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(fallbackLg);
            if (fallbackLg0 != null) {
                outputStream.writeString(4, fallbackLg0);
            }
        }
        var fallbackLc = protoInputObject.fallbackLc();
        if (fallbackLc != null) {
            var fallbackLc0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(fallbackLc);
            if (fallbackLc0 != null) {
                outputStream.writeString(5, fallbackLc0);
            }
        }
        if (protoInputObject.localizableParameters() != null) {
            for (var localizableParametersEntry : protoInputObject.localizableParameters()) { 
                outputStream.writeBytes(6, it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredLocalizableParameterSpec.encode(localizableParametersEntry));
            }
        }
        var deterministicLg = protoInputObject.deterministicLg();
        if (deterministicLg != null) {
            var deterministicLg0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(deterministicLg);
            if (deterministicLg0 != null) {
                outputStream.writeString(7, deterministicLg0);
            }
        }
        var deterministicLc = protoInputObject.deterministicLc();
        if (deterministicLc != null) {
            var deterministicLc0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(deterministicLc);
            if (deterministicLc0 != null) {
                outputStream.writeString(8, deterministicLc0);
            }
        }
        outputStream.writeBytes(9, it.auties.whatsapp.model.message.button.TemplateMessageSpec.encode(protoInputObject.templateMessage()));
        return outputStream.toByteArray();
    }

    public static HighlyStructuredMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static HighlyStructuredMessage decode(ProtobufInputStream protoInputStream) {
        java.lang.String namespace = null;
        java.lang.String elementName = null;
        java.util.List<java.lang.String> params = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        java.util.Optional<java.lang.String> fallbackLg = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> fallbackLc = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.List<it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredLocalizableParameter> localizableParameters = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        java.util.Optional<java.lang.String> deterministicLg = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> deterministicLc = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        it.auties.whatsapp.model.message.button.TemplateMessage templateMessage = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> namespace = protoInputStream.readString();
                case 2 -> elementName = protoInputStream.readString();
                case 3 -> params.add(protoInputStream.readString());
                case 4 -> fallbackLg = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 5 -> fallbackLc = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 6 -> localizableParameters.add(it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredLocalizableParameterSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 7 -> deterministicLg = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 8 -> deterministicLc = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 9 -> templateMessage = it.auties.whatsapp.model.message.button.TemplateMessageSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessage(namespace, elementName, params, fallbackLg, fallbackLc, localizableParameters, deterministicLg, deterministicLc, templateMessage);
    }

    public static int sizeOf(HighlyStructuredMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var namespace = object.namespace();
        if (namespace != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(namespace);
        }
        var elementName = object.elementName();
        if (elementName != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(elementName);
        }
        var paramsRepeatedField = object.params();
        if (paramsRepeatedField != null) {
            for (var paramsEntry : paramsRepeatedField) { 
                if (paramsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                    protoSize += ProtobufOutputStream.getStringSize(paramsEntry);
                }
            }
        }
        var fallbackLg = object.fallbackLg();
        if (fallbackLg != null) {
            var fallbackLg0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(fallbackLg);
            if (fallbackLg0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                protoSize += ProtobufOutputStream.getStringSize(fallbackLg0);
            }
        }
        var fallbackLc = object.fallbackLc();
        if (fallbackLc != null) {
            var fallbackLc0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(fallbackLc);
            if (fallbackLc0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                protoSize += ProtobufOutputStream.getStringSize(fallbackLc0);
            }
        }
        var localizableParametersRepeatedField = object.localizableParameters();
        if (localizableParametersRepeatedField != null) {
            for (var localizableParametersEntry : localizableParametersRepeatedField) { 
                if (localizableParametersEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(6, 2);
                    var localizableParametersEntrySerializedSize = it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredLocalizableParameterSpec.sizeOf(localizableParametersEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(localizableParametersEntrySerializedSize);
                    protoSize += localizableParametersEntrySerializedSize;
                }
            }
        }
        var deterministicLg = object.deterministicLg();
        if (deterministicLg != null) {
            var deterministicLg0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(deterministicLg);
            if (deterministicLg0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(7, 2);
                protoSize += ProtobufOutputStream.getStringSize(deterministicLg0);
            }
        }
        var deterministicLc = object.deterministicLc();
        if (deterministicLc != null) {
            var deterministicLc0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(deterministicLc);
            if (deterministicLc0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(8, 2);
                protoSize += ProtobufOutputStream.getStringSize(deterministicLc0);
            }
        }
        var templateMessage = object.templateMessage();
        if (templateMessage != null) {
            protoSize += ProtobufOutputStream.getFieldSize(9, 2);
            var templateMessageSerializedSize = it.auties.whatsapp.model.message.button.TemplateMessageSpec.sizeOf(templateMessage);
            protoSize += ProtobufOutputStream.getVarIntSize(templateMessageSerializedSize);
            protoSize += templateMessageSerializedSize;
        }
        return protoSize;
    }

}
