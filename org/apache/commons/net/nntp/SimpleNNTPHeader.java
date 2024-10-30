/*     */ package org.apache.commons.net.nntp;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SimpleNNTPHeader
/*     */ {
/*     */   private final String subject;
/*     */   private final String from;
/*     */   private final StringBuilder newsgroups;
/*     */   private final StringBuilder headerFields;
/*     */   private int newsgroupCount;
/*     */   
/*     */   public SimpleNNTPHeader(String paramString1, String paramString2) {
/*  65 */     this.from = paramString1;
/*  66 */     this.subject = paramString2;
/*  67 */     this.newsgroups = new StringBuilder();
/*  68 */     this.headerFields = new StringBuilder();
/*  69 */     this.newsgroupCount = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addNewsgroup(String paramString) {
/*  80 */     if (this.newsgroupCount++ > 0) {
/*  81 */       this.newsgroups.append(',');
/*     */     }
/*  83 */     this.newsgroups.append(paramString);
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
/*     */   public void addHeaderField(String paramString1, String paramString2) {
/* 100 */     this.headerFields.append(paramString1);
/* 101 */     this.headerFields.append(": ");
/* 102 */     this.headerFields.append(paramString2);
/* 103 */     this.headerFields.append('\n');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFromAddress() {
/* 114 */     return this.from;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSubject() {
/* 124 */     return this.subject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNewsgroups() {
/* 135 */     return this.newsgroups.toString();
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
/*     */   public String toString() {
/* 148 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 150 */     stringBuilder.append("From: ");
/* 151 */     stringBuilder.append(this.from);
/* 152 */     stringBuilder.append("\nNewsgroups: ");
/* 153 */     stringBuilder.append(this.newsgroups.toString());
/* 154 */     stringBuilder.append("\nSubject: ");
/* 155 */     stringBuilder.append(this.subject);
/* 156 */     stringBuilder.append('\n');
/* 157 */     if (this.headerFields.length() > 0) {
/* 158 */       stringBuilder.append(this.headerFields.toString());
/*     */     }
/* 160 */     stringBuilder.append('\n');
/*     */     
/* 162 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\nntp\SimpleNNTPHeader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */