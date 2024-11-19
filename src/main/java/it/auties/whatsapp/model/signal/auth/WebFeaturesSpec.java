package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.WebFeatures;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class WebFeaturesSpec {
    public static byte[] encode(WebFeatures protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.labelsDisplay()));
        outputStream.writeInt32(2, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.voipIndividualOutgoing()));
        outputStream.writeInt32(3, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.groupsV3()));
        outputStream.writeInt32(4, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.groupsV3Create()));
        outputStream.writeInt32(5, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.changeNumberV2()));
        outputStream.writeInt32(6, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.queryStatusV3Thumbnail()));
        outputStream.writeInt32(7, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.liveLocations()));
        outputStream.writeInt32(8, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.queryVname()));
        outputStream.writeInt32(9, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.voipIndividualIncoming()));
        outputStream.writeInt32(10, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.quickRepliesQuery()));
        outputStream.writeInt32(11, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.payments()));
        outputStream.writeInt32(12, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.stickerPackQuery()));
        outputStream.writeInt32(13, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.liveLocationsFinal()));
        outputStream.writeInt32(14, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.labelsEdit()));
        outputStream.writeInt32(15, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.mediaUpload()));
        outputStream.writeInt32(18, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.mediaUploadRichQuickReplies()));
        outputStream.writeInt32(19, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.vnameV2()));
        outputStream.writeInt32(20, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.videoPlaybackUrl()));
        outputStream.writeInt32(21, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.statusRanking()));
        outputStream.writeInt32(22, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.voipIndividualVideo()));
        outputStream.writeInt32(23, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.thirdPartyStickers()));
        outputStream.writeInt32(24, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.frequentlyForwardedSetting()));
        outputStream.writeInt32(25, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.groupsV4JoinPermission()));
        outputStream.writeInt32(26, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.recentStickers()));
        outputStream.writeInt32(27, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.catalog()));
        outputStream.writeInt32(28, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.starredStickers()));
        outputStream.writeInt32(29, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.voipGroupCall()));
        outputStream.writeInt32(30, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.templateMessage()));
        outputStream.writeInt32(31, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.templateMessageInteractivity()));
        outputStream.writeInt32(32, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.ephemeralMessages()));
        outputStream.writeInt32(33, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.e2ENotificationSync()));
        outputStream.writeInt32(34, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.recentStickersV2()));
        outputStream.writeInt32(36, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.recentStickersV3()));
        outputStream.writeInt32(37, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.userNotice()));
        outputStream.writeInt32(39, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.support()));
        outputStream.writeInt32(40, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.groupUiiCleanup()));
        outputStream.writeInt32(41, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.groupDogfoodingInternalOnly()));
        outputStream.writeInt32(42, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.settingsSync()));
        outputStream.writeInt32(43, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.archiveV2()));
        outputStream.writeInt32(44, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.ephemeralAllowGroupMembers()));
        outputStream.writeInt32(45, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.ephemeral24HDuration()));
        outputStream.writeInt32(46, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.mdForceUpgrade()));
        outputStream.writeInt32(47, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.disappearingMode()));
        outputStream.writeInt32(48, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.externalMdOptInAvailable()));
        outputStream.writeInt32(49, it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.encode(protoInputObject.noDeleteMessageTimeLimit()));
        return outputStream.toByteArray();
    }

    public static WebFeatures decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static WebFeatures decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag labelsDisplay = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag voipIndividualOutgoing = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag groupsV3 = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag groupsV3Create = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag changeNumberV2 = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag queryStatusV3Thumbnail = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag liveLocations = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag queryVname = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag voipIndividualIncoming = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag quickRepliesQuery = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag payments = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag stickerPackQuery = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag liveLocationsFinal = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag labelsEdit = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag mediaUpload = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag mediaUploadRichQuickReplies = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag vnameV2 = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag videoPlaybackUrl = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag statusRanking = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag voipIndividualVideo = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag thirdPartyStickers = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag frequentlyForwardedSetting = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag groupsV4JoinPermission = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag recentStickers = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag catalog = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag starredStickers = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag voipGroupCall = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag templateMessage = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag templateMessageInteractivity = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag ephemeralMessages = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag e2ENotificationSync = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag recentStickersV2 = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag recentStickersV3 = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag userNotice = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag support = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag groupUiiCleanup = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag groupDogfoodingInternalOnly = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag settingsSync = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag archiveV2 = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag ephemeralAllowGroupMembers = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag ephemeral24HDuration = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag mdForceUpgrade = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag disappearingMode = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag externalMdOptInAvailable = null;
        it.auties.whatsapp.model.signal.auth.WebFeatures.WebFeaturesFlag noDeleteMessageTimeLimit = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> labelsDisplay = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 2 -> voipIndividualOutgoing = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 3 -> groupsV3 = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 4 -> groupsV3Create = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 5 -> changeNumberV2 = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 6 -> queryStatusV3Thumbnail = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 7 -> liveLocations = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 8 -> queryVname = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 9 -> voipIndividualIncoming = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 10 -> quickRepliesQuery = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 11 -> payments = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 12 -> stickerPackQuery = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 13 -> liveLocationsFinal = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 14 -> labelsEdit = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 15 -> mediaUpload = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 18 -> mediaUploadRichQuickReplies = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 19 -> vnameV2 = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 20 -> videoPlaybackUrl = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 21 -> statusRanking = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 22 -> voipIndividualVideo = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 23 -> thirdPartyStickers = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 24 -> frequentlyForwardedSetting = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 25 -> groupsV4JoinPermission = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 26 -> recentStickers = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 27 -> catalog = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 28 -> starredStickers = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 29 -> voipGroupCall = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 30 -> templateMessage = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 31 -> templateMessageInteractivity = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 32 -> ephemeralMessages = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 33 -> e2ENotificationSync = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 34 -> recentStickersV2 = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 36 -> recentStickersV3 = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 37 -> userNotice = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 39 -> support = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 40 -> groupUiiCleanup = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 41 -> groupDogfoodingInternalOnly = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 42 -> settingsSync = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 43 -> archiveV2 = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 44 -> ephemeralAllowGroupMembers = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 45 -> ephemeral24HDuration = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 46 -> mdForceUpgrade = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 47 -> disappearingMode = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 48 -> externalMdOptInAvailable = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 49 -> noDeleteMessageTimeLimit = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.decode(protoInputStream.readInt32()).orElse(null);
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.auth.WebFeatures(labelsDisplay, voipIndividualOutgoing, groupsV3, groupsV3Create, changeNumberV2, queryStatusV3Thumbnail, liveLocations, queryVname, voipIndividualIncoming, quickRepliesQuery, payments, stickerPackQuery, liveLocationsFinal, labelsEdit, mediaUpload, mediaUploadRichQuickReplies, vnameV2, videoPlaybackUrl, statusRanking, voipIndividualVideo, thirdPartyStickers, frequentlyForwardedSetting, groupsV4JoinPermission, recentStickers, catalog, starredStickers, voipGroupCall, templateMessage, templateMessageInteractivity, ephemeralMessages, e2ENotificationSync, recentStickersV2, recentStickersV3, userNotice, support, groupUiiCleanup, groupDogfoodingInternalOnly, settingsSync, archiveV2, ephemeralAllowGroupMembers, ephemeral24HDuration, mdForceUpgrade, disappearingMode, externalMdOptInAvailable, noDeleteMessageTimeLimit);
    }

    public static int sizeOf(WebFeatures object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var labelsDisplay = object.labelsDisplay();
        if (labelsDisplay != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var labelsDisplaySerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(labelsDisplay);
            protoSize += labelsDisplaySerializedSize;
        }
        var voipIndividualOutgoing = object.voipIndividualOutgoing();
        if (voipIndividualOutgoing != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var voipIndividualOutgoingSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(voipIndividualOutgoing);
            protoSize += voipIndividualOutgoingSerializedSize;
        }
        var groupsV3 = object.groupsV3();
        if (groupsV3 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            var groupsV3SerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(groupsV3);
            protoSize += groupsV3SerializedSize;
        }
        var groupsV3Create = object.groupsV3Create();
        if (groupsV3Create != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            var groupsV3CreateSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(groupsV3Create);
            protoSize += groupsV3CreateSerializedSize;
        }
        var changeNumberV2 = object.changeNumberV2();
        if (changeNumberV2 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(5, 2);
            var changeNumberV2SerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(changeNumberV2);
            protoSize += changeNumberV2SerializedSize;
        }
        var queryStatusV3Thumbnail = object.queryStatusV3Thumbnail();
        if (queryStatusV3Thumbnail != null) {
            protoSize += ProtobufOutputStream.getFieldSize(6, 2);
            var queryStatusV3ThumbnailSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(queryStatusV3Thumbnail);
            protoSize += queryStatusV3ThumbnailSerializedSize;
        }
        var liveLocations = object.liveLocations();
        if (liveLocations != null) {
            protoSize += ProtobufOutputStream.getFieldSize(7, 2);
            var liveLocationsSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(liveLocations);
            protoSize += liveLocationsSerializedSize;
        }
        var queryVname = object.queryVname();
        if (queryVname != null) {
            protoSize += ProtobufOutputStream.getFieldSize(8, 2);
            var queryVnameSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(queryVname);
            protoSize += queryVnameSerializedSize;
        }
        var voipIndividualIncoming = object.voipIndividualIncoming();
        if (voipIndividualIncoming != null) {
            protoSize += ProtobufOutputStream.getFieldSize(9, 2);
            var voipIndividualIncomingSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(voipIndividualIncoming);
            protoSize += voipIndividualIncomingSerializedSize;
        }
        var quickRepliesQuery = object.quickRepliesQuery();
        if (quickRepliesQuery != null) {
            protoSize += ProtobufOutputStream.getFieldSize(10, 2);
            var quickRepliesQuerySerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(quickRepliesQuery);
            protoSize += quickRepliesQuerySerializedSize;
        }
        var payments = object.payments();
        if (payments != null) {
            protoSize += ProtobufOutputStream.getFieldSize(11, 2);
            var paymentsSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(payments);
            protoSize += paymentsSerializedSize;
        }
        var stickerPackQuery = object.stickerPackQuery();
        if (stickerPackQuery != null) {
            protoSize += ProtobufOutputStream.getFieldSize(12, 2);
            var stickerPackQuerySerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(stickerPackQuery);
            protoSize += stickerPackQuerySerializedSize;
        }
        var liveLocationsFinal = object.liveLocationsFinal();
        if (liveLocationsFinal != null) {
            protoSize += ProtobufOutputStream.getFieldSize(13, 2);
            var liveLocationsFinalSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(liveLocationsFinal);
            protoSize += liveLocationsFinalSerializedSize;
        }
        var labelsEdit = object.labelsEdit();
        if (labelsEdit != null) {
            protoSize += ProtobufOutputStream.getFieldSize(14, 2);
            var labelsEditSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(labelsEdit);
            protoSize += labelsEditSerializedSize;
        }
        var mediaUpload = object.mediaUpload();
        if (mediaUpload != null) {
            protoSize += ProtobufOutputStream.getFieldSize(15, 2);
            var mediaUploadSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(mediaUpload);
            protoSize += mediaUploadSerializedSize;
        }
        var mediaUploadRichQuickReplies = object.mediaUploadRichQuickReplies();
        if (mediaUploadRichQuickReplies != null) {
            protoSize += ProtobufOutputStream.getFieldSize(18, 2);
            var mediaUploadRichQuickRepliesSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(mediaUploadRichQuickReplies);
            protoSize += mediaUploadRichQuickRepliesSerializedSize;
        }
        var vnameV2 = object.vnameV2();
        if (vnameV2 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(19, 2);
            var vnameV2SerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(vnameV2);
            protoSize += vnameV2SerializedSize;
        }
        var videoPlaybackUrl = object.videoPlaybackUrl();
        if (videoPlaybackUrl != null) {
            protoSize += ProtobufOutputStream.getFieldSize(20, 2);
            var videoPlaybackUrlSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(videoPlaybackUrl);
            protoSize += videoPlaybackUrlSerializedSize;
        }
        var statusRanking = object.statusRanking();
        if (statusRanking != null) {
            protoSize += ProtobufOutputStream.getFieldSize(21, 2);
            var statusRankingSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(statusRanking);
            protoSize += statusRankingSerializedSize;
        }
        var voipIndividualVideo = object.voipIndividualVideo();
        if (voipIndividualVideo != null) {
            protoSize += ProtobufOutputStream.getFieldSize(22, 2);
            var voipIndividualVideoSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(voipIndividualVideo);
            protoSize += voipIndividualVideoSerializedSize;
        }
        var thirdPartyStickers = object.thirdPartyStickers();
        if (thirdPartyStickers != null) {
            protoSize += ProtobufOutputStream.getFieldSize(23, 2);
            var thirdPartyStickersSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(thirdPartyStickers);
            protoSize += thirdPartyStickersSerializedSize;
        }
        var frequentlyForwardedSetting = object.frequentlyForwardedSetting();
        if (frequentlyForwardedSetting != null) {
            protoSize += ProtobufOutputStream.getFieldSize(24, 2);
            var frequentlyForwardedSettingSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(frequentlyForwardedSetting);
            protoSize += frequentlyForwardedSettingSerializedSize;
        }
        var groupsV4JoinPermission = object.groupsV4JoinPermission();
        if (groupsV4JoinPermission != null) {
            protoSize += ProtobufOutputStream.getFieldSize(25, 2);
            var groupsV4JoinPermissionSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(groupsV4JoinPermission);
            protoSize += groupsV4JoinPermissionSerializedSize;
        }
        var recentStickers = object.recentStickers();
        if (recentStickers != null) {
            protoSize += ProtobufOutputStream.getFieldSize(26, 2);
            var recentStickersSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(recentStickers);
            protoSize += recentStickersSerializedSize;
        }
        var catalog = object.catalog();
        if (catalog != null) {
            protoSize += ProtobufOutputStream.getFieldSize(27, 2);
            var catalogSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(catalog);
            protoSize += catalogSerializedSize;
        }
        var starredStickers = object.starredStickers();
        if (starredStickers != null) {
            protoSize += ProtobufOutputStream.getFieldSize(28, 2);
            var starredStickersSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(starredStickers);
            protoSize += starredStickersSerializedSize;
        }
        var voipGroupCall = object.voipGroupCall();
        if (voipGroupCall != null) {
            protoSize += ProtobufOutputStream.getFieldSize(29, 2);
            var voipGroupCallSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(voipGroupCall);
            protoSize += voipGroupCallSerializedSize;
        }
        var templateMessage = object.templateMessage();
        if (templateMessage != null) {
            protoSize += ProtobufOutputStream.getFieldSize(30, 2);
            var templateMessageSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(templateMessage);
            protoSize += templateMessageSerializedSize;
        }
        var templateMessageInteractivity = object.templateMessageInteractivity();
        if (templateMessageInteractivity != null) {
            protoSize += ProtobufOutputStream.getFieldSize(31, 2);
            var templateMessageInteractivitySerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(templateMessageInteractivity);
            protoSize += templateMessageInteractivitySerializedSize;
        }
        var ephemeralMessages = object.ephemeralMessages();
        if (ephemeralMessages != null) {
            protoSize += ProtobufOutputStream.getFieldSize(32, 2);
            var ephemeralMessagesSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(ephemeralMessages);
            protoSize += ephemeralMessagesSerializedSize;
        }
        var e2ENotificationSync = object.e2ENotificationSync();
        if (e2ENotificationSync != null) {
            protoSize += ProtobufOutputStream.getFieldSize(33, 2);
            var e2ENotificationSyncSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(e2ENotificationSync);
            protoSize += e2ENotificationSyncSerializedSize;
        }
        var recentStickersV2 = object.recentStickersV2();
        if (recentStickersV2 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(34, 2);
            var recentStickersV2SerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(recentStickersV2);
            protoSize += recentStickersV2SerializedSize;
        }
        var recentStickersV3 = object.recentStickersV3();
        if (recentStickersV3 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(36, 2);
            var recentStickersV3SerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(recentStickersV3);
            protoSize += recentStickersV3SerializedSize;
        }
        var userNotice = object.userNotice();
        if (userNotice != null) {
            protoSize += ProtobufOutputStream.getFieldSize(37, 2);
            var userNoticeSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(userNotice);
            protoSize += userNoticeSerializedSize;
        }
        var support = object.support();
        if (support != null) {
            protoSize += ProtobufOutputStream.getFieldSize(39, 2);
            var supportSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(support);
            protoSize += supportSerializedSize;
        }
        var groupUiiCleanup = object.groupUiiCleanup();
        if (groupUiiCleanup != null) {
            protoSize += ProtobufOutputStream.getFieldSize(40, 2);
            var groupUiiCleanupSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(groupUiiCleanup);
            protoSize += groupUiiCleanupSerializedSize;
        }
        var groupDogfoodingInternalOnly = object.groupDogfoodingInternalOnly();
        if (groupDogfoodingInternalOnly != null) {
            protoSize += ProtobufOutputStream.getFieldSize(41, 2);
            var groupDogfoodingInternalOnlySerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(groupDogfoodingInternalOnly);
            protoSize += groupDogfoodingInternalOnlySerializedSize;
        }
        var settingsSync = object.settingsSync();
        if (settingsSync != null) {
            protoSize += ProtobufOutputStream.getFieldSize(42, 2);
            var settingsSyncSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(settingsSync);
            protoSize += settingsSyncSerializedSize;
        }
        var archiveV2 = object.archiveV2();
        if (archiveV2 != null) {
            protoSize += ProtobufOutputStream.getFieldSize(43, 2);
            var archiveV2SerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(archiveV2);
            protoSize += archiveV2SerializedSize;
        }
        var ephemeralAllowGroupMembers = object.ephemeralAllowGroupMembers();
        if (ephemeralAllowGroupMembers != null) {
            protoSize += ProtobufOutputStream.getFieldSize(44, 2);
            var ephemeralAllowGroupMembersSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(ephemeralAllowGroupMembers);
            protoSize += ephemeralAllowGroupMembersSerializedSize;
        }
        var ephemeral24HDuration = object.ephemeral24HDuration();
        if (ephemeral24HDuration != null) {
            protoSize += ProtobufOutputStream.getFieldSize(45, 2);
            var ephemeral24HDurationSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(ephemeral24HDuration);
            protoSize += ephemeral24HDurationSerializedSize;
        }
        var mdForceUpgrade = object.mdForceUpgrade();
        if (mdForceUpgrade != null) {
            protoSize += ProtobufOutputStream.getFieldSize(46, 2);
            var mdForceUpgradeSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(mdForceUpgrade);
            protoSize += mdForceUpgradeSerializedSize;
        }
        var disappearingMode = object.disappearingMode();
        if (disappearingMode != null) {
            protoSize += ProtobufOutputStream.getFieldSize(47, 2);
            var disappearingModeSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(disappearingMode);
            protoSize += disappearingModeSerializedSize;
        }
        var externalMdOptInAvailable = object.externalMdOptInAvailable();
        if (externalMdOptInAvailable != null) {
            protoSize += ProtobufOutputStream.getFieldSize(48, 2);
            var externalMdOptInAvailableSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(externalMdOptInAvailable);
            protoSize += externalMdOptInAvailableSerializedSize;
        }
        var noDeleteMessageTimeLimit = object.noDeleteMessageTimeLimit();
        if (noDeleteMessageTimeLimit != null) {
            protoSize += ProtobufOutputStream.getFieldSize(49, 2);
            var noDeleteMessageTimeLimitSerializedSize = it.auties.whatsapp.model.signal.auth.WebFeaturesWebFeaturesFlagSpec.sizeOf(noDeleteMessageTimeLimit);
            protoSize += noDeleteMessageTimeLimitSerializedSize;
        }
        return protoSize;
    }

}
