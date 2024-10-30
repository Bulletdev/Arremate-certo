/*    */ package org.apache.poi.ss.formula.udf;
/*    */ 
/*    */ import org.apache.poi.ss.formula.atp.AnalysisToolPak;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface UDFFinder
/*    */ {
/*    */   @Deprecated
/* 35 */   public static final UDFFinder DEFAULT = new AggregatingUDFFinder(new UDFFinder[] { AnalysisToolPak.instance });
/*    */   
/*    */   FreeRefFunction findFunction(String paramString);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formul\\udf\UDFFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */