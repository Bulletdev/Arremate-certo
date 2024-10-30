/*    */ package ch.qos.logback.classic.joran.action;
/*    */ 
/*    */ import ch.qos.logback.core.joran.action.Action;
/*    */ import ch.qos.logback.core.joran.action.ActionUtil;
/*    */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*    */ import ch.qos.logback.core.util.JNDIUtil;
/*    */ import ch.qos.logback.core.util.OptionHelper;
/*    */ import javax.naming.Context;
/*    */ import javax.naming.NamingException;
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
/*    */ public class InsertFromJNDIAction
/*    */   extends Action
/*    */ {
/*    */   public static final String ENV_ENTRY_NAME_ATTR = "env-entry-name";
/*    */   public static final String AS_ATTR = "as";
/*    */   
/*    */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) {
/* 41 */     byte b = 0;
/* 42 */     String str1 = paramInterpretationContext.subst(paramAttributes.getValue("env-entry-name"));
/* 43 */     String str2 = paramInterpretationContext.subst(paramAttributes.getValue("as"));
/*    */     
/* 45 */     String str3 = paramAttributes.getValue("scope");
/* 46 */     ActionUtil.Scope scope = ActionUtil.stringToScope(str3);
/*    */ 
/*    */ 
/*    */     
/* 50 */     if (OptionHelper.isEmpty(str1)) {
/* 51 */       String str = getLineColStr(paramInterpretationContext);
/* 52 */       addError("[env-entry-name] missing, around " + str);
/* 53 */       b++;
/*    */     } 
/*    */     
/* 56 */     if (OptionHelper.isEmpty(str2)) {
/* 57 */       String str = getLineColStr(paramInterpretationContext);
/* 58 */       addError("[as] missing, around " + str);
/* 59 */       b++;
/*    */     } 
/*    */     
/* 62 */     if (b != 0) {
/*    */       return;
/*    */     }
/*    */     
/*    */     try {
/* 67 */       Context context = JNDIUtil.getInitialContext();
/* 68 */       String str = JNDIUtil.lookupString(context, str1);
/* 69 */       if (OptionHelper.isEmpty(str)) {
/* 70 */         addError("[" + str1 + "] has null or empty value");
/*    */       } else {
/* 72 */         addInfo("Setting variable [" + str2 + "] to [" + str + "] in [" + scope + "] scope");
/* 73 */         ActionUtil.setProperty(paramInterpretationContext, str2, str, scope);
/*    */       } 
/* 75 */     } catch (NamingException namingException) {
/* 76 */       addError("Failed to lookup JNDI env-entry [" + str1 + "]", namingException);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void end(InterpretationContext paramInterpretationContext, String paramString) {}
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\joran\action\InsertFromJNDIAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */