/*    */ package ch.qos.logback.core.util;
/*    */ 
/*    */ import java.util.Hashtable;
/*    */ import javax.naming.Context;
/*    */ import javax.naming.InitialContext;
/*    */ import javax.naming.NamingException;
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
/*    */ public class JNDIUtil
/*    */ {
/*    */   static final String RESTRICTION_MSG = "JNDI name must start with java: but was ";
/*    */   
/*    */   public static Context getInitialContext() throws NamingException {
/* 38 */     return new InitialContext();
/*    */   }
/*    */   
/*    */   public static Context getInitialContext(Hashtable<?, ?> paramHashtable) throws NamingException {
/* 42 */     return new InitialContext(paramHashtable);
/*    */   }
/*    */   
/*    */   public static Object lookupObject(Context paramContext, String paramString) throws NamingException {
/* 46 */     if (paramContext == null) {
/* 47 */       return null;
/*    */     }
/*    */     
/* 50 */     if (OptionHelper.isEmpty(paramString)) {
/* 51 */       return null;
/*    */     }
/*    */     
/* 54 */     jndiNameSecurityCheck(paramString);
/*    */     
/* 56 */     return paramContext.lookup(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   private static void jndiNameSecurityCheck(String paramString) throws NamingException {
/* 61 */     if (!paramString.startsWith("java:")) {
/* 62 */       throw new NamingException("JNDI name must start with java: but was " + paramString);
/*    */     }
/*    */   }
/*    */   
/*    */   public static String lookupString(Context paramContext, String paramString) throws NamingException {
/* 67 */     Object object = lookupObject(paramContext, paramString);
/* 68 */     return (String)object;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\cor\\util\JNDIUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */