/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import org.apache.poi.ss.formula.ptg.Area3DPtg;
/*     */ import org.apache.poi.ss.formula.ptg.AreaPtg;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.formula.ptg.Ref3DPtg;
/*     */ import org.apache.poi.ss.formula.ptg.RefPtg;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndianInput;
/*     */ import org.apache.poi.util.LittleEndianInputStream;
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.util.StringUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class EmbeddedObjectRefSubRecord
/*     */   extends SubRecord
/*     */   implements Cloneable
/*     */ {
/*  42 */   private static POILogger logger = POILogFactory.getLogger(EmbeddedObjectRefSubRecord.class);
/*     */   
/*     */   public static final short sid = 9;
/*  45 */   private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
/*     */ 
/*     */   
/*     */   private int field_1_unknown_int;
/*     */   
/*     */   private Ptg field_2_refPtg;
/*     */   
/*     */   private byte[] field_2_unknownFormulaData;
/*     */   
/*     */   private boolean field_3_unicode_flag;
/*     */   
/*     */   private String field_4_ole_classname;
/*     */   
/*     */   private Byte field_4_unknownByte;
/*     */   
/*     */   private Integer field_5_stream_id;
/*     */   
/*     */   private byte[] field_6_unknown;
/*     */ 
/*     */   
/*     */   public EmbeddedObjectRefSubRecord() {
/*  66 */     this.field_2_unknownFormulaData = new byte[] { 2, 108, 106, 22, 1 };
/*  67 */     this.field_6_unknown = EMPTY_BYTE_ARRAY;
/*  68 */     this.field_4_ole_classname = null;
/*     */   }
/*     */   
/*     */   public short getSid() {
/*  72 */     return 9;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EmbeddedObjectRefSubRecord(LittleEndianInput paramLittleEndianInput, int paramInt) {
/*     */     byte b;
/*  82 */     short s = paramLittleEndianInput.readShort();
/*  83 */     int i = paramInt - 2;
/*     */     
/*  85 */     int j = i - s;
/*  86 */     int k = paramLittleEndianInput.readUShort();
/*  87 */     i -= 2;
/*  88 */     this.field_1_unknown_int = paramLittleEndianInput.readInt();
/*  89 */     i -= 4;
/*  90 */     byte[] arrayOfByte = readRawData(paramLittleEndianInput, k);
/*  91 */     i -= k;
/*  92 */     this.field_2_refPtg = readRefPtg(arrayOfByte);
/*  93 */     if (this.field_2_refPtg == null) {
/*     */ 
/*     */ 
/*     */       
/*  97 */       this.field_2_unknownFormulaData = arrayOfByte;
/*     */     } else {
/*  99 */       this.field_2_unknownFormulaData = null;
/*     */     } 
/*     */ 
/*     */     
/* 103 */     if (i >= j + 3) {
/* 104 */       byte b1 = paramLittleEndianInput.readByte();
/* 105 */       b = 1;
/* 106 */       if (b1 != 3) {
/* 107 */         throw new RecordFormatException("Expected byte 0x03 here");
/*     */       }
/* 109 */       int n = paramLittleEndianInput.readUShort();
/* 110 */       b += true;
/* 111 */       if (n > 0) {
/*     */         
/* 113 */         this.field_3_unicode_flag = ((paramLittleEndianInput.readByte() & 0x1) != 0);
/* 114 */         b++;
/* 115 */         if (this.field_3_unicode_flag) {
/* 116 */           this.field_4_ole_classname = StringUtil.readUnicodeLE(paramLittleEndianInput, n);
/* 117 */           b += n * 2;
/*     */         } else {
/* 119 */           this.field_4_ole_classname = StringUtil.readCompressedUnicode(paramLittleEndianInput, n);
/* 120 */           b += n;
/*     */         } 
/*     */       } else {
/* 123 */         this.field_4_ole_classname = "";
/*     */       } 
/*     */     } else {
/* 126 */       this.field_4_ole_classname = null;
/* 127 */       b = 0;
/*     */     } 
/* 129 */     i -= b;
/*     */     
/* 131 */     if ((b + k) % 2 != 0) {
/* 132 */       byte b1 = paramLittleEndianInput.readByte();
/* 133 */       i--;
/* 134 */       if (this.field_2_refPtg != null && this.field_4_ole_classname == null) {
/* 135 */         this.field_4_unknownByte = Byte.valueOf((byte)b1);
/*     */       }
/*     */     } 
/* 138 */     int m = i - j;
/*     */     
/* 140 */     if (m > 0) {
/* 141 */       logger.log(7, new Object[] { "Discarding " + m + " unexpected padding bytes " });
/* 142 */       readRawData(paramLittleEndianInput, m);
/* 143 */       i -= m;
/*     */     } 
/*     */ 
/*     */     
/* 147 */     if (j >= 4) {
/* 148 */       this.field_5_stream_id = Integer.valueOf(paramLittleEndianInput.readInt());
/* 149 */       i -= 4;
/*     */     } else {
/* 151 */       this.field_5_stream_id = null;
/*     */     } 
/* 153 */     this.field_6_unknown = readRawData(paramLittleEndianInput, i);
/*     */   }
/*     */   
/*     */   private static Ptg readRefPtg(byte[] paramArrayOfbyte) {
/* 157 */     LittleEndianInputStream littleEndianInputStream = new LittleEndianInputStream(new ByteArrayInputStream(paramArrayOfbyte));
/* 158 */     byte b = littleEndianInputStream.readByte();
/* 159 */     switch (b) { case 37:
/* 160 */         return (Ptg)new AreaPtg((LittleEndianInput)littleEndianInputStream);
/* 161 */       case 59: return (Ptg)new Area3DPtg((LittleEndianInput)littleEndianInputStream);
/* 162 */       case 36: return (Ptg)new RefPtg((LittleEndianInput)littleEndianInputStream);
/* 163 */       case 58: return (Ptg)new Ref3DPtg((LittleEndianInput)littleEndianInputStream); }
/*     */     
/* 165 */     return null;
/*     */   }
/*     */   
/*     */   private static byte[] readRawData(LittleEndianInput paramLittleEndianInput, int paramInt) {
/* 169 */     if (paramInt < 0) {
/* 170 */       throw new IllegalArgumentException("Negative size (" + paramInt + ")");
/*     */     }
/* 172 */     if (paramInt == 0) {
/* 173 */       return EMPTY_BYTE_ARRAY;
/*     */     }
/* 175 */     byte[] arrayOfByte = new byte[paramInt];
/* 176 */     paramLittleEndianInput.readFully(arrayOfByte);
/* 177 */     return arrayOfByte;
/*     */   }
/*     */   
/*     */   private int getStreamIDOffset(int paramInt) {
/* 181 */     int i = 6;
/* 182 */     i += paramInt;
/*     */ 
/*     */     
/* 185 */     if (this.field_4_ole_classname == null) {
/*     */       
/* 187 */       boolean bool = false;
/*     */     } else {
/* 189 */       i += 3;
/* 190 */       int j = this.field_4_ole_classname.length();
/* 191 */       if (j > 0) {
/* 192 */         i++;
/* 193 */         if (this.field_3_unicode_flag) {
/* 194 */           i += j * 2;
/*     */         } else {
/* 196 */           i += j;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 201 */     if (i % 2 != 0) {
/* 202 */       i++;
/*     */     }
/* 204 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   private int getDataSize(int paramInt) {
/* 209 */     int i = 2 + paramInt;
/* 210 */     if (this.field_5_stream_id != null) {
/* 211 */       i += 4;
/*     */     }
/* 213 */     return i + this.field_6_unknown.length;
/*     */   }
/*     */   protected int getDataSize() {
/* 216 */     int i = (this.field_2_refPtg == null) ? this.field_2_unknownFormulaData.length : this.field_2_refPtg.getSize();
/* 217 */     int j = getStreamIDOffset(i);
/* 218 */     return getDataSize(j);
/*     */   }
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 223 */     int i = (this.field_2_refPtg == null) ? this.field_2_unknownFormulaData.length : this.field_2_refPtg.getSize();
/* 224 */     int j = getStreamIDOffset(i);
/* 225 */     int k = getDataSize(j);
/*     */ 
/*     */     
/* 228 */     paramLittleEndianOutput.writeShort(9);
/* 229 */     paramLittleEndianOutput.writeShort(k);
/*     */     
/* 231 */     paramLittleEndianOutput.writeShort(j);
/* 232 */     paramLittleEndianOutput.writeShort(i);
/* 233 */     paramLittleEndianOutput.writeInt(this.field_1_unknown_int);
/*     */     
/* 235 */     int m = 12;
/*     */     
/* 237 */     if (this.field_2_refPtg == null) {
/* 238 */       paramLittleEndianOutput.write(this.field_2_unknownFormulaData);
/*     */     } else {
/* 240 */       this.field_2_refPtg.write(paramLittleEndianOutput);
/*     */     } 
/* 242 */     m += i;
/*     */ 
/*     */     
/* 245 */     if (this.field_4_ole_classname == null) {
/*     */       
/* 247 */       boolean bool = false;
/*     */     } else {
/* 249 */       paramLittleEndianOutput.writeByte(3);
/* 250 */       m++;
/* 251 */       int n = this.field_4_ole_classname.length();
/* 252 */       paramLittleEndianOutput.writeShort(n);
/* 253 */       m += 2;
/* 254 */       if (n > 0) {
/* 255 */         paramLittleEndianOutput.writeByte(this.field_3_unicode_flag ? 1 : 0);
/* 256 */         m++;
/*     */         
/* 258 */         if (this.field_3_unicode_flag) {
/* 259 */           StringUtil.putUnicodeLE(this.field_4_ole_classname, paramLittleEndianOutput);
/* 260 */           m += n * 2;
/*     */         } else {
/* 262 */           StringUtil.putCompressedUnicode(this.field_4_ole_classname, paramLittleEndianOutput);
/* 263 */           m += n;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 269 */     switch (j - m - 6) {
/*     */       case 1:
/* 271 */         paramLittleEndianOutput.writeByte((this.field_4_unknownByte == null) ? 0 : this.field_4_unknownByte.intValue());
/* 272 */         m++;
/*     */         break;
/*     */       case 0:
/*     */         break;
/*     */       default:
/* 277 */         throw new IllegalStateException("Bad padding calculation (" + j + ", " + m + ")");
/*     */     } 
/*     */     
/* 280 */     if (this.field_5_stream_id != null) {
/* 281 */       paramLittleEndianOutput.writeInt(this.field_5_stream_id.intValue());
/* 282 */       m += 4;
/*     */     } 
/* 284 */     paramLittleEndianOutput.write(this.field_6_unknown);
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
/*     */   public Integer getStreamId() {
/* 296 */     return this.field_5_stream_id;
/*     */   }
/*     */   
/*     */   public String getOLEClassName() {
/* 300 */     return this.field_4_ole_classname;
/*     */   }
/*     */   
/*     */   public byte[] getObjectData() {
/* 304 */     return this.field_6_unknown;
/*     */   }
/*     */ 
/*     */   
/*     */   public EmbeddedObjectRefSubRecord clone() {
/* 309 */     return this;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 313 */     StringBuffer stringBuffer = new StringBuffer();
/* 314 */     stringBuffer.append("[ftPictFmla]\n");
/* 315 */     stringBuffer.append("    .f2unknown     = ").append(HexDump.intToHex(this.field_1_unknown_int)).append("\n");
/* 316 */     if (this.field_2_refPtg == null) {
/* 317 */       stringBuffer.append("    .f3unknown     = ").append(HexDump.toHex(this.field_2_unknownFormulaData)).append("\n");
/*     */     } else {
/* 319 */       stringBuffer.append("    .formula       = ").append(this.field_2_refPtg.toString()).append("\n");
/*     */     } 
/* 321 */     if (this.field_4_ole_classname != null) {
/* 322 */       stringBuffer.append("    .unicodeFlag   = ").append(this.field_3_unicode_flag).append("\n");
/* 323 */       stringBuffer.append("    .oleClassname  = ").append(this.field_4_ole_classname).append("\n");
/*     */     } 
/* 325 */     if (this.field_4_unknownByte != null) {
/* 326 */       stringBuffer.append("    .f4unknown   = ").append(HexDump.byteToHex(this.field_4_unknownByte.intValue())).append("\n");
/*     */     }
/* 328 */     if (this.field_5_stream_id != null) {
/* 329 */       stringBuffer.append("    .streamId      = ").append(HexDump.intToHex(this.field_5_stream_id.intValue())).append("\n");
/*     */     }
/* 331 */     if (this.field_6_unknown.length > 0) {
/* 332 */       stringBuffer.append("    .f7unknown     = ").append(HexDump.toHex(this.field_6_unknown)).append("\n");
/*     */     }
/* 334 */     stringBuffer.append("[/ftPictFmla]");
/* 335 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void setUnknownFormulaData(byte[] paramArrayOfbyte) {
/* 339 */     this.field_2_unknownFormulaData = paramArrayOfbyte;
/*     */   }
/*     */   
/*     */   public void setOleClassname(String paramString) {
/* 343 */     this.field_4_ole_classname = paramString;
/*     */   }
/*     */   
/*     */   public void setStorageId(int paramInt) {
/* 347 */     this.field_5_stream_id = Integer.valueOf(paramInt);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\EmbeddedObjectRefSubRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */