/*    */ package ch.qos.logback.core.joran.action;
/*    */ 
/*    */ import ch.qos.logback.core.joran.spi.ActionException;
/*    */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*    */ import ch.qos.logback.core.util.CachingDateFormatter;
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
/*    */ public class TimestampAction
/*    */   extends Action
/*    */ {
/* 33 */   static String DATE_PATTERN_ATTRIBUTE = "datePattern";
/* 34 */   static String TIME_REFERENCE_ATTRIBUTE = "timeReference";
/* 35 */   static String CONTEXT_BIRTH = "contextBirth";
/*    */   
/*    */   boolean inError = false;
/*    */   
/*    */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) throws ActionException {
/*    */     long l;
/* 41 */     String str1 = paramAttributes.getValue("key");
/* 42 */     if (OptionHelper.isEmpty(str1)) {
/* 43 */       addError("Attribute named [key] cannot be empty");
/* 44 */       this.inError = true;
/*    */     } 
/* 46 */     String str2 = paramAttributes.getValue(DATE_PATTERN_ATTRIBUTE);
/* 47 */     if (OptionHelper.isEmpty(str2)) {
/* 48 */       addError("Attribute named [" + DATE_PATTERN_ATTRIBUTE + "] cannot be empty");
/* 49 */       this.inError = true;
/*    */     } 
/*    */     
/* 52 */     String str3 = paramAttributes.getValue(TIME_REFERENCE_ATTRIBUTE);
/*    */     
/* 54 */     if (CONTEXT_BIRTH.equalsIgnoreCase(str3)) {
/* 55 */       addInfo("Using context birth as time reference.");
/* 56 */       l = this.context.getBirthTime();
/*    */     } else {
/* 58 */       l = System.currentTimeMillis();
/* 59 */       addInfo("Using current interpretation time, i.e. now, as time reference.");
/*    */     } 
/*    */     
/* 62 */     if (this.inError) {
/*    */       return;
/*    */     }
/* 65 */     String str4 = paramAttributes.getValue("scope");
/* 66 */     ActionUtil.Scope scope = ActionUtil.stringToScope(str4);
/*    */     
/* 68 */     CachingDateFormatter cachingDateFormatter = new CachingDateFormatter(str2);
/* 69 */     String str5 = cachingDateFormatter.format(l);
/*    */     
/* 71 */     addInfo("Adding property to the context with key=\"" + str1 + "\" and value=\"" + str5 + "\" to the " + scope + " scope");
/* 72 */     ActionUtil.setProperty(paramInterpretationContext, str1, str5, scope);
/*    */   }
/*    */   
/*    */   public void end(InterpretationContext paramInterpretationContext, String paramString) throws ActionException {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\action\TimestampAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */