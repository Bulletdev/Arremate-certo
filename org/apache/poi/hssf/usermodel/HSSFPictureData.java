/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.ddf.EscherBlipRecord;
/*     */ import org.apache.poi.ss.usermodel.PictureData;
/*     */ import org.apache.poi.util.PngUtils;
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
/*     */ 
/*     */ public class HSSFPictureData
/*     */   implements PictureData
/*     */ {
/*     */   public static final short MSOBI_WMF = 8544;
/*     */   public static final short MSOBI_EMF = 15680;
/*     */   public static final short MSOBI_PICT = 21536;
/*     */   public static final short MSOBI_PNG = 28160;
/*     */   public static final short MSOBI_JPEG = 18080;
/*     */   public static final short MSOBI_DIB = 31360;
/*     */   public static final short FORMAT_MASK = -16;
/*     */   private EscherBlipRecord blip;
/*     */   
/*     */   public HSSFPictureData(EscherBlipRecord paramEscherBlipRecord) {
/*  55 */     this.blip = paramEscherBlipRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte[] getData() {
/*  63 */     byte[] arrayOfByte = this.blip.getPicturedata();
/*     */ 
/*     */ 
/*     */     
/*  67 */     if (PngUtils.matchesPngHeader(arrayOfByte, 16)) {
/*     */       
/*  69 */       byte[] arrayOfByte1 = new byte[arrayOfByte.length - 16];
/*  70 */       System.arraycopy(arrayOfByte, 16, arrayOfByte1, 0, arrayOfByte1.length);
/*  71 */       arrayOfByte = arrayOfByte1;
/*     */     } 
/*     */     
/*  74 */     return arrayOfByte;
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
/*     */   public int getFormat() {
/*  88 */     return this.blip.getRecordId() - -4072;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String suggestFileExtension() {
/*  96 */     switch (this.blip.getRecordId()) {
/*     */       case -4069:
/*  98 */         return "wmf";
/*     */       case -4070:
/* 100 */         return "emf";
/*     */       case -4068:
/* 102 */         return "pict";
/*     */       case -4066:
/* 104 */         return "png";
/*     */       case -4067:
/* 106 */         return "jpeg";
/*     */       case -4065:
/* 108 */         return "dib";
/*     */     } 
/* 110 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMimeType() {
/* 118 */     switch (this.blip.getRecordId()) {
/*     */       case -4069:
/* 120 */         return "image/x-wmf";
/*     */       case -4070:
/* 122 */         return "image/x-emf";
/*     */       case -4068:
/* 124 */         return "image/x-pict";
/*     */       case -4066:
/* 126 */         return "image/png";
/*     */       case -4067:
/* 128 */         return "image/jpeg";
/*     */       case -4065:
/* 130 */         return "image/bmp";
/*     */     } 
/* 132 */     return "image/unknown";
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
/*     */   public int getPictureType() {
/* 147 */     switch (this.blip.getRecordId()) {
/*     */       case -4069:
/* 149 */         return 3;
/*     */       case -4070:
/* 151 */         return 2;
/*     */       case -4068:
/* 153 */         return 4;
/*     */       case -4066:
/* 155 */         return 6;
/*     */       case -4067:
/* 157 */         return 5;
/*     */       case -4065:
/* 159 */         return 7;
/*     */     } 
/* 161 */     return -1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HSSFPictureData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */