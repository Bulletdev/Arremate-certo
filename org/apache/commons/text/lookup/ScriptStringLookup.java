/*    */ package org.apache.commons.text.lookup;
/*    */ 
/*    */ import java.util.Objects;
/*    */ import javax.script.ScriptEngine;
/*    */ import javax.script.ScriptEngineManager;
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
/*    */ final class ScriptStringLookup
/*    */   extends AbstractStringLookup
/*    */ {
/* 50 */   static final ScriptStringLookup INSTANCE = new ScriptStringLookup();
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
/*    */   public String lookup(String paramString) {
/* 70 */     if (paramString == null) {
/* 71 */       return null;
/*    */     }
/* 73 */     String[] arrayOfString = paramString.split(SPLIT_STR, 2);
/* 74 */     int i = arrayOfString.length;
/* 75 */     if (i != 2) {
/* 76 */       throw IllegalArgumentExceptions.format("Bad script key format [%s]; expected format is EngineName:Script.", new Object[] { paramString });
/*    */     }
/*    */     
/* 79 */     String str1 = arrayOfString[0];
/* 80 */     String str2 = arrayOfString[1];
/*    */     try {
/* 82 */       ScriptEngine scriptEngine = (new ScriptEngineManager()).getEngineByName(str1);
/* 83 */       if (scriptEngine == null) {
/* 84 */         throw new IllegalArgumentException("No script engine named " + str1);
/*    */       }
/* 86 */       return Objects.toString(scriptEngine.eval(str2), null);
/* 87 */     } catch (Exception exception) {
/* 88 */       throw IllegalArgumentExceptions.format(exception, "Error in script engine [%s] evaluating script [%s].", new Object[] { str1, str2 });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\lookup\ScriptStringLookup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */