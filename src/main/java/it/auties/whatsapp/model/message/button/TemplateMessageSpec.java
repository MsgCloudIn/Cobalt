package it.auties.whatsapp.model.message.button;

import it.auties.whatsapp.model.message.button.TemplateMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class TemplateMessageSpec {
    public static byte[] encode(TemplateMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(9, protoInputObject.id());
        outputStream.writeBytes(4, it.auties.whatsapp.model.button.template.hydrated.HydratedFourRowTemplateSpec.encode(protoInputObject.content()));
        var highlyStructuredFourRowTemplateFormat = protoInputObject.highlyStructuredFourRowTemplateFormat();
        if (highlyStructuredFourRowTemplateFormat != null) {
            var highlyStructuredFourRowTemplateFormat0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(highlyStructuredFourRowTemplateFormat);
            if (highlyStructuredFourRowTemplateFormat0 != null) {
                outputStream.writeBytes(1, it.auties.whatsapp.model.button.template.hsm.HighlyStructuredFourRowTemplateSpec.encode(highlyStructuredFourRowTemplateFormat0));
            }
        }
        var hydratedFourRowTemplateFormat = protoInputObject.hydratedFourRowTemplateFormat();
        if (hydratedFourRowTemplateFormat != null) {
            var hydratedFourRowTemplateFormat0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(hydratedFourRowTemplateFormat);
            if (hydratedFourRowTemplateFormat0 != null) {
                outputStream.writeBytes(2, it.auties.whatsapp.model.button.template.hydrated.HydratedFourRowTemplateSpec.encode(hydratedFourRowTemplateFormat0));
            }
        }
        var interactiveMessageFormat = protoInputObject.interactiveMessageFormat();
        if (interactiveMessageFormat != null) {
            var interactiveMessageFormat0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(interactiveMessageFormat);
            if (interactiveMessageFormat0 != null) {
                outputStream.writeBytes(5, it.auties.whatsapp.model.message.button.InteractiveMessageSpec.encode(interactiveMessageFormat0));
            }
        }
        var contextInfo = protoInputObject.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                outputStream.writeBytes(3, it.auties.whatsapp.model.info.ContextInfoSpec.encode(contextInfo0));
            }
        }
        return outputStream.toByteArray();
    }

    public static TemplateMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static TemplateMessage decode(ProtobufInputStream protoInputStream) {
        java.lang.String id = null;
        it.auties.whatsapp.model.button.template.hydrated.HydratedFourRowTemplate content = null;
        it.auties.whatsapp.model.button.template.hsm.HighlyStructuredFourRowTemplate highlyStructuredFourRowTemplateFormat = null;
        it.auties.whatsapp.model.button.template.hydrated.HydratedFourRowTemplate hydratedFourRowTemplateFormat = null;
        it.auties.whatsapp.model.message.button.InteractiveMessage interactiveMessageFormat = null;
        it.auties.whatsapp.model.info.ContextInfo contextInfo = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 9 -> id = protoInputStream.readString();
                case 4 -> content = it.auties.whatsapp.model.button.template.hydrated.HydratedFourRowTemplateSpec.decode(protoInputStream.lengthDelimitedStream());
                case 1 -> highlyStructuredFourRowTemplateFormat = it.auties.whatsapp.model.button.template.hsm.HighlyStructuredFourRowTemplateSpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> hydratedFourRowTemplateFormat = it.auties.whatsapp.model.button.template.hydrated.HydratedFourRowTemplateSpec.decode(protoInputStream.lengthDelimitedStream());
                case 5 -> interactiveMessageFormat = it.auties.whatsapp.model.message.button.InteractiveMessageSpec.decode(protoInputStream.lengthDelimitedStream());
                case 3 -> contextInfo = it.auties.whatsapp.model.info.ContextInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.button.TemplateMessage(id, content, highlyStructuredFourRowTemplateFormat, hydratedFourRowTemplateFormat, interactiveMessageFormat, contextInfo);
    }

    public static int sizeOf(TemplateMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var id = object.id();
        if (id != null) {
            protoSize += ProtobufOutputStream.getFieldSize(9, 2);
            protoSize += ProtobufOutputStream.getStringSize(id);
        }
        var content = object.content();
        if (content != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            var contentSerializedSize = it.auties.whatsapp.model.button.template.hydrated.HydratedFourRowTemplateSpec.sizeOf(content);
            protoSize += ProtobufOutputStream.getVarIntSize(contentSerializedSize);
            protoSize += contentSerializedSize;
        }
        var highlyStructuredFourRowTemplateFormat = object.highlyStructuredFourRowTemplateFormat();
        if (highlyStructuredFourRowTemplateFormat != null) {
            var highlyStructuredFourRowTemplateFormat0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(highlyStructuredFourRowTemplateFormat);
            if (highlyStructuredFourRowTemplateFormat0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                var highlyStructuredFourRowTemplateFormat0SerializedSize = it.auties.whatsapp.model.button.template.hsm.HighlyStructuredFourRowTemplateSpec.sizeOf(highlyStructuredFourRowTemplateFormat0);
                protoSize += ProtobufOutputStream.getVarIntSize(highlyStructuredFourRowTemplateFormat0SerializedSize);
                protoSize += highlyStructuredFourRowTemplateFormat0SerializedSize;
            }
        }
        var hydratedFourRowTemplateFormat = object.hydratedFourRowTemplateFormat();
        if (hydratedFourRowTemplateFormat != null) {
            var hydratedFourRowTemplateFormat0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(hydratedFourRowTemplateFormat);
            if (hydratedFourRowTemplateFormat0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                var hydratedFourRowTemplateFormat0SerializedSize = it.auties.whatsapp.model.button.template.hydrated.HydratedFourRowTemplateSpec.sizeOf(hydratedFourRowTemplateFormat0);
                protoSize += ProtobufOutputStream.getVarIntSize(hydratedFourRowTemplateFormat0SerializedSize);
                protoSize += hydratedFourRowTemplateFormat0SerializedSize;
            }
        }
        var interactiveMessageFormat = object.interactiveMessageFormat();
        if (interactiveMessageFormat != null) {
            var interactiveMessageFormat0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(interactiveMessageFormat);
            if (interactiveMessageFormat0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                var interactiveMessageFormat0SerializedSize = it.auties.whatsapp.model.message.button.InteractiveMessageSpec.sizeOf(interactiveMessageFormat0);
                protoSize += ProtobufOutputStream.getVarIntSize(interactiveMessageFormat0SerializedSize);
                protoSize += interactiveMessageFormat0SerializedSize;
            }
        }
        var contextInfo = object.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                var contextInfo0SerializedSize = it.auties.whatsapp.model.info.ContextInfoSpec.sizeOf(contextInfo0);
                protoSize += ProtobufOutputStream.getVarIntSize(contextInfo0SerializedSize);
                protoSize += contextInfo0SerializedSize;
            }
        }
        return protoSize;
    }

}
