/*     */ package oshi.driver.windows.registry;
/*     */ 
/*     */ import com.sun.jna.Memory;
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.platform.win32.Advapi32;
/*     */ import com.sun.jna.platform.win32.Advapi32Util;
/*     */ import com.sun.jna.platform.win32.Win32Exception;
/*     */ import com.sun.jna.platform.win32.WinReg;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import java.util.Collections;
/*     */ import java.util.EnumMap;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.util.platform.windows.PerfCounterWildcardQuery;
/*     */ import oshi.util.tuples.Pair;
/*     */ import oshi.util.tuples.Triplet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public final class HkeyPerformanceDataUtil
/*     */ {
/*  61 */   private static final Logger LOG = LoggerFactory.getLogger(HkeyPerformanceDataUtil.class);
/*     */ 
/*     */   
/*     */   private static final String HKEY_PERFORMANCE_TEXT = "SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Perflib\\009";
/*     */ 
/*     */   
/*     */   private static final String COUNTER = "Counter";
/*     */   
/*  69 */   private static final Map<String, Integer> COUNTER_INDEX_MAP = mapCounterIndicesFromRegistry();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends Enum<T> & PerfCounterWildcardQuery.PdhCounterWildcardProperty> Triplet<List<Map<T, Object>>, Long, Long> readPerfDataFromRegistry(String paramString, Class<T> paramClass) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: aload_1
/*     */     //   2: invokestatic getCounterIndices : (Ljava/lang/String;Ljava/lang/Class;)Loshi/util/tuples/Pair;
/*     */     //   5: astore_2
/*     */     //   6: aload_2
/*     */     //   7: ifnonnull -> 12
/*     */     //   10: aconst_null
/*     */     //   11: areturn
/*     */     //   12: aload_0
/*     */     //   13: invokestatic readPerfDataBuffer : (Ljava/lang/String;)Lcom/sun/jna/Memory;
/*     */     //   16: astore_3
/*     */     //   17: aload_3
/*     */     //   18: ifnonnull -> 23
/*     */     //   21: aconst_null
/*     */     //   22: areturn
/*     */     //   23: new com/sun/jna/platform/win32/WinPerf$PERF_DATA_BLOCK
/*     */     //   26: dup
/*     */     //   27: aload_3
/*     */     //   28: lconst_0
/*     */     //   29: invokevirtual share : (J)Lcom/sun/jna/Pointer;
/*     */     //   32: invokespecial <init> : (Lcom/sun/jna/Pointer;)V
/*     */     //   35: astore #4
/*     */     //   37: aload #4
/*     */     //   39: getfield PerfTime100nSec : Lcom/sun/jna/platform/win32/WinNT$LARGE_INTEGER;
/*     */     //   42: invokevirtual getValue : ()J
/*     */     //   45: lstore #5
/*     */     //   47: lload #5
/*     */     //   49: bipush #32
/*     */     //   51: lshr
/*     */     //   52: l2i
/*     */     //   53: lload #5
/*     */     //   55: ldc2_w 4294967295
/*     */     //   58: land
/*     */     //   59: l2i
/*     */     //   60: invokestatic filetimeToDate : (II)Ljava/util/Date;
/*     */     //   63: invokevirtual getTime : ()J
/*     */     //   66: lstore #7
/*     */     //   68: aload #4
/*     */     //   70: getfield HeaderLength : I
/*     */     //   73: i2l
/*     */     //   74: lstore #9
/*     */     //   76: iconst_0
/*     */     //   77: istore #11
/*     */     //   79: iload #11
/*     */     //   81: aload #4
/*     */     //   83: getfield NumObjectTypes : I
/*     */     //   86: if_icmpge -> 605
/*     */     //   89: new com/sun/jna/platform/win32/WinPerf$PERF_OBJECT_TYPE
/*     */     //   92: dup
/*     */     //   93: aload_3
/*     */     //   94: lload #9
/*     */     //   96: invokevirtual share : (J)Lcom/sun/jna/Pointer;
/*     */     //   99: invokespecial <init> : (Lcom/sun/jna/Pointer;)V
/*     */     //   102: astore #12
/*     */     //   104: aload #12
/*     */     //   106: getfield ObjectNameTitleIndex : I
/*     */     //   109: getstatic oshi/driver/windows/registry/HkeyPerformanceDataUtil.COUNTER_INDEX_MAP : Ljava/util/Map;
/*     */     //   112: aload_0
/*     */     //   113: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   118: checkcast java/lang/Integer
/*     */     //   121: invokevirtual intValue : ()I
/*     */     //   124: if_icmpne -> 588
/*     */     //   127: lload #9
/*     */     //   129: aload #12
/*     */     //   131: getfield HeaderLength : I
/*     */     //   134: i2l
/*     */     //   135: ladd
/*     */     //   136: lstore #13
/*     */     //   138: new java/util/HashMap
/*     */     //   141: dup
/*     */     //   142: invokespecial <init> : ()V
/*     */     //   145: astore #15
/*     */     //   147: new java/util/HashMap
/*     */     //   150: dup
/*     */     //   151: invokespecial <init> : ()V
/*     */     //   154: astore #16
/*     */     //   156: iconst_0
/*     */     //   157: istore #17
/*     */     //   159: iload #17
/*     */     //   161: aload #12
/*     */     //   163: getfield NumCounters : I
/*     */     //   166: if_icmpge -> 249
/*     */     //   169: new com/sun/jna/platform/win32/WinPerf$PERF_COUNTER_DEFINITION
/*     */     //   172: dup
/*     */     //   173: aload_3
/*     */     //   174: lload #13
/*     */     //   176: invokevirtual share : (J)Lcom/sun/jna/Pointer;
/*     */     //   179: invokespecial <init> : (Lcom/sun/jna/Pointer;)V
/*     */     //   182: astore #18
/*     */     //   184: aload #15
/*     */     //   186: aload #18
/*     */     //   188: getfield CounterNameTitleIndex : I
/*     */     //   191: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   194: aload #18
/*     */     //   196: getfield CounterOffset : I
/*     */     //   199: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   202: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   207: pop
/*     */     //   208: aload #16
/*     */     //   210: aload #18
/*     */     //   212: getfield CounterNameTitleIndex : I
/*     */     //   215: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   218: aload #18
/*     */     //   220: getfield CounterSize : I
/*     */     //   223: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   226: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   231: pop
/*     */     //   232: lload #13
/*     */     //   234: aload #18
/*     */     //   236: getfield ByteLength : I
/*     */     //   239: i2l
/*     */     //   240: ladd
/*     */     //   241: lstore #13
/*     */     //   243: iinc #17, 1
/*     */     //   246: goto -> 159
/*     */     //   249: lload #9
/*     */     //   251: aload #12
/*     */     //   253: getfield DefinitionLength : I
/*     */     //   256: i2l
/*     */     //   257: ladd
/*     */     //   258: lstore #17
/*     */     //   260: new java/util/ArrayList
/*     */     //   263: dup
/*     */     //   264: aload #12
/*     */     //   266: getfield NumInstances : I
/*     */     //   269: invokespecial <init> : (I)V
/*     */     //   272: astore #19
/*     */     //   274: iconst_0
/*     */     //   275: istore #20
/*     */     //   277: iload #20
/*     */     //   279: aload #12
/*     */     //   281: getfield NumInstances : I
/*     */     //   284: if_icmpge -> 568
/*     */     //   287: new com/sun/jna/platform/win32/WinPerf$PERF_INSTANCE_DEFINITION
/*     */     //   290: dup
/*     */     //   291: aload_3
/*     */     //   292: lload #17
/*     */     //   294: invokevirtual share : (J)Lcom/sun/jna/Pointer;
/*     */     //   297: invokespecial <init> : (Lcom/sun/jna/Pointer;)V
/*     */     //   300: astore #21
/*     */     //   302: lload #17
/*     */     //   304: aload #21
/*     */     //   306: getfield ByteLength : I
/*     */     //   309: i2l
/*     */     //   310: ladd
/*     */     //   311: lstore #22
/*     */     //   313: new java/util/EnumMap
/*     */     //   316: dup
/*     */     //   317: aload_1
/*     */     //   318: invokespecial <init> : (Ljava/lang/Class;)V
/*     */     //   321: astore #24
/*     */     //   323: aload_1
/*     */     //   324: invokevirtual getEnumConstants : ()[Ljava/lang/Object;
/*     */     //   327: checkcast [Ljava/lang/Enum;
/*     */     //   330: astore #25
/*     */     //   332: aload #24
/*     */     //   334: aload #25
/*     */     //   336: iconst_0
/*     */     //   337: aaload
/*     */     //   338: aload_3
/*     */     //   339: lload #17
/*     */     //   341: aload #21
/*     */     //   343: getfield NameOffset : I
/*     */     //   346: i2l
/*     */     //   347: ladd
/*     */     //   348: invokevirtual getWideString : (J)Ljava/lang/String;
/*     */     //   351: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   356: pop
/*     */     //   357: iconst_1
/*     */     //   358: istore #26
/*     */     //   360: iload #26
/*     */     //   362: aload #25
/*     */     //   364: arraylength
/*     */     //   365: if_icmpge -> 530
/*     */     //   368: aload #25
/*     */     //   370: iload #26
/*     */     //   372: aaload
/*     */     //   373: astore #27
/*     */     //   375: getstatic oshi/driver/windows/registry/HkeyPerformanceDataUtil.COUNTER_INDEX_MAP : Ljava/util/Map;
/*     */     //   378: aload #27
/*     */     //   380: checkcast oshi/util/platform/windows/PerfCounterWildcardQuery$PdhCounterWildcardProperty
/*     */     //   383: invokeinterface getCounter : ()Ljava/lang/String;
/*     */     //   388: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   393: checkcast java/lang/Integer
/*     */     //   396: invokevirtual intValue : ()I
/*     */     //   399: istore #28
/*     */     //   401: aload #16
/*     */     //   403: iload #28
/*     */     //   405: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   408: iconst_0
/*     */     //   409: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   412: invokeinterface getOrDefault : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   417: checkcast java/lang/Integer
/*     */     //   420: invokevirtual intValue : ()I
/*     */     //   423: istore #29
/*     */     //   425: iload #29
/*     */     //   427: iconst_4
/*     */     //   428: if_icmpne -> 473
/*     */     //   431: aload #24
/*     */     //   433: aload #27
/*     */     //   435: aload_3
/*     */     //   436: lload #22
/*     */     //   438: aload #15
/*     */     //   440: iload #28
/*     */     //   442: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   445: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   450: checkcast java/lang/Integer
/*     */     //   453: invokevirtual intValue : ()I
/*     */     //   456: i2l
/*     */     //   457: ladd
/*     */     //   458: invokevirtual getInt : (J)I
/*     */     //   461: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   464: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   469: pop
/*     */     //   470: goto -> 524
/*     */     //   473: iload #29
/*     */     //   475: bipush #8
/*     */     //   477: if_icmpne -> 522
/*     */     //   480: aload #24
/*     */     //   482: aload #27
/*     */     //   484: aload_3
/*     */     //   485: lload #22
/*     */     //   487: aload #15
/*     */     //   489: iload #28
/*     */     //   491: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   494: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   499: checkcast java/lang/Integer
/*     */     //   502: invokevirtual intValue : ()I
/*     */     //   505: i2l
/*     */     //   506: ladd
/*     */     //   507: invokevirtual getLong : (J)J
/*     */     //   510: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   513: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
/*     */     //   518: pop
/*     */     //   519: goto -> 524
/*     */     //   522: aconst_null
/*     */     //   523: areturn
/*     */     //   524: iinc #26, 1
/*     */     //   527: goto -> 360
/*     */     //   530: aload #19
/*     */     //   532: aload #24
/*     */     //   534: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   539: pop
/*     */     //   540: lload #22
/*     */     //   542: new com/sun/jna/platform/win32/WinPerf$PERF_COUNTER_BLOCK
/*     */     //   545: dup
/*     */     //   546: aload_3
/*     */     //   547: lload #22
/*     */     //   549: invokevirtual share : (J)Lcom/sun/jna/Pointer;
/*     */     //   552: invokespecial <init> : (Lcom/sun/jna/Pointer;)V
/*     */     //   555: getfield ByteLength : I
/*     */     //   558: i2l
/*     */     //   559: ladd
/*     */     //   560: lstore #17
/*     */     //   562: iinc #20, 1
/*     */     //   565: goto -> 277
/*     */     //   568: new oshi/util/tuples/Triplet
/*     */     //   571: dup
/*     */     //   572: aload #19
/*     */     //   574: lload #5
/*     */     //   576: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   579: lload #7
/*     */     //   581: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   584: invokespecial <init> : (Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
/*     */     //   587: areturn
/*     */     //   588: lload #9
/*     */     //   590: aload #12
/*     */     //   592: getfield TotalByteLength : I
/*     */     //   595: i2l
/*     */     //   596: ladd
/*     */     //   597: lstore #9
/*     */     //   599: iinc #11, 1
/*     */     //   602: goto -> 79
/*     */     //   605: aconst_null
/*     */     //   606: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #98	-> 0
/*     */     //   #99	-> 6
/*     */     //   #100	-> 10
/*     */     //   #104	-> 12
/*     */     //   #105	-> 17
/*     */     //   #106	-> 21
/*     */     //   #124	-> 23
/*     */     //   #125	-> 37
/*     */     //   #126	-> 47
/*     */     //   #127	-> 63
/*     */     //   #130	-> 68
/*     */     //   #131	-> 76
/*     */     //   #132	-> 89
/*     */     //   #136	-> 104
/*     */     //   #140	-> 127
/*     */     //   #142	-> 138
/*     */     //   #143	-> 147
/*     */     //   #144	-> 156
/*     */     //   #145	-> 169
/*     */     //   #146	-> 176
/*     */     //   #147	-> 184
/*     */     //   #148	-> 208
/*     */     //   #150	-> 232
/*     */     //   #144	-> 243
/*     */     //   #155	-> 249
/*     */     //   #158	-> 260
/*     */     //   #159	-> 274
/*     */     //   #160	-> 287
/*     */     //   #161	-> 294
/*     */     //   #162	-> 302
/*     */     //   #164	-> 313
/*     */     //   #165	-> 323
/*     */     //   #168	-> 332
/*     */     //   #169	-> 348
/*     */     //   #168	-> 351
/*     */     //   #170	-> 357
/*     */     //   #171	-> 368
/*     */     //   #172	-> 375
/*     */     //   #174	-> 401
/*     */     //   #177	-> 425
/*     */     //   #178	-> 431
/*     */     //   #179	-> 442
/*     */     //   #178	-> 464
/*     */     //   #180	-> 473
/*     */     //   #181	-> 480
/*     */     //   #182	-> 491
/*     */     //   #181	-> 513
/*     */     //   #185	-> 522
/*     */     //   #170	-> 524
/*     */     //   #188	-> 530
/*     */     //   #196	-> 540
/*     */     //   #197	-> 549
/*     */     //   #159	-> 562
/*     */     //   #201	-> 568
/*     */     //   #204	-> 588
/*     */     //   #131	-> 599
/*     */     //   #207	-> 605
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static <T extends Enum<T> & PerfCounterWildcardQuery.PdhCounterWildcardProperty> Pair<Integer, EnumMap<T, Integer>> getCounterIndices(String paramString, Class<T> paramClass) {
/* 229 */     if (!COUNTER_INDEX_MAP.containsKey(paramString)) {
/* 230 */       LOG.debug("Couldn't find counter index of {}.", paramString);
/* 231 */       return null;
/*     */     } 
/* 233 */     int i = ((Integer)COUNTER_INDEX_MAP.get(paramString)).intValue();
/* 234 */     Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
/* 235 */     EnumMap<T, Object> enumMap = new EnumMap<>(paramClass);
/*     */ 
/*     */     
/* 238 */     for (byte b = 1; b < arrayOfEnum.length; b++) {
/* 239 */       Enum enum_ = arrayOfEnum[b];
/* 240 */       String str = ((PerfCounterWildcardQuery.PdhCounterWildcardProperty)enum_).getCounter();
/* 241 */       if (!COUNTER_INDEX_MAP.containsKey(str)) {
/* 242 */         LOG.debug("Couldn't find counter index of {}.", str);
/* 243 */         return null;
/*     */       } 
/* 245 */       enumMap.put((T)enum_, COUNTER_INDEX_MAP.get(str));
/*     */     } 
/*     */     
/* 248 */     return new Pair(Integer.valueOf(i), enumMap);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Memory readPerfDataBuffer(String paramString) {
/* 262 */     String str = Integer.toString(((Integer)COUNTER_INDEX_MAP.get(paramString)).intValue());
/*     */ 
/*     */     
/* 265 */     char c = 'က';
/* 266 */     IntByReference intByReference = new IntByReference(c);
/* 267 */     Memory memory = new Memory(c);
/* 268 */     int i = Advapi32.INSTANCE.RegQueryValueEx(WinReg.HKEY_PERFORMANCE_DATA, str, 0, null, (Pointer)memory, intByReference);
/*     */     
/* 270 */     if (i != 0 && i != 234) {
/* 271 */       LOG.error("Error reading performance data from registry for {}.", paramString);
/* 272 */       return null;
/*     */     } 
/*     */     
/* 275 */     while (i == 234) {
/* 276 */       c += 'က';
/* 277 */       intByReference.setValue(c);
/* 278 */       memory = new Memory(c);
/* 279 */       i = Advapi32.INSTANCE.RegQueryValueEx(WinReg.HKEY_PERFORMANCE_DATA, str, 0, null, (Pointer)memory, intByReference);
/*     */     } 
/*     */     
/* 282 */     return memory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map<String, Integer> mapCounterIndicesFromRegistry() {
/* 299 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     try {
/* 301 */       String[] arrayOfString = Advapi32Util.registryGetStringArray(WinReg.HKEY_LOCAL_MACHINE, "SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\\Perflib\\009", "Counter");
/*     */       
/* 303 */       for (byte b = 1; b < arrayOfString.length; b += 2) {
/* 304 */         hashMap.putIfAbsent(arrayOfString[b], Integer.valueOf(Integer.parseInt(arrayOfString[b - 1])));
/*     */       }
/* 306 */     } catch (Win32Exception win32Exception) {
/* 307 */       LOG.error("Unable to locate English counter names in registry Perflib 009. Counters may need to be rebuilt: ", (Throwable)win32Exception);
/*     */     
/*     */     }
/* 310 */     catch (NumberFormatException numberFormatException) {
/*     */       
/* 312 */       LOG.error("Unable to parse English counter names in registry Perflib 009.");
/*     */     } 
/* 314 */     return (Map)Collections.unmodifiableMap(hashMap);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\registry\HkeyPerformanceDataUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */