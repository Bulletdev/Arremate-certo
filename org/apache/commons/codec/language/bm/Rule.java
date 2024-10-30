/*     */ package org.apache.commons.codec.language.bm;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.EnumMap;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Scanner;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.commons.codec.Resources;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Rule
/*     */ {
/*     */   public static final class Phoneme
/*     */     implements PhonemeExpr
/*     */   {
/*  84 */     public static final Comparator<Phoneme> COMPARATOR = new Comparator<Phoneme>()
/*     */       {
/*     */         public int compare(Rule.Phoneme param2Phoneme1, Rule.Phoneme param2Phoneme2) {
/*  87 */           for (byte b = 0; b < param2Phoneme1.phonemeText.length(); b++) {
/*  88 */             if (b >= param2Phoneme2.phonemeText.length()) {
/*  89 */               return 1;
/*     */             }
/*  91 */             int i = param2Phoneme1.phonemeText.charAt(b) - param2Phoneme2.phonemeText.charAt(b);
/*  92 */             if (i != 0) {
/*  93 */               return i;
/*     */             }
/*     */           } 
/*     */           
/*  97 */           if (param2Phoneme1.phonemeText.length() < param2Phoneme2.phonemeText.length()) {
/*  98 */             return -1;
/*     */           }
/*     */           
/* 101 */           return 0;
/*     */         }
/*     */       };
/*     */     
/*     */     private final StringBuilder phonemeText;
/*     */     private final Languages.LanguageSet languages;
/*     */     
/*     */     public Phoneme(CharSequence param1CharSequence, Languages.LanguageSet param1LanguageSet) {
/* 109 */       this.phonemeText = new StringBuilder(param1CharSequence);
/* 110 */       this.languages = param1LanguageSet;
/*     */     }
/*     */     
/*     */     public Phoneme(Phoneme param1Phoneme1, Phoneme param1Phoneme2) {
/* 114 */       this(param1Phoneme1.phonemeText, param1Phoneme1.languages);
/* 115 */       this.phonemeText.append(param1Phoneme2.phonemeText);
/*     */     }
/*     */     
/*     */     public Phoneme(Phoneme param1Phoneme1, Phoneme param1Phoneme2, Languages.LanguageSet param1LanguageSet) {
/* 119 */       this(param1Phoneme1.phonemeText, param1LanguageSet);
/* 120 */       this.phonemeText.append(param1Phoneme2.phonemeText);
/*     */     }
/*     */     
/*     */     public Phoneme append(CharSequence param1CharSequence) {
/* 124 */       this.phonemeText.append(param1CharSequence);
/* 125 */       return this;
/*     */     }
/*     */     
/*     */     public Languages.LanguageSet getLanguages() {
/* 129 */       return this.languages;
/*     */     }
/*     */ 
/*     */     
/*     */     public Iterable<Phoneme> getPhonemes() {
/* 134 */       return Collections.singleton(this);
/*     */     }
/*     */     
/*     */     public CharSequence getPhonemeText() {
/* 138 */       return this.phonemeText;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @Deprecated
/*     */     public Phoneme join(Phoneme param1Phoneme) {
/* 150 */       return new Phoneme(this.phonemeText.toString() + param1Phoneme.phonemeText.toString(), this.languages
/* 151 */           .restrictTo(param1Phoneme.languages));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Phoneme mergeWithLanguage(Languages.LanguageSet param1LanguageSet) {
/* 162 */       return new Phoneme(this.phonemeText.toString(), this.languages.merge(param1LanguageSet));
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 167 */       return this.phonemeText.toString() + "[" + this.languages + "]";
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class PhonemeList
/*     */     implements PhonemeExpr
/*     */   {
/*     */     private final List<Rule.Phoneme> phonemes;
/*     */ 
/*     */     
/*     */     public PhonemeList(List<Rule.Phoneme> param1List) {
/* 179 */       this.phonemes = param1List;
/*     */     }
/*     */ 
/*     */     
/*     */     public List<Rule.Phoneme> getPhonemes() {
/* 184 */       return this.phonemes;
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
/* 195 */   public static final RPattern ALL_STRINGS_RMATCHER = new RPattern()
/*     */     {
/*     */       public boolean isMatch(CharSequence param1CharSequence) {
/* 198 */         return true;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public static final String ALL = "ALL";
/*     */   
/*     */   private static final String DOUBLE_QUOTE = "\"";
/*     */   
/*     */   private static final String HASH_INCLUDE = "#include";
/* 208 */   private static final Map<NameType, Map<RuleType, Map<String, Map<String, List<Rule>>>>> RULES = new EnumMap<>(NameType.class); private final RPattern lContext;
/*     */   private final String pattern;
/*     */   
/*     */   static {
/* 212 */     for (NameType nameType : NameType.values()) {
/* 213 */       EnumMap<RuleType, Object> enumMap = new EnumMap<>(RuleType.class);
/*     */ 
/*     */       
/* 216 */       for (RuleType ruleType : RuleType.values()) {
/* 217 */         HashMap<Object, Object> hashMap = new HashMap<>();
/*     */         
/* 219 */         Languages languages = Languages.getInstance(nameType);
/* 220 */         for (String str : languages.getLanguages()) {
/* 221 */           try (Scanner null = createScanner(nameType, ruleType, str)) {
/* 222 */             hashMap.put(str, parseRules(scanner, createResourceName(nameType, ruleType, str)));
/* 223 */           } catch (IllegalStateException illegalStateException) {
/* 224 */             throw new IllegalStateException("Problem processing " + createResourceName(nameType, ruleType, str), illegalStateException);
/*     */           } 
/*     */         } 
/* 227 */         if (!ruleType.equals(RuleType.RULES)) {
/* 228 */           try (Scanner null = createScanner(nameType, ruleType, "common")) {
/* 229 */             hashMap.put("common", parseRules(scanner, createResourceName(nameType, ruleType, "common")));
/*     */           } 
/*     */         }
/*     */         
/* 233 */         enumMap.put(ruleType, Collections.unmodifiableMap(hashMap));
/*     */       } 
/*     */       
/* 236 */       RULES.put(nameType, (Map)Collections.unmodifiableMap(enumMap));
/*     */     } 
/*     */   }
/*     */   private final PhonemeExpr phoneme; private final RPattern rContext;
/*     */   private static boolean contains(CharSequence paramCharSequence, char paramChar) {
/* 241 */     for (byte b = 0; b < paramCharSequence.length(); b++) {
/* 242 */       if (paramCharSequence.charAt(b) == paramChar) {
/* 243 */         return true;
/*     */       }
/*     */     } 
/* 246 */     return false;
/*     */   }
/*     */   
/*     */   private static String createResourceName(NameType paramNameType, RuleType paramRuleType, String paramString) {
/* 250 */     return String.format("org/apache/commons/codec/language/bm/%s_%s_%s.txt", new Object[] { paramNameType
/* 251 */           .getName(), paramRuleType.getName(), paramString });
/*     */   }
/*     */   
/*     */   private static Scanner createScanner(NameType paramNameType, RuleType paramRuleType, String paramString) {
/* 255 */     String str = createResourceName(paramNameType, paramRuleType, paramString);
/* 256 */     return new Scanner(Resources.getInputStream(str), "UTF-8");
/*     */   }
/*     */   
/*     */   private static Scanner createScanner(String paramString) {
/* 260 */     String str = String.format("org/apache/commons/codec/language/bm/%s.txt", new Object[] { paramString });
/* 261 */     return new Scanner(Resources.getInputStream(str), "UTF-8");
/*     */   }
/*     */   
/*     */   private static boolean endsWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 265 */     if (paramCharSequence2.length() > paramCharSequence1.length()) {
/* 266 */       return false;
/*     */     }
/* 268 */     for (int i = paramCharSequence1.length() - 1, j = paramCharSequence2.length() - 1; j >= 0; i--, j--) {
/* 269 */       if (paramCharSequence1.charAt(i) != paramCharSequence2.charAt(j)) {
/* 270 */         return false;
/*     */       }
/*     */     } 
/* 273 */     return true;
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
/*     */   public static List<Rule> getInstance(NameType paramNameType, RuleType paramRuleType, Languages.LanguageSet paramLanguageSet) {
/* 289 */     Map<String, List<Rule>> map = getInstanceMap(paramNameType, paramRuleType, paramLanguageSet);
/* 290 */     ArrayList<Rule> arrayList = new ArrayList();
/* 291 */     for (List<Rule> list : map.values()) {
/* 292 */       arrayList.addAll(list);
/*     */     }
/* 294 */     return arrayList;
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
/*     */   public static List<Rule> getInstance(NameType paramNameType, RuleType paramRuleType, String paramString) {
/* 309 */     return getInstance(paramNameType, paramRuleType, Languages.LanguageSet.from(new HashSet<>(Arrays.asList(new String[] { paramString }))));
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
/*     */   public static Map<String, List<Rule>> getInstanceMap(NameType paramNameType, RuleType paramRuleType, Languages.LanguageSet paramLanguageSet) {
/* 326 */     return paramLanguageSet.isSingleton() ? getInstanceMap(paramNameType, paramRuleType, paramLanguageSet.getAny()) : 
/* 327 */       getInstanceMap(paramNameType, paramRuleType, "any");
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
/*     */   public static Map<String, List<Rule>> getInstanceMap(NameType paramNameType, RuleType paramRuleType, String paramString) {
/* 344 */     Map<String, List<Rule>> map = (Map)((Map)((Map)RULES.get(paramNameType)).get(paramRuleType)).get(paramString);
/*     */     
/* 346 */     if (map == null) {
/* 347 */       throw new IllegalArgumentException(String.format("No rules found for %s, %s, %s.", new Object[] { paramNameType
/* 348 */               .getName(), paramRuleType.getName(), paramString }));
/*     */     }
/*     */     
/* 351 */     return map;
/*     */   }
/*     */   
/*     */   private static Phoneme parsePhoneme(String paramString) {
/* 355 */     int i = paramString.indexOf("[");
/* 356 */     if (i >= 0) {
/* 357 */       if (!paramString.endsWith("]")) {
/* 358 */         throw new IllegalArgumentException("Phoneme expression contains a '[' but does not end in ']'");
/*     */       }
/* 360 */       String str1 = paramString.substring(0, i);
/* 361 */       String str2 = paramString.substring(i + 1, paramString.length() - 1);
/* 362 */       HashSet<String> hashSet = new HashSet(Arrays.asList((Object[])str2.split("[+]")));
/*     */       
/* 364 */       return new Phoneme(str1, Languages.LanguageSet.from(hashSet));
/*     */     } 
/* 366 */     return new Phoneme(paramString, Languages.ANY_LANGUAGE);
/*     */   }
/*     */   
/*     */   private static PhonemeExpr parsePhonemeExpr(String paramString) {
/* 370 */     if (paramString.startsWith("(")) {
/* 371 */       if (!paramString.endsWith(")")) {
/* 372 */         throw new IllegalArgumentException("Phoneme starts with '(' so must end with ')'");
/*     */       }
/*     */       
/* 375 */       ArrayList<Phoneme> arrayList = new ArrayList();
/* 376 */       String str = paramString.substring(1, paramString.length() - 1);
/* 377 */       for (String str1 : str.split("[|]")) {
/* 378 */         arrayList.add(parsePhoneme(str1));
/*     */       }
/* 380 */       if (str.startsWith("|") || str.endsWith("|")) {
/* 381 */         arrayList.add(new Phoneme("", Languages.ANY_LANGUAGE));
/*     */       }
/*     */       
/* 384 */       return new PhonemeList(arrayList);
/*     */     } 
/* 386 */     return parsePhoneme(paramString);
/*     */   }
/*     */   
/*     */   private static Map<String, List<Rule>> parseRules(Scanner paramScanner, final String location) {
/* 390 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 391 */     byte b = 0;
/*     */     
/* 393 */     boolean bool = false;
/* 394 */     while (paramScanner.hasNextLine()) {
/* 395 */       b++;
/* 396 */       String str1 = paramScanner.nextLine();
/* 397 */       String str2 = str1;
/*     */       
/* 399 */       if (bool) {
/* 400 */         if (str2.endsWith("*/"))
/* 401 */           bool = false; 
/*     */         continue;
/*     */       } 
/* 404 */       if (str2.startsWith("/*")) {
/* 405 */         bool = true;
/*     */         continue;
/*     */       } 
/* 408 */       int i = str2.indexOf("//");
/* 409 */       if (i >= 0) {
/* 410 */         str2 = str2.substring(0, i);
/*     */       }
/*     */ 
/*     */       
/* 414 */       str2 = str2.trim();
/*     */       
/* 416 */       if (str2.length() == 0) {
/*     */         continue;
/*     */       }
/*     */       
/* 420 */       if (str2.startsWith("#include")) {
/*     */         
/* 422 */         String str = str2.substring("#include".length()).trim();
/* 423 */         if (str.contains(" ")) {
/* 424 */           throw new IllegalArgumentException("Malformed import statement '" + str1 + "' in " + location);
/*     */         }
/*     */         
/* 427 */         try (Scanner null = createScanner(str)) {
/* 428 */           hashMap.putAll(parseRules(scanner, location + "->" + str));
/*     */         } 
/*     */         continue;
/*     */       } 
/* 432 */       String[] arrayOfString = str2.split("\\s+");
/* 433 */       if (arrayOfString.length != 4) {
/* 434 */         throw new IllegalArgumentException("Malformed rule statement split into " + arrayOfString.length + " parts: " + str1 + " in " + location);
/*     */       }
/*     */       
/*     */       try {
/* 438 */         final String pat = stripQuotes(arrayOfString[0]);
/* 439 */         final String lCon = stripQuotes(arrayOfString[1]);
/* 440 */         final String rCon = stripQuotes(arrayOfString[2]);
/* 441 */         PhonemeExpr phonemeExpr = parsePhonemeExpr(stripQuotes(arrayOfString[3]));
/* 442 */         final byte cLine = b;
/* 443 */         Rule rule = new Rule(str3, str4, str5, phonemeExpr) {
/* 444 */             private final int myLine = cLine;
/* 445 */             private final String loc = location;
/*     */ 
/*     */             
/*     */             public String toString() {
/* 449 */               StringBuilder stringBuilder = new StringBuilder();
/* 450 */               stringBuilder.append("Rule");
/* 451 */               stringBuilder.append("{line=").append(this.myLine);
/* 452 */               stringBuilder.append(", loc='").append(this.loc).append('\'');
/* 453 */               stringBuilder.append(", pat='").append(pat).append('\'');
/* 454 */               stringBuilder.append(", lcon='").append(lCon).append('\'');
/* 455 */               stringBuilder.append(", rcon='").append(rCon).append('\'');
/* 456 */               stringBuilder.append('}');
/* 457 */               return stringBuilder.toString();
/*     */             }
/*     */           };
/* 460 */         String str6 = rule.pattern.substring(0, 1);
/* 461 */         List<Rule> list = (List)hashMap.get(str6);
/* 462 */         if (list == null) {
/* 463 */           list = new ArrayList();
/* 464 */           hashMap.put(str6, list);
/*     */         } 
/* 466 */         list.add(rule);
/* 467 */       } catch (IllegalArgumentException illegalArgumentException) {
/* 468 */         throw new IllegalStateException("Problem parsing line '" + b + "' in " + location, illegalArgumentException);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 476 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static RPattern pattern(final String regex) {
/* 487 */     boolean bool1 = regex.startsWith("^");
/* 488 */     boolean bool2 = regex.endsWith("$");
/* 489 */     final String content = regex.substring(bool1 ? 1 : 0, bool2 ? (regex.length() - 1) : regex.length());
/* 490 */     boolean bool3 = str.contains("[");
/*     */     
/* 492 */     if (!bool3) {
/* 493 */       if (bool1 && bool2) {
/*     */         
/* 495 */         if (str.length() == 0)
/*     */         {
/* 497 */           return new RPattern()
/*     */             {
/*     */               public boolean isMatch(CharSequence param1CharSequence) {
/* 500 */                 return (param1CharSequence.length() == 0);
/*     */               }
/*     */             };
/*     */         }
/* 504 */         return new RPattern()
/*     */           {
/*     */             public boolean isMatch(CharSequence param1CharSequence) {
/* 507 */               return param1CharSequence.equals(content); }
/*     */           };
/*     */       } 
/* 510 */       if ((bool1 || bool2) && str.length() == 0)
/*     */       {
/* 512 */         return ALL_STRINGS_RMATCHER; } 
/* 513 */       if (bool1)
/*     */       {
/* 515 */         return new RPattern()
/*     */           {
/*     */             public boolean isMatch(CharSequence param1CharSequence) {
/* 518 */               return Rule.startsWith(param1CharSequence, content);
/*     */             }
/*     */           }; } 
/* 521 */       if (bool2)
/*     */       {
/* 523 */         return new RPattern()
/*     */           {
/*     */             public boolean isMatch(CharSequence param1CharSequence) {
/* 526 */               return Rule.endsWith(param1CharSequence, content);
/*     */             }
/*     */           };
/*     */       }
/*     */     } else {
/* 531 */       boolean bool4 = str.startsWith("[");
/* 532 */       boolean bool5 = str.endsWith("]");
/*     */       
/* 534 */       if (bool4 && bool5) {
/* 535 */         String str1 = str.substring(1, str.length() - 1);
/* 536 */         if (!str1.contains("[")) {
/*     */           
/* 538 */           boolean bool = str1.startsWith("^");
/* 539 */           if (bool) {
/* 540 */             str1 = str1.substring(1);
/*     */           }
/* 542 */           final String bContent = str1;
/* 543 */           final boolean shouldMatch = !bool ? true : false;
/*     */           
/* 545 */           if (bool1 && bool2)
/*     */           {
/* 547 */             return new RPattern()
/*     */               {
/*     */                 public boolean isMatch(CharSequence param1CharSequence) {
/* 550 */                   return (param1CharSequence.length() == 1 && Rule.contains(bContent, param1CharSequence.charAt(0)) == shouldMatch);
/*     */                 }
/*     */               }; } 
/* 553 */           if (bool1)
/*     */           {
/* 555 */             return new RPattern()
/*     */               {
/*     */                 public boolean isMatch(CharSequence param1CharSequence) {
/* 558 */                   return (param1CharSequence.length() > 0 && Rule.contains(bContent, param1CharSequence.charAt(0)) == shouldMatch);
/*     */                 }
/*     */               }; } 
/* 561 */           if (bool2)
/*     */           {
/* 563 */             return new RPattern()
/*     */               {
/*     */                 public boolean isMatch(CharSequence param1CharSequence) {
/* 566 */                   return (param1CharSequence.length() > 0 && Rule
/* 567 */                     .contains(bContent, param1CharSequence.charAt(param1CharSequence.length() - 1)) == shouldMatch);
/*     */                 }
/*     */               };
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 575 */     return new RPattern() {
/* 576 */         Pattern pattern = Pattern.compile(regex);
/*     */ 
/*     */         
/*     */         public boolean isMatch(CharSequence param1CharSequence) {
/* 580 */           Matcher matcher = this.pattern.matcher(param1CharSequence);
/* 581 */           return matcher.find();
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private static boolean startsWith(CharSequence paramCharSequence1, CharSequence paramCharSequence2) {
/* 587 */     if (paramCharSequence2.length() > paramCharSequence1.length()) {
/* 588 */       return false;
/*     */     }
/* 590 */     for (byte b = 0; b < paramCharSequence2.length(); b++) {
/* 591 */       if (paramCharSequence1.charAt(b) != paramCharSequence2.charAt(b)) {
/* 592 */         return false;
/*     */       }
/*     */     } 
/* 595 */     return true;
/*     */   }
/*     */   
/*     */   private static String stripQuotes(String paramString) {
/* 599 */     if (paramString.startsWith("\"")) {
/* 600 */       paramString = paramString.substring(1);
/*     */     }
/*     */     
/* 603 */     if (paramString.endsWith("\"")) {
/* 604 */       paramString = paramString.substring(0, paramString.length() - 1);
/*     */     }
/*     */     
/* 607 */     return paramString;
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
/*     */   public Rule(String paramString1, String paramString2, String paramString3, PhonemeExpr paramPhonemeExpr) {
/* 631 */     this.pattern = paramString1;
/* 632 */     this.lContext = pattern(paramString2 + "$");
/* 633 */     this.rContext = pattern("^" + paramString3);
/* 634 */     this.phoneme = paramPhonemeExpr;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RPattern getLContext() {
/* 643 */     return this.lContext;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPattern() {
/* 652 */     return this.pattern;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PhonemeExpr getPhoneme() {
/* 661 */     return this.phoneme;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RPattern getRContext() {
/* 670 */     return this.rContext;
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
/*     */   public boolean patternAndContextMatches(CharSequence paramCharSequence, int paramInt) {
/* 685 */     if (paramInt < 0) {
/* 686 */       throw new IndexOutOfBoundsException("Can not match pattern at negative indexes");
/*     */     }
/*     */     
/* 689 */     int i = this.pattern.length();
/* 690 */     int j = paramInt + i;
/*     */     
/* 692 */     if (j > paramCharSequence.length())
/*     */     {
/* 694 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 699 */     if (!paramCharSequence.subSequence(paramInt, j).equals(this.pattern))
/* 700 */       return false; 
/* 701 */     if (!this.rContext.isMatch(paramCharSequence.subSequence(j, paramCharSequence.length()))) {
/* 702 */       return false;
/*     */     }
/* 704 */     return this.lContext.isMatch(paramCharSequence.subSequence(0, paramInt));
/*     */   }
/*     */   
/*     */   public static interface RPattern {
/*     */     boolean isMatch(CharSequence param1CharSequence);
/*     */   }
/*     */   
/*     */   public static interface PhonemeExpr {
/*     */     Iterable<Rule.Phoneme> getPhonemes();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\language\bm\Rule.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */