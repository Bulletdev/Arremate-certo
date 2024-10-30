/*    */ package ch.qos.logback.core.joran.action;
/*    */ 
/*    */ import ch.qos.logback.core.Appender;
/*    */ import ch.qos.logback.core.joran.spi.ActionException;
/*    */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*    */ import ch.qos.logback.core.util.OptionHelper;
/*    */ import java.util.HashMap;
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
/*    */ public class AppenderAction<E>
/*    */   extends Action
/*    */ {
/*    */   Appender<E> appender;
/*    */   private boolean inError = false;
/*    */   
/*    */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) throws ActionException {
/* 39 */     this.appender = null;
/* 40 */     this.inError = false;
/*    */     
/* 42 */     String str = paramAttributes.getValue("class");
/* 43 */     if (OptionHelper.isEmpty(str)) {
/* 44 */       addError("Missing class name for appender. Near [" + paramString + "] line " + getLineNumber(paramInterpretationContext));
/* 45 */       this.inError = true;
/*    */       
/*    */       return;
/*    */     } 
/*    */     try {
/* 50 */       addInfo("About to instantiate appender of type [" + str + "]");
/*    */       
/* 52 */       this.appender = (Appender<E>)OptionHelper.instantiateByClassName(str, Appender.class, this.context);
/*    */       
/* 54 */       this.appender.setContext(this.context);
/*    */       
/* 56 */       String str1 = paramInterpretationContext.subst(paramAttributes.getValue("name"));
/*    */       
/* 58 */       if (OptionHelper.isEmpty(str1)) {
/* 59 */         addWarn("No appender name given for appender of type " + str + "].");
/*    */       } else {
/* 61 */         this.appender.setName(str1);
/* 62 */         addInfo("Naming appender as [" + str1 + "]");
/*    */       } 
/*    */ 
/*    */ 
/*    */       
/* 67 */       HashMap<String, Appender<E>> hashMap = (HashMap)paramInterpretationContext.getObjectMap().get("APPENDER_BAG");
/*    */ 
/*    */       
/* 70 */       hashMap.put(str1, this.appender);
/*    */       
/* 72 */       paramInterpretationContext.pushObject(this.appender);
/* 73 */     } catch (Exception exception) {
/* 74 */       this.inError = true;
/* 75 */       addError("Could not create an Appender of type [" + str + "].", exception);
/* 76 */       throw new ActionException(exception);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void end(InterpretationContext paramInterpretationContext, String paramString) {
/* 85 */     if (this.inError) {
/*    */       return;
/*    */     }
/*    */     
/* 89 */     if (this.appender instanceof ch.qos.logback.core.spi.LifeCycle) {
/* 90 */       this.appender.start();
/*    */     }
/*    */     
/* 93 */     Object object = paramInterpretationContext.peekObject();
/*    */     
/* 95 */     if (object != this.appender) {
/* 96 */       addWarn("The object at the of the stack is not the appender named [" + this.appender.getName() + "] pushed earlier.");
/*    */     } else {
/* 98 */       paramInterpretationContext.popObject();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\action\AppenderAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */