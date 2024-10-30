/*    */ package ch.qos.logback.classic.joran.action;
/*    */ 
/*    */ import ch.qos.logback.classic.Level;
/*    */ import ch.qos.logback.classic.Logger;
/*    */ import ch.qos.logback.classic.LoggerContext;
/*    */ import ch.qos.logback.core.joran.action.Action;
/*    */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*    */ import ch.qos.logback.core.util.OptionHelper;
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
/*    */ public class RootLoggerAction
/*    */   extends Action
/*    */ {
/*    */   Logger root;
/*    */   boolean inError = false;
/*    */   
/*    */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) {
/* 32 */     this.inError = false;
/*    */     
/* 34 */     LoggerContext loggerContext = (LoggerContext)this.context;
/* 35 */     this.root = loggerContext.getLogger("ROOT");
/*    */     
/* 37 */     String str = paramInterpretationContext.subst(paramAttributes.getValue("level"));
/* 38 */     if (!OptionHelper.isEmpty(str)) {
/* 39 */       Level level = Level.toLevel(str);
/* 40 */       addInfo("Setting level of ROOT logger to " + level);
/* 41 */       this.root.setLevel(level);
/*    */     } 
/* 43 */     paramInterpretationContext.pushObject(this.root);
/*    */   }
/*    */   
/*    */   public void end(InterpretationContext paramInterpretationContext, String paramString) {
/* 47 */     if (this.inError) {
/*    */       return;
/*    */     }
/* 50 */     Object object = paramInterpretationContext.peekObject();
/* 51 */     if (object != this.root) {
/* 52 */       addWarn("The object on the top the of the stack is not the root logger");
/* 53 */       addWarn("It is: " + object);
/*    */     } else {
/* 55 */       paramInterpretationContext.popObject();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void finish(InterpretationContext paramInterpretationContext) {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\joran\action\RootLoggerAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */