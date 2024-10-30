/*     */ package org.c.a.b.r;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */ {
/*     */   private final List<String> as;
/*     */   private final List<List<String>> at;
/*     */   private final boolean db;
/*     */   private final String nullText;
/*     */   private final String lI;
/*     */   
/*     */   public b(List<String> paramList, List<List<String>> paramList1, boolean paramBoolean, String paramString1, String paramString2) {
/*  41 */     this.as = paramList;
/*  42 */     this.at = paramList1;
/*  43 */     this.db = paramBoolean;
/*  44 */     this.nullText = paramString1;
/*  45 */     this.lI = paramString2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String eN() {
/*  52 */     ArrayList<Integer> arrayList = new ArrayList();
/*  53 */     for (String str : this.as) {
/*  54 */       arrayList.add(Integer.valueOf(str.length()));
/*     */     }
/*     */     
/*  57 */     for (List<String> list : this.at) {
/*  58 */       for (byte b1 = 0; b1 < list.size(); b1++) {
/*  59 */         arrayList.set(b1, Integer.valueOf(Math.max(((Integer)arrayList.get(b1)).intValue(), a(list, b1).length())));
/*     */       }
/*     */     } 
/*     */     
/*  63 */     StringBuilder stringBuilder1 = new StringBuilder("+");
/*  64 */     for (Integer integer : arrayList) {
/*  65 */       stringBuilder1.append("-").append(n.c("", integer.intValue(), '-')).append("-+");
/*     */     }
/*  67 */     stringBuilder1.append("\n");
/*     */     
/*  69 */     StringBuilder stringBuilder2 = new StringBuilder();
/*     */     
/*  71 */     if (this.db) {
/*  72 */       StringBuilder stringBuilder = new StringBuilder("|");
/*  73 */       for (byte b1 = 0; b1 < arrayList.size(); b1++) {
/*  74 */         stringBuilder.append(" ").append(n.c(this.as.get(b1), ((Integer)arrayList.get(b1)).intValue(), ' ')).append(" |");
/*     */       }
/*  76 */       stringBuilder.append("\n");
/*     */       
/*  78 */       stringBuilder2.append(stringBuilder1);
/*  79 */       stringBuilder2.append(stringBuilder);
/*     */     } 
/*     */     
/*  82 */     stringBuilder2.append(stringBuilder1);
/*     */     
/*  84 */     if (this.at.isEmpty()) {
/*  85 */       stringBuilder2.append("| ").append(n.k(this.lI, stringBuilder1.length() - 5)).append(" |\n");
/*     */     } else {
/*  87 */       for (List<String> list : this.at) {
/*  88 */         StringBuilder stringBuilder = new StringBuilder("|");
/*  89 */         for (byte b1 = 0; b1 < arrayList.size(); b1++) {
/*  90 */           stringBuilder.append(" ").append(n.c(a(list, b1), ((Integer)arrayList.get(b1)).intValue(), ' ')).append(" |");
/*     */         }
/*  92 */         stringBuilder.append("\n");
/*  93 */         stringBuilder2.append(stringBuilder);
/*     */       } 
/*     */     } 
/*     */     
/*  97 */     stringBuilder2.append(stringBuilder1);
/*  98 */     return stringBuilder2.toString();
/*     */   }
/*     */   
/*     */   private String a(List<String> paramList, int paramInt) {
/* 102 */     String str = paramList.get(paramInt);
/* 103 */     if (str == null) {
/* 104 */       str = this.nullText;
/*     */     }
/* 106 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\r\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */