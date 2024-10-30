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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LoggerAction
/*    */   extends Action
/*    */ {
/*    */   public static final String LEVEL_ATTRIBUTE = "level";
/*    */   boolean inError = false;
/*    */   Logger logger;
/*    */   
/*    */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) {
/* 39 */     this.inError = false;
/* 40 */     this.logger = null;
/*    */     
/* 42 */     LoggerContext loggerContext = (LoggerContext)this.context;
/*    */     
/* 44 */     String str1 = paramInterpretationContext.subst(paramAttributes.getValue("name"));
/*    */     
/* 46 */     if (OptionHelper.isEmpty(str1)) {
/* 47 */       this.inError = true;
/* 48 */       String str4 = getLineColStr(paramInterpretationContext);
/* 49 */       String str5 = "No 'name' attribute in element " + paramString + ", around " + str4;
/* 50 */       addError(str5);
/*    */       
/*    */       return;
/*    */     } 
/* 54 */     this.logger = loggerContext.getLogger(str1);
/*    */     
/* 56 */     String str2 = paramInterpretationContext.subst(paramAttributes.getValue("level"));
/*    */     
/* 58 */     if (!OptionHelper.isEmpty(str2)) {
/* 59 */       if ("INHERITED".equalsIgnoreCase(str2) || "NULL".equalsIgnoreCase(str2)) {
/* 60 */         addInfo("Setting level of logger [" + str1 + "] to null, i.e. INHERITED");
/* 61 */         this.logger.setLevel(null);
/*    */       } else {
/* 63 */         Level level = Level.toLevel(str2);
/* 64 */         addInfo("Setting level of logger [" + str1 + "] to " + level);
/* 65 */         this.logger.setLevel(level);
/*    */       } 
/*    */     }
/*    */     
/* 69 */     String str3 = paramInterpretationContext.subst(paramAttributes.getValue("additivity"));
/* 70 */     if (!OptionHelper.isEmpty(str3)) {
/* 71 */       boolean bool = OptionHelper.toBoolean(str3, true);
/* 72 */       addInfo("Setting additivity of logger [" + str1 + "] to " + bool);
/* 73 */       this.logger.setAdditive(bool);
/*    */     } 
/* 75 */     paramInterpretationContext.pushObject(this.logger);
/*    */   }
/*    */   
/*    */   public void end(InterpretationContext paramInterpretationContext, String paramString) {
/* 79 */     if (this.inError) {
/*    */       return;
/*    */     }
/* 82 */     Object object = paramInterpretationContext.peekObject();
/* 83 */     if (object != this.logger) {
/* 84 */       addWarn("The object on the top the of the stack is not " + this.logger + " pushed earlier");
/* 85 */       addWarn("It is: " + object);
/*    */     } else {
/* 87 */       paramInterpretationContext.popObject();
/*    */     } 
/*    */   }
/*    */   
/*    */   public void finish(InterpretationContext paramInterpretationContext) {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\joran\action\LoggerAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */