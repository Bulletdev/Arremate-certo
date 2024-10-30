/*     */ package org.apache.poi.ddf;
/*     */ 
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class EscherBSERecord
/*     */   extends EscherRecord
/*     */ {
/*     */   public static final short RECORD_ID = -4089;
/*     */   public static final String RECORD_DESCRIPTION = "MsofbtBSE";
/*     */   public static final byte BT_ERROR = 0;
/*     */   public static final byte BT_UNKNOWN = 1;
/*     */   public static final byte BT_EMF = 2;
/*     */   public static final byte BT_WMF = 3;
/*     */   public static final byte BT_PICT = 4;
/*     */   public static final byte BT_JPEG = 5;
/*     */   public static final byte BT_PNG = 6;
/*     */   public static final byte BT_DIB = 7;
/*     */   private byte field_1_blipTypeWin32;
/*     */   private byte field_2_blipTypeMacOS;
/*  45 */   private final byte[] field_3_uid = new byte[16];
/*     */   
/*     */   private short field_4_tag;
/*     */   private int field_5_size;
/*     */   private int field_6_ref;
/*     */   private int field_7_offset;
/*     */   private byte field_8_usage;
/*     */   private byte field_9_name;
/*     */   private byte field_10_unused2;
/*     */   private byte field_11_unused3;
/*     */   private EscherBlipRecord field_12_blipRecord;
/*  56 */   private byte[] _remainingData = new byte[0];
/*     */ 
/*     */   
/*     */   public int fillFields(byte[] paramArrayOfbyte, int paramInt, EscherRecordFactory paramEscherRecordFactory) {
/*  60 */     int i = readHeader(paramArrayOfbyte, paramInt);
/*  61 */     int j = paramInt + 8;
/*  62 */     this.field_1_blipTypeWin32 = paramArrayOfbyte[j];
/*  63 */     this.field_2_blipTypeMacOS = paramArrayOfbyte[j + 1];
/*  64 */     System.arraycopy(paramArrayOfbyte, j + 2, this.field_3_uid, 0, 16);
/*  65 */     this.field_4_tag = LittleEndian.getShort(paramArrayOfbyte, j + 18);
/*  66 */     this.field_5_size = LittleEndian.getInt(paramArrayOfbyte, j + 20);
/*  67 */     this.field_6_ref = LittleEndian.getInt(paramArrayOfbyte, j + 24);
/*  68 */     this.field_7_offset = LittleEndian.getInt(paramArrayOfbyte, j + 28);
/*  69 */     this.field_8_usage = paramArrayOfbyte[j + 32];
/*  70 */     this.field_9_name = paramArrayOfbyte[j + 33];
/*  71 */     this.field_10_unused2 = paramArrayOfbyte[j + 34];
/*  72 */     this.field_11_unused3 = paramArrayOfbyte[j + 35];
/*  73 */     i -= 36;
/*     */     
/*  75 */     int k = 0;
/*  76 */     if (i > 0) {
/*     */       
/*  78 */       this.field_12_blipRecord = (EscherBlipRecord)paramEscherRecordFactory.createRecord(paramArrayOfbyte, j + 36);
/*  79 */       k = this.field_12_blipRecord.fillFields(paramArrayOfbyte, j + 36, paramEscherRecordFactory);
/*     */     } 
/*  81 */     j += 36 + k;
/*  82 */     i -= k;
/*     */     
/*  84 */     this._remainingData = new byte[i];
/*  85 */     System.arraycopy(paramArrayOfbyte, j, this._remainingData, 0, i);
/*  86 */     return i + 8 + 36 + ((this.field_12_blipRecord == null) ? 0 : this.field_12_blipRecord.getRecordSize());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte, EscherSerializationListener paramEscherSerializationListener) {
/*  92 */     paramEscherSerializationListener.beforeRecordSerialize(paramInt, getRecordId(), this);
/*     */     
/*  94 */     if (this._remainingData == null) {
/*  95 */       this._remainingData = new byte[0];
/*     */     }
/*     */     
/*  98 */     LittleEndian.putShort(paramArrayOfbyte, paramInt, getOptions());
/*  99 */     LittleEndian.putShort(paramArrayOfbyte, paramInt + 2, getRecordId());
/* 100 */     byte b = (this.field_12_blipRecord == null) ? 0 : this.field_12_blipRecord.getRecordSize();
/* 101 */     int i = this._remainingData.length + 36 + b;
/* 102 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 4, i);
/*     */     
/* 104 */     paramArrayOfbyte[paramInt + 8] = this.field_1_blipTypeWin32;
/* 105 */     paramArrayOfbyte[paramInt + 9] = this.field_2_blipTypeMacOS; int j;
/* 106 */     for (j = 0; j < 16; j++)
/* 107 */       paramArrayOfbyte[paramInt + 10 + j] = this.field_3_uid[j]; 
/* 108 */     LittleEndian.putShort(paramArrayOfbyte, paramInt + 26, this.field_4_tag);
/* 109 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 28, this.field_5_size);
/* 110 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 32, this.field_6_ref);
/* 111 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 36, this.field_7_offset);
/* 112 */     paramArrayOfbyte[paramInt + 40] = this.field_8_usage;
/* 113 */     paramArrayOfbyte[paramInt + 41] = this.field_9_name;
/* 114 */     paramArrayOfbyte[paramInt + 42] = this.field_10_unused2;
/* 115 */     paramArrayOfbyte[paramInt + 43] = this.field_11_unused3;
/* 116 */     j = 0;
/* 117 */     if (this.field_12_blipRecord != null)
/*     */     {
/* 119 */       j = this.field_12_blipRecord.serialize(paramInt + 44, paramArrayOfbyte, new NullEscherSerializationListener());
/*     */     }
/* 121 */     System.arraycopy(this._remainingData, 0, paramArrayOfbyte, paramInt + 44 + j, this._remainingData.length);
/* 122 */     int k = paramInt + 8 + 36 + this._remainingData.length + j;
/*     */     
/* 124 */     paramEscherSerializationListener.afterRecordSerialize(k, getRecordId(), k - paramInt, this);
/* 125 */     return k - paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRecordSize() {
/* 130 */     int i = 0;
/* 131 */     if (this.field_12_blipRecord != null) {
/* 132 */       i = this.field_12_blipRecord.getRecordSize();
/*     */     }
/* 134 */     int j = 0;
/* 135 */     if (this._remainingData != null) {
/* 136 */       j = this._remainingData.length;
/*     */     }
/* 138 */     return 44 + i + j;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getRecordName() {
/* 144 */     return "BSE";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getBlipTypeWin32() {
/* 154 */     return this.field_1_blipTypeWin32;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBlipTypeWin32(byte paramByte) {
/* 163 */     this.field_1_blipTypeWin32 = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getBlipTypeMacOS() {
/* 173 */     return this.field_2_blipTypeMacOS;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBlipTypeMacOS(byte paramByte) {
/* 182 */     this.field_2_blipTypeMacOS = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getUid() {
/* 191 */     return this.field_3_uid;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUid(byte[] paramArrayOfbyte) {
/* 200 */     if (paramArrayOfbyte == null || paramArrayOfbyte.length != 16) {
/* 201 */       throw new IllegalArgumentException("uid must be byte[16]");
/*     */     }
/* 203 */     System.arraycopy(paramArrayOfbyte, 0, this.field_3_uid, 0, this.field_3_uid.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getTag() {
/* 212 */     return this.field_4_tag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTag(short paramShort) {
/* 221 */     this.field_4_tag = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSize() {
/* 230 */     return this.field_5_size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSize(int paramInt) {
/* 239 */     this.field_5_size = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRef() {
/* 248 */     return this.field_6_ref;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRef(int paramInt) {
/* 257 */     this.field_6_ref = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOffset() {
/* 266 */     return this.field_7_offset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOffset(int paramInt) {
/* 275 */     this.field_7_offset = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getUsage() {
/* 284 */     return this.field_8_usage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUsage(byte paramByte) {
/* 293 */     this.field_8_usage = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getName() {
/* 302 */     return this.field_9_name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(byte paramByte) {
/* 311 */     this.field_9_name = paramByte;
/*     */   }
/*     */   
/*     */   public byte getUnused2() {
/* 315 */     return this.field_10_unused2;
/*     */   }
/*     */   
/*     */   public void setUnused2(byte paramByte) {
/* 319 */     this.field_10_unused2 = paramByte;
/*     */   }
/*     */   
/*     */   public byte getUnused3() {
/* 323 */     return this.field_11_unused3;
/*     */   }
/*     */   
/*     */   public void setUnused3(byte paramByte) {
/* 327 */     this.field_11_unused3 = paramByte;
/*     */   }
/*     */   
/*     */   public EscherBlipRecord getBlipRecord() {
/* 331 */     return this.field_12_blipRecord;
/*     */   }
/*     */   
/*     */   public void setBlipRecord(EscherBlipRecord paramEscherBlipRecord) {
/* 335 */     this.field_12_blipRecord = paramEscherBlipRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getRemainingData() {
/* 344 */     return this._remainingData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRemainingData(byte[] paramArrayOfbyte) {
/* 353 */     if (paramArrayOfbyte == null) {
/* 354 */       this._remainingData = new byte[0];
/*     */     } else {
/* 356 */       this._remainingData = (byte[])paramArrayOfbyte.clone();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 362 */     String str = (this._remainingData == null) ? null : HexDump.toHex(this._remainingData, 32);
/* 363 */     return getClass().getName() + ":" + '\n' + "  RecordId: 0x" + HexDump.toHex((short)-4089) + '\n' + "  Version: 0x" + HexDump.toHex(getVersion()) + '\n' + "  Instance: 0x" + HexDump.toHex(getInstance()) + '\n' + "  BlipTypeWin32: " + this.field_1_blipTypeWin32 + '\n' + "  BlipTypeMacOS: " + this.field_2_blipTypeMacOS + '\n' + "  SUID: " + ((this.field_3_uid == null) ? "" : HexDump.toHex(this.field_3_uid)) + '\n' + "  Tag: " + this.field_4_tag + '\n' + "  Size: " + this.field_5_size + '\n' + "  Ref: " + this.field_6_ref + '\n' + "  Offset: " + this.field_7_offset + '\n' + "  Usage: " + this.field_8_usage + '\n' + "  Name: " + this.field_9_name + '\n' + "  Unused2: " + this.field_10_unused2 + '\n' + "  Unused3: " + this.field_11_unused3 + '\n' + "  blipRecord: " + this.field_12_blipRecord + '\n' + "  Extra Data:" + '\n' + str;
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
/*     */   public String toXml(String paramString) {
/* 384 */     StringBuilder stringBuilder = new StringBuilder();
/* 385 */     stringBuilder.append(paramString).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance()))).append(paramString).append("\t").append("<BlipTypeWin32>").append(this.field_1_blipTypeWin32).append("</BlipTypeWin32>\n").append(paramString).append("\t").append("<BlipTypeMacOS>").append(this.field_2_blipTypeMacOS).append("</BlipTypeMacOS>\n").append(paramString).append("\t").append("<SUID>").append((this.field_3_uid == null) ? "" : HexDump.toHex(this.field_3_uid)).append("</SUID>\n").append(paramString).append("\t").append("<Tag>").append(this.field_4_tag).append("</Tag>\n").append(paramString).append("\t").append("<Size>").append(this.field_5_size).append("</Size>\n").append(paramString).append("\t").append("<Ref>").append(this.field_6_ref).append("</Ref>\n").append(paramString).append("\t").append("<Offset>").append(this.field_7_offset).append("</Offset>\n").append(paramString).append("\t").append("<Usage>").append(this.field_8_usage).append("</Usage>\n").append(paramString).append("\t").append("<Name>").append(this.field_9_name).append("</Name>\n").append(paramString).append("\t").append("<Unused2>").append(this.field_10_unused2).append("</Unused2>\n").append(paramString).append("\t").append("<Unused3>").append(this.field_11_unused3).append("</Unused3>\n");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 397 */     stringBuilder.append(paramString).append("</").append(getClass().getSimpleName()).append(">\n");
/* 398 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getBlipType(byte paramByte) {
/* 409 */     switch (paramByte) { case 0:
/* 410 */         return " ERROR";
/* 411 */       case 1: return " UNKNOWN";
/* 412 */       case 2: return " EMF";
/* 413 */       case 3: return " WMF";
/* 414 */       case 4: return " PICT";
/* 415 */       case 5: return " JPEG";
/* 416 */       case 6: return " PNG";
/* 417 */       case 7: return " DIB"; }
/*     */     
/* 419 */     if (paramByte < 32) {
/* 420 */       return " NotKnown";
/*     */     }
/* 422 */     return " Client";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherBSERecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */