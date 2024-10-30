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
/*     */ public class EscherChildAnchorRecord
/*     */   extends EscherRecord
/*     */ {
/*     */   public static final short RECORD_ID = -4081;
/*     */   public static final String RECORD_DESCRIPTION = "MsofbtChildAnchor";
/*     */   private int field_1_dx1;
/*     */   private int field_2_dy1;
/*     */   private int field_3_dx2;
/*     */   private int field_4_dy2;
/*     */   
/*     */   public int fillFields(byte[] paramArrayOfbyte, int paramInt, EscherRecordFactory paramEscherRecordFactory) {
/*  43 */     int i = readHeader(paramArrayOfbyte, paramInt);
/*  44 */     int j = paramInt + 8;
/*  45 */     byte b = 0;
/*  46 */     switch (i) {
/*     */       case 16:
/*  48 */         this.field_1_dx1 = LittleEndian.getInt(paramArrayOfbyte, j + b); b += 4;
/*  49 */         this.field_2_dy1 = LittleEndian.getInt(paramArrayOfbyte, j + b); b += 4;
/*  50 */         this.field_3_dx2 = LittleEndian.getInt(paramArrayOfbyte, j + b); b += 4;
/*  51 */         this.field_4_dy2 = LittleEndian.getInt(paramArrayOfbyte, j + b); b += 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  63 */         return 8 + b;case 8: this.field_1_dx1 = LittleEndian.getShort(paramArrayOfbyte, j + b); b += 2; this.field_2_dy1 = LittleEndian.getShort(paramArrayOfbyte, j + b); b += 2; this.field_3_dx2 = LittleEndian.getShort(paramArrayOfbyte, j + b); b += 2; this.field_4_dy2 = LittleEndian.getShort(paramArrayOfbyte, j + b); b += 2; return 8 + b;
/*     */     } 
/*     */     throw new RuntimeException("Invalid EscherChildAnchorRecord - neither 8 nor 16 bytes.");
/*     */   }
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte, EscherSerializationListener paramEscherSerializationListener) {
/*  68 */     paramEscherSerializationListener.beforeRecordSerialize(paramInt, getRecordId(), this);
/*  69 */     int i = paramInt;
/*  70 */     LittleEndian.putShort(paramArrayOfbyte, i, getOptions()); i += 2;
/*  71 */     LittleEndian.putShort(paramArrayOfbyte, i, getRecordId()); i += 2;
/*  72 */     LittleEndian.putInt(paramArrayOfbyte, i, getRecordSize() - 8); i += 4;
/*  73 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_1_dx1); i += 4;
/*  74 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_2_dy1); i += 4;
/*  75 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_3_dx2); i += 4;
/*  76 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_4_dy2); i += 4;
/*     */     
/*  78 */     paramEscherSerializationListener.afterRecordSerialize(i, getRecordId(), i - paramInt, this);
/*  79 */     return i - paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRecordSize() {
/*  85 */     return 24;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getRecordId() {
/*  90 */     return -4081;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRecordName() {
/*  95 */     return "ChildAnchor";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 105 */     String str = System.getProperty("line.separator");
/*     */     
/* 107 */     return getClass().getName() + ":" + str + "  RecordId: 0x" + HexDump.toHex((short)-4081) + str + "  Version: 0x" + HexDump.toHex(getVersion()) + str + "  Instance: 0x" + HexDump.toHex(getInstance()) + str + "  X1: " + this.field_1_dx1 + str + "  Y1: " + this.field_2_dy1 + str + "  X2: " + this.field_3_dx2 + str + "  Y2: " + this.field_4_dy2 + str;
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
/*     */   public String toXml(String paramString) {
/* 120 */     StringBuilder stringBuilder = new StringBuilder();
/* 121 */     stringBuilder.append(paramString).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance()))).append(paramString).append("\t").append("<X1>").append(this.field_1_dx1).append("</X1>\n").append(paramString).append("\t").append("<Y1>").append(this.field_2_dy1).append("</Y1>\n").append(paramString).append("\t").append("<X2>").append(this.field_3_dx2).append("</X2>\n").append(paramString).append("\t").append("<Y2>").append(this.field_4_dy2).append("</Y2>\n");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 126 */     stringBuilder.append(paramString).append("</").append(getClass().getSimpleName()).append(">\n");
/* 127 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDx1() {
/* 137 */     return this.field_1_dx1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDx1(int paramInt) {
/* 147 */     this.field_1_dx1 = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDy1() {
/* 157 */     return this.field_2_dy1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDy1(int paramInt) {
/* 167 */     this.field_2_dy1 = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDx2() {
/* 177 */     return this.field_3_dx2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDx2(int paramInt) {
/* 187 */     this.field_3_dx2 = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDy2() {
/* 197 */     return this.field_4_dy2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDy2(int paramInt) {
/* 207 */     this.field_4_dy2 = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherChildAnchorRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */