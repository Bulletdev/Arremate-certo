/*     */ package br.com.arremate.d.l;
/*     */ 
/*     */ import br.com.arremate.a.m;
/*     */ import br.com.arremate.d.e;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.j.j.a;
/*     */ import br.com.arremate.l.m;
/*     */ import java.text.DateFormat;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.e.f;
/*     */ import org.e.g;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends e
/*     */ {
/*     */   private final m a;
/*  28 */   private final Set<Integer> b = new HashSet<>();
/*     */   private final SimpleDateFormat c;
/*     */   private final SimpleDateFormat d;
/*     */   private final int ad;
/*     */   private long A;
/*     */   private boolean n;
/*     */   
/*     */   public b(g paramg, i parami, m paramm) {
/*  36 */     super(paramg, parami);
/*  37 */     h(TimeUnit.SECONDS.toMillis(30L));
/*  38 */     this.a = paramm;
/*  39 */     this.ad = paramg.a().v();
/*     */     
/*  41 */     this.c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  42 */     this.d = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
/*  43 */     this.A = 0L;
/*  44 */     this.n = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<m> d() {
/*     */     try {
/*  50 */       return this.n ? o() : p();
/*  51 */     } catch (Exception exception) {
/*  52 */       a.info("Failed to capture message in Licitanet - Dispute ID {}", Integer.valueOf(this.ad), exception);
/*     */ 
/*     */       
/*  55 */       return new ArrayList<>();
/*     */     } 
/*     */   } private List<m> o() throws ParseException, g {
/*     */     int i;
/*  59 */     ArrayList<m> arrayList = new ArrayList();
/*  60 */     this.n = false;
/*  61 */     byte b1 = 1;
/*     */ 
/*     */     
/*     */     do {
/*  65 */       String str = a().a(this.ad, this.A, b1);
/*  66 */       if (str.isEmpty()) {
/*     */         break;
/*     */       }
/*     */       
/*  70 */       arrayList.addAll(d(str));
/*  71 */       i = (new i(str)).j("pagination").getInt("totalPages");
/*  72 */       ++b1;
/*  73 */     } while (b1 <= i);
/*     */     
/*  75 */     return arrayList;
/*     */   }
/*     */   
/*     */   private List<m> d(String paramString) throws ParseException, g {
/*  79 */     return a((new i(paramString))
/*  80 */         .c("data"), this.c, "identifier", "name", "datMessage");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private List<m> p() throws ParseException, g {
/*  89 */     e e1 = this.a.a(this.ad, Long.toString(this.A));
/*  90 */     boolean bool = (e1.getStatusCode() == 404) ? true : false;
/*     */     
/*  92 */     if (bool) {
/*  93 */       return o();
/*     */     }
/*  95 */     String str = e1.getData();
/*  96 */     return (str == null || str.isEmpty()) ? new ArrayList<>() : e(str);
/*     */   }
/*     */   
/*     */   private List<m> e(String paramString) throws ParseException, g {
/* 100 */     return a(new f(paramString), this.d, "id", "author", "data");
/*     */   }
/*     */   
/*     */   private List<m> a(f paramf, DateFormat paramDateFormat, String paramString1, String paramString2, String paramString3) throws ParseException, g {
/* 104 */     ArrayList<m> arrayList = new ArrayList();
/* 105 */     int i = 0;
/*     */     
/* 107 */     for (byte b1 = 0; b1 < paramf.length(); b1++) {
/* 108 */       i i1 = paramf.b(b1);
/* 109 */       int j = i1.getInt(paramString1);
/*     */       
/* 111 */       if (!this.b.contains(Integer.valueOf(j))) {
/* 112 */         if (!i) {
/* 113 */           i = j;
/*     */         }
/*     */         
/* 116 */         m m1 = a(i1, paramDateFormat, paramString2, paramString3);
/* 117 */         arrayList.add(m1);
/* 118 */         this.b.add(Integer.valueOf(j));
/*     */       } 
/*     */     } 
/*     */     
/* 122 */     if (i > 0 && i > this.A) {
/* 123 */       this.A = i;
/*     */     }
/* 125 */     return arrayList;
/*     */   }
/*     */   
/*     */   private m a(i parami, DateFormat paramDateFormat, String paramString1, String paramString2) throws ParseException, g {
/* 129 */     m m1 = new m();
/* 130 */     m1.f(parami.getString("message"));
/* 131 */     m1.aE(parami.getString(paramString1));
/* 132 */     m1.c(paramDateFormat.parse(parami.getString(paramString2)));
/* 133 */     m1.T(Integer.toString(parami.getInt("batch")));
/* 134 */     return m1;
/*     */   }
/*     */ 
/*     */   
/*     */   public d a() {
/* 139 */     return (d)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public a a() {
/* 144 */     return (a)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\l\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */