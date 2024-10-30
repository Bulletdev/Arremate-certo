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
/*     */ public class EscherSpRecord
/*     */   extends EscherRecord
/*     */ {
/*     */   public static final short RECORD_ID = -4086;
/*     */   public static final String RECORD_DESCRIPTION = "MsofbtSp";
/*     */   public static final int FLAG_GROUP = 1;
/*     */   public static final int FLAG_CHILD = 2;
/*     */   public static final int FLAG_PATRIARCH = 4;
/*     */   public static final int FLAG_DELETED = 8;
/*     */   public static final int FLAG_OLESHAPE = 16;
/*     */   public static final int FLAG_HAVEMASTER = 32;
/*     */   public static final int FLAG_FLIPHORIZ = 64;
/*     */   public static final int FLAG_FLIPVERT = 128;
/*     */   public static final int FLAG_CONNECTOR = 256;
/*     */   public static final int FLAG_HAVEANCHOR = 512;
/*     */   public static final int FLAG_BACKGROUND = 1024;
/*     */   public static final int FLAG_HASSHAPETYPE = 2048;
/*     */   private int field_1_shapeId;
/*     */   private int field_2_flags;
/*     */   
/*     */   public int fillFields(byte[] paramArrayOfbyte, int paramInt, EscherRecordFactory paramEscherRecordFactory) {
/*  51 */     readHeader(paramArrayOfbyte, paramInt);
/*  52 */     int i = paramInt + 8;
/*  53 */     byte b = 0;
/*  54 */     this.field_1_shapeId = LittleEndian.getInt(paramArrayOfbyte, i + b); b += 4;
/*  55 */     this.field_2_flags = LittleEndian.getInt(paramArrayOfbyte, i + b); b += 4;
/*     */ 
/*     */ 
/*     */     
/*  59 */     return getRecordSize();
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
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte, EscherSerializationListener paramEscherSerializationListener) {
/*  75 */     paramEscherSerializationListener.beforeRecordSerialize(paramInt, getRecordId(), this);
/*  76 */     LittleEndian.putShort(paramArrayOfbyte, paramInt, getOptions());
/*  77 */     LittleEndian.putShort(paramArrayOfbyte, paramInt + 2, getRecordId());
/*  78 */     byte b = 8;
/*  79 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 4, b);
/*  80 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 8, this.field_1_shapeId);
/*  81 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 12, this.field_2_flags);
/*     */ 
/*     */     
/*  84 */     paramEscherSerializationListener.afterRecordSerialize(paramInt + getRecordSize(), getRecordId(), getRecordSize(), this);
/*  85 */     return 16;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRecordSize() {
/*  91 */     return 16;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getRecordId() {
/*  96 */     return -4086;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRecordName() {
/* 101 */     return "Sp";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 111 */     String str = System.getProperty("line.separator");
/*     */     
/* 113 */     return getClass().getName() + ":" + str + "  RecordId: 0x" + HexDump.toHex((short)-4086) + str + "  Version: 0x" + HexDump.toHex(getVersion()) + str + "  ShapeType: 0x" + HexDump.toHex(getShapeType()) + str + "  ShapeId: " + this.field_1_shapeId + str + "  Flags: " + decodeFlags(this.field_2_flags) + " (0x" + HexDump.toHex(this.field_2_flags) + ")" + str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toXml(String paramString) {
/* 124 */     StringBuilder stringBuilder = new StringBuilder();
/* 125 */     stringBuilder.append(paramString).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance()))).append(paramString).append("\t").append("<ShapeType>0x").append(HexDump.toHex(getShapeType())).append("</ShapeType>\n").append(paramString).append("\t").append("<ShapeId>").append(this.field_1_shapeId).append("</ShapeId>\n").append(paramString).append("\t").append("<Flags>").append(decodeFlags(this.field_2_flags) + " (0x" + HexDump.toHex(this.field_2_flags) + ")").append("</Flags>\n");
/*     */ 
/*     */ 
/*     */     
/* 129 */     stringBuilder.append(paramString).append("</").append(getClass().getSimpleName()).append(">\n");
/* 130 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String decodeFlags(int paramInt) {
/* 138 */     StringBuffer stringBuffer = new StringBuffer();
/* 139 */     stringBuffer.append(((paramInt & 0x1) != 0) ? "|GROUP" : "");
/* 140 */     stringBuffer.append(((paramInt & 0x2) != 0) ? "|CHILD" : "");
/* 141 */     stringBuffer.append(((paramInt & 0x4) != 0) ? "|PATRIARCH" : "");
/* 142 */     stringBuffer.append(((paramInt & 0x8) != 0) ? "|DELETED" : "");
/* 143 */     stringBuffer.append(((paramInt & 0x10) != 0) ? "|OLESHAPE" : "");
/* 144 */     stringBuffer.append(((paramInt & 0x20) != 0) ? "|HAVEMASTER" : "");
/* 145 */     stringBuffer.append(((paramInt & 0x40) != 0) ? "|FLIPHORIZ" : "");
/* 146 */     stringBuffer.append(((paramInt & 0x80) != 0) ? "|FLIPVERT" : "");
/* 147 */     stringBuffer.append(((paramInt & 0x100) != 0) ? "|CONNECTOR" : "");
/* 148 */     stringBuffer.append(((paramInt & 0x200) != 0) ? "|HAVEANCHOR" : "");
/* 149 */     stringBuffer.append(((paramInt & 0x400) != 0) ? "|BACKGROUND" : "");
/* 150 */     stringBuffer.append(((paramInt & 0x800) != 0) ? "|HASSHAPETYPE" : "");
/*     */ 
/*     */     
/* 153 */     if (stringBuffer.length() > 0) {
/* 154 */       stringBuffer.deleteCharAt(0);
/*     */     }
/* 156 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getShapeId() {
/* 164 */     return this.field_1_shapeId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShapeId(int paramInt) {
/* 174 */     this.field_1_shapeId = paramInt;
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
/*     */   public int getFlags() {
/* 197 */     return this.field_2_flags;
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
/*     */   public void setFlags(int paramInt) {
/* 220 */     this.field_2_flags = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getShapeType() {
/* 231 */     return getInstance();
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
/*     */   public void setShapeType(short paramShort) {
/* 243 */     setInstance(paramShort);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherSpRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */