/*     */ package org.apache.http.conn.util;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public final class PublicSuffixListParser
/*     */ {
/*     */   public PublicSuffixList parse(Reader paramReader) throws IOException {
/*  60 */     ArrayList<String> arrayList1 = new ArrayList();
/*  61 */     ArrayList<String> arrayList2 = new ArrayList();
/*  62 */     BufferedReader bufferedReader = new BufferedReader(paramReader);
/*     */     
/*     */     String str;
/*  65 */     while ((str = bufferedReader.readLine()) != null) {
/*  66 */       if (str.isEmpty()) {
/*     */         continue;
/*     */       }
/*  69 */       if (str.startsWith("//")) {
/*     */         continue;
/*     */       }
/*  72 */       if (str.startsWith(".")) {
/*  73 */         str = str.substring(1);
/*     */       }
/*     */       
/*  76 */       boolean bool = str.startsWith("!");
/*  77 */       if (bool) {
/*  78 */         str = str.substring(1);
/*     */       }
/*     */       
/*  81 */       if (bool) {
/*  82 */         arrayList2.add(str); continue;
/*     */       } 
/*  84 */       arrayList1.add(str);
/*     */     } 
/*     */     
/*  87 */     return new PublicSuffixList(DomainType.UNKNOWN, arrayList1, arrayList2);
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
/*     */   public List<PublicSuffixList> parseByType(Reader paramReader) throws IOException {
/* 102 */     ArrayList<PublicSuffixList> arrayList = new ArrayList(2);
/*     */     
/* 104 */     BufferedReader bufferedReader = new BufferedReader(paramReader);
/*     */     
/* 106 */     DomainType domainType = null;
/* 107 */     List<String> list1 = null;
/* 108 */     List<String> list2 = null;
/*     */     String str;
/* 110 */     while ((str = bufferedReader.readLine()) != null) {
/* 111 */       if (str.isEmpty()) {
/*     */         continue;
/*     */       }
/* 114 */       if (str.startsWith("//")) {
/*     */         
/* 116 */         if (domainType == null) {
/* 117 */           if (str.contains("===BEGIN ICANN DOMAINS===")) {
/* 118 */             domainType = DomainType.ICANN; continue;
/* 119 */           }  if (str.contains("===BEGIN PRIVATE DOMAINS==="))
/* 120 */             domainType = DomainType.PRIVATE; 
/*     */           continue;
/*     */         } 
/* 123 */         if (str.contains("===END ICANN DOMAINS===") || str.contains("===END PRIVATE DOMAINS===")) {
/* 124 */           if (list1 != null) {
/* 125 */             arrayList.add(new PublicSuffixList(domainType, list1, list2));
/*     */           }
/* 127 */           domainType = null;
/* 128 */           list1 = null;
/* 129 */           list2 = null;
/*     */         } 
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 135 */       if (domainType == null) {
/*     */         continue;
/*     */       }
/*     */       
/* 139 */       if (str.startsWith(".")) {
/* 140 */         str = str.substring(1);
/*     */       }
/*     */       
/* 143 */       boolean bool = str.startsWith("!");
/* 144 */       if (bool) {
/* 145 */         str = str.substring(1);
/*     */       }
/*     */       
/* 148 */       if (bool) {
/* 149 */         if (list2 == null) {
/* 150 */           list2 = new ArrayList();
/*     */         }
/* 152 */         list2.add(str); continue;
/*     */       } 
/* 154 */       if (list1 == null) {
/* 155 */         list1 = new ArrayList();
/*     */       }
/* 157 */       list1.add(str);
/*     */     } 
/*     */     
/* 160 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\con\\util\PublicSuffixListParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */