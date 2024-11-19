package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.HistorySyncConfig;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class HistorySyncConfigSpec {
    public static byte[] encode(HistorySyncConfig protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeUInt32(1, protoInputObject.fullSyncDaysLimit());
        outputStream.writeUInt32(2, protoInputObject.fullSyncSizeMbLimit());
        outputStream.writeUInt32(3, protoInputObject.storageQuotaMb());
        outputStream.writeBool(4, protoInputObject.inlineInitialPayloadInE2EeMsg());
        outputStream.writeUInt32(5, protoInputObject.recentSyncDaysLimit());
        outputStream.writeBool(6, protoInputObject.supportCallLogHistory());
        outputStream.writeBool(7, protoInputObject.supportBotUserAgentChatHistory());
        return outputStream.toByteArray();
    }

    public static HistorySyncConfig decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static HistorySyncConfig decode(ProtobufInputStream protoInputStream) {
        java.lang.Integer fullSyncDaysLimit = null;
        java.lang.Integer fullSyncSizeMbLimit = null;
        java.lang.Integer storageQuotaMb = null;
        java.lang.Boolean inlineInitialPayloadInE2EeMsg = null;
        java.lang.Integer recentSyncDaysLimit = null;
        java.lang.Boolean supportCallLogHistory = null;
        java.lang.Boolean supportBotUserAgentChatHistory = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> fullSyncDaysLimit = protoInputStream.readInt32();
                case 2 -> fullSyncSizeMbLimit = protoInputStream.readInt32();
                case 3 -> storageQuotaMb = protoInputStream.readInt32();
                case 4 -> inlineInitialPayloadInE2EeMsg = protoInputStream.readBool();
                case 5 -> recentSyncDaysLimit = protoInputStream.readInt32();
                case 6 -> supportCallLogHistory = protoInputStream.readBool();
                case 7 -> supportBotUserAgentChatHistory = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.HistorySyncConfig(fullSyncDaysLimit, fullSyncSizeMbLimit, storageQuotaMb, inlineInitialPayloadInE2EeMsg, recentSyncDaysLimit, supportCallLogHistory, supportBotUserAgentChatHistory);
    }

    public static int sizeOf(HistorySyncConfig object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var fullSyncDaysLimit = object.fullSyncDaysLimit();
        if (fullSyncDaysLimit != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(fullSyncDaysLimit);
        }
        var fullSyncSizeMbLimit = object.fullSyncSizeMbLimit();
        if (fullSyncSizeMbLimit != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(fullSyncSizeMbLimit);
        }
        var storageQuotaMb = object.storageQuotaMb();
        if (storageQuotaMb != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(storageQuotaMb);
        }
        var inlineInitialPayloadInE2EeMsg = object.inlineInitialPayloadInE2EeMsg();
        if (inlineInitialPayloadInE2EeMsg != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 0);
            protoSize += 1;
        }
        var recentSyncDaysLimit = object.recentSyncDaysLimit();
        if (recentSyncDaysLimit != null) {
            protoSize += ProtobufOutputStream.getFieldSize(5, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(recentSyncDaysLimit);
        }
        var supportCallLogHistory = object.supportCallLogHistory();
        if (supportCallLogHistory != null) {
            protoSize += ProtobufOutputStream.getFieldSize(6, 0);
            protoSize += 1;
        }
        var supportBotUserAgentChatHistory = object.supportBotUserAgentChatHistory();
        if (supportBotUserAgentChatHistory != null) {
            protoSize += ProtobufOutputStream.getFieldSize(7, 0);
            protoSize += 1;
        }
        return protoSize;
    }

}
