/*    */ package ch.qos.logback.core.joran.action;
/*    */ 
/*    */ import ch.qos.logback.core.hook.ShutdownHookBase;
/*    */ import ch.qos.logback.core.joran.spi.ActionException;
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
/*    */ public class ShutdownHookAction
/*    */   extends Action
/*    */ {
/*    */   ShutdownHookBase hook;
/*    */   private boolean inError;
/*    */   
/*    */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) throws ActionException {
/* 42 */     this.hook = null;
/* 43 */     this.inError = false;
/*    */     
/* 45 */     String str = paramAttributes.getValue("class");
/* 46 */     if (OptionHelper.isEmpty(str)) {
/* 47 */       addError("Missing class name for shutdown hook. Near [" + paramString + "] line " + getLineNumber(paramInterpretationContext));
/* 48 */       this.inError = true;
/*    */       
/*    */       return;
/*    */     } 
/*    */     try {
/* 53 */       addInfo("About to instantiate shutdown hook of type [" + str + "]");
/*    */       
/* 55 */       this.hook = (ShutdownHookBase)OptionHelper.instantiateByClassName(str, ShutdownHookBase.class, this.context);
/* 56 */       this.hook.setContext(this.context);
/*    */       
/* 58 */       paramInterpretationContext.pushObject(this.hook);
/* 59 */     } catch (Exception exception) {
/* 60 */       this.inError = true;
/* 61 */       addError("Could not create a shutdown hook of type [" + str + "].", exception);
/* 62 */       throw new ActionException(exception);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void end(InterpretationContext paramInterpretationContext, String paramString) throws ActionException {
/* 72 */     if (this.inError) {
/*    */       return;
/*    */     }
/*    */     
/* 76 */     Object object = paramInterpretationContext.peekObject();
/* 77 */     if (object != this.hook) {
/* 78 */       addWarn("The object at the of the stack is not the hook pushed earlier.");
/*    */     } else {
/* 80 */       paramInterpretationContext.popObject();
/*    */       
/* 82 */       Thread thread = new Thread((Runnable)this.hook, "Logback shutdown hook [" + this.context.getName() + "]");
/*    */       
/* 84 */       this.context.putObject("SHUTDOWN_HOOK", thread);
/* 85 */       Runtime.getRuntime().addShutdownHook(thread);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\action\ShutdownHookAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */