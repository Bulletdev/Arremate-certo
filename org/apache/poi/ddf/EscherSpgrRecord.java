/*     */ package org.apache.poi.ddf;
/*     */ 
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.RecordFormatException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EscherSpgrRecord
/*     */   extends EscherRecord
/*     */ {
/*     */   public static final short RECORD_ID = -4087;
/*     */   public static final String RECORD_DESCRIPTION = "MsofbtSpgr";
/*     */   private int field_1_rectX1;
/*     */   private int field_2_rectY1;
/*     */   private int field_3_rectX2;
/*     */   private int field_4_rectY2;
/*     */   
/*     */   public int fillFields(byte[] paramArrayOfbyte, int paramInt, EscherRecordFactory paramEscherRecordFactory) {
/*  41 */     int i = readHeader(paramArrayOfbyte, paramInt);
/*  42 */     int j = paramInt + 8;
/*  43 */     byte b = 0;
/*  44 */     this.field_1_rectX1 = LittleEndian.getInt(paramArrayOfbyte, j + b); b += 4;
/*  45 */     this.field_2_rectY1 = LittleEndian.getInt(paramArrayOfbyte, j + b); b += 4;
/*  46 */     this.field_3_rectX2 = LittleEndian.getInt(paramArrayOfbyte, j + b); b += 4;
/*  47 */     this.field_4_rectY2 = LittleEndian.getInt(paramArrayOfbyte, j + b); b += 4;
/*  48 */     i -= b;
/*  49 */     if (i != 0) throw new RecordFormatException("Expected no remaining bytes but got " + i);
/*     */ 
/*     */     
/*  52 */     return 8 + b + i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte, EscherSerializationListener paramEscherSerializationListener) {
/*  58 */     paramEscherSerializationListener.beforeRecordSerialize(paramInt, getRecordId(), this);
/*  59 */     LittleEndian.putShort(paramArrayOfbyte, paramInt, getOptions());
/*  60 */     LittleEndian.putShort(paramArrayOfbyte, paramInt + 2, getRecordId());
/*  61 */     byte b = 16;
/*  62 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 4, b);
/*  63 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 8, this.field_1_rectX1);
/*  64 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 12, this.field_2_rectY1);
/*  65 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 16, this.field_3_rectX2);
/*  66 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 20, this.field_4_rectY2);
/*     */ 
/*     */     
/*  69 */     paramEscherSerializationListener.afterRecordSerialize(paramInt + getRecordSize(), getRecordId(), paramInt + getRecordSize(), this);
/*  70 */     return 24;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRecordSize() {
/*  76 */     return 24;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getRecordId() {
/*  81 */     return -4087;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRecordName() {
/*  86 */     return "Spgr";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  94 */     return getClass().getName() + ":" + '\n' + "  RecordId: 0x" + HexDump.toHex((short)-4087) + '\n' + "  Version: 0x" + HexDump.toHex(getVersion()) + '\n' + "  Instance: 0x" + HexDump.toHex(getInstance()) + '\n' + "  RectX: " + this.field_1_rectX1 + '\n' + "  RectY: " + this.field_2_rectY1 + '\n' + "  RectWidth: " + this.field_3_rectX2 + '\n' + "  RectHeight: " + this.field_4_rectY2 + '\n';
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
/*     */   public String toXml(String paramString) {
/* 106 */     StringBuilder stringBuilder = new StringBuilder();
/* 107 */     stringBuilder.append(paramString).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance()))).append(paramString).append("\t").append("<RectX>").append(this.field_1_rectX1).append("</RectX>\n").append(paramString).append("\t").append("<RectY>").append(this.field_2_rectY1).append("</RectY>\n").append(paramString).append("\t").append("<RectWidth>").append(this.field_3_rectX2).append("</RectWidth>\n").append(paramString).append("\t").append("<RectHeight>").append(this.field_4_rectY2).append("</RectHeight>\n");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     stringBuilder.append(paramString).append("</").append(getClass().getSimpleName()).append(">\n");
/* 113 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRectX1() {
/* 123 */     return this.field_1_rectX1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRectX1(int paramInt) {
/* 133 */     this.field_1_rectX1 = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRectY1() {
/* 143 */     return this.field_2_rectY1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRectY1(int paramInt) {
/* 153 */     this.field_2_rectY1 = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRectX2() {
/* 163 */     return this.field_3_rectX2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRectX2(int paramInt) {
/* 173 */     this.field_3_rectX2 = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRectY2() {
/* 183 */     return this.field_4_rectY2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRectY2(int paramInt) {
/* 192 */     this.field_4_rectY2 = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherSpgrRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */