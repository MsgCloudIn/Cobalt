package it.auties.whatsapp.model.setting;

import it.auties.whatsapp.model.setting.GlobalSettings;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class GlobalSettingsSpec {
    public static byte[] encode(GlobalSettings protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var lightThemeWallpaper = protoInputObject.lightThemeWallpaper();
        if (lightThemeWallpaper != null) {
            var lightThemeWallpaper0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(lightThemeWallpaper);
            if (lightThemeWallpaper0 != null) {
                outputStream.writeBytes(1, it.auties.whatsapp.model.chat.ChatWallpaperSpec.encode(lightThemeWallpaper0));
            }
        }
        outputStream.writeInt32(2, it.auties.whatsapp.model.media.MediaVisibilitySpec.encode(protoInputObject.mediaVisibility()));
        var darkThemeWallpaper = protoInputObject.darkThemeWallpaper();
        if (darkThemeWallpaper != null) {
            var darkThemeWallpaper0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(darkThemeWallpaper);
            if (darkThemeWallpaper0 != null) {
                outputStream.writeBytes(3, it.auties.whatsapp.model.chat.ChatWallpaperSpec.encode(darkThemeWallpaper0));
            }
        }
        var autoDownloadWiFi = protoInputObject.autoDownloadWiFi();
        if (autoDownloadWiFi != null) {
            var autoDownloadWiFi0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(autoDownloadWiFi);
            if (autoDownloadWiFi0 != null) {
                outputStream.writeBytes(4, it.auties.whatsapp.model.setting.AutoDownloadSettingsSpec.encode(autoDownloadWiFi0));
            }
        }
        var autoDownloadCellular = protoInputObject.autoDownloadCellular();
        if (autoDownloadCellular != null) {
            var autoDownloadCellular0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(autoDownloadCellular);
            if (autoDownloadCellular0 != null) {
                outputStream.writeBytes(5, it.auties.whatsapp.model.setting.AutoDownloadSettingsSpec.encode(autoDownloadCellular0));
            }
        }
        var autoDownloadRoaming = protoInputObject.autoDownloadRoaming();
        if (autoDownloadRoaming != null) {
            var autoDownloadRoaming0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(autoDownloadRoaming);
            if (autoDownloadRoaming0 != null) {
                outputStream.writeBytes(6, it.auties.whatsapp.model.setting.AutoDownloadSettingsSpec.encode(autoDownloadRoaming0));
            }
        }
        outputStream.writeBool(7, protoInputObject.showIndividualNotificationsPreview());
        outputStream.writeBool(8, protoInputObject.showGroupNotificationsPreview());
        outputStream.writeInt32(9, protoInputObject.disappearingModeDuration());
        outputStream.writeInt64(10, protoInputObject.disappearingModeTimestampSeconds());
        outputStream.writeBytes(11, it.auties.whatsapp.model.setting.AvatarUserSettingsSpec.encode(protoInputObject.avatarUserSettings()));
        return outputStream.toByteArray();
    }

    public static GlobalSettings decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static GlobalSettings decode(ProtobufInputStream protoInputStream) {
        java.util.Optional<it.auties.whatsapp.model.chat.ChatWallpaper> lightThemeWallpaper = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        it.auties.whatsapp.model.media.MediaVisibility mediaVisibility = null;
        java.util.Optional<it.auties.whatsapp.model.chat.ChatWallpaper> darkThemeWallpaper = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.setting.AutoDownloadSettings> autoDownloadWiFi = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.setting.AutoDownloadSettings> autoDownloadCellular = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.setting.AutoDownloadSettings> autoDownloadRoaming = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        boolean showIndividualNotificationsPreview = false;
        boolean showGroupNotificationsPreview = false;
        int disappearingModeDuration = 0;
        long disappearingModeTimestampSeconds = 0l;
        it.auties.whatsapp.model.setting.AvatarUserSettings avatarUserSettings = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> lightThemeWallpaper = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.chat.ChatWallpaperSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 2 -> mediaVisibility = it.auties.whatsapp.model.media.MediaVisibilitySpec.decode(protoInputStream.readInt32()).orElse(null);
                case 3 -> darkThemeWallpaper = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.chat.ChatWallpaperSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 4 -> autoDownloadWiFi = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.setting.AutoDownloadSettingsSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 5 -> autoDownloadCellular = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.setting.AutoDownloadSettingsSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 6 -> autoDownloadRoaming = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.setting.AutoDownloadSettingsSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 7 -> showIndividualNotificationsPreview = protoInputStream.readBool();
                case 8 -> showGroupNotificationsPreview = protoInputStream.readBool();
                case 9 -> disappearingModeDuration = protoInputStream.readInt32();
                case 10 -> disappearingModeTimestampSeconds = protoInputStream.readInt64();
                case 11 -> avatarUserSettings = it.auties.whatsapp.model.setting.AvatarUserSettingsSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.setting.GlobalSettings(lightThemeWallpaper, mediaVisibility, darkThemeWallpaper, autoDownloadWiFi, autoDownloadCellular, autoDownloadRoaming, showIndividualNotificationsPreview, showGroupNotificationsPreview, disappearingModeDuration, disappearingModeTimestampSeconds, avatarUserSettings);
    }

    public static int sizeOf(GlobalSettings object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var lightThemeWallpaper = object.lightThemeWallpaper();
        if (lightThemeWallpaper != null) {
            var lightThemeWallpaper0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(lightThemeWallpaper);
            if (lightThemeWallpaper0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                var lightThemeWallpaper0SerializedSize = it.auties.whatsapp.model.chat.ChatWallpaperSpec.sizeOf(lightThemeWallpaper0);
                protoSize += ProtobufOutputStream.getVarIntSize(lightThemeWallpaper0SerializedSize);
                protoSize += lightThemeWallpaper0SerializedSize;
            }
        }
        var mediaVisibility = object.mediaVisibility();
        if (mediaVisibility != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var mediaVisibilitySerializedSize = it.auties.whatsapp.model.media.MediaVisibilitySpec.sizeOf(mediaVisibility);
            protoSize += mediaVisibilitySerializedSize;
        }
        var darkThemeWallpaper = object.darkThemeWallpaper();
        if (darkThemeWallpaper != null) {
            var darkThemeWallpaper0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(darkThemeWallpaper);
            if (darkThemeWallpaper0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                var darkThemeWallpaper0SerializedSize = it.auties.whatsapp.model.chat.ChatWallpaperSpec.sizeOf(darkThemeWallpaper0);
                protoSize += ProtobufOutputStream.getVarIntSize(darkThemeWallpaper0SerializedSize);
                protoSize += darkThemeWallpaper0SerializedSize;
            }
        }
        var autoDownloadWiFi = object.autoDownloadWiFi();
        if (autoDownloadWiFi != null) {
            var autoDownloadWiFi0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(autoDownloadWiFi);
            if (autoDownloadWiFi0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                var autoDownloadWiFi0SerializedSize = it.auties.whatsapp.model.setting.AutoDownloadSettingsSpec.sizeOf(autoDownloadWiFi0);
                protoSize += ProtobufOutputStream.getVarIntSize(autoDownloadWiFi0SerializedSize);
                protoSize += autoDownloadWiFi0SerializedSize;
            }
        }
        var autoDownloadCellular = object.autoDownloadCellular();
        if (autoDownloadCellular != null) {
            var autoDownloadCellular0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(autoDownloadCellular);
            if (autoDownloadCellular0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                var autoDownloadCellular0SerializedSize = it.auties.whatsapp.model.setting.AutoDownloadSettingsSpec.sizeOf(autoDownloadCellular0);
                protoSize += ProtobufOutputStream.getVarIntSize(autoDownloadCellular0SerializedSize);
                protoSize += autoDownloadCellular0SerializedSize;
            }
        }
        var autoDownloadRoaming = object.autoDownloadRoaming();
        if (autoDownloadRoaming != null) {
            var autoDownloadRoaming0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(autoDownloadRoaming);
            if (autoDownloadRoaming0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(6, 2);
                var autoDownloadRoaming0SerializedSize = it.auties.whatsapp.model.setting.AutoDownloadSettingsSpec.sizeOf(autoDownloadRoaming0);
                protoSize += ProtobufOutputStream.getVarIntSize(autoDownloadRoaming0SerializedSize);
                protoSize += autoDownloadRoaming0SerializedSize;
            }
        }
        var showIndividualNotificationsPreview = object.showIndividualNotificationsPreview();
        protoSize += ProtobufOutputStream.getFieldSize(7, 0);
        protoSize += 1;
        var showGroupNotificationsPreview = object.showGroupNotificationsPreview();
        protoSize += ProtobufOutputStream.getFieldSize(8, 0);
        protoSize += 1;
        var disappearingModeDuration = object.disappearingModeDuration();
        protoSize += ProtobufOutputStream.getFieldSize(9, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(disappearingModeDuration);
        var disappearingModeTimestampSeconds = object.disappearingModeTimestampSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(10, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(disappearingModeTimestampSeconds);
        var avatarUserSettings = object.avatarUserSettings();
        if (avatarUserSettings != null) {
            protoSize += ProtobufOutputStream.getFieldSize(11, 2);
            var avatarUserSettingsSerializedSize = it.auties.whatsapp.model.setting.AvatarUserSettingsSpec.sizeOf(avatarUserSettings);
            protoSize += ProtobufOutputStream.getVarIntSize(avatarUserSettingsSerializedSize);
            protoSize += avatarUserSettingsSerializedSize;
        }
        return protoSize;
    }

}
