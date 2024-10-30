/*     */ package org.apache.commons.codec.language;
/*     */ 
/*     */ import java.util.regex.Pattern;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Nysiis
/*     */   implements StringEncoder
/*     */ {
/*  71 */   private static final char[] CHARS_A = new char[] { 'A' };
/*  72 */   private static final char[] CHARS_AF = new char[] { 'A', 'F' };
/*  73 */   private static final char[] CHARS_C = new char[] { 'C' };
/*  74 */   private static final char[] CHARS_FF = new char[] { 'F', 'F' };
/*  75 */   private static final char[] CHARS_G = new char[] { 'G' };
/*  76 */   private static final char[] CHARS_N = new char[] { 'N' };
/*  77 */   private static final char[] CHARS_NN = new char[] { 'N', 'N' };
/*  78 */   private static final char[] CHARS_S = new char[] { 'S' };
/*  79 */   private static final char[] CHARS_SSS = new char[] { 'S', 'S', 'S' };
/*     */   
/*  81 */   private static final Pattern PAT_MAC = Pattern.compile("^MAC");
/*  82 */   private static final Pattern PAT_KN = Pattern.compile("^KN");
/*  83 */   private static final Pattern PAT_K = Pattern.compile("^K");
/*  84 */   private static final Pattern PAT_PH_PF = Pattern.compile("^(PH|PF)");
/*  85 */   private static final Pattern PAT_SCH = Pattern.compile("^SCH");
/*  86 */   private static final Pattern PAT_EE_IE = Pattern.compile("(EE|IE)$");
/*  87 */   private static final Pattern PAT_DT_ETC = Pattern.compile("(DT|RT|RD|NT|ND)$");
/*     */ 
/*     */   
/*     */   private static final char SPACE = ' ';
/*     */ 
/*     */   
/*     */   private static final int TRUE_LENGTH = 6;
/*     */ 
/*     */   
/*     */   private final boolean strict;
/*     */ 
/*     */   
/*     */   private static boolean isVowel(char paramChar) {
/* 100 */     return (paramChar == 'A' || paramChar == 'E' || paramChar == 'I' || paramChar == 'O' || paramChar == 'U');
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
/*     */   private static char[] transcodeRemaining(char paramChar1, char paramChar2, char paramChar3, char paramChar4) {
/* 119 */     if (paramChar2 == 'E' && paramChar3 == 'V') {
/* 120 */       return CHARS_AF;
/*     */     }
/*     */ 
/*     */     
/* 124 */     if (isVowel(paramChar2)) {
/* 125 */       return CHARS_A;
/*     */     }
/*     */ 
/*     */     
/* 129 */     if (paramChar2 == 'Q')
/* 130 */       return CHARS_G; 
/* 131 */     if (paramChar2 == 'Z')
/* 132 */       return CHARS_S; 
/* 133 */     if (paramChar2 == 'M') {
/* 134 */       return CHARS_N;
/*     */     }
/*     */ 
/*     */     
/* 138 */     if (paramChar2 == 'K') {
/* 139 */       if (paramChar3 == 'N') {
/* 140 */         return CHARS_NN;
/*     */       }
/* 142 */       return CHARS_C;
/*     */     } 
/*     */ 
/*     */     
/* 146 */     if (paramChar2 == 'S' && paramChar3 == 'C' && paramChar4 == 'H') {
/* 147 */       return CHARS_SSS;
/*     */     }
/*     */ 
/*     */     
/* 151 */     if (paramChar2 == 'P' && paramChar3 == 'H') {
/* 152 */       return CHARS_FF;
/*     */     }
/*     */ 
/*     */     
/* 156 */     if (paramChar2 == 'H' && (!isVowel(paramChar1) || !isVowel(paramChar3))) {
/* 157 */       return new char[] { paramChar1 };
/*     */     }
/*     */ 
/*     */     
/* 161 */     if (paramChar2 == 'W' && isVowel(paramChar1)) {
/* 162 */       return new char[] { paramChar1 };
/*     */     }
/*     */     
/* 165 */     return new char[] { paramChar2 };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Nysiis() {
/* 176 */     this(true);
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
/*     */   public Nysiis(boolean paramBoolean) {
/* 191 */     this.strict = paramBoolean;
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
/* 209 */     if (!(paramObject instanceof String)) {
/* 210 */       throw new EncoderException("Parameter supplied to Nysiis encode is not of type java.lang.String");
/*     */     }
/* 212 */     return nysiis((String)paramObject);
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
/* 226 */     return nysiis(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isStrict() {
/* 235 */     return this.strict;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String nysiis(String paramString) {
/* 246 */     if (paramString == null) {
/* 247 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 251 */     paramString = SoundexUtils.clean(paramString);
/*     */     
/* 253 */     if (paramString.length() == 0) {
/* 254 */       return paramString;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 259 */     paramString = PAT_MAC.matcher(paramString).replaceFirst("MCC");
/* 260 */     paramString = PAT_KN.matcher(paramString).replaceFirst("NN");
/* 261 */     paramString = PAT_K.matcher(paramString).replaceFirst("C");
/* 262 */     paramString = PAT_PH_PF.matcher(paramString).replaceFirst("FF");
/* 263 */     paramString = PAT_SCH.matcher(paramString).replaceFirst("SSS");
/*     */ 
/*     */ 
/*     */     
/* 267 */     paramString = PAT_EE_IE.matcher(paramString).replaceFirst("Y");
/* 268 */     paramString = PAT_DT_ETC.matcher(paramString).replaceFirst("D");
/*     */ 
/*     */     
/* 271 */     StringBuilder stringBuilder = new StringBuilder(paramString.length());
/* 272 */     stringBuilder.append(paramString.charAt(0));
/*     */ 
/*     */     
/* 275 */     char[] arrayOfChar = paramString.toCharArray();
/* 276 */     int i = arrayOfChar.length;
/*     */     char c;
/* 278 */     for (c = '\001'; c < i; c++) {
/* 279 */       boolean bool1 = (c < i - 1) ? arrayOfChar[c + 1] : true;
/* 280 */       boolean bool2 = (c < i - 2) ? arrayOfChar[c + 2] : true;
/* 281 */       char[] arrayOfChar1 = transcodeRemaining(arrayOfChar[c - 1], arrayOfChar[c], bool1, bool2);
/* 282 */       System.arraycopy(arrayOfChar1, 0, arrayOfChar, c, arrayOfChar1.length);
/*     */ 
/*     */       
/* 285 */       if (arrayOfChar[c] != arrayOfChar[c - 1]) {
/* 286 */         stringBuilder.append(arrayOfChar[c]);
/*     */       }
/*     */     } 
/*     */     
/* 290 */     if (stringBuilder.length() > 1) {
/* 291 */       c = stringBuilder.charAt(stringBuilder.length() - 1);
/*     */ 
/*     */       
/* 294 */       if (c == 'S') {
/* 295 */         stringBuilder.deleteCharAt(stringBuilder.length() - 1);
/* 296 */         c = stringBuilder.charAt(stringBuilder.length() - 1);
/*     */       } 
/*     */       
/* 299 */       if (stringBuilder.length() > 2) {
/* 300 */         char c1 = stringBuilder.charAt(stringBuilder.length() - 2);
/*     */         
/* 302 */         if (c1 == 'A' && c == 'Y') {
/* 303 */           stringBuilder.deleteCharAt(stringBuilder.length() - 2);
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 308 */       if (c == 'A') {
/* 309 */         stringBuilder.deleteCharAt(stringBuilder.length() - 1);
/*     */       }
/*     */     } 
/*     */     
/* 313 */     String str = stringBuilder.toString();
/* 314 */     return isStrict() ? str.substring(0, Math.min(6, str.length())) : str;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\language\Nysiis.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */