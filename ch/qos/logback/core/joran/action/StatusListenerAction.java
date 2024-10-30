/*    */ package ch.qos.logback.core.joran.action;
/*    */ 
/*    */ import ch.qos.logback.core.joran.spi.ActionException;
/*    */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*    */ import ch.qos.logback.core.spi.ContextAware;
/*    */ import ch.qos.logback.core.spi.LifeCycle;
/*    */ import ch.qos.logback.core.status.StatusListener;
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
/*    */ public class StatusListenerAction
/*    */   extends Action
/*    */ {
/*    */   boolean inError = false;
/* 28 */   Boolean effectivelyAdded = null;
/* 29 */   StatusListener statusListener = null;
/*    */   
/*    */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) throws ActionException {
/* 32 */     this.inError = false;
/* 33 */     this.effectivelyAdded = null;
/* 34 */     String str = paramAttributes.getValue("class");
/* 35 */     if (OptionHelper.isEmpty(str)) {
/* 36 */       addError("Missing class name for statusListener. Near [" + paramString + "] line " + getLineNumber(paramInterpretationContext));
/* 37 */       this.inError = true;
/*    */       
/*    */       return;
/*    */     } 
/*    */     try {
/* 42 */       this.statusListener = (StatusListener)OptionHelper.instantiateByClassName(str, StatusListener.class, this.context);
/* 43 */       this.effectivelyAdded = Boolean.valueOf(paramInterpretationContext.getContext().getStatusManager().add(this.statusListener));
/* 44 */       if (this.statusListener instanceof ContextAware) {
/* 45 */         ((ContextAware)this.statusListener).setContext(this.context);
/*    */       }
/* 47 */       addInfo("Added status listener of type [" + str + "]");
/* 48 */       paramInterpretationContext.pushObject(this.statusListener);
/* 49 */     } catch (Exception exception) {
/* 50 */       this.inError = true;
/* 51 */       addError("Could not create an StatusListener of type [" + str + "].", exception);
/* 52 */       throw new ActionException(exception);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void finish(InterpretationContext paramInterpretationContext) {}
/*    */ 
/*    */   
/*    */   public void end(InterpretationContext paramInterpretationContext, String paramString) {
/* 61 */     if (this.inError) {
/*    */       return;
/*    */     }
/* 64 */     if (isEffectivelyAdded() && this.statusListener instanceof LifeCycle) {
/* 65 */       ((LifeCycle)this.statusListener).start();
/*    */     }
/* 67 */     Object object = paramInterpretationContext.peekObject();
/* 68 */     if (object != this.statusListener) {
/* 69 */       addWarn("The object at the of the stack is not the statusListener pushed earlier.");
/*    */     } else {
/* 71 */       paramInterpretationContext.popObject();
/*    */     } 
/*    */   }
/*    */   
/*    */   private boolean isEffectivelyAdded() {
/* 76 */     if (this.effectivelyAdded == null)
/* 77 */       return false; 
/* 78 */     return this.effectivelyAdded.booleanValue();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\action\StatusListenerAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */