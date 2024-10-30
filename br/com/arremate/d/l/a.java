/*    */ package br.com.arremate.d.l;
/*    */ 
/*    */ public class a
/*    */ {
/*    */   private String description;
/*    */   private int count;
/*    */   
/*    */   public a(String paramString) {
/*  9 */     this.description = paramString;
/*    */   }
/*    */   
/*    */   public a(String paramString, int paramInt) {
/* 13 */     this.description = paramString;
/* 14 */     this.count = paramInt;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 18 */     return this.description;
/*    */   }
/*    */   
/*    */   public void setDescription(String paramString) {
/* 22 */     this.description = paramString;
/*    */   }
/*    */   
/*    */   public int getCount() {
/* 26 */     return this.count;
/*    */   }
/*    */   
/*    */   public void J(int paramInt) {
/* 30 */     this.count = paramInt;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object paramObject) {
/* 35 */     return this.description.equals(((a)paramObject).getDescription());
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 40 */     return this.description.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\l\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */