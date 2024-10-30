/*     */ package org.apache.poi.ss.usermodel;
/*     */ 
/*     */ import java.awt.Color;
/*     */ import java.util.Locale;
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
/*     */ public abstract class ExtendedColor
/*     */   implements Color
/*     */ {
/*     */   protected void setColor(Color paramColor) {
/*  30 */     setRGB(new byte[] { (byte)paramColor.getRed(), (byte)paramColor.getGreen(), (byte)paramColor.getBlue() });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean isAuto();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean isIndexed();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean isRGB();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean isThemed();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract short getIndex();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int getTheme();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract byte[] getRGB();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract byte[] getARGB();
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract byte[] getStoredRBG();
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void setRGB(byte[] paramArrayOfbyte);
/*     */ 
/*     */ 
/*     */   
/*     */   protected byte[] getRGBOrARGB() {
/*  84 */     if (isIndexed() && getIndex() > 0) {
/*  85 */       short s = getIndex();
/*  86 */       HSSFColor hSSFColor = (HSSFColor)HSSFColor.getIndexHash().get(Integer.valueOf(s));
/*  87 */       if (hSSFColor != null) {
/*  88 */         byte[] arrayOfByte = new byte[3];
/*  89 */         arrayOfByte[0] = (byte)hSSFColor.getTriplet()[0];
/*  90 */         arrayOfByte[1] = (byte)hSSFColor.getTriplet()[1];
/*  91 */         arrayOfByte[2] = (byte)hSSFColor.getTriplet()[2];
/*  92 */         return arrayOfByte;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  97 */     return getStoredRBG();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getRGBWithTint() {
/* 105 */     byte[] arrayOfByte = getStoredRBG();
/* 106 */     if (arrayOfByte != null) {
/* 107 */       if (arrayOfByte.length == 4) {
/* 108 */         byte[] arrayOfByte1 = new byte[3];
/* 109 */         System.arraycopy(arrayOfByte, 1, arrayOfByte1, 0, 3);
/* 110 */         arrayOfByte = arrayOfByte1;
/*     */       } 
/* 112 */       double d = getTint();
/* 113 */       for (byte b = 0; b < arrayOfByte.length; b++) {
/* 114 */         arrayOfByte[b] = applyTint(arrayOfByte[b] & 0xFF, d);
/*     */       }
/*     */     } 
/* 117 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getARGBHex() {
/* 125 */     byte[] arrayOfByte = getARGB();
/* 126 */     if (arrayOfByte == null) {
/* 127 */       return null;
/*     */     }
/*     */     
/* 130 */     StringBuilder stringBuilder = new StringBuilder();
/* 131 */     for (byte b : arrayOfByte) {
/* 132 */       int i = b & 0xFF;
/* 133 */       String str = Integer.toHexString(i);
/* 134 */       if (str.length() == 1) {
/* 135 */         stringBuilder.append('0');
/*     */       }
/* 137 */       stringBuilder.append(str);
/*     */     } 
/* 139 */     return stringBuilder.toString().toUpperCase(Locale.ROOT);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setARGBHex(String paramString) {
/* 147 */     if (paramString.length() == 6 || paramString.length() == 8) {
/* 148 */       byte[] arrayOfByte = new byte[paramString.length() / 2];
/* 149 */       for (byte b = 0; b < arrayOfByte.length; b++) {
/* 150 */         String str = paramString.substring(b * 2, (b + 1) * 2);
/* 151 */         arrayOfByte[b] = (byte)Integer.parseInt(str, 16);
/*     */       } 
/* 153 */       setRGB(arrayOfByte);
/*     */     } else {
/* 155 */       throw new IllegalArgumentException("Must be of the form 112233 or FFEEDDCC");
/*     */     } 
/*     */   }
/*     */   
/*     */   private static byte applyTint(int paramInt, double paramDouble) {
/* 160 */     if (paramDouble > 0.0D)
/* 161 */       return (byte)(int)(paramInt * (1.0D - paramDouble) + 255.0D - 255.0D * (1.0D - paramDouble)); 
/* 162 */     if (paramDouble < 0.0D) {
/* 163 */       return (byte)(int)(paramInt * (1.0D + paramDouble));
/*     */     }
/* 165 */     return (byte)paramInt;
/*     */   }
/*     */   
/*     */   public abstract double getTint();
/*     */   
/*     */   public abstract void setTint(double paramDouble);
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\ExtendedColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */