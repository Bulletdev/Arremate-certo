/*    */ package ch.qos.logback.classic.spi;
/*    */ 
/*    */ import java.io.Serializable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StackTraceElementProxy
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -2374374378980555982L;
/*    */   final StackTraceElement ste;
/*    */   private transient String steAsString;
/*    */   private ClassPackagingData cpd;
/*    */   
/*    */   public StackTraceElementProxy(StackTraceElement paramStackTraceElement) {
/* 29 */     if (paramStackTraceElement == null) {
/* 30 */       throw new IllegalArgumentException("ste cannot be null");
/*    */     }
/* 32 */     this.ste = paramStackTraceElement;
/*    */   }
/*    */   
/*    */   public String getSTEAsString() {
/* 36 */     if (this.steAsString == null) {
/* 37 */       this.steAsString = "at " + this.ste.toString();
/*    */     }
/* 39 */     return this.steAsString;
/*    */   }
/*    */   
/*    */   public StackTraceElement getStackTraceElement() {
/* 43 */     return this.ste;
/*    */   }
/*    */   
/*    */   public void setClassPackagingData(ClassPackagingData paramClassPackagingData) {
/* 47 */     if (this.cpd != null) {
/* 48 */       throw new IllegalStateException("Packaging data has been already set");
/*    */     }
/* 50 */     this.cpd = paramClassPackagingData;
/*    */   }
/*    */   
/*    */   public ClassPackagingData getClassPackagingData() {
/* 54 */     return this.cpd;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 59 */     return this.ste.hashCode();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 64 */     if (this == paramObject)
/* 65 */       return true; 
/* 66 */     if (paramObject == null)
/* 67 */       return false; 
/* 68 */     if (getClass() != paramObject.getClass())
/* 69 */       return false; 
/* 70 */     StackTraceElementProxy stackTraceElementProxy = (StackTraceElementProxy)paramObject;
/*    */     
/* 72 */     if (!this.ste.equals(stackTraceElementProxy.ste)) {
/* 73 */       return false;
/*    */     }
/* 75 */     if (this.cpd == null) {
/* 76 */       if (stackTraceElementProxy.cpd != null) {
/* 77 */         return false;
/*    */       }
/* 79 */     } else if (!this.cpd.equals(stackTraceElementProxy.cpd)) {
/* 80 */       return false;
/*    */     } 
/* 82 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 87 */     return getSTEAsString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\spi\StackTraceElementProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */