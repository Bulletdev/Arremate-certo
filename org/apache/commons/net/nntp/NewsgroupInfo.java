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
/*     */ public final class NewsgroupInfo
/*     */ {
/*     */   public static final int UNKNOWN_POSTING_PERMISSION = 0;
/*     */   public static final int MODERATED_POSTING_PERMISSION = 1;
/*     */   public static final int PERMITTED_POSTING_PERMISSION = 2;
/*     */   public static final int PROHIBITED_POSTING_PERMISSION = 3;
/*     */   private String newsgroup;
/*     */   private long estimatedArticleCount;
/*     */   private long firstArticle;
/*     */   private long lastArticle;
/*     */   private int postingPermission;
/*     */   
/*     */   void setNewsgroup(String paramString) {
/*  62 */     this.newsgroup = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   void setArticleCount(long paramLong) {
/*  67 */     this.estimatedArticleCount = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   void setFirstArticle(long paramLong) {
/*  72 */     this.firstArticle = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   void setLastArticle(long paramLong) {
/*  77 */     this.lastArticle = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   void setPostingPermission(int paramInt) {
/*  82 */     this.postingPermission = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNewsgroup() {
/*  92 */     return this.newsgroup;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getArticleCountLong() {
/* 103 */     return this.estimatedArticleCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getFirstArticleLong() {
/* 113 */     return this.firstArticle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLastArticleLong() {
/* 123 */     return this.lastArticle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPostingPermission() {
/* 134 */     return this.postingPermission;
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
/*     */   @Deprecated
/*     */   public int getArticleCount() {
/* 159 */     return (int)this.estimatedArticleCount;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public int getFirstArticle() {
/* 164 */     return (int)this.firstArticle;
/*     */   }
/*     */   
/*     */   @Deprecated
/*     */   public int getLastArticle() {
/* 169 */     return (int)this.lastArticle;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\nntp\NewsgroupInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */