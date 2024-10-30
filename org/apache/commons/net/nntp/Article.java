/*     */ package org.apache.commons.net.nntp;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import org.apache.commons.net.util.NetConstants;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Article
/*     */   implements Threadable
/*     */ {
/*  43 */   private long articleNumber = -1L;
/*     */   private String subject;
/*     */   private String date;
/*     */   private String articleId;
/*     */   private String simplifiedSubject;
/*     */   
/*     */   public void addReference(String paramString) {
/*  50 */     if (paramString == null || paramString.isEmpty()) {
/*     */       return;
/*     */     }
/*  53 */     if (this.references == null) {
/*  54 */       this.references = new ArrayList<>();
/*     */     }
/*  56 */     this.isReply = true;
/*  57 */     Collections.addAll(this.references, paramString.split(" "));
/*     */   }
/*     */ 
/*     */   
/*     */   private String from;
/*     */   private ArrayList<String> references;
/*     */   
/*     */   public String[] getReferences() {
/*  65 */     if (this.references == null) {
/*  66 */       return NetConstants.EMPTY_STRING_ARRAY;
/*     */     }
/*  68 */     return this.references.<String>toArray(NetConstants.EMPTY_STRING_ARRAY);
/*     */   }
/*     */   
/*     */   private boolean isReply;
/*     */   public Article kid;
/*     */   public Article next;
/*     */   
/*     */   private void simplifySubject() {
/*  76 */     int i = 0;
/*  77 */     String str = getSubject();
/*  78 */     int j = str.length();
/*     */     
/*  80 */     boolean bool = false;
/*     */     
/*  82 */     while (!bool) {
/*  83 */       bool = true;
/*     */ 
/*     */ 
/*     */       
/*  87 */       while (i < j && str.charAt(i) == ' ') {
/*  88 */         i++;
/*     */       }
/*     */       
/*  91 */       if (i < j - 2 && (str
/*  92 */         .charAt(i) == 'r' || str.charAt(i) == 'R') && (str
/*  93 */         .charAt(i + 1) == 'e' || str.charAt(i + 1) == 'E'))
/*     */       {
/*  95 */         if (str.charAt(i + 2) == ':') {
/*  96 */           i += 3;
/*  97 */           bool = false;
/*  98 */         } else if (i < j - 2 && (str
/*     */ 
/*     */           
/* 101 */           .charAt(i + 2) == '[' || str.charAt(i + 2) == '(')) {
/*     */           
/* 103 */           int m = i + 3;
/*     */           
/* 105 */           while (m < j && str.charAt(m) >= '0' && str.charAt(m) <= '9') {
/* 106 */             m++;
/*     */           }
/*     */           
/* 109 */           if (m < j - 1 && (str
/* 110 */             .charAt(m) == ']' || str.charAt(m) == ')') && str
/* 111 */             .charAt(m + 1) == ':') {
/*     */             
/* 113 */             i = m + 2;
/* 114 */             bool = false;
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/* 119 */       if ("(no subject)".equals(this.simplifiedSubject)) {
/* 120 */         this.simplifiedSubject = "";
/*     */       }
/*     */       
/* 123 */       int k = j;
/*     */       
/* 125 */       while (k > i && str.charAt(k - 1) < ' ') {
/* 126 */         k--;
/*     */       }
/*     */       
/* 129 */       if (i == 0 && k == j) {
/* 130 */         this.simplifiedSubject = str; continue;
/*     */       } 
/* 132 */       this.simplifiedSubject = str.substring(i, k);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void printThread(Article paramArticle) {
/* 144 */     printThread(paramArticle, 0, System.out);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void printThread(Article paramArticle, PrintStream paramPrintStream) {
/* 155 */     printThread(paramArticle, 0, paramPrintStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void printThread(Article paramArticle, int paramInt) {
/* 165 */     printThread(paramArticle, paramInt, System.out);
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
/*     */   public static void printThread(Article paramArticle, int paramInt, PrintStream paramPrintStream) {
/* 177 */     for (byte b = 0; b < paramInt; b++) {
/* 178 */       paramPrintStream.print("==>");
/*     */     }
/* 180 */     paramPrintStream.println(paramArticle.getSubject() + "\t" + paramArticle.getFrom() + "\t" + paramArticle.getArticleId());
/* 181 */     if (paramArticle.kid != null) {
/* 182 */       printThread(paramArticle.kid, paramInt + 1);
/*     */     }
/* 184 */     if (paramArticle.next != null) {
/* 185 */       printThread(paramArticle.next, paramInt);
/*     */     }
/*     */   }
/*     */   
/*     */   public String getArticleId() {
/* 190 */     return this.articleId;
/*     */   }
/*     */   
/*     */   public long getArticleNumberLong() {
/* 194 */     return this.articleNumber;
/*     */   }
/*     */   
/*     */   public String getDate() {
/* 198 */     return this.date;
/*     */   }
/*     */   
/*     */   public String getFrom() {
/* 202 */     return this.from;
/*     */   }
/*     */   
/*     */   public String getSubject() {
/* 206 */     return this.subject;
/*     */   }
/*     */   
/*     */   public void setArticleId(String paramString) {
/* 210 */     this.articleId = paramString;
/*     */   }
/*     */   
/*     */   public void setArticleNumber(long paramLong) {
/* 214 */     this.articleNumber = paramLong;
/*     */   }
/*     */   
/*     */   public void setDate(String paramString) {
/* 218 */     this.date = paramString;
/*     */   }
/*     */   
/*     */   public void setFrom(String paramString) {
/* 222 */     this.from = paramString;
/*     */   }
/*     */   
/*     */   public void setSubject(String paramString) {
/* 226 */     this.subject = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDummy() {
/* 232 */     return (this.articleNumber == -1L);
/*     */   }
/*     */ 
/*     */   
/*     */   public String messageThreadId() {
/* 237 */     return this.articleId;
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] messageThreadReferences() {
/* 242 */     return getReferences();
/*     */   }
/*     */ 
/*     */   
/*     */   public String simplifiedSubject() {
/* 247 */     if (this.simplifiedSubject == null) {
/* 248 */       simplifySubject();
/*     */     }
/* 250 */     return this.simplifiedSubject;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean subjectIsReply() {
/* 256 */     return this.isReply;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setChild(Threadable paramThreadable) {
/* 262 */     this.kid = (Article)paramThreadable;
/* 263 */     flushSubjectCache();
/*     */   }
/*     */   
/*     */   private void flushSubjectCache() {
/* 267 */     this.simplifiedSubject = null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNext(Threadable paramThreadable) {
/* 273 */     this.next = (Article)paramThreadable;
/* 274 */     flushSubjectCache();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Threadable makeDummy() {
/* 280 */     return new Article();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 285 */     return this.articleNumber + " " + this.articleId + " " + this.subject;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public int getArticleNumber() {
/* 292 */     return (int)this.articleNumber;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public void setArticleNumber(int paramInt) {
/* 297 */     this.articleNumber = paramInt;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public void addHeaderField(String paramString1, String paramString2) {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\nntp\Article.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */