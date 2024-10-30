/*     */ package br.com.arremate.d.r;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.i;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.j.k.a;
/*     */ import br.com.arremate.k.b.a;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends f
/*     */ {
/*     */   private Elements d;
/*     */   private List<h> o;
/*  35 */   private final SimpleDateFormat a = new SimpleDateFormat("mm:ss");
/*     */   
/*     */   public b(e parame, i parami, g paramg) {
/*  38 */     super(parame, parami, paramg);
/*  39 */     a(new a());
/*     */     
/*  41 */     this.o = new ArrayList<>();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void P() {
/*  46 */     if (this.d != null && !this.d.isEmpty()) {
/*  47 */       bq();
/*     */     } else {
/*  49 */       bp();
/*     */     } 
/*  51 */     if (a().br()) {
/*  52 */       b().g(a());
/*  53 */       b().p(a());
/*     */     } 
/*     */   }
/*     */   
/*     */   private void bp() {
/*  58 */     this.o = e();
/*  59 */     a().N("Encerrado");
/*  60 */     for (h h : this.o) {
/*  61 */       if (h.bb()) {
/*  62 */         a().h(h.m());
/*     */         break;
/*     */       } 
/*     */     } 
/*  66 */     a().l(((h)this.o.get(0)).m());
/*  67 */     az();
/*     */   }
/*     */   
/*     */   private void bq() {
/*  71 */     bc();
/*  72 */     if (a().a().a() != m.a) {
/*  73 */       bd();
/*     */     }
/*  75 */     K(6);
/*  76 */     be();
/*  77 */     az();
/*     */   }
/*     */   
/*     */   private void bc() {
/*  81 */     a().N(this.d.get(5).select("img").attr("title"));
/*     */   }
/*     */   
/*     */   private void bd() {
/*  85 */     String str = this.d.get(5).text();
/*  86 */     if (!str.isEmpty()) {
/*     */       try {
/*  88 */         long l = this.a.parse(str).getTime();
/*  89 */         if (l > a().z()) {
/*  90 */           a().x(l);
/*     */         }
/*  92 */       } catch (ParseException parseException) {}
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void K(int paramInt) {
/*  98 */     a().l(y.a(this.d.get(paramInt).text().replace("R$", "")).doubleValue());
/*     */   }
/*     */   
/*     */   private void be() {
/* 102 */     a().h(y.a(this.d.get(7).text()).doubleValue());
/*     */   }
/*     */   
/*     */   private void az() {
/* 106 */     a().a((a().f() == a().f().m()) ? s.a : s.c);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/* 111 */     return (parami == i.a || (parami == i.b && 
/* 112 */       g.b(paramString, g.bt)) || (parami == i.b && 
/* 113 */       g.b(paramString, g.bs)) || 
/* 114 */       a().bu());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/* 119 */     if (!b(paramh.m()) && !paramBoolean) {
/* 120 */       a.warn("Tentativa de lance abaixo do mínimo");
/* 121 */       return false;
/*     */     } 
/*     */     
/* 124 */     if (!k.b()) {
/* 125 */       a().a().y(y.i().getTimeInMillis());
/* 126 */       a().w(a().aR());
/* 127 */       a("Lance de simulação", paramh, m(), paramBoolean, new String[] { "Bid: " + 
/* 128 */             String.valueOf(paramh.m()) + " Bidding: " + 
/* 129 */             a().a().v() + " Item: " + a().bo() });
/* 130 */       return true;
/*     */     } 
/*     */     
/*     */     try {
/* 134 */       e e = b().b(a(Integer.valueOf(a().a().v())), a(Integer.valueOf(a().v())), a(Double.valueOf(a().f())), a(Double.valueOf(paramh.m())));
/* 135 */       String str = b(e);
/*     */       
/* 137 */       if (e.getStatusCode() == 200 && e.getData().contains("true")) {
/* 138 */         a("Lance enviado", paramh, m(), paramBoolean, new String[] { "Tempo para envio: " + str });
/* 139 */         return true;
/*     */       } 
/* 141 */       a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { "Tempo para envio: " + str });
/* 142 */       a.error("Failed to send item bid" + e.getData());
/*     */ 
/*     */       
/* 145 */       return false;
/* 146 */     } catch (Exception exception) {
/* 147 */       a.error("Failed to send item {} bid", a().bo(), exception);
/*     */ 
/*     */       
/* 150 */       return false;
/*     */     } 
/*     */   }
/*     */   private String a(Number paramNumber) {
/* 154 */     return String.valueOf(paramNumber);
/*     */   }
/*     */   
/*     */   private String b(e parame) {
/* 158 */     double d = parame.k() / 1000.0D;
/* 159 */     DecimalFormat decimalFormat = new DecimalFormat("#.##");
/* 160 */     return decimalFormat.format(d);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> e() {
/* 165 */     if (!this.o.isEmpty()) {
/* 166 */       return Collections.unmodifiableList(this.o);
/*     */     }
/* 168 */     return j();
/*     */   }
/*     */ 
/*     */   
/*     */   private List<h> j() {
/* 173 */     ArrayList<h> arrayList = new ArrayList();
/*     */     
/* 175 */     List list = b().k().get(a().bo());
/* 176 */     arrayList.addAll(list);
/*     */     
/* 178 */     e e = b().C(String.valueOf(a().v()));
/* 179 */     Document document = Jsoup.parse(e.getData());
/* 180 */     Elements elements = document.select("tr[class^=linha_]");
/*     */     
/* 182 */     if (elements != null && !elements.isEmpty()) {
/* 183 */       for (Element element : elements) {
/* 184 */         Elements elements1 = element.select("td");
/* 185 */         h h = new h();
/* 186 */         h.c(y.a(elements1.get(0).text()));
/* 187 */         h.q(y.a(elements1.get(1).text()).doubleValue());
/* 188 */         h.A(elements1.get(2).text().trim().equals("seu lance"));
/* 189 */         arrayList.add(h);
/*     */       } 
/*     */     }
/*     */     
/* 193 */     Collections.sort(arrayList, Comparator.comparing(h::m));
/* 194 */     for (byte b1 = 0; b1 < arrayList.size(); b1++) {
/* 195 */       ((h)arrayList.get(b1)).l(b1 + 1);
/*     */     }
/*     */     
/* 198 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public a b() {
/* 203 */     return (a)super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public c b() {
/* 208 */     return (c)super.b();
/*     */   }
/*     */   
/*     */   public void c(Elements paramElements) {
/* 212 */     this.d = paramElements;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\r\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */