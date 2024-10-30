/*     */ package org.apache.commons.codec.language.bm;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.EnumMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PhoneticEngine
/*     */ {
/*     */   static final class PhonemeBuilder
/*     */   {
/*     */     private final Set<Rule.Phoneme> phonemes;
/*     */     
/*     */     public static PhonemeBuilder empty(Languages.LanguageSet param1LanguageSet) {
/*  72 */       return new PhonemeBuilder(new Rule.Phoneme("", param1LanguageSet));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private PhonemeBuilder(Rule.Phoneme param1Phoneme) {
/*  78 */       this.phonemes = new LinkedHashSet<>();
/*  79 */       this.phonemes.add(param1Phoneme);
/*     */     }
/*     */     
/*     */     private PhonemeBuilder(Set<Rule.Phoneme> param1Set) {
/*  83 */       this.phonemes = param1Set;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void append(CharSequence param1CharSequence) {
/*  92 */       for (Rule.Phoneme phoneme : this.phonemes) {
/*  93 */         phoneme.append(param1CharSequence);
/*     */       }
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
/*     */     
/*     */     public void apply(Rule.PhonemeExpr param1PhonemeExpr, int param1Int) {
/* 107 */       LinkedHashSet<Rule.Phoneme> linkedHashSet = new LinkedHashSet(param1Int);
/*     */       
/* 109 */       label18: for (Rule.Phoneme phoneme : this.phonemes) {
/* 110 */         for (Rule.Phoneme phoneme1 : param1PhonemeExpr.getPhonemes()) {
/* 111 */           Languages.LanguageSet languageSet = phoneme.getLanguages().restrictTo(phoneme1.getLanguages());
/* 112 */           if (!languageSet.isEmpty()) {
/* 113 */             Rule.Phoneme phoneme2 = new Rule.Phoneme(phoneme, phoneme1, languageSet);
/* 114 */             if (linkedHashSet.size() < param1Int) {
/* 115 */               linkedHashSet.add(phoneme2);
/* 116 */               if (linkedHashSet.size() >= param1Int) {
/*     */                 break label18;
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 124 */       this.phonemes.clear();
/* 125 */       this.phonemes.addAll(linkedHashSet);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Set<Rule.Phoneme> getPhonemes() {
/* 134 */       return this.phonemes;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String makeString() {
/* 145 */       StringBuilder stringBuilder = new StringBuilder();
/*     */       
/* 147 */       for (Rule.Phoneme phoneme : this.phonemes) {
/* 148 */         if (stringBuilder.length() > 0) {
/* 149 */           stringBuilder.append("|");
/*     */         }
/* 151 */         stringBuilder.append(phoneme.getPhonemeText());
/*     */       } 
/*     */       
/* 154 */       return stringBuilder.toString();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class RulesApplication
/*     */   {
/*     */     private final Map<String, List<Rule>> finalRules;
/*     */ 
/*     */     
/*     */     private final CharSequence input;
/*     */ 
/*     */     
/*     */     private final PhoneticEngine.PhonemeBuilder phonemeBuilder;
/*     */ 
/*     */     
/*     */     private int i;
/*     */ 
/*     */     
/*     */     private final int maxPhonemes;
/*     */ 
/*     */     
/*     */     private boolean found;
/*     */ 
/*     */     
/*     */     public RulesApplication(Map<String, List<Rule>> param1Map, CharSequence param1CharSequence, PhoneticEngine.PhonemeBuilder param1PhonemeBuilder, int param1Int1, int param1Int2) {
/* 181 */       Objects.requireNonNull(param1Map, "finalRules");
/* 182 */       this.finalRules = param1Map;
/* 183 */       this.phonemeBuilder = param1PhonemeBuilder;
/* 184 */       this.input = param1CharSequence;
/* 185 */       this.i = param1Int1;
/* 186 */       this.maxPhonemes = param1Int2;
/*     */     }
/*     */     
/*     */     public int getI() {
/* 190 */       return this.i;
/*     */     }
/*     */     
/*     */     public PhoneticEngine.PhonemeBuilder getPhonemeBuilder() {
/* 194 */       return this.phonemeBuilder;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public RulesApplication invoke() {
/* 205 */       this.found = false;
/* 206 */       int i = 1;
/* 207 */       List list = this.finalRules.get(this.input.subSequence(this.i, this.i + i));
/* 208 */       if (list != null) {
/* 209 */         for (Rule rule : list) {
/* 210 */           String str = rule.getPattern();
/* 211 */           i = str.length();
/* 212 */           if (rule.patternAndContextMatches(this.input, this.i)) {
/* 213 */             this.phonemeBuilder.apply(rule.getPhoneme(), this.maxPhonemes);
/* 214 */             this.found = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/* 220 */       if (!this.found) {
/* 221 */         i = 1;
/*     */       }
/*     */       
/* 224 */       this.i += i;
/* 225 */       return this;
/*     */     }
/*     */     
/*     */     public boolean isFound() {
/* 229 */       return this.found;
/*     */     }
/*     */   }
/*     */   private static final int DEFAULT_MAX_PHONEMES = 20;
/* 233 */   private static final Map<NameType, Set<String>> NAME_PREFIXES = new EnumMap<>(NameType.class);
/*     */   
/*     */   static {
/* 236 */     NAME_PREFIXES.put(NameType.ASHKENAZI, 
/* 237 */         Collections.unmodifiableSet(new HashSet<>(
/* 238 */             Arrays.asList(new String[] { "bar", "ben", "da", "de", "van", "von" }))));
/* 239 */     NAME_PREFIXES.put(NameType.SEPHARDIC, 
/* 240 */         Collections.unmodifiableSet(new HashSet<>(
/* 241 */             Arrays.asList(new String[] { 
/*     */                 "al", "el", "da", "dal", "de", "del", "dela", "de la", "della", "des", 
/* 243 */                 "di", "do", "dos", "du", "van", "von" })))); NAME_PREFIXES.put(NameType.GENERIC, 
/* 244 */         Collections.unmodifiableSet(new HashSet<>(
/* 245 */             Arrays.asList(new String[] { 
/*     */                 "da", "dal", "de", "del", "dela", "de la", "della", "des", "di", "do", 
/*     */                 "dos", "du", "van", "von" }))));
/*     */   }
/*     */   private final Lang lang;
/*     */   private final NameType nameType;
/*     */   private final RuleType ruleType;
/*     */   private final boolean concat;
/*     */   private final int maxPhonemes;
/*     */   
/*     */   private static String join(Iterable<String> paramIterable, String paramString) {
/* 256 */     StringBuilder stringBuilder = new StringBuilder();
/* 257 */     Iterator<String> iterator = paramIterable.iterator();
/* 258 */     if (iterator.hasNext()) {
/* 259 */       stringBuilder.append(iterator.next());
/*     */     }
/* 261 */     while (iterator.hasNext()) {
/* 262 */       stringBuilder.append(paramString).append(iterator.next());
/*     */     }
/*     */     
/* 265 */     return stringBuilder.toString();
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
/*     */   public PhoneticEngine(NameType paramNameType, RuleType paramRuleType, boolean paramBoolean) {
/* 291 */     this(paramNameType, paramRuleType, paramBoolean, 20);
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
/*     */   public PhoneticEngine(NameType paramNameType, RuleType paramRuleType, boolean paramBoolean, int paramInt) {
/* 309 */     if (paramRuleType == RuleType.RULES) {
/* 310 */       throw new IllegalArgumentException("ruleType must not be " + RuleType.RULES);
/*     */     }
/* 312 */     this.nameType = paramNameType;
/* 313 */     this.ruleType = paramRuleType;
/* 314 */     this.concat = paramBoolean;
/* 315 */     this.lang = Lang.instance(paramNameType);
/* 316 */     this.maxPhonemes = paramInt;
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
/*     */   private PhonemeBuilder applyFinalRules(PhonemeBuilder paramPhonemeBuilder, Map<String, List<Rule>> paramMap) {
/* 329 */     Objects.requireNonNull(paramMap, "finalRules");
/* 330 */     if (paramMap.isEmpty()) {
/* 331 */       return paramPhonemeBuilder;
/*     */     }
/*     */     
/* 334 */     TreeMap<Rule.Phoneme, Object> treeMap = new TreeMap<>(Rule.Phoneme.COMPARATOR);
/*     */ 
/*     */     
/* 337 */     for (Rule.Phoneme phoneme : paramPhonemeBuilder.getPhonemes()) {
/* 338 */       PhonemeBuilder phonemeBuilder = PhonemeBuilder.empty(phoneme.getLanguages());
/* 339 */       String str = phoneme.getPhonemeText().toString();
/*     */       int i;
/* 341 */       for (i = 0; i < str.length(); ) {
/*     */         
/* 343 */         RulesApplication rulesApplication = (new RulesApplication(paramMap, str, phonemeBuilder, i, this.maxPhonemes)).invoke();
/* 344 */         boolean bool = rulesApplication.isFound();
/* 345 */         phonemeBuilder = rulesApplication.getPhonemeBuilder();
/*     */         
/* 347 */         if (!bool)
/*     */         {
/* 349 */           phonemeBuilder.append(str.subSequence(i, i + 1));
/*     */         }
/*     */         
/* 352 */         i = rulesApplication.getI();
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 358 */       for (Rule.Phoneme phoneme1 : phonemeBuilder.getPhonemes()) {
/* 359 */         if (treeMap.containsKey(phoneme1)) {
/* 360 */           Rule.Phoneme phoneme2 = (Rule.Phoneme)treeMap.remove(phoneme1);
/* 361 */           Rule.Phoneme phoneme3 = phoneme2.mergeWithLanguage(phoneme1.getLanguages());
/* 362 */           treeMap.put(phoneme3, phoneme3); continue;
/*     */         } 
/* 364 */         treeMap.put(phoneme1, phoneme1);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 369 */     return new PhonemeBuilder(treeMap.keySet());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String encode(String paramString) {
/* 380 */     Languages.LanguageSet languageSet = this.lang.guessLanguages(paramString);
/* 381 */     return encode(paramString, languageSet);
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
/*     */   public String encode(String paramString, Languages.LanguageSet paramLanguageSet) {
/* 395 */     Map<String, List<Rule>> map1 = Rule.getInstanceMap(this.nameType, RuleType.RULES, paramLanguageSet);
/*     */     
/* 397 */     Map<String, List<Rule>> map2 = Rule.getInstanceMap(this.nameType, this.ruleType, "common");
/*     */     
/* 399 */     Map<String, List<Rule>> map3 = Rule.getInstanceMap(this.nameType, this.ruleType, paramLanguageSet);
/*     */ 
/*     */ 
/*     */     
/* 403 */     paramString = paramString.toLowerCase(Locale.ENGLISH).replace('-', ' ').trim();
/*     */     
/* 405 */     if (this.nameType == NameType.GENERIC) {
/* 406 */       if (paramString.length() >= 2 && paramString.substring(0, 2).equals("d'")) {
/* 407 */         String str1 = paramString.substring(2);
/* 408 */         String str2 = "d" + str1;
/* 409 */         return "(" + encode(str1) + ")-(" + encode(str2) + ")";
/*     */       } 
/* 411 */       for (String str : NAME_PREFIXES.get(this.nameType)) {
/*     */         
/* 413 */         if (paramString.startsWith(str + " ")) {
/*     */           
/* 415 */           String str1 = paramString.substring(str.length() + 1);
/* 416 */           String str2 = str + str1;
/* 417 */           return "(" + encode(str1) + ")-(" + encode(str2) + ")";
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 422 */     List<String> list = Arrays.asList(paramString.split("\\s+"));
/* 423 */     ArrayList<String> arrayList = new ArrayList();
/*     */ 
/*     */     
/* 426 */     switch (this.nameType) {
/*     */       case SEPHARDIC:
/* 428 */         for (String str1 : list) {
/* 429 */           String[] arrayOfString = str1.split("'");
/* 430 */           String str2 = arrayOfString[arrayOfString.length - 1];
/* 431 */           arrayList.add(str2);
/*     */         } 
/* 433 */         arrayList.removeAll(NAME_PREFIXES.get(this.nameType));
/*     */         break;
/*     */       case ASHKENAZI:
/* 436 */         arrayList.addAll(list);
/* 437 */         arrayList.removeAll(NAME_PREFIXES.get(this.nameType));
/*     */         break;
/*     */       case GENERIC:
/* 440 */         arrayList.addAll(list);
/*     */         break;
/*     */       default:
/* 443 */         throw new IllegalStateException("Unreachable case: " + this.nameType);
/*     */     } 
/*     */     
/* 446 */     if (this.concat) {
/*     */       
/* 448 */       paramString = join(arrayList, " ");
/* 449 */     } else if (arrayList.size() == 1) {
/*     */       
/* 451 */       paramString = list.iterator().next();
/*     */     } else {
/*     */       
/* 454 */       StringBuilder stringBuilder = new StringBuilder();
/* 455 */       for (String str : arrayList) {
/* 456 */         stringBuilder.append("-").append(encode(str));
/*     */       }
/*     */       
/* 459 */       return stringBuilder.substring(1);
/*     */     } 
/*     */     
/* 462 */     PhonemeBuilder phonemeBuilder = PhonemeBuilder.empty(paramLanguageSet);
/*     */ 
/*     */     
/* 465 */     for (int i = 0; i < paramString.length(); ) {
/*     */       
/* 467 */       RulesApplication rulesApplication = (new RulesApplication(map1, paramString, phonemeBuilder, i, this.maxPhonemes)).invoke();
/* 468 */       i = rulesApplication.getI();
/* 469 */       phonemeBuilder = rulesApplication.getPhonemeBuilder();
/*     */     } 
/*     */ 
/*     */     
/* 473 */     phonemeBuilder = applyFinalRules(phonemeBuilder, map2);
/*     */     
/* 475 */     phonemeBuilder = applyFinalRules(phonemeBuilder, map3);
/*     */     
/* 477 */     return phonemeBuilder.makeString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Lang getLang() {
/* 486 */     return this.lang;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NameType getNameType() {
/* 495 */     return this.nameType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RuleType getRuleType() {
/* 504 */     return this.ruleType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isConcat() {
/* 513 */     return this.concat;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxPhonemes() {
/* 523 */     return this.maxPhonemes;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\language\bm\PhoneticEngine.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */