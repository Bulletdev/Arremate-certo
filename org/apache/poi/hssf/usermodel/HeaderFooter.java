/*     */ package org.apache.poi.hssf.usermodel;
/*     */ 
/*     */ import org.apache.poi.ss.usermodel.HeaderFooter;
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
/*     */ public abstract class HeaderFooter
/*     */   implements HeaderFooter
/*     */ {
/*     */   protected abstract String getRawText();
/*     */   
/*     */   private String[] splitParts() {
/*  37 */     String str1 = getRawText();
/*     */     
/*  39 */     String str2 = "";
/*  40 */     String str3 = "";
/*  41 */     String str4 = "";
/*     */ 
/*     */     
/*  44 */     while (str1.length() > 1)
/*  45 */     { if (str1.charAt(0) != '&') {
/*     */         
/*  47 */         str3 = str1;
/*     */         break;
/*     */       } 
/*  50 */       int i = str1.length();
/*  51 */       switch (str1.charAt(1)) {
/*     */         case 'L':
/*  53 */           if (str1.indexOf("&C") >= 0) {
/*  54 */             i = Math.min(i, str1.indexOf("&C"));
/*     */           }
/*  56 */           if (str1.indexOf("&R") >= 0) {
/*  57 */             i = Math.min(i, str1.indexOf("&R"));
/*     */           }
/*  59 */           str2 = str1.substring(2, i);
/*  60 */           str1 = str1.substring(i);
/*     */           continue;
/*     */         case 'C':
/*  63 */           if (str1.indexOf("&L") >= 0) {
/*  64 */             i = Math.min(i, str1.indexOf("&L"));
/*     */           }
/*  66 */           if (str1.indexOf("&R") >= 0) {
/*  67 */             i = Math.min(i, str1.indexOf("&R"));
/*     */           }
/*  69 */           str3 = str1.substring(2, i);
/*  70 */           str1 = str1.substring(i);
/*     */           continue;
/*     */         case 'R':
/*  73 */           if (str1.indexOf("&C") >= 0) {
/*  74 */             i = Math.min(i, str1.indexOf("&C"));
/*     */           }
/*  76 */           if (str1.indexOf("&L") >= 0) {
/*  77 */             i = Math.min(i, str1.indexOf("&L"));
/*     */           }
/*  79 */           str4 = str1.substring(2, i);
/*  80 */           str1 = str1.substring(i);
/*     */           continue;
/*     */       } 
/*     */       
/*  84 */       str3 = str1;
/*     */ 
/*     */ 
/*     */       
/*  88 */       return new String[] { str2, str3, str4 }; }  return new String[] { str2, str3, str4 };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getLeft() {
/*  95 */     return splitParts()[0];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setLeft(String paramString) {
/* 102 */     updatePart(0, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getCenter() {
/* 109 */     return splitParts()[1];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setCenter(String paramString) {
/* 116 */     updatePart(1, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getRight() {
/* 123 */     return splitParts()[2];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final void setRight(String paramString) {
/* 130 */     updatePart(2, paramString);
/*     */   }
/*     */   
/*     */   private void updatePart(int paramInt, String paramString) {
/* 134 */     String[] arrayOfString = splitParts();
/* 135 */     arrayOfString[paramInt] = (paramString == null) ? "" : paramString;
/* 136 */     updateHeaderFooterText(arrayOfString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void updateHeaderFooterText(String[] paramArrayOfString) {
/* 143 */     String str1 = paramArrayOfString[0];
/* 144 */     String str2 = paramArrayOfString[1];
/* 145 */     String str3 = paramArrayOfString[2];
/*     */     
/* 147 */     if (str2.length() < 1 && str1.length() < 1 && str3.length() < 1) {
/* 148 */       setHeaderFooterText("");
/*     */       return;
/*     */     } 
/* 151 */     StringBuilder stringBuilder = new StringBuilder(64);
/* 152 */     stringBuilder.append("&C");
/* 153 */     stringBuilder.append(str2);
/* 154 */     stringBuilder.append("&L");
/* 155 */     stringBuilder.append(str1);
/* 156 */     stringBuilder.append("&R");
/* 157 */     stringBuilder.append(str3);
/* 158 */     String str4 = stringBuilder.toString();
/* 159 */     setHeaderFooterText(str4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void setHeaderFooterText(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String fontSize(short paramShort) {
/* 174 */     return "&" + paramShort;
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
/*     */   public static String font(String paramString1, String paramString2) {
/* 186 */     return "&\"" + paramString1 + "," + paramString2 + "\"";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String page() {
/* 193 */     return MarkupTag.PAGE_FIELD.getRepresentation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String numPages() {
/* 200 */     return MarkupTag.NUM_PAGES_FIELD.getRepresentation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String date() {
/* 207 */     return MarkupTag.DATE_FIELD.getRepresentation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String time() {
/* 214 */     return MarkupTag.TIME_FIELD.getRepresentation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String file() {
/* 221 */     return MarkupTag.FILE_FIELD.getRepresentation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String tab() {
/* 228 */     return MarkupTag.SHEET_NAME_FIELD.getRepresentation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String startBold() {
/* 235 */     return MarkupTag.BOLD_FIELD.getRepresentation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String endBold() {
/* 242 */     return MarkupTag.BOLD_FIELD.getRepresentation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String startUnderline() {
/* 249 */     return MarkupTag.UNDERLINE_FIELD.getRepresentation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String endUnderline() {
/* 256 */     return MarkupTag.UNDERLINE_FIELD.getRepresentation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String startDoubleUnderline() {
/* 263 */     return MarkupTag.DOUBLE_UNDERLINE_FIELD.getRepresentation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String endDoubleUnderline() {
/* 270 */     return MarkupTag.DOUBLE_UNDERLINE_FIELD.getRepresentation();
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
/*     */   public static String stripFields(String paramString) {
/* 282 */     if (paramString == null || paramString.length() == 0) {
/* 283 */       return paramString;
/*     */     }
/*     */     
/* 286 */     String str = paramString;
/*     */ 
/*     */     
/* 289 */     for (MarkupTag markupTag : MarkupTag.values()) {
/* 290 */       String str1 = markupTag.getRepresentation(); int i;
/* 291 */       while ((i = str.indexOf(str1)) > -1) {
/* 292 */         str = str.substring(0, i) + str.substring(i + str1.length());
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 298 */     str = str.replaceAll("\\&\\d+", "");
/* 299 */     str = str.replaceAll("\\&\".*?,.*?\"", "");
/*     */ 
/*     */     
/* 302 */     return str;
/*     */   }
/*     */   
/*     */   private enum MarkupTag {
/* 306 */     SHEET_NAME_FIELD("&A", false),
/* 307 */     DATE_FIELD("&D", false),
/* 308 */     FILE_FIELD("&F", false),
/* 309 */     FULL_FILE_FIELD("&Z", false),
/* 310 */     PAGE_FIELD("&P", false),
/* 311 */     TIME_FIELD("&T", false),
/* 312 */     NUM_PAGES_FIELD("&N", false),
/*     */     
/* 314 */     PICTURE_FIELD("&G", false),
/*     */     
/* 316 */     BOLD_FIELD("&B", true),
/* 317 */     ITALIC_FIELD("&I", true),
/* 318 */     STRIKETHROUGH_FIELD("&S", true),
/* 319 */     SUBSCRIPT_FIELD("&Y", true),
/* 320 */     SUPERSCRIPT_FIELD("&X", true),
/* 321 */     UNDERLINE_FIELD("&U", true),
/* 322 */     DOUBLE_UNDERLINE_FIELD("&E", true);
/*     */     
/*     */     private final String _representation;
/*     */     private final boolean _occursInPairs;
/*     */     
/*     */     MarkupTag(String param1String1, boolean param1Boolean) {
/* 328 */       this._representation = param1String1;
/* 329 */       this._occursInPairs = param1Boolean;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getRepresentation() {
/* 335 */       return this._representation;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean occursPairs() {
/* 343 */       return this._occursInPairs;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\usermodel\HeaderFooter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */