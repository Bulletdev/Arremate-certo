/*     */ package org.apache.poi.xssf.usermodel.helpers;
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
/*     */ public class HeaderFooterHelper
/*     */ {
/*     */   private static final String HeaderFooterEntity_L = "&L";
/*     */   private static final String HeaderFooterEntity_C = "&C";
/*     */   private static final String HeaderFooterEntity_R = "&R";
/*     */   public static final String HeaderFooterEntity_File = "&F";
/*     */   public static final String HeaderFooterEntity_Date = "&D";
/*     */   public static final String HeaderFooterEntity_Time = "&T";
/*     */   
/*     */   public String getLeftSection(String paramString) {
/*  35 */     return getParts(paramString)[0];
/*     */   }
/*     */   public String getCenterSection(String paramString) {
/*  38 */     return getParts(paramString)[1];
/*     */   }
/*     */   public String getRightSection(String paramString) {
/*  41 */     return getParts(paramString)[2];
/*     */   }
/*     */   
/*     */   public String setLeftSection(String paramString1, String paramString2) {
/*  45 */     String[] arrayOfString = getParts(paramString1);
/*  46 */     arrayOfString[0] = paramString2;
/*  47 */     return joinParts(arrayOfString);
/*     */   }
/*     */   public String setCenterSection(String paramString1, String paramString2) {
/*  50 */     String[] arrayOfString = getParts(paramString1);
/*  51 */     arrayOfString[1] = paramString2;
/*  52 */     return joinParts(arrayOfString);
/*     */   }
/*     */   public String setRightSection(String paramString1, String paramString2) {
/*  55 */     String[] arrayOfString = getParts(paramString1);
/*  56 */     arrayOfString[2] = paramString2;
/*  57 */     return joinParts(arrayOfString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String[] getParts(String paramString) {
/*  64 */     String[] arrayOfString = { "", "", "" };
/*  65 */     if (paramString == null) {
/*  66 */       return arrayOfString;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  71 */     int i = 0;
/*  72 */     int j = 0;
/*  73 */     int k = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  79 */     while ((i = paramString.indexOf("&L")) > -2 && (j = paramString.indexOf("&C")) > -2 && (k = paramString.indexOf("&R")) > -2 && (i > -1 || j > -1 || k > -1)) {
/*     */ 
/*     */ 
/*     */       
/*  83 */       if (k > j && k > i) {
/*  84 */         arrayOfString[2] = paramString.substring(k + "&R".length());
/*  85 */         paramString = paramString.substring(0, k); continue;
/*  86 */       }  if (j > k && j > i) {
/*  87 */         arrayOfString[1] = paramString.substring(j + "&C".length());
/*  88 */         paramString = paramString.substring(0, j); continue;
/*     */       } 
/*  90 */       arrayOfString[0] = paramString.substring(i + "&L".length());
/*  91 */       paramString = paramString.substring(0, i);
/*     */     } 
/*     */ 
/*     */     
/*  95 */     return arrayOfString;
/*     */   }
/*     */   private String joinParts(String[] paramArrayOfString) {
/*  98 */     return joinParts(paramArrayOfString[0], paramArrayOfString[1], paramArrayOfString[2]);
/*     */   }
/*     */   private String joinParts(String paramString1, String paramString2, String paramString3) {
/* 101 */     StringBuffer stringBuffer = new StringBuffer();
/*     */ 
/*     */     
/* 104 */     if (paramString2.length() > 0) {
/* 105 */       stringBuffer.append("&C");
/* 106 */       stringBuffer.append(paramString2);
/*     */     } 
/* 108 */     if (paramString1.length() > 0) {
/* 109 */       stringBuffer.append("&L");
/* 110 */       stringBuffer.append(paramString1);
/*     */     } 
/* 112 */     if (paramString3.length() > 0) {
/* 113 */       stringBuffer.append("&R");
/* 114 */       stringBuffer.append(paramString3);
/*     */     } 
/*     */     
/* 117 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xss\\usermodel\helpers\HeaderFooterHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */