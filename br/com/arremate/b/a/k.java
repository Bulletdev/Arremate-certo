/*     */ package br.com.arremate.b.a;
/*     */ 
/*     */ import br.com.arremate.f.j;
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.u;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.j.j.a;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.j.b;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ 
/*     */ public class k
/*     */   extends a
/*     */ {
/*     */   public k(a parama) {
/*  23 */     super((i)parama);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<j> a(List<j> paramList) throws Exception {
/*  28 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*  29 */     byte b = 0;
/*  30 */     int i = 0;
/*  31 */     String str = y.formatDate(f().getTime(), "yyyy-MM-dd");
/*     */     
/*     */     do {
/*  34 */       b++;
/*  35 */       i i1 = new i(a().j(b, str).getData().replaceAll("\\\\.", ""));
/*     */       
/*  37 */       if (!i) {
/*  38 */         i i2 = i1.j("pagination");
/*  39 */         i = i2.getInt("totalPages");
/*     */       } 
/*     */       
/*  42 */       f f = i1.c("data");
/*  43 */       hashMap.putAll(a(f, paramList));
/*  44 */     } while (b < i);
/*     */     
/*  46 */     return new ArrayList<>(hashMap.values());
/*     */   }
/*     */   
/*     */   private HashMap<Integer, b> a(f paramf, List<j> paramList) {
/*  50 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/*  52 */     paramf.spliterator().forEachRemaining(paramObject -> {
/*     */           i i = (i)paramObject;
/*     */           
/*     */           b b = a(i);
/*     */           
/*     */           if (b != null && paramList.contains(b.a())) {
/*     */             paramHashMap.put(Integer.valueOf(b.v()), b);
/*     */           }
/*     */         });
/*  61 */     return (HashMap)hashMap;
/*     */   }
/*     */   
/*     */   private b a(i parami) {
/*  65 */     int j = parami.getInt("identitifer");
/*     */     
/*  67 */     if (a(j)) {
/*  68 */       return null;
/*     */     }
/*     */     
/*  71 */     b b = new b(a().a(), j);
/*  72 */     b.a(a(parami));
/*  73 */     b.T(c(parami));
/*  74 */     b.aw(parami.getString("buyer"));
/*  75 */     b.b(b(parami));
/*  76 */     b.s(parami.getBoolean("isPriceRecord"));
/*  77 */     b.a(a(parami));
/*  78 */     b.a(b(parami));
/*  79 */     b.a(a(parami));
/*  80 */     b.z(d(parami));
/*  81 */     return b;
/*     */   }
/*     */   
/*     */   private j a(i parami) {
/*     */     try {
/*  86 */       switch (parami.getInt("idStatus")) {
/*     */         case 1:
/*  88 */           return j.d;
/*     */         case 2:
/*  90 */           return j.a;
/*     */         case 4:
/*     */         case 6:
/*     */         case 12:
/*     */         case 18:
/*     */         case 19:
/*     */         case 20:
/*  97 */           return j.g;
/*     */       } 
/*  99 */     } catch (Exception exception) {
/* 100 */       a.error("Falha ao pegar o status, JSON: {}", parami);
/*     */     } 
/*     */     
/* 103 */     return j.d;
/*     */   }
/*     */   
/*     */   private String c(i parami) {
/* 107 */     String str = parami.has("number") ? "number" : "numero";
/* 108 */     Object object = parami.get(str);
/*     */ 
/*     */     
/* 111 */     int j = (object instanceof Integer) ? ((Integer)object).intValue() : Integer.parseInt(((String)object).split("/")[0]);
/* 112 */     return j + "/" + parami.getInt("year");
/*     */   }
/*     */   
/*     */   private Calendar b(i parami) {
/* 116 */     return y.c(y.X(parami.getString("datStartSession")));
/*     */   }
/*     */   
/*     */   private l a(i parami) {
/* 120 */     switch (parami.getInt("disputeMode")) {
/*     */       case 1:
/* 122 */         return l.a;
/*     */       case 2:
/* 124 */         return l.c;
/*     */     } 
/* 126 */     return l.l;
/*     */   }
/*     */ 
/*     */   
/*     */   private m b(i parami) {
/* 131 */     int j = parami.getInt("decree");
/* 132 */     int m = parami.getInt("typeModel");
/*     */     
/* 134 */     switch (j) {
/*     */       case 0:
/* 136 */         return m.a;
/*     */       case 1:
/* 138 */         return (m == 1) ? m.b : m.c;
/*     */     } 
/*     */     
/* 141 */     return m.e;
/*     */   }
/*     */   
/*     */   private u a(i parami) {
/* 145 */     switch (parami.getInt("typeBid")) {
/*     */       case 1:
/*     */       case 2:
/* 148 */         return u.c;
/*     */       case 3:
/*     */       case 6:
/* 151 */         return u.d;
/*     */       case 4:
/* 153 */         return u.i;
/*     */       case 5:
/* 155 */         return u.j;
/*     */     } 
/*     */     
/* 158 */     return u.h;
/*     */   }
/*     */   
/*     */   private boolean d(i parami) {
/* 162 */     switch (parami.getInt("typeBid")) {
/*     */       case 1:
/*     */       case 3:
/* 165 */         return true;
/*     */       case 2:
/*     */       case 6:
/* 168 */         return false;
/*     */     } 
/* 170 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<j> a(String paramString) throws Exception {
/* 175 */     int i = Integer.parseInt(paramString);
/* 176 */     i i1 = new i(a().t(i).getData().replaceAll("\\\\.", ""));
/* 177 */     b b = a(i1);
/* 178 */     ArrayList<b> arrayList = new ArrayList();
/* 179 */     arrayList.add(b);
/*     */     
/* 181 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public a a() {
/* 186 */     return (a)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\b\a\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */