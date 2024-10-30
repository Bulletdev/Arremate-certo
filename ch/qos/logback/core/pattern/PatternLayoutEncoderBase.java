/*    */ package ch.qos.logback.core.pattern;
/*    */ 
/*    */ import ch.qos.logback.core.Layout;
/*    */ import ch.qos.logback.core.encoder.LayoutWrappingEncoder;
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
/*    */ public class PatternLayoutEncoderBase<E>
/*    */   extends LayoutWrappingEncoder<E>
/*    */ {
/*    */   String pattern;
/*    */   protected boolean outputPatternAsHeader = false;
/*    */   
/*    */   public String getPattern() {
/* 27 */     return this.pattern;
/*    */   }
/*    */   
/*    */   public void setPattern(String paramString) {
/* 31 */     this.pattern = paramString;
/*    */   }
/*    */   
/*    */   public boolean isOutputPatternAsHeader() {
/* 35 */     return this.outputPatternAsHeader;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setOutputPatternAsHeader(boolean paramBoolean) {
/* 45 */     this.outputPatternAsHeader = paramBoolean;
/*    */   }
/*    */   
/*    */   public boolean isOutputPatternAsPresentationHeader() {
/* 49 */     return this.outputPatternAsHeader;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setOutputPatternAsPresentationHeader(boolean paramBoolean) {
/* 56 */     addWarn("[outputPatternAsPresentationHeader] property is deprecated. Please use [outputPatternAsHeader] option instead.");
/* 57 */     this.outputPatternAsHeader = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public void setLayout(Layout<E> paramLayout) {
/* 62 */     throw new UnsupportedOperationException("one cannot set the layout of " + getClass().getName());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\pattern\PatternLayoutEncoderBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */