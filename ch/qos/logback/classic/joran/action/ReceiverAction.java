/*    */ package ch.qos.logback.classic.joran.action;
/*    */ 
/*    */ import ch.qos.logback.classic.net.ReceiverBase;
/*    */ import ch.qos.logback.core.joran.action.Action;
/*    */ import ch.qos.logback.core.joran.spi.ActionException;
/*    */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*    */ import ch.qos.logback.core.spi.LifeCycle;
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
/*    */ public class ReceiverAction
/*    */   extends Action
/*    */ {
/*    */   private ReceiverBase receiver;
/*    */   private boolean inError;
/*    */   
/*    */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) throws ActionException {
/* 38 */     String str = paramAttributes.getValue("class");
/* 39 */     if (OptionHelper.isEmpty(str)) {
/* 40 */       addError("Missing class name for receiver. Near [" + paramString + "] line " + getLineNumber(paramInterpretationContext));
/* 41 */       this.inError = true;
/*    */       
/*    */       return;
/*    */     } 
/*    */     try {
/* 46 */       addInfo("About to instantiate receiver of type [" + str + "]");
/*    */       
/* 48 */       this.receiver = (ReceiverBase)OptionHelper.instantiateByClassName(str, ReceiverBase.class, this.context);
/* 49 */       this.receiver.setContext(this.context);
/*    */       
/* 51 */       paramInterpretationContext.pushObject(this.receiver);
/* 52 */     } catch (Exception exception) {
/* 53 */       this.inError = true;
/* 54 */       addError("Could not create a receiver of type [" + str + "].", exception);
/* 55 */       throw new ActionException(exception);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void end(InterpretationContext paramInterpretationContext, String paramString) throws ActionException {
/* 62 */     if (this.inError) {
/*    */       return;
/*    */     }
/* 65 */     paramInterpretationContext.getContext().register((LifeCycle)this.receiver);
/* 66 */     this.receiver.start();
/*    */     
/* 68 */     Object object = paramInterpretationContext.peekObject();
/* 69 */     if (object != this.receiver) {
/* 70 */       addWarn("The object at the of the stack is not the remote pushed earlier.");
/*    */     } else {
/* 72 */       paramInterpretationContext.popObject();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\joran\action\ReceiverAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */