/*     */ package org.apache.xmlbeans.impl.soap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SOAPException
/*     */   extends Exception
/*     */ {
/*     */   private Throwable cause;
/*     */   
/*     */   public SOAPException() {
/*  41 */     this.cause = null;
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
/*     */   public SOAPException(String paramString) {
/*  53 */     super(paramString);
/*     */     
/*  55 */     this.cause = null;
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
/*     */   public SOAPException(String paramString, Throwable paramThrowable) {
/*  71 */     super(paramString);
/*     */     
/*  73 */     initCause(paramThrowable);
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
/*     */   public SOAPException(Throwable paramThrowable) {
/*  86 */     super(paramThrowable.toString());
/*     */     
/*  88 */     initCause(paramThrowable);
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
/*     */   public String getMessage() {
/* 107 */     String str = super.getMessage();
/*     */     
/* 109 */     if (str == null && this.cause != null) {
/* 110 */       return this.cause.getMessage();
/*     */     }
/* 112 */     return str;
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
/*     */   public Throwable getCause() {
/* 124 */     return this.cause;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized Throwable initCause(Throwable paramThrowable) {
/* 163 */     if (this.cause != null) {
/* 164 */       throw new IllegalStateException("Can't override cause");
/*     */     }
/*     */     
/* 167 */     if (paramThrowable == this) {
/* 168 */       throw new IllegalArgumentException("Self-causation not permitted");
/*     */     }
/* 170 */     this.cause = paramThrowable;
/*     */     
/* 172 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\soap\SOAPException.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */