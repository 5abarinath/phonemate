package com.droidbots.phonemate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by sabari on 3/3/18.
 */

public class Phone implements Serializable {
//    @SerializedName("phones")
//    Smartphone phone[];
//
//    public Smartphone[] getPhone() {
//        return phone;
//    }
//
//    public void setPhone(Smartphone[] phone) {
//        this.phone = phone;
//    }
@SerializedName("3G")
@Expose
private String _3G;
    @SerializedName("flipkart_link")
    @Expose
    private String flipkartLink;
    @SerializedName("3G Speed")
    @Expose
    private Object _3GSpeed;
    @SerializedName("Additional Content")
    @Expose
    private Object additionalContent;
    @SerializedName("Audio Formats")
    @Expose
    private Object audioFormats;
    @SerializedName("Audio Jack")
    @Expose
    private String audioJack;
    @SerializedName("Battery Capacity")
    @Expose
    private String batteryCapacity;
    @SerializedName("Battery Type")
    @Expose
    private Object batteryType;
    @SerializedName("Bluetooth Support")
    @Expose
    private String bluetoothSupport;
    @SerializedName("Bluetooth Version")
    @Expose
    private Object bluetoothVersion;
    @SerializedName("Browse Type")
    @Expose
    private String browseType;
    @SerializedName("Browser")
    @Expose
    private Object browser;
    @SerializedName("Business Phone")
    @Expose
    private Object businessPhone;
    @SerializedName("Call Divert")
    @Expose
    private Object callDivert;
    @SerializedName("Call Log Memory")
    @Expose
    private String callLogMemory;
    @SerializedName("Call Records")
    @Expose
    private Object callRecords;
    @SerializedName("Call Timer")
    @Expose
    private Object callTimer;
    @SerializedName("Call Wait/Hold")
    @Expose
    private Object callWaitHold;
    @SerializedName("Color")
    @Expose
    private String color;
    @SerializedName("Conference Call")
    @Expose
    private Object conferenceCall;
    @SerializedName("Cost")
    @Expose
    private String cost;
    @SerializedName("Covered in Warranty")
    @Expose
    private Object coveredInWarranty;
    @SerializedName("DLNA Support")
    @Expose
    private Object dLNASupport;
    @SerializedName("Depth")
    @Expose
    private Object depth;
    @SerializedName("Digital Zoom")
    @Expose
    private Object digitalZoom;
    @SerializedName("Display Colors")
    @Expose
    private Object displayColors;
    @SerializedName("Display Size")
    @Expose
    private String displaySize;
    @SerializedName("Display Type")
    @Expose
    private String displayType;
    @SerializedName("Domestic Warranty")
    @Expose
    private Object domesticWarranty;
    @SerializedName("Dual Battery")
    @Expose
    private Object dualBattery;
    @SerializedName("Dual Camera Lens")
    @Expose
    private String dualCameraLens;
    @SerializedName("EDGE")
    @Expose
    private Object eDGE;
    @SerializedName("EDGE Features")
    @Expose
    private Object eDGEFeatures;
    @SerializedName("Expandable Storage")
    @Expose
    private String expandableStorage;
    @SerializedName("FM Radio")
    @Expose
    private Object fMRadio;
    @SerializedName("FM Radio Recording")
    @Expose
    private Object fMRadioRecording;
    @SerializedName("Flash")
    @Expose
    private Object flash;
    @SerializedName("Frame Rate")
    @Expose
    private Object frameRate;
    @SerializedName("Full HD Recording")
    @Expose
    private Object fullHDRecording;
    @SerializedName("GPRS")
    @Expose
    private Object gPRS;
    @SerializedName("GPRS Features")
    @Expose
    private Object gPRSFeatures;
    @SerializedName("GPS Support")
    @Expose
    private String gPSSupport;
    @SerializedName("GPU")
    @Expose
    private Object gPU;
    @SerializedName("Games")
    @Expose
    private Object games;
    @SerializedName("Graphics PPI")
    @Expose
    private Object graphicsPPI;
    @SerializedName("HD Game Support")
    @Expose
    private Object hDGameSupport;
    @SerializedName("HD Recording")
    @Expose
    private Object hDRecording;
    @SerializedName("Hands Free")
    @Expose
    private Object handsFree;
    @SerializedName("Height")
    @Expose
    private Object height;
    @SerializedName("Hot SWAP Support")
    @Expose
    private Object hotSWAPSupport;
    @SerializedName("Hybrid Sim Slot")
    @Expose
    private String hybridSimSlot;
    @SerializedName("Image Editor")
    @Expose
    private Object imageEditor;
    @SerializedName("Imgsrc")
    @Expose
    private String imgsrc;
    @SerializedName("Important Apps")
    @Expose
    private String importantApps;
    @SerializedName("In The Box")
    @Expose
    private String inTheBox;
    @SerializedName("Infrared")
    @Expose
    private Object infrared;
    @SerializedName("Instant Message")
    @Expose
    private Object instantMessage;
    @SerializedName("Internal Storage")
    @Expose
    private String internalStorage;
    @SerializedName("International Warranty")
    @Expose
    private Object internationalWarranty;
    @SerializedName("Internet Connectivity")
    @Expose
    private String internetConnectivity;
    @SerializedName("JAVA Support")
    @Expose
    private Object jAVASupport;
    @SerializedName("Java Application")
    @Expose
    private Object javaApplication;
    @SerializedName("Keypad")
    @Expose
    private Object keypad;
    @SerializedName("Keypad Type")
    @Expose
    private Object keypadType;
    @SerializedName("Logs")
    @Expose
    private Object logs;
    @SerializedName("MMS")
    @Expose
    private Object mMS;
    @SerializedName("Map Support")
    @Expose
    private String mapSupport;
    @SerializedName("Memory Card Slot Type")
    @Expose
    private Object memoryCardSlotType;
    @SerializedName("Micro USB Port")
    @Expose
    private Object microUSBPort;
    @SerializedName("Micro USB Version")
    @Expose
    private Object microUSBVersion;
    @SerializedName("Mini HDMI Port")
    @Expose
    private Object miniHDMIPort;
    @SerializedName("Mini USB Port")
    @Expose
    private Object miniUSBPort;
    @SerializedName("Mini USB Version")
    @Expose
    private Object miniUSBVersion;
    @SerializedName("Mobile Tracker")
    @Expose
    private Object mobileTracker;
    @SerializedName("Model Name")
    @Expose
    private String modelName;
    @SerializedName("Model Number")
    @Expose
    private Object modelNumber;
    @SerializedName("Music Player")
    @Expose
    private Object musicPlayer;
    @SerializedName("NFC")
    @Expose
    private Object nFC;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Network Type")
    @Expose
    private String networkType;
    @SerializedName("Not Covered in Warranty")
    @Expose
    private Object notCoveredInWarranty;
    @SerializedName("OTG Compatible")
    @Expose
    private String oTGCompatible;
    @SerializedName("Operating Frequency")
    @Expose
    private Object operatingFrequency;
    @SerializedName("Operating System")
    @Expose
    private String operatingSystem;
    @SerializedName("Optical Zoom")
    @Expose
    private Object opticalZoom;
    @SerializedName("Other Display Features")
    @Expose
    private Object otherDisplayFeatures;
    @SerializedName("Other Features")
    @Expose
    private String otherFeatures;
    @SerializedName("Phone Book")
    @Expose
    private Object phoneBook;
    @SerializedName("Phone Book Memory")
    @Expose
    private Object phoneBookMemory;
    @SerializedName("Pre-installed Browser")
    @Expose
    private Object preInstalledBrowser;
    @SerializedName("Predictive Text Input")
    @Expose
    private Object predictiveTextInput;
    @SerializedName("Primary Camera")
    @Expose
    private String primaryCamera;
    @SerializedName("Primary Camera Available")
    @Expose
    private String primaryCameraAvailable;
    @SerializedName("Primary Camera Features")
    @Expose
    private String primaryCameraFeatures;
    @SerializedName("Primary Clock Speed")
    @Expose
    private String primaryClockSpeed;
    @SerializedName("Processor Core")
    @Expose
    private String processorCore;
    @SerializedName("Processor Type")
    @Expose
    private String processorType;
    @SerializedName("Quick Charging")
    @Expose
    private Object quickCharging;
    @SerializedName("RAM")
    @Expose
    private String rAM;
    @SerializedName("Removable Battery")
    @Expose
    private Object removableBattery;
    @SerializedName("Resolution")
    @Expose
    private String resolution;
    @SerializedName("Resolution Type")
    @Expose
    private Object resolutionType;
    @SerializedName("Ringtones Format")
    @Expose
    private Object ringtonesFormat;
    @SerializedName("SIM Access")
    @Expose
    private Object sIMAccess;
    @SerializedName("SIM Size")
    @Expose
    private String sIMSize;
    @SerializedName("SIM Type")
    @Expose
    private String sIMType;
    @SerializedName("SMS")
    @Expose
    private String sMS;
    @SerializedName("SMS Memory")
    @Expose
    private String sMSMemory;
    @SerializedName("Secondary Camera")
    @Expose
    private String secondaryCamera;
    @SerializedName("Secondary Camera Available")
    @Expose
    private String secondaryCameraAvailable;
    @SerializedName("Secondary Camera Features")
    @Expose
    private Object secondaryCameraFeatures;
    @SerializedName("Secondary Clock Speed")
    @Expose
    private Object secondaryClockSpeed;
    @SerializedName("Sensors")
    @Expose
    private String sensors;
    @SerializedName("Series")
    @Expose
    private Object series;
    @SerializedName("Smartphone")
    @Expose
    private String smartphone;
    @SerializedName("Social Networking Phone")
    @Expose
    private Object socialNetworkingPhone;
    @SerializedName("Sound Enhancements")
    @Expose
    private Object soundEnhancements;
    @SerializedName("Speaker Phone")
    @Expose
    private Object speakerPhone;
    @SerializedName("Speed Dialing")
    @Expose
    private Object speedDialing;
    @SerializedName("Supported Languages")
    @Expose
    private Object supportedLanguages;
    @SerializedName("Supported Memory Card Type")
    @Expose
    private String supportedMemoryCardType;
    @SerializedName("Supported Networks")
    @Expose
    private String supportedNetworks;
    @SerializedName("TV Out")
    @Expose
    private Object tVOut;
    @SerializedName("Talk Time")
    @Expose
    private String talkTime;
    @SerializedName("Total Memory")
    @Expose
    private Object totalMemory;
    @SerializedName("Touchscreen")
    @Expose
    private String touchscreen;
    @SerializedName("Touchscreen Type")
    @Expose
    private String touchscreenType;
    @SerializedName("USB Connectivity")
    @Expose
    private Object uSBConnectivity;
    @SerializedName("USB Tethering")
    @Expose
    private Object uSBTethering;
    @SerializedName("Unnamed: 0")
    @Expose
    private int unnamed0;
    @SerializedName("Unnamed: 147")
    @Expose
    private Object unnamed147;
    @SerializedName("Unnamed: 148")
    @Expose
    private Object unnamed148;
    @SerializedName("Unnamed: 149")
    @Expose
    private Object unnamed149;
    @SerializedName("Upgradable Operating System")
    @Expose
    private Object upgradableOperatingSystem;
    @SerializedName("User Interface")
    @Expose
    private Object userInterface;
    @SerializedName("User Memory")
    @Expose
    private Object userMemory;
    @SerializedName("Video Call Support")
    @Expose
    private Object videoCallSupport;
    @SerializedName("Video Formats")
    @Expose
    private Object videoFormats;
    @SerializedName("Video Recording")
    @Expose
    private String videoRecording;
    @SerializedName("Video Recording Resolution")
    @Expose
    private Object videoRecordingResolution;
    @SerializedName("Voice Input")
    @Expose
    private String voiceInput;
    @SerializedName("WAP")
    @Expose
    private Object wAP;
    @SerializedName("WAP Version")
    @Expose
    private Object wAPVersion;
    @SerializedName("Warranty Service Type")
    @Expose
    private Object warrantyServiceType;
    @SerializedName("Warranty Summary")
    @Expose
    private String warrantySummary;
    @SerializedName("Weight")
    @Expose
    private Object weight;
    @SerializedName("Wi-Fi")
    @Expose
    private String wiFi;
    @SerializedName("Wi-Fi Hotspot")
    @Expose
    private Object wiFiHotspot;
    @SerializedName("Wi-Fi Version")
    @Expose
    private Object wiFiVersion;
    @SerializedName("Width")
    @Expose
    private Object width;
    @SerializedName("reviewlink")
    @Expose
    private String reviewlink;
    private final static long serialVersionUID = -8536114115796334666L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Phone() {
    }

    /**
     *
     * @param flash
     * @param internetConnectivity
     * @param networkType
     * @param businessPhone
     * @param phoneBook
     * @param phoneBookMemory
     * @param importantApps
     * @param handsFree
     * @param userInterface
     * @param secondaryCamera
     * @param miniUSBPort
     * @param wAP
     * @param sIMType
     * @param frameRate
     * @param secondaryCameraAvailable
     * @param batteryCapacity
     * @param opticalZoom
     * @param memoryCardSlotType
     * @param games
     * @param resolutionType
     * @param quickCharging
     * @param inTheBox
     * @param displaySize
     * @param domesticWarranty
     * @param rAM
     * @param sIMAccess
     * @param supportedMemoryCardType
     * @param preInstalledBrowser
     * @param microUSBVersion
     * @param keypadType
     * @param otherDisplayFeatures
     * @param unnamed148
     * @param warrantySummary
     * @param unnamed147
     * @param internalStorage
     * @param unnamed149
     * @param callWaitHold
     * @param modelNumber
     * @param ringtonesFormat
     * @param series
     * @param callDivert
     * @param bluetoothVersion
     * @param miniUSBVersion
     * @param supportedLanguages
     * @param sMSMemory
     * @param jAVASupport
     * @param audioFormats
     * @param browseType
     * @param warrantyServiceType
     * @param secondaryCameraFeatures
     * @param primaryClockSpeed
     * @param videoFormats
     * @param oTGCompatible
     * @param gPSSupport
     * @param primaryCameraFeatures
     * @param browser
     * @param additionalContent
     * @param notCoveredInWarranty
     * @param digitalZoom
     * @param hDRecording
     * @param audioJack
     * @param gPRS
     * @param fMRadioRecording
     * @param expandableStorage
     * @param _3G
     * @param upgradableOperatingSystem
     * @param totalMemory
     * @param gPRSFeatures
     * @param mapSupport
     * @param logs
     * @param talkTime
     * @param gPU
     * @param videoCallSupport
     * @param javaApplication
     * @param dualBattery
     * @param wiFiHotspot
     * @param dualCameraLens
     * @param conferenceCall
     * @param microUSBPort
     * @param processorType
     * @param musicPlayer
     * @param displayType
     * @param reviewlink
     * @param eDGEFeatures
     * @param hybridSimSlot
     * @param smartphone
     * @param graphicsPPI
     * @param mobileTracker
     * @param socialNetworkingPhone
     * @param videoRecording
     * @param height
     * @param displayColors
     * @param soundEnhancements
     * @param dLNASupport
     * @param wiFi
     * @param keypad
     * @param videoRecordingResolution
     * @param uSBConnectivity
     * @param processorCore
     * @param mMS
     * @param eDGE
     * @param nFC
     * @param wAPVersion
     * @param fMRadio
     * @param sMS
     * @param tVOut
     * @param uSBTethering
     * @param width
     * @param supportedNetworks
     * @param cost
     * @param depth
     * @param primaryCameraAvailable
     * @param modelName
     * @param primaryCamera
     * @param sIMSize
     * @param miniHDMIPort
     * @param imgsrc
     * @param callTimer
     * @param unnamed0
     * @param speakerPhone
     * @param operatingSystem
     * @param weight
     * @param bluetoothSupport
     * @param hDGameSupport
     * @param voiceInput
     * @param resolution
     * @param internationalWarranty
     * @param otherFeatures
     * @param name
     * @param imageEditor
     * @param touchscreenType
     * @param hotSWAPSupport
     * @param fullHDRecording
     * @param removableBattery
     * @param _3GSpeed
     * @param secondaryClockSpeed
     * @param batteryType
     * @param infrared
     * @param callLogMemory
     * @param callRecords
     * @param sensors
     * @param wiFiVersion
     * @param coveredInWarranty
     * @param instantMessage
     * @param operatingFrequency
     * @param predictiveTextInput
     * @param color
     * @param speedDialing
     * @param touchscreen
     * @param userMemory
     */
    public Phone(String _3G, Object _3GSpeed, Object additionalContent, Object audioFormats, String audioJack, String batteryCapacity, Object batteryType, String bluetoothSupport, Object bluetoothVersion, String browseType, Object browser, Object businessPhone, Object callDivert, String callLogMemory, Object callRecords, Object callTimer, Object callWaitHold, String color, Object conferenceCall, String cost, Object coveredInWarranty, Object dLNASupport, Object depth, Object digitalZoom, Object displayColors, String displaySize, String displayType, Object domesticWarranty, Object dualBattery, String dualCameraLens, Object eDGE, Object eDGEFeatures, String expandableStorage, Object fMRadio, Object fMRadioRecording, Object flash, Object frameRate, Object fullHDRecording, Object gPRS, Object gPRSFeatures, String gPSSupport, Object gPU, Object games, Object graphicsPPI, Object hDGameSupport, Object hDRecording, Object handsFree, Object height, Object hotSWAPSupport, String hybridSimSlot, Object imageEditor, String imgsrc, String importantApps, String inTheBox, Object infrared, Object instantMessage, String internalStorage, Object internationalWarranty, String internetConnectivity, Object jAVASupport, Object javaApplication, Object keypad, Object keypadType, Object logs, Object mMS, String mapSupport, Object memoryCardSlotType, Object microUSBPort, Object microUSBVersion, Object miniHDMIPort, Object miniUSBPort, Object miniUSBVersion, Object mobileTracker, String modelName, Object modelNumber, Object musicPlayer, Object nFC, String name, String networkType, Object notCoveredInWarranty, String oTGCompatible, Object operatingFrequency, String operatingSystem, Object opticalZoom, Object otherDisplayFeatures, String otherFeatures, Object phoneBook, Object phoneBookMemory, Object preInstalledBrowser, Object predictiveTextInput, String primaryCamera, String primaryCameraAvailable, String primaryCameraFeatures, String primaryClockSpeed, String processorCore, String processorType, Object quickCharging, String rAM, Object removableBattery, String resolution, Object resolutionType, Object ringtonesFormat, Object sIMAccess, String sIMSize, String sIMType, String sMS, String sMSMemory, String secondaryCamera, String secondaryCameraAvailable, Object secondaryCameraFeatures, Object secondaryClockSpeed, String sensors, Object series, String smartphone, Object socialNetworkingPhone, Object soundEnhancements, Object speakerPhone, Object speedDialing, Object supportedLanguages, String supportedMemoryCardType, String supportedNetworks, Object tVOut, String talkTime, Object totalMemory, String touchscreen, String touchscreenType, Object uSBConnectivity, Object uSBTethering, int unnamed0, Object unnamed147, Object unnamed148, Object unnamed149, Object upgradableOperatingSystem, Object userInterface, Object userMemory, Object videoCallSupport, Object videoFormats, String videoRecording, Object videoRecordingResolution, String voiceInput, Object wAP, Object wAPVersion, Object warrantyServiceType, String warrantySummary, Object weight, String wiFi, Object wiFiHotspot, Object wiFiVersion, Object width, String reviewlink) {
        super();
        this._3G = _3G;
        this._3GSpeed = _3GSpeed;
        this.additionalContent = additionalContent;
        this.audioFormats = audioFormats;
        this.audioJack = audioJack;
        this.batteryCapacity = batteryCapacity;
        this.batteryType = batteryType;
        this.bluetoothSupport = bluetoothSupport;
        this.bluetoothVersion = bluetoothVersion;
        this.browseType = browseType;
        this.browser = browser;
        this.businessPhone = businessPhone;
        this.callDivert = callDivert;
        this.callLogMemory = callLogMemory;
        this.callRecords = callRecords;
        this.callTimer = callTimer;
        this.callWaitHold = callWaitHold;
        this.color = color;
        this.conferenceCall = conferenceCall;
        this.cost = cost;
        this.coveredInWarranty = coveredInWarranty;
        this.dLNASupport = dLNASupport;
        this.depth = depth;
        this.digitalZoom = digitalZoom;
        this.displayColors = displayColors;
        this.displaySize = displaySize;
        this.displayType = displayType;
        this.domesticWarranty = domesticWarranty;
        this.dualBattery = dualBattery;
        this.dualCameraLens = dualCameraLens;
        this.eDGE = eDGE;
        this.eDGEFeatures = eDGEFeatures;
        this.expandableStorage = expandableStorage;
        this.fMRadio = fMRadio;
        this.fMRadioRecording = fMRadioRecording;
        this.flash = flash;
        this.frameRate = frameRate;
        this.fullHDRecording = fullHDRecording;
        this.gPRS = gPRS;
        this.gPRSFeatures = gPRSFeatures;
        this.gPSSupport = gPSSupport;
        this.gPU = gPU;
        this.games = games;
        this.graphicsPPI = graphicsPPI;
        this.hDGameSupport = hDGameSupport;
        this.hDRecording = hDRecording;
        this.handsFree = handsFree;
        this.height = height;
        this.hotSWAPSupport = hotSWAPSupport;
        this.hybridSimSlot = hybridSimSlot;
        this.imageEditor = imageEditor;
        this.imgsrc = imgsrc;
        this.importantApps = importantApps;
        this.inTheBox = inTheBox;
        this.infrared = infrared;
        this.instantMessage = instantMessage;
        this.internalStorage = internalStorage;
        this.internationalWarranty = internationalWarranty;
        this.internetConnectivity = internetConnectivity;
        this.jAVASupport = jAVASupport;
        this.javaApplication = javaApplication;
        this.keypad = keypad;
        this.keypadType = keypadType;
        this.logs = logs;
        this.mMS = mMS;
        this.mapSupport = mapSupport;
        this.memoryCardSlotType = memoryCardSlotType;
        this.microUSBPort = microUSBPort;
        this.microUSBVersion = microUSBVersion;
        this.miniHDMIPort = miniHDMIPort;
        this.miniUSBPort = miniUSBPort;
        this.miniUSBVersion = miniUSBVersion;
        this.mobileTracker = mobileTracker;
        this.modelName = modelName;
        this.modelNumber = modelNumber;
        this.musicPlayer = musicPlayer;
        this.nFC = nFC;
        this.name = name;
        this.networkType = networkType;
        this.notCoveredInWarranty = notCoveredInWarranty;
        this.oTGCompatible = oTGCompatible;
        this.operatingFrequency = operatingFrequency;
        this.operatingSystem = operatingSystem;
        this.opticalZoom = opticalZoom;
        this.otherDisplayFeatures = otherDisplayFeatures;
        this.otherFeatures = otherFeatures;
        this.phoneBook = phoneBook;
        this.phoneBookMemory = phoneBookMemory;
        this.preInstalledBrowser = preInstalledBrowser;
        this.predictiveTextInput = predictiveTextInput;
        this.primaryCamera = primaryCamera;
        this.primaryCameraAvailable = primaryCameraAvailable;
        this.primaryCameraFeatures = primaryCameraFeatures;
        this.primaryClockSpeed = primaryClockSpeed;
        this.processorCore = processorCore;
        this.processorType = processorType;
        this.quickCharging = quickCharging;
        this.rAM = rAM;
        this.removableBattery = removableBattery;
        this.resolution = resolution;
        this.resolutionType = resolutionType;
        this.ringtonesFormat = ringtonesFormat;
        this.sIMAccess = sIMAccess;
        this.sIMSize = sIMSize;
        this.sIMType = sIMType;
        this.sMS = sMS;
        this.sMSMemory = sMSMemory;
        this.secondaryCamera = secondaryCamera;
        this.secondaryCameraAvailable = secondaryCameraAvailable;
        this.secondaryCameraFeatures = secondaryCameraFeatures;
        this.secondaryClockSpeed = secondaryClockSpeed;
        this.sensors = sensors;
        this.series = series;
        this.smartphone = smartphone;
        this.socialNetworkingPhone = socialNetworkingPhone;
        this.soundEnhancements = soundEnhancements;
        this.speakerPhone = speakerPhone;
        this.speedDialing = speedDialing;
        this.supportedLanguages = supportedLanguages;
        this.supportedMemoryCardType = supportedMemoryCardType;
        this.supportedNetworks = supportedNetworks;
        this.tVOut = tVOut;
        this.talkTime = talkTime;
        this.totalMemory = totalMemory;
        this.touchscreen = touchscreen;
        this.touchscreenType = touchscreenType;
        this.uSBConnectivity = uSBConnectivity;
        this.uSBTethering = uSBTethering;
        this.unnamed0 = unnamed0;
        this.unnamed147 = unnamed147;
        this.unnamed148 = unnamed148;
        this.unnamed149 = unnamed149;
        this.upgradableOperatingSystem = upgradableOperatingSystem;
        this.userInterface = userInterface;
        this.userMemory = userMemory;
        this.videoCallSupport = videoCallSupport;
        this.videoFormats = videoFormats;
        this.videoRecording = videoRecording;
        this.videoRecordingResolution = videoRecordingResolution;
        this.voiceInput = voiceInput;
        this.wAP = wAP;
        this.wAPVersion = wAPVersion;
        this.warrantyServiceType = warrantyServiceType;
        this.warrantySummary = warrantySummary;
        this.weight = weight;
        this.wiFi = wiFi;
        this.wiFiHotspot = wiFiHotspot;
        this.wiFiVersion = wiFiVersion;
        this.width = width;
        this.reviewlink = reviewlink;
    }

    public String getFlipkartLink() {
        return flipkartLink;
    }

    public void setFlipkartLink(String flipkartLink) {
        this.flipkartLink = flipkartLink;
    }

    public String get3G() {
        return _3G;
    }

    public void set3G(String _3G) {
        this._3G = _3G;
    }

    public Phone with3G(String _3G) {
        this._3G = _3G;
        return this;
    }

    public Object get3GSpeed() {
        return _3GSpeed;
    }

    public void set3GSpeed(Object _3GSpeed) {
        this._3GSpeed = _3GSpeed;
    }

    public Phone with3GSpeed(Object _3GSpeed) {
        this._3GSpeed = _3GSpeed;
        return this;
    }

    public Object getAdditionalContent() {
        return additionalContent;
    }

    public void setAdditionalContent(Object additionalContent) {
        this.additionalContent = additionalContent;
    }

    public Phone withAdditionalContent(Object additionalContent) {
        this.additionalContent = additionalContent;
        return this;
    }

    public Object getAudioFormats() {
        return audioFormats;
    }

    public void setAudioFormats(Object audioFormats) {
        this.audioFormats = audioFormats;
    }

    public Phone withAudioFormats(Object audioFormats) {
        this.audioFormats = audioFormats;
        return this;
    }

    public String getAudioJack() {
        return audioJack;
    }

    public void setAudioJack(String audioJack) {
        this.audioJack = audioJack;
    }

    public Phone withAudioJack(String audioJack) {
        this.audioJack = audioJack;
        return this;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Phone withBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
        return this;
    }

    public Object getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(Object batteryType) {
        this.batteryType = batteryType;
    }

    public Phone withBatteryType(Object batteryType) {
        this.batteryType = batteryType;
        return this;
    }

    public String getBluetoothSupport() {
        return bluetoothSupport;
    }

    public void setBluetoothSupport(String bluetoothSupport) {
        this.bluetoothSupport = bluetoothSupport;
    }

    public Phone withBluetoothSupport(String bluetoothSupport) {
        this.bluetoothSupport = bluetoothSupport;
        return this;
    }

    public Object getBluetoothVersion() {
        return bluetoothVersion;
    }

    public void setBluetoothVersion(Object bluetoothVersion) {
        this.bluetoothVersion = bluetoothVersion;
    }

    public Phone withBluetoothVersion(Object bluetoothVersion) {
        this.bluetoothVersion = bluetoothVersion;
        return this;
    }

    public String getBrowseType() {
        return browseType;
    }

    public void setBrowseType(String browseType) {
        this.browseType = browseType;
    }

    public Phone withBrowseType(String browseType) {
        this.browseType = browseType;
        return this;
    }

    public Object getBrowser() {
        return browser;
    }

    public void setBrowser(Object browser) {
        this.browser = browser;
    }

    public Phone withBrowser(Object browser) {
        this.browser = browser;
        return this;
    }

    public Object getBusinessPhone() {
        return businessPhone;
    }

    public void setBusinessPhone(Object businessPhone) {
        this.businessPhone = businessPhone;
    }

    public Phone withBusinessPhone(Object businessPhone) {
        this.businessPhone = businessPhone;
        return this;
    }

    public Object getCallDivert() {
        return callDivert;
    }

    public void setCallDivert(Object callDivert) {
        this.callDivert = callDivert;
    }

    public Phone withCallDivert(Object callDivert) {
        this.callDivert = callDivert;
        return this;
    }

    public String getCallLogMemory() {
        return callLogMemory;
    }

    public void setCallLogMemory(String callLogMemory) {
        this.callLogMemory = callLogMemory;
    }

    public Phone withCallLogMemory(String callLogMemory) {
        this.callLogMemory = callLogMemory;
        return this;
    }

    public Object getCallRecords() {
        return callRecords;
    }

    public void setCallRecords(Object callRecords) {
        this.callRecords = callRecords;
    }

    public Phone withCallRecords(Object callRecords) {
        this.callRecords = callRecords;
        return this;
    }

    public Object getCallTimer() {
        return callTimer;
    }

    public void setCallTimer(Object callTimer) {
        this.callTimer = callTimer;
    }

    public Phone withCallTimer(Object callTimer) {
        this.callTimer = callTimer;
        return this;
    }

    public Object getCallWaitHold() {
        return callWaitHold;
    }

    public void setCallWaitHold(Object callWaitHold) {
        this.callWaitHold = callWaitHold;
    }

    public Phone withCallWaitHold(Object callWaitHold) {
        this.callWaitHold = callWaitHold;
        return this;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Phone withColor(String color) {
        this.color = color;
        return this;
    }

    public Object getConferenceCall() {
        return conferenceCall;
    }

    public void setConferenceCall(Object conferenceCall) {
        this.conferenceCall = conferenceCall;
    }

    public Phone withConferenceCall(Object conferenceCall) {
        this.conferenceCall = conferenceCall;
        return this;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Phone withCost(String cost) {
        this.cost = cost;
        return this;
    }

    public Object getCoveredInWarranty() {
        return coveredInWarranty;
    }

    public void setCoveredInWarranty(Object coveredInWarranty) {
        this.coveredInWarranty = coveredInWarranty;
    }

    public Phone withCoveredInWarranty(Object coveredInWarranty) {
        this.coveredInWarranty = coveredInWarranty;
        return this;
    }

    public Object getDLNASupport() {
        return dLNASupport;
    }

    public void setDLNASupport(Object dLNASupport) {
        this.dLNASupport = dLNASupport;
    }

    public Phone withDLNASupport(Object dLNASupport) {
        this.dLNASupport = dLNASupport;
        return this;
    }

    public Object getDepth() {
        return depth;
    }

    public void setDepth(Object depth) {
        this.depth = depth;
    }

    public Phone withDepth(Object depth) {
        this.depth = depth;
        return this;
    }

    public Object getDigitalZoom() {
        return digitalZoom;
    }

    public void setDigitalZoom(Object digitalZoom) {
        this.digitalZoom = digitalZoom;
    }

    public Phone withDigitalZoom(Object digitalZoom) {
        this.digitalZoom = digitalZoom;
        return this;
    }

    public Object getDisplayColors() {
        return displayColors;
    }

    public void setDisplayColors(Object displayColors) {
        this.displayColors = displayColors;
    }

    public Phone withDisplayColors(Object displayColors) {
        this.displayColors = displayColors;
        return this;
    }

    public String getDisplaySize() {
        return displaySize;
    }

    public void setDisplaySize(String displaySize) {
        this.displaySize = displaySize;
    }

    public Phone withDisplaySize(String displaySize) {
        this.displaySize = displaySize;
        return this;
    }

    public String getDisplayType() {
        return displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public Phone withDisplayType(String displayType) {
        this.displayType = displayType;
        return this;
    }

    public Object getDomesticWarranty() {
        return domesticWarranty;
    }

    public void setDomesticWarranty(Object domesticWarranty) {
        this.domesticWarranty = domesticWarranty;
    }

    public Phone withDomesticWarranty(Object domesticWarranty) {
        this.domesticWarranty = domesticWarranty;
        return this;
    }

    public Object getDualBattery() {
        return dualBattery;
    }

    public void setDualBattery(Object dualBattery) {
        this.dualBattery = dualBattery;
    }

    public Phone withDualBattery(Object dualBattery) {
        this.dualBattery = dualBattery;
        return this;
    }

    public String getDualCameraLens() {
        return dualCameraLens;
    }

    public void setDualCameraLens(String dualCameraLens) {
        this.dualCameraLens = dualCameraLens;
    }

    public Phone withDualCameraLens(String dualCameraLens) {
        this.dualCameraLens = dualCameraLens;
        return this;
    }

    public Object getEDGE() {
        return eDGE;
    }

    public void setEDGE(Object eDGE) {
        this.eDGE = eDGE;
    }

    public Phone withEDGE(Object eDGE) {
        this.eDGE = eDGE;
        return this;
    }

    public Object getEDGEFeatures() {
        return eDGEFeatures;
    }

    public void setEDGEFeatures(Object eDGEFeatures) {
        this.eDGEFeatures = eDGEFeatures;
    }

    public Phone withEDGEFeatures(Object eDGEFeatures) {
        this.eDGEFeatures = eDGEFeatures;
        return this;
    }

    public String getExpandableStorage() {
        return expandableStorage;
    }

    public void setExpandableStorage(String expandableStorage) {
        this.expandableStorage = expandableStorage;
    }

    public Phone withExpandableStorage(String expandableStorage) {
        this.expandableStorage = expandableStorage;
        return this;
    }

    public Object getFMRadio() {
        return fMRadio;
    }

    public void setFMRadio(Object fMRadio) {
        this.fMRadio = fMRadio;
    }

    public Phone withFMRadio(Object fMRadio) {
        this.fMRadio = fMRadio;
        return this;
    }

    public Object getFMRadioRecording() {
        return fMRadioRecording;
    }

    public void setFMRadioRecording(Object fMRadioRecording) {
        this.fMRadioRecording = fMRadioRecording;
    }

    public Phone withFMRadioRecording(Object fMRadioRecording) {
        this.fMRadioRecording = fMRadioRecording;
        return this;
    }

    public Object getFlash() {
        return flash;
    }

    public void setFlash(Object flash) {
        this.flash = flash;
    }

    public Phone withFlash(Object flash) {
        this.flash = flash;
        return this;
    }

    public Object getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(Object frameRate) {
        this.frameRate = frameRate;
    }

    public Phone withFrameRate(Object frameRate) {
        this.frameRate = frameRate;
        return this;
    }

    public Object getFullHDRecording() {
        return fullHDRecording;
    }

    public void setFullHDRecording(Object fullHDRecording) {
        this.fullHDRecording = fullHDRecording;
    }

    public Phone withFullHDRecording(Object fullHDRecording) {
        this.fullHDRecording = fullHDRecording;
        return this;
    }

    public Object getGPRS() {
        return gPRS;
    }

    public void setGPRS(Object gPRS) {
        this.gPRS = gPRS;
    }

    public Phone withGPRS(Object gPRS) {
        this.gPRS = gPRS;
        return this;
    }

    public Object getGPRSFeatures() {
        return gPRSFeatures;
    }

    public void setGPRSFeatures(Object gPRSFeatures) {
        this.gPRSFeatures = gPRSFeatures;
    }

    public Phone withGPRSFeatures(Object gPRSFeatures) {
        this.gPRSFeatures = gPRSFeatures;
        return this;
    }

    public String getGPSSupport() {
        return gPSSupport;
    }

    public void setGPSSupport(String gPSSupport) {
        this.gPSSupport = gPSSupport;
    }

    public Phone withGPSSupport(String gPSSupport) {
        this.gPSSupport = gPSSupport;
        return this;
    }

    public Object getGPU() {
        return gPU;
    }

    public void setGPU(Object gPU) {
        this.gPU = gPU;
    }

    public Phone withGPU(Object gPU) {
        this.gPU = gPU;
        return this;
    }

    public Object getGames() {
        return games;
    }

    public void setGames(Object games) {
        this.games = games;
    }

    public Phone withGames(Object games) {
        this.games = games;
        return this;
    }

    public Object getGraphicsPPI() {
        return graphicsPPI;
    }

    public void setGraphicsPPI(Object graphicsPPI) {
        this.graphicsPPI = graphicsPPI;
    }

    public Phone withGraphicsPPI(Object graphicsPPI) {
        this.graphicsPPI = graphicsPPI;
        return this;
    }

    public Object getHDGameSupport() {
        return hDGameSupport;
    }

    public void setHDGameSupport(Object hDGameSupport) {
        this.hDGameSupport = hDGameSupport;
    }

    public Phone withHDGameSupport(Object hDGameSupport) {
        this.hDGameSupport = hDGameSupport;
        return this;
    }

    public Object getHDRecording() {
        return hDRecording;
    }

    public void setHDRecording(Object hDRecording) {
        this.hDRecording = hDRecording;
    }

    public Phone withHDRecording(Object hDRecording) {
        this.hDRecording = hDRecording;
        return this;
    }

    public Object getHandsFree() {
        return handsFree;
    }

    public void setHandsFree(Object handsFree) {
        this.handsFree = handsFree;
    }

    public Phone withHandsFree(Object handsFree) {
        this.handsFree = handsFree;
        return this;
    }

    public Object getHeight() {
        return height;
    }

    public void setHeight(Object height) {
        this.height = height;
    }

    public Phone withHeight(Object height) {
        this.height = height;
        return this;
    }

    public Object getHotSWAPSupport() {
        return hotSWAPSupport;
    }

    public void setHotSWAPSupport(Object hotSWAPSupport) {
        this.hotSWAPSupport = hotSWAPSupport;
    }

    public Phone withHotSWAPSupport(Object hotSWAPSupport) {
        this.hotSWAPSupport = hotSWAPSupport;
        return this;
    }

    public String getHybridSimSlot() {
        return hybridSimSlot;
    }

    public void setHybridSimSlot(String hybridSimSlot) {
        this.hybridSimSlot = hybridSimSlot;
    }

    public Phone withHybridSimSlot(String hybridSimSlot) {
        this.hybridSimSlot = hybridSimSlot;
        return this;
    }

    public Object getImageEditor() {
        return imageEditor;
    }

    public void setImageEditor(Object imageEditor) {
        this.imageEditor = imageEditor;
    }

    public Phone withImageEditor(Object imageEditor) {
        this.imageEditor = imageEditor;
        return this;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public Phone withImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
        return this;
    }

    public String getImportantApps() {
        return importantApps;
    }

    public void setImportantApps(String importantApps) {
        this.importantApps = importantApps;
    }

    public Phone withImportantApps(String importantApps) {
        this.importantApps = importantApps;
        return this;
    }

    public String getInTheBox() {
        return inTheBox;
    }

    public void setInTheBox(String inTheBox) {
        this.inTheBox = inTheBox;
    }

    public Phone withInTheBox(String inTheBox) {
        this.inTheBox = inTheBox;
        return this;
    }

    public Object getInfrared() {
        return infrared;
    }

    public void setInfrared(Object infrared) {
        this.infrared = infrared;
    }

    public Phone withInfrared(Object infrared) {
        this.infrared = infrared;
        return this;
    }

    public Object getInstantMessage() {
        return instantMessage;
    }

    public void setInstantMessage(Object instantMessage) {
        this.instantMessage = instantMessage;
    }

    public Phone withInstantMessage(Object instantMessage) {
        this.instantMessage = instantMessage;
        return this;
    }

    public String getInternalStorage() {
        return internalStorage;
    }

    public void setInternalStorage(String internalStorage) {
        this.internalStorage = internalStorage;
    }

    public Phone withInternalStorage(String internalStorage) {
        this.internalStorage = internalStorage;
        return this;
    }

    public Object getInternationalWarranty() {
        return internationalWarranty;
    }

    public void setInternationalWarranty(Object internationalWarranty) {
        this.internationalWarranty = internationalWarranty;
    }

    public Phone withInternationalWarranty(Object internationalWarranty) {
        this.internationalWarranty = internationalWarranty;
        return this;
    }

    public String getInternetConnectivity() {
        return internetConnectivity;
    }

    public void setInternetConnectivity(String internetConnectivity) {
        this.internetConnectivity = internetConnectivity;
    }

    public Phone withInternetConnectivity(String internetConnectivity) {
        this.internetConnectivity = internetConnectivity;
        return this;
    }

    public Object getJAVASupport() {
        return jAVASupport;
    }

    public void setJAVASupport(Object jAVASupport) {
        this.jAVASupport = jAVASupport;
    }

    public Phone withJAVASupport(Object jAVASupport) {
        this.jAVASupport = jAVASupport;
        return this;
    }

    public Object getJavaApplication() {
        return javaApplication;
    }

    public void setJavaApplication(Object javaApplication) {
        this.javaApplication = javaApplication;
    }

    public Phone withJavaApplication(Object javaApplication) {
        this.javaApplication = javaApplication;
        return this;
    }

    public Object getKeypad() {
        return keypad;
    }

    public void setKeypad(Object keypad) {
        this.keypad = keypad;
    }

    public Phone withKeypad(Object keypad) {
        this.keypad = keypad;
        return this;
    }

    public Object getKeypadType() {
        return keypadType;
    }

    public void setKeypadType(Object keypadType) {
        this.keypadType = keypadType;
    }

    public Phone withKeypadType(Object keypadType) {
        this.keypadType = keypadType;
        return this;
    }

    public Object getLogs() {
        return logs;
    }

    public void setLogs(Object logs) {
        this.logs = logs;
    }

    public Phone withLogs(Object logs) {
        this.logs = logs;
        return this;
    }

    public Object getMMS() {
        return mMS;
    }

    public void setMMS(Object mMS) {
        this.mMS = mMS;
    }

    public Phone withMMS(Object mMS) {
        this.mMS = mMS;
        return this;
    }

    public String getMapSupport() {
        return mapSupport;
    }

    public void setMapSupport(String mapSupport) {
        this.mapSupport = mapSupport;
    }

    public Phone withMapSupport(String mapSupport) {
        this.mapSupport = mapSupport;
        return this;
    }

    public Object getMemoryCardSlotType() {
        return memoryCardSlotType;
    }

    public void setMemoryCardSlotType(Object memoryCardSlotType) {
        this.memoryCardSlotType = memoryCardSlotType;
    }

    public Phone withMemoryCardSlotType(Object memoryCardSlotType) {
        this.memoryCardSlotType = memoryCardSlotType;
        return this;
    }

    public Object getMicroUSBPort() {
        return microUSBPort;
    }

    public void setMicroUSBPort(Object microUSBPort) {
        this.microUSBPort = microUSBPort;
    }

    public Phone withMicroUSBPort(Object microUSBPort) {
        this.microUSBPort = microUSBPort;
        return this;
    }

    public Object getMicroUSBVersion() {
        return microUSBVersion;
    }

    public void setMicroUSBVersion(Object microUSBVersion) {
        this.microUSBVersion = microUSBVersion;
    }

    public Phone withMicroUSBVersion(Object microUSBVersion) {
        this.microUSBVersion = microUSBVersion;
        return this;
    }

    public Object getMiniHDMIPort() {
        return miniHDMIPort;
    }

    public void setMiniHDMIPort(Object miniHDMIPort) {
        this.miniHDMIPort = miniHDMIPort;
    }

    public Phone withMiniHDMIPort(Object miniHDMIPort) {
        this.miniHDMIPort = miniHDMIPort;
        return this;
    }

    public Object getMiniUSBPort() {
        return miniUSBPort;
    }

    public void setMiniUSBPort(Object miniUSBPort) {
        this.miniUSBPort = miniUSBPort;
    }

    public Phone withMiniUSBPort(Object miniUSBPort) {
        this.miniUSBPort = miniUSBPort;
        return this;
    }

    public Object getMiniUSBVersion() {
        return miniUSBVersion;
    }

    public void setMiniUSBVersion(Object miniUSBVersion) {
        this.miniUSBVersion = miniUSBVersion;
    }

    public Phone withMiniUSBVersion(Object miniUSBVersion) {
        this.miniUSBVersion = miniUSBVersion;
        return this;
    }

    public Object getMobileTracker() {
        return mobileTracker;
    }

    public void setMobileTracker(Object mobileTracker) {
        this.mobileTracker = mobileTracker;
    }

    public Phone withMobileTracker(Object mobileTracker) {
        this.mobileTracker = mobileTracker;
        return this;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Phone withModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public Object getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(Object modelNumber) {
        this.modelNumber = modelNumber;
    }

    public Phone withModelNumber(Object modelNumber) {
        this.modelNumber = modelNumber;
        return this;
    }

    public Object getMusicPlayer() {
        return musicPlayer;
    }

    public void setMusicPlayer(Object musicPlayer) {
        this.musicPlayer = musicPlayer;
    }

    public Phone withMusicPlayer(Object musicPlayer) {
        this.musicPlayer = musicPlayer;
        return this;
    }

    public Object getNFC() {
        return nFC;
    }

    public void setNFC(Object nFC) {
        this.nFC = nFC;
    }

    public Phone withNFC(Object nFC) {
        this.nFC = nFC;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Phone withName(String name) {
        this.name = name;
        return this;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public Phone withNetworkType(String networkType) {
        this.networkType = networkType;
        return this;
    }

    public Object getNotCoveredInWarranty() {
        return notCoveredInWarranty;
    }

    public void setNotCoveredInWarranty(Object notCoveredInWarranty) {
        this.notCoveredInWarranty = notCoveredInWarranty;
    }

    public Phone withNotCoveredInWarranty(Object notCoveredInWarranty) {
        this.notCoveredInWarranty = notCoveredInWarranty;
        return this;
    }

    public String getOTGCompatible() {
        return oTGCompatible;
    }

    public void setOTGCompatible(String oTGCompatible) {
        this.oTGCompatible = oTGCompatible;
    }

    public Phone withOTGCompatible(String oTGCompatible) {
        this.oTGCompatible = oTGCompatible;
        return this;
    }

    public Object getOperatingFrequency() {
        return operatingFrequency;
    }

    public void setOperatingFrequency(Object operatingFrequency) {
        this.operatingFrequency = operatingFrequency;
    }

    public Phone withOperatingFrequency(Object operatingFrequency) {
        this.operatingFrequency = operatingFrequency;
        return this;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public Phone withOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
        return this;
    }

    public Object getOpticalZoom() {
        return opticalZoom;
    }

    public void setOpticalZoom(Object opticalZoom) {
        this.opticalZoom = opticalZoom;
    }

    public Phone withOpticalZoom(Object opticalZoom) {
        this.opticalZoom = opticalZoom;
        return this;
    }

    public Object getOtherDisplayFeatures() {
        return otherDisplayFeatures;
    }

    public void setOtherDisplayFeatures(Object otherDisplayFeatures) {
        this.otherDisplayFeatures = otherDisplayFeatures;
    }

    public Phone withOtherDisplayFeatures(Object otherDisplayFeatures) {
        this.otherDisplayFeatures = otherDisplayFeatures;
        return this;
    }

    public String getOtherFeatures() {
        return otherFeatures;
    }

    public void setOtherFeatures(String otherFeatures) {
        this.otherFeatures = otherFeatures;
    }

    public Phone withOtherFeatures(String otherFeatures) {
        this.otherFeatures = otherFeatures;
        return this;
    }

    public Object getPhoneBook() {
        return phoneBook;
    }

    public void setPhoneBook(Object phoneBook) {
        this.phoneBook = phoneBook;
    }

    public Phone withPhoneBook(Object phoneBook) {
        this.phoneBook = phoneBook;
        return this;
    }

    public Object getPhoneBookMemory() {
        return phoneBookMemory;
    }

    public void setPhoneBookMemory(Object phoneBookMemory) {
        this.phoneBookMemory = phoneBookMemory;
    }

    public Phone withPhoneBookMemory(Object phoneBookMemory) {
        this.phoneBookMemory = phoneBookMemory;
        return this;
    }

    public Object getPreInstalledBrowser() {
        return preInstalledBrowser;
    }

    public void setPreInstalledBrowser(Object preInstalledBrowser) {
        this.preInstalledBrowser = preInstalledBrowser;
    }

    public Phone withPreInstalledBrowser(Object preInstalledBrowser) {
        this.preInstalledBrowser = preInstalledBrowser;
        return this;
    }

    public Object getPredictiveTextInput() {
        return predictiveTextInput;
    }

    public void setPredictiveTextInput(Object predictiveTextInput) {
        this.predictiveTextInput = predictiveTextInput;
    }

    public Phone withPredictiveTextInput(Object predictiveTextInput) {
        this.predictiveTextInput = predictiveTextInput;
        return this;
    }

    public String getPrimaryCamera() {
        return primaryCamera;
    }

    public void setPrimaryCamera(String primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public Phone withPrimaryCamera(String primaryCamera) {
        this.primaryCamera = primaryCamera;
        return this;
    }

    public String getPrimaryCameraAvailable() {
        return primaryCameraAvailable;
    }

    public void setPrimaryCameraAvailable(String primaryCameraAvailable) {
        this.primaryCameraAvailable = primaryCameraAvailable;
    }

    public Phone withPrimaryCameraAvailable(String primaryCameraAvailable) {
        this.primaryCameraAvailable = primaryCameraAvailable;
        return this;
    }

    public String getPrimaryCameraFeatures() {
        return primaryCameraFeatures;
    }

    public void setPrimaryCameraFeatures(String primaryCameraFeatures) {
        this.primaryCameraFeatures = primaryCameraFeatures;
    }

    public Phone withPrimaryCameraFeatures(String primaryCameraFeatures) {
        this.primaryCameraFeatures = primaryCameraFeatures;
        return this;
    }

    public String getPrimaryClockSpeed() {
        return primaryClockSpeed;
    }

    public void setPrimaryClockSpeed(String primaryClockSpeed) {
        this.primaryClockSpeed = primaryClockSpeed;
    }

    public Phone withPrimaryClockSpeed(String primaryClockSpeed) {
        this.primaryClockSpeed = primaryClockSpeed;
        return this;
    }

    public String getProcessorCore() {
        return processorCore;
    }

    public void setProcessorCore(String processorCore) {
        this.processorCore = processorCore;
    }

    public Phone withProcessorCore(String processorCore) {
        this.processorCore = processorCore;
        return this;
    }

    public String getProcessorType() {
        return processorType;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    public Phone withProcessorType(String processorType) {
        this.processorType = processorType;
        return this;
    }

    public Object getQuickCharging() {
        return quickCharging;
    }

    public void setQuickCharging(Object quickCharging) {
        this.quickCharging = quickCharging;
    }

    public Phone withQuickCharging(Object quickCharging) {
        this.quickCharging = quickCharging;
        return this;
    }

    public String getRAM() {
        return rAM;
    }

    public void setRAM(String rAM) {
        this.rAM = rAM;
    }

    public Phone withRAM(String rAM) {
        this.rAM = rAM;
        return this;
    }

    public Object getRemovableBattery() {
        return removableBattery;
    }

    public void setRemovableBattery(Object removableBattery) {
        this.removableBattery = removableBattery;
    }

    public Phone withRemovableBattery(Object removableBattery) {
        this.removableBattery = removableBattery;
        return this;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Phone withResolution(String resolution) {
        this.resolution = resolution;
        return this;
    }

    public Object getResolutionType() {
        return resolutionType;
    }

    public void setResolutionType(Object resolutionType) {
        this.resolutionType = resolutionType;
    }

    public Phone withResolutionType(Object resolutionType) {
        this.resolutionType = resolutionType;
        return this;
    }

    public Object getRingtonesFormat() {
        return ringtonesFormat;
    }

    public void setRingtonesFormat(Object ringtonesFormat) {
        this.ringtonesFormat = ringtonesFormat;
    }

    public Phone withRingtonesFormat(Object ringtonesFormat) {
        this.ringtonesFormat = ringtonesFormat;
        return this;
    }

    public Object getSIMAccess() {
        return sIMAccess;
    }

    public void setSIMAccess(Object sIMAccess) {
        this.sIMAccess = sIMAccess;
    }

    public Phone withSIMAccess(Object sIMAccess) {
        this.sIMAccess = sIMAccess;
        return this;
    }

    public String getSIMSize() {
        return sIMSize;
    }

    public void setSIMSize(String sIMSize) {
        this.sIMSize = sIMSize;
    }

    public Phone withSIMSize(String sIMSize) {
        this.sIMSize = sIMSize;
        return this;
    }

    public String getSIMType() {
        return sIMType;
    }

    public void setSIMType(String sIMType) {
        this.sIMType = sIMType;
    }

    public Phone withSIMType(String sIMType) {
        this.sIMType = sIMType;
        return this;
    }

    public String getSMS() {
        return sMS;
    }

    public void setSMS(String sMS) {
        this.sMS = sMS;
    }

    public Phone withSMS(String sMS) {
        this.sMS = sMS;
        return this;
    }

    public String getSMSMemory() {
        return sMSMemory;
    }

    public void setSMSMemory(String sMSMemory) {
        this.sMSMemory = sMSMemory;
    }

    public Phone withSMSMemory(String sMSMemory) {
        this.sMSMemory = sMSMemory;
        return this;
    }

    public String getSecondaryCamera() {
        return secondaryCamera;
    }

    public void setSecondaryCamera(String secondaryCamera) {
        this.secondaryCamera = secondaryCamera;
    }

    public Phone withSecondaryCamera(String secondaryCamera) {
        this.secondaryCamera = secondaryCamera;
        return this;
    }

    public String getSecondaryCameraAvailable() {
        return secondaryCameraAvailable;
    }

    public void setSecondaryCameraAvailable(String secondaryCameraAvailable) {
        this.secondaryCameraAvailable = secondaryCameraAvailable;
    }

    public Phone withSecondaryCameraAvailable(String secondaryCameraAvailable) {
        this.secondaryCameraAvailable = secondaryCameraAvailable;
        return this;
    }

    public Object getSecondaryCameraFeatures() {
        return secondaryCameraFeatures;
    }

    public void setSecondaryCameraFeatures(Object secondaryCameraFeatures) {
        this.secondaryCameraFeatures = secondaryCameraFeatures;
    }

    public Phone withSecondaryCameraFeatures(Object secondaryCameraFeatures) {
        this.secondaryCameraFeatures = secondaryCameraFeatures;
        return this;
    }

    public Object getSecondaryClockSpeed() {
        return secondaryClockSpeed;
    }

    public void setSecondaryClockSpeed(Object secondaryClockSpeed) {
        this.secondaryClockSpeed = secondaryClockSpeed;
    }

    public Phone withSecondaryClockSpeed(Object secondaryClockSpeed) {
        this.secondaryClockSpeed = secondaryClockSpeed;
        return this;
    }

    public String getSensors() {
        return sensors;
    }

    public void setSensors(String sensors) {
        this.sensors = sensors;
    }

    public Phone withSensors(String sensors) {
        this.sensors = sensors;
        return this;
    }

    public Object getSeries() {
        return series;
    }

    public void setSeries(Object series) {
        this.series = series;
    }

    public Phone withSeries(Object series) {
        this.series = series;
        return this;
    }

    public String getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(String smartphone) {
        this.smartphone = smartphone;
    }

    public Phone withSmartphone(String smartphone) {
        this.smartphone = smartphone;
        return this;
    }

    public Object getSocialNetworkingPhone() {
        return socialNetworkingPhone;
    }

    public void setSocialNetworkingPhone(Object socialNetworkingPhone) {
        this.socialNetworkingPhone = socialNetworkingPhone;
    }

    public Phone withSocialNetworkingPhone(Object socialNetworkingPhone) {
        this.socialNetworkingPhone = socialNetworkingPhone;
        return this;
    }

    public Object getSoundEnhancements() {
        return soundEnhancements;
    }

    public void setSoundEnhancements(Object soundEnhancements) {
        this.soundEnhancements = soundEnhancements;
    }

    public Phone withSoundEnhancements(Object soundEnhancements) {
        this.soundEnhancements = soundEnhancements;
        return this;
    }

    public Object getSpeakerPhone() {
        return speakerPhone;
    }

    public void setSpeakerPhone(Object speakerPhone) {
        this.speakerPhone = speakerPhone;
    }

    public Phone withSpeakerPhone(Object speakerPhone) {
        this.speakerPhone = speakerPhone;
        return this;
    }

    public Object getSpeedDialing() {
        return speedDialing;
    }

    public void setSpeedDialing(Object speedDialing) {
        this.speedDialing = speedDialing;
    }

    public Phone withSpeedDialing(Object speedDialing) {
        this.speedDialing = speedDialing;
        return this;
    }

    public Object getSupportedLanguages() {
        return supportedLanguages;
    }

    public void setSupportedLanguages(Object supportedLanguages) {
        this.supportedLanguages = supportedLanguages;
    }

    public Phone withSupportedLanguages(Object supportedLanguages) {
        this.supportedLanguages = supportedLanguages;
        return this;
    }

    public String getSupportedMemoryCardType() {
        return supportedMemoryCardType;
    }

    public void setSupportedMemoryCardType(String supportedMemoryCardType) {
        this.supportedMemoryCardType = supportedMemoryCardType;
    }

    public Phone withSupportedMemoryCardType(String supportedMemoryCardType) {
        this.supportedMemoryCardType = supportedMemoryCardType;
        return this;
    }

    public String getSupportedNetworks() {
        return supportedNetworks;
    }

    public void setSupportedNetworks(String supportedNetworks) {
        this.supportedNetworks = supportedNetworks;
    }

    public Phone withSupportedNetworks(String supportedNetworks) {
        this.supportedNetworks = supportedNetworks;
        return this;
    }

    public Object getTVOut() {
        return tVOut;
    }

    public void setTVOut(Object tVOut) {
        this.tVOut = tVOut;
    }

    public Phone withTVOut(Object tVOut) {
        this.tVOut = tVOut;
        return this;
    }

    public String getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(String talkTime) {
        this.talkTime = talkTime;
    }

    public Phone withTalkTime(String talkTime) {
        this.talkTime = talkTime;
        return this;
    }

    public Object getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(Object totalMemory) {
        this.totalMemory = totalMemory;
    }

    public Phone withTotalMemory(Object totalMemory) {
        this.totalMemory = totalMemory;
        return this;
    }

    public String getTouchscreen() {
        return touchscreen;
    }

    public void setTouchscreen(String touchscreen) {
        this.touchscreen = touchscreen;
    }

    public Phone withTouchscreen(String touchscreen) {
        this.touchscreen = touchscreen;
        return this;
    }

    public String getTouchscreenType() {
        return touchscreenType;
    }

    public void setTouchscreenType(String touchscreenType) {
        this.touchscreenType = touchscreenType;
    }

    public Phone withTouchscreenType(String touchscreenType) {
        this.touchscreenType = touchscreenType;
        return this;
    }

    public Object getUSBConnectivity() {
        return uSBConnectivity;
    }

    public void setUSBConnectivity(Object uSBConnectivity) {
        this.uSBConnectivity = uSBConnectivity;
    }

    public Phone withUSBConnectivity(Object uSBConnectivity) {
        this.uSBConnectivity = uSBConnectivity;
        return this;
    }

    public Object getUSBTethering() {
        return uSBTethering;
    }

    public void setUSBTethering(Object uSBTethering) {
        this.uSBTethering = uSBTethering;
    }

    public Phone withUSBTethering(Object uSBTethering) {
        this.uSBTethering = uSBTethering;
        return this;
    }

    public int getUnnamed0() {
        return unnamed0;
    }

    public void setUnnamed0(int unnamed0) {
        this.unnamed0 = unnamed0;
    }

    public Phone withUnnamed0(int unnamed0) {
        this.unnamed0 = unnamed0;
        return this;
    }

    public Object getUnnamed147() {
        return unnamed147;
    }

    public void setUnnamed147(Object unnamed147) {
        this.unnamed147 = unnamed147;
    }

    public Phone withUnnamed147(Object unnamed147) {
        this.unnamed147 = unnamed147;
        return this;
    }

    public Object getUnnamed148() {
        return unnamed148;
    }

    public void setUnnamed148(Object unnamed148) {
        this.unnamed148 = unnamed148;
    }

    public Phone withUnnamed148(Object unnamed148) {
        this.unnamed148 = unnamed148;
        return this;
    }

    public Object getUnnamed149() {
        return unnamed149;
    }

    public void setUnnamed149(Object unnamed149) {
        this.unnamed149 = unnamed149;
    }

    public Phone withUnnamed149(Object unnamed149) {
        this.unnamed149 = unnamed149;
        return this;
    }

    public Object getUpgradableOperatingSystem() {
        return upgradableOperatingSystem;
    }

    public void setUpgradableOperatingSystem(Object upgradableOperatingSystem) {
        this.upgradableOperatingSystem = upgradableOperatingSystem;
    }

    public Phone withUpgradableOperatingSystem(Object upgradableOperatingSystem) {
        this.upgradableOperatingSystem = upgradableOperatingSystem;
        return this;
    }

    public Object getUserInterface() {
        return userInterface;
    }

    public void setUserInterface(Object userInterface) {
        this.userInterface = userInterface;
    }

    public Phone withUserInterface(Object userInterface) {
        this.userInterface = userInterface;
        return this;
    }

    public Object getUserMemory() {
        return userMemory;
    }

    public void setUserMemory(Object userMemory) {
        this.userMemory = userMemory;
    }

    public Phone withUserMemory(Object userMemory) {
        this.userMemory = userMemory;
        return this;
    }

    public Object getVideoCallSupport() {
        return videoCallSupport;
    }

    public void setVideoCallSupport(Object videoCallSupport) {
        this.videoCallSupport = videoCallSupport;
    }

    public Phone withVideoCallSupport(Object videoCallSupport) {
        this.videoCallSupport = videoCallSupport;
        return this;
    }

    public Object getVideoFormats() {
        return videoFormats;
    }

    public void setVideoFormats(Object videoFormats) {
        this.videoFormats = videoFormats;
    }

    public Phone withVideoFormats(Object videoFormats) {
        this.videoFormats = videoFormats;
        return this;
    }

    public String getVideoRecording() {
        return videoRecording;
    }

    public void setVideoRecording(String videoRecording) {
        this.videoRecording = videoRecording;
    }

    public Phone withVideoRecording(String videoRecording) {
        this.videoRecording = videoRecording;
        return this;
    }

    public Object getVideoRecordingResolution() {
        return videoRecordingResolution;
    }

    public void setVideoRecordingResolution(Object videoRecordingResolution) {
        this.videoRecordingResolution = videoRecordingResolution;
    }

    public Phone withVideoRecordingResolution(Object videoRecordingResolution) {
        this.videoRecordingResolution = videoRecordingResolution;
        return this;
    }

    public String getVoiceInput() {
        return voiceInput;
    }

    public void setVoiceInput(String voiceInput) {
        this.voiceInput = voiceInput;
    }

    public Phone withVoiceInput(String voiceInput) {
        this.voiceInput = voiceInput;
        return this;
    }

    public Object getWAP() {
        return wAP;
    }

    public void setWAP(Object wAP) {
        this.wAP = wAP;
    }

    public Phone withWAP(Object wAP) {
        this.wAP = wAP;
        return this;
    }

    public Object getWAPVersion() {
        return wAPVersion;
    }

    public void setWAPVersion(Object wAPVersion) {
        this.wAPVersion = wAPVersion;
    }

    public Phone withWAPVersion(Object wAPVersion) {
        this.wAPVersion = wAPVersion;
        return this;
    }

    public Object getWarrantyServiceType() {
        return warrantyServiceType;
    }

    public void setWarrantyServiceType(Object warrantyServiceType) {
        this.warrantyServiceType = warrantyServiceType;
    }

    public Phone withWarrantyServiceType(Object warrantyServiceType) {
        this.warrantyServiceType = warrantyServiceType;
        return this;
    }

    public String getWarrantySummary() {
        return warrantySummary;
    }

    public void setWarrantySummary(String warrantySummary) {
        this.warrantySummary = warrantySummary;
    }

    public Phone withWarrantySummary(String warrantySummary) {
        this.warrantySummary = warrantySummary;
        return this;
    }

    public Object getWeight() {
        return weight;
    }

    public void setWeight(Object weight) {
        this.weight = weight;
    }

    public Phone withWeight(Object weight) {
        this.weight = weight;
        return this;
    }

    public String getWiFi() {
        return wiFi;
    }

    public void setWiFi(String wiFi) {
        this.wiFi = wiFi;
    }

    public Phone withWiFi(String wiFi) {
        this.wiFi = wiFi;
        return this;
    }

    public Object getWiFiHotspot() {
        return wiFiHotspot;
    }

    public void setWiFiHotspot(Object wiFiHotspot) {
        this.wiFiHotspot = wiFiHotspot;
    }

    public Phone withWiFiHotspot(Object wiFiHotspot) {
        this.wiFiHotspot = wiFiHotspot;
        return this;
    }

    public Object getWiFiVersion() {
        return wiFiVersion;
    }

    public void setWiFiVersion(Object wiFiVersion) {
        this.wiFiVersion = wiFiVersion;
    }

    public Phone withWiFiVersion(Object wiFiVersion) {
        this.wiFiVersion = wiFiVersion;
        return this;
    }

    public Object getWidth() {
        return width;
    }

    public void setWidth(Object width) {
        this.width = width;
    }

    public Phone withWidth(Object width) {
        this.width = width;
        return this;
    }

    public String getReviewlink() {
        return reviewlink;
    }

    public void setReviewlink(String reviewlink) {
        this.reviewlink = reviewlink;
    }

    public Phone withReviewlink(String reviewlink) {
        this.reviewlink = reviewlink;
        return this;
    }

}
