/*     */ package org.apache.http.config;
/*     */ 
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
/*     */ public class MessageConstraints
/*     */   implements Cloneable
/*     */ {
/*  44 */   public static final MessageConstraints DEFAULT = (new Builder()).build();
/*     */   
/*     */   private final int maxLineLength;
/*     */   
/*     */   private final int maxHeaderCount;
/*     */   
/*     */   MessageConstraints(int paramInt1, int paramInt2) {
/*  51 */     this.maxLineLength = paramInt1;
/*  52 */     this.maxHeaderCount = paramInt2;
/*     */   }
/*     */   
/*     */   public int getMaxLineLength() {
/*  56 */     return this.maxLineLength;
/*     */   }
/*     */   
/*     */   public int getMaxHeaderCount() {
/*  60 */     return this.maxHeaderCount;
/*     */   }
/*     */ 
/*     */   
/*     */   protected MessageConstraints clone() throws CloneNotSupportedException {
/*  65 */     return (MessageConstraints)super.clone();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  70 */     StringBuilder stringBuilder = new StringBuilder();
/*  71 */     stringBuilder.append("[maxLineLength=").append(this.maxLineLength).append(", maxHeaderCount=").append(this.maxHeaderCount).append("]");
/*     */ 
/*     */     
/*  74 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public static MessageConstraints lineLen(int paramInt) {
/*  78 */     return new MessageConstraints(Args.notNegative(paramInt, "Max line length"), -1);
/*     */   }
/*     */   
/*     */   public static Builder custom() {
/*  82 */     return new Builder();
/*     */   }
/*     */   
/*     */   public static Builder copy(MessageConstraints paramMessageConstraints) {
/*  86 */     Args.notNull(paramMessageConstraints, "Message constraints");
/*  87 */     return (new Builder()).setMaxHeaderCount(paramMessageConstraints.getMaxHeaderCount()).setMaxLineLength(paramMessageConstraints.getMaxLineLength());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Builder
/*     */   {
/*  98 */     private int maxLineLength = -1;
/*  99 */     private int maxHeaderCount = -1;
/*     */ 
/*     */     
/*     */     public Builder setMaxLineLength(int param1Int) {
/* 103 */       this.maxLineLength = param1Int;
/* 104 */       return this;
/*     */     }
/*     */     
/*     */     public Builder setMaxHeaderCount(int param1Int) {
/* 108 */       this.maxHeaderCount = param1Int;
/* 109 */       return this;
/*     */     }
/*     */     
/*     */     public MessageConstraints build() {
/* 113 */       return new MessageConstraints(this.maxLineLength, this.maxHeaderCount);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\config\MessageConstraints.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */