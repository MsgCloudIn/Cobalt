package it.auties.whatsapp.api;

import it.auties.whatsapp.api.TextPreviewSetting;
import java.util.Arrays;
import java.util.Optional;
import it.auties.protobuf.stream.ProtobufOutputStream;

public class TextPreviewSettingSpec {
    public static Integer encode(TextPreviewSetting protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        return protoInputObject.index;
    }

    public static Optional<TextPreviewSetting> decode(int index) {
        return Arrays.stream(TextPreviewSetting.values())
                .filter(entry -> entry.index == index)
                .findFirst();
    }

    public static int sizeOf(TextPreviewSetting object) {
        if (object == null) {
            return 0;
        }
        return ProtobufOutputStream.getVarIntSize(object.index);
    }

}
