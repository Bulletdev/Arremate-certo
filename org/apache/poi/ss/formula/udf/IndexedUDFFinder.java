/*    */ package org.apache.poi.ss.formula.udf;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import org.apache.poi.ss.formula.functions.FreeRefFunction;
/*    */ import org.apache.poi.util.Internal;
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
/*    */ @Internal
/*    */ public class IndexedUDFFinder
/*    */   extends AggregatingUDFFinder
/*    */ {
/*    */   private final HashMap<Integer, String> _funcMap;
/*    */   
/*    */   public IndexedUDFFinder(UDFFinder... paramVarArgs) {
/* 34 */     super(paramVarArgs);
/* 35 */     this._funcMap = new HashMap<Integer, String>();
/*    */   }
/*    */ 
/*    */   
/*    */   public FreeRefFunction findFunction(String paramString) {
/* 40 */     FreeRefFunction freeRefFunction = super.findFunction(paramString);
/* 41 */     if (freeRefFunction != null) {
/* 42 */       int i = getFunctionIndex(paramString);
/* 43 */       this._funcMap.put(Integer.valueOf(i), paramString);
/*    */     } 
/* 45 */     return freeRefFunction;
/*    */   }
/*    */   
/*    */   public String getFunctionName(int paramInt) {
/* 49 */     return this._funcMap.get(Integer.valueOf(paramInt));
/*    */   }
/*    */   
/*    */   public int getFunctionIndex(String paramString) {
/* 53 */     return paramString.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formul\\udf\IndexedUDFFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */