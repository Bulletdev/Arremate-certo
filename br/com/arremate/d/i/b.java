/*     */ package br.com.arremate.d.i;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.i;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.n.n;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.TreeSet;
/*     */ import org.e.f;
/*     */ import org.e.g;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends f
/*     */ {
/*     */   private i f;
/*     */   
/*     */   public b(e parame, i parami, g paramg) {
/*  34 */     super(parame, parami, paramg);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void P() {
/*     */     try {
/*  41 */       String str1 = this.f.getString("StatusLote").toLowerCase();
/*  42 */       String str2 = this.f.getString("TempoRandomicoExecutado").toLowerCase();
/*     */       
/*  44 */       if (str1.equals("fracassado")) {
/*  45 */         a().N(g.at.getValue());
/*  46 */       } else if (str2.equals("executado")) {
/*  47 */         a().N(g.s.getValue());
/*     */       }
/*  49 */       else if (str1.equals("aberto") && str2.equals("aguardando execução")) {
/*  50 */         a().N(g.f.getValue());
/*  51 */       } else if (str1.equals("aberto") && str2.equals("em execução")) {
/*  52 */         a().N(g.k.getValue());
/*  53 */       } else if (str1.equals("fechado") && str2.equals("aguardando execução")) {
/*  54 */         a().N(g.aY.getValue());
/*     */       } else {
/*  56 */         a().N(g.g.getValue());
/*     */       } 
/*     */ 
/*     */       
/*  60 */       List<h> list = l();
/*  61 */       if (!list.isEmpty()) {
/*  62 */         a().h(list.get(0));
/*     */         
/*  64 */         list.stream().filter(paramh -> paramh.bb()).forEachOrdered(paramh -> a().h(paramh.m()));
/*     */ 
/*     */ 
/*     */         
/*  68 */         s s = ((h)list.get(0)).bb() ? s.a : s.c;
/*  69 */         a().a(s);
/*     */         
/*  71 */         if (a().br()) {
/*  72 */           a().g(a());
/*  73 */           a().p(a());
/*     */         } 
/*     */       } 
/*  76 */     } catch (Exception exception) {
/*  77 */       a.warn("[Cemig] - Failed to update item {} data", a().bo(), exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/*  83 */     return (parami == i.a || a().bu());
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> e() throws d {
/*  88 */     return l();
/*     */   }
/*     */   
/*     */   private List<h> l() {
/*     */     try {
/*  93 */       TreeSet<h> treeSet = new TreeSet((paramh1, paramh2) -> (paramh1.m() < paramh2.m()) ? -1 : ((paramh1.m() > paramh2.m()) ? 1 : 0));
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
/* 105 */       f f1 = this.f.c("Detalhes"); byte b1;
/* 106 */       for (b1 = 0; b1 < f1.length(); b1++) {
/* 107 */         i i1 = f1.b(b1);
/* 108 */         h h = new h();
/* 109 */         if (i1.has("ValorNegociado") && i1.getDouble("ValorNegociado") > 0.0D) {
/* 110 */           h.q(i1.getDouble("ValorNegociado"));
/* 111 */         } else if (i1.has("ValorClassificacao") && i1.getDouble("ValorClassificacao") > 0.0D) {
/* 112 */           h.q(i1.getDouble("ValorClassificacao"));
/* 113 */         } else if (i1.has("ValorEqualizadoLance") && i1.getDouble("ValorEqualizadoLance") > 0.0D) {
/* 114 */           h.q(i1.getDouble("ValorEqualizadoLance"));
/*     */         } else {
/* 116 */           h.q(i1.getDouble("ValorProposta"));
/*     */         } 
/*     */         
/* 119 */         h.E(i1.getString("Participante"));
/* 120 */         h.A(h.ay().toLowerCase().contains(b().a().bv().toLowerCase()));
/* 121 */         treeSet.add(h);
/*     */       } 
/*     */       
/* 124 */       b1 = 1;
/* 125 */       ArrayList<h> arrayList = new ArrayList<>(treeSet);
/* 126 */       for (h h : arrayList) {
/* 127 */         h.l(b1);
/* 128 */         b1++;
/*     */       } 
/*     */       
/* 131 */       return arrayList;
/* 132 */     } catch (g g) {
/* 133 */       a.warn("[Cemig] - Failed to get best bids item {} data", a().bo(), g);
/*     */ 
/*     */       
/* 136 */       return new ArrayList<>();
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/* 141 */     if (!b(paramh.m()) && !paramBoolean) {
/* 142 */       a.warn("Tentativa de lance abaixo do mínimo");
/* 143 */       return false;
/*     */     } 
/*     */     
/*     */     try {
/* 147 */       if (!k.b()) {
/* 148 */         a().a().y(n.a().longValue());
/* 149 */         a("Lance de simulação", paramh, m(), paramBoolean, new String[0]);
/* 150 */         return true;
/*     */       } 
/*     */       
/* 153 */       i i1 = this.f.c("Itens").b(0);
/* 154 */       i i2 = new i(this, i1, paramh)
/*     */         {
/*     */         
/*     */         };
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 182 */       e e = b().a(i2);
/* 183 */       return d(e, paramh, paramBoolean);
/* 184 */     } catch (g g) {
/* 185 */       a.error("{} - Failed to send bid to Cemig", paramh.a().bo(), g);
/*     */ 
/*     */       
/* 188 */       return false;
/*     */     } 
/*     */   }
/*     */   private boolean d(e parame, h paramh, boolean paramBoolean) {
/* 192 */     if (parame.getStatusCode() == 401) {
/* 193 */       a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { "Login sem sessão para enviar lance!" });
/* 194 */       return false;
/*     */     } 
/*     */     
/*     */     try {
/* 198 */       double d = parame.k() / 1000.0D;
/* 199 */       String str = (new DecimalFormat("#.##")).format(d);
/* 200 */       str = String.join("", new CharSequence[] { "Tempo para envio: ", str });
/*     */       
/* 202 */       if (parame.getStatusCode() == 200) {
/* 203 */         i i1 = new i(parame.getData());
/* 204 */         i1 = i1.j("d").c("Mensagens").b(0);
/*     */         
/* 206 */         String str1 = i1.getString("Texto");
/* 207 */         if (str1.toLowerCase().contains("lance aceito")) {
/* 208 */           a("Lance enviado", paramh, m(), paramBoolean, new String[] { str });
/* 209 */           return true;
/*     */         } 
/* 211 */         a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { str1, str, 
/* 212 */               String.join("", new CharSequence[] { "Status:", parame.Q() }) });
/* 213 */         return false;
/*     */       }
/*     */     
/* 216 */     } catch (g g) {
/* 217 */       a.error("[Cemig Bidding {}] (Item {}) Failed to read json response", new Object[] { Integer.valueOf(a().a().v()), paramh.a().bo(), g });
/*     */     } 
/*     */     
/* 220 */     a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { "Erro interno do portal", String.join("", new CharSequence[] { "Status: ", parame.Q() }) });
/* 221 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public c a() {
/* 226 */     return (c)super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public a b() {
/* 231 */     return (a)super.b();
/*     */   }
/*     */   
/*     */   void f(i parami) {
/* 235 */     this.f = parami;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\i\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */