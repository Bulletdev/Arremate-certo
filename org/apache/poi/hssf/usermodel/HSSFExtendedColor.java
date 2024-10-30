/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.hssf.record.common.ExtendedColor;
/*     */ import org.apache.poi.ss.usermodel.ExtendedColor;
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
/*     */ public class HSSFExtendedColor
/*     */   extends ExtendedColor
/*     */ {
/*     */   private ExtendedColor color;
/*     */   
/*     */   public HSSFExtendedColor(ExtendedColor paramExtendedColor) {
/*  37 */     this.color = paramExtendedColor;
/*     */   }
/*     */   
/*     */   protected ExtendedColor getExtendedColor() {
/*  41 */     return this.color;
/*     */   }
/*     */   
/*     */   public boolean isAuto() {
/*  45 */     return (this.color.getType() == 0);
/*     */   }
/*     */   public boolean isIndexed() {
/*  48 */     return (this.color.getType() == 1);
/*     */   }
/*     */   public boolean isRGB() {
/*  51 */     return (this.color.getType() == 2);
/*     */   }
/*     */   public boolean isThemed() {
/*  54 */     return (this.color.getType() == 3);
/*     */   }
/*     */   
/*     */   public short getIndex() {
/*  58 */     return (short)this.color.getColorIndex();
/*     */   }
/*     */   public int getTheme() {
/*  61 */     return this.color.getThemeIndex();
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getRGB() {
/*  66 */     byte[] arrayOfByte1 = new byte[3];
/*  67 */     byte[] arrayOfByte2 = this.color.getRGBA();
/*  68 */     if (arrayOfByte2 == null) return null; 
/*  69 */     System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, 3);
/*  70 */     return arrayOfByte1;
/*     */   }
/*     */   
/*     */   public byte[] getARGB() {
/*  74 */     byte[] arrayOfByte1 = new byte[4];
/*  75 */     byte[] arrayOfByte2 = this.color.getRGBA();
/*  76 */     if (arrayOfByte2 == null) return null; 
/*  77 */     System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 1, 3);
/*  78 */     arrayOfByte1[0] = arrayOfByte2[3];
/*  79 */     return arrayOfByte1;
/*     */   }
/*     */   
/*     */   protected byte[] getStoredRBG() {
/*  83 */     return getARGB();
/*     */   }
/*     */   
/*     */   public void setRGB(byte[] paramArrayOfbyte) {
/*  87 */     if (paramArrayOfbyte.length == 3) {
/*  88 */       byte[] arrayOfByte = new byte[4];
/*  89 */       System.arraycopy(paramArrayOfbyte, 0, arrayOfByte, 0, 3);
/*  90 */       arrayOfByte[3] = -1;
/*     */     } else {
/*     */       
/*  93 */       byte b = paramArrayOfbyte[0];
/*  94 */       paramArrayOfbyte[0] = paramArrayOfbyte[1];
/*  95 */       paramArrayOfbyte[1] = paramArrayOfbyte[2];
/*  96 */       paramArrayOfbyte[2] = paramArrayOfbyte[3];
/*  97 */       paramArrayOfbyte[3] = b;
/*  98 */       this.color.setRGBA(paramArrayOfbyte);
/*     */     } 
/* 100 */     this.color.setType(2);
/*     */   }
/*     */   
/*     */   public double getTint() {
/* 104 */     return this.color.getTint();
/*     */   }
/*     */   public void setTint(double paramDouble) {
/* 107 */     this.color.setTint(paramDouble);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFExtendedColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */