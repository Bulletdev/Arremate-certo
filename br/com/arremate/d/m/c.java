/*     */ package br.com.arremate.d.m;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.d.h;
/*     */ import br.com.arremate.f.f;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.d;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.k.a;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.c.f;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ public class c
/*     */   extends g
/*     */ {
/*     */   public c(b paramb, i parami) {
/*  34 */     super(paramb, parami);
/*  35 */     a(new a(this, parami));
/*  36 */     j(TimeUnit.SECONDS.toMillis(10L));
/*     */   }
/*     */ 
/*     */   
/*     */   public t a() {
/*  41 */     t t = t.c;
/*     */     
/*     */     try {
/*  44 */       String str = a().a(Integer.valueOf(a().v()));
/*     */       
/*  46 */       if (!"".equals(str)) {
/*  47 */         Document document = Jsoup.parse(str);
/*  48 */         Elements elements = document.select("span[id=situacaoAtual]");
/*     */         
/*  50 */         if (!elements.isEmpty()) {
/*  51 */           Element element = elements.first();
/*  52 */           String str1 = element.text().toLowerCase().trim();
/*  53 */           String str2 = "Pregão em disputa";
/*     */           
/*  55 */           if (str1.contains("concluído")) {
/*  56 */             str2 = "Disputa encerrada";
/*  57 */             t = t.d;
/*  58 */           } else if (str1.contains("sessão não iniciada")) {
/*  59 */             str2 = "Pregão em fase de proposta";
/*  60 */             t = t.b;
/*  61 */           } else if (str1.contains("suspenso") || str1.contains("suspensa")) {
/*  62 */             str2 = "Pregão suspenso";
/*  63 */             t = t.e;
/*     */           } 
/*     */           
/*  66 */           k(str2);
/*     */         } 
/*  68 */       } else if (!D() && !E() && 
/*  69 */         isRunning() && !a().isRunning()) {
/*  70 */         a().z();
/*     */       }
/*     */     
/*  73 */     } catch (Exception exception) {
/*  74 */       a.error("#004 - Erro no verifica pregão aberto", exception);
/*  75 */       h("#004");
/*     */     } 
/*     */     
/*  78 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   public void R() {
/*     */     try {
/*  84 */       boolean bool = false;
/*  85 */       i i = l();
/*     */       
/*  87 */       if (i != null) {
/*  88 */         if (!i.has("msgErro")) {
/*  89 */           if (i.has("lotes")) {
/*  90 */             f f = i.c("lotes");
/*     */             
/*  92 */             for (byte b = 0; b < f.length(); b++) {
/*  93 */               i i1 = f.b(b);
/*  94 */               int j = i1.getInt("idLote");
/*  95 */               e e = a(j);
/*     */               
/*  97 */               if (e != null) {
/*  98 */                 String str = i1.getString("situacao");
/*     */ 
/*     */                 
/* 101 */                 if (str.equals("Abertura de lances concluída")) {
/* 102 */                   String str1 = i1.getString("tempoDeIminencia");
/*     */                   
/* 104 */                   if (!str1.equals("-") && !str1.equals("Encerrado")) {
/* 105 */                     str = "Tempo de iminência iniciado";
/*     */                   }
/*     */                 } 
/*     */                 
/* 109 */                 a a = new a(e.v(), a());
/* 110 */                 if (a().a() != m.a) {
/* 111 */                   a.N(a(e, i1, str));
/*     */                 } else {
/* 113 */                   a.N(str);
/*     */                 } 
/*     */ 
/*     */                 
/* 117 */                 if (!a.aw()) {
/* 118 */                   e.N(a.bB());
/* 119 */                   int k = a().indexOf(e.v());
/*     */                   
/* 121 */                   if (k >= 0) {
/* 122 */                     a().fireTableCellUpdated(k, 8);
/*     */                   }
/*     */                 } 
/*     */                 
/* 126 */                 if (e.bt()) {
/* 127 */                   bool = true;
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } else {
/* 133 */           l(i.getString("msgErro"));
/*     */         } 
/* 135 */       } else if (!D() && !E() && 
/* 136 */         isRunning() && !a().isRunning()) {
/* 137 */         while (a().z() != 1 && isRunning()) {
/* 138 */           a(f.i);
/* 139 */           a.warn("Tentativa falha de login thread da licitacao");
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 144 */       if ((a() == null || !a().isRunning()) && 
/* 145 */         bool && isRunning()) {
/* 146 */         if (a().a() != m.a) {
/* 147 */           a(new e(this));
/*     */         } else {
/* 149 */           a(new d(this));
/*     */         } 
/* 151 */         a().start();
/*     */       }
/*     */     
/* 154 */     } catch (Exception exception) {
/* 155 */       a.error("#002", exception);
/* 156 */       h("#002");
/*     */     } 
/*     */   }
/*     */   
/*     */   protected String a(e parame, i parami, String paramString) {
/* 161 */     String str = parami.getString("tempoDeSessaoAberta");
/* 162 */     if (str.equals("-") || str.equals("Encerrado")) {
/* 163 */       str = parami.getString("tempoDeSessaoFechada");
/*     */     }
/*     */     
/* 166 */     int j = 0;
/* 167 */     int k = 0;
/*     */     
/* 169 */     if (!str.equals("-") && !str.equals("Encerrado")) {
/* 170 */       String[] arrayOfString = str.split(":");
/* 171 */       j = Integer.parseInt(arrayOfString[0]);
/* 172 */       k = Integer.parseInt(arrayOfString[1]);
/*     */     } 
/*     */     
/* 175 */     long l = TimeUnit.MINUTES.toMillis(j) + TimeUnit.SECONDS.toMillis(k);
/* 176 */     if (l > 0L) {
/* 177 */       if (l <= 120000L && parame.a().a() == m.b) {
/* 178 */         paramString = "Tempo de iminência - modo aberto";
/*     */       }
/* 180 */     } else if (paramString.equals("Disputa aberta iniciada") && parame.a().a() != m.b) {
/* 181 */       paramString = "Tempo randômico iniciado";
/*     */     } 
/*     */     
/* 184 */     a a = (a)parame.a();
/* 185 */     if (g.b(paramString, g.P) && !a.aR() && a.bh()) {
/* 186 */       paramString = g.p.getValue();
/*     */     }
/*     */     
/* 189 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   i l() {
/* 198 */     HashSet<Integer> hashSet = new HashSet();
/*     */     
/* 200 */     a()
/* 201 */       .L()
/* 202 */       .forEach(parame -> paramSet.add(Integer.valueOf(parame.v())));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 207 */     return a(hashSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   i a(Set<Integer> paramSet) {
/* 216 */     i i = null;
/* 217 */     String str = "";
/*     */     
/*     */     try {
/* 220 */       str = a(paramSet);
/*     */       
/* 222 */       if (!str.isEmpty()) {
/* 223 */         if (!str.contains("erroPregaoNaoValidado")) {
/* 224 */           i = new i(str);
/*     */         } else {
/* 226 */           String str1; Document document = Jsoup.parse(str);
/*     */ 
/*     */           
/*     */           try {
/* 230 */             str1 = document.select("span[id=erroPregaoNaoValidado]").first().text().trim();
/* 231 */           } catch (Exception exception) {
/* 232 */             str1 = "Acesso negado";
/*     */           } 
/*     */           
/* 235 */           i = new i();
/* 236 */           i.c("msgErro", str1);
/*     */         } 
/*     */       }
/* 239 */     } catch (Exception exception) {
/* 240 */       a.warn("#007", exception);
/* 241 */       h("#007");
/*     */     } 
/*     */     
/* 244 */     return i;
/*     */   }
/*     */   
/*     */   private String a(Set<Integer> paramSet) {
/* 248 */     e e = a().a(Integer.valueOf(a().v()), paramSet);
/* 249 */     String str = e.getData();
/* 250 */     e(e.k());
/*     */     
/* 252 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> b(e parame) throws d {
/* 257 */     b b = null;
/*     */     
/* 259 */     if (!parame.br() && isRunning() && a() != null) {
/* 260 */       b = a().a(parame.v());
/*     */     }
/*     */     
/* 263 */     if (b == null) {
/* 264 */       b = new b(parame, (i)a(), this);
/*     */     }
/*     */     
/* 267 */     return b.e();
/*     */   }
/*     */ 
/*     */   
/*     */   public void S() {
/* 272 */     d d = a();
/* 273 */     if (d == null) {
/* 274 */       d = new d(this);
/*     */     }
/*     */     
/* 277 */     d.g(true);
/* 278 */     d.ag();
/*     */ 
/*     */     
/* 281 */     d.bk();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(f paramf, List<h> paramList) {}
/*     */ 
/*     */   
/*     */   protected void T() {
/* 290 */     d d = a();
/* 291 */     a()
/* 292 */       .I()
/* 293 */       .forEach(parame -> {
/*     */           if (paramd != null) {
/*     */             b b = paramd.a(parame.v());
/*     */             if (b != null) {
/*     */               int[] arrayOfInt = b.a();
/*     */               parame.ah(arrayOfInt[0]);
/*     */               parame.ai(arrayOfInt[1]);
/*     */             } 
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean c(e parame, double paramDouble) {
/* 307 */     if (a() != null && a().isRunning()) {
/* 308 */       return a().c(parame, paramDouble);
/*     */     }
/*     */     
/* 311 */     return false;
/*     */   }
/*     */   
/*     */   void p(e parame) {
/* 315 */     d d = a();
/* 316 */     if (d != null) {
/* 317 */       d.c().remove(Integer.valueOf(parame.v()));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public d a() {
/* 323 */     return (d)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public d a() {
/* 328 */     return (d)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\m\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */