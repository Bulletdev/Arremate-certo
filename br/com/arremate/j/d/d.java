/*    */ package br.com.arremate.j.d;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class d
/*    */ {
/* 13 */   private final HashMap<Long, b> b = new HashMap<>();
/* 14 */   private final HashMap<Long, c> c = new HashMap<>();
/*    */ 
/*    */   
/*    */   public static d a() {
/* 18 */     return a.b();
/*    */   }
/*    */   
/*    */   public b a(br.com.arremate.l.d paramd, boolean paramBoolean) {
/* 22 */     synchronized (this.b) {
/*    */       b b;
/* 24 */       long l = paramd.x();
/*    */       
/* 26 */       if (!this.b.containsKey(Long.valueOf(l))) {
/* 27 */         b = new b(paramd, paramBoolean);
/* 28 */         if (l != 0L && b.z() == 1) {
/* 29 */           this.b.put(Long.valueOf(l), b);
/*    */         }
/*    */       } else {
/* 32 */         b = this.b.get(Long.valueOf(l));
/* 33 */         if (b.aa()) {
/* 34 */           b.b();
/* 35 */           this.b.remove(Long.valueOf(l));
/* 36 */           return b;
/*    */         } 
/*    */         
/* 39 */         b.bJ();
/*    */       } 
/*    */       
/* 42 */       return b;
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean a(b paramb) {
/* 47 */     synchronized (this.b) {
/* 48 */       if (paramb.A() > 1) {
/* 49 */         paramb.bK();
/* 50 */         return false;
/*    */       } 
/* 52 */       br.com.arremate.l.d d1 = paramb.a();
/* 53 */       this.b.remove(Long.valueOf(d1.x()));
/* 54 */       return true;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public c a(br.com.arremate.l.d paramd, boolean paramBoolean) {
/* 60 */     synchronized (this.c) {
/*    */       c c;
/* 62 */       long l = paramd.x();
/*    */       
/* 64 */       if (!this.c.containsKey(Long.valueOf(l))) {
/* 65 */         c = new c(paramd, paramBoolean);
/* 66 */         if (l != 0L && c.z() == 1) {
/* 67 */           this.c.put(Long.valueOf(l), c);
/*    */         }
/*    */       } else {
/* 70 */         c = this.c.get(Long.valueOf(l));
/* 71 */         if (c.aa()) {
/* 72 */           c.b();
/* 73 */           this.c.remove(Long.valueOf(l));
/* 74 */           return c;
/*    */         } 
/*    */         
/* 77 */         c.bJ();
/*    */       } 
/*    */       
/* 80 */       return c;
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean a(c paramc) {
/* 85 */     synchronized (this.c) {
/* 86 */       if (paramc.A() > 1) {
/* 87 */         paramc.bK();
/* 88 */         return false;
/*    */       } 
/* 90 */       br.com.arremate.l.d d1 = paramc.a();
/* 91 */       this.c.remove(Long.valueOf(d1.x()));
/* 92 */       return true;
/*    */     } 
/*    */   }
/*    */   
/*    */   private d() {}
/*    */   
/*    */   private static class a {
/* 99 */     private static final d a = new d();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\d\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */