package it.auties.whatsapp.model.setting;

import it.auties.whatsapp.model.setting.AutoDownloadSettings;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class AutoDownloadSettingsSpec {
    public static byte[] encode(AutoDownloadSettings protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBool(1, protoInputObject.downloadImages());
        outputStream.writeBool(2, protoInputObject.downloadAudio());
        outputStream.writeBool(3, protoInputObject.downloadVideo());
        outputStream.writeBool(4, protoInputObject.downloadDocuments());
        return outputStream.toByteArray();
    }

    public static AutoDownloadSettings decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static AutoDownloadSettings decode(ProtobufInputStream protoInputStream) {
        boolean downloadImages = false;
        boolean downloadAudio = false;
        boolean downloadVideo = false;
        boolean downloadDocuments = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> downloadImages = protoInputStream.readBool();
                case 2 -> downloadAudio = protoInputStream.readBool();
                case 3 -> downloadVideo = protoInputStream.readBool();
                case 4 -> downloadDocuments = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.setting.AutoDownloadSettings(downloadImages, downloadAudio, downloadVideo, downloadDocuments);
    }

    public static int sizeOf(AutoDownloadSettings object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var downloadImages = object.downloadImages();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += 1;
        var downloadAudio = object.downloadAudio();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += 1;
        var downloadVideo = object.downloadVideo();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += 1;
        var downloadDocuments = object.downloadDocuments();
        protoSize += ProtobufOutputStream.getFieldSize(4, 0);
        protoSize += 1;
        return protoSize;
    }

}
