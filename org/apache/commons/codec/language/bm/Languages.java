/*     */ package org.apache.commons.codec.language.bm;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import java.util.EnumMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Scanner;
/*     */ import java.util.Set;
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
/*     */ public class Languages
/*     */ {
/*     */   public static final String ANY = "any";
/*     */   
/*     */   public static abstract class LanguageSet
/*     */   {
/*     */     public static LanguageSet from(Set<String> param1Set) {
/*  69 */       return param1Set.isEmpty() ? Languages.NO_LANGUAGES : new Languages.SomeLanguages(param1Set);
/*     */     }
/*     */ 
/*     */     
/*     */     public abstract boolean contains(String param1String);
/*     */     
/*     */     public abstract String getAny();
/*     */     
/*     */     public abstract boolean isEmpty();
/*     */     
/*     */     public abstract boolean isSingleton();
/*     */     
/*     */     public abstract LanguageSet restrictTo(LanguageSet param1LanguageSet);
/*     */     
/*     */     abstract LanguageSet merge(LanguageSet param1LanguageSet);
/*     */   }
/*     */   
/*     */   public static final class SomeLanguages
/*     */     extends LanguageSet
/*     */   {
/*     */     private final Set<String> languages;
/*     */     
/*     */     private SomeLanguages(Set<String> param1Set) {
/*  92 */       this.languages = Collections.unmodifiableSet(param1Set);
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean contains(String param1String) {
/*  97 */       return this.languages.contains(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public String getAny() {
/* 102 */       return this.languages.iterator().next();
/*     */     }
/*     */     
/*     */     public Set<String> getLanguages() {
/* 106 */       return this.languages;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isEmpty() {
/* 111 */       return this.languages.isEmpty();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isSingleton() {
/* 116 */       return (this.languages.size() == 1);
/*     */     }
/*     */ 
/*     */     
/*     */     public Languages.LanguageSet restrictTo(Languages.LanguageSet param1LanguageSet) {
/* 121 */       if (param1LanguageSet == Languages.NO_LANGUAGES)
/* 122 */         return param1LanguageSet; 
/* 123 */       if (param1LanguageSet == Languages.ANY_LANGUAGE) {
/* 124 */         return this;
/*     */       }
/* 126 */       SomeLanguages someLanguages = (SomeLanguages)param1LanguageSet;
/* 127 */       HashSet<String> hashSet = new HashSet(Math.min(this.languages.size(), someLanguages.languages.size()));
/* 128 */       for (String str : this.languages) {
/* 129 */         if (someLanguages.languages.contains(str)) {
/* 130 */           hashSet.add(str);
/*     */         }
/*     */       } 
/* 133 */       return from(hashSet);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Languages.LanguageSet merge(Languages.LanguageSet param1LanguageSet) {
/* 139 */       if (param1LanguageSet == Languages.NO_LANGUAGES)
/* 140 */         return this; 
/* 141 */       if (param1LanguageSet == Languages.ANY_LANGUAGE) {
/* 142 */         return param1LanguageSet;
/*     */       }
/* 144 */       SomeLanguages someLanguages = (SomeLanguages)param1LanguageSet;
/* 145 */       HashSet<String> hashSet = new HashSet<>(this.languages);
/* 146 */       for (String str : someLanguages.languages) {
/* 147 */         hashSet.add(str);
/*     */       }
/* 149 */       return from(hashSet);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 155 */       return "Languages(" + this.languages.toString() + ")";
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 162 */   private static final Map<NameType, Languages> LANGUAGES = new EnumMap<>(NameType.class); private final Set<String> languages;
/*     */   
/*     */   static {
/* 165 */     for (NameType nameType : NameType.values()) {
/* 166 */       LANGUAGES.put(nameType, getInstance(langResourceName(nameType)));
/*     */     }
/*     */   }
/*     */   
/*     */   public static Languages getInstance(NameType paramNameType) {
/* 171 */     return LANGUAGES.get(paramNameType);
/*     */   }
/*     */ 
/*     */   
/*     */   public static Languages getInstance(String paramString) {
/* 176 */     HashSet<String> hashSet = new HashSet();
/* 177 */     try (Scanner null = new Scanner(Resources.getInputStream(paramString), "UTF-8")) {
/*     */       
/* 179 */       boolean bool = false;
/* 180 */       while (scanner.hasNextLine()) {
/* 181 */         String str = scanner.nextLine().trim();
/* 182 */         if (bool) {
/* 183 */           if (str.endsWith("*/"))
/* 184 */             bool = false; 
/*     */           continue;
/*     */         } 
/* 187 */         if (str.startsWith("/*")) {
/* 188 */           bool = true; continue;
/* 189 */         }  if (str.length() > 0) {
/* 190 */           hashSet.add(str);
/*     */         }
/*     */       } 
/*     */       
/* 194 */       return new Languages(Collections.unmodifiableSet(hashSet));
/*     */     } 
/*     */   }
/*     */   
/*     */   private static String langResourceName(NameType paramNameType) {
/* 199 */     return String.format("org/apache/commons/codec/language/bm/%s_languages.txt", new Object[] { paramNameType.getName() });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 207 */   public static final LanguageSet NO_LANGUAGES = new LanguageSet()
/*     */     {
/*     */       public boolean contains(String param1String) {
/* 210 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public String getAny() {
/* 215 */         throw new NoSuchElementException("Can't fetch any language from the empty language set.");
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isEmpty() {
/* 220 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isSingleton() {
/* 225 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public Languages.LanguageSet restrictTo(Languages.LanguageSet param1LanguageSet) {
/* 230 */         return this;
/*     */       }
/*     */ 
/*     */       
/*     */       public Languages.LanguageSet merge(Languages.LanguageSet param1LanguageSet) {
/* 235 */         return param1LanguageSet;
/*     */       }
/*     */ 
/*     */       
/*     */       public String toString() {
/* 240 */         return "NO_LANGUAGES";
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 247 */   public static final LanguageSet ANY_LANGUAGE = new LanguageSet()
/*     */     {
/*     */       public boolean contains(String param1String) {
/* 250 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public String getAny() {
/* 255 */         throw new NoSuchElementException("Can't fetch any language from the any language set.");
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isEmpty() {
/* 260 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean isSingleton() {
/* 265 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       public Languages.LanguageSet restrictTo(Languages.LanguageSet param1LanguageSet) {
/* 270 */         return param1LanguageSet;
/*     */       }
/*     */ 
/*     */       
/*     */       public Languages.LanguageSet merge(Languages.LanguageSet param1LanguageSet) {
/* 275 */         return param1LanguageSet;
/*     */       }
/*     */ 
/*     */       
/*     */       public String toString() {
/* 280 */         return "ANY_LANGUAGE";
/*     */       }
/*     */     };
/*     */   
/*     */   private Languages(Set<String> paramSet) {
/* 285 */     this.languages = paramSet;
/*     */   }
/*     */   
/*     */   public Set<String> getLanguages() {
/* 289 */     return this.languages;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\language\bm\Languages.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */