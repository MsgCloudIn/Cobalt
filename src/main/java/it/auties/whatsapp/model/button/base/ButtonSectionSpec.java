package it.auties.whatsapp.model.button.base;

import it.auties.whatsapp.model.button.base.ButtonSection;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ButtonSectionSpec {
    public static byte[] encode(ButtonSection protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.title());
        if (protoInputObject.rows() != null) {
            for (var rowsEntry : protoInputObject.rows()) { 
                outputStream.writeBytes(2, it.auties.whatsapp.model.button.base.ButtonRowSpec.encode(rowsEntry));
            }
        }
        return outputStream.toByteArray();
    }

    public static ButtonSection decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ButtonSection decode(ProtobufInputStream protoInputStream) {
        java.lang.String title = null;
        java.util.List<it.auties.whatsapp.model.button.base.ButtonRow> rows = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> title = protoInputStream.readString();
                case 2 -> rows.add(it.auties.whatsapp.model.button.base.ButtonRowSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.base.ButtonSection(title, rows);
    }

    public static int sizeOf(ButtonSection object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var title = object.title();
        if (title != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(title);
        }
        var rowsRepeatedField = object.rows();
        if (rowsRepeatedField != null) {
            for (var rowsEntry : rowsRepeatedField) { 
                if (rowsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                    var rowsEntrySerializedSize = it.auties.whatsapp.model.button.base.ButtonRowSpec.sizeOf(rowsEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(rowsEntrySerializedSize);
                    protoSize += rowsEntrySerializedSize;
                }
            }
        }
        return protoSize;
    }

}
