/*     */ package org.passay.dictionary;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import org.passay.dictionary.a.a;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class l
/*     */ {
/*  21 */   public static final Comparator<String> m = new Comparator<String>()
/*     */     {
/*     */       public int compare(String param1String1, String param1String2)
/*     */       {
/*  25 */         return param1String1.compareTo(param1String2);
/*     */       }
/*     */ 
/*     */       
/*     */       public String toString() {
/*  30 */         return String.format("%s-%s@%d", new Object[] { getClass().getName(), "CASE_SENSITIVE", Integer.valueOf(hashCode()) });
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  35 */   public static final Comparator<String> n = new Comparator<String>()
/*     */     {
/*     */       public int compare(String param1String1, String param1String2)
/*     */       {
/*  39 */         return param1String1.compareToIgnoreCase(param1String2);
/*     */       }
/*     */ 
/*     */       
/*     */       public String toString() {
/*  44 */         return String.format("%s-%s@%d", new Object[] { getClass().getName(), "CASE_INSENSITIVE", Integer.valueOf(hashCode()) });
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int NOT_FOUND = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int a(k paramk, String paramString) {
/*  66 */     Comparator<String> comparator = paramk.getComparator();
/*  67 */     int i = 0;
/*  68 */     int j = paramk.size() - 1;
/*     */     
/*  70 */     while (i <= j) {
/*  71 */       int m = (i + j) / 2;
/*     */       
/*  73 */       int n = comparator.compare(paramk.get(m), paramString);
/*  74 */       if (n < 0) {
/*  75 */         i = m + 1; continue;
/*  76 */       }  if (n > 0) {
/*  77 */         j = m - 1; continue;
/*     */       } 
/*  79 */       return m;
/*     */     } 
/*     */     
/*  82 */     return -1;
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
/*     */   public static c a(Reader[] paramArrayOfReader) throws IOException {
/*  98 */     return a(paramArrayOfReader, true);
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
/*     */   public static c a(Reader[] paramArrayOfReader, boolean paramBoolean) throws IOException {
/* 115 */     return a(paramArrayOfReader, paramBoolean, null);
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
/*     */   public static c a(Reader[] paramArrayOfReader, boolean paramBoolean, a parama) throws IOException {
/* 136 */     ArrayList<String> arrayList = new ArrayList();
/* 137 */     for (Reader reader : paramArrayOfReader) {
/* 138 */       a(reader, arrayList);
/*     */     }
/* 140 */     return new c(arrayList.<String>toArray(new String[arrayList.size()]), paramBoolean, parama);
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
/*     */   public static void a(Reader paramReader, List<String> paramList) throws IOException {
/*     */     try {
/*     */       BufferedReader bufferedReader;
/* 157 */       if (paramReader instanceof BufferedReader) {
/* 158 */         bufferedReader = (BufferedReader)paramReader;
/*     */       } else {
/* 160 */         bufferedReader = new BufferedReader(paramReader);
/*     */       } 
/*     */       
/*     */       String str;
/* 164 */       while ((str = bufferedReader.readLine()) != null) {
/* 165 */         if (!str.isEmpty()) {
/* 166 */           paramList.add(str);
/*     */         }
/*     */       } 
/*     */     } finally {
/* 170 */       paramReader.close();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\dictionary\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */