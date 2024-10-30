/*     */ package br.com.arremate.d.d;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.f.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.c.f;
/*     */ import br.com.arremate.m.y;
/*     */ import java.net.URLDecoder;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.ScheduledExecutorService;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.e.i;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class d
/*     */   extends g
/*     */ {
/*     */   private final ExecutorService a;
/*     */   private final Map<Integer, Future> g;
/*     */   private final Map<Integer, c> h;
/*     */   private final ExecutorService b;
/*     */   private final List<Future<e>> k;
/*     */   private final ScheduledExecutorService b;
/*     */   private List<String> l;
/*     */   private String W;
/*     */   private int T;
/*     */   private boolean k;
/*     */   
/*     */   public d(b paramb, a parama, boolean paramBoolean) {
/*  51 */     super(paramb, (i)parama);
/*  52 */     j(5000L);
/*     */     
/*  54 */     this.a = Executors.newCachedThreadPool();
/*  55 */     this.g = new HashMap<>();
/*  56 */     this.h = new HashMap<>();
/*     */     
/*  58 */     this.b = Executors.newScheduledThreadPool(5);
/*  59 */     this.k = new ArrayList();
/*     */     
/*  61 */     this.b = Executors.newScheduledThreadPool(1);
/*     */     
/*  63 */     this.W = "";
/*  64 */     this.T = a().B();
/*     */     
/*  66 */     if (paramBoolean) {
/*  67 */       if (a().a().equals(m.c)) {
/*  68 */         a(new b(this, (i)parama));
/*     */       }
/*     */       
/*  71 */       a().a(this);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected t b() {
/*  77 */     K();
/*  78 */     t t = super.b();
/*     */     
/*  80 */     if (t == t.c && a().a() != m.a) {
/*  81 */       aA();
/*     */     }
/*     */     
/*  84 */     return t;
/*     */   }
/*     */   
/*     */   private void aA() {
/*  88 */     this.b.scheduleAtFixedRate(() -> a().B().parallelStream().forEach(()), 1L, 1L, TimeUnit.SECONDS);
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
/*     */   private e b(j paramj) {
/* 105 */     String str = (paramj.a() == l.f) ? "10" : "1";
/* 106 */     return a().a(paramj.bT(), paramj.bo(), paramj.bW(), str);
/*     */   }
/*     */ 
/*     */   
/*     */   public t a() {
/*     */     try {
/* 112 */       e e = b(a());
/* 113 */       e(e.k());
/* 114 */       i i = a.g(e.getData());
/*     */       
/* 116 */       if (i != null) {
/* 117 */         Document document = Jsoup.parse(String.join("", new CharSequence[] { "<table>", i.getString("html"), "</table>" }));
/*     */         
/* 119 */         if (this.W.isEmpty()) {
/* 120 */           c(document);
/*     */         }
/*     */         
/* 123 */         Elements elements = document.select("td");
/* 124 */         String str = elements.get(5).text().trim();
/*     */         
/* 126 */         switch (str) {
/*     */           case "DISPUTA":
/* 128 */             return t.c;
/*     */           case "SUSPENSO":
/* 130 */             return t.e;
/*     */           case "HABILITAÇÃO":
/*     */           case "ADJUDICADO":
/*     */           case "HOMOLOGADO":
/* 134 */             return t.d;
/*     */           case "ANULADO":
/* 136 */             return t.f;
/*     */         } 
/*     */       } 
/* 139 */     } catch (Exception exception) {
/* 140 */       a.error("Failed to get bidding status", exception);
/*     */     } 
/*     */     
/* 143 */     return t.b;
/*     */   }
/*     */   
/*     */   private void a(j paramj) {
/*     */     try {
/*     */       i i;
/* 149 */       byte b = 0;
/*     */       do {
/* 151 */         e e = b(paramj);
/* 152 */         i = a.g(e.getData());
/* 153 */         b++;
/* 154 */       } while (i == null && b < 3);
/*     */       
/* 156 */       if (i != null) {
/* 157 */         Document document = Jsoup.parse(String.join("", new CharSequence[] { "<table>", i.getString("html"), "</table>" }));
/* 158 */         c(document);
/*     */       } 
/* 160 */     } catch (Exception exception) {
/* 161 */       a.error("Failed to get bidding dispute page token", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void c(Document paramDocument) {
/*     */     try {
/* 167 */       Element element = paramDocument.select("td > a[href^=/BatchList?]").first();
/* 168 */       String str = URLDecoder.decode(element.attr("href"), "UTF-8");
/* 169 */       str = str.replace("/BatchList?param1=", "");
/* 170 */       str = str.substring(0, str.indexOf("&param2"));
/* 171 */       this.W = str;
/* 172 */     } catch (Exception exception) {
/* 173 */       a.error("Failed to get bidding dispute page token", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean K() {
/* 178 */     int i = a().B();
/*     */     
/* 180 */     if (this.T < i) {
/* 181 */       this.T = i;
/* 182 */       a(a());
/* 183 */       return true;
/*     */     } 
/*     */     
/* 186 */     return false;
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
/*     */   public void R() {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: invokespecial K : ()Z
/*     */     //   4: ifeq -> 8
/*     */     //   7: return
/*     */     //   8: aload_0
/*     */     //   9: getfield l : Ljava/util/List;
/*     */     //   12: ifnonnull -> 88
/*     */     //   15: aload_0
/*     */     //   16: new java/util/ArrayList
/*     */     //   19: dup
/*     */     //   20: invokespecial <init> : ()V
/*     */     //   23: putfield l : Ljava/util/List;
/*     */     //   26: aload_0
/*     */     //   27: getfield l : Ljava/util/List;
/*     */     //   30: ldc '0'
/*     */     //   32: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   37: pop
/*     */     //   38: aload_0
/*     */     //   39: invokespecial a : ()Lbr/com/arremate/l/q/b/i;
/*     */     //   42: invokevirtual L : ()Ljava/util/List;
/*     */     //   45: astore_1
/*     */     //   46: bipush #99
/*     */     //   48: istore_2
/*     */     //   49: iload_2
/*     */     //   50: aload_1
/*     */     //   51: invokeinterface size : ()I
/*     */     //   56: if_icmpge -> 88
/*     */     //   59: aload_0
/*     */     //   60: getfield l : Ljava/util/List;
/*     */     //   63: aload_1
/*     */     //   64: iload_2
/*     */     //   65: invokeinterface get : (I)Ljava/lang/Object;
/*     */     //   70: checkcast br/com/arremate/l/q/b/e
/*     */     //   73: invokevirtual bo : ()Ljava/lang/String;
/*     */     //   76: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   81: pop
/*     */     //   82: iinc #2, 100
/*     */     //   85: goto -> 49
/*     */     //   88: aload_0
/*     */     //   89: getfield l : Ljava/util/List;
/*     */     //   92: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   97: astore_1
/*     */     //   98: aload_1
/*     */     //   99: invokeinterface hasNext : ()Z
/*     */     //   104: ifeq -> 146
/*     */     //   107: aload_1
/*     */     //   108: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   113: checkcast java/lang/String
/*     */     //   116: astore_2
/*     */     //   117: aload_0
/*     */     //   118: getfield k : Ljava/util/List;
/*     */     //   121: aload_0
/*     */     //   122: getfield b : Ljava/util/concurrent/ExecutorService;
/*     */     //   125: aload_0
/*     */     //   126: aload_2
/*     */     //   127: <illegal opcode> call : (Lbr/com/arremate/d/d/d;Ljava/lang/String;)Ljava/util/concurrent/Callable;
/*     */     //   132: invokeinterface submit : (Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
/*     */     //   137: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   142: pop
/*     */     //   143: goto -> 98
/*     */     //   146: lconst_0
/*     */     //   147: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   150: astore_1
/*     */     //   151: aload_0
/*     */     //   152: getfield k : Ljava/util/List;
/*     */     //   155: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   160: astore_2
/*     */     //   161: aload_2
/*     */     //   162: invokeinterface hasNext : ()Z
/*     */     //   167: ifeq -> 263
/*     */     //   170: aload_2
/*     */     //   171: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   176: checkcast java/util/concurrent/Future
/*     */     //   179: astore_3
/*     */     //   180: aload_3
/*     */     //   181: invokeinterface get : ()Ljava/lang/Object;
/*     */     //   186: checkcast br/com/arremate/h/e
/*     */     //   189: astore #4
/*     */     //   191: aload #4
/*     */     //   193: invokevirtual k : ()J
/*     */     //   196: aload_1
/*     */     //   197: invokevirtual longValue : ()J
/*     */     //   200: lcmp
/*     */     //   201: ifle -> 213
/*     */     //   204: aload #4
/*     */     //   206: invokevirtual k : ()J
/*     */     //   209: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   212: astore_1
/*     */     //   213: aload #4
/*     */     //   215: invokevirtual getData : ()Ljava/lang/String;
/*     */     //   218: invokevirtual trim : ()Ljava/lang/String;
/*     */     //   221: invokevirtual isEmpty : ()Z
/*     */     //   224: ifeq -> 230
/*     */     //   227: goto -> 161
/*     */     //   230: aload #4
/*     */     //   232: invokevirtual getData : ()Ljava/lang/String;
/*     */     //   235: invokestatic parse : (Ljava/lang/String;)Lorg/jsoup/nodes/Document;
/*     */     //   238: astore #5
/*     */     //   240: aload #5
/*     */     //   242: ldc 'table > tbody > tr'
/*     */     //   244: invokevirtual select : (Ljava/lang/String;)Lorg/jsoup/select/Elements;
/*     */     //   247: astore #6
/*     */     //   249: aload #6
/*     */     //   251: aload_0
/*     */     //   252: <illegal opcode> accept : (Lbr/com/arremate/d/d/d;)Ljava/util/function/Consumer;
/*     */     //   257: invokevirtual forEach : (Ljava/util/function/Consumer;)V
/*     */     //   260: goto -> 161
/*     */     //   263: aload_0
/*     */     //   264: aload_1
/*     */     //   265: invokevirtual longValue : ()J
/*     */     //   268: invokespecial e : (J)V
/*     */     //   271: goto -> 286
/*     */     //   274: astore_1
/*     */     //   275: getstatic br/com/arremate/d/d/d.a : Lorg/slf4j/Logger;
/*     */     //   278: ldc 'Failed to load bidding batches data'
/*     */     //   280: aload_1
/*     */     //   281: invokeinterface error : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   286: aload_0
/*     */     //   287: getfield k : Ljava/util/List;
/*     */     //   290: invokeinterface clear : ()V
/*     */     //   295: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #191	-> 0
/*     */     //   #192	-> 7
/*     */     //   #195	-> 8
/*     */     //   #196	-> 15
/*     */     //   #197	-> 26
/*     */     //   #199	-> 38
/*     */     //   #200	-> 46
/*     */     //   #201	-> 59
/*     */     //   #200	-> 82
/*     */     //   #206	-> 88
/*     */     //   #207	-> 117
/*     */     //   #208	-> 143
/*     */     //   #210	-> 146
/*     */     //   #212	-> 151
/*     */     //   #213	-> 180
/*     */     //   #215	-> 191
/*     */     //   #216	-> 204
/*     */     //   #219	-> 213
/*     */     //   #220	-> 227
/*     */     //   #223	-> 230
/*     */     //   #224	-> 240
/*     */     //   #225	-> 249
/*     */     //   #237	-> 260
/*     */     //   #239	-> 263
/*     */     //   #242	-> 271
/*     */     //   #240	-> 274
/*     */     //   #241	-> 275
/*     */     //   #244	-> 286
/*     */     //   #245	-> 295
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   88	271	274	java/lang/Exception
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
/*     */   private void a(e parame, Element paramElement) {
/* 248 */     int i = parame.v();
/* 249 */     Future future = this.g.get(Integer.valueOf(i));
/*     */     
/*     */     try {
/* 252 */       if (future == null || future.isDone()) {
/* 253 */         c c = this.h.get(Integer.valueOf(i));
/*     */         
/* 255 */         if (c == null) {
/* 256 */           c = new c(parame, (i)a(), this);
/*     */           
/* 258 */           if (t.c.equals(c()) && !this.k) {
/* 259 */             this.h.put(Integer.valueOf(i), c);
/*     */             
/* 261 */             DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/* 262 */             String str = decimalFormat.format(parame.l());
/*     */             
/* 264 */             StringBuilder stringBuilder = new StringBuilder();
/* 265 */             stringBuilder.append("Lote ").append(parame.bo()).append(" entrou em disputa com valor mínimo de R$ ").append(str);
/* 266 */             l(stringBuilder.toString());
/*     */           } 
/*     */         } 
/*     */         
/* 270 */         c.e(paramElement);
/* 271 */         Future<?> future1 = this.a.submit((Runnable)c);
/* 272 */         this.g.put(Integer.valueOf(i), future1);
/*     */       } 
/* 274 */     } catch (Exception exception) {
/* 275 */       a.warn("[Item {}] Failed to start thread from item", parame.bo(), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean b(e parame, double paramDouble) {
/* 280 */     c c = this.h.get(Integer.valueOf(parame.v()));
/* 281 */     if (c == null) {
/* 282 */       return false;
/*     */     }
/*     */     
/* 285 */     return c.a(new h(paramDouble), true);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> b(e parame) throws br.com.arremate.g.d {
/* 290 */     List<h> list = new ArrayList();
/* 291 */     c c = this.h.get(Integer.valueOf(parame.v()));
/*     */     
/* 293 */     if (c == null) {
/* 294 */       if (this.W.isEmpty()) {
/* 295 */         a(parame.a());
/*     */       }
/*     */       
/* 298 */       String str = Integer.toString(Integer.parseInt(parame.bo()) - 1);
/* 299 */       e e1 = a().g(this.W, str);
/* 300 */       if (e1.getData().trim().isEmpty()) {
/* 301 */         return list;
/*     */       }
/*     */       
/*     */       try {
/* 305 */         Document document = Jsoup.parse(e1.getData());
/* 306 */         Elements elements = document.select("table > tbody > tr");
/* 307 */         if (elements.isEmpty()) {
/* 308 */           return list;
/*     */         }
/*     */         
/* 311 */         c = new c(parame, (i)a(), this);
/* 312 */         c.e(elements.get(0));
/* 313 */       } catch (Exception exception) {
/* 314 */         a.error("Failed to load bidding batches data situation", exception);
/*     */       } 
/*     */     } 
/*     */     
/* 318 */     if (c != null) {
/* 319 */       list = c.e();
/*     */     }
/*     */     
/* 322 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void S() {
/* 327 */     this.k = true;
/* 328 */     R();
/*     */     
/* 330 */     this.g.entrySet().stream().map(paramEntry -> (Future)paramEntry.getValue())
/* 331 */       .forEachOrdered(paramFuture -> {
/*     */           try {
/*     */             paramFuture.get();
/* 334 */           } catch (Exception exception) {}
/*     */         });
/*     */ 
/*     */     
/* 338 */     this.b.shutdown();
/* 339 */     this.a.shutdown();
/* 340 */     this.b.shutdown();
/*     */   }
/*     */   
/*     */   void p(e parame) {
/* 344 */     this.h.remove(Integer.valueOf(parame.v()));
/*     */   }
/*     */ 
/*     */   
/*     */   public final a a() {
/* 349 */     return (a)super.a();
/*     */   }
/*     */   
/*     */   public String t() {
/* 353 */     return this.W;
/*     */   }
/*     */   
/*     */   protected void T() {}
/*     */   
/*     */   protected void a(f paramf, List<h> paramList) {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\d\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */