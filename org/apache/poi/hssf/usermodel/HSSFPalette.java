/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import org.apache.poi.hssf.record.PaletteRecord;
/*     */ import org.apache.poi.hssf.util.HSSFColor;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class HSSFPalette
/*     */ {
/*     */   private PaletteRecord _palette;
/*     */   
/*     */   protected HSSFPalette(PaletteRecord paramPaletteRecord) {
/*  36 */     this._palette = paramPaletteRecord;
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
/*     */   public HSSFColor getColor(short paramShort) {
/*  48 */     if (paramShort == 64) {
/*  49 */       return HSSFColor.AUTOMATIC.getInstance();
/*     */     }
/*  51 */     byte[] arrayOfByte = this._palette.getColor(paramShort);
/*  52 */     if (arrayOfByte != null)
/*     */     {
/*  54 */       return new CustomColor(paramShort, arrayOfByte);
/*     */     }
/*  56 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HSSFColor getColor(int paramInt) {
/*  65 */     return getColor((short)paramInt);
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
/*     */   public HSSFColor findColor(byte paramByte1, byte paramByte2, byte paramByte3) {
/*  78 */     byte[] arrayOfByte = this._palette.getColor(8);
/*  79 */     for (short s = 8; arrayOfByte != null; 
/*  80 */       s = (short)(s + 1), arrayOfByte = this._palette.getColor(s)) {
/*     */       
/*  82 */       if (arrayOfByte[0] == paramByte1 && arrayOfByte[1] == paramByte2 && arrayOfByte[2] == paramByte3)
/*     */       {
/*  84 */         return new CustomColor(s, arrayOfByte);
/*     */       }
/*     */     } 
/*  87 */     return null;
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
/*     */   public HSSFColor findSimilarColor(byte paramByte1, byte paramByte2, byte paramByte3) {
/* 102 */     return findSimilarColor(unsignedInt(paramByte1), unsignedInt(paramByte2), unsignedInt(paramByte3));
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
/*     */   public HSSFColor findSimilarColor(int paramInt1, int paramInt2, int paramInt3) {
/* 116 */     HSSFColor hSSFColor = null;
/* 117 */     int i = Integer.MAX_VALUE;
/* 118 */     byte[] arrayOfByte = this._palette.getColor(8);
/* 119 */     for (short s = 8; arrayOfByte != null; 
/* 120 */       s = (short)(s + 1), arrayOfByte = this._palette.getColor(s)) {
/*     */       
/* 122 */       int j = Math.abs(paramInt1 - unsignedInt(arrayOfByte[0])) + Math.abs(paramInt2 - unsignedInt(arrayOfByte[1])) + Math.abs(paramInt3 - unsignedInt(arrayOfByte[2]));
/*     */ 
/*     */       
/* 125 */       if (j < i) {
/*     */         
/* 127 */         i = j;
/* 128 */         hSSFColor = getColor(s);
/*     */       } 
/*     */     } 
/* 131 */     return hSSFColor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int unsignedInt(byte paramByte) {
/* 139 */     return 0xFF & paramByte;
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
/*     */   public void setColorAtIndex(short paramShort, byte paramByte1, byte paramByte2, byte paramByte3) {
/* 152 */     this._palette.setColor(paramShort, paramByte1, paramByte2, paramByte3);
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
/*     */   public HSSFColor addColor(byte paramByte1, byte paramByte2, byte paramByte3) {
/* 167 */     byte[] arrayOfByte = this._palette.getColor(8);
/*     */     
/* 169 */     for (short s = 8; s < 64; s = (short)(s + 1), arrayOfByte = this._palette.getColor(s)) {
/*     */       
/* 171 */       if (arrayOfByte == null) {
/*     */         
/* 173 */         setColorAtIndex(s, paramByte1, paramByte2, paramByte3);
/* 174 */         return getColor(s);
/*     */       } 
/*     */     } 
/* 177 */     throw new RuntimeException("Could not find free color index");
/*     */   }
/*     */   
/*     */   private static final class CustomColor
/*     */     extends HSSFColor {
/*     */     private short _byteOffset;
/*     */     private byte _red;
/*     */     private byte _green;
/*     */     private byte _blue;
/*     */     
/*     */     public CustomColor(short param1Short, byte[] param1ArrayOfbyte) {
/* 188 */       this(param1Short, param1ArrayOfbyte[0], param1ArrayOfbyte[1], param1ArrayOfbyte[2]);
/*     */     }
/*     */ 
/*     */     
/*     */     private CustomColor(short param1Short, byte param1Byte1, byte param1Byte2, byte param1Byte3) {
/* 193 */       this._byteOffset = param1Short;
/* 194 */       this._red = param1Byte1;
/* 195 */       this._green = param1Byte2;
/* 196 */       this._blue = param1Byte3;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public short getIndex() {
/* 202 */       return this._byteOffset;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public short[] getTriplet() {
/* 208 */       return new short[] { (short)(this._red & 0xFF), (short)(this._green & 0xFF), (short)(this._blue & 0xFF) };
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getHexString() {
/* 219 */       StringBuffer stringBuffer = new StringBuffer();
/* 220 */       stringBuffer.append(getGnumericPart(this._red));
/* 221 */       stringBuffer.append(':');
/* 222 */       stringBuffer.append(getGnumericPart(this._green));
/* 223 */       stringBuffer.append(':');
/* 224 */       stringBuffer.append(getGnumericPart(this._blue));
/* 225 */       return stringBuffer.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     private String getGnumericPart(byte param1Byte) {
/*     */       String str;
/* 231 */       if (param1Byte == 0) {
/*     */         
/* 233 */         str = "0";
/*     */       }
/*     */       else {
/*     */         
/* 237 */         int i = param1Byte & 0xFF;
/* 238 */         i = i << 8 | i;
/* 239 */         str = Integer.toHexString(i).toUpperCase(Locale.ROOT);
/* 240 */         while (str.length() < 4)
/*     */         {
/* 242 */           str = "0" + str;
/*     */         }
/*     */       } 
/* 245 */       return str;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFPalette.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */