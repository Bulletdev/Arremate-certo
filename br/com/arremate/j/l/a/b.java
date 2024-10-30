/*     */ package br.com.arremate.j.l.a;
/*     */ 
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.Date;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class b
/*     */ {
/*  19 */   private static final String dg = "99.999.999/9999-99";
/*     */   
/*     */   private final d b;
/*     */   
/*     */   private final int aF;
/*     */   private final String df;
/*     */   private final long F;
/*     */   
/*     */   public b(d paramd) {
/*  28 */     this.b = paramd;
/*  29 */     this.F = System.currentTimeMillis();
/*  30 */     this.df = "EFFECTI SIMULAÇÃO";
/*  31 */     this.aF = 2014;
/*     */   }
/*     */   
/*     */   a a(int paramInt) {
/*  35 */     long l = this.F;
/*     */     
/*  37 */     switch (paramInt) {
/*     */       case 100001:
/*  39 */         return a();
/*     */       case 100005:
/*  41 */         return b();
/*     */       case 100002:
/*  43 */         l += TimeUnit.HOURS.toMillis(2L);
/*     */       case 100003:
/*  45 */         l += TimeUnit.DAYS.toMillis(1L) - TimeUnit.HOURS.toMillis(4L);
/*     */       case 100004:
/*  47 */         l += TimeUnit.DAYS.toMillis(1L) - TimeUnit.HOURS.toMillis(1L); break;
/*     */     } 
/*  49 */     return a(paramInt, l);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private h a(double paramDouble, int paramInt, Date paramDate, String paramString1, String paramString2) {
/*  55 */     return a(paramDouble, paramInt, paramDate, paramString1, paramString2, false);
/*     */   }
/*     */ 
/*     */   
/*     */   private h a(double paramDouble, int paramInt, Date paramDate, String paramString1, String paramString2, boolean paramBoolean) {
/*  60 */     h h = new h(paramDouble);
/*  61 */     h.l(paramInt);
/*  62 */     h.c(paramDate);
/*  63 */     h.E(paramString1);
/*  64 */     h.D(paramString2);
/*  65 */     h.A(paramBoolean);
/*  66 */     return h;
/*     */   }
/*     */   
/*     */   private a a(int paramInt, long paramLong) {
/*  70 */     String str = Integer.toString(paramInt - 100000) + "2019";
/*  71 */     return new a(this.b, paramInt, str, this.aF, this.df, new Date(paramLong), false, false);
/*     */   }
/*     */ 
/*     */   
/*     */   private a a() {
/*  76 */     a a = new a(this.b, 100001, "12019", this.aF, this.df, new Date(this.F), false, false);
/*     */ 
/*     */     
/*  79 */     String str1 = y.k("##.###.###/####-##", Long.toString(this.b.x()));
/*  80 */     String str2 = "Jean";
/*  81 */     String str3 = "Fernanda";
/*  82 */     String str4 = "Lenilson";
/*  83 */     String str5 = "Mateus";
/*     */ 
/*     */     
/*  86 */     c c1 = new c(1000011, "1", 5, 60, 70, 180, 100, false);
/*  87 */     Date date = a.a();
/*  88 */     byte b1 = 1;
/*     */     
/*  90 */     h h1 = a(16862.0D, b1++, date, this.b.bv(), str1, true);
/*  91 */     c1.a((e)null, h1);
/*     */     
/*  93 */     e e = new e(str2, 15000.0D, 50.0F, 150.0F, g.k);
/*  94 */     h h2 = a(18049.37D, b1++, date, str2, dg);
/*  95 */     c1.a(e, h2);
/*     */     
/*  97 */     e = new e(str3, 16000.0D, 250.0F, 400.0F, g.f);
/*  98 */     h2 = a(18789.12D, b1++, date, str3, dg);
/*  99 */     c1.a(e, h2);
/*     */     
/* 101 */     e = new e(str4, 14950.0D, 100.0F, 250.0F, g.j);
/* 102 */     h2 = a(20000.0D, b1++, date, str4, dg);
/* 103 */     c1.a(e, h2);
/*     */     
/* 105 */     e = new e(str5, 15230.0D, 80.0F, 150.0F, g.k);
/* 106 */     h2 = a(22450.0D, b1++, date, str5, dg);
/* 107 */     c1.a(e, h2);
/*     */ 
/*     */     
/* 110 */     c c2 = new c(1000012, "2", 45, 90, 160, 283, 100, false);
/* 111 */     b1 = 1;
/*     */     
/* 113 */     e = new e(str2, 6000.0D, 50.0F, 100.0F, g.f);
/* 114 */     h2 = a(7213.75D, b1++, date, str2, dg);
/* 115 */     c2.a(e, h2);
/*     */     
/* 117 */     e = new e(str3, 7000.0D, 1.0F, 10.0F, g.k);
/* 118 */     h2 = a(8500.0D, b1++, date, str3, dg);
/* 119 */     c2.a(e, h2);
/*     */     
/* 121 */     h1 = a(8600.0D, b1++, date, this.b.bv(), str1, true);
/* 122 */     c2.a((e)null, h1);
/*     */     
/* 124 */     e = new e(str4, 6180.0D, 40.0F, 80.0F, g.f);
/* 125 */     h2 = a(9000.0D, b1++, date, str4, dg);
/* 126 */     c2.a(e, h2);
/*     */     
/* 128 */     e = new e(str5, 6500.0D, 100.0F, 115.0F, g.k);
/* 129 */     h2 = a(9000.0D, b1++, date, str5, dg);
/* 130 */     c2.a(e, h2);
/*     */ 
/*     */     
/* 133 */     c c3 = new c(1000013, "3", 45, 90, 160, 300, 100, false);
/* 134 */     b1 = 1;
/*     */     
/* 136 */     e = new e(str2, 80000.0D, 1000.0F, 1500.0F, g.f);
/* 137 */     h2 = a(120000.0D, b1++, date, str2, dg);
/* 138 */     c3.a(e, h2);
/*     */     
/* 140 */     e = new e(str3, 72000.0D, 500.0F, 2000.0F, g.j);
/* 141 */     h2 = a(135000.0D, b1++, date, str3, dg);
/* 142 */     c3.a(e, h2);
/*     */     
/* 144 */     e = new e(str4, 93000.0D, 100.0F, 3000.0F, g.f);
/* 145 */     h2 = a(140000.0D, b1++, date, str4, dg);
/* 146 */     c3.a(e, h2);
/*     */     
/* 148 */     h1 = a(150000.0D, b1++, date, this.b.bv(), str1, true);
/* 149 */     c3.a((e)null, h1);
/*     */     
/* 151 */     e = new e(str5, 70000.0D, 1000.0F, 5000.0F, g.j);
/* 152 */     h2 = a(150000.0D, b1++, date, str5, dg);
/* 153 */     c3.a(e, h2);
/*     */     
/* 155 */     a.a(c1);
/* 156 */     a.a(c2);
/* 157 */     a.a(c3);
/* 158 */     return a;
/*     */   }
/*     */   
/*     */   private a b() {
/* 162 */     a a = new a(this.b, 100005, "52019", this.aF, this.df, new Date(this.F), true, false);
/*     */ 
/*     */     
/* 165 */     String str1 = y.k("##.###.###/####-##", Long.toString(this.b.x()));
/* 166 */     String str2 = "Lenilson";
/* 167 */     String str3 = "Jean";
/* 168 */     String str4 = "Fernanda";
/*     */ 
/*     */     
/* 171 */     c c1 = new c(1000051, "1", 5, 60, 70, 180, 100, true);
/* 172 */     Date date = a.a();
/* 173 */     byte b1 = 1;
/*     */     
/* 175 */     h h1 = a(16862.0D, b1++, date, this.b.bv(), str1, true);
/* 176 */     c1.a((e)null, h1);
/*     */     
/* 178 */     e e = new e(str2, 150.0D, 1.0F, 2.5F, g.f);
/* 179 */     h h2 = a(18049.37D, b1++, date, str2, dg);
/* 180 */     c1.a(e, h2);
/*     */     
/* 182 */     e = new e(str3, 160.0D, 2.5F, 4.0F, g.f);
/* 183 */     h2 = a(18789.12D, b1++, date, str3, dg);
/* 184 */     c1.a(e, h2);
/*     */     
/* 186 */     e = new e(str4, 152.3D, 1.8F, 3.5F, g.k);
/* 187 */     h2 = a(22450.0D, b1++, date, str4, dg);
/* 188 */     c1.a(e, h2);
/*     */ 
/*     */     
/* 191 */     c c2 = new c(1000052, "2", 45, 90, 160, 283, 100, true);
/* 192 */     b1 = 1;
/*     */     
/* 194 */     e = new e(str2, 60.0D, 1.0F, 3.0F, g.f);
/* 195 */     h2 = a(7213.75D, b1++, date, str2, dg);
/* 196 */     c2.a(e, h2);
/*     */     
/* 198 */     e = new e(str3, 70.0D, 1.0F, 2.5F, g.k);
/* 199 */     h2 = a(8500.0D, b1++, date, str3, dg);
/* 200 */     c2.a(e, h2);
/*     */     
/* 202 */     h1 = a(8600.0D, b1++, date, this.b.bv(), str1, true);
/* 203 */     c2.a((e)null, h1);
/*     */     
/* 205 */     e = new e(str4, 65.0D, 0.4F, 1.15F, g.k);
/* 206 */     h2 = a(9000.0D, b1++, date, str4, dg);
/* 207 */     c2.a(e, h2);
/*     */     
/* 209 */     a.a(c1);
/* 210 */     a.a(c2);
/* 211 */     return a;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\l\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */