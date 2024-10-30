/*    */ package org.apache.poi.ss.usermodel;
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
/*    */ public interface ConditionalFormattingThreshold
/*    */ {
/*    */   RangeType getRangeType();
/*    */   
/*    */   void setRangeType(RangeType paramRangeType);
/*    */   
/*    */   String getFormula();
/*    */   
/*    */   void setFormula(String paramString);
/*    */   
/*    */   Double getValue();
/*    */   
/*    */   void setValue(Double paramDouble);
/*    */   
/*    */   public enum RangeType
/*    */   {
/* 32 */     NUMBER(1, "num"),
/*    */     
/* 34 */     MIN(2, "min"),
/*    */     
/* 36 */     MAX(3, "max"),
/*    */     
/* 38 */     PERCENT(4, "percent"),
/*    */     
/* 40 */     PERCENTILE(5, "percentile"),
/* 41 */     UNALLOCATED(6, null),
/*    */     
/* 43 */     FORMULA(7, "formula");
/*    */     
/*    */     public final int id;
/*    */     
/*    */     public final String name;
/*    */ 
/*    */     
/*    */     public String toString() {
/* 51 */       return this.id + " - " + this.name;
/*    */     }
/*    */     
/*    */     public static RangeType byId(int param1Int) {
/* 55 */       return values()[param1Int - 1];
/*    */     }
/*    */     public static RangeType byName(String param1String) {
/* 58 */       for (RangeType rangeType : values()) {
/* 59 */         if (rangeType.name.equals(param1String)) return rangeType; 
/*    */       } 
/* 61 */       return null;
/*    */     }
/*    */     
/*    */     RangeType(int param1Int1, String param1String1) {
/* 65 */       this.id = param1Int1; this.name = param1String1;
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\ConditionalFormattingThreshold.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */