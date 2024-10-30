/*    */ package org.junit.a.e;
/*    */ 
/*    */ public abstract class g
/*    */ {
/*    */   public static class a
/*    */     extends Exception
/*    */   {
/*    */     private static final long serialVersionUID = 1L;
/*    */     
/*    */     public a() {}
/*    */     
/*    */     public a(Throwable param1Throwable) {
/* 13 */       super(param1Throwable);
/*    */     }
/*    */   }
/*    */   
/*    */   public static g a(final String name, Object paramObject) {
/* 18 */     return new g(paramObject)
/*    */       {
/*    */         public Object getValue() {
/* 21 */           return this.D;
/*    */         }
/*    */ 
/*    */         
/*    */         public String toString() {
/* 26 */           return String.format("[%s]", new Object[] { this.D });
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         public String getDescription() {
/*    */           String str;
/* 33 */           if (this.D == null) {
/* 34 */             str = "null";
/*    */           } else {
/*    */             try {
/* 37 */               str = String.format("\"%s\"", new Object[] { this.D });
/* 38 */             } catch (Throwable throwable) {
/* 39 */               str = String.format("[toString() threw %s: %s]", new Object[] { throwable.getClass().getSimpleName(), throwable.getMessage() });
/*    */             } 
/*    */           } 
/*    */ 
/*    */           
/* 44 */           return String.format("%s <from %s>", new Object[] { str, this.val$name });
/*    */         }
/*    */       };
/*    */   }
/*    */   
/*    */   public abstract Object getValue() throws a;
/*    */   
/*    */   public abstract String getDescription() throws a;
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\a\e\g.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */