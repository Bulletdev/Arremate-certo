/*    */ package ch.qos.logback.core.joran.action;
/*    */ 
/*    */ import ch.qos.logback.core.Appender;
/*    */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*    */ import ch.qos.logback.core.spi.AppenderAttachable;
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
/*    */ public class AppenderRefAction<E>
/*    */   extends Action
/*    */ {
/*    */   boolean inError = false;
/*    */   
/*    */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) {
/* 32 */     this.inError = false;
/*    */ 
/*    */ 
/*    */     
/* 36 */     Object object = paramInterpretationContext.peekObject();
/*    */     
/* 38 */     if (!(object instanceof AppenderAttachable)) {
/* 39 */       String str1 = "Could not find an AppenderAttachable at the top of execution stack. Near [" + paramString + "] line " + getLineNumber(paramInterpretationContext);
/* 40 */       this.inError = true;
/* 41 */       addError(str1);
/*    */       
/*    */       return;
/*    */     } 
/* 45 */     AppenderAttachable appenderAttachable = (AppenderAttachable)object;
/*    */     
/* 47 */     String str = paramInterpretationContext.subst(paramAttributes.getValue("ref"));
/*    */     
/* 49 */     if (OptionHelper.isEmpty(str)) {
/*    */       
/* 51 */       String str1 = "Missing appender ref attribute in <appender-ref> tag.";
/* 52 */       this.inError = true;
/* 53 */       addError(str1);
/*    */       
/*    */       return;
/*    */     } 
/*    */     
/* 58 */     HashMap hashMap = (HashMap)paramInterpretationContext.getObjectMap().get("APPENDER_BAG");
/* 59 */     Appender appender = (Appender)hashMap.get(str);
/*    */     
/* 61 */     if (appender == null) {
/* 62 */       String str1 = "Could not find an appender named [" + str + "]. Did you define it below instead of above in the configuration file?";
/* 63 */       this.inError = true;
/* 64 */       addError(str1);
/* 65 */       addError("See http://logback.qos.ch/codes.html#appender_order for more details.");
/*    */       
/*    */       return;
/*    */     } 
/* 69 */     addInfo("Attaching appender named [" + str + "] to " + appenderAttachable);
/* 70 */     appenderAttachable.addAppender(appender);
/*    */   }
/*    */   
/*    */   public void end(InterpretationContext paramInterpretationContext, String paramString) {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\action\AppenderRefAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */