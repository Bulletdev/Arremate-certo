/*    */ package org.apache.poi.ss.formula.udf;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.Collection;
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
/*    */ public class AggregatingUDFFinder
/*    */   implements UDFFinder
/*    */ {
/* 37 */   public static final UDFFinder DEFAULT = new AggregatingUDFFinder(new UDFFinder[] { AnalysisToolPak.instance });
/*    */   
/*    */   private final Collection<UDFFinder> _usedToolPacks;
/*    */   
/*    */   public AggregatingUDFFinder(UDFFinder... paramVarArgs) {
/* 42 */     this._usedToolPacks = new ArrayList<UDFFinder>(paramVarArgs.length);
/* 43 */     this._usedToolPacks.addAll(Arrays.asList(paramVarArgs));
/*    */   }
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
/*    */   public FreeRefFunction findFunction(String paramString) {
/* 56 */     for (UDFFinder uDFFinder : this._usedToolPacks) {
/* 57 */       FreeRefFunction freeRefFunction = uDFFinder.findFunction(paramString);
/* 58 */       if (freeRefFunction != null) {
/* 59 */         return freeRefFunction;
/*    */       }
/*    */     } 
/* 62 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void add(UDFFinder paramUDFFinder) {
/* 71 */     this._usedToolPacks.add(paramUDFFinder);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formul\\udf\AggregatingUDFFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */