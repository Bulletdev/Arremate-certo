/*    */ package org.c.a.b.q;
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
/*    */ public class d
/*    */ {
/* 22 */   public static final d e = new d(";", false);
/* 23 */   public static final d f = new d("GO", true);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final String lG;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final boolean cT;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public d(String paramString, boolean paramBoolean) {
/* 42 */     this.lG = paramString;
/* 43 */     this.cT = paramBoolean;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String eL() {
/* 50 */     return this.lG;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean fT() {
/* 57 */     return this.cT;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 62 */     return (this.cT ? "\n" : "") + this.lG;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 67 */     if (this == paramObject) return true; 
/* 68 */     if (paramObject == null || getClass() != paramObject.getClass()) return false;
/*    */     
/* 70 */     d d1 = (d)paramObject;
/*    */     
/* 72 */     return (this.cT == d1.cT && this.lG.equals(d1.lG));
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 77 */     int i = this.lG.hashCode();
/* 78 */     i = 31 * i + (this.cT ? 1 : 0);
/* 79 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\q\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */