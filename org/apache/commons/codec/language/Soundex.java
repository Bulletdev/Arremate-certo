/*     */ package org.apache.commons.codec.language;
/*     */ 
/*     */ import org.apache.commons.codec.EncoderException;
/*     */ import org.apache.commons.codec.StringEncoder;
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
/*     */ public class Soundex
/*     */   implements StringEncoder
/*     */ {
/*     */   public static final char SILENT_MARKER = '-';
/*     */   public static final String US_ENGLISH_MAPPING_STRING = "01230120022455012623010202";
/*  65 */   private static final char[] US_ENGLISH_MAPPING = "01230120022455012623010202".toCharArray();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  75 */   public static final Soundex US_ENGLISH = new Soundex();
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
/*  88 */   public static final Soundex US_ENGLISH_SIMPLIFIED = new Soundex("01230120022455012623010202", false);
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
/* 103 */   public static final Soundex US_ENGLISH_GENEALOGY = new Soundex("-123-12--22455-12623-1-2-2");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/* 111 */   private int maxLength = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final char[] soundexMapping;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean specialCaseHW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Soundex() {
/* 136 */     this.soundexMapping = US_ENGLISH_MAPPING;
/* 137 */     this.specialCaseHW = true;
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
/*     */   public Soundex(char[] paramArrayOfchar) {
/* 153 */     this.soundexMapping = new char[paramArrayOfchar.length];
/* 154 */     System.arraycopy(paramArrayOfchar, 0, this.soundexMapping, 0, paramArrayOfchar.length);
/* 155 */     this.specialCaseHW = !hasMarker(this.soundexMapping);
/*     */   }
/*     */   
/*     */   private boolean hasMarker(char[] paramArrayOfchar) {
/* 159 */     for (char c : paramArrayOfchar) {
/* 160 */       if (c == '-') {
/* 161 */         return true;
/*     */       }
/*     */     } 
/* 164 */     return false;
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
/*     */   public Soundex(String paramString) {
/* 178 */     this.soundexMapping = paramString.toCharArray();
/* 179 */     this.specialCaseHW = !hasMarker(this.soundexMapping);
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
/*     */   public Soundex(String paramString, boolean paramBoolean) {
/* 192 */     this.soundexMapping = paramString.toCharArray();
/* 193 */     this.specialCaseHW = paramBoolean;
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
/*     */   public int difference(String paramString1, String paramString2) throws EncoderException {
/* 216 */     return SoundexUtils.difference(this, paramString1, paramString2);
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
/*     */   public Object encode(Object paramObject) throws EncoderException {
/* 234 */     if (!(paramObject instanceof String)) {
/* 235 */       throw new EncoderException("Parameter supplied to Soundex encode is not of type java.lang.String");
/*     */     }
/* 237 */     return soundex((String)paramObject);
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
/*     */   public String encode(String paramString) {
/* 251 */     return soundex(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public int getMaxLength() {
/* 262 */     return this.maxLength;
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
/*     */   private char map(char paramChar) {
/* 275 */     int i = paramChar - 65;
/* 276 */     if (i < 0 || i >= this.soundexMapping.length) {
/* 277 */       throw new IllegalArgumentException("The character is not mapped: " + paramChar + " (index=" + i + ")");
/*     */     }
/* 279 */     return this.soundexMapping[i];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void setMaxLength(int paramInt) {
/* 291 */     this.maxLength = paramInt;
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
/*     */   public String soundex(String paramString) {
/* 304 */     if (paramString == null) {
/* 305 */       return null;
/*     */     }
/* 307 */     paramString = SoundexUtils.clean(paramString);
/* 308 */     if (paramString.length() == 0) {
/* 309 */       return paramString;
/*     */     }
/* 311 */     char[] arrayOfChar = { '0', '0', '0', '0' };
/* 312 */     byte b1 = 0;
/* 313 */     char c1 = paramString.charAt(0);
/* 314 */     arrayOfChar[b1++] = c1;
/* 315 */     char c2 = map(c1);
/* 316 */     for (byte b2 = 1; b2 < paramString.length() && b1 < arrayOfChar.length; b2++) {
/* 317 */       char c = paramString.charAt(b2);
/* 318 */       if (!this.specialCaseHW || (c != 'H' && c != 'W')) {
/*     */ 
/*     */         
/* 321 */         char c3 = map(c);
/* 322 */         if (c3 != '-')
/*     */         
/*     */         { 
/* 325 */           if (c3 != '0' && c3 != c2) {
/* 326 */             arrayOfChar[b1++] = c3;
/*     */           }
/* 328 */           c2 = c3; } 
/*     */       } 
/* 330 */     }  return new String(arrayOfChar);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\language\Soundex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */