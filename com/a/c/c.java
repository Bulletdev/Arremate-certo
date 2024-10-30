/*     */ package com.a.c;
/*     */ 
/*     */ import com.a.e.a;
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
/*     */ public abstract class c
/*     */ {
/*  46 */   protected c a = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract double a(o paramo, f paramf);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean a(c paramc) {
/*  58 */     c c1 = this;
/*     */     
/*  60 */     while (c1 != null) {
/*  61 */       if (c1 == paramc)
/*  62 */         return true; 
/*  63 */       c1 = c1.a;
/*     */     } 
/*     */     
/*  66 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public c a() {
/*  73 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(c paramc) {
/*  84 */     if (paramc == null) {
/*  85 */       throw new IllegalArgumentException("expression cannot be null");
/*     */     }
/*  87 */     if (paramc.a != null) {
/*  88 */       throw new IllegalArgumentException("expression must be removed parent");
/*     */     }
/*  90 */     if (a(paramc)) {
/*  91 */       throw new IllegalArgumentException("cyclic reference");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getVariableNames() {
/*  98 */     return a(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] b() {
/* 105 */     return a(false);
/*     */   }
/*     */   
/*     */   private String[] a(boolean paramBoolean) {
/* 109 */     a a = new a();
/* 110 */     a(this, a, paramBoolean);
/* 111 */     String[] arrayOfString = new String[a.size()];
/* 112 */     for (byte b = 0; b < arrayOfString.length; b++)
/* 113 */       arrayOfString[b] = (String)a.get(b); 
/* 114 */     return arrayOfString;
/*     */   }
/*     */   
/*     */   private static void a(c paramc, a parama, boolean paramBoolean) {
/* 118 */     if (paramc instanceof i) {
/* 119 */       i i = (i)paramc;
/* 120 */       a(i.b, parama, paramBoolean);
/* 121 */       a(i.c, parama, paramBoolean);
/*     */     }
/* 123 */     else if (paramc instanceof p) {
/* 124 */       if (paramBoolean) {
/* 125 */         p p = (p)paramc;
/* 126 */         if (!parama.contains(p.name)) {
/* 127 */           parama.add(p.name);
/*     */         }
/*     */       } 
/* 130 */     } else if (paramc instanceof g) {
/* 131 */       g g = (g)paramc;
/*     */       
/* 133 */       if (!paramBoolean && 
/* 134 */         !parama.contains(g.name)) {
/* 135 */         parama.add(g.name);
/*     */       }
/*     */       
/* 138 */       for (byte b = 0; b < g.aP(); b++) {
/* 139 */         a(g.a(b), parama, paramBoolean);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 147 */     StringBuffer stringBuffer = new StringBuffer();
/* 148 */     a(this, stringBuffer);
/* 149 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   private static void a(c paramc, StringBuffer paramStringBuffer) {
/* 153 */     if (paramc instanceof i) {
/* 154 */       i i = (i)paramc;
/* 155 */       paramStringBuffer.append("(");
/* 156 */       a(i.b, paramStringBuffer);
/* 157 */       paramStringBuffer.append(i.dC());
/* 158 */       a(i.c, paramStringBuffer);
/* 159 */       paramStringBuffer.append(")");
/*     */     }
/* 161 */     else if (paramc instanceof m) {
/* 162 */       m m = (m)paramc;
/*     */       
/* 164 */       if (m.dQ()) {
/* 165 */         paramStringBuffer.append("(");
/* 166 */         paramStringBuffer.append("-");
/*     */       } 
/*     */       
/* 169 */       paramStringBuffer.append(m.getName());
/*     */       
/* 171 */       if (m instanceof g) {
/* 172 */         g g = (g)m;
/*     */         
/* 174 */         paramStringBuffer.append("(");
/*     */         
/* 176 */         if (g.aP() > 0) {
/* 177 */           a(g.a(0), paramStringBuffer);
/*     */         }
/* 179 */         for (byte b = 1; b < g.aP(); b++) {
/* 180 */           paramStringBuffer.append(", ");
/* 181 */           a(g.a(b), paramStringBuffer);
/*     */         } 
/*     */         
/* 184 */         paramStringBuffer.append(")");
/*     */       } 
/*     */       
/* 187 */       if (m.dQ()) {
/* 188 */         paramStringBuffer.append(")");
/*     */       }
/* 190 */     } else if (paramc instanceof n) {
/* 191 */       paramStringBuffer.append(((n)paramc).X);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\c\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */