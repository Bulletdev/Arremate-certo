/*    */ package ch.qos.logback.classic.pattern;
/*    */ 
/*    */ import ch.qos.logback.classic.spi.ILoggingEvent;
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
/*    */ public abstract class NamedConverter
/*    */   extends ClassicConverter
/*    */ {
/* 20 */   Abbreviator abbreviator = null;
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
/*    */   public void start() {
/* 32 */     String str = getFirstOption();
/* 33 */     if (str != null) {
/*    */       try {
/* 35 */         int i = Integer.parseInt(str);
/* 36 */         if (i == 0) {
/* 37 */           this.abbreviator = new ClassNameOnlyAbbreviator();
/* 38 */         } else if (i > 0) {
/* 39 */           this.abbreviator = new TargetLengthBasedClassNameAbbreviator(i);
/*    */         } 
/* 41 */       } catch (NumberFormatException numberFormatException) {}
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String convert(ILoggingEvent paramILoggingEvent) {
/* 48 */     String str = getFullyQualifiedName(paramILoggingEvent);
/*    */     
/* 50 */     if (this.abbreviator == null) {
/* 51 */       return str;
/*    */     }
/* 53 */     return this.abbreviator.abbreviate(str);
/*    */   }
/*    */   
/*    */   protected abstract String getFullyQualifiedName(ILoggingEvent paramILoggingEvent);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\pattern\NamedConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */