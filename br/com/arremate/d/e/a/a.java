/*     */ package br.com.arremate.d.e.a;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.d.e.c;
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.i;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.c.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.n.n;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.e.f;
/*     */ import org.e.g;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends f
/*     */ {
/*     */   private final c a;
/*     */   private i e;
/*     */   private boolean l;
/*     */   
/*     */   public a(e parame, e parame1, g paramg) {
/*  39 */     super(parame, (i)parame1, paramg);
/*     */     
/*  41 */     this.a = new c(a(), parame, parame1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void P() {
/*     */     try {
/*  47 */       if (this.e == null) {
/*     */         return;
/*     */       }
/*     */       
/*  51 */       String str1 = "";
/*  52 */       String str2 = "";
/*     */       
/*  54 */       if (this.e.has("fase")) {
/*  55 */         str1 = this.e.getString("fase");
/*     */       }
/*     */       
/*  58 */       if (this.e.has("situacao")) {
/*  59 */         str2 = this.e.getString("situacao");
/*     */       }
/*     */       
/*  62 */       long l = a().a().g().getTimeInMillis() - n.a().longValue();
/*  63 */       if (l < TimeUnit.SECONDS.toMillis(-10L) && this.e.has("situacaoAposContagem")) {
/*  64 */         str1 = this.e.getString("situacaoAposContagem");
/*     */       }
/*     */ 
/*     */       
/*  68 */       g g = b(str2, str1);
/*  69 */       if (this.e.has("desclassificado") && this.e.getBoolean("desclassificado") && g != g.s) {
/*  70 */         g = g.aW;
/*     */       }
/*     */       
/*  73 */       if (g != null) {
/*  74 */         a().N(g.getValue());
/*     */       }
/*     */       
/*  77 */       aL();
/*  78 */       aE();
/*  79 */       az();
/*     */       
/*  81 */       if (a().br()) {
/*  82 */         super.b().g(a());
/*     */       }
/*  84 */     } catch (g g) {
/*  85 */       a.error("Item {} - Failed to update dispense item data", a().bo(), g);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void aL() throws g {
/*  90 */     if (this.e.has("melhorValorGeral") && !this.e.isNull("melhorValorGeral")) {
/*  91 */       i i1 = this.e.j("melhorValorGeral");
/*  92 */       if (!i1.isNull("valorCalculado")) {
/*  93 */         a().l(i1.getDouble("valorCalculado"));
/*     */       }
/*     */     } 
/*     */     
/*  97 */     if (this.e.has("melhorValorFornecedor")) {
/*  98 */       a().h(this.e.j("melhorValorFornecedor").getDouble("valorCalculado"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void aE() throws g {
/* 103 */     g g = a().a();
/* 104 */     if (g.r().compareTo(BigDecimal.ZERO) == 0 && g.s().compareTo(BigDecimal.ZERO) == 0 && 
/* 105 */       this.e.has("variacaoMinimaEntreLances") && !this.e.isNull("variacaoMinimaEntreLances")) {
/* 106 */       BigDecimal bigDecimal = BigDecimal.valueOf(this.e.getDouble("variacaoMinimaEntreLances"));
/*     */       
/* 108 */       if (this.e.getString("tipoVariacaoMinimaEntreLances").equals("V")) {
/* 109 */         g.e(bigDecimal);
/*     */       } else {
/* 111 */         g.f(bigDecimal);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void az() {
/* 119 */     s s = s.c;
/* 120 */     if (this.e.has("situacaoParticipanteDisputa")) {
/* 121 */       switch (this.e.getString("situacaoParticipanteDisputa")) {
/*     */         case "E":
/* 123 */           s = s.b;
/*     */           break;
/*     */         case "G":
/* 126 */           s = s.a;
/*     */           break;
/*     */       } 
/* 129 */     } else if (a().f().m() == a().f()) {
/* 130 */       s = s.a;
/*     */     } 
/*     */     
/* 133 */     a().a(s);
/*     */   }
/*     */   
/*     */   private g b(String paramString1, String paramString2) {
/* 137 */     n(paramString2);
/*     */     
/* 139 */     switch (paramString1) {
/*     */       case "2":
/* 141 */         return g.av;
/*     */       case "3":
/* 143 */         return g.t;
/*     */       case "4":
/* 145 */         return g.u;
/*     */       case "5":
/* 147 */         return g.r;
/*     */       case "6":
/* 149 */         return g.au;
/*     */       case "7":
/* 151 */         return g.at;
/*     */     } 
/*     */     
/* 154 */     switch (paramString2) {
/*     */       case "LA":
/* 156 */         return g.f;
/*     */       case "AL":
/* 158 */         return g.k;
/*     */       case "AF":
/* 160 */         return g.n;
/*     */       case "F":
/* 162 */         return g.a;
/*     */       case "AS":
/* 164 */         return g.b;
/*     */       case "AP":
/* 166 */         return g.c;
/*     */       case "AA":
/* 168 */         return g.d;
/*     */       case "LS":
/* 170 */         return g.e;
/*     */       case "PE":
/*     */       case "FE":
/* 173 */         return g.l;
/*     */       case "RA":
/* 175 */         return g.m;
/*     */       case "AM":
/*     */       case "DM":
/*     */       case "A7":
/*     */       case "D7":
/* 180 */         return g.q;
/*     */       case "E":
/* 182 */         return g.s;
/*     */     } 
/*     */ 
/*     */     
/* 186 */     return null;
/*     */   }
/*     */   
/*     */   private void n(String paramString) {
/* 190 */     ((br.com.arremate.l.e.a)a().a()).n(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/* 195 */     if (a().b().aI()) {
/* 196 */       return (a().z() < a().b().v());
/*     */     }
/*     */     
/* 199 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected h b(List<h> paramList) throws br.com.arremate.g.a {
/* 204 */     boolean bool = (this.l && a().b().aH()) ? true : false;
/* 205 */     if (bool) {
/* 206 */       h h = a().a(a());
/* 207 */       if (h != null) {
/* 208 */         i("1º Lugar");
/* 209 */         return h;
/*     */       } 
/*     */     } 
/*     */     
/* 213 */     return super.b(paramList);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> e() {
/* 218 */     return this.a.j();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/* 223 */     if (!b(paramh.m()) && !paramBoolean) {
/* 224 */       a.warn("Tentativa de lance abaixo do mínimo");
/* 225 */       return false;
/*     */     } 
/*     */     
/*     */     try {
/* 229 */       if (!k.b()) {
/* 230 */         a().a().y(n.a().longValue());
/* 231 */         a("Lance de simulação", paramh, m(), paramBoolean, new String[0]);
/* 232 */         return true;
/*     */       } 
/*     */       
/* 235 */       String str = ((br.com.arremate.l.e.a)a().a()).u();
/* 236 */       a.info("Enviando lance no valor de {} para o item {}", Double.valueOf(paramh.m()), a().bo());
/* 237 */       e e = a().a(
/* 238 */           a().a().bk(), 
/* 239 */           a().bo(), paramh
/* 240 */           .m(), str);
/*     */ 
/*     */ 
/*     */       
/* 244 */       return c(e, paramh, paramBoolean);
/* 245 */     } catch (d d) {
/* 246 */       b("enviar lance", d);
/* 247 */     } catch (Exception exception) {
/* 248 */       a.error("Item {} - Failed to send dispense bid", a().bo(), exception);
/*     */     } 
/*     */     
/* 251 */     return false;
/*     */   }
/*     */   
/*     */   private boolean c(e parame, h paramh, boolean paramBoolean) {
/* 255 */     String str = parame.getData().trim();
/* 256 */     a.info("Retorno sobre envio de lance para o item {}, status: {} | message: {}", new Object[] { a().bo(), Integer.valueOf(parame.getStatusCode()), str });
/*     */     
/* 258 */     if (parame.getStatusCode() == 200) {
/*     */       
/*     */       try {
/* 261 */         double d = parame.k() / 1000.0D;
/* 262 */         DecimalFormat decimalFormat = new DecimalFormat("#.##");
/* 263 */         String str1 = decimalFormat.format(d);
/*     */         
/* 265 */         a("Lance enviado", paramh, m(), paramBoolean, new String[] { "Tempo para envio: " + str1 });
/* 266 */         a().a().y(n.a().longValue());
/*     */         
/* 268 */         if (!str.isEmpty() && !str.equals("{}")) {
/* 269 */           f f1 = new f(str);
/* 270 */           if (f1.length() > 0) {
/* 271 */             i i1 = f1.b(0);
/*     */             
/* 273 */             if (a().g(i1)) {
/* 274 */               this.e = i1;
/* 275 */               P();
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 280 */         return true;
/* 281 */       } catch (g g) {}
/*     */     }
/*     */ 
/*     */     
/* 285 */     a.info("Falha ao enviar lance, status: {} | message: {}", Integer.valueOf(parame.getStatusCode()), str);
/* 286 */     b(str, parame.getStatusCode(), paramh, paramBoolean);
/* 287 */     return false;
/*     */   }
/*     */   
/*     */   private void b(String paramString, int paramInt, h paramh, boolean paramBoolean) {
/* 291 */     String str = "Não houve mensagem de retorno do portal!";
/*     */     
/* 293 */     if (!paramString.isEmpty() && !paramString.equals("{}")) {
/* 294 */       i i1 = new i(paramString);
/* 295 */       if (i1.has("message")) {
/* 296 */         str = i1.getString("message");
/*     */       }
/*     */     } 
/*     */     
/* 300 */     a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { str, "Status: " + paramInt });
/*     */   }
/*     */ 
/*     */   
/*     */   public final b a() {
/* 305 */     return (b)super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public e a() {
/* 310 */     return (e)super.b();
/*     */   }
/*     */   
/*     */   public void e(i parami) {
/* 314 */     this.e = parami;
/*     */   }
/*     */   
/*     */   public void e(boolean paramBoolean) {
/* 318 */     this.l = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\e\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */