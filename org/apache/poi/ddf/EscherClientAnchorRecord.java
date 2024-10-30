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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EscherClientAnchorRecord
/*     */   extends EscherRecord
/*     */ {
/*     */   public static final short RECORD_ID = -4080;
/*     */   public static final String RECORD_DESCRIPTION = "MsofbtClientAnchor";
/*     */   private short field_1_flag;
/*     */   private short field_2_col1;
/*     */   private short field_3_dx1;
/*     */   private short field_4_row1;
/*     */   private short field_5_dy1;
/*     */   private short field_6_col2;
/*     */   private short field_7_dx2;
/*     */   private short field_8_row2;
/*     */   private short field_9_dy2;
/*  54 */   private byte[] remainingData = new byte[0];
/*     */   
/*     */   private boolean shortRecord = false;
/*     */   
/*     */   public int fillFields(byte[] paramArrayOfbyte, int paramInt, EscherRecordFactory paramEscherRecordFactory) {
/*  59 */     int i = readHeader(paramArrayOfbyte, paramInt);
/*  60 */     int j = paramInt + 8;
/*  61 */     byte b = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  69 */     if (i != 4) {
/*     */       
/*  71 */       this.field_1_flag = LittleEndian.getShort(paramArrayOfbyte, j + b); b += 2;
/*  72 */       this.field_2_col1 = LittleEndian.getShort(paramArrayOfbyte, j + b); b += 2;
/*  73 */       this.field_3_dx1 = LittleEndian.getShort(paramArrayOfbyte, j + b); b += 2;
/*  74 */       this.field_4_row1 = LittleEndian.getShort(paramArrayOfbyte, j + b); b += 2;
/*  75 */       if (i >= 18) {
/*  76 */         this.field_5_dy1 = LittleEndian.getShort(paramArrayOfbyte, j + b); b += 2;
/*  77 */         this.field_6_col2 = LittleEndian.getShort(paramArrayOfbyte, j + b); b += 2;
/*  78 */         this.field_7_dx2 = LittleEndian.getShort(paramArrayOfbyte, j + b); b += 2;
/*  79 */         this.field_8_row2 = LittleEndian.getShort(paramArrayOfbyte, j + b); b += 2;
/*  80 */         this.field_9_dy2 = LittleEndian.getShort(paramArrayOfbyte, j + b); b += 2;
/*  81 */         this.shortRecord = false;
/*     */       } else {
/*  83 */         this.shortRecord = true;
/*     */       } 
/*     */     } 
/*  86 */     i -= b;
/*  87 */     this.remainingData = new byte[i];
/*  88 */     System.arraycopy(paramArrayOfbyte, j + b, this.remainingData, 0, i);
/*  89 */     return 8 + b + i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte, EscherSerializationListener paramEscherSerializationListener) {
/*  95 */     paramEscherSerializationListener.beforeRecordSerialize(paramInt, getRecordId(), this);
/*     */     
/*  97 */     if (this.remainingData == null) this.remainingData = new byte[0]; 
/*  98 */     LittleEndian.putShort(paramArrayOfbyte, paramInt, getOptions());
/*  99 */     LittleEndian.putShort(paramArrayOfbyte, paramInt + 2, getRecordId());
/* 100 */     int i = this.remainingData.length + (this.shortRecord ? 8 : 18);
/* 101 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 4, i);
/* 102 */     LittleEndian.putShort(paramArrayOfbyte, paramInt + 8, this.field_1_flag);
/* 103 */     LittleEndian.putShort(paramArrayOfbyte, paramInt + 10, this.field_2_col1);
/* 104 */     LittleEndian.putShort(paramArrayOfbyte, paramInt + 12, this.field_3_dx1);
/* 105 */     LittleEndian.putShort(paramArrayOfbyte, paramInt + 14, this.field_4_row1);
/* 106 */     if (!this.shortRecord) {
/* 107 */       LittleEndian.putShort(paramArrayOfbyte, paramInt + 16, this.field_5_dy1);
/* 108 */       LittleEndian.putShort(paramArrayOfbyte, paramInt + 18, this.field_6_col2);
/* 109 */       LittleEndian.putShort(paramArrayOfbyte, paramInt + 20, this.field_7_dx2);
/* 110 */       LittleEndian.putShort(paramArrayOfbyte, paramInt + 22, this.field_8_row2);
/* 111 */       LittleEndian.putShort(paramArrayOfbyte, paramInt + 24, this.field_9_dy2);
/*     */     } 
/* 113 */     System.arraycopy(this.remainingData, 0, paramArrayOfbyte, paramInt + (this.shortRecord ? 16 : 26), this.remainingData.length);
/* 114 */     int j = paramInt + 8 + (this.shortRecord ? 8 : 18) + this.remainingData.length;
/*     */     
/* 116 */     paramEscherSerializationListener.afterRecordSerialize(j, getRecordId(), j - paramInt, this);
/* 117 */     return j - paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRecordSize() {
/* 123 */     return 8 + (this.shortRecord ? 8 : 18) + ((this.remainingData == null) ? 0 : this.remainingData.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public short getRecordId() {
/* 128 */     return -4080;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRecordName() {
/* 133 */     return "ClientAnchor";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 144 */     String str1 = System.getProperty("line.separator");
/* 145 */     String str2 = HexDump.dump(this.remainingData, 0L, 0);
/* 146 */     return getClass().getName() + ":" + str1 + "  RecordId: 0x" + HexDump.toHex((short)-4080) + str1 + "  Version: 0x" + HexDump.toHex(getVersion()) + str1 + "  Instance: 0x" + HexDump.toHex(getInstance()) + str1 + "  Flag: " + this.field_1_flag + str1 + "  Col1: " + this.field_2_col1 + str1 + "  DX1: " + this.field_3_dx1 + str1 + "  Row1: " + this.field_4_row1 + str1 + "  DY1: " + this.field_5_dy1 + str1 + "  Col2: " + this.field_6_col2 + str1 + "  DX2: " + this.field_7_dx2 + str1 + "  Row2: " + this.field_8_row2 + str1 + "  DY2: " + this.field_9_dy2 + str1 + "  Extra Data:" + str1 + str2;
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
/*     */   public String toXml(String paramString) {
/* 165 */     String str = HexDump.dump(this.remainingData, 0L, 0).trim();
/* 166 */     return paramString + formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance())) + paramString + "\t" + "<Flag>" + this.field_1_flag + "</Flag>\n" + paramString + "\t" + "<Col1>" + this.field_2_col1 + "</Col1>\n" + paramString + "\t" + "<DX1>" + this.field_3_dx1 + "</DX1>\n" + paramString + "\t" + "<Row1>" + this.field_4_row1 + "</Row1>\n" + paramString + "\t" + "<DY1>" + this.field_5_dy1 + "</DY1>\n" + paramString + "\t" + "<Col2>" + this.field_6_col2 + "</Col2>\n" + paramString + "\t" + "<DX2>" + this.field_7_dx2 + "</DX2>\n" + paramString + "\t" + "<Row2>" + this.field_8_row2 + "</Row2>\n" + paramString + "\t" + "<DY2>" + this.field_9_dy2 + "</DY2>\n" + paramString + "\t" + "<ExtraData>" + str + "</ExtraData>\n" + paramString + "</" + getClass().getSimpleName() + ">\n";
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
/*     */   public short getFlag() {
/* 187 */     return this.field_1_flag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFlag(short paramShort) {
/* 197 */     this.field_1_flag = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getCol1() {
/* 207 */     return this.field_2_col1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCol1(short paramShort) {
/* 217 */     this.field_2_col1 = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getDx1() {
/* 227 */     return this.field_3_dx1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDx1(short paramShort) {
/* 237 */     this.field_3_dx1 = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getRow1() {
/* 247 */     return this.field_4_row1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRow1(short paramShort) {
/* 257 */     this.field_4_row1 = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getDy1() {
/* 267 */     return this.field_5_dy1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDy1(short paramShort) {
/* 277 */     this.shortRecord = false;
/* 278 */     this.field_5_dy1 = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getCol2() {
/* 288 */     return this.field_6_col2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCol2(short paramShort) {
/* 298 */     this.shortRecord = false;
/* 299 */     this.field_6_col2 = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getDx2() {
/* 309 */     return this.field_7_dx2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDx2(short paramShort) {
/* 319 */     this.shortRecord = false;
/* 320 */     this.field_7_dx2 = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getRow2() {
/* 330 */     return this.field_8_row2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRow2(short paramShort) {
/* 340 */     this.shortRecord = false;
/* 341 */     this.field_8_row2 = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getDy2() {
/* 351 */     return this.field_9_dy2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDy2(short paramShort) {
/* 361 */     this.shortRecord = false;
/* 362 */     this.field_9_dy2 = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getRemainingData() {
/* 372 */     return this.remainingData;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRemainingData(byte[] paramArrayOfbyte) {
/* 381 */     if (paramArrayOfbyte == null) {
/* 382 */       this.remainingData = new byte[0];
/*     */     } else {
/* 384 */       this.remainingData = (byte[])paramArrayOfbyte.clone();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherClientAnchorRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */