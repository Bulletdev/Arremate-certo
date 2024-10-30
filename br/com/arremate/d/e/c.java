/*     */ package br.com.arremate.d.e;
/*     */ 
/*     */ import br.com.arremate.f.v;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.c.e;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.b.f;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */ {
/*  27 */   private static final Logger a = LoggerFactory.getLogger(c.class);
/*     */   
/*     */   private final a a;
/*     */   
/*     */   private final e d;
/*     */   
/*     */   private final e b;
/*     */   private final long k;
/*     */   private final br.com.arremate.l.e.c a;
/*     */   private String X;
/*     */   private long l;
/*     */   
/*     */   public c(a parama, e parame, e parame1) {
/*  40 */     this.a = (br.com.arremate.l.e.c)parama;
/*  41 */     this.d = parame;
/*  42 */     this.b = parame1;
/*  43 */     this.k = TimeUnit.SECONDS.toMillis(6L);
/*     */     
/*  45 */     this.a = (br.com.arremate.l.e.c)this.d.a();
/*     */     
/*  47 */     this.l = 0L;
/*     */   }
/*     */   
/*     */   public List<h> j() {
/*  51 */     if (this.X == null || this.X.isEmpty()) {
/*  52 */       if (!this.d.ay()) {
/*  53 */         this.X = this.d.bo();
/*     */       } else {
/*  55 */         this.X = ((f)this.d).a().bC();
/*     */       } 
/*     */     }
/*     */     
/*  59 */     if (this.X != null && !this.X.isEmpty() && !this.d.bv()) {
/*  60 */       return k();
/*     */     }
/*     */     
/*  63 */     return new ArrayList<>();
/*     */   }
/*     */   
/*     */   private List<h> k() {
/*  67 */     ArrayList<h> arrayList = new ArrayList();
/*     */     
/*     */     try {
/*  70 */       if (this.l > 0L) {
/*  71 */         Long long_ = Long.valueOf(System.currentTimeMillis());
/*  72 */         long_ = Long.valueOf(long_.longValue() - this.l);
/*  73 */         if (long_.longValue() < this.k) {
/*  74 */           Thread.sleep(this.k - long_.longValue());
/*     */         }
/*     */       } 
/*     */       
/*  78 */       e e1 = this.b.b(this.a.bk(), this.X);
/*  79 */       this.l = System.currentTimeMillis();
/*     */       
/*  81 */       String str = e1.getData();
/*  82 */       if (str.isEmpty() || !str.contains("[") || str.equals("[]")) {
/*  83 */         this.a.m(e1.k());
/*  84 */         a.warn("Item {} - Licitação {} - UASG {} - Status code {} - Falha ao carregar os melhores lances do item", new Object[] { this.d
/*  85 */               .bo(), this.a.bo(), Integer.valueOf(this.a.K()), Integer.valueOf(e1.getStatusCode()) });
/*  86 */         return arrayList;
/*     */       } 
/*     */       
/*  89 */       this.a.n(e1.k());
/*     */       
/*  91 */       boolean bool = false;
/*  92 */       f f = new f(str);
/*  93 */       for (byte b = 0; b < f.length(); b++) {
/*  94 */         i i = f.b(b);
/*     */         
/*  96 */         if (!i.getBoolean("excluido")) {
/*  97 */           h h = new h();
/*  98 */           h.l(b + 1);
/*  99 */           h.c((new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")).parse(i.getString("dataHoraInclusao")));
/* 100 */           i i1 = i.j("valor");
/*     */           
/* 102 */           if (this.d.w() == v.b.v() && i1
/* 103 */             .has("valorInformado") && !i1.isNull("valorInformado")) {
/* 104 */             h.q(i1.getDouble("valorInformado"));
/*     */           } else {
/* 106 */             h.q(i1.getDouble("valorCalculado"));
/*     */           } 
/*     */           
/* 109 */           if (!bool && h.m() == this.d.f()) {
/* 110 */             h.A(true);
/* 111 */             bool = true;
/*     */           } 
/*     */           
/* 114 */           arrayList.add(h);
/*     */         } 
/*     */       } 
/* 117 */     } catch (InterruptedException|java.text.ParseException|org.e.g interruptedException) {
/* 118 */       a.warn("{} - Failed to get best bids from bidding room cn", this.d.bo(), interruptedException);
/*     */     } 
/*     */     
/* 121 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\e\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */