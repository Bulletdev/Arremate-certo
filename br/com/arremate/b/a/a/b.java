/*     */ package br.com.arremate.b.a.a;
/*     */ 
/*     */ import br.com.arremate.b.a.a;
/*     */ import br.com.arremate.f.j;
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.j.c.d;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.e.d;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends a
/*     */ {
/*     */   public b(i parami) {
/*  24 */     super(parami);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<j> a(List<j> paramList) throws Exception {
/*  29 */     ArrayList<j> arrayList = new ArrayList();
/*  30 */     for (j j : paramList) {
/*  31 */       switch (null.b[j.ordinal()]) {
/*     */         case 1:
/*  33 */           a(arrayList);
/*     */         
/*     */         case 2:
/*  36 */           b(arrayList);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/*  43 */     return arrayList;
/*     */   }
/*     */   
/*     */   private void a(List<j> paramList) throws Exception {
/*  47 */     if (a().get()) {
/*     */       return;
/*     */     }
/*     */     
/*  51 */     String str = a().e().getData();
/*  52 */     if (str.isEmpty()) {
/*     */       return;
/*     */     }
/*     */     
/*  56 */     d d = d.a(str);
/*  57 */     Elements elements = d.a();
/*  58 */     if (!elements.isEmpty()) {
/*  59 */       a(paramList, elements, j.a);
/*     */     }
/*     */   }
/*     */   
/*     */   private void b(List<j> paramList) throws Exception {
/*  64 */     if (a().get()) {
/*     */       return;
/*     */     }
/*     */     
/*  68 */     String str = a().f().getData();
/*  69 */     if (str.isEmpty()) {
/*     */       return;
/*     */     }
/*     */     
/*  73 */     e e = e.a(str);
/*  74 */     Elements elements = e.b();
/*  75 */     if (!elements.isEmpty()) {
/*  76 */       a(paramList, elements, j.g);
/*     */     }
/*     */   }
/*     */   
/*     */   private void a(List<j> paramList, Elements paramElements, j paramj) throws Exception {
/*  81 */     for (Element element : paramElements) {
/*  82 */       if (a().get()) {
/*     */         return;
/*     */       }
/*     */       
/*  86 */       String str1 = element.select("a").attr("href").trim();
/*  87 */       String str2 = a().g(str1).getData();
/*  88 */       if (str2 == null || str2.isEmpty()) {
/*     */         continue;
/*     */       }
/*     */       
/*  92 */       f f = f.a(str2);
/*  93 */       if (f.i()) {
/*     */         continue;
/*     */       }
/*     */       
/*  97 */       if (paramj.equals(j.g) && 
/*  98 */         f.l()) {
/*     */         continue;
/*     */       }
/*     */ 
/*     */       
/* 103 */       Calendar calendar = f.d();
/* 104 */       if (a(calendar)) {
/*     */         continue;
/*     */       }
/*     */       
/* 108 */       int i = f.b();
/* 109 */       if (a(i)) {
/*     */         continue;
/*     */       }
/*     */       
/* 113 */       String str3 = "Encerramento: " + y.formatDate(calendar.getTime(), "dd/MM/yy HH:mm");
/*     */       
/* 115 */       d d = new d(a().a(), i);
/* 116 */       d.T(f.h());
/* 117 */       d.Q(f.a().intValue());
/* 118 */       d.aw(f.i());
/* 119 */       d.b(f.c());
/* 120 */       d.a(calendar);
/* 121 */       d.s(false);
/* 122 */       d.D(f.k());
/* 123 */       d.ay(str3);
/* 124 */       d.a(paramj);
/* 125 */       d.a(l.b);
/*     */       
/* 127 */       paramList.add(d);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final d a() {
/* 133 */     return (d)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */