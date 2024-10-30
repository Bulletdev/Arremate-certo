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
/*     */ public class EscherSplitMenuColorsRecord
/*     */   extends EscherRecord
/*     */ {
/*     */   public static final short RECORD_ID = -3810;
/*     */   public static final String RECORD_DESCRIPTION = "MsofbtSplitMenuColors";
/*     */   private int field_1_color1;
/*     */   private int field_2_color2;
/*     */   private int field_3_color3;
/*     */   private int field_4_color4;
/*     */   
/*     */   public int fillFields(byte[] paramArrayOfbyte, int paramInt, EscherRecordFactory paramEscherRecordFactory) {
/*  41 */     int i = readHeader(paramArrayOfbyte, paramInt);
/*  42 */     int j = paramInt + 8;
/*  43 */     byte b = 0;
/*  44 */     this.field_1_color1 = LittleEndian.getInt(paramArrayOfbyte, j + b); b += 4;
/*  45 */     this.field_2_color2 = LittleEndian.getInt(paramArrayOfbyte, j + b); b += 4;
/*  46 */     this.field_3_color3 = LittleEndian.getInt(paramArrayOfbyte, j + b); b += 4;
/*  47 */     this.field_4_color4 = LittleEndian.getInt(paramArrayOfbyte, j + b); b += 4;
/*  48 */     i -= b;
/*  49 */     if (i != 0)
/*  50 */       throw new RecordFormatException("Expecting no remaining data but got " + i + " byte(s)."); 
/*  51 */     return 8 + b + i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte, EscherSerializationListener paramEscherSerializationListener) {
/*  57 */     paramEscherSerializationListener.beforeRecordSerialize(paramInt, getRecordId(), this);
/*     */     
/*  59 */     int i = paramInt;
/*  60 */     LittleEndian.putShort(paramArrayOfbyte, i, getOptions()); i += 2;
/*  61 */     LittleEndian.putShort(paramArrayOfbyte, i, getRecordId()); i += 2;
/*  62 */     int j = getRecordSize() - 8;
/*     */     
/*  64 */     LittleEndian.putInt(paramArrayOfbyte, i, j); i += 4;
/*  65 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_1_color1); i += 4;
/*  66 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_2_color2); i += 4;
/*  67 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_3_color3); i += 4;
/*  68 */     LittleEndian.putInt(paramArrayOfbyte, i, this.field_4_color4); i += 4;
/*  69 */     paramEscherSerializationListener.afterRecordSerialize(i, getRecordId(), i - paramInt, this);
/*  70 */     return getRecordSize();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getRecordSize() {
/*  75 */     return 24;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getRecordId() {
/*  80 */     return -3810;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getRecordName() {
/*  85 */     return "SplitMenuColors";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  93 */     return getClass().getName() + ":" + '\n' + "  RecordId: 0x" + HexDump.toHex((short)-3810) + '\n' + "  Version: 0x" + HexDump.toHex(getVersion()) + '\n' + "  Instance: 0x" + HexDump.toHex(getInstance()) + '\n' + "  Color1: 0x" + HexDump.toHex(this.field_1_color1) + '\n' + "  Color2: 0x" + HexDump.toHex(this.field_2_color2) + '\n' + "  Color3: 0x" + HexDump.toHex(this.field_3_color3) + '\n' + "  Color4: 0x" + HexDump.toHex(this.field_4_color4) + '\n' + "";
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
/* 106 */     StringBuilder stringBuilder = new StringBuilder();
/* 107 */     stringBuilder.append(paramString).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance()))).append(paramString).append("\t").append("<Color1>0x").append(HexDump.toHex(this.field_1_color1)).append("</Color1>\n").append(paramString).append("\t").append("<Color2>0x").append(HexDump.toHex(this.field_2_color2)).append("</Color2>\n").append(paramString).append("\t").append("<Color3>0x").append(HexDump.toHex(this.field_3_color3)).append("</Color3>\n").append(paramString).append("\t").append("<Color4>0x").append(HexDump.toHex(this.field_4_color4)).append("</Color4>\n");
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
/*     */   public int getColor1() {
/* 122 */     return this.field_1_color1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColor1(int paramInt) {
/* 131 */     this.field_1_color1 = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColor2() {
/* 140 */     return this.field_2_color2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColor2(int paramInt) {
/* 149 */     this.field_2_color2 = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColor3() {
/* 158 */     return this.field_3_color3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColor3(int paramInt) {
/* 167 */     this.field_3_color3 = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getColor4() {
/* 176 */     return this.field_4_color4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColor4(int paramInt) {
/* 185 */     this.field_4_color4 = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\EscherSplitMenuColorsRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */