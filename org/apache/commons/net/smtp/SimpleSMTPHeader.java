/*     */ package org.apache.commons.net.smtp;
/*     */ 
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SimpleSMTPHeader
/*     */ {
/*     */   private final String subject;
/*     */   private final String from;
/*     */   private final String to;
/*     */   private final StringBuffer headerFields;
/*     */   private boolean hasHeaderDate;
/*     */   private StringBuffer cc;
/*     */   
/*     */   public SimpleSMTPHeader(String paramString1, String paramString2, String paramString3) {
/*  77 */     if (paramString1 == null) {
/*  78 */       throw new IllegalArgumentException("From cannot be null");
/*     */     }
/*  80 */     this.to = paramString2;
/*  81 */     this.from = paramString1;
/*  82 */     this.subject = paramString3;
/*  83 */     this.headerFields = new StringBuffer();
/*  84 */     this.cc = null;
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
/* 101 */     if (!this.hasHeaderDate && "Date".equals(paramString1)) {
/* 102 */       this.hasHeaderDate = true;
/*     */     }
/* 104 */     this.headerFields.append(paramString1);
/* 105 */     this.headerFields.append(": ");
/* 106 */     this.headerFields.append(paramString2);
/* 107 */     this.headerFields.append('\n');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addCC(String paramString) {
/* 118 */     if (this.cc == null) {
/* 119 */       this.cc = new StringBuffer();
/*     */     } else {
/* 121 */       this.cc.append(", ");
/*     */     } 
/*     */     
/* 124 */     this.cc.append(paramString);
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
/*     */   public String toString() {
/* 139 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 141 */     String str = "EEE, dd MMM yyyy HH:mm:ss Z";
/* 142 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
/*     */     
/* 144 */     if (!this.hasHeaderDate) {
/* 145 */       addHeaderField("Date", simpleDateFormat.format(new Date()));
/*     */     }
/* 147 */     if (this.headerFields.length() > 0) {
/* 148 */       stringBuilder.append(this.headerFields.toString());
/*     */     }
/*     */     
/* 151 */     stringBuilder.append("From: ").append(this.from).append("\n");
/*     */     
/* 153 */     if (this.to != null) {
/* 154 */       stringBuilder.append("To: ").append(this.to).append("\n");
/*     */     }
/*     */     
/* 157 */     if (this.cc != null)
/*     */     {
/* 159 */       stringBuilder.append("Cc: ").append(this.cc.toString()).append("\n");
/*     */     }
/*     */     
/* 162 */     if (this.subject != null)
/*     */     {
/* 164 */       stringBuilder.append("Subject: ").append(this.subject).append("\n");
/*     */     }
/*     */     
/* 167 */     stringBuilder.append('\n');
/*     */     
/* 169 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\smtp\SimpleSMTPHeader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */