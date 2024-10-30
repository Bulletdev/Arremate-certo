/*     */ package br.com.arremate.j.j;
/*     */ 
/*     */ import br.com.arremate.a.a.c;
/*     */ import br.com.arremate.f.x;
/*     */ import br.com.arremate.h.c;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.h.f;
/*     */ import br.com.arremate.h.g;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.m.A;
/*     */ import com.google.a.o.a.af;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.e.i;
/*     */ 
/*     */ public class a
/*     */   extends i
/*     */ {
/*  21 */   private static final String cI = c.a().d();
/*     */   
/*     */   private static final String cJ = "https://licitanet-api-sala-disputa.licitanet.com.br/";
/*  24 */   private static final String cK = String.join("", new CharSequence[] { "https://licitanet-api-sala-disputa.licitanet.com.br/", "proposal" });
/*  25 */   private static final String cL = String.join("", new CharSequence[] { "https://licitanet-api-sala-disputa.licitanet.com.br/", "process/" });
/*  26 */   private static final String cM = String.join("", new CharSequence[] { cL, "status" });
/*  27 */   private static final String cN = String.join("", new CharSequence[] { cL, "message/" });
/*  28 */   private static final String cO = String.join("", new CharSequence[] { cL, "bid/" });
/*  29 */   private static final String cP = String.join("", new CharSequence[] { cO, "best/" });
/*  30 */   private static final String cQ = String.join("", new CharSequence[] { "https://licitanet-api-sala-disputa.licitanet.com.br/", "company" });
/*     */   
/*     */   private static final String cR = "https://portal.licitanet.com.br/login";
/*     */   
/*  34 */   private static final af f = af.a(1.0D);
/*     */   private static final int DEFAULT_TIMEOUT = 30000;
/*     */   
/*     */   public a(d paramd) {
/*  38 */     a(paramd);
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
/*  50 */     c c = g.c().a(201).a(500).a(400).b(30000).d(25).e(100).a(f).a("Origin", "https://portal.licitanet.com.br").a("referer", "https://portal.licitanet.com.br/").a("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36");
/*     */     
/*  52 */     a(c.a());
/*     */   }
/*     */ 
/*     */   
/*     */   public int z() {
/*  57 */     c().bB();
/*     */     
/*     */     try {
/*  60 */       if (ai()) {
/*  61 */         setRunning(!ae());
/*  62 */         return 1;
/*     */       } 
/*     */       
/*  65 */       setMessage("Verifique se a chave de integração está correta e ativa no portal.");
/*  66 */     } catch (b b) {
/*  67 */       setMessage(b.getMessage());
/*  68 */     } catch (a a1) {
/*  69 */       setMessage("Falha ao realizar login devido à sobrecarga no portal. Por favor, tente novamente em instantes.");
/*     */     } 
/*     */     
/*  72 */     return 0;
/*     */   }
/*     */   
/*     */   private boolean ai() throws b, a {
/*  76 */     e e = p();
/*     */     
/*  78 */     if (e.getStatusCode() == 200) {
/*  79 */       i i1 = new i(e.getData());
/*  80 */       a().aa(i1.getString("name"));
/*  81 */       a().v(Long.parseLong(i1.getString("document")));
/*  82 */       return true;
/*  83 */     }  if (e.getStatusCode() == 400) {
/*  84 */       i i1 = new i(e.getData());
/*     */       
/*  86 */       if (i1.has("error")) {
/*  87 */         i i2 = i1.j("error");
/*     */         
/*  89 */         if (i2.has("description") && "Fornecedor esta usando plano avulso".equals(i2.getString("description"))) {
/*  90 */           throw new b(this);
/*     */         }
/*     */       } 
/*  93 */     } else if (e.getStatusCode() == 429) {
/*  94 */       throw new a(this);
/*     */     } 
/*     */     
/*  97 */     return false;
/*     */   }
/*     */   
/*     */   private e p() {
/* 101 */     return c().a(
/* 102 */         g.c().a(cQ).a("/my-data").b(l()));
/*     */   }
/*     */   
/*     */   public e j(int paramInt, String paramString) {
/* 106 */     return c().a(
/* 107 */         g.c().a(cK)
/* 108 */         .a("page", paramInt)
/* 109 */         .a("limit", 200)
/* 110 */         .a("after", paramString)
/* 111 */         .b(l()));
/*     */   }
/*     */ 
/*     */   
/*     */   public e s(int paramInt) {
/* 116 */     return a(paramInt, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e a(int paramInt, boolean paramBoolean) {
/* 123 */     f f = g.c().a(cK).a("/").a(paramInt).b(l());
/*     */     
/* 125 */     if (paramBoolean) {
/* 126 */       f.a("onlyBidIsAvailable", "true");
/*     */     }
/*     */     
/* 129 */     return c().a(f);
/*     */   }
/*     */   
/*     */   public e t(int paramInt) {
/* 133 */     return c().a(
/* 134 */         g.c().a(cL).a(paramInt).b(l()));
/*     */   }
/*     */   
/*     */   public e u(int paramInt) {
/* 138 */     return c().a(
/* 139 */         g.c().a(cM)
/* 140 */         .a("page", 1)
/* 141 */         .a("limit", 250)
/* 142 */         .a("identifier", paramInt)
/* 143 */         .b(l()));
/*     */   }
/*     */   
/*     */   public e k(int paramInt, String paramString) {
/* 147 */     return c().a(
/* 148 */         g.c().a(cO).a(paramInt).a("batches", paramString).b(l()));
/*     */   }
/*     */   
/*     */   public e l(int paramInt, String paramString) {
/* 152 */     return c().a(
/* 153 */         g.c().a(cP).a(paramInt).a("batches", paramString).b(l()));
/*     */   }
/*     */   
/*     */   public String a(int paramInt1, long paramLong, int paramInt2) {
/* 157 */     f f = g.c().a(cN).a(paramInt1);
/* 158 */     if (paramLong > 0L) {
/* 159 */       f.a("lastIdentifier", paramLong);
/*     */     }
/* 161 */     f.a("page", paramInt2).a("limit", 250).b(l());
/*     */     
/* 163 */     return c().a(f).getData();
/*     */   }
/*     */   
/*     */   public e a(int paramInt, String paramString1, String paramString2) {
/* 167 */     i i1 = (new i()).c("batch", paramString1).c("value", paramString2);
/* 168 */     return c().a(
/* 169 */         g.e().a(cO).a(paramInt).a(i1).b(l()));
/*     */   }
/*     */   
/*     */   private Map<String, String> l() {
/* 173 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 174 */     hashMap.put("X-Token", cI);
/* 175 */     hashMap.put("ApiKey", a().bz());
/* 176 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean T() {
/* 181 */     return A.a().p("https://portal.licitanet.com.br/login");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, x paramx) {
/* 186 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, NameValuePair[] paramArrayOfNameValuePair, x paramx) {
/* 191 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */   
/*     */   private class b extends Exception {
/*     */     public b(a this$0) {
/* 196 */       super("Seu plano do Licitanet é o 'Plano Avulso', que não inclui acesso à API e impossibilita a adição de processos na plataforma.");
/*     */     }
/*     */   }
/*     */   
/*     */   private class a extends Exception {
/*     */     public a(a this$0) {
/* 202 */       super("");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\j\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */