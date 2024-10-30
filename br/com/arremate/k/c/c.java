/*     */ package br.com.arremate.k.c;
/*     */ 
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.f.o;
/*     */ import br.com.arremate.j.a;
/*     */ import br.com.arremate.j.a.b;
/*     */ import br.com.arremate.j.b;
/*     */ import br.com.arremate.j.b.b;
/*     */ import br.com.arremate.j.c.d;
/*     */ import br.com.arremate.j.c.e;
/*     */ import br.com.arremate.j.c.f;
/*     */ import br.com.arremate.j.d.d;
/*     */ import br.com.arremate.j.e;
/*     */ import br.com.arremate.j.e.a;
/*     */ import br.com.arremate.j.f;
/*     */ import br.com.arremate.j.f.a;
/*     */ import br.com.arremate.j.g.b;
/*     */ import br.com.arremate.j.h;
/*     */ import br.com.arremate.j.h.b;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.j.j;
/*     */ import br.com.arremate.j.j.a;
/*     */ import br.com.arremate.j.k.a;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.m.g;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class c
/*     */ {
/*  41 */   private static final Logger a = LoggerFactory.getLogger(c.class);
/*  42 */   private static final ExecutorService h = Executors.newCachedThreadPool();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Future<i> a(j paramj) {
/*  48 */     return h.submit(() -> {
/*     */           i i = b(paramj);
/*     */           return a(i);
/*     */         });
/*     */   }
/*     */   
/*     */   public static Future<i> a(d paramd) {
/*  55 */     return h.submit(() -> {
/*     */           i i = a(paramd);
/*     */           return a(i);
/*     */         });
/*     */   }
/*     */   
/*     */   public static Future<i> b(j paramj) {
/*  62 */     return h.submit(() -> {
/*     */           i i = a(paramj);
/*     */           return a(i);
/*     */         });
/*     */   }
/*     */   
/*     */   private static i a(i parami) {
/*     */     try {
/*  70 */       if (parami != null) {
/*  71 */         d d = parami.a();
/*  72 */         o o = d.b().a();
/*  73 */         if (a(o)) {
/*  74 */           int j = parami.z();
/*  75 */           if (j == 2) {
/*  76 */             g.b(d);
/*     */           }
/*     */         } else {
/*  79 */           return parami;
/*     */         } 
/*     */       } 
/*  82 */     } catch (Exception exception) {
/*  83 */       a.error("Erro ao criar login para o portal", exception);
/*     */     } 
/*     */     
/*  86 */     return parami;
/*     */   }
/*     */   
/*     */   private static boolean a(o paramo) {
/*  90 */     return (paramo != o.b && paramo != o.d && paramo != o.a && paramo != o.n && paramo != o.f && paramo != o.e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static i a(j paramj) {
/*  99 */     o o = paramj.b().a();
/* 100 */     if (o.equals(o.b)) {
/* 101 */       return (i)d.a().a(paramj.a(), false);
/*     */     }
/* 103 */     return b(paramj);
/*     */   }
/*     */ 
/*     */   
/*     */   private static i b(j paramj) {
/* 108 */     d d = paramj.a();
/* 109 */     o o = d.b().a();
/* 110 */     if (o.equals(o.a)) {
/* 111 */       l l = paramj.a();
/* 112 */       i i = (i)(l.equals(l.c) ? new d(d) : new e(d));
/* 113 */       i.z();
/* 114 */       return i;
/*     */     } 
/* 116 */     return a(d);
/*     */   }
/*     */ 
/*     */   
/*     */   public static i a(d paramd) {
/* 121 */     return a(paramd, false);
/*     */   }
/*     */   
/*     */   public static i a(d paramd, boolean paramBoolean) {
/* 125 */     o o = paramd.b().a();
/* 126 */     switch (null.g[o.ordinal()]) {
/*     */       case 1:
/* 128 */         return (i)d.a().a(paramd, paramBoolean);
/*     */       case 2:
/* 130 */         return (i)br.com.arremate.j.i.c.a().a(paramd);
/*     */       case 3:
/* 132 */         return (i)f.a().a(paramd);
/*     */       case 4:
/* 134 */         if (paramBoolean) {
/* 135 */           return (i)f.a().a(paramd);
/*     */         }
/* 137 */         return (i)new d(paramd);
/*     */       case 5:
/* 139 */         return (i)new e(paramd);
/*     */       case 6:
/* 141 */         return (i)new h(paramd);
/*     */       case 7:
/* 143 */         return (i)b.a().a(paramd, paramBoolean);
/*     */       case 8:
/* 145 */         return (i)b.a().a(paramd, paramBoolean);
/*     */       case 9:
/* 147 */         return (i)new b(paramd);
/*     */       case 10:
/* 149 */         return (i)b.a().a(paramd, paramBoolean);
/*     */       case 11:
/* 151 */         return (i)new f(paramd);
/*     */       case 12:
/* 153 */         return (i)new j(paramd);
/*     */       case 13:
/* 155 */         return (i)b.a().a(paramd, paramBoolean);
/*     */       case 14:
/* 157 */         return (i)new a(paramd);
/*     */       case 15:
/* 159 */         return (i)new a(paramd);
/*     */       case 16:
/* 161 */         return (i)new a(paramd);
/*     */       case 17:
/* 163 */         return (i)b.a().a(paramd);
/*     */       case 18:
/* 165 */         return (i)new a(paramd);
/*     */       case 19:
/* 167 */         return (i)new a(paramd);
/*     */     } 
/*     */     
/* 170 */     return null;
/*     */   }
/*     */   
/*     */   public static void b(i parami) {
/* 174 */     if (parami != null && parami.isRunning())
/* 175 */       parami.b(); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\k\c\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */