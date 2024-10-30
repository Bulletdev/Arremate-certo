/*     */ package org.apache.commons.codec.language;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Scanner;
/*     */ import org.apache.commons.codec.EncoderException;
/*     */ import org.apache.commons.codec.Resources;
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
/*     */ public class DaitchMokotoffSoundex
/*     */   implements StringEncoder
/*     */ {
/*     */   private static final String COMMENT = "//";
/*     */   private static final String DOUBLE_QUOTE = "\"";
/*     */   private static final String MULTILINE_COMMENT_END = "*/";
/*     */   private static final String MULTILINE_COMMENT_START = "/*";
/*     */   private static final String RESOURCE_FILE = "org/apache/commons/codec/language/dmrules.txt";
/*     */   private static final int MAX_LENGTH = 6;
/*     */   
/*     */   private static final class Branch
/*     */   {
/*  82 */     private final StringBuilder builder = new StringBuilder();
/*  83 */     private String lastReplacement = null;
/*  84 */     private String cachedString = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Branch createBranch() {
/*  93 */       Branch branch = new Branch();
/*  94 */       branch.builder.append(toString());
/*  95 */       branch.lastReplacement = this.lastReplacement;
/*  96 */       return branch;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 101 */       if (this == param1Object) {
/* 102 */         return true;
/*     */       }
/* 104 */       if (!(param1Object instanceof Branch)) {
/* 105 */         return false;
/*     */       }
/*     */       
/* 108 */       return toString().equals(((Branch)param1Object).toString());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void finish() {
/* 115 */       while (this.builder.length() < 6) {
/* 116 */         this.builder.append('0');
/* 117 */         this.cachedString = null;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 123 */       return toString().hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void processNextReplacement(String param1String, boolean param1Boolean) {
/* 135 */       boolean bool = (this.lastReplacement == null || !this.lastReplacement.endsWith(param1String) || param1Boolean) ? true : false;
/*     */       
/* 137 */       if (bool && this.builder.length() < 6) {
/* 138 */         this.builder.append(param1String);
/*     */         
/* 140 */         if (this.builder.length() > 6) {
/* 141 */           this.builder.delete(6, this.builder.length());
/*     */         }
/* 143 */         this.cachedString = null;
/*     */       } 
/*     */       
/* 146 */       this.lastReplacement = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 151 */       if (this.cachedString == null) {
/* 152 */         this.cachedString = this.builder.toString();
/*     */       }
/* 154 */       return this.cachedString;
/*     */     }
/*     */ 
/*     */     
/*     */     private Branch() {}
/*     */   }
/*     */   
/*     */   private static final class Rule
/*     */   {
/*     */     private final String pattern;
/*     */     private final String[] replacementAtStart;
/*     */     private final String[] replacementBeforeVowel;
/*     */     private final String[] replacementDefault;
/*     */     
/*     */     protected Rule(String param1String1, String param1String2, String param1String3, String param1String4) {
/* 169 */       this.pattern = param1String1;
/* 170 */       this.replacementAtStart = param1String2.split("\\|");
/* 171 */       this.replacementBeforeVowel = param1String3.split("\\|");
/* 172 */       this.replacementDefault = param1String4.split("\\|");
/*     */     }
/*     */     
/*     */     public int getPatternLength() {
/* 176 */       return this.pattern.length();
/*     */     }
/*     */     
/*     */     public String[] getReplacements(String param1String, boolean param1Boolean) {
/* 180 */       if (param1Boolean) {
/* 181 */         return this.replacementAtStart;
/*     */       }
/*     */       
/* 184 */       int i = getPatternLength();
/* 185 */       boolean bool = (i < param1String.length()) ? isVowel(param1String.charAt(i)) : false;
/* 186 */       if (bool) {
/* 187 */         return this.replacementBeforeVowel;
/*     */       }
/*     */       
/* 190 */       return this.replacementDefault;
/*     */     }
/*     */     
/*     */     private boolean isVowel(char param1Char) {
/* 194 */       return (param1Char == 'a' || param1Char == 'e' || param1Char == 'i' || param1Char == 'o' || param1Char == 'u');
/*     */     }
/*     */     
/*     */     public boolean matches(String param1String) {
/* 198 */       return param1String.startsWith(this.pattern);
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 203 */       return String.format("%s=(%s,%s,%s)", new Object[] { this.pattern, Arrays.asList(this.replacementAtStart), 
/* 204 */             Arrays.asList(this.replacementBeforeVowel), Arrays.asList(this.replacementDefault) });
/*     */     }
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
/* 222 */   private static final Map<Character, List<Rule>> RULES = new HashMap<>();
/*     */ 
/*     */   
/* 225 */   private static final Map<Character, Character> FOLDINGS = new HashMap<>(); private final boolean folding;
/*     */   
/*     */   static {
/* 228 */     try (Scanner null = new Scanner(Resources.getInputStream("org/apache/commons/codec/language/dmrules.txt"), "UTF-8")) {
/* 229 */       parseRules(scanner, "org/apache/commons/codec/language/dmrules.txt", RULES, FOLDINGS);
/*     */     } 
/*     */ 
/*     */     
/* 233 */     for (Map.Entry<Character, List<Rule>> entry : RULES.entrySet()) {
/* 234 */       List<?> list = (List)entry.getValue();
/* 235 */       Collections.sort(list, new Comparator<Rule>()
/*     */           {
/*     */             public int compare(DaitchMokotoffSoundex.Rule param1Rule1, DaitchMokotoffSoundex.Rule param1Rule2) {
/* 238 */               return param1Rule2.getPatternLength() - param1Rule1.getPatternLength();
/*     */             }
/*     */           });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void parseRules(Scanner paramScanner, String paramString, Map<Character, List<Rule>> paramMap, Map<Character, Character> paramMap1) {
/* 246 */     byte b = 0;
/* 247 */     boolean bool = false;
/*     */     
/* 249 */     while (paramScanner.hasNextLine()) {
/* 250 */       b++;
/* 251 */       String str1 = paramScanner.nextLine();
/* 252 */       String str2 = str1;
/*     */       
/* 254 */       if (bool) {
/* 255 */         if (str2.endsWith("*/")) {
/* 256 */           bool = false;
/*     */         }
/*     */         
/*     */         continue;
/*     */       } 
/* 261 */       if (str2.startsWith("/*")) {
/* 262 */         bool = true;
/*     */         continue;
/*     */       } 
/* 265 */       int i = str2.indexOf("//");
/* 266 */       if (i >= 0) {
/* 267 */         str2 = str2.substring(0, i);
/*     */       }
/*     */ 
/*     */       
/* 271 */       str2 = str2.trim();
/*     */       
/* 273 */       if (str2.length() == 0) {
/*     */         continue;
/*     */       }
/*     */       
/* 277 */       if (str2.contains("=")) {
/*     */         
/* 279 */         String[] arrayOfString1 = str2.split("=");
/* 280 */         if (arrayOfString1.length != 2) {
/* 281 */           throw new IllegalArgumentException("Malformed folding statement split into " + arrayOfString1.length + " parts: " + str1 + " in " + paramString);
/*     */         }
/*     */         
/* 284 */         String str3 = arrayOfString1[0];
/* 285 */         String str4 = arrayOfString1[1];
/*     */         
/* 287 */         if (str3.length() != 1 || str4.length() != 1) {
/* 288 */           throw new IllegalArgumentException("Malformed folding statement - patterns are not single characters: " + str1 + " in " + paramString);
/*     */         }
/*     */ 
/*     */         
/* 292 */         paramMap1.put(Character.valueOf(str3.charAt(0)), Character.valueOf(str4.charAt(0)));
/*     */         continue;
/*     */       } 
/* 295 */       String[] arrayOfString = str2.split("\\s+");
/* 296 */       if (arrayOfString.length != 4) {
/* 297 */         throw new IllegalArgumentException("Malformed rule statement split into " + arrayOfString.length + " parts: " + str1 + " in " + paramString);
/*     */       }
/*     */       
/*     */       try {
/* 301 */         String str3 = stripQuotes(arrayOfString[0]);
/* 302 */         String str4 = stripQuotes(arrayOfString[1]);
/* 303 */         String str5 = stripQuotes(arrayOfString[2]);
/* 304 */         String str6 = stripQuotes(arrayOfString[3]);
/*     */         
/* 306 */         Rule rule = new Rule(str3, str4, str5, str6);
/* 307 */         char c = rule.pattern.charAt(0);
/* 308 */         List<Rule> list = paramMap.get(Character.valueOf(c));
/* 309 */         if (list == null) {
/* 310 */           list = new ArrayList();
/* 311 */           paramMap.put(Character.valueOf(c), list);
/*     */         } 
/* 313 */         list.add(rule);
/* 314 */       } catch (IllegalArgumentException illegalArgumentException) {
/* 315 */         throw new IllegalStateException("Problem parsing line '" + b + "' in " + paramString, illegalArgumentException);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String stripQuotes(String paramString) {
/* 324 */     if (paramString.startsWith("\"")) {
/* 325 */       paramString = paramString.substring(1);
/*     */     }
/*     */     
/* 328 */     if (paramString.endsWith("\"")) {
/* 329 */       paramString = paramString.substring(0, paramString.length() - 1);
/*     */     }
/*     */     
/* 332 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DaitchMokotoffSoundex() {
/* 342 */     this(true);
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
/*     */   public DaitchMokotoffSoundex(boolean paramBoolean) {
/* 356 */     this.folding = paramBoolean;
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
/*     */   private String cleanup(String paramString) {
/* 370 */     StringBuilder stringBuilder = new StringBuilder();
/* 371 */     for (char c : paramString.toCharArray()) {
/* 372 */       if (!Character.isWhitespace(c)) {
/*     */ 
/*     */ 
/*     */         
/* 376 */         c = Character.toLowerCase(c);
/* 377 */         if (this.folding && FOLDINGS.containsKey(Character.valueOf(c))) {
/* 378 */           c = ((Character)FOLDINGS.get(Character.valueOf(c))).charValue();
/*     */         }
/* 380 */         stringBuilder.append(c);
/*     */       } 
/* 382 */     }  return stringBuilder.toString();
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
/*     */   public Object encode(Object paramObject) throws EncoderException {
/* 405 */     if (!(paramObject instanceof String)) {
/* 406 */       throw new EncoderException("Parameter supplied to DaitchMokotoffSoundex encode is not of type java.lang.String");
/*     */     }
/*     */     
/* 409 */     return encode((String)paramObject);
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
/*     */   public String encode(String paramString) {
/* 425 */     if (paramString == null) {
/* 426 */       return null;
/*     */     }
/* 428 */     return soundex(paramString, false)[0];
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
/*     */   
/*     */   public String soundex(String paramString) {
/* 455 */     String[] arrayOfString = soundex(paramString, true);
/* 456 */     StringBuilder stringBuilder = new StringBuilder();
/* 457 */     byte b = 0;
/* 458 */     for (String str : arrayOfString) {
/* 459 */       stringBuilder.append(str);
/* 460 */       if (++b < arrayOfString.length) {
/* 461 */         stringBuilder.append('|');
/*     */       }
/*     */     } 
/* 464 */     return stringBuilder.toString();
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
/*     */   private String[] soundex(String paramString, boolean paramBoolean) {
/* 478 */     if (paramString == null) {
/* 479 */       return null;
/*     */     }
/*     */     
/* 482 */     String str = cleanup(paramString);
/*     */     
/* 484 */     LinkedHashSet<Branch> linkedHashSet = new LinkedHashSet();
/* 485 */     linkedHashSet.add(new Branch());
/*     */     
/* 487 */     char c = Character.MIN_VALUE;
/* 488 */     for (int i = 0; i < str.length(); i++) {
/* 489 */       char c1 = str.charAt(i);
/*     */ 
/*     */       
/* 492 */       if (!Character.isWhitespace(c1)) {
/*     */ 
/*     */ 
/*     */         
/* 496 */         String str1 = str.substring(i);
/* 497 */         List list = RULES.get(Character.valueOf(c1));
/* 498 */         if (list != null) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 503 */           List<Branch> list1 = paramBoolean ? new ArrayList() : Collections.emptyList();
/*     */           
/* 505 */           for (Rule rule : list) {
/* 506 */             if (rule.matches(str1)) {
/* 507 */               if (paramBoolean) {
/* 508 */                 list1.clear();
/*     */               }
/* 510 */               String[] arrayOfString1 = rule.getReplacements(str1, !c);
/* 511 */               boolean bool = (arrayOfString1.length > 1 && paramBoolean) ? true : false;
/*     */               
/* 513 */               for (Branch branch : linkedHashSet) {
/* 514 */                 String[] arrayOfString2; int j; byte b1; for (arrayOfString2 = arrayOfString1, j = arrayOfString2.length, b1 = 0; b1 < j; ) { String str2 = arrayOfString2[b1];
/*     */                   
/* 516 */                   Branch branch1 = bool ? branch.createBranch() : branch;
/*     */ 
/*     */                   
/* 519 */                   boolean bool1 = ((c == 'm' && c1 == 'n') || (c == 'n' && c1 == 'm')) ? true : false;
/*     */                   
/* 521 */                   branch1.processNextReplacement(str2, bool1);
/*     */                   
/* 523 */                   if (paramBoolean) {
/* 524 */                     list1.add(branch1);
/*     */                     
/*     */                     b1++;
/*     */                   }  }
/*     */               
/*     */               } 
/*     */               
/* 531 */               if (paramBoolean) {
/* 532 */                 linkedHashSet.clear();
/* 533 */                 linkedHashSet.addAll(list1);
/*     */               } 
/* 535 */               i += rule.getPatternLength() - 1;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/* 540 */           c = c1;
/*     */         } 
/*     */       } 
/* 543 */     }  String[] arrayOfString = new String[linkedHashSet.size()];
/* 544 */     byte b = 0;
/* 545 */     for (Branch branch : linkedHashSet) {
/* 546 */       branch.finish();
/* 547 */       arrayOfString[b++] = branch.toString();
/*     */     } 
/*     */     
/* 550 */     return arrayOfString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\language\DaitchMokotoffSoundex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */