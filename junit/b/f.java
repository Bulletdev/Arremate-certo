/*    */ package junit.b;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import org.junit.runner.b.a;
/*    */ import org.junit.runner.b.b;
/*    */ import org.junit.runner.b.c;
/*    */ import org.junit.runner.c;
/*    */ 
/*    */ public class f
/*    */   extends HashMap<c, i> {
/*    */   private static final long serialVersionUID = 1L;
/* 15 */   private static final f b = new f();
/*    */   
/*    */   public static f a() {
/* 18 */     return b;
/*    */   }
/*    */   
/*    */   public i a(c paramc) {
/* 22 */     if (paramc.gs()) {
/* 23 */       return b(paramc);
/*    */     }
/* 25 */     if (!containsKey(paramc)) {
/* 26 */       put(paramc, b(paramc));
/*    */     }
/* 28 */     return get(paramc);
/*    */   }
/*    */ 
/*    */   
/*    */   i b(c paramc) {
/* 33 */     if (paramc.gt()) {
/* 34 */       return new g(paramc);
/*    */     }
/* 36 */     n n = new n(paramc.getDisplayName());
/* 37 */     for (c c1 : paramc.getChildren()) {
/* 38 */       n.c(a(c1));
/*    */     }
/* 40 */     return n;
/*    */   }
/*    */ 
/*    */   
/*    */   public c a(m paramm, e parame) {
/* 45 */     c c = new c();
/* 46 */     c.a(new b(this, paramm)
/*    */         {
/*    */           public void a(a param1a) throws Exception {
/* 49 */             this.a.a(this.c.a(param1a.a()), param1a.e());
/*    */           }
/*    */ 
/*    */           
/*    */           public void a(c param1c) throws Exception {
/* 54 */             this.a.a(this.c.a(param1c));
/*    */           }
/*    */ 
/*    */           
/*    */           public void b(c param1c) throws Exception {
/* 59 */             this.a.b(this.c.a(param1c));
/*    */           }
/*    */         });
/* 62 */     return c;
/*    */   }
/*    */   
/*    */   public List<i> a(c paramc) {
/* 66 */     if (paramc.gt()) {
/* 67 */       return Arrays.asList(new i[] { a(paramc) });
/*    */     }
/* 69 */     ArrayList<i> arrayList = new ArrayList();
/* 70 */     for (c c1 : paramc.getChildren()) {
/* 71 */       arrayList.add(a(c1));
/*    */     }
/* 73 */     return arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\junit\b\f.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */