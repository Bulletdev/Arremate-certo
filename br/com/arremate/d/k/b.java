/*     */ package br.com.arremate.d.k;
/*     */ 
/*     */ import br.com.arremate.d.e;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.m;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import java.math.BigDecimal;
/*     */ import java.time.LocalDateTime;
/*     */ import java.time.format.DateTimeFormatter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends e
/*     */ {
/*     */   private final Map<Integer, m> s;
/*     */   
/*     */   public b(g paramg, i parami) {
/*  35 */     super(paramg, parami);
/*     */     
/*  37 */     this.s = new HashMap<>();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<m> d() {
/*  42 */     t t = a().c();
/*  43 */     if (t == null) {
/*  44 */       t = a().a();
/*     */     }
/*     */     
/*  47 */     if (t == t.d) {
/*  48 */       return n();
/*     */     }
/*  50 */     return m();
/*     */   }
/*     */ 
/*     */   
/*     */   private List<m> m() {
/*  55 */     ArrayList<m> arrayList = new ArrayList();
/*     */     
/*  57 */     Map<Integer, f> map = a().i();
/*  58 */     for (Integer integer : map.keySet()) {
/*  59 */       ArrayList<m> arrayList1 = new ArrayList();
/*  60 */       f f = map.get(integer);
/*     */       
/*  62 */       for (byte b1 = 0; b1 < f.length(); b1++) {
/*  63 */         i i = f.b(b1);
/*     */         
/*  65 */         m m = new m();
/*  66 */         m.f(i.getString("texto"));
/*  67 */         m.c(y.a(i.getString("data"), i.getString("hora")));
/*  68 */         m.T(String.valueOf(integer));
/*  69 */         int j = i.getInt("codigoTipoEmitente");
/*  70 */         m.aE((j == 3) ? "Sistema" : ((j == 1) ? "Pregoeiro" : "Fornecedor"));
/*     */         
/*  72 */         if (c(m)) {
/*     */           break;
/*     */         }
/*     */         
/*  76 */         e(m);
/*  77 */         f(m);
/*  78 */         g(m);
/*  79 */         h(m);
/*     */         
/*  81 */         arrayList1.add(m);
/*     */       } 
/*     */       
/*  84 */       if (!arrayList1.isEmpty()) {
/*  85 */         this.s.put(integer, arrayList1.get(0));
/*     */       }
/*     */       
/*  88 */       Collections.reverse(arrayList1);
/*  89 */       arrayList.addAll(arrayList1);
/*     */     } 
/*     */     
/*  92 */     return arrayList;
/*     */   }
/*     */   
/*     */   private List<m> n() {
/*  96 */     ArrayList<m> arrayList = new ArrayList();
/*     */     
/*  98 */     List list = a().a().B();
/*     */     
/* 100 */     for (g g : list) {
/* 101 */       ArrayList<m> arrayList1 = new ArrayList();
/* 102 */       e e1 = a().k(g.a().v(), g.v());
/*     */       
/* 104 */       if (e1.getData().isEmpty()) {
/* 105 */         return arrayList;
/*     */       }
/* 107 */       f f = (new i(e1.getData())).c("data");
/*     */       
/* 109 */       for (int i = f.length() - 1; i >= 0; i--) {
/* 110 */         i i1 = f.b(i);
/*     */         
/* 112 */         m m = new m();
/* 113 */         m.f(i1.getString("texto"));
/* 114 */         m.c(y.a(i1.getString("data"), i1.getString("hora")));
/* 115 */         m.T(String.valueOf(g.v()));
/* 116 */         m.aE(i1.getString("emitente"));
/*     */         
/* 118 */         arrayList1.add(m);
/*     */       } 
/* 120 */       arrayList.addAll(arrayList1);
/*     */     } 
/*     */     
/* 123 */     return arrayList;
/*     */   }
/*     */   
/*     */   private boolean c(m paramm) {
/* 127 */     int i = Integer.parseInt(paramm.bo());
/* 128 */     if (!this.s.containsKey(Integer.valueOf(i))) {
/* 129 */       return false;
/*     */     }
/*     */     
/* 132 */     return (((m)this.s.get(Integer.valueOf(i))).a(paramm) >= 0);
/*     */   }
/*     */   
/*     */   private void e(m paramm) {
/* 136 */     String str1 = paramm.j();
/* 137 */     String str2 = "O valor mínimo entre lances do próprio fornecedor em relação ao seu último lance deverá ser de";
/* 138 */     if (str1.contains(str2) && !str1.contains("%")) {
/* 139 */       String str = str1.substring(str1.lastIndexOf(" ser de ") + 11, str1.length() - 1);
/*     */       
/* 141 */       e e1 = a().a(paramm.bo());
/* 142 */       if (e1 != null) {
/* 143 */         e1.e(new BigDecimal(y.a(str).doubleValue()));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void f(m paramm) {
/* 150 */     String str1 = paramm.j();
/* 151 */     d d = a().a().a();
/* 152 */     String str2 = d.bv().toUpperCase() + ", está convocado para ofertar um lance final e fechado em até cinco minutos,";
/* 153 */     if (str1.contains(str2)) {
/* 154 */       long l = TimeUnit.MINUTES.toMillis(5L) - n.a().longValue() - paramm.b().getTime();
/* 155 */       e e1 = a().a(paramm.bo());
/* 156 */       if (e1 != null) {
/* 157 */         e1.v(true);
/* 158 */         e1.x(l);
/*     */       } 
/* 160 */       a.info("Convocado para lance fechado");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void g(m paramm) {
/* 165 */     String str1 = paramm.j();
/* 166 */     String str2 = "encerrada automaticamente pelo sistema às";
/*     */     
/* 168 */     if (str1.contains(str2)) {
/* 169 */       String str = str1.substring(str1.lastIndexOf(" sistema às ") + 12, str1.length() - 1);
/* 170 */       Date date = y.a(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), str);
/*     */       
/* 172 */       e e1 = a().a(paramm.bo());
/* 173 */       if (e1 != null) {
/* 174 */         ((br.com.arremate.l.i.b)e1.a()).d(date);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void h(m paramm) {
/* 180 */     String str1 = paramm.j();
/* 181 */     String str2 = "a disputa foi prorrogada por mais 2 minutos, visto que,";
/*     */     
/* 183 */     if (str1.contains(str2)) {
/* 184 */       long l = TimeUnit.MINUTES.toMillis(2L) - n.a().longValue() - paramm.b().getTime();
/* 185 */       e e1 = a().a(paramm.bo());
/* 186 */       if (e1 != null && l > 0L) {
/* 187 */         e1.x(l);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public e a() {
/* 194 */     return (e)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public br.com.arremate.j.i.b a() {
/* 199 */     return (br.com.arremate.j.i.b)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\k\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */