/*    */ package ch.qos.logback.core.rolling;
/*    */ 
/*    */ import ch.qos.logback.core.util.DefaultInvocationGate;
/*    */ import ch.qos.logback.core.util.FileSize;
/*    */ import ch.qos.logback.core.util.InvocationGate;
/*    */ import java.io.File;
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
/*    */ public class SizeBasedTriggeringPolicy<E>
/*    */   extends TriggeringPolicyBase<E>
/*    */ {
/*    */   public static final String SEE_SIZE_FORMAT = "http://logback.qos.ch/codes.html#sbtp_size_format";
/*    */   public static final long DEFAULT_MAX_FILE_SIZE = 10485760L;
/* 41 */   FileSize maxFileSize = new FileSize(10485760L);
/*    */   
/*    */   InvocationGate invocationGate;
/*    */   
/*    */   public SizeBasedTriggeringPolicy() {
/* 46 */     this.invocationGate = (InvocationGate)new DefaultInvocationGate();
/*    */   }
/*    */   public boolean isTriggeringEvent(File paramFile, E paramE) {
/* 49 */     long l = System.currentTimeMillis();
/* 50 */     if (this.invocationGate.isTooSoon(l)) {
/* 51 */       return false;
/*    */     }
/* 53 */     return (paramFile.length() >= this.maxFileSize.getSize());
/*    */   }
/*    */   
/*    */   public void setMaxFileSize(FileSize paramFileSize) {
/* 57 */     this.maxFileSize = paramFileSize;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\rolling\SizeBasedTriggeringPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */