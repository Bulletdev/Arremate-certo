package com.sun.jna.platform.win32;

public interface LMErr {
  public static final int NERR_Success = 0;
  
  public static final int NERR_BASE = 2100;
  
  public static final int NERR_NetNotStarted = 2102;
  
  public static final int NERR_UnknownServer = 2103;
  
  public static final int NERR_ShareMem = 2104;
  
  public static final int NERR_NoNetworkResource = 2105;
  
  public static final int NERR_RemoteOnly = 2106;
  
  public static final int NERR_DevNotRedirected = 2107;
  
  public static final int NERR_ServerNotStarted = 2114;
  
  public static final int NERR_ItemNotFound = 2115;
  
  public static final int NERR_UnknownDevDir = 2116;
  
  public static final int NERR_RedirectedPath = 2117;
  
  public static final int NERR_DuplicateShare = 2118;
  
  public static final int NERR_NoRoom = 2119;
  
  public static final int NERR_TooManyItems = 2121;
  
  public static final int NERR_InvalidMaxUsers = 2122;
  
  public static final int NERR_BufTooSmall = 2123;
  
  public static final int NERR_RemoteErr = 2127;
  
  public static final int NERR_LanmanIniError = 2131;
  
  public static final int NERR_NetworkError = 2136;
  
  public static final int NERR_WkstaInconsistentState = 2137;
  
  public static final int NERR_WkstaNotStarted = 2138;
  
  public static final int NERR_BrowserNotStarted = 2139;
  
  public static final int NERR_InternalError = 2140;
  
  public static final int NERR_BadTransactConfig = 2141;
  
  public static final int NERR_InvalidAPI = 2142;
  
  public static final int NERR_BadEventName = 2143;
  
  public static final int NERR_DupNameReboot = 2144;
  
  public static final int NERR_CfgCompNotFound = 2146;
  
  public static final int NERR_CfgParamNotFound = 2147;
  
  public static final int NERR_LineTooLong = 2149;
  
  public static final int NERR_QNotFound = 2150;
  
  public static final int NERR_JobNotFound = 2151;
  
  public static final int NERR_DestNotFound = 2152;
  
  public static final int NERR_DestExists = 2153;
  
  public static final int NERR_QExists = 2154;
  
  public static final int NERR_QNoRoom = 2155;
  
  public static final int NERR_JobNoRoom = 2156;
  
  public static final int NERR_DestNoRoom = 2157;
  
  public static final int NERR_DestIdle = 2158;
  
  public static final int NERR_DestInvalidOp = 2159;
  
  public static final int NERR_ProcNoRespond = 2160;
  
  public static final int NERR_SpoolerNotLoaded = 2161;
  
  public static final int NERR_DestInvalidState = 2162;
  
  public static final int NERR_QInvalidState = 2163;
  
  public static final int NERR_JobInvalidState = 2164;
  
  public static final int NERR_SpoolNoMemory = 2165;
  
  public static final int NERR_DriverNotFound = 2166;
  
  public static final int NERR_DataTypeInvalid = 2167;
  
  public static final int NERR_ProcNotFound = 2168;
  
  public static final int NERR_ServiceTableLocked = 2180;
  
  public static final int NERR_ServiceTableFull = 2181;
  
  public static final int NERR_ServiceInstalled = 2182;
  
  public static final int NERR_ServiceEntryLocked = 2183;
  
  public static final int NERR_ServiceNotInstalled = 2184;
  
  public static final int NERR_BadServiceName = 2185;
  
  public static final int NERR_ServiceCtlTimeout = 2186;
  
  public static final int NERR_ServiceCtlBusy = 2187;
  
  public static final int NERR_BadServiceProgName = 2188;
  
  public static final int NERR_ServiceNotCtrl = 2189;
  
  public static final int NERR_ServiceKillProc = 2190;
  
  public static final int NERR_ServiceCtlNotValid = 2191;
  
  public static final int NERR_NotInDispatchTbl = 2192;
  
  public static final int NERR_BadControlRecv = 2193;
  
  public static final int NERR_ServiceNotStarting = 2194;
  
  public static final int NERR_AlreadyLoggedOn = 2200;
  
  public static final int NERR_NotLoggedOn = 2201;
  
  public static final int NERR_BadUsername = 2202;
  
  public static final int NERR_BadPassword = 2203;
  
  public static final int NERR_UnableToAddName_W = 2204;
  
  public static final int NERR_UnableToAddName_F = 2205;
  
  public static final int NERR_UnableToDelName_W = 2206;
  
  public static final int NERR_UnableToDelName_F = 2207;
  
  public static final int NERR_LogonsPaused = 2209;
  
  public static final int NERR_LogonServerConflict = 2210;
  
  public static final int NERR_LogonNoUserPath = 2211;
  
  public static final int NERR_LogonScriptError = 2212;
  
  public static final int NERR_StandaloneLogon = 2214;
  
  public static final int NERR_LogonServerNotFound = 2215;
  
  public static final int NERR_LogonDomainExists = 2216;
  
  public static final int NERR_NonValidatedLogon = 2217;
  
  public static final int NERR_ACFNotFound = 2219;
  
  public static final int NERR_GroupNotFound = 2220;
  
  public static final int NERR_UserNotFound = 2221;
  
  public static final int NERR_ResourceNotFound = 2222;
  
  public static final int NERR_GroupExists = 2223;
  
  public static final int NERR_UserExists = 2224;
  
  public static final int NERR_ResourceExists = 2225;
  
  public static final int NERR_NotPrimary = 2226;
  
  public static final int NERR_ACFNotLoaded = 2227;
  
  public static final int NERR_ACFNoRoom = 2228;
  
  public static final int NERR_ACFFileIOFail = 2229;
  
  public static final int NERR_ACFTooManyLists = 2230;
  
  public static final int NERR_UserLogon = 2231;
  
  public static final int NERR_ACFNoParent = 2232;
  
  public static final int NERR_CanNotGrowSegment = 2233;
  
  public static final int NERR_SpeGroupOp = 2234;
  
  public static final int NERR_NotInCache = 2235;
  
  public static final int NERR_UserInGroup = 2236;
  
  public static final int NERR_UserNotInGroup = 2237;
  
  public static final int NERR_AccountUndefined = 2238;
  
  public static final int NERR_AccountExpired = 2239;
  
  public static final int NERR_InvalidWorkstation = 2240;
  
  public static final int NERR_InvalidLogonHours = 2241;
  
  public static final int NERR_PasswordExpired = 2242;
  
  public static final int NERR_PasswordCantChange = 2243;
  
  public static final int NERR_PasswordHistConflict = 2244;
  
  public static final int NERR_PasswordTooShort = 2245;
  
  public static final int NERR_PasswordTooRecent = 2246;
  
  public static final int NERR_InvalidDatabase = 2247;
  
  public static final int NERR_DatabaseUpToDate = 2248;
  
  public static final int NERR_SyncRequired = 2249;
  
  public static final int NERR_UseNotFound = 2250;
  
  public static final int NERR_BadAsgType = 2251;
  
  public static final int NERR_DeviceIsShared = 2252;
  
  public static final int NERR_SameAsComputerName = 2253;
  
  public static final int NERR_NoComputerName = 2270;
  
  public static final int NERR_MsgAlreadyStarted = 2271;
  
  public static final int NERR_MsgInitFailed = 2272;
  
  public static final int NERR_NameNotFound = 2273;
  
  public static final int NERR_AlreadyForwarded = 2274;
  
  public static final int NERR_AddForwarded = 2275;
  
  public static final int NERR_AlreadyExists = 2276;
  
  public static final int NERR_TooManyNames = 2277;
  
  public static final int NERR_DelComputerName = 2278;
  
  public static final int NERR_LocalForward = 2279;
  
  public static final int NERR_GrpMsgProcessor = 2280;
  
  public static final int NERR_PausedRemote = 2281;
  
  public static final int NERR_BadReceive = 2282;
  
  public static final int NERR_NameInUse = 2283;
  
  public static final int NERR_MsgNotStarted = 2284;
  
  public static final int NERR_NotLocalName = 2285;
  
  public static final int NERR_NoForwardName = 2286;
  
  public static final int NERR_RemoteFull = 2287;
  
  public static final int NERR_NameNotForwarded = 2288;
  
  public static final int NERR_TruncatedBroadcast = 2289;
  
  public static final int NERR_InvalidDevice = 2294;
  
  public static final int NERR_WriteFault = 2295;
  
  public static final int NERR_DuplicateName = 2297;
  
  public static final int NERR_DeleteLater = 2298;
  
  public static final int NERR_IncompleteDel = 2299;
  
  public static final int NERR_MultipleNets = 2300;
  
  public static final int NERR_NetNameNotFound = 2310;
  
  public static final int NERR_DeviceNotShared = 2311;
  
  public static final int NERR_ClientNameNotFound = 2312;
  
  public static final int NERR_FileIdNotFound = 2314;
  
  public static final int NERR_ExecFailure = 2315;
  
  public static final int NERR_TmpFile = 2316;
  
  public static final int NERR_TooMuchData = 2317;
  
  public static final int NERR_DeviceShareConflict = 2318;
  
  public static final int NERR_BrowserTableIncomplete = 2319;
  
  public static final int NERR_NotLocalDomain = 2320;
  
  public static final int NERR_IsDfsShare = 2321;
  
  public static final int NERR_DevInvalidOpCode = 2331;
  
  public static final int NERR_DevNotFound = 2332;
  
  public static final int NERR_DevNotOpen = 2333;
  
  public static final int NERR_BadQueueDevString = 2334;
  
  public static final int NERR_BadQueuePriority = 2335;
  
  public static final int NERR_NoCommDevs = 2337;
  
  public static final int NERR_QueueNotFound = 2338;
  
  public static final int NERR_BadDevString = 2340;
  
  public static final int NERR_BadDev = 2341;
  
  public static final int NERR_InUseBySpooler = 2342;
  
  public static final int NERR_CommDevInUse = 2343;
  
  public static final int NERR_InvalidComputer = 2351;
  
  public static final int NERR_MaxLenExceeded = 2354;
  
  public static final int NERR_BadComponent = 2356;
  
  public static final int NERR_CantType = 2357;
  
  public static final int NERR_TooManyEntries = 2362;
  
  public static final int NERR_ProfileFileTooBig = 2370;
  
  public static final int NERR_ProfileOffset = 2371;
  
  public static final int NERR_ProfileCleanup = 2372;
  
  public static final int NERR_ProfileUnknownCmd = 2373;
  
  public static final int NERR_ProfileLoadErr = 2374;
  
  public static final int NERR_ProfileSaveErr = 2375;
  
  public static final int NERR_LogOverflow = 2377;
  
  public static final int NERR_LogFileChanged = 2378;
  
  public static final int NERR_LogFileCorrupt = 2379;
  
  public static final int NERR_SourceIsDir = 2380;
  
  public static final int NERR_BadSource = 2381;
  
  public static final int NERR_BadDest = 2382;
  
  public static final int NERR_DifferentServers = 2383;
  
  public static final int NERR_RunSrvPaused = 2385;
  
  public static final int NERR_ErrCommRunSrv = 2389;
  
  public static final int NERR_ErrorExecingGhost = 2391;
  
  public static final int NERR_ShareNotFound = 2392;
  
  public static final int NERR_InvalidLana = 2400;
  
  public static final int NERR_OpenFiles = 2401;
  
  public static final int NERR_ActiveConns = 2402;
  
  public static final int NERR_BadPasswordCore = 2403;
  
  public static final int NERR_DevInUse = 2404;
  
  public static final int NERR_LocalDrive = 2405;
  
  public static final int NERR_AlertExists = 2430;
  
  public static final int NERR_TooManyAlerts = 2431;
  
  public static final int NERR_NoSuchAlert = 2432;
  
  public static final int NERR_BadRecipient = 2433;
  
  public static final int NERR_AcctLimitExceeded = 2434;
  
  public static final int NERR_InvalidLogSeek = 2440;
  
  public static final int NERR_BadUasConfig = 2450;
  
  public static final int NERR_InvalidUASOp = 2451;
  
  public static final int NERR_LastAdmin = 2452;
  
  public static final int NERR_DCNotFound = 2453;
  
  public static final int NERR_LogonTrackingError = 2454;
  
  public static final int NERR_NetlogonNotStarted = 2455;
  
  public static final int NERR_CanNotGrowUASFile = 2456;
  
  public static final int NERR_TimeDiffAtDC = 2457;
  
  public static final int NERR_PasswordMismatch = 2458;
  
  public static final int NERR_NoSuchServer = 2460;
  
  public static final int NERR_NoSuchSession = 2461;
  
  public static final int NERR_NoSuchConnection = 2462;
  
  public static final int NERR_TooManyServers = 2463;
  
  public static final int NERR_TooManySessions = 2464;
  
  public static final int NERR_TooManyConnections = 2465;
  
  public static final int NERR_TooManyFiles = 2466;
  
  public static final int NERR_NoAlternateServers = 2467;
  
  public static final int NERR_TryDownLevel = 2470;
  
  public static final int NERR_UPSDriverNotStarted = 2480;
  
  public static final int NERR_UPSInvalidConfig = 2481;
  
  public static final int NERR_UPSInvalidCommPort = 2482;
  
  public static final int NERR_UPSSignalAsserted = 2483;
  
  public static final int NERR_UPSShutdownFailed = 2484;
  
  public static final int NERR_BadDosRetCode = 2500;
  
  public static final int NERR_ProgNeedsExtraMem = 2501;
  
  public static final int NERR_BadDosFunction = 2502;
  
  public static final int NERR_RemoteBootFailed = 2503;
  
  public static final int NERR_BadFileCheckSum = 2504;
  
  public static final int NERR_NoRplBootSystem = 2505;
  
  public static final int NERR_RplLoadrNetBiosErr = 2506;
  
  public static final int NERR_RplLoadrDiskErr = 2507;
  
  public static final int NERR_ImageParamErr = 2508;
  
  public static final int NERR_TooManyImageParams = 2509;
  
  public static final int NERR_NonDosFloppyUsed = 2510;
  
  public static final int NERR_RplBootRestart = 2511;
  
  public static final int NERR_RplSrvrCallFailed = 2512;
  
  public static final int NERR_CantConnectRplSrvr = 2513;
  
  public static final int NERR_CantOpenImageFile = 2514;
  
  public static final int NERR_CallingRplSrvr = 2515;
  
  public static final int NERR_StartingRplBoot = 2516;
  
  public static final int NERR_RplBootServiceTerm = 2517;
  
  public static final int NERR_RplBootStartFailed = 2518;
  
  public static final int NERR_RPL_CONNECTED = 2519;
  
  public static final int NERR_BrowserConfiguredToNotRun = 2550;
  
  public static final int NERR_RplNoAdaptersStarted = 2610;
  
  public static final int NERR_RplBadRegistry = 2611;
  
  public static final int NERR_RplBadDatabase = 2612;
  
  public static final int NERR_RplRplfilesShare = 2613;
  
  public static final int NERR_RplNotRplServer = 2614;
  
  public static final int NERR_RplCannotEnum = 2615;
  
  public static final int NERR_RplWkstaInfoCorrupted = 2616;
  
  public static final int NERR_RplWkstaNotFound = 2617;
  
  public static final int NERR_RplWkstaNameUnavailable = 2618;
  
  public static final int NERR_RplProfileInfoCorrupted = 2619;
  
  public static final int NERR_RplProfileNotFound = 2620;
  
  public static final int NERR_RplProfileNameUnavailable = 2621;
  
  public static final int NERR_RplProfileNotEmpty = 2622;
  
  public static final int NERR_RplConfigInfoCorrupted = 2623;
  
  public static final int NERR_RplConfigNotFound = 2624;
  
  public static final int NERR_RplAdapterInfoCorrupted = 2625;
  
  public static final int NERR_RplInternal = 2626;
  
  public static final int NERR_RplVendorInfoCorrupted = 2627;
  
  public static final int NERR_RplBootInfoCorrupted = 2628;
  
  public static final int NERR_RplWkstaNeedsUserAcct = 2629;
  
  public static final int NERR_RplNeedsRPLUSERAcct = 2630;
  
  public static final int NERR_RplBootNotFound = 2631;
  
  public static final int NERR_RplIncompatibleProfile = 2632;
  
  public static final int NERR_RplAdapterNameUnavailable = 2633;
  
  public static final int NERR_RplConfigNotEmpty = 2634;
  
  public static final int NERR_RplBootInUse = 2635;
  
  public static final int NERR_RplBackupDatabase = 2636;
  
  public static final int NERR_RplAdapterNotFound = 2637;
  
  public static final int NERR_RplVendorNotFound = 2638;
  
  public static final int NERR_RplVendorNameUnavailable = 2639;
  
  public static final int NERR_RplBootNameUnavailable = 2640;
  
  public static final int NERR_RplConfigNameUnavailable = 2641;
  
  public static final int NERR_DfsInternalCorruption = 2660;
  
  public static final int NERR_DfsVolumeDataCorrupt = 2661;
  
  public static final int NERR_DfsNoSuchVolume = 2662;
  
  public static final int NERR_DfsVolumeAlreadyExists = 2663;
  
  public static final int NERR_DfsAlreadyShared = 2664;
  
  public static final int NERR_DfsNoSuchShare = 2665;
  
  public static final int NERR_DfsNotALeafVolume = 2666;
  
  public static final int NERR_DfsLeafVolume = 2667;
  
  public static final int NERR_DfsVolumeHasMultipleServers = 2668;
  
  public static final int NERR_DfsCantCreateJunctionPoint = 2669;
  
  public static final int NERR_DfsServerNotDfsAware = 2670;
  
  public static final int NERR_DfsBadRenamePath = 2671;
  
  public static final int NERR_DfsVolumeIsOffline = 2672;
  
  public static final int NERR_DfsNoSuchServer = 2673;
  
  public static final int NERR_DfsCyclicalName = 2674;
  
  public static final int NERR_DfsNotSupportedInServerDfs = 2675;
  
  public static final int NERR_DfsDuplicateService = 2676;
  
  public static final int NERR_DfsCantRemoveLastServerShare = 2677;
  
  public static final int NERR_DfsVolumeIsInterDfs = 2678;
  
  public static final int NERR_DfsInconsistent = 2679;
  
  public static final int NERR_DfsServerUpgraded = 2680;
  
  public static final int NERR_DfsDataIsIdentical = 2681;
  
  public static final int NERR_DfsCantRemoveDfsRoot = 2682;
  
  public static final int NERR_DfsChildOrParentInDfs = 2683;
  
  public static final int NERR_DfsInternalError = 2690;
  
  public static final int NERR_SetupAlreadyJoined = 2691;
  
  public static final int NERR_SetupNotJoined = 2692;
  
  public static final int NERR_SetupDomainController = 2693;
  
  public static final int NERR_DefaultJoinRequired = 2694;
  
  public static final int NERR_InvalidWorkgroupName = 2695;
  
  public static final int NERR_NameUsesIncompatibleCodePage = 2696;
  
  public static final int NERR_ComputerAccountNotFound = 2697;
  
  public static final int NERR_PersonalSku = 2698;
  
  public static final int NERR_SetupCheckDNSConfig = 2699;
  
  public static final int NERR_PasswordMustChange = 2701;
  
  public static final int NERR_AccountLockedOut = 2702;
  
  public static final int NERR_PasswordTooLong = 2703;
  
  public static final int NERR_PasswordNotComplexEnough = 2704;
  
  public static final int NERR_PasswordFilterError = 2705;
  
  public static final int MAX_NERR = 2999;
}


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\LMErr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */