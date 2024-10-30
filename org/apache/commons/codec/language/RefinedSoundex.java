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
/*     */ public class RefinedSoundex
/*     */   implements StringEncoder
/*     */ {
/*     */   public static final String US_ENGLISH_MAPPING_STRING = "01360240043788015936020505";
/*  57 */   private static final char[] US_ENGLISH_MAPPING = "01360240043788015936020505".toCharArray();
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
/*  70 */   public static final RefinedSoundex US_ENGLISH = new RefinedSoundex();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RefinedSoundex() {
/*  77 */     this.soundexMapping = US_ENGLISH_MAPPING;
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
/*     */   public RefinedSoundex(char[] paramArrayOfchar) {
/*  90 */     this.soundexMapping = new char[paramArrayOfchar.length];
/*  91 */     System.arraycopy(paramArrayOfchar, 0, this.soundexMapping, 0, paramArrayOfchar.length);
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
/*     */   public RefinedSoundex(String paramString) {
/* 103 */     this.soundexMapping = paramString.toCharArray();
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
/*     */ 
/*     */ 
/*     */   
/*     */   public int difference(String paramString1, String paramString2) throws EncoderException {
/* 129 */     return SoundexUtils.difference(this, paramString1, paramString2);
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
/* 147 */     if (!(paramObject instanceof String)) {
/* 148 */       throw new EncoderException("Parameter supplied to RefinedSoundex encode is not of type java.lang.String");
/*     */     }
/* 150 */     return soundex((String)paramObject);
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
/*     */   public String encode(String paramString) {
/* 162 */     return soundex(paramString);
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
/*     */   char getMappingCode(char paramChar) {
/* 175 */     if (!Character.isLetter(paramChar)) {
/* 176 */       return Character.MIN_VALUE;
/*     */     }
/* 178 */     return this.soundexMapping[Character.toUpperCase(paramChar) - 65];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String soundex(String paramString) {
/* 189 */     if (paramString == null) {
/* 190 */       return null;
/*     */     }
/* 192 */     paramString = SoundexUtils.clean(paramString);
/* 193 */     if (paramString.length() == 0) {
/* 194 */       return paramString;
/*     */     }
/*     */     
/* 197 */     StringBuilder stringBuilder = new StringBuilder();
/* 198 */     stringBuilder.append(paramString.charAt(0));
/*     */ 
/*     */     
/* 201 */     char c = '*';
/*     */     
/* 203 */     for (byte b = 0; b < paramString.length(); b++) {
/*     */       
/* 205 */       char c1 = getMappingCode(paramString.charAt(b));
/* 206 */       if (c1 != c) {
/*     */         
/* 208 */         if (c1 != '\000') {
/* 209 */           stringBuilder.append(c1);
/*     */         }
/*     */         
/* 212 */         c = c1;
/*     */       } 
/*     */     } 
/*     */     
/* 216 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\language\RefinedSoundex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */