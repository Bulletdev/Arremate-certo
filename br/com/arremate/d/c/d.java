/*     */ package br.com.arremate.d.c;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.e.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.c.f;
/*     */ import java.net.URLDecoder;
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
/*     */ 
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
/*  53 */     super(paramb, (i)parama);
/*  54 */     j(TimeUnit.SECONDS.toMillis(5L));
/*     */     
/*  56 */     this.a = Executors.newCachedThreadPool();
/*  57 */     this.g = new HashMap<>();
/*  58 */     this.h = new HashMap<>();
/*     */     
/*  60 */     this.b = Executors.newScheduledThreadPool(5);
/*  61 */     this.k = new ArrayList();
/*     */     
/*  63 */     this.b = Executors.newScheduledThreadPool(1);
/*     */     
/*  65 */     this.W = "";
/*  66 */     this.T = a().B();
/*     */     
/*  68 */     if (paramBoolean) {
/*  69 */       if (a().a().equals(m.c)) {
/*  70 */         a(new b(this, (i)parama));
/*     */       }
/*     */       
/*  73 */       a().a(this);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected t b() {
/*  79 */     K();
/*  80 */     t t = super.b();
/*     */     
/*  82 */     if (t == t.c && a().a() != m.a) {
/*  83 */       aA();
/*     */     }
/*     */     
/*  86 */     return t;
/*     */   }
/*     */   
/*     */   private void aA() {
/*  90 */     this.b.scheduleAtFixedRate(() -> a().B().parallelStream().forEach(()), 1L, 1L, TimeUnit.SECONDS);
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
/*     */   private e a(j paramj) {
/* 107 */     String str = (paramj.a() == l.f) ? "10" : "1";
/* 108 */     return a().a(paramj.bT(), paramj.bo(), paramj.bW(), str);
/*     */   }
/*     */ 
/*     */   
/*     */   public t a() {
/*     */     try {
/* 114 */       e e = a(a());
/* 115 */       e(e.k());
/* 116 */       i i = a.g(e.getData());
/*     */       
/* 118 */       if (i != null) {
/* 119 */         Document document = Jsoup.parse(String.join("", new CharSequence[] { "<table>", i.getString("html"), "</table>" }));
/* 120 */         if (this.W.isEmpty()) {
/* 121 */           c(document);
/*     */         }
/*     */         
/* 124 */         Elements elements = document.select("td");
/* 125 */         String str = elements.get(5).text().trim();
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
/* 151 */         e e = a(paramj);
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
/* 179 */     if (this.T < i) {
/* 180 */       this.T = i;
/* 181 */       a(a());
/* 182 */       return true;
/*     */     } 
/*     */     
/* 185 */     return false;
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
/*     */     //   127: <illegal opcode> call : (Lbr/com/arremate/d/c/d;Ljava/lang/String;)Ljava/util/concurrent/Callable;
/*     */     //   132: invokeinterface submit : (Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;
/*     */     //   137: invokeinterface add : (Ljava/lang/Object;)Z
/*     */     //   142: pop
/*     */     //   143: goto -> 98
/*     */     //   146: lconst_0
/*     */     //   147: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   150: astore_1
/*     */     //   151: aload_0
/*     */     //   152: invokevirtual a : ()Lbr/com/arremate/l/q/b/i;
/*     */     //   155: invokevirtual H : ()Ljava/util/List;
/*     */     //   158: astore_2
/*     */     //   159: aload_0
/*     */     //   160: getfield k : Ljava/util/List;
/*     */     //   163: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   168: astore_3
/*     */     //   169: aload_3
/*     */     //   170: invokeinterface hasNext : ()Z
/*     */     //   175: ifeq -> 274
/*     */     //   178: aload_3
/*     */     //   179: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   184: checkcast java/util/concurrent/Future
/*     */     //   187: astore #4
/*     */     //   189: aload #4
/*     */     //   191: invokeinterface get : ()Ljava/lang/Object;
/*     */     //   196: checkcast br/com/arremate/h/e
/*     */     //   199: astore #5
/*     */     //   201: aload #5
/*     */     //   203: invokevirtual k : ()J
/*     */     //   206: aload_1
/*     */     //   207: invokevirtual longValue : ()J
/*     */     //   210: lcmp
/*     */     //   211: ifle -> 223
/*     */     //   214: aload #5
/*     */     //   216: invokevirtual k : ()J
/*     */     //   219: invokestatic valueOf : (J)Ljava/lang/Long;
/*     */     //   222: astore_1
/*     */     //   223: aload #5
/*     */     //   225: invokevirtual getData : ()Ljava/lang/String;
/*     */     //   228: invokevirtual trim : ()Ljava/lang/String;
/*     */     //   231: invokevirtual isEmpty : ()Z
/*     */     //   234: ifeq -> 240
/*     */     //   237: goto -> 169
/*     */     //   240: aload #5
/*     */     //   242: invokevirtual getData : ()Ljava/lang/String;
/*     */     //   245: invokestatic parse : (Ljava/lang/String;)Lorg/jsoup/nodes/Document;
/*     */     //   248: astore #6
/*     */     //   250: aload #6
/*     */     //   252: ldc 'table > tbody > tr'
/*     */     //   254: invokevirtual select : (Ljava/lang/String;)Lorg/jsoup/select/Elements;
/*     */     //   257: astore #7
/*     */     //   259: aload #7
/*     */     //   261: aload_0
/*     */     //   262: aload_2
/*     */     //   263: <illegal opcode> accept : (Lbr/com/arremate/d/c/d;Ljava/util/List;)Ljava/util/function/Consumer;
/*     */     //   268: invokevirtual forEach : (Ljava/util/function/Consumer;)V
/*     */     //   271: goto -> 169
/*     */     //   274: aload_0
/*     */     //   275: aload_2
/*     */     //   276: invokespecial f : (Ljava/util/List;)V
/*     */     //   279: aload_0
/*     */     //   280: aload_1
/*     */     //   281: invokevirtual longValue : ()J
/*     */     //   284: invokespecial e : (J)V
/*     */     //   287: goto -> 302
/*     */     //   290: astore_1
/*     */     //   291: getstatic br/com/arremate/d/c/d.a : Lorg/slf4j/Logger;
/*     */     //   294: ldc 'Failed to load bidding batches data'
/*     */     //   296: aload_1
/*     */     //   297: invokeinterface error : (Ljava/lang/String;Ljava/lang/Throwable;)V
/*     */     //   302: aload_0
/*     */     //   303: getfield k : Ljava/util/List;
/*     */     //   306: invokeinterface clear : ()V
/*     */     //   311: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #190	-> 0
/*     */     //   #191	-> 7
/*     */     //   #194	-> 8
/*     */     //   #195	-> 15
/*     */     //   #196	-> 26
/*     */     //   #198	-> 38
/*     */     //   #199	-> 46
/*     */     //   #200	-> 59
/*     */     //   #199	-> 82
/*     */     //   #205	-> 88
/*     */     //   #206	-> 117
/*     */     //   #207	-> 143
/*     */     //   #209	-> 146
/*     */     //   #210	-> 151
/*     */     //   #212	-> 159
/*     */     //   #213	-> 189
/*     */     //   #214	-> 201
/*     */     //   #215	-> 214
/*     */     //   #218	-> 223
/*     */     //   #219	-> 237
/*     */     //   #222	-> 240
/*     */     //   #223	-> 250
/*     */     //   #224	-> 259
/*     */     //   #239	-> 271
/*     */     //   #241	-> 274
/*     */     //   #242	-> 279
/*     */     //   #245	-> 287
/*     */     //   #243	-> 290
/*     */     //   #244	-> 291
/*     */     //   #247	-> 302
/*     */     //   #248	-> 311
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   88	287	290	java/lang/Exception
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
/*     */ 
/*     */   
/*     */   private void a(e parame, Element paramElement) {
/* 251 */     int i = parame.v();
/* 252 */     Future future = this.g.get(Integer.valueOf(i));
/*     */     
/*     */     try {
/* 255 */       if (future == null || future.isDone()) {
/* 256 */         c c = this.h.get(Integer.valueOf(i));
/*     */         
/* 258 */         if (c == null) {
/* 259 */           c = new c(parame, (i)a(), this);
/*     */           
/* 261 */           if (t.c.equals(c()) && !this.k) {
/* 262 */             this.h.put(Integer.valueOf(i), c);
/*     */           }
/*     */         } 
/*     */         
/* 266 */         c.e(paramElement);
/* 267 */         Future<?> future1 = this.a.submit((Runnable)c);
/* 268 */         this.g.put(Integer.valueOf(i), future1);
/*     */       } 
/* 270 */     } catch (Exception exception) {
/* 271 */       a.warn("[Item {}] Failed to start thread from item", parame.bo(), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void f(List<e> paramList) {
/* 276 */     if (a().isRunning()) {
/* 277 */       paramList.forEach(parame -> a("Item está em disputa e não recebeu dados atualizados do portal", parame.bo()));
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean b(e parame, double paramDouble) {
/* 282 */     c c = this.h.get(Integer.valueOf(parame.v()));
/* 283 */     if (c == null) {
/* 284 */       return false;
/*     */     }
/*     */     
/* 287 */     return c.a(new h(paramDouble), true);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> b(e parame) throws br.com.arremate.g.d {
/* 292 */     List<h> list = new ArrayList();
/*     */     
/* 294 */     c c = this.h.get(Integer.valueOf(parame.v()));
/* 295 */     if (c == null) {
/* 296 */       if (this.W.isEmpty()) {
/* 297 */         a(parame.a());
/*     */       }
/*     */       
/* 300 */       String str = Integer.toString(Integer.parseInt(parame.bo()) - 1);
/* 301 */       e e1 = a().g(this.W, str);
/* 302 */       if (e1.getData().trim().isEmpty()) {
/* 303 */         return list;
/*     */       }
/*     */       
/*     */       try {
/* 307 */         Document document = Jsoup.parse(e1.getData());
/* 308 */         Elements elements = document.select("table > tbody > tr");
/* 309 */         if (elements.isEmpty()) {
/* 310 */           return list;
/*     */         }
/*     */         
/* 313 */         c = new c(parame, (i)a(), this);
/* 314 */         c.e(elements.get(0));
/* 315 */       } catch (Exception exception) {
/* 316 */         a.error("Failed to load bidding batches data situation", exception);
/*     */       } 
/*     */     } 
/*     */     
/* 320 */     if (c != null) {
/* 321 */       list = c.e();
/*     */     }
/*     */     
/* 324 */     return list;
/*     */   }
/*     */ 
/*     */   
/*     */   public void S() {
/* 329 */     this.k = true;
/* 330 */     R();
/*     */     
/* 332 */     this.g.entrySet().stream().map(paramEntry -> (Future)paramEntry.getValue())
/* 333 */       .forEachOrdered(paramFuture -> {
/*     */           try {
/*     */             paramFuture.get();
/* 336 */           } catch (Exception exception) {}
/*     */         });
/*     */ 
/*     */     
/* 340 */     this.b.shutdown();
/* 341 */     this.a.shutdown();
/* 342 */     this.b.shutdown();
/*     */   }
/*     */   
/*     */   void p(e parame) {
/* 346 */     this.h.remove(Integer.valueOf(parame.v()));
/*     */   }
/*     */ 
/*     */   
/*     */   public final a a() {
/* 351 */     return (a)super.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String t() {
/* 358 */     return this.W;
/*     */   }
/*     */   
/*     */   protected void T() {}
/*     */   
/*     */   protected void a(f paramf, List<h> paramList) {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\c\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */