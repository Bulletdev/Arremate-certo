/*     */ package br.com.arremate.j;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.f.x;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.m.A;
/*     */ import br.com.arremate.m.y;
/*     */ import java.net.URI;
/*     */ import java.security.cert.CertificateException;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Set;
/*     */ import javax.net.ssl.HostnameVerifier;
/*     */ import javax.net.ssl.SSLContext;
/*     */ import javax.swing.text.MaskFormatter;
/*     */ import org.apache.commons.codec.binary.Base64;
/*     */ import org.apache.commons.io.IOUtils;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.client.CookieStore;
/*     */ import org.apache.http.client.RedirectStrategy;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.client.entity.UrlEncodedFormEntity;
/*     */ import org.apache.http.client.methods.CloseableHttpResponse;
/*     */ import org.apache.http.client.methods.HttpGet;
/*     */ import org.apache.http.client.methods.HttpUriRequest;
/*     */ import org.apache.http.client.methods.RequestBuilder;
/*     */ import org.apache.http.conn.ssl.NoopHostnameVerifier;
/*     */ import org.apache.http.conn.ssl.SSLContexts;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.apache.http.entity.StringEntity;
/*     */ import org.apache.http.impl.client.BasicCookieStore;
/*     */ import org.apache.http.impl.client.CloseableHttpClient;
/*     */ import org.apache.http.impl.client.HttpClients;
/*     */ import org.apache.http.impl.client.LaxRedirectStrategy;
/*     */ import org.apache.http.message.BasicHeader;
/*     */ import org.apache.http.message.BasicNameValuePair;
/*     */ import org.apache.http.util.EntityUtils;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ public class d extends i {
/*     */   private final BasicCookieStore a;
/*  51 */   private int at = 0;
/*     */   
/*     */   private final CloseableHttpClient a;
/*  54 */   private static final String bI = String.join("", new CharSequence[] { "https://www1.compras.mg.gov.br/", "principal.html" }); private a a; private static final String DOMAIN = "https://www1.compras.mg.gov.br/";
/*  55 */   private static final String bJ = String.join("", new CharSequence[] { "https://www1.compras.mg.gov.br/", "j_acegi_security_check" });
/*  56 */   private static final String bK = String.join("", new CharSequence[] { "https://www1.compras.mg.gov.br/", "servico/pregao/lances-representante/enviarLance" });
/*     */   
/*     */   public d(br.com.arremate.l.d paramd) {
/*  59 */     a(paramd);
/*  60 */     this.a = (a)new BasicCookieStore();
/*     */     
/*  62 */     SSLContext sSLContext = null;
/*     */     try {
/*  64 */       sSLContext = SSLContexts.custom().loadTrustMaterial(null, (paramArrayOfX509Certificate, paramString) -> true).build();
/*  65 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/*  68 */     RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(180000).setConnectionRequestTimeout(180000).setSocketTimeout(180000).build();
/*     */     
/*  70 */     this
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  77 */       .a = (a)HttpClients.custom().setSSLContext(sSLContext).setSSLHostnameVerifier((HostnameVerifier)new NoopHostnameVerifier()).setDefaultRequestConfig(requestConfig).setDefaultCookieStore((CookieStore)this.a).setConnectionManagerShared(true).setRedirectStrategy((RedirectStrategy)new LaxRedirectStrategy()).build();
/*     */   }
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
/*     */   public int z() {
/*  96 */     byte b = 0;
/*     */     
/*     */     try {
/*  99 */       this.a.clear();
/*     */       
/* 101 */       NameValuePair[] arrayOfNameValuePair = new NameValuePair[9];
/* 102 */       arrayOfNameValuePair[0] = (NameValuePair)new BasicNameValuePair("j_username", as() + "|" + ax() + (a().aP() ? "|R|SSC" : "|R"));
/*     */       
/* 104 */       arrayOfNameValuePair[1] = (NameValuePair)new BasicNameValuePair("j_password", getPassword());
/* 105 */       arrayOfNameValuePair[2] = (NameValuePair)new BasicNameValuePair("cpfRep", as());
/* 106 */       arrayOfNameValuePair[3] = (NameValuePair)new BasicNameValuePair("cnpjCpf", ax());
/* 107 */       arrayOfNameValuePair[4] = (NameValuePair)new BasicNameValuePair("tipoLogin", "R");
/* 108 */       arrayOfNameValuePair[5] = (NameValuePair)new BasicNameValuePair("matricula", "");
/* 109 */       arrayOfNameValuePair[6] = (NameValuePair)new BasicNameValuePair("cpfRespMat", "");
/* 110 */       arrayOfNameValuePair[7] = (NameValuePair)new BasicNameValuePair("unidade", "");
/* 111 */       arrayOfNameValuePair[8] = (NameValuePair)new BasicNameValuePair("cnpjCpfResponsavel", "");
/*     */       
/* 113 */       String str = a(bJ, arrayOfNameValuePair);
/*     */       
/* 115 */       if (str != null) {
/* 116 */         if (str.toLowerCase().contains("os dados digitados são inválidos")) {
/* 117 */           b = 2;
/*     */         } else {
/* 119 */           Document document = Jsoup.parse(str);
/* 120 */           Elements elements = document.select("span[class=textcorpo]");
/*     */           
/* 122 */           if (elements != null && !elements.isEmpty()) {
/* 123 */             String str1 = elements.first().text();
/*     */             
/* 125 */             E(str1);
/* 126 */             setRunning(true);
/* 127 */             b = 1;
/*     */             
/* 129 */             this.a = new a(this, this);
/* 130 */             this.a.setName("SessionRenewerMG_" + getUser());
/* 131 */             this.a.start();
/*     */           } 
/*     */         } 
/*     */       }
/* 135 */     } catch (Exception exception) {
/* 136 */       exception.printStackTrace();
/*     */     } 
/*     */     
/* 139 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   public void b() {
/*     */     try {
/* 145 */       setRunning(false);
/* 146 */       this.a.close();
/* 147 */       this.a.interrupt();
/* 148 */     } catch (Exception exception) {}
/*     */   }
/*     */ 
/*     */   
/*     */   public String a(br.com.arremate.l.k.a parama, double paramDouble, boolean paramBoolean) {
/*     */     try {
/*     */       DecimalFormat decimalFormat;
/* 155 */       if (paramBoolean) {
/* 156 */         decimalFormat = y.a("###,###,##0.0000");
/*     */       } else {
/* 158 */         decimalFormat = y.a("###,###,##0.00");
/*     */       } 
/* 160 */       String str = decimalFormat.format(paramDouble);
/*     */ 
/*     */       
/* 163 */       if (k.b()) {
/* 164 */         i i1 = new i();
/* 165 */         i1.c("idLoteSelecionado", Integer.toString(parama.v()));
/* 166 */         i1.c("valorDoLance", str);
/*     */         
/* 168 */         return a(i1.toString(), parama.a().v());
/*     */       } 
/* 170 */     } catch (Exception exception) {
/* 171 */       a.warn("Erro ao enviar lance", exception);
/*     */     } 
/* 173 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, x paramx) {
/* 178 */     return a(paramString, paramx).getData();
/*     */   }
/*     */   
/*     */   private e m(String paramString) {
/* 182 */     return a(paramString, x.a);
/*     */   }
/*     */   
/*     */   private e a(String paramString, x paramx) {
/* 186 */     HttpGet httpGet = new HttpGet(paramString);
/*     */ 
/*     */     
/* 189 */     try { httpGet.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
/* 190 */       httpGet.addHeader("Accept-Encoding", "gzip,deflate,sdch");
/* 191 */       httpGet.addHeader("Accept-Language", "en-US,en;q=0.8,pt-BR;q=0.6,pt;q=0.4");
/* 192 */       httpGet.addHeader("Cache-Control", "no-cache");
/* 193 */       httpGet.addHeader("Connection", "keep-alive");
/* 194 */       httpGet.addHeader("Host", "www1.compras.mg.gov.br");
/* 195 */       httpGet.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.111 Safari/537.36");
/*     */       
/* 197 */       String str = P();
/*     */       
/* 199 */       if (str.length() > 0) {
/* 200 */         httpGet.addHeader("Cookie", str);
/*     */       }
/*     */       
/* 203 */       return a((HttpUriRequest)httpGet, paramx); }
/* 204 */     catch (Exception exception) {  }
/*     */     finally
/* 206 */     { httpGet.releaseConnection(); }
/*     */ 
/*     */     
/* 209 */     return new e();
/*     */   }
/*     */   
/*     */   private String a(String paramString, int paramInt) {
/* 213 */     String str = "";
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 219 */       HttpUriRequest httpUriRequest = RequestBuilder.post().setUri(new URI(bK)).setEntity((HttpEntity)new StringEntity(paramString, "UTF8")).build();
/*     */       
/* 221 */       httpUriRequest.addHeader((Header)new BasicHeader("Host", "www1.compras.mg.gov.br"));
/* 222 */       httpUriRequest.addHeader((Header)new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:79.0) Gecko/20100101 Firefox/79.0"));
/* 223 */       httpUriRequest.addHeader((Header)new BasicHeader("Accept", "application/json, text/plain, */*"));
/* 224 */       httpUriRequest.addHeader((Header)new BasicHeader("Accept-Language", "pt-BR,pt;q=0.8,en-US;q=0.5,en;q=0.3"));
/* 225 */       httpUriRequest.addHeader((Header)new BasicHeader("Accept-Encoding", "gzip, deflate, br"));
/* 226 */       httpUriRequest.addHeader((Header)new BasicHeader("Content-Type", "application/json;charset=utf-8"));
/* 227 */       httpUriRequest.addHeader((Header)new BasicHeader("Origin", "https://www1.compras.mg.gov.br"));
/* 228 */       httpUriRequest.addHeader((Header)new BasicHeader("Connection", "keep-alive"));
/* 229 */       httpUriRequest.addHeader((Header)new BasicHeader("Referer", "https://www1.compras.mg.gov.br/processocompra/pregao/eletronico/encaminhamento/lances/abaLotesPregaoEletronico.html?aba=abaLotesPregao&metodo=pesquisar&idPregao=" + paramInt));
/*     */       
/* 231 */       str = a(httpUriRequest, x.a).getData();
/* 232 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 235 */     return str;
/*     */   }
/*     */   
/*     */   private String g(String paramString1, String paramString2) {
/* 239 */     String str = "";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 246 */       HttpUriRequest httpUriRequest = RequestBuilder.post().setUri(new URI(paramString1)).setEntity((HttpEntity)new StringEntity(paramString2, "UTF8")).setHeader("Content-type", "application/json").build();
/*     */       
/* 248 */       str = a(httpUriRequest, x.a).getData();
/* 249 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 252 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, NameValuePair[] paramArrayOfNameValuePair, x paramx) {
/* 257 */     String str = "";
/*     */     
/* 259 */     ArrayList arrayList = new ArrayList();
/* 260 */     arrayList.addAll(Arrays.asList(paramArrayOfNameValuePair));
/*     */     
/*     */     try {
/* 263 */       HttpUriRequest httpUriRequest = RequestBuilder.post().setUri(new URI(paramString)).setEntity((HttpEntity)new UrlEncodedFormEntity(arrayList, "ISO-8859-1")).build();
/*     */       
/* 265 */       str = a(httpUriRequest, paramx).getData();
/* 266 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 269 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private e a(HttpUriRequest paramHttpUriRequest, x paramx) {
/* 279 */     CloseableHttpResponse closeableHttpResponse = null;
/* 280 */     e e = null;
/*     */     
/* 282 */     long l = System.currentTimeMillis();
/*     */     
/*     */     try {
/* 285 */       closeableHttpResponse = this.a.execute(paramHttpUriRequest);
/* 286 */       HttpEntity httpEntity = closeableHttpResponse.getEntity();
/*     */       
/* 288 */       l = System.currentTimeMillis() - l;
/* 289 */       e = new e(l, closeableHttpResponse.getStatusLine().getStatusCode());
/*     */       
/* 291 */       if (closeableHttpResponse.getStatusLine().getStatusCode() == 200) {
/* 292 */         if (paramx == x.a) {
/* 293 */           String str = EntityUtils.toString(httpEntity);
/* 294 */           e.setData(str);
/* 295 */         } else if (paramx == x.c) {
/* 296 */           byte[] arrayOfByte = Base64.encodeBase64(IOUtils.toByteArray(httpEntity.getContent()));
/* 297 */           String str = new String(arrayOfByte);
/* 298 */           e.setData(str);
/*     */         } 
/*     */         
/* 301 */         this.at = 0;
/*     */       } else {
/* 303 */         this.at++;
/*     */         
/* 305 */         if (this.at >= 3) {
/* 306 */           b();
/*     */         }
/*     */       } 
/*     */       
/* 310 */       closeableHttpResponse.close();
/* 311 */     } catch (Exception exception) {
/* 312 */       a.error("Failed to process request", exception);
/* 313 */       if (e == null) {
/* 314 */         l = System.currentTimeMillis() - l;
/*     */         
/* 316 */         e = new e();
/* 317 */         e.q(l);
/*     */       } 
/*     */     } finally {
/*     */       try {
/* 321 */         if (closeableHttpResponse != null) {
/* 322 */           closeableHttpResponse.close();
/*     */         }
/* 324 */       } catch (Exception exception) {
/* 325 */         a.info("Failed to close response", exception);
/*     */       } 
/*     */     } 
/*     */     
/* 329 */     return e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e a(Object paramObject, Set<Integer> paramSet) {
/* 338 */     if (!paramSet.isEmpty()) {
/* 339 */       StringBuilder stringBuilder = new StringBuilder("https://www1.compras.mg.gov.br/");
/* 340 */       stringBuilder.append("processocompra/pregao/eletronico/encaminhamento/lances/abaLotesPregaoEletronico.html?metodo=solicitarAtualizacaoDeCampos&reqAjax=XMLHttpRequest&idPregao=");
/* 341 */       stringBuilder.append(paramObject);
/* 342 */       paramSet.forEach(paramInteger -> {
/*     */             paramStringBuilder.append("&idLote=");
/*     */             
/*     */             paramStringBuilder.append(paramInteger);
/*     */           });
/* 347 */       return m(stringBuilder.toString());
/*     */     } 
/*     */     
/* 350 */     return new e();
/*     */   }
/*     */   
/*     */   public String a(Object paramObject) {
/* 354 */     StringBuilder stringBuilder = new StringBuilder();
/* 355 */     stringBuilder.append("https://www1.compras.mg.gov.br/");
/* 356 */     stringBuilder.append("processocompra/pregao/consulta/dados/abaDadosPregao.html?idPregao=");
/* 357 */     stringBuilder.append(paramObject);
/*     */     
/* 359 */     return K(stringBuilder.toString());
/*     */   }
/*     */   
/*     */   public String a(Object paramObject1, Object paramObject2) {
/* 363 */     StringBuilder stringBuilder = new StringBuilder();
/* 364 */     stringBuilder.append("https://www1.compras.mg.gov.br/");
/* 365 */     stringBuilder.append("processocompra/pregao/consulta/dados/lotes/lancesLote.html?idPregao=");
/* 366 */     stringBuilder.append(paramObject1);
/* 367 */     stringBuilder.append("&idLote=").append(paramObject2);
/*     */     
/* 369 */     return K(stringBuilder.toString());
/*     */   }
/*     */   
/*     */   public String b(Object paramObject) {
/* 373 */     StringBuilder stringBuilder = new StringBuilder();
/* 374 */     stringBuilder.append("https://www1.compras.mg.gov.br/");
/* 375 */     stringBuilder.append("processocompra/pregao/consulta/dados/lotes/lancesLote.html");
/* 376 */     stringBuilder.append(paramObject);
/*     */     
/* 378 */     return K(stringBuilder.toString());
/*     */   }
/*     */   
/*     */   public String c(Object paramObject) {
/* 382 */     StringBuilder stringBuilder = new StringBuilder();
/* 383 */     stringBuilder.append("https://www1.compras.mg.gov.br/");
/* 384 */     stringBuilder.append("processocompra/pregao/eletronico/gestaopropostaslotes/abaLotesPregao.html?aba=abaLotesPregao&idPregao=");
/* 385 */     stringBuilder.append(paramObject);
/*     */     
/* 387 */     return K(stringBuilder.toString());
/*     */   }
/*     */   
/*     */   public String d(Object paramObject) {
/* 391 */     StringBuilder stringBuilder = new StringBuilder();
/* 392 */     stringBuilder.append("https://www1.compras.mg.gov.br/");
/* 393 */     stringBuilder.append("processocompra/pregao/eletronico/gestaopropostaslotes/abaLotesPregao.html");
/* 394 */     stringBuilder.append(paramObject);
/*     */     
/* 396 */     return K(stringBuilder.toString());
/*     */   }
/*     */   
/*     */   public String e(Object paramObject) {
/* 400 */     StringBuilder stringBuilder = new StringBuilder();
/* 401 */     stringBuilder.append("https://www1.compras.mg.gov.br/");
/* 402 */     stringBuilder.append("processocompra/pregao/eletronico/gestaopropostaslotes/edicaoProposta.html?metodo=visualizar&idLote=");
/* 403 */     stringBuilder.append(paramObject);
/*     */     
/* 405 */     return K(stringBuilder.toString());
/*     */   }
/*     */   
/*     */   public String f(Object paramObject) {
/* 409 */     StringBuilder stringBuilder = new StringBuilder();
/* 410 */     stringBuilder.append("https://www1.compras.mg.gov.br/");
/* 411 */     stringBuilder.append("processocompra/pregao/eletronico/encaminhamento/lances/abaLotesPregaoEletronico.html?aba=abaLotesPregao&aba=abaLotesPregao&metodo=pesquisar&idPregao=");
/* 412 */     stringBuilder.append(paramObject);
/*     */     
/* 414 */     return K(stringBuilder.toString());
/*     */   }
/*     */   
/*     */   public String g(Object paramObject) {
/* 418 */     StringBuilder stringBuilder = new StringBuilder();
/* 419 */     stringBuilder.append("https://www1.compras.mg.gov.br/");
/* 420 */     stringBuilder.append("processocompra/pregao/consulta/dados/abaLotesPregao.html?aba=abaLotesCadastrados&idPregao=");
/* 421 */     stringBuilder.append(paramObject);
/*     */     
/* 423 */     return K(stringBuilder.toString());
/*     */   }
/*     */   
/*     */   public String b(Object paramObject1, Object paramObject2) {
/* 427 */     StringBuilder stringBuilder = new StringBuilder();
/* 428 */     stringBuilder.append("https://www1.compras.mg.gov.br/");
/* 429 */     stringBuilder.append("processocompra/pregao/consulta/dados/itens/itensLote.html?idLote=");
/* 430 */     stringBuilder.append(paramObject1);
/* 431 */     stringBuilder.append("&idPregao=").append(paramObject2);
/*     */     
/* 433 */     return K(stringBuilder.toString());
/*     */   }
/*     */ 
/*     */   
/*     */   public String a(int paramInt1, int paramInt2, int paramInt3) {
/* 438 */     i i1 = new i();
/* 439 */     i1.c("lote", "Todos os lotes");
/*     */     
/* 441 */     i i2 = new i();
/* 442 */     i2.c("sortName", "dataHoraEnvio");
/* 443 */     i2.c("sortOrder", "desc");
/* 444 */     f f = new f();
/* 445 */     f.a(i2);
/*     */     
/* 447 */     i i3 = new i();
/* 448 */     i3.c("filtros", i1);
/* 449 */     i3.c("ordenacoes", f);
/* 450 */     i3.a("sizePerPage", paramInt3);
/* 451 */     i3.a("page", paramInt2);
/*     */     
/* 453 */     StringBuilder stringBuilder = new StringBuilder();
/* 454 */     stringBuilder.append("https://www1.compras.mg.gov.br/");
/* 455 */     stringBuilder.append("servico/pregao/chat/recuperarHistoricoChat?idPregao=");
/* 456 */     stringBuilder.append(paramInt1);
/*     */     
/* 458 */     return g(stringBuilder.toString(), i3.toString());
/*     */   }
/*     */   
/*     */   public String g(int paramInt) {
/* 462 */     StringBuilder stringBuilder = new StringBuilder();
/* 463 */     stringBuilder.append("https://www1.compras.mg.gov.br/");
/* 464 */     stringBuilder.append("servico/pregao/chat/recuperarDetalhesMeuChat?idProcedimento=");
/* 465 */     stringBuilder.append(paramInt);
/*     */     
/* 467 */     return K(stringBuilder.toString());
/*     */   }
/*     */   
/*     */   public String D(String paramString) {
/* 471 */     StringBuilder stringBuilder = new StringBuilder();
/* 472 */     stringBuilder.append("https://www1.compras.mg.gov.br/");
/* 473 */     stringBuilder.append("processocompra/pregao/eletronico/gestaopropostaslotes/abaDadosPregao.html?idPregao=");
/* 474 */     stringBuilder.append(paramString);
/*     */     
/* 476 */     return K(stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean T() {
/* 486 */     return A.a().p("https://www1.compras.mg.gov.br/");
/*     */   }
/*     */   
/*     */   public String P() {
/* 490 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 492 */     for (Cookie cookie : this.a.getCookies()) {
/* 493 */       stringBuilder.append(cookie.getName()).append("=").append(cookie.getValue()).append(";");
/*     */     }
/*     */     
/* 496 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private void bV() {
/* 501 */     if (isRunning()) {
/* 502 */       K(bI);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String as() {
/*     */     String str;
/* 515 */     if (av().length() > 14) {
/* 516 */       return av();
/*     */     }
/*     */     
/*     */     try {
/* 520 */       str = StringUtils.leftPad(getUser(), 11, "0");
/*     */       
/* 522 */       MaskFormatter maskFormatter = new MaskFormatter("###.###.###-##");
/* 523 */       maskFormatter.setValueContainsLiteralCharacters(false);
/* 524 */       str = maskFormatter.valueToString(str);
/* 525 */     } catch (Exception exception) {
/* 526 */       str = "000.000.000-00";
/*     */     } 
/*     */     
/* 529 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   class a
/*     */     extends Thread
/*     */   {
/*     */     private final d a;
/*     */ 
/*     */     
/*     */     a(d this$0, d param1d1) {
/* 540 */       this.a = param1d1;
/*     */     }
/*     */ 
/*     */     
/*     */     public void run() {
/* 545 */       while (this.a.isRunning()) {
/*     */         try {
/* 547 */           sleep(50000L);
/* 548 */           d.a(this.a);
/* 549 */         } catch (InterruptedException interruptedException) {}
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */