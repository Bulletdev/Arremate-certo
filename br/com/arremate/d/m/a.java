/*     */ package br.com.arremate.d.m;
/*     */ 
/*     */ import br.com.arremate.d.e;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.j.d;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.m;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends e
/*     */ {
/*     */   private final String ag;
/*     */   
/*     */   public a(g paramg, i parami) {
/*  24 */     super(paramg, parami);
/*     */     
/*  26 */     this.ag = "TEMPO DE IMINÊNCIA concluído para esse lote. O TEMPO RANDÔMICO foi iniciado e a sessão de lances pode encerrar a qualquer momento.";
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<m> d() {
/*  31 */     int i = a().a().v();
/*  32 */     ArrayList<m> arrayList = new ArrayList();
/*  33 */     byte b1 = 1;
/*     */     
/*  35 */     boolean bool = false;
/*     */ 
/*     */     
/*  38 */     byte b2 = (a() == null) ? 100 : 10;
/*     */     try {
/*     */       int j;
/*     */       do {
/*  42 */         String str = a().a(i, b1, b2);
/*  43 */         if ("".equals(str)) {
/*     */           break;
/*     */         }
/*     */         
/*  47 */         i i1 = new i(str);
/*  48 */         i i2 = i1.j("resultado");
/*  49 */         j = i2.getInt("total");
/*  50 */         f f = i2.c("dados");
/*     */         
/*  52 */         for (byte b = 0; b < f.length(); b++) {
/*  53 */           i i3 = f.b(b);
/*  54 */           String str1 = Integer.toString(i3.getInt("numeroLote"));
/*  55 */           String str2 = i3.getString("texto");
/*  56 */           Date date = y.a(i3.getString("dataHoraEnvio"));
/*  57 */           String str3 = i3.j("remetente").getString("descricao");
/*     */           
/*  59 */           if (str3.equalsIgnoreCase("fornecedor")) {
/*  60 */             str3 = String.join(" ", new CharSequence[] { str3, i3.j("fornecedor").getString("identificadorFornecedorFormatado") });
/*     */           }
/*     */           
/*  63 */           m m = new m(str1, str2, date, str3);
/*  64 */           if (a(m)) {
/*  65 */             bool = true;
/*     */             
/*     */             break;
/*     */           } 
/*  69 */           arrayList.add(0, m);
/*  70 */           i(m);
/*  71 */           if (a().a().a() == m.c) {
/*  72 */             j(m);
/*     */           }
/*     */         } 
/*     */         
/*  76 */         ++b1;
/*  77 */       } while (b1 * b2 < j && !bool);
/*  78 */     } catch (Exception exception) {
/*  79 */       a.warn("Failed to get new messages", exception);
/*     */     } 
/*     */     
/*  82 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void i(m paramm) {
/*  91 */     if (paramm != null && this.ag.equals(paramm.j())) {
/*  92 */       e e1 = a().a(paramm.bo());
/*     */       
/*  94 */       if (e1 != null) {
/*  95 */         br.com.arremate.l.k.a a1 = (br.com.arremate.l.k.a)e1.a();
/*  96 */         a1.e(paramm.b());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void j(m paramm) {
/* 107 */     if (paramm != null && paramm.j().contains("A etapa de lances fechados foi iniciada.")) {
/* 108 */       e e1 = a().a(paramm.bo());
/* 109 */       if (e1 != null) {
/* 110 */         br.com.arremate.l.k.a a1 = (br.com.arremate.l.k.a)e1.a();
/* 111 */         if (paramm.j().contains(a1.bG())) {
/* 112 */           a1.v(true);
/*     */         }
/*     */         
/* 115 */         a1.F(true);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public d a() {
/* 122 */     return (d)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public c a() {
/* 127 */     return (c)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\m\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */