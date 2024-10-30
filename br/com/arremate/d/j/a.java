/*     */ package br.com.arremate.d.j;
/*     */ 
/*     */ import br.com.arremate.d.e;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.j.b;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.m;
/*     */ import br.com.arremate.m.y;
/*     */ import java.text.DateFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.stream.Collectors;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends e
/*     */ {
/*  30 */   private final Map<String, Map<String, h>> r = Collections.synchronizedMap(new HashMap<>());
/*  31 */   private final DateFormat a = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
/*     */   private final Map<String, m> f;
/*     */   
/*     */   public a(c paramc, b paramb) {
/*  35 */     super(paramc, (i)paramb);
/*  36 */     this.f = new HashMap<>();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<m> d() {
/*  41 */     ArrayList<m> arrayList = new ArrayList();
/*     */     
/*  43 */     a().B().forEach(paramg -> {
/*     */           List<m> list = a(paramg);
/*     */           
/*     */           int i = list.size();
/*     */           
/*     */           if (i > 0) {
/*     */             this.f.put(paramg.bo(), list.get(i - 1));
/*     */             paramList.addAll(list);
/*     */           } 
/*     */         });
/*  53 */     return arrayList;
/*     */   }
/*     */   
/*     */   public List<m> a(g paramg) {
/*  57 */     ArrayList<m> arrayList = new ArrayList();
/*  58 */     br.com.arremate.l.h.a a1 = (br.com.arremate.l.h.a)paramg;
/*     */     
/*     */     try {
/*  61 */       String str = a().a(a1);
/*  62 */       Document document = Jsoup.parse(str);
/*  63 */       Elements elements = document.select("#mensagensDataTable > tbody > tr");
/*     */       
/*  65 */       for (Element element : elements) {
/*  66 */         Elements elements1 = element.select("td");
/*  67 */         String str1 = elements1.get(0).text();
/*  68 */         Date date = this.a.parse(str1);
/*     */         
/*  70 */         String str2 = elements1.get(1).text();
/*  71 */         String str3 = elements1.get(2).text();
/*     */         
/*  73 */         m m = new m(paramg.bo(), str3, date, str2);
/*  74 */         if (b(m)) {
/*     */           break;
/*     */         }
/*     */         
/*  78 */         arrayList.add(m);
/*     */       } 
/*     */       
/*  81 */       Collections.reverse(arrayList);
/*  82 */       for (m m : arrayList) {
/*  83 */         d(m);
/*     */       }
/*  85 */     } catch (Exception exception) {
/*  86 */       a.warn("Erro ao capturar mensagem", exception);
/*     */     } 
/*     */     
/*  89 */     return arrayList;
/*     */   }
/*     */   
/*     */   private boolean b(m paramm) {
/*  93 */     String str = paramm.bo();
/*     */     
/*  95 */     if (!this.f.containsKey(str)) {
/*  96 */       return false;
/*     */     }
/*     */     
/*  99 */     return (((m)this.f.get(str)).a(paramm) >= 0);
/*     */   }
/*     */   
/*     */   private void d(m paramm) {
/* 103 */     String str = paramm.j();
/* 104 */     if (str.contains("O lance do licitante Licitante") || str.contains("O valor negociado do licitante Licitante")) {
/*     */       
/* 106 */       int i = str.indexOf("Licitante");
/* 107 */       int j = i + 12;
/* 108 */       String str1 = str.substring(i, j);
/*     */ 
/*     */       
/* 111 */       i = str.indexOf("R$") + 3;
/* 112 */       String str2 = str.substring(i);
/* 113 */       Double double_ = y.a(str2);
/*     */       
/* 115 */       Map<Object, Object> map = (Map)this.r.get(paramm.bo());
/* 116 */       if (map == null) {
/* 117 */         map = new HashMap<>();
/* 118 */         this.r.put(paramm.bo(), map);
/*     */       } 
/*     */       
/* 121 */       h h = (h)map.get(str1);
/* 122 */       if (h == null) {
/* 123 */         h = new h();
/* 124 */         h.E(str1);
/* 125 */         map.put(str1, h);
/*     */       } 
/*     */       
/* 128 */       h.q(double_.doubleValue());
/* 129 */       h.c(paramm.b());
/*     */     } 
/*     */   }
/*     */   
/*     */   List<h> c(String paramString) {
/* 134 */     if (this.r.containsKey(paramString)) {
/* 135 */       synchronized (this.r) {
/* 136 */         return (List<h>)((Map)this.r.get(paramString)).values().stream().collect(Collectors.toList());
/*     */       } 
/*     */     }
/*     */     
/* 140 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public b a() {
/* 145 */     return (b)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public c a() {
/* 150 */     return (c)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\j\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */