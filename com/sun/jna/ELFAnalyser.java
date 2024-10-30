/*     */ package com.sun.jna;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.RandomAccessFile;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.math.BigInteger;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.ByteOrder;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class ELFAnalyser
/*     */ {
/*  51 */   private static final byte[] ELF_MAGIC = new byte[] { Byte.MAX_VALUE, 69, 76, 70 };
/*     */   
/*     */   private static final int EF_ARM_ABI_FLOAT_HARD = 1024;
/*     */   
/*     */   private static final int EF_ARM_ABI_FLOAT_SOFT = 512;
/*     */   
/*     */   private static final int EI_DATA_BIG_ENDIAN = 2;
/*     */   
/*     */   private static final int E_MACHINE_ARM = 40;
/*     */   
/*     */   private static final int EI_CLASS_64BIT = 2;
/*     */   
/*     */   private final String filename;
/*     */ 
/*     */   
/*     */   public static ELFAnalyser analyse(String paramString) throws IOException {
/*  67 */     ELFAnalyser eLFAnalyser = new ELFAnalyser(paramString);
/*  68 */     eLFAnalyser.runDetection();
/*  69 */     return eLFAnalyser;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean ELF = false;
/*     */   
/*     */   private boolean _64Bit = false;
/*     */   
/*     */   private boolean bigEndian = false;
/*     */   
/*     */   private boolean armHardFloatFlag = false;
/*     */   private boolean armSoftFloatFlag = false;
/*     */   private boolean armEabiAapcsVfp = false;
/*     */   private boolean arm = false;
/*     */   
/*     */   public boolean isELF() {
/*  85 */     return this.ELF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean is64Bit() {
/*  93 */     return this._64Bit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBigEndian() {
/* 101 */     return this.bigEndian;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFilename() {
/* 108 */     return this.filename;
/*     */   }
/*     */   
/*     */   public boolean isArmHardFloat() {
/* 112 */     return (isArmEabiAapcsVfp() || isArmHardFloatFlag());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isArmEabiAapcsVfp() {
/* 120 */     return this.armEabiAapcsVfp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isArmHardFloatFlag() {
/* 128 */     return this.armHardFloatFlag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isArmSoftFloatFlag() {
/* 136 */     return this.armSoftFloatFlag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isArm() {
/* 144 */     return this.arm;
/*     */   }
/*     */   
/*     */   private ELFAnalyser(String paramString) {
/* 148 */     this.filename = paramString;
/*     */   }
/*     */   
/*     */   private void runDetection() throws IOException {
/* 152 */     RandomAccessFile randomAccessFile = new RandomAccessFile(this.filename, "r");
/*     */ 
/*     */     
/*     */     try {
/* 156 */       if (randomAccessFile.length() > 4L) {
/* 157 */         byte[] arrayOfByte = new byte[4];
/* 158 */         randomAccessFile.seek(0L);
/* 159 */         randomAccessFile.read(arrayOfByte);
/* 160 */         if (Arrays.equals(arrayOfByte, ELF_MAGIC)) {
/* 161 */           this.ELF = true;
/*     */         }
/*     */       } 
/* 164 */       if (!this.ELF) {
/*     */         return;
/*     */       }
/* 167 */       randomAccessFile.seek(4L);
/*     */ 
/*     */       
/* 170 */       byte b1 = randomAccessFile.readByte();
/* 171 */       byte b2 = randomAccessFile.readByte();
/* 172 */       this._64Bit = (b1 == 2);
/* 173 */       this.bigEndian = (b2 == 2);
/* 174 */       randomAccessFile.seek(0L);
/*     */       
/* 176 */       ByteBuffer byteBuffer = ByteBuffer.allocate(this._64Bit ? 64 : 52);
/* 177 */       randomAccessFile.getChannel().read(byteBuffer, 0L);
/*     */       
/* 179 */       byteBuffer.order(this.bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
/*     */ 
/*     */       
/* 182 */       this.arm = (byteBuffer.get(18) == 40);
/*     */       
/* 184 */       if (this.arm) {
/*     */         
/* 186 */         int i = byteBuffer.getInt(this._64Bit ? 48 : 36);
/* 187 */         this.armHardFloatFlag = ((i & 0x400) == 1024);
/* 188 */         this.armSoftFloatFlag = ((i & 0x200) == 512);
/*     */         
/* 190 */         parseEabiAapcsVfp(byteBuffer, randomAccessFile);
/*     */       } 
/*     */     } finally {
/*     */       try {
/* 194 */         randomAccessFile.close();
/* 195 */       } catch (IOException iOException) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void parseEabiAapcsVfp(ByteBuffer paramByteBuffer, RandomAccessFile paramRandomAccessFile) throws IOException {
/* 202 */     ELFSectionHeaders eLFSectionHeaders = new ELFSectionHeaders(this._64Bit, this.bigEndian, paramByteBuffer, paramRandomAccessFile);
/*     */     
/* 204 */     for (ELFSectionHeaderEntry eLFSectionHeaderEntry : eLFSectionHeaders.getEntries()) {
/* 205 */       if (".ARM.attributes".equals(eLFSectionHeaderEntry.getName())) {
/* 206 */         ByteBuffer byteBuffer = ByteBuffer.allocate(eLFSectionHeaderEntry.getSize());
/* 207 */         byteBuffer.order(this.bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
/* 208 */         paramRandomAccessFile.getChannel().read(byteBuffer, eLFSectionHeaderEntry.getOffset());
/* 209 */         byteBuffer.rewind();
/* 210 */         Map<Integer, Map<ArmAeabiAttributesTag, Object>> map = parseArmAttributes(byteBuffer);
/* 211 */         Map map1 = map.get(Integer.valueOf(1));
/* 212 */         if (map1 == null) {
/*     */           continue;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 222 */         Object object = map1.get(ArmAeabiAttributesTag.ABI_VFP_args);
/* 223 */         if (object instanceof Integer && ((Integer)object).equals(Integer.valueOf(1))) {
/* 224 */           this.armEabiAapcsVfp = true; continue;
/* 225 */         }  if (object instanceof BigInteger && ((BigInteger)object).intValue() == 1)
/* 226 */           this.armEabiAapcsVfp = true; 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   static class ELFSectionHeaders { public ELFSectionHeaders(boolean param1Boolean1, boolean param1Boolean2, ByteBuffer param1ByteBuffer, RandomAccessFile param1RandomAccessFile) throws IOException {
/*     */       long l;
/*     */       short s1, s2, s3;
/* 233 */       this.entries = new ArrayList<ELFAnalyser.ELFSectionHeaderEntry>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 240 */       if (param1Boolean1) {
/* 241 */         l = param1ByteBuffer.getLong(40);
/* 242 */         s1 = param1ByteBuffer.getShort(58);
/* 243 */         s2 = param1ByteBuffer.getShort(60);
/* 244 */         s3 = param1ByteBuffer.getShort(62);
/*     */       } else {
/* 246 */         l = param1ByteBuffer.getInt(32);
/* 247 */         s1 = param1ByteBuffer.getShort(46);
/* 248 */         s2 = param1ByteBuffer.getShort(48);
/* 249 */         s3 = param1ByteBuffer.getShort(50);
/*     */       } 
/*     */       
/* 252 */       int i = s2 * s1;
/*     */       
/* 254 */       ByteBuffer byteBuffer1 = ByteBuffer.allocate(i);
/* 255 */       byteBuffer1.order(param1Boolean2 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
/* 256 */       param1RandomAccessFile.getChannel().read(byteBuffer1, l);
/*     */       
/* 258 */       for (byte b = 0; b < s2; b++) {
/* 259 */         byteBuffer1.position(b * s1);
/* 260 */         ByteBuffer byteBuffer = byteBuffer1.slice();
/* 261 */         byteBuffer.order(byteBuffer1.order());
/* 262 */         byteBuffer.limit(s1);
/* 263 */         this.entries.add(new ELFAnalyser.ELFSectionHeaderEntry(param1Boolean1, byteBuffer));
/*     */       } 
/*     */       
/* 266 */       ELFAnalyser.ELFSectionHeaderEntry eLFSectionHeaderEntry = this.entries.get(s3);
/* 267 */       ByteBuffer byteBuffer2 = ByteBuffer.allocate(eLFSectionHeaderEntry.getSize());
/* 268 */       byteBuffer2.order(param1Boolean2 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
/* 269 */       param1RandomAccessFile.getChannel().read(byteBuffer2, eLFSectionHeaderEntry.getOffset());
/* 270 */       byteBuffer2.rewind();
/*     */       
/* 272 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(20);
/* 273 */       for (ELFAnalyser.ELFSectionHeaderEntry eLFSectionHeaderEntry1 : this.entries) {
/* 274 */         byteArrayOutputStream.reset();
/*     */         
/* 276 */         byteBuffer2.position(eLFSectionHeaderEntry1.getNameOffset());
/*     */         
/* 278 */         while (byteBuffer2.position() < byteBuffer2.limit()) {
/* 279 */           byte b1 = byteBuffer2.get();
/* 280 */           if (b1 == 0) {
/*     */             break;
/*     */           }
/* 283 */           byteArrayOutputStream.write(b1);
/*     */         } 
/*     */ 
/*     */         
/* 287 */         eLFSectionHeaderEntry1.setName(byteArrayOutputStream.toString("ASCII"));
/*     */       } 
/*     */     }
/*     */     private final List<ELFAnalyser.ELFSectionHeaderEntry> entries;
/*     */     public List<ELFAnalyser.ELFSectionHeaderEntry> getEntries() {
/* 292 */       return this.entries;
/*     */     } }
/*     */ 
/*     */   
/*     */   static class ELFSectionHeaderEntry {
/*     */     private final int nameOffset;
/*     */     private String name;
/*     */     private final int type;
/*     */     private final int flags;
/*     */     private final int offset;
/*     */     private final int size;
/*     */     
/*     */     public ELFSectionHeaderEntry(boolean param1Boolean, ByteBuffer param1ByteBuffer) {
/* 305 */       this.nameOffset = param1ByteBuffer.getInt(0);
/* 306 */       this.type = param1ByteBuffer.getInt(4);
/* 307 */       this.flags = (int)(param1Boolean ? param1ByteBuffer.getLong(8) : param1ByteBuffer.getInt(8));
/* 308 */       this.offset = (int)(param1Boolean ? param1ByteBuffer.getLong(24) : param1ByteBuffer.getInt(16));
/* 309 */       this.size = (int)(param1Boolean ? param1ByteBuffer.getLong(32) : param1ByteBuffer.getInt(20));
/*     */     }
/*     */     
/*     */     public String getName() {
/* 313 */       return this.name;
/*     */     }
/*     */     
/*     */     public void setName(String param1String) {
/* 317 */       this.name = param1String;
/*     */     }
/*     */     
/*     */     public int getNameOffset() {
/* 321 */       return this.nameOffset;
/*     */     }
/*     */     
/*     */     public int getType() {
/* 325 */       return this.type;
/*     */     }
/*     */     
/*     */     public int getFlags() {
/* 329 */       return this.flags;
/*     */     }
/*     */     
/*     */     public int getOffset() {
/* 333 */       return this.offset;
/*     */     }
/*     */     
/*     */     public int getSize() {
/* 337 */       return this.size;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 342 */       return "ELFSectionHeaderEntry{nameIdx=" + this.nameOffset + ", name=" + this.name + ", type=" + this.type + ", flags=" + this.flags + ", offset=" + this.offset + ", size=" + this.size + '}';
/*     */     } }
/*     */   
/*     */   static class ArmAeabiAttributesTag { private final int value;
/*     */     private final String name;
/*     */     private final ParameterType parameterType;
/*     */     
/* 349 */     public enum ParameterType { UINT32, NTBS, ULEB128; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public ArmAeabiAttributesTag(int param1Int, String param1String, ParameterType param1ParameterType) {
/* 357 */       this.value = param1Int;
/* 358 */       this.name = param1String;
/* 359 */       this.parameterType = param1ParameterType;
/*     */     }
/*     */     
/*     */     public int getValue() {
/* 363 */       return this.value;
/*     */     }
/*     */     
/*     */     public String getName() {
/* 367 */       return this.name;
/*     */     }
/*     */     
/*     */     public ParameterType getParameterType() {
/* 371 */       return this.parameterType;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 376 */       return this.name + " (" + this.value + ")";
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 381 */       int i = 7;
/* 382 */       i = 67 * i + this.value;
/* 383 */       return i;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 388 */       if (this == param1Object) {
/* 389 */         return true;
/*     */       }
/* 391 */       if (param1Object == null) {
/* 392 */         return false;
/*     */       }
/* 394 */       if (getClass() != param1Object.getClass()) {
/* 395 */         return false;
/*     */       }
/* 397 */       ArmAeabiAttributesTag armAeabiAttributesTag = (ArmAeabiAttributesTag)param1Object;
/* 398 */       if (this.value != armAeabiAttributesTag.value) {
/* 399 */         return false;
/*     */       }
/* 401 */       return true;
/*     */     }
/*     */     
/* 404 */     private static final List<ArmAeabiAttributesTag> tags = new LinkedList<ArmAeabiAttributesTag>();
/* 405 */     private static final Map<Integer, ArmAeabiAttributesTag> valueMap = new HashMap<Integer, ArmAeabiAttributesTag>();
/* 406 */     private static final Map<String, ArmAeabiAttributesTag> nameMap = new HashMap<String, ArmAeabiAttributesTag>();
/*     */ 
/*     */     
/* 409 */     public static final ArmAeabiAttributesTag File = addTag(1, "File", ParameterType.UINT32);
/* 410 */     public static final ArmAeabiAttributesTag Section = addTag(2, "Section", ParameterType.UINT32);
/* 411 */     public static final ArmAeabiAttributesTag Symbol = addTag(3, "Symbol", ParameterType.UINT32);
/* 412 */     public static final ArmAeabiAttributesTag CPU_raw_name = addTag(4, "CPU_raw_name", ParameterType.NTBS);
/* 413 */     public static final ArmAeabiAttributesTag CPU_name = addTag(5, "CPU_name", ParameterType.NTBS);
/* 414 */     public static final ArmAeabiAttributesTag CPU_arch = addTag(6, "CPU_arch", ParameterType.ULEB128);
/* 415 */     public static final ArmAeabiAttributesTag CPU_arch_profile = addTag(7, "CPU_arch_profile", ParameterType.ULEB128);
/* 416 */     public static final ArmAeabiAttributesTag ARM_ISA_use = addTag(8, "ARM_ISA_use", ParameterType.ULEB128);
/* 417 */     public static final ArmAeabiAttributesTag THUMB_ISA_use = addTag(9, "THUMB_ISA_use", ParameterType.ULEB128);
/* 418 */     public static final ArmAeabiAttributesTag FP_arch = addTag(10, "FP_arch", ParameterType.ULEB128);
/* 419 */     public static final ArmAeabiAttributesTag WMMX_arch = addTag(11, "WMMX_arch", ParameterType.ULEB128);
/* 420 */     public static final ArmAeabiAttributesTag Advanced_SIMD_arch = addTag(12, "Advanced_SIMD_arch", ParameterType.ULEB128);
/* 421 */     public static final ArmAeabiAttributesTag PCS_config = addTag(13, "PCS_config", ParameterType.ULEB128);
/* 422 */     public static final ArmAeabiAttributesTag ABI_PCS_R9_use = addTag(14, "ABI_PCS_R9_use", ParameterType.ULEB128);
/* 423 */     public static final ArmAeabiAttributesTag ABI_PCS_RW_data = addTag(15, "ABI_PCS_RW_data", ParameterType.ULEB128);
/* 424 */     public static final ArmAeabiAttributesTag ABI_PCS_RO_data = addTag(16, "ABI_PCS_RO_data", ParameterType.ULEB128);
/* 425 */     public static final ArmAeabiAttributesTag ABI_PCS_GOT_use = addTag(17, "ABI_PCS_GOT_use", ParameterType.ULEB128);
/* 426 */     public static final ArmAeabiAttributesTag ABI_PCS_wchar_t = addTag(18, "ABI_PCS_wchar_t", ParameterType.ULEB128);
/* 427 */     public static final ArmAeabiAttributesTag ABI_FP_rounding = addTag(19, "ABI_FP_rounding", ParameterType.ULEB128);
/* 428 */     public static final ArmAeabiAttributesTag ABI_FP_denormal = addTag(20, "ABI_FP_denormal", ParameterType.ULEB128);
/* 429 */     public static final ArmAeabiAttributesTag ABI_FP_exceptions = addTag(21, "ABI_FP_exceptions", ParameterType.ULEB128);
/* 430 */     public static final ArmAeabiAttributesTag ABI_FP_user_exceptions = addTag(22, "ABI_FP_user_exceptions", ParameterType.ULEB128);
/* 431 */     public static final ArmAeabiAttributesTag ABI_FP_number_model = addTag(23, "ABI_FP_number_model", ParameterType.ULEB128);
/* 432 */     public static final ArmAeabiAttributesTag ABI_align_needed = addTag(24, "ABI_align_needed", ParameterType.ULEB128);
/* 433 */     public static final ArmAeabiAttributesTag ABI_align8_preserved = addTag(25, "ABI_align8_preserved", ParameterType.ULEB128);
/* 434 */     public static final ArmAeabiAttributesTag ABI_enum_size = addTag(26, "ABI_enum_size", ParameterType.ULEB128);
/* 435 */     public static final ArmAeabiAttributesTag ABI_HardFP_use = addTag(27, "ABI_HardFP_use", ParameterType.ULEB128);
/* 436 */     public static final ArmAeabiAttributesTag ABI_VFP_args = addTag(28, "ABI_VFP_args", ParameterType.ULEB128);
/* 437 */     public static final ArmAeabiAttributesTag ABI_WMMX_args = addTag(29, "ABI_WMMX_args", ParameterType.ULEB128);
/* 438 */     public static final ArmAeabiAttributesTag ABI_optimization_goals = addTag(30, "ABI_optimization_goals", ParameterType.ULEB128);
/* 439 */     public static final ArmAeabiAttributesTag ABI_FP_optimization_goals = addTag(31, "ABI_FP_optimization_goals", ParameterType.ULEB128);
/* 440 */     public static final ArmAeabiAttributesTag compatibility = addTag(32, "compatibility", ParameterType.NTBS);
/* 441 */     public static final ArmAeabiAttributesTag CPU_unaligned_access = addTag(34, "CPU_unaligned_access", ParameterType.ULEB128);
/* 442 */     public static final ArmAeabiAttributesTag FP_HP_extension = addTag(36, "FP_HP_extension", ParameterType.ULEB128);
/* 443 */     public static final ArmAeabiAttributesTag ABI_FP_16bit_format = addTag(38, "ABI_FP_16bit_format", ParameterType.ULEB128);
/* 444 */     public static final ArmAeabiAttributesTag MPextension_use = addTag(42, "MPextension_use", ParameterType.ULEB128);
/* 445 */     public static final ArmAeabiAttributesTag DIV_use = addTag(44, "DIV_use", ParameterType.ULEB128);
/* 446 */     public static final ArmAeabiAttributesTag nodefaults = addTag(64, "nodefaults", ParameterType.ULEB128);
/* 447 */     public static final ArmAeabiAttributesTag also_compatible_with = addTag(65, "also_compatible_with", ParameterType.NTBS);
/* 448 */     public static final ArmAeabiAttributesTag conformance = addTag(67, "conformance", ParameterType.NTBS);
/* 449 */     public static final ArmAeabiAttributesTag T2EE_use = addTag(66, "T2EE_use", ParameterType.ULEB128);
/* 450 */     public static final ArmAeabiAttributesTag Virtualization_use = addTag(68, "Virtualization_use", ParameterType.ULEB128);
/* 451 */     public static final ArmAeabiAttributesTag MPextension_use2 = addTag(70, "MPextension_use", ParameterType.ULEB128);
/*     */     
/*     */     private static ArmAeabiAttributesTag addTag(int param1Int, String param1String, ParameterType param1ParameterType) {
/* 454 */       ArmAeabiAttributesTag armAeabiAttributesTag = new ArmAeabiAttributesTag(param1Int, param1String, param1ParameterType);
/*     */       
/* 456 */       if (!valueMap.containsKey(Integer.valueOf(armAeabiAttributesTag.getValue()))) {
/* 457 */         valueMap.put(Integer.valueOf(armAeabiAttributesTag.getValue()), armAeabiAttributesTag);
/*     */       }
/* 459 */       if (!nameMap.containsKey(armAeabiAttributesTag.getName())) {
/* 460 */         nameMap.put(armAeabiAttributesTag.getName(), armAeabiAttributesTag);
/*     */       }
/* 462 */       tags.add(armAeabiAttributesTag);
/* 463 */       return armAeabiAttributesTag;
/*     */     }
/*     */     
/*     */     public static List<ArmAeabiAttributesTag> getTags() {
/* 467 */       return Collections.unmodifiableList(tags);
/*     */     }
/*     */     
/*     */     public static ArmAeabiAttributesTag getByName(String param1String) {
/* 471 */       return nameMap.get(param1String);
/*     */     }
/*     */     
/*     */     public static ArmAeabiAttributesTag getByValue(int param1Int) {
/* 475 */       if (valueMap.containsKey(Integer.valueOf(param1Int))) {
/* 476 */         return valueMap.get(Integer.valueOf(param1Int));
/*     */       }
/* 478 */       return new ArmAeabiAttributesTag(param1Int, "Unknown " + param1Int, getParameterType(param1Int));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static ParameterType getParameterType(int param1Int) {
/* 485 */       ArmAeabiAttributesTag armAeabiAttributesTag = getByValue(param1Int);
/* 486 */       if (armAeabiAttributesTag == null) {
/* 487 */         if (param1Int % 2 == 0) {
/* 488 */           return ParameterType.ULEB128;
/*     */         }
/* 490 */         return ParameterType.NTBS;
/*     */       } 
/*     */       
/* 493 */       return armAeabiAttributesTag.getParameterType();
/*     */     } }
/*     */ 
/*     */   
/*     */   public enum ParameterType { UINT32, NTBS, ULEB128; }
/*     */   
/*     */   private static Map<Integer, Map<ArmAeabiAttributesTag, Object>> parseArmAttributes(ByteBuffer paramByteBuffer) {
/* 500 */     byte b = paramByteBuffer.get();
/* 501 */     if (b != 65)
/*     */     {
/*     */       
/* 504 */       return Collections.EMPTY_MAP;
/*     */     }
/* 506 */     while (paramByteBuffer.position() < paramByteBuffer.limit()) {
/* 507 */       int i = paramByteBuffer.position();
/* 508 */       int j = paramByteBuffer.getInt();
/* 509 */       if (j <= 0) {
/*     */         break;
/*     */       }
/*     */       
/* 513 */       String str = readNTBS(paramByteBuffer, null);
/* 514 */       if ("aeabi".equals(str)) {
/* 515 */         return parseAEABI(paramByteBuffer);
/*     */       }
/* 517 */       paramByteBuffer.position(i + j);
/*     */     } 
/* 519 */     return Collections.EMPTY_MAP;
/*     */   }
/*     */   
/*     */   private static Map<Integer, Map<ArmAeabiAttributesTag, Object>> parseAEABI(ByteBuffer paramByteBuffer) {
/* 523 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 524 */     while (paramByteBuffer.position() < paramByteBuffer.limit()) {
/* 525 */       int i = paramByteBuffer.position();
/* 526 */       int j = readULEB128(paramByteBuffer).intValue();
/* 527 */       int k = paramByteBuffer.getInt();
/* 528 */       if (j == 1) {
/* 529 */         hashMap.put(Integer.valueOf(j), parseFileAttribute(paramByteBuffer));
/*     */       }
/* 531 */       paramByteBuffer.position(i + k);
/*     */     } 
/* 533 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   private static Map<ArmAeabiAttributesTag, Object> parseFileAttribute(ByteBuffer paramByteBuffer) {
/* 537 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
/* 538 */     while (paramByteBuffer.position() < paramByteBuffer.limit()) {
/* 539 */       int i = readULEB128(paramByteBuffer).intValue();
/* 540 */       ArmAeabiAttributesTag armAeabiAttributesTag = ArmAeabiAttributesTag.getByValue(i);
/* 541 */       switch (armAeabiAttributesTag.getParameterType()) {
/*     */         case UINT32:
/* 543 */           hashMap.put(armAeabiAttributesTag, Integer.valueOf(paramByteBuffer.getInt()));
/*     */         
/*     */         case NTBS:
/* 546 */           hashMap.put(armAeabiAttributesTag, readNTBS(paramByteBuffer, null));
/*     */         
/*     */         case ULEB128:
/* 549 */           hashMap.put(armAeabiAttributesTag, readULEB128(paramByteBuffer));
/*     */       } 
/*     */     
/*     */     } 
/* 553 */     return (Map)hashMap;
/*     */   }
/*     */   private static String readNTBS(ByteBuffer paramByteBuffer, Integer paramInteger) {
/*     */     byte b;
/* 557 */     if (paramInteger != null) {
/* 558 */       paramByteBuffer.position(paramInteger.intValue());
/*     */     }
/* 560 */     int i = paramByteBuffer.position();
/*     */     
/*     */     do {
/* 563 */       b = paramByteBuffer.get();
/* 564 */     } while (b != 0 && paramByteBuffer.position() <= paramByteBuffer.limit());
/* 565 */     int j = paramByteBuffer.position();
/* 566 */     byte[] arrayOfByte = new byte[j - i - 1];
/* 567 */     paramByteBuffer.position(i);
/* 568 */     paramByteBuffer.get(arrayOfByte);
/* 569 */     paramByteBuffer.position(paramByteBuffer.position() + 1);
/*     */     try {
/* 571 */       return new String(arrayOfByte, "ASCII");
/* 572 */     } catch (UnsupportedEncodingException unsupportedEncodingException) {
/* 573 */       throw new RuntimeException(unsupportedEncodingException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static BigInteger readULEB128(ByteBuffer paramByteBuffer) {
/* 578 */     BigInteger bigInteger = BigInteger.ZERO;
/* 579 */     boolean bool = false;
/*     */     while (true) {
/* 581 */       byte b = paramByteBuffer.get();
/* 582 */       bigInteger = bigInteger.or(BigInteger.valueOf((b & Byte.MAX_VALUE)).shiftLeft(bool));
/* 583 */       if ((b & 0x80) == 0) {
/*     */         break;
/*     */       }
/* 586 */       bool += true;
/*     */     } 
/* 588 */     return bigInteger;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\ELFAnalyser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */