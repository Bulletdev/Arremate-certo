/*     */ package org.c.a.b.a;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.util.List;
/*     */ import org.c.a.a.b.c;
/*     */ import org.c.a.a.b.d;
/*     */ import org.c.a.a.b.g;
/*     */ import org.c.a.a.b.h;
/*     */ import org.c.a.a.c;
/*     */ import org.c.a.a.c.b;
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
/*     */ public class f
/*     */   implements c
/*     */ {
/*     */   private final b a;
/*     */   private final org.c.a.b.e.a.a b;
/*     */   private final c a;
/*     */   private final g a;
/*     */   
/*     */   f(b paramb, org.c.a.b.e.a.a parama, c paramc) {
/*  35 */     this.a = (g)paramb;
/*  36 */     this.b = parama;
/*  37 */     this.a = (g)paramc;
/*  38 */     this.a = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public f(b paramb, org.c.a.b.e.a.a parama, c paramc, String paramString, List<h> paramList, List<d> paramList1) {
/*  43 */     this.a = (g)paramb;
/*  44 */     this.b = parama;
/*  45 */     this.a = (g)paramc;
/*  46 */     this.a = new a(paramString, paramList, paramList1);
/*     */   }
/*     */ 
/*     */   
/*     */   public b a() {
/*  51 */     return (b)this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public Connection getConnection() {
/*  56 */     return this.b.c();
/*     */   }
/*     */ 
/*     */   
/*     */   public c b() {
/*  61 */     return (c)this.a;
/*     */   }
/*     */ 
/*     */   
/*     */   public g a() {
/*  66 */     return this.a;
/*     */   }
/*     */   
/*     */   private static class a
/*     */     implements g {
/*     */     private final String sql;
/*     */     private final List<h> aj;
/*     */     private final List<d> ak;
/*     */     private boolean cx;
/*     */     
/*     */     private a(String param1String, List<h> param1List, List<d> param1List1) {
/*  77 */       this.sql = param1String;
/*  78 */       this.aj = param1List;
/*  79 */       this.ak = param1List1;
/*     */     }
/*     */ 
/*     */     
/*     */     public String ev() {
/*  84 */       return this.sql;
/*     */     }
/*     */ 
/*     */     
/*     */     public List<h> aG() {
/*  89 */       return this.aj;
/*     */     }
/*     */ 
/*     */     
/*     */     public List<d> getErrors() {
/*  94 */       return this.ak;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean fu() {
/*  99 */       return this.cx;
/*     */     }
/*     */ 
/*     */     
/*     */     public void aK(boolean param1Boolean) {
/* 104 */       this.cx = param1Boolean;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\a\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */