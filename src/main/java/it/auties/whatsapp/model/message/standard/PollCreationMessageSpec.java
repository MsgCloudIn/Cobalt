package it.auties.whatsapp.model.message.standard;

import it.auties.whatsapp.model.message.standard.PollCreationMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class PollCreationMessageSpec {
    public static byte[] encode(PollCreationMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var encryptionKey = protoInputObject.encryptionKey();
        if (encryptionKey != null) {
            var encryptionKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(encryptionKey);
            if (encryptionKey0 != null) {
                outputStream.writeBytes(1, encryptionKey0);
            }
        }
        outputStream.writeString(2, protoInputObject.title());
        if (protoInputObject.selectableOptions() != null) {
            for (var selectableOptionsEntry : protoInputObject.selectableOptions()) { 
                outputStream.writeBytes(3, it.auties.whatsapp.model.poll.PollOptionSpec.encode(selectableOptionsEntry));
            }
        }
        outputStream.writeUInt32(4, protoInputObject.selectableOptionsCount());
        var contextInfo = protoInputObject.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                outputStream.writeBytes(5, it.auties.whatsapp.model.info.ContextInfoSpec.encode(contextInfo0));
            }
        }
        if (protoInputObject.selectableOptionsMap != null) {
            for (var selectableOptionsMapEntry : protoInputObject.selectableOptionsMap.entrySet()) { 
                var selectableOptionsMapOutputStream = new ProtobufOutputStream(sizeOfSelectableOptionsMap(selectableOptionsMapEntry));
                selectableOptionsMapOutputStream.writeString(1, selectableOptionsMapEntry.getKey());
                selectableOptionsMapOutputStream.writeBytes(2, it.auties.whatsapp.model.poll.PollOptionSpec.encode(selectableOptionsMapEntry.getValue()));
                outputStream.writeBytes(999, selectableOptionsMapOutputStream.toByteArray());
            }
        }
        if (protoInputObject.selectedOptions != null) {
            for (var selectedOptionsEntry : protoInputObject.selectedOptions) { 
                outputStream.writeBytes(1000, it.auties.whatsapp.model.poll.SelectedPollOptionSpec.encode(selectedOptionsEntry));
            }
        }
        return outputStream.toByteArray();
    }

    public static PollCreationMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static PollCreationMessage decode(ProtobufInputStream protoInputStream) {
        byte[] encryptionKey = null;
        java.lang.String title = null;
        java.util.List<it.auties.whatsapp.model.poll.PollOption> selectableOptions = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        int selectableOptionsCount = 0;
        it.auties.whatsapp.model.info.ContextInfo contextInfo = null;
        java.util.Map<java.lang.String,it.auties.whatsapp.model.poll.PollOption> selectableOptionsMap = it.auties.protobuf.builtin.ProtobufMapMixin.newMap();
        java.util.List<it.auties.whatsapp.model.poll.SelectedPollOption> selectedOptions = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> encryptionKey = protoInputStream.readBytes();
                case 2 -> title = protoInputStream.readString();
                case 3 -> selectableOptions.add(it.auties.whatsapp.model.poll.PollOptionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 4 -> selectableOptionsCount = protoInputStream.readInt32();
                case 5 -> contextInfo = it.auties.whatsapp.model.info.ContextInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                case 999 -> {
                    var selectableOptionsMapInputStream = protoInputStream.lengthDelimitedStream();
                    java.lang.String selectableOptionsMapKey = null;
                    it.auties.whatsapp.model.poll.PollOption selectableOptionsMapValue = null;
                    while (selectableOptionsMapInputStream.readTag()) {
                        switch (selectableOptionsMapInputStream.index()) {
                            case 1 -> selectableOptionsMapKey = selectableOptionsMapInputStream.readString();
                            case 2 -> selectableOptionsMapValue = it.auties.whatsapp.model.poll.PollOptionSpec.decode(selectableOptionsMapInputStream.lengthDelimitedStream());
                        }
                    }
                    selectableOptionsMap.put(selectableOptionsMapKey, selectableOptionsMapValue);
                }
                case 1000 -> selectedOptions.add(it.auties.whatsapp.model.poll.SelectedPollOptionSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.standard.PollCreationMessage(encryptionKey, title, selectableOptions, selectableOptionsCount, contextInfo, selectableOptionsMap, selectedOptions);
    }

    public static int sizeOf(PollCreationMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var encryptionKey = object.encryptionKey();
        if (encryptionKey != null) {
            var encryptionKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(encryptionKey);
            if (encryptionKey0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getBytesSize(encryptionKey0);
            }
        }
        var title = object.title();
        if (title != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(title);
        }
        var selectableOptionsRepeatedField = object.selectableOptions();
        if (selectableOptionsRepeatedField != null) {
            for (var selectableOptionsEntry : selectableOptionsRepeatedField) { 
                if (selectableOptionsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                    var selectableOptionsEntrySerializedSize = it.auties.whatsapp.model.poll.PollOptionSpec.sizeOf(selectableOptionsEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(selectableOptionsEntrySerializedSize);
                    protoSize += selectableOptionsEntrySerializedSize;
                }
            }
        }
        var selectableOptionsCount = object.selectableOptionsCount();
        protoSize += ProtobufOutputStream.getFieldSize(4, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(selectableOptionsCount);
        var contextInfo = object.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                var contextInfo0SerializedSize = it.auties.whatsapp.model.info.ContextInfoSpec.sizeOf(contextInfo0);
                protoSize += ProtobufOutputStream.getVarIntSize(contextInfo0SerializedSize);
                protoSize += contextInfo0SerializedSize;
            }
        }
        var selectableOptionsMapMapField = object.selectableOptionsMap;
        if (selectableOptionsMapMapField != null) {
            for (var selectableOptionsMapMapEntry : selectableOptionsMapMapField.entrySet()) { 
                protoSize += ProtobufOutputStream.getFieldSize(999, 2);
                var selectableOptionsMapMapEntrySize = sizeOfSelectableOptionsMap(selectableOptionsMapMapEntry);
                protoSize += ProtobufOutputStream.getVarIntSize(selectableOptionsMapMapEntrySize);
                protoSize += selectableOptionsMapMapEntrySize;
            }
        }
        var selectedOptionsRepeatedField = object.selectedOptions;
        if (selectedOptionsRepeatedField != null) {
            for (var selectedOptionsEntry : selectedOptionsRepeatedField) { 
                if (selectedOptionsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(1000, 2);
                    var selectedOptionsEntrySerializedSize = it.auties.whatsapp.model.poll.SelectedPollOptionSpec.sizeOf(selectedOptionsEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(selectedOptionsEntrySerializedSize);
                    protoSize += selectedOptionsEntrySerializedSize;
                }
            }
        }
        return protoSize;
    }

    private static int sizeOfSelectableOptionsMap(java.util.Map.Entry<java.lang.String, it.auties.whatsapp.model.poll.PollOption> object) {
        var protoSize = 0;
        var objectMapKey = object.getKey();
        protoSize += ProtobufOutputStream.getFieldSize(1, 2);
        protoSize += ProtobufOutputStream.getStringSize(objectMapKey);
        var selectableOptionsMapMapValue = object.getValue();
        if (selectableOptionsMapMapValue != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var selectableOptionsMapMapValueSerializedSize = it.auties.whatsapp.model.poll.PollOptionSpec.sizeOf(selectableOptionsMapMapValue);
            protoSize += ProtobufOutputStream.getVarIntSize(selectableOptionsMapMapValueSerializedSize);
            protoSize += selectableOptionsMapMapValueSerializedSize;
        }
        return protoSize;
    }

}
