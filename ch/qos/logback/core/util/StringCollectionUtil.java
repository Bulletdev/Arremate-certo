/*     */ package ch.qos.logback.core.util;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StringCollectionUtil
/*     */ {
/*     */   public static void retainMatching(Collection<String> paramCollection, String... paramVarArgs) {
/*  41 */     retainMatching(paramCollection, Arrays.asList(paramVarArgs));
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
/*     */   public static void retainMatching(Collection<String> paramCollection1, Collection<String> paramCollection2) {
/*  56 */     if (paramCollection2.isEmpty())
/*     */       return; 
/*  58 */     ArrayList<String> arrayList = new ArrayList(paramCollection1.size());
/*  59 */     for (String str : paramCollection2) {
/*  60 */       Pattern pattern = Pattern.compile(str);
/*  61 */       for (String str1 : paramCollection1) {
/*  62 */         if (pattern.matcher(str1).matches()) {
/*  63 */           arrayList.add(str1);
/*     */         }
/*     */       } 
/*     */     } 
/*  67 */     paramCollection1.retainAll(arrayList);
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
/*     */   public static void removeMatching(Collection<String> paramCollection, String... paramVarArgs) {
/*  82 */     removeMatching(paramCollection, Arrays.asList(paramVarArgs));
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
/*     */   public static void removeMatching(Collection<String> paramCollection1, Collection<String> paramCollection2) {
/*  97 */     ArrayList<String> arrayList = new ArrayList(paramCollection1.size());
/*  98 */     for (String str : paramCollection2) {
/*  99 */       Pattern pattern = Pattern.compile(str);
/* 100 */       for (String str1 : paramCollection1) {
/* 101 */         if (pattern.matcher(str1).matches()) {
/* 102 */           arrayList.add(str1);
/*     */         }
/*     */       } 
/*     */     } 
/* 106 */     paramCollection1.removeAll(arrayList);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\StringCollectionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */