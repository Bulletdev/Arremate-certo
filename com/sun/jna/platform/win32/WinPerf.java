/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ import com.sun.jna.Pointer;
/*     */ import com.sun.jna.Structure;
/*     */ import com.sun.jna.Structure.FieldOrder;
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
/*     */ public interface WinPerf
/*     */ {
/*     */   public static final int PERF_NO_INSTANCES = -1;
/*     */   public static final int PERF_SIZE_DWORD = 0;
/*     */   public static final int PERF_SIZE_LARGE = 256;
/*     */   public static final int PERF_SIZE_ZERO = 512;
/*     */   public static final int PERF_SIZE_VARIABLE_LEN = 768;
/*     */   public static final int PERF_TYPE_NUMBER = 0;
/*     */   public static final int PERF_TYPE_COUNTER = 1024;
/*     */   public static final int PERF_TYPE_TEXT = 2048;
/*     */   public static final int PERF_TYPE_ZERO = 3072;
/*     */   public static final int PERF_NUMBER_HEX = 0;
/*     */   public static final int PERF_NUMBER_DECIMAL = 65536;
/*     */   public static final int PERF_NUMBER_DEC_1000 = 131072;
/*     */   public static final int PERF_COUNTER_VALUE = 0;
/*     */   public static final int PERF_COUNTER_RATE = 65536;
/*     */   public static final int PERF_COUNTER_FRACTION = 131072;
/*     */   public static final int PERF_COUNTER_BASE = 196608;
/*     */   public static final int PERF_COUNTER_ELAPSED = 262144;
/*     */   public static final int PERF_COUNTER_QUEUELEN = 327680;
/*     */   public static final int PERF_COUNTER_HISTOGRAM = 393216;
/*     */   public static final int PERF_COUNTER_PRECISION = 458752;
/*     */   public static final int PERF_TEXT_UNICODE = 0;
/*     */   public static final int PERF_TEXT_ASCII = 65536;
/*     */   public static final int PERF_TIMER_TICK = 0;
/*     */   public static final int PERF_TIMER_100NS = 1048576;
/*     */   public static final int PERF_OBJECT_TIMER = 2097152;
/*     */   public static final int PERF_DELTA_COUNTER = 4194304;
/*     */   public static final int PERF_DELTA_BASE = 8388608;
/*     */   public static final int PERF_INVERSE_COUNTER = 16777216;
/*     */   public static final int PERF_MULTI_COUNTER = 33554432;
/*     */   public static final int PERF_DISPLAY_NO_SUFFIX = 0;
/*     */   public static final int PERF_DISPLAY_PER_SEC = 268435456;
/*     */   public static final int PERF_DISPLAY_PERCENT = 536870912;
/*     */   public static final int PERF_DISPLAY_SECONDS = 805306368;
/*     */   public static final int PERF_DISPLAY_NOSHOW = 1073741824;
/*     */   public static final int PERF_COUNTER_COUNTER = 272696320;
/*     */   public static final int PERF_COUNTER_TIMER = 541132032;
/*     */   public static final int PERF_COUNTER_QUEUELEN_TYPE = 4523008;
/*     */   public static final int PERF_COUNTER_LARGE_QUEUELEN_TYPE = 4523264;
/*     */   public static final int PERF_COUNTER_100NS_QUEUELEN_TYPE = 5571840;
/*     */   public static final int PERF_COUNTER_OBJ_TIME_QUEUELEN_TYPE = 6620416;
/*     */   public static final int PERF_COUNTER_BULK_COUNT = 272696576;
/*     */   public static final int PERF_COUNTER_TEXT = 2816;
/*     */   public static final int PERF_COUNTER_RAWCOUNT = 65536;
/*     */   public static final int PERF_COUNTER_LARGE_RAWCOUNT = 65792;
/*     */   public static final int PERF_COUNTER_RAWCOUNT_HEX = 0;
/*     */   public static final int PERF_COUNTER_LARGE_RAWCOUNT_HEX = 256;
/*     */   public static final int PERF_SAMPLE_FRACTION = 549585920;
/*     */   public static final int PERF_SAMPLE_COUNTER = 4260864;
/*     */   public static final int PERF_COUNTER_NODATA = 1073742336;
/*     */   public static final int PERF_COUNTER_TIMER_INV = 557909248;
/*     */   public static final int PERF_SAMPLE_BASE = 1073939457;
/*     */   public static final int PERF_AVERAGE_TIMER = 805438464;
/*     */   public static final int PERF_AVERAGE_BASE = 1073939458;
/*     */   public static final int PERF_AVERAGE_BULK = 1073874176;
/*     */   public static final int PERF_OBJ_TIME_TIMER = 543229184;
/*     */   public static final int PERF_100NSEC_TIMER = 542180608;
/*     */   public static final int PERF_100NSEC_TIMER_INV = 558957824;
/*     */   public static final int PERF_COUNTER_MULTI_TIMER = 574686464;
/*     */   public static final int PERF_COUNTER_MULTI_TIMER_INV = 591463680;
/*     */   public static final int PERF_COUNTER_MULTI_BASE = 1107494144;
/*     */   public static final int PERF_100NSEC_MULTI_TIMER = 575735040;
/*     */   public static final int PERF_100NSEC_MULTI_TIMER_INV = 592512256;
/*     */   public static final int PERF_RAW_FRACTION = 537003008;
/*     */   public static final int PERF_LARGE_RAW_FRACTION = 537003264;
/*     */   public static final int PERF_RAW_BASE = 1073939459;
/*     */   public static final int PERF_LARGE_RAW_BASE = 1073939712;
/*     */   public static final int PERF_ELAPSED_TIME = 807666944;
/*     */   public static final int PERF_COUNTER_HISTOGRAM_TYPE = -2147483648;
/*     */   public static final int PERF_COUNTER_DELTA = 4195328;
/*     */   public static final int PERF_COUNTER_LARGE_DELTA = 4195584;
/*     */   public static final int PERF_PRECISION_SYSTEM_TIMER = 541525248;
/*     */   public static final int PERF_PRECISION_100NS_TIMER = 542573824;
/*     */   public static final int PERF_PRECISION_OBJECT_TIMER = 543622400;
/*     */   public static final int PERF_PRECISION_TIMESTAMP = 1073939712;
/*     */   public static final int PERF_DETAIL_NOVICE = 100;
/*     */   public static final int PERF_DETAIL_ADVANCED = 200;
/*     */   public static final int PERF_DETAIL_EXPERT = 300;
/*     */   public static final int PERF_DETAIL_WIZARD = 400;
/*     */   public static final int PERF_NO_UNIQUE_ID = -1;
/*     */   public static final int PERF_QUERY_OBJECTS = -2147483648;
/*     */   public static final int PERF_QUERY_GLOBAL = -2147483647;
/*     */   public static final int PERF_QUERY_COSTLY = -2147483646;
/*     */   
/*     */   @FieldOrder({"Signature", "LittleEndian", "Version", "Revision", "TotalByteLength", "HeaderLength", "NumObjectTypes", "DefaultObject", "SystemTime", "PerfTime", "PerfFreq", "PerfTime100nSec", "SystemNameLength", "SystemNameOffset"})
/*     */   public static class PERF_DATA_BLOCK
/*     */     extends Structure
/*     */   {
/* 425 */     public char[] Signature = new char[4];
/*     */     public int LittleEndian;
/*     */     public int Version;
/*     */     public int Revision;
/*     */     public int TotalByteLength;
/*     */     public int HeaderLength;
/*     */     public int NumObjectTypes;
/*     */     public int DefaultObject;
/* 433 */     public WinBase.SYSTEMTIME SystemTime = new WinBase.SYSTEMTIME();
/* 434 */     public WinNT.LARGE_INTEGER PerfTime = new WinNT.LARGE_INTEGER();
/* 435 */     public WinNT.LARGE_INTEGER PerfFreq = new WinNT.LARGE_INTEGER();
/* 436 */     public WinNT.LARGE_INTEGER PerfTime100nSec = new WinNT.LARGE_INTEGER();
/*     */     
/*     */     public int SystemNameLength;
/*     */     
/*     */     public int SystemNameOffset;
/*     */     
/*     */     public PERF_DATA_BLOCK() {}
/*     */     
/*     */     public PERF_DATA_BLOCK(Pointer param1Pointer) {
/* 445 */       super(param1Pointer);
/* 446 */       read();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @FieldOrder({"ByteLength", "ParentObjectTitleIndex", "ParentObjectInstance", "UniqueID", "NameOffset", "NameLength"})
/*     */   public static class PERF_INSTANCE_DEFINITION
/*     */     extends Structure
/*     */   {
/*     */     public int ByteLength;
/*     */     
/*     */     public int ParentObjectTitleIndex;
/*     */     
/*     */     public int ParentObjectInstance;
/*     */     
/*     */     public int UniqueID;
/*     */     
/*     */     public int NameOffset;
/*     */     public int NameLength;
/*     */     
/*     */     public PERF_INSTANCE_DEFINITION() {}
/*     */     
/*     */     public PERF_INSTANCE_DEFINITION(Pointer param1Pointer) {
/* 469 */       super(param1Pointer);
/* 470 */       read();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @FieldOrder({"TotalByteLength", "DefinitionLength", "HeaderLength", "ObjectNameTitleIndex", "ObjectNameTitle", "ObjectHelpTitleIndex", "ObjectHelpTitle", "DetailLevel", "NumCounters", "DefaultCounter", "NumInstances", "CodePage", "PerfTime", "PerfFreq"})
/*     */   public static class PERF_OBJECT_TYPE
/*     */     extends Structure
/*     */   {
/*     */     public int TotalByteLength;
/*     */     
/*     */     public int DefinitionLength;
/*     */     
/*     */     public int HeaderLength;
/*     */     
/*     */     public int ObjectNameTitleIndex;
/*     */     
/*     */     public int ObjectNameTitle;
/*     */     
/*     */     public int ObjectHelpTitleIndex;
/*     */     
/*     */     public int ObjectHelpTitle;
/*     */     
/*     */     public int DetailLevel;
/*     */     
/*     */     public int NumCounters;
/*     */     
/*     */     public int DefaultCounter;
/*     */     
/*     */     public int NumInstances;
/*     */     public int CodePage;
/*     */     public WinNT.LARGE_INTEGER PerfTime;
/*     */     public WinNT.LARGE_INTEGER PerfFreq;
/*     */     
/*     */     public PERF_OBJECT_TYPE() {}
/*     */     
/*     */     public PERF_OBJECT_TYPE(Pointer param1Pointer) {
/* 507 */       super(param1Pointer);
/* 508 */       read();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @FieldOrder({"ByteLength", "CounterNameTitleIndex", "CounterNameTitle", "CounterHelpTitleIndex", "CounterHelpTitle", "DefaultScale", "DetailLevel", "CounterType", "CounterSize", "CounterOffset"})
/*     */   public static class PERF_COUNTER_DEFINITION
/*     */     extends Structure
/*     */   {
/*     */     public int ByteLength;
/*     */     
/*     */     public int CounterNameTitleIndex;
/*     */     
/*     */     public int CounterNameTitle;
/*     */     
/*     */     public int CounterHelpTitleIndex;
/*     */     
/*     */     public int CounterHelpTitle;
/*     */     
/*     */     public int DefaultScale;
/*     */     
/*     */     public int DetailLevel;
/*     */     
/*     */     public int CounterType;
/*     */     public int CounterSize;
/*     */     public int CounterOffset;
/*     */     
/*     */     public PERF_COUNTER_DEFINITION() {}
/*     */     
/*     */     public PERF_COUNTER_DEFINITION(Pointer param1Pointer) {
/* 538 */       super(param1Pointer);
/* 539 */       read();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @FieldOrder({"ByteLength"})
/*     */   public static class PERF_COUNTER_BLOCK
/*     */     extends Structure
/*     */   {
/*     */     public int ByteLength;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public PERF_COUNTER_BLOCK() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public PERF_COUNTER_BLOCK(Pointer param1Pointer) {
/* 560 */       super(param1Pointer);
/* 561 */       read();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\WinPerf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */