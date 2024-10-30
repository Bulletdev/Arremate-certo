/*     */ package org.apache.commons.codec.language.bm;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.EnumMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.Scanner;
/*     */ import java.util.Set;
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
/*     */ public class Lang
/*     */ {
/*     */   private static final class LangRule
/*     */   {
/*     */     private final boolean acceptOnMatch;
/*     */     private final Set<String> languages;
/*     */     private final Pattern pattern;
/*     */     
/*     */     private LangRule(Pattern param1Pattern, Set<String> param1Set, boolean param1Boolean) {
/*  86 */       this.pattern = param1Pattern;
/*  87 */       this.languages = param1Set;
/*  88 */       this.acceptOnMatch = param1Boolean;
/*     */     }
/*     */     
/*     */     public boolean matches(String param1String) {
/*  92 */       return this.pattern.matcher(param1String).find();
/*     */     }
/*     */   }
/*     */   
/*  96 */   private static final Map<NameType, Lang> Langs = new EnumMap<>(NameType.class);
/*     */   
/*     */   private static final String LANGUAGE_RULES_RN = "org/apache/commons/codec/language/bm/%s_lang.txt";
/*     */   
/*     */   static {
/* 101 */     for (NameType nameType : NameType.values()) {
/* 102 */       Langs.put(nameType, loadFromResource(String.format("org/apache/commons/codec/language/bm/%s_lang.txt", new Object[] { nameType.getName() }), Languages.getInstance(nameType)));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private final Languages languages;
/*     */   
/*     */   private final List<LangRule> rules;
/*     */ 
/*     */   
/*     */   public static Lang instance(NameType paramNameType) {
/* 114 */     return Langs.get(paramNameType);
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
/*     */   public static Lang loadFromResource(String paramString, Languages paramLanguages) {
/* 130 */     ArrayList<LangRule> arrayList = new ArrayList();
/* 131 */     try (Scanner null = new Scanner(Resources.getInputStream(paramString), "UTF-8")) {
/*     */       
/* 133 */       boolean bool = false;
/* 134 */       while (scanner.hasNextLine()) {
/* 135 */         String str1 = scanner.nextLine();
/* 136 */         String str2 = str1;
/* 137 */         if (bool) {
/*     */           
/* 139 */           if (str2.endsWith("*/"))
/* 140 */             bool = false; 
/*     */           continue;
/*     */         } 
/* 143 */         if (str2.startsWith("/*")) {
/* 144 */           bool = true;
/*     */           continue;
/*     */         } 
/* 147 */         int i = str2.indexOf("//");
/* 148 */         if (i >= 0) {
/* 149 */           str2 = str2.substring(0, i);
/*     */         }
/*     */ 
/*     */         
/* 153 */         str2 = str2.trim();
/*     */         
/* 155 */         if (str2.length() == 0) {
/*     */           continue;
/*     */         }
/*     */ 
/*     */         
/* 160 */         String[] arrayOfString1 = str2.split("\\s+");
/*     */         
/* 162 */         if (arrayOfString1.length != 3) {
/* 163 */           throw new IllegalArgumentException("Malformed line '" + str1 + "' in language resource '" + paramString + "'");
/*     */         }
/*     */ 
/*     */         
/* 167 */         Pattern pattern = Pattern.compile(arrayOfString1[0]);
/* 168 */         String[] arrayOfString2 = arrayOfString1[1].split("\\+");
/* 169 */         boolean bool1 = arrayOfString1[2].equals("true");
/*     */         
/* 171 */         arrayList.add(new LangRule(pattern, new HashSet(Arrays.asList((Object[])arrayOfString2)), bool1));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 176 */     return new Lang(arrayList, paramLanguages);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Lang(List<LangRule> paramList, Languages paramLanguages) {
/* 183 */     this.rules = Collections.unmodifiableList(paramList);
/* 184 */     this.languages = paramLanguages;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String guessLanguage(String paramString) {
/* 195 */     Languages.LanguageSet languageSet = guessLanguages(paramString);
/* 196 */     return languageSet.isSingleton() ? languageSet.getAny() : "any";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Languages.LanguageSet guessLanguages(String paramString) {
/* 207 */     String str = paramString.toLowerCase(Locale.ENGLISH);
/*     */     
/* 209 */     HashSet<String> hashSet = new HashSet<>(this.languages.getLanguages());
/* 210 */     for (LangRule langRule : this.rules) {
/* 211 */       if (langRule.matches(str)) {
/* 212 */         if (langRule.acceptOnMatch) {
/* 213 */           hashSet.retainAll(langRule.languages); continue;
/*     */         } 
/* 215 */         hashSet.removeAll(langRule.languages);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 220 */     Languages.LanguageSet languageSet = Languages.LanguageSet.from(hashSet);
/* 221 */     return languageSet.equals(Languages.NO_LANGUAGES) ? Languages.ANY_LANGUAGE : languageSet;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\language\bm\Lang.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */