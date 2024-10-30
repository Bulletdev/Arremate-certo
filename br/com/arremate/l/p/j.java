/*      */ package br.com.arremate.l.p;
/*      */ 
/*      */ import br.com.arremate.a.a;
/*      */ import br.com.arremate.a.a.c;
/*      */ import br.com.arremate.d.h.a;
/*      */ import br.com.arremate.f.o;
/*      */ import br.com.arremate.f.r;
/*      */ import br.com.arremate.f.v;
/*      */ import br.com.arremate.l.b;
/*      */ import br.com.arremate.l.d;
/*      */ import br.com.arremate.l.e;
/*      */ import br.com.arremate.l.g;
/*      */ import br.com.arremate.l.h;
/*      */ import br.com.arremate.l.h.a;
/*      */ import br.com.arremate.l.q.b.e;
/*      */ import br.com.arremate.l.q.b.i;
/*      */ import br.com.arremate.m.A;
/*      */ import br.com.arremate.m.l;
/*      */ import br.com.arremate.m.y;
/*      */ import java.text.DecimalFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import java.util.UUID;
/*      */ import org.e.f;
/*      */ import org.e.i;
/*      */ import org.slf4j.Logger;
/*      */ import org.slf4j.LoggerFactory;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class j
/*      */ {
/*   35 */   private static final Logger a = LoggerFactory.getLogger(j.class);
/*   36 */   private static final j a = new j();
/*   37 */   private static final String er = UUID.randomUUID().toString();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static j a() {
/*   43 */     return a;
/*      */   }
/*      */   
/*      */   public static String cj() {
/*   47 */     return er;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void O(boolean paramBoolean) {
/*      */     try {
/*   62 */       i i = s();
/*   63 */       i.b("lembrarme", paramBoolean);
/*      */       
/*   65 */       a("login", i);
/*   66 */     } catch (Exception exception) {
/*   67 */       a.error("Fail to track login()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void C(e parame) {
/*      */     try {
/*   78 */       i i = b(parame.a());
/*   79 */       i.a("item-id", parame.v());
/*   80 */       i.c("item-numero", parame.bo());
/*   81 */       i.a("valor-limite", parame.l());
/*   82 */       i.a("tipo-desconto", parame.w());
/*   83 */       i.a("quantidade", parame.i());
/*      */       
/*   85 */       a("alter-limit-item", i);
/*   86 */     } catch (Exception exception) {
/*   87 */       a.error("Fail to track alterLimitItem()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void D(e parame) {
/*      */     try {
/*   98 */       i i = b(parame.a());
/*   99 */       i.a("item-id", parame.v());
/*  100 */       i.c("item-numero", parame.bo());
/*  101 */       i.c("lance-fechado", parame.y());
/*  102 */       i.a("tipo-desconto", parame.w());
/*  103 */       i.a("quantidade", parame.i());
/*      */       
/*  105 */       a("alter-closed-bid-item", i);
/*  106 */     } catch (Exception exception) {
/*  107 */       a.error("Fail to track alterLimitItem()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void e(br.com.arremate.l.j paramj) {
/*      */     try {
/*  118 */       b b = paramj.b();
/*  119 */       i i = b(paramj);
/*      */       
/*  121 */       DecimalFormat decimalFormat = y.a("###,###,##0.0000");
/*  122 */       String str1 = decimalFormat.format(b.f());
/*  123 */       String str2 = decimalFormat.format(b.g());
/*      */       
/*  125 */       i.c("reducao-inicial", str1);
/*  126 */       i.c("reducao-final", str2);
/*  127 */       i.c("inicio-envio-lance", b.a(paramj));
/*  128 */       i.a("arredondar-casas-decimais", b.E());
/*  129 */       i.a("tipo-reducao", b.a().y());
/*  130 */       i.b("disputa-meepp", b.a(paramj.b(), paramj.a(), paramj.a()));
/*  131 */       i.c("percentual-meepp", b.h());
/*  132 */       i.b("lance-derradeiro", b.aD());
/*  133 */       i.b("disputa-segundo-quinto", b.aE());
/*  134 */       i.b("lance-inicio-disputa", b.aF());
/*  135 */       i.b("lance-virada-minuto", b.aG());
/*  136 */       i.b("cobrir-lance-virada-minuto", b.aH());
/*  137 */       i.a("tempo-extra-entre-lances", b.t());
/*  138 */       i.a("momento-enviar-lance-aberto", b.u());
/*  139 */       i.b("top-tres", b.aJ());
/*  140 */       i.b("manter-dez-porcento-primeiro-lugar", b.aK());
/*  141 */       i.c("percentual-primeiro-lugar", b.i());
/*  142 */       i.b("excluir-competidor", b.aL());
/*  143 */       i.a("posicao-excluir-competidor", b.F());
/*  144 */       i.a("momento-enviar-lance-fechado", b.w());
/*      */       
/*  146 */       a("update-config-bidding", i);
/*  147 */     } catch (Exception exception) {
/*  148 */       a.error("Fail to track updateConfigBidding()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(d paramd, int paramInt, boolean paramBoolean) {
/*      */     try {
/*  161 */       i i = s();
/*  162 */       i.a("empresa-cpnj", paramd.x());
/*  163 */       i.a("portal-id", paramInt);
/*  164 */       i.b("certificate", paramBoolean);
/*      */       
/*  166 */       a("register-company", i);
/*  167 */     } catch (Exception exception) {
/*  168 */       a.error("Fail to track registerCompany()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(br.com.arremate.l.j paramj, i parami) {
/*      */     try {
/*  180 */       i i1 = b(paramj);
/*      */       
/*  182 */       List list = parami.B();
/*  183 */       boolean bool = list.stream().anyMatch(paramg -> (paramg.w() == v.b.v()));
/*      */       
/*  185 */       i1.b("maior-desconto", bool);
/*  186 */       i1.b("grupo", !parami.G().isEmpty());
/*  187 */       i1.c("versao-arremate", "2.97.0");
/*      */       
/*  189 */       a("start-bidding", i1);
/*  190 */     } catch (Exception exception) {
/*  191 */       a.error("Fail to track startBidding()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(br.com.arremate.l.j paramj, boolean paramBoolean) {
/*      */     try {
/*  202 */       i i = b(paramj);
/*  203 */       i.b("is-user-input", paramBoolean);
/*  204 */       a("stop-bidding", i);
/*  205 */       i.c("versao-arremate", "2.97.0");
/*  206 */     } catch (Exception exception) {
/*  207 */       a.error("Fail to track stopBidding()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(br.com.arremate.l.j paramj, boolean paramBoolean, a parama, h paramh) {
/*      */     try {
/*  221 */       i i = b(paramj);
/*  222 */       i.c("versao-arremate", "2.97.0");
/*  223 */       i.b("login", paramBoolean);
/*  224 */       i.a("lote", parama.v());
/*  225 */       i.a("bid", paramh.m());
/*      */       
/*  227 */       a("send-bid-error-es", i);
/*  228 */     } catch (Exception exception) {
/*  229 */       a.error("Fail to track sendBidErrorES()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(br.com.arremate.l.j paramj, int paramInt) {
/*      */     try {
/*  241 */       i i = b(paramj);
/*  242 */       i.c("versao-arremate", "2.97.0");
/*  243 */       i.a("amount-running", paramInt);
/*      */       
/*  245 */       a("mising-recaptcha-sc", i);
/*  246 */     } catch (Exception exception) {
/*  247 */       a.error("Fail to track missingRecaptchaSC()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void b(br.com.arremate.l.j paramj, int paramInt) {
/*      */     try {
/*  259 */       i i = b(paramj);
/*  260 */       i.b("licitacao-srp", paramj.bf());
/*  261 */       i.b("licitacao-unitario", paramj.aZ());
/*  262 */       i.a("quantidade-itens", paramInt);
/*      */       
/*  264 */       a("add-bidding", i);
/*  265 */     } catch (Exception exception) {
/*  266 */       a.error("Fail to track addBidding()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(br.com.arremate.l.j paramj, String paramString) {
/*      */     try {
/*  278 */       i i = b(paramj);
/*  279 */       i.c("motivo-bloqueio", paramString);
/*      */       
/*  281 */       a("tried-add-bidding", i);
/*  282 */     } catch (Exception exception) {
/*  283 */       a.error("Fail to track triedAddBidding()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void f(br.com.arremate.l.j paramj) {
/*      */     try {
/*  294 */       i i = b(paramj);
/*  295 */       a("remove-bidding", i);
/*  296 */     } catch (Exception exception) {
/*  297 */       a.error("Fail to track removeBidding()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void ag(int paramInt) {
/*      */     try {
/*  308 */       i i = s();
/*  309 */       i.a("portal-id", paramInt);
/*      */       
/*  311 */       a("select-unavailable-portal", i);
/*  312 */     } catch (Exception exception) {
/*  313 */       a.error("Fail to track selectUnavailablePortal()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void b(e parame, List<h> paramList) {
/*      */     try {
/*  330 */       i i = b(parame.a());
/*  331 */       i.a("item-id", parame.v());
/*  332 */       i.c("item-numero", parame.bo());
/*  333 */       i.a("valor-limite", parame.l());
/*  334 */       i.a("ultimo-lance", parame.f());
/*  335 */       i.a("melhor-lance", parame.f().m());
/*      */       
/*  337 */       f f = new f();
/*  338 */       byte b = 0;
/*  339 */       while (b < paramList.size() && b < 5) {
/*  340 */         f.a(((h)paramList.get(b)).m());
/*  341 */         b++;
/*      */       } 
/*      */       
/*  344 */       if (f.length() > 0) {
/*  345 */         i.c("lista-lances", f);
/*      */       }
/*      */       
/*  348 */       a("better-bids-item", i);
/*  349 */     } catch (Exception exception) {
/*  350 */       a.error("Fail to track betterBidsItem()", exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(int paramInt, double paramDouble1, double paramDouble2) {
/*      */     try {
/*  356 */       i i = s();
/*  357 */       i.a("numberRequests", paramInt);
/*  358 */       i.a("success", paramDouble1);
/*  359 */       i.a("latency", paramDouble2);
/*      */       
/*  361 */       a("comprasnetBestBidsLog", i);
/*  362 */     } catch (Exception exception) {
/*  363 */       a.error("Fail to track comprasnetBestBidsLog", exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, double paramDouble1, double paramDouble2) {
/*      */     try {
/*  369 */       i i = s();
/*  370 */       i.a("company", c.a().getCode());
/*  371 */       i.b("withCertificate", paramBoolean3);
/*      */       
/*  373 */       i.a("numberRequests", paramInt);
/*  374 */       i.a("successToken", paramBoolean1 ? 100 : 0);
/*  375 */       i.a("successLogin", paramBoolean2 ? 100 : 0);
/*  376 */       i.a("latencyToken", paramDouble1);
/*  377 */       i.a("latencyLogin", paramDouble2);
/*      */       
/*  379 */       a("comprasnetLoginLog", i);
/*  380 */     } catch (Exception exception) {
/*  381 */       a.error("Fail to track comprasnetLoginLog", exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(boolean paramBoolean, long paramLong1, long paramLong2) {
/*      */     try {
/*  387 */       i i = s();
/*  388 */       i.a("successInt", paramBoolean ? 100 : 0);
/*  389 */       i.c("action", "genAction");
/*      */       
/*  391 */       double d = paramLong1 / 1000.0D;
/*  392 */       i.a("latency_token", d);
/*      */       
/*  394 */       d = paramLong2 / 1000.0D;
/*  395 */       i.a("latency_request", d);
/*      */       
/*  397 */       a("recaptcha-token-bll", i);
/*  398 */     } catch (Exception exception) {
/*  399 */       a.error("Fail to track recatpchaTokenBLL()", exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void b(boolean paramBoolean, long paramLong1, long paramLong2) {
/*      */     try {
/*  405 */       i i = s();
/*  406 */       i.a("successInt", paramBoolean ? 100 : 0);
/*  407 */       i.c("action", "genAction");
/*      */       
/*  409 */       double d = paramLong1 / 1000.0D;
/*  410 */       i.a("latency_token", d);
/*      */       
/*  412 */       d = paramLong2 / 1000.0D;
/*  413 */       i.a("latency_request", d);
/*      */       
/*  415 */       a("recaptcha-bll-token-queue", i);
/*  416 */     } catch (Exception exception) {
/*  417 */       a.error("Fail to track recatpchaTokenBLL()", exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(boolean paramBoolean, long paramLong) {
/*  422 */     c(paramBoolean, paramLong, 0L);
/*      */   }
/*      */   
/*      */   public void c(boolean paramBoolean, long paramLong1, long paramLong2) {
/*      */     try {
/*  427 */       i i = s();
/*  428 */       i.a("successInt", paramBoolean ? 100 : 0);
/*  429 */       i.c("action", "genAction");
/*      */       
/*  431 */       double d = paramLong1 / 1000.0D;
/*  432 */       i.a("latency_token", d);
/*      */       
/*  434 */       d = paramLong2 / 1000.0D;
/*  435 */       i.a("latency_request", d);
/*      */       
/*  437 */       a("recaptcha-token-bnc", i);
/*  438 */     } catch (Exception exception) {
/*  439 */       a.error("Fail to track recatpchaTokenBNC()", exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void b(boolean paramBoolean, long paramLong) {
/*  444 */     d(paramBoolean, paramLong, 0L);
/*      */   }
/*      */   
/*      */   public void d(boolean paramBoolean, long paramLong1, long paramLong2) {
/*      */     try {
/*  449 */       i i = s();
/*  450 */       i.a("successInt", paramBoolean ? 100 : 0);
/*      */       
/*  452 */       double d = paramLong1 / 1000.0D;
/*  453 */       i.a("latency_token", d);
/*      */       
/*  455 */       d = paramLong2 / 1000.0D;
/*  456 */       i.a("latency_request", d);
/*      */       
/*  458 */       a("recaptcha-token-paradigma", i);
/*  459 */     } catch (Exception exception) {
/*  460 */       a.error("Fail to track recatpchaTokenParadigma()", exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(String paramString, boolean paramBoolean, long paramLong) {
/*  465 */     a("", paramString, paramBoolean, paramLong, 0L, 0);
/*      */   }
/*      */   
/*      */   public void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, int paramInt) {
/*      */     try {
/*  470 */       i i = s();
/*  471 */       i.c("client_host", paramString1);
/*  472 */       i.c("url", paramString2);
/*  473 */       i.a("company", c.a().getCode());
/*      */       
/*  475 */       i.a("successInt", paramBoolean ? 100 : 0);
/*      */       
/*  477 */       double d = paramLong1 / 1000.0D;
/*  478 */       i.a("latency_token", d);
/*      */       
/*  480 */       d = paramLong2 / 1000.0D;
/*  481 */       i.a("latency_request", d);
/*      */       
/*  483 */       i.a("status_code", paramInt);
/*      */       
/*  485 */       a("hcaptcha-token-cn", i);
/*  486 */     } catch (Exception exception) {
/*  487 */       a.error("Fail to track tokenBiddingRoomCN()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(a parama, br.com.arremate.l.j paramj) {
/*      */     try {
/*  496 */       i i = s();
/*  497 */       i.a("numberRequests", parama.q());
/*  498 */       i.a("success", parama.b());
/*  499 */       i.a("latency", parama.c());
/*  500 */       i.c("cnpj", paramj.a().aw());
/*  501 */       i.a("portal", paramj.b().v());
/*  502 */       i.a("biddingId", paramj.v());
/*  503 */       i.c("statusCodes", parama.k());
/*      */       
/*  505 */       a("comprasPublicasStatusBiddingLog", i);
/*  506 */     } catch (Exception exception) {
/*  507 */       a.error("Fail to track comprasPublicasStatusBiddingLog", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void b(a parama, br.com.arremate.l.j paramj) {
/*      */     try {
/*  516 */       i i = s();
/*  517 */       i.a("numberRequests", parama.q());
/*  518 */       i.a("success", parama.b());
/*  519 */       i.a("latency", parama.c());
/*  520 */       i.c("cnpj", paramj.a().aw());
/*  521 */       i.a("portal", paramj.b().v());
/*  522 */       i.a("biddingId", paramj.v());
/*  523 */       i.c("statusCodes", parama.k());
/*      */       
/*  525 */       a("comprasPublicasItemsInDisputeLog", i);
/*  526 */     } catch (Exception exception) {
/*  527 */       a.error("Fail to track comprasPublicasItemsInDisputeLog", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void c(a parama, br.com.arremate.l.j paramj) {
/*      */     try {
/*  536 */       i i = s();
/*  537 */       i.a("numberRequests", parama.q());
/*  538 */       i.a("success", parama.b());
/*  539 */       i.a("latency", parama.c());
/*  540 */       i.c("cnpj", paramj.a().aw());
/*  541 */       i.a("portal", paramj.b().v());
/*  542 */       i.a("biddingId", paramj.v());
/*  543 */       i.c("statusCodes", parama.k());
/*      */       
/*  545 */       a("comprasPublicasBiddingMessagesLog", i);
/*  546 */     } catch (Exception exception) {
/*  547 */       a.error("Fail to track comprasPublicasBiddingMessagesLog", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void g(br.com.arremate.l.j paramj) {
/*      */     try {
/*  558 */       i i = b(paramj);
/*  559 */       a("view-finished-itens", i);
/*  560 */     } catch (Exception exception) {
/*  561 */       a.error("Fail to track viewFinishedItens()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void c(e parame, List<h> paramList) {
/*      */     try {
/*  573 */       i i = b(parame.a());
/*  574 */       i.a("item-id", parame.v());
/*  575 */       i.c("item-numero", parame.bo());
/*  576 */       i.a("valor-limite", parame.l());
/*  577 */       i.a("ultimo-lance", parame.f());
/*  578 */       i.a("melhor-lance", parame.f().m());
/*      */       
/*  580 */       f f = new f();
/*  581 */       byte b = 0;
/*  582 */       while (b < paramList.size() && b < 5) {
/*  583 */         i i1 = new i();
/*  584 */         h h = paramList.get(b);
/*      */         
/*  586 */         i1.a("valor", h.m());
/*  587 */         i1.c("empresa-cnpj", h.av());
/*  588 */         i1.c("empresa-nome", h.ay());
/*  589 */         i1.c("marca", h.bH());
/*  590 */         i1.c("fabricante", h.bI());
/*  591 */         f.a(i1);
/*      */         
/*  593 */         b++;
/*      */       } 
/*      */       
/*  596 */       if (f.length() > 0) {
/*  597 */         i.c("lista-lances", f);
/*      */       }
/*      */       
/*  600 */       a("better-bids-finished-item", i);
/*  601 */     } catch (Exception exception) {
/*  602 */       a.error("Fail to track betterBidsFinishedItem()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void g(g paramg) {
/*      */     try {
/*  613 */       br.com.arremate.l.j j1 = paramg.a();
/*  614 */       b b = paramg.b();
/*  615 */       i i = b(j1);
/*      */       
/*  617 */       DecimalFormat decimalFormat = y.a("###,###,##0.0000");
/*  618 */       String str1 = decimalFormat.format(b.f());
/*  619 */       String str2 = decimalFormat.format(b.g());
/*      */       
/*  621 */       i.c("reducao-inicial", str1);
/*  622 */       i.c("reducao-final", str2);
/*  623 */       i.a("posicao-disputa", paramg.j());
/*  624 */       i.c("inicio-envio-lance", b.a(j1));
/*  625 */       i.a("arredondar-casas-decimais", b.E());
/*  626 */       i.a("tipo-reducao", b.a().y());
/*  627 */       i.b("disputa-meepp", b.a(j1.b(), j1.a(), j1.a()));
/*  628 */       i.c("percentual-meepp", b.h());
/*  629 */       i.b("lance-derradeiro", b.aD());
/*  630 */       i.b("disputa-segundo-quinto", b.aE());
/*  631 */       i.b("lance-inicio-disputa", b.aF());
/*  632 */       i.b("lance-virada-minuto", b.aG());
/*  633 */       i.b("cobrir-lance-virada-minuto", b.aH());
/*  634 */       i.a("tempo-extra-entre-lances", b.t());
/*  635 */       i.a("momento-enviar-lance-aberto", b.u());
/*  636 */       i.b("top-tres", b.aJ());
/*  637 */       i.b("manter-dez-porcento-primeiro-lugar", b.aK());
/*  638 */       i.c("percentual-primeiro-lugar", b.i());
/*  639 */       i.b("excluir-competidor", b.aL());
/*  640 */       i.a("posicao-excluir-competidor", b.F());
/*  641 */       i.a("momento-enviar-lance-fechado", b.w());
/*      */       
/*  643 */       a("update-config-item", i);
/*  644 */     } catch (Exception exception) {
/*  645 */       a.error("Fail to track updateConfigItem()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(e parame) {
/*      */     try {
/*  656 */       br.com.arremate.l.j j1 = parame.a();
/*  657 */       b b = parame.b();
/*  658 */       i i = b(j1);
/*      */       
/*  660 */       DecimalFormat decimalFormat = y.a("###,###,##0.0000");
/*  661 */       String str1 = decimalFormat.format(b.f());
/*  662 */       String str2 = decimalFormat.format(b.g());
/*      */       
/*  664 */       i.c("reducao-inicial", str1);
/*  665 */       i.c("reducao-final", str2);
/*  666 */       i.a("posicao-disputa", parame.j());
/*  667 */       i.c("inicio-envio-lance", b.a(j1));
/*  668 */       i.a("arredondar-casas-decimais", b.E());
/*  669 */       i.a("tipo-reducao", b.a().y());
/*  670 */       i.b("disputa-meepp", b.a(j1.b(), j1.a(), j1.a()));
/*  671 */       i.c("percentual-meepp", b.h());
/*  672 */       i.b("lance-derradeiro", b.aD());
/*  673 */       i.b("disputa-segundo-quinto", b.aE());
/*  674 */       i.b("lance-inicio-disputa", b.aF());
/*  675 */       i.b("lance-virada-minuto", b.aG());
/*  676 */       i.b("cobrir-lance-virada-minuto", b.aH());
/*  677 */       i.a("tempo-extra-entre-lances", b.t());
/*  678 */       i.a("momento-enviar-lance-aberto", b.u());
/*  679 */       i.b("top-tres", b.aJ());
/*  680 */       i.b("manter-dez-porcento-primeiro-lugar", b.aK());
/*  681 */       i.c("percentual-primeiro-lugar", b.i());
/*  682 */       i.b("excluir-competidor", b.aL());
/*  683 */       i.a("posicao-excluir-competidor", b.F());
/*      */       
/*  685 */       a("update-config-group", i);
/*  686 */     } catch (Exception exception) {
/*  687 */       a.error("Fail to track updateConfigGroup()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(e parame, double paramDouble) {
/*      */     try {
/*  699 */       i i = b(parame.a());
/*  700 */       i.a("item-id", parame.v());
/*  701 */       i.c("item-numero", parame.bo());
/*  702 */       i.a("valor-lance-manual", paramDouble);
/*      */       
/*  704 */       a("manual-bid", i);
/*  705 */     } catch (Exception exception) {
/*  706 */       a.error("Fail to track manualBid()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void h(br.com.arremate.l.j paramj) {
/*      */     try {
/*  717 */       i i = b(paramj);
/*  718 */       a("open-bidding-details", i);
/*  719 */     } catch (Exception exception) {
/*  720 */       a.error("Fail to track openBiddingDetails()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void i(br.com.arremate.l.j paramj) {
/*      */     try {
/*  731 */       i i = b(paramj);
/*  732 */       a("view-bidding-operations", i);
/*  733 */     } catch (Exception exception) {
/*  734 */       a.error("Fail to track viewBiddingOperations()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void l(List<String> paramList) {
/*      */     try {
/*  745 */       i i = s();
/*  746 */       f f = new f();
/*      */       
/*  748 */       paramList.forEach(paramString -> paramf.a(y.Z(paramString)));
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  753 */       if (f.length() > 0) {
/*  754 */         i.c("mensagens", f);
/*      */       }
/*      */       
/*  757 */       a("open-menu-status-effecti", i);
/*  758 */     } catch (Exception exception) {
/*  759 */       a.error("Fail to track openMenuWarnings()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(br.com.arremate.m.j paramj, boolean paramBoolean) {
/*      */     try {
/*  771 */       i i = s();
/*  772 */       i.b("aberto-pelo-menu", paramBoolean);
/*  773 */       i.c("sistema-operacional", y.Z(paramj.getOperatingSystem()));
/*  774 */       i.c("processador", y.Z(paramj.ct()));
/*  775 */       i.c("memoria", y.Z(paramj.cu()));
/*  776 */       i.c("versao-java", paramj.cv());
/*  777 */       i.c("internet-velociade", y.Z(paramj.cw()));
/*  778 */       i.b("configuracao-minima", paramj.bN());
/*  779 */       i.b("configuracao-ideal", paramj.bO());
/*      */       
/*  781 */       a("computational-requirements", i);
/*  782 */     } catch (Exception exception) {
/*  783 */       a.error("Fail to track computationalRequirements()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void cv() {
/*      */     try {
/*  790 */       i i = s();
/*  791 */       a("open-screen-about", i);
/*  792 */     } catch (Exception exception) {
/*  793 */       a.error("Fail to track openScreenAbout()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(boolean paramBoolean1, boolean paramBoolean2) {
/*      */     try {
/*  805 */       i i = s();
/*  806 */       i.b("filtro-numero", paramBoolean1);
/*  807 */       i.b("filtro-uasg", paramBoolean2);
/*      */       
/*  809 */       a("filter-add-bidding", i);
/*  810 */     } catch (Exception exception) {
/*  811 */       a.error("Fail to track filterAddBidding()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void j(br.com.arremate.l.j paramj) {
/*      */     try {
/*  827 */       i i = b(paramj);
/*  828 */       a("export-itens", i);
/*  829 */     } catch (Exception exception) {
/*  830 */       a.error("Fail to track exportItens()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void k(br.com.arremate.l.j paramj) {
/*      */     try {
/*  841 */       i i = b(paramj);
/*  842 */       a("export-finished-itens", i);
/*  843 */     } catch (Exception exception) {
/*  844 */       a.error("Fail to track exportFinishedItens()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void l(br.com.arremate.l.j paramj) {
/*      */     try {
/*  855 */       i i = b(paramj);
/*  856 */       a("import-itens", i);
/*  857 */     } catch (Exception exception) {
/*  858 */       a.error("Fail to track importItens()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void d(String paramString1, String paramString2) {
/*      */     try {
/*  870 */       i i = s();
/*  871 */       i.c("atalho", paramString1);
/*  872 */       i.c("evento", y.Z(paramString2));
/*      */       
/*  874 */       a("shortcut-keyboard", i);
/*  875 */     } catch (Exception exception) {
/*  876 */       a.error("Fail to track shortcutKeyboard()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void E(e parame) {
/*      */     try {
/*  887 */       i i = b(parame.a());
/*  888 */       i.a("item-id", parame.v());
/*  889 */       i.c("item-numero", parame.bo());
/*  890 */       i.a("valor-limite", parame.l());
/*  891 */       i.a("ultimo-lance", parame.f());
/*  892 */       i.a("melhor-lance", parame.f().m());
/*      */       
/*  894 */       if (parame.a() == r.a) {
/*  895 */         i.c("acao", "play");
/*      */       } else {
/*  897 */         i.c("acao", "pause");
/*      */       } 
/*      */       
/*  900 */       a("play-pause-item", i);
/*  901 */     } catch (Exception exception) {
/*  902 */       a.error("Fail to track playPauseItem()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void aF(String paramString) {
/*      */     try {
/*  913 */       i i = s();
/*  914 */       i.c("texto", y.Z(paramString));
/*      */       
/*  916 */       a("view-payment-history", i);
/*  917 */     } catch (Exception exception) {
/*  918 */       a.error("Fail to track viewPaymentHistory()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void P(boolean paramBoolean) {
/*      */     try {
/*  929 */       i i = s();
/*  930 */       i.b("aberto", paramBoolean);
/*      */       
/*  932 */       a("open-chat", i);
/*  933 */     } catch (Exception exception) {
/*  934 */       a.error("Fail to track openClientService()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(boolean paramBoolean, int paramInt, String paramString) {
/*      */     try {
/*  947 */       i i = s();
/*  948 */       i.b("aberto", paramBoolean);
/*  949 */       i.a("incidente-id", paramInt);
/*  950 */       i.c("titulo", y.Z(paramString));
/*      */       
/*  952 */       a("open-status-effecti", i);
/*  953 */     } catch (Exception exception) {
/*  954 */       a.error("Fail to track statusEffecti()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void Q(boolean paramBoolean) {
/*      */     try {
/*  965 */       i i = s();
/*  966 */       i.b("sucesso", paramBoolean);
/*      */       
/*  968 */       a("remove-finished-bidding", i);
/*  969 */     } catch (Exception exception) {
/*  970 */       a.error("Fail to track removeFinishedBidding()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void m(br.com.arremate.l.j paramj) {
/*      */     try {
/*  981 */       i i = b(paramj);
/*  982 */       a("search-bidding-function", i);
/*  983 */     } catch (Exception exception) {
/*  984 */       a.error("Fail to track searchBiddingFunction()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void n(br.com.arremate.l.j paramj) {
/*      */     try {
/*  996 */       i i = b(paramj);
/*  997 */       a("alter-limit-function", i);
/*  998 */     } catch (Exception exception) {
/*  999 */       a.error("Fail to track alterLimitFunction()", exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void m(List<String> paramList) {
/*      */     try {
/* 1005 */       i i = s();
/*      */       
/* 1007 */       paramList = y.a((ArrayList)paramList);
/* 1008 */       i.c("notification-list", new f(paramList));
/*      */       
/* 1010 */       a("open-notifications-menu", i);
/* 1011 */     } catch (Exception exception) {
/* 1012 */       a.error("Fail to track openNotificationsMenu()", exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(int paramInt1, int paramInt2, String paramString) {
/*      */     try {
/* 1018 */       i i = s();
/* 1019 */       i.a("notification-code", paramInt1);
/* 1020 */       i.a("notification-type", paramInt2);
/* 1021 */       i.c("title-message", y.Z(paramString));
/*      */       
/* 1023 */       a("open-notification", i);
/* 1024 */     } catch (Exception exception) {
/* 1025 */       a.error("Fail to track openNotification()", exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void o(br.com.arremate.l.j paramj) {
/*      */     try {
/* 1031 */       i i = b(paramj);
/* 1032 */       a("hide-bidding", i);
/* 1033 */     } catch (Exception exception) {
/* 1034 */       a.error("Fail to track hideBidding()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(br.com.arremate.l.j paramj, long paramLong) {
/*      */     try {
/* 1045 */       i i = b(paramj);
/* 1046 */       i.a("time", paramLong);
/* 1047 */       a("time-between-bids", i);
/* 1048 */     } catch (Exception exception) {
/* 1049 */       a.error("Fail to track timeBetweenBids()", exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(g paramg, long paramLong) {
/*      */     try {
/* 1055 */       i i = b(paramg.a());
/* 1056 */       i.c("item-number", paramg.bo());
/* 1057 */       i.a("time", paramLong);
/* 1058 */       a("time-between-bids", i);
/* 1059 */     } catch (Exception exception) {
/* 1060 */       a.error("Fail to track timeBetweenBids()", exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(e parame, long paramLong) {
/*      */     try {
/* 1066 */       i i = b(parame.a());
/* 1067 */       i.c("item-number", parame.K());
/* 1068 */       i.a("time", paramLong);
/* 1069 */       a("time-between-bids", i);
/* 1070 */     } catch (Exception exception) {
/* 1071 */       a.error("Fail to track timeBetweenBids()", exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(boolean paramBoolean, o paramo) {
/*      */     try {
/* 1077 */       i i = s();
/* 1078 */       i.b("sucesso", paramBoolean);
/* 1079 */       i.a("portal", l.a().a(paramo).v());
/*      */       
/* 1081 */       a("used-captcha-base64", i);
/* 1082 */     } catch (Exception exception) {
/* 1083 */       a.error("Fail to track getCaptchaBase64()", exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void b(boolean paramBoolean, o paramo) {
/*      */     try {
/* 1089 */       i i = s();
/* 1090 */       i.b("sucesso", paramBoolean);
/* 1091 */       i.a("portal", l.a().a(paramo).v());
/*      */       
/* 1093 */       a("used-recaptcha-v2", i);
/* 1094 */     } catch (Exception exception) {
/* 1095 */       a.error("Fail to track getReCaptchaV2()", exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void c(boolean paramBoolean, o paramo) {
/*      */     try {
/* 1101 */       i i = s();
/* 1102 */       i.b("sucesso", paramBoolean);
/* 1103 */       i.a("portal", l.a().a(paramo).v());
/*      */       
/* 1105 */       a("used-recaptcha-v3", i);
/* 1106 */     } catch (Exception exception) {
/* 1107 */       a.error("Fail to track getReCaptchaV3()", exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(boolean paramBoolean, o paramo, String paramString, int paramInt) {
/*      */     try {
/* 1113 */       i i = s();
/* 1114 */       i.b("success", paramBoolean);
/* 1115 */       i.a("portal", l.a().a(paramo).v());
/* 1116 */       i.c("url", paramString);
/* 1117 */       i.a("attempt", paramInt);
/*      */       
/* 1119 */       a("used-amazon-captcha", i);
/* 1120 */     } catch (Exception exception) {
/* 1121 */       a.error("Fail to track getReCaptchaV2()", exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void cw() {
/*      */     try {
/* 1127 */       i i = s();
/*      */       
/* 1129 */       a("heartbeat", i);
/* 1130 */     } catch (Exception exception) {
/* 1131 */       a.error("Fail to track heartbeatEvent()", exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void p(br.com.arremate.l.j paramj) {
/*      */     try {
/* 1137 */       i i = b(paramj);
/* 1138 */       i.a("cnpj", paramj.a().x());
/* 1139 */       a("heartbeat-bidding", i);
/* 1140 */     } catch (Exception exception) {
/* 1141 */       a.error("Fail to track heartbeatBiddingEvent()", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private i s() {
/* 1156 */     i i = new i();
/* 1157 */     i.c("session-id", er);
/* 1158 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private i b(br.com.arremate.l.j paramj) {
/* 1167 */     i i = new i();
/* 1168 */     i.c("session-id", er);
/* 1169 */     i.a("licitacao-id", paramj.v());
/* 1170 */     i.a("portal-id", (paramj.b().v() == 22222) ? 2 : paramj.b().v());
/* 1171 */     i.a("licitacao-uasg", paramj.K());
/* 1172 */     i.c("licitacao-numero", paramj.bo());
/* 1173 */     i.a("modo-disputa", paramj.a().getId());
/* 1174 */     i.a("modalidade", paramj.a().getId());
/* 1175 */     i.b("icms", paramj.k());
/* 1176 */     i.b("licitacao-srp", paramj.bf());
/* 1177 */     i.b("licitacao-unitario", paramj.aZ());
/*      */     
/* 1179 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void a(String paramString, i parami) {
/* 1189 */     (new Thread(() -> {
/*      */           i i1 = new i();
/*      */           
/*      */           i1.c("ipOrigin", A.a().cA());
/*      */           i1.c("event", paramString);
/*      */           i1.c("properties", parami);
/*      */           a.a().a(i1);
/* 1196 */         })).start();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\p\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */