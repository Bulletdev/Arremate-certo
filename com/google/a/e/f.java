/*    */ package com.google.a.e;
/*    */ 
/*    */ import com.google.a.a.b;
/*    */ import com.google.a.b.s;
/*    */ import com.google.b.a.f;
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
/*    */ @f("Use Escapers.nullEscaper() or another methods from the *Escapers classes")
/*    */ @b
/*    */ public abstract class f
/*    */ {
/* 87 */   private final s<String, String> k = new s<String, String>(this)
/*    */     {
/*    */       public String apply(String param1String)
/*    */       {
/* 91 */         return this.a.escape(param1String);
/*    */       }
/*    */     };
/*    */ 
/*    */   
/*    */   public final s<String, String> l() {
/* 97 */     return this.k;
/*    */   }
/*    */   
/*    */   public abstract String escape(String paramString);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\e\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */