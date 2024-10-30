/*    */ package ch.qos.logback.classic.joran.action;
/*    */ 
/*    */ import ch.qos.logback.core.joran.action.Action;
/*    */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*    */ import org.xml.sax.Attributes;
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
/*    */ public class ContextNameAction
/*    */   extends Action
/*    */ {
/*    */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) {}
/*    */   
/*    */   public void body(InterpretationContext paramInterpretationContext, String paramString) {
/* 28 */     String str = paramInterpretationContext.subst(paramString);
/* 29 */     addInfo("Setting logger context name as [" + str + "]");
/*    */     try {
/* 31 */       this.context.setName(str);
/* 32 */     } catch (IllegalStateException illegalStateException) {
/* 33 */       addError("Failed to rename context [" + this.context.getName() + "] as [" + str + "]", illegalStateException);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void end(InterpretationContext paramInterpretationContext, String paramString) {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\joran\action\ContextNameAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */