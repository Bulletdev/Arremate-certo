/*     */ package br.com.arremate.b.a;
/*     */ 
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.j.i.b;
/*     */ import br.com.arremate.l.i.b;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class j
/*     */   extends a
/*     */ {
/*     */   public j(i parami) {
/*  25 */     super(parami);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<br.com.arremate.l.j> a(List<br.com.arremate.f.j> paramList) throws Exception {
/*  30 */     ArrayList<br.com.arremate.l.j> arrayList = new ArrayList();
/*  31 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  32 */     for (br.com.arremate.f.j j1 : paramList) {
/*  33 */       switch (null.b[j1.ordinal()]) {
/*     */         case 1:
/*  35 */           hashMap.put(j1, Arrays.asList(new String[] { "3", "4", "5" }));
/*     */         
/*     */         case 2:
/*  38 */           hashMap.put(j1, Arrays.asList(new String[] { "6" }));
/*     */         
/*     */         case 3:
/*  41 */           hashMap.put(j1, Arrays.asList(new String[] { "7" }));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/*  48 */     for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
/*  49 */       for (String str : entry.getValue()) {
/*  50 */         if (a().get()) {
/*  51 */           return arrayList;
/*     */         }
/*     */         
/*  54 */         e e = a().B(str);
/*  55 */         i i = new i(e.getData());
/*  56 */         if (i.getInt("statusCode") == 200) {
/*  57 */           a(i.j("data").c("conteudo"), (br.com.arremate.f.j)entry.getKey(), arrayList);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  62 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<br.com.arremate.l.j> a(String paramString) throws Exception {
/*  67 */     return null;
/*     */   }
/*     */   
/*     */   private void a(f paramf, br.com.arremate.f.j paramj, List<br.com.arremate.l.j> paramList) throws Exception {
/*  71 */     for (byte b = 0; b < paramf.length(); b++) {
/*  72 */       i i = (i)paramf.get(b);
/*  73 */       int k = i.getInt("numeroLicitacao");
/*  74 */       b b1 = new b(a().a(), k);
/*     */       
/*  76 */       if (!a(k)) {
/*     */ 
/*     */ 
/*     */         
/*  80 */         if (a(y.d(i.getString("dataFimAcolhimentoProposta")))) {
/*     */           break;
/*     */         }
/*     */         
/*  84 */         b1.T(String.valueOf(k));
/*  85 */         b1.a(paramj);
/*  86 */         b1.aw(i.getString("nomeComprador"));
/*  87 */         b1.a(a(i.getInt("codigoModalidade")));
/*     */         
/*  89 */         i i1 = new i(a().q(b1.v()).getData());
/*  90 */         i1 = i1.j("data");
/*  91 */         b1.b(y.c(i1.getString("dataHoraDisputa")));
/*  92 */         b1.D(!i1.getString("equalizacaoICMS").toLowerCase().equals("sem icms"));
/*     */         
/*  94 */         b1.a(m.e);
/*  95 */         b1.a(b(i1.getString("tipoLicitacao").toLowerCase()));
/*     */         
/*  97 */         paramList.add(b1);
/*     */       } 
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
/*     */   
/*     */   private l a(int paramInt) {
/* 111 */     switch (paramInt) {
/*     */       case 7:
/* 113 */         return l.i;
/*     */       case 8:
/* 115 */         return l.j;
/*     */     } 
/* 117 */     return l.l;
/*     */   }
/*     */ 
/*     */   
/*     */   private u b(String paramString) {
/* 122 */     switch (paramString) {
/*     */       case "menor preço":
/* 124 */         return u.c;
/*     */     } 
/* 126 */     return u.d;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public b a() {
/* 132 */     return (b)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */