package it.auties.whatsapp.model.poll;

import it.auties.whatsapp.model.poll.PollUpdateEncryptedOptions;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class PollUpdateEncryptedOptionsSpec {
    public static byte[] encode(PollUpdateEncryptedOptions protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        if (protoInputObject.selectedOptions() != null) {
            for (var selectedOptionsEntry : protoInputObject.selectedOptions()) { 
                outputStream.writeBytes(1, selectedOptionsEntry);
            }
        }
        return outputStream.toByteArray();
    }

    public static PollUpdateEncryptedOptions decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static PollUpdateEncryptedOptions decode(ProtobufInputStream protoInputStream) {
        java.util.List<byte[]> selectedOptions = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> selectedOptions.add(protoInputStream.readBytes());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.poll.PollUpdateEncryptedOptions(selectedOptions);
    }

    public static int sizeOf(PollUpdateEncryptedOptions object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var selectedOptionsRepeatedField = object.selectedOptions();
        if (selectedOptionsRepeatedField != null) {
            for (var selectedOptionsEntry : selectedOptionsRepeatedField) { 
                if (selectedOptionsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                    protoSize += ProtobufOutputStream.getBytesSize(selectedOptionsEntry);
                }
            }
        }
        return protoSize;
    }

}
