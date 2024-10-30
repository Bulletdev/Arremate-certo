/*     */ package org.apache.commons.net.nntp;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class NewGroupsOrNewsQuery
/*     */ {
/*     */   private final String date;
/*     */   private final String time;
/*     */   private StringBuffer distributions;
/*     */   private StringBuffer newsgroups;
/*     */   private final boolean isGMT;
/*     */   
/*     */   public NewGroupsOrNewsQuery(Calendar paramCalendar, boolean paramBoolean) {
/*  63 */     this.distributions = null;
/*  64 */     this.newsgroups = null;
/*  65 */     this.isGMT = paramBoolean;
/*     */     
/*  67 */     StringBuilder stringBuilder = new StringBuilder();
/*     */ 
/*     */     
/*  70 */     int i = paramCalendar.get(1);
/*  71 */     String str = Integer.toString(i);
/*  72 */     i = str.length();
/*     */     
/*  74 */     if (i >= 2) {
/*  75 */       stringBuilder.append(str.substring(i - 2));
/*     */     } else {
/*  77 */       stringBuilder.append("00");
/*     */     } 
/*     */ 
/*     */     
/*  81 */     i = paramCalendar.get(2) + 1;
/*  82 */     str = Integer.toString(i);
/*  83 */     i = str.length();
/*     */     
/*  85 */     if (i == 1) {
/*  86 */       stringBuilder.append('0');
/*  87 */       stringBuilder.append(str);
/*  88 */     } else if (i == 2) {
/*  89 */       stringBuilder.append(str);
/*     */     } else {
/*  91 */       stringBuilder.append("01");
/*     */     } 
/*     */ 
/*     */     
/*  95 */     i = paramCalendar.get(5);
/*  96 */     str = Integer.toString(i);
/*  97 */     i = str.length();
/*     */     
/*  99 */     if (i == 1) {
/* 100 */       stringBuilder.append('0');
/* 101 */       stringBuilder.append(str);
/* 102 */     } else if (i == 2) {
/* 103 */       stringBuilder.append(str);
/*     */     } else {
/* 105 */       stringBuilder.append("01");
/*     */     } 
/*     */     
/* 108 */     this.date = stringBuilder.toString();
/*     */     
/* 110 */     stringBuilder.setLength(0);
/*     */ 
/*     */     
/* 113 */     i = paramCalendar.get(11);
/* 114 */     str = Integer.toString(i);
/* 115 */     i = str.length();
/*     */     
/* 117 */     if (i == 1) {
/* 118 */       stringBuilder.append('0');
/* 119 */       stringBuilder.append(str);
/* 120 */     } else if (i == 2) {
/* 121 */       stringBuilder.append(str);
/*     */     } else {
/* 123 */       stringBuilder.append("00");
/*     */     } 
/*     */ 
/*     */     
/* 127 */     i = paramCalendar.get(12);
/* 128 */     str = Integer.toString(i);
/* 129 */     i = str.length();
/*     */     
/* 131 */     if (i == 1) {
/* 132 */       stringBuilder.append('0');
/* 133 */       stringBuilder.append(str);
/* 134 */     } else if (i == 2) {
/* 135 */       stringBuilder.append(str);
/*     */     } else {
/* 137 */       stringBuilder.append("00");
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 142 */     i = paramCalendar.get(13);
/* 143 */     str = Integer.toString(i);
/* 144 */     i = str.length();
/*     */     
/* 146 */     if (i == 1) {
/* 147 */       stringBuilder.append('0');
/* 148 */       stringBuilder.append(str);
/* 149 */     } else if (i == 2) {
/* 150 */       stringBuilder.append(str);
/*     */     } else {
/* 152 */       stringBuilder.append("00");
/*     */     } 
/*     */     
/* 155 */     this.time = stringBuilder.toString();
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
/*     */   public void addNewsgroup(String paramString) {
/* 171 */     if (this.newsgroups != null) {
/* 172 */       this.newsgroups.append(',');
/*     */     } else {
/* 174 */       this.newsgroups = new StringBuffer();
/*     */     } 
/* 176 */     this.newsgroups.append(paramString);
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
/*     */   public void omitNewsgroup(String paramString) {
/* 200 */     addNewsgroup("!" + paramString);
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
/*     */   public void addDistribution(String paramString) {
/* 216 */     if (this.distributions != null) {
/* 217 */       this.distributions.append(',');
/*     */     } else {
/* 219 */       this.distributions = new StringBuffer();
/*     */     } 
/* 221 */     this.distributions.append(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDate() {
/* 232 */     return this.date;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTime() {
/* 243 */     return this.time;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isGMT() {
/* 253 */     return this.isGMT;
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
/*     */   public String getDistributions() {
/* 265 */     return (this.distributions == null) ? null : this.distributions.toString();
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
/*     */   public String getNewsgroups() {
/* 277 */     return (this.newsgroups == null) ? null : this.newsgroups.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\nntp\NewGroupsOrNewsQuery.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */