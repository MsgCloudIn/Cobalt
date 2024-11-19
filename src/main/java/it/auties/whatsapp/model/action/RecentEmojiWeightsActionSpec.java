package it.auties.whatsapp.model.action;

import it.auties.whatsapp.model.action.RecentEmojiWeightsAction;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class RecentEmojiWeightsActionSpec {
    public static byte[] encode(RecentEmojiWeightsAction protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        if (protoInputObject.weights() != null) {
            for (var weightsEntry : protoInputObject.weights()) { 
                outputStream.writeBytes(1, it.auties.whatsapp.model.sync.RecentEmojiWeightSpec.encode(weightsEntry));
            }
        }
        return outputStream.toByteArray();
    }

    public static RecentEmojiWeightsAction decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static RecentEmojiWeightsAction decode(ProtobufInputStream protoInputStream) {
        java.util.List<it.auties.whatsapp.model.sync.RecentEmojiWeight> weights = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> weights.add(it.auties.whatsapp.model.sync.RecentEmojiWeightSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.action.RecentEmojiWeightsAction(weights);
    }

    public static int sizeOf(RecentEmojiWeightsAction object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var weightsRepeatedField = object.weights();
        if (weightsRepeatedField != null) {
            for (var weightsEntry : weightsRepeatedField) { 
                if (weightsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                    var weightsEntrySerializedSize = it.auties.whatsapp.model.sync.RecentEmojiWeightSpec.sizeOf(weightsEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(weightsEntrySerializedSize);
                    protoSize += weightsEntrySerializedSize;
                }
            }
        }
        return protoSize;
    }

}
