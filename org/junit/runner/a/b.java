/*     */ package org.junit.runner.a;
/*     */ 
/*     */ import org.junit.runner.c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class b
/*     */ {
/*  21 */   public static final b b = new b()
/*     */     {
/*     */       public boolean b(c param1c) {
/*  24 */         return true;
/*     */       }
/*     */ 
/*     */       
/*     */       public String eY() {
/*  29 */         return "all tests";
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void I(Object param1Object) throws e {}
/*     */ 
/*     */ 
/*     */       
/*     */       public b a(b param1b) {
/*  39 */         return param1b;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static b a(c paramc) {
/*  48 */     return new b(paramc)
/*     */       {
/*     */         public boolean b(c param1c) {
/*  51 */           if (param1c.gt()) {
/*  52 */             return this.g.equals(param1c);
/*     */           }
/*     */ 
/*     */           
/*  56 */           for (c c1 : param1c.getChildren()) {
/*  57 */             if (b(c1)) {
/*  58 */               return true;
/*     */             }
/*     */           } 
/*  61 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public String eY() {
/*  66 */           return String.format("Method %s", new Object[] { this.g.getDisplayName() });
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean b(c paramc);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract String eY();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void I(Object paramObject) throws e {
/*  93 */     if (!(paramObject instanceof c)) {
/*     */       return;
/*     */     }
/*  96 */     c c = (c)paramObject;
/*  97 */     c.a(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b a(b paramb) {
/* 105 */     if (paramb == this || paramb == b) {
/* 106 */       return this;
/*     */     }
/* 108 */     b b1 = this;
/* 109 */     return new b(this, b1, paramb)
/*     */       {
/*     */         public boolean b(c param1c) {
/* 112 */           return (this.c.b(param1c) && this.d.b(param1c));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public String eY() {
/* 118 */           return this.c.eY() + " and " + this.d.eY();
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\runner\a\b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */