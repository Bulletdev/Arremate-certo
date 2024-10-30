/*     */ package junit.b;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.junit.k;
/*     */ import org.junit.runner.a.b;
/*     */ import org.junit.runner.a.c;
/*     */ import org.junit.runner.a.d;
/*     */ import org.junit.runner.a.f;
/*     */ import org.junit.runner.a.g;
/*     */ import org.junit.runner.a.j;
/*     */ import org.junit.runner.b;
/*     */ import org.junit.runner.c;
/*     */ import org.junit.runner.j;
/*     */ import org.junit.runner.m;
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
/*     */ public class e
/*     */   implements i, c, f, b
/*     */ {
/*     */   private final Class<?> g;
/*     */   private final m a;
/*     */   private final f a;
/*     */   
/*     */   public e(Class<?> paramClass) {
/*  36 */     this(paramClass, f.a());
/*     */   }
/*     */   
/*     */   public e(Class<?> paramClass, f paramf) {
/*  40 */     this.a = paramf;
/*  41 */     this.g = paramClass;
/*  42 */     this.a = (f)j.b(paramClass).a();
/*     */   }
/*     */   
/*     */   public int bc() {
/*  46 */     return this.a.bg();
/*     */   }
/*     */   
/*     */   public void a(m paramm) {
/*  50 */     this.a.a(this.a.a(paramm, this));
/*     */   }
/*     */ 
/*     */   
/*     */   public List<i> ae() {
/*  55 */     return this.a.a(a());
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<?> f() {
/*  60 */     return this.g;
/*     */   }
/*     */   
/*     */   public c a() {
/*  64 */     c c1 = this.a.a();
/*  65 */     return a(c1);
/*     */   }
/*     */   
/*     */   private c a(c paramc) {
/*  69 */     if (a(paramc)) {
/*  70 */       return c.d;
/*     */     }
/*  72 */     c c1 = paramc.c();
/*  73 */     for (c c2 : paramc.getChildren()) {
/*  74 */       c c3 = a(c2);
/*  75 */       if (!c3.isEmpty()) {
/*  76 */         c1.g(c3);
/*     */       }
/*     */     } 
/*  79 */     return c1;
/*     */   }
/*     */   
/*     */   private boolean a(c paramc) {
/*  83 */     return (paramc.getAnnotation(k.class) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  88 */     return this.g.getName();
/*     */   }
/*     */   
/*     */   public void a(b paramb) throws org.junit.runner.a.e {
/*  92 */     paramb.I(this.a);
/*     */   }
/*     */   
/*     */   public void a(j paramj) {
/*  96 */     paramj.I(this.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(g paramg) throws d {
/* 105 */     paramg.I(this.a);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\junit\b\e.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */