/*     */ package org.apache.http.conn.util;
/*     */ 
/*     */ import java.net.IDN;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.util.Args;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public final class PublicSuffixMatcher
/*     */ {
/*     */   private final Map<String, DomainType> rules;
/*     */   private final Map<String, DomainType> exceptions;
/*     */   
/*     */   public PublicSuffixMatcher(Collection<String> paramCollection1, Collection<String> paramCollection2) {
/*  56 */     this(DomainType.UNKNOWN, paramCollection1, paramCollection2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PublicSuffixMatcher(DomainType paramDomainType, Collection<String> paramCollection1, Collection<String> paramCollection2) {
/*  64 */     Args.notNull(paramDomainType, "Domain type");
/*  65 */     Args.notNull(paramCollection1, "Domain suffix rules");
/*  66 */     this.rules = new ConcurrentHashMap<String, DomainType>(paramCollection1.size());
/*  67 */     for (String str : paramCollection1) {
/*  68 */       this.rules.put(str, paramDomainType);
/*     */     }
/*  70 */     this.exceptions = new ConcurrentHashMap<String, DomainType>();
/*  71 */     if (paramCollection2 != null) {
/*  72 */       for (String str : paramCollection2) {
/*  73 */         this.exceptions.put(str, paramDomainType);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PublicSuffixMatcher(Collection<PublicSuffixList> paramCollection) {
/*  82 */     Args.notNull(paramCollection, "Domain suffix lists");
/*  83 */     this.rules = new ConcurrentHashMap<String, DomainType>();
/*  84 */     this.exceptions = new ConcurrentHashMap<String, DomainType>();
/*  85 */     for (PublicSuffixList publicSuffixList : paramCollection) {
/*  86 */       DomainType domainType = publicSuffixList.getType();
/*  87 */       List<String> list1 = publicSuffixList.getRules();
/*  88 */       for (String str : list1) {
/*  89 */         this.rules.put(str, domainType);
/*     */       }
/*  91 */       List<String> list2 = publicSuffixList.getExceptions();
/*  92 */       if (list2 != null) {
/*  93 */         for (String str : list2) {
/*  94 */           this.exceptions.put(str, domainType);
/*     */         }
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private static DomainType findEntry(Map<String, DomainType> paramMap, String paramString) {
/* 101 */     if (paramMap == null) {
/* 102 */       return null;
/*     */     }
/* 104 */     return paramMap.get(paramString);
/*     */   }
/*     */   
/*     */   private static boolean match(DomainType paramDomainType1, DomainType paramDomainType2) {
/* 108 */     return (paramDomainType1 != null && (paramDomainType2 == null || paramDomainType1.equals(paramDomainType2)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDomainRoot(String paramString) {
/* 119 */     return getDomainRoot(paramString, null);
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
/*     */   public String getDomainRoot(String paramString, DomainType paramDomainType) {
/* 133 */     if (paramString == null) {
/* 134 */       return null;
/*     */     }
/* 136 */     if (paramString.startsWith(".")) {
/* 137 */       return null;
/*     */     }
/* 139 */     String str1 = DnsUtils.normalize(paramString);
/* 140 */     String str2 = str1;
/* 141 */     String str3 = null;
/* 142 */     while (str2 != null) {
/*     */       
/* 144 */       String str4 = IDN.toUnicode(str2);
/* 145 */       DomainType domainType1 = findEntry(this.exceptions, str4);
/* 146 */       if (match(domainType1, paramDomainType)) {
/* 147 */         return str2;
/*     */       }
/* 149 */       DomainType domainType2 = findEntry(this.rules, str4);
/* 150 */       if (match(domainType2, paramDomainType)) {
/* 151 */         if (domainType2 == DomainType.PRIVATE) {
/* 152 */           return str2;
/*     */         }
/* 154 */         return str3;
/*     */       } 
/*     */       
/* 157 */       int i = str2.indexOf('.');
/* 158 */       String str5 = (i != -1) ? str2.substring(i + 1) : null;
/*     */       
/* 160 */       if (str5 != null) {
/* 161 */         DomainType domainType = findEntry(this.rules, "*." + IDN.toUnicode(str5));
/* 162 */         if (match(domainType, paramDomainType)) {
/* 163 */           if (domainType == DomainType.PRIVATE) {
/* 164 */             return str2;
/*     */           }
/* 166 */           return str3;
/*     */         } 
/*     */       } 
/* 169 */       str3 = str2;
/* 170 */       str2 = str5;
/*     */     } 
/*     */ 
/*     */     
/* 174 */     if (paramDomainType == null || paramDomainType == DomainType.UNKNOWN) {
/* 175 */       return str3;
/*     */     }
/*     */ 
/*     */     
/* 179 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(String paramString) {
/* 186 */     return matches(paramString, null);
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
/*     */   public boolean matches(String paramString, DomainType paramDomainType) {
/* 199 */     if (paramString == null) {
/* 200 */       return false;
/*     */     }
/* 202 */     String str = getDomainRoot(paramString.startsWith(".") ? paramString.substring(1) : paramString, paramDomainType);
/*     */     
/* 204 */     return (str == null);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\con\\util\PublicSuffixMatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */