/*    */ package org.apache.poi.ss.formula.udf;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Locale;
/*    */ import java.util.Map;
/*    */ import org.apache.poi.ss.formula.functions.FreeRefFunction;
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
/*    */ public final class DefaultUDFFinder
/*    */   implements UDFFinder
/*    */ {
/*    */   private final Map<String, FreeRefFunction> _functionsByName;
/*    */   
/*    */   public DefaultUDFFinder(String[] paramArrayOfString, FreeRefFunction[] paramArrayOfFreeRefFunction) {
/* 35 */     int i = paramArrayOfString.length;
/* 36 */     if (paramArrayOfFreeRefFunction.length != i) {
/* 37 */       throw new IllegalArgumentException("Mismatch in number of function names and implementations");
/*    */     }
/*    */     
/* 40 */     HashMap<Object, Object> hashMap = new HashMap<Object, Object>(i * 3 / 2);
/* 41 */     for (byte b = 0; b < paramArrayOfFreeRefFunction.length; b++) {
/* 42 */       hashMap.put(paramArrayOfString[b].toUpperCase(Locale.ROOT), paramArrayOfFreeRefFunction[b]);
/*    */     }
/* 44 */     this._functionsByName = (Map)hashMap;
/*    */   }
/*    */ 
/*    */   
/*    */   public FreeRefFunction findFunction(String paramString) {
/* 49 */     return this._functionsByName.get(paramString.toUpperCase(Locale.ROOT));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formul\\udf\DefaultUDFFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */