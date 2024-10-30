/*     */ package com.a.c;
/*     */ 
/*     */ import com.a.c.a.A;
/*     */ import com.a.c.a.B;
/*     */ import com.a.c.a.C;
/*     */ import com.a.c.a.D;
/*     */ import com.a.c.a.E;
/*     */ import com.a.c.a.F;
/*     */ import com.a.c.a.G;
/*     */ import com.a.c.a.H;
/*     */ import com.a.c.a.a;
/*     */ import com.a.c.a.b;
/*     */ import com.a.c.a.c;
/*     */ import com.a.c.a.d;
/*     */ import com.a.c.a.e;
/*     */ import com.a.c.a.f;
/*     */ import com.a.c.a.g;
/*     */ import com.a.c.a.h;
/*     */ import com.a.c.a.i;
/*     */ import com.a.c.a.j;
/*     */ import com.a.c.a.k;
/*     */ import com.a.c.a.l;
/*     */ import com.a.c.a.m;
/*     */ import com.a.c.a.n;
/*     */ import com.a.c.a.o;
/*     */ import com.a.c.a.p;
/*     */ import com.a.c.a.q;
/*     */ import com.a.c.a.r;
/*     */ import com.a.c.a.s;
/*     */ import com.a.c.a.t;
/*     */ import com.a.c.a.u;
/*     */ import com.a.c.a.v;
/*     */ import com.a.c.a.w;
/*     */ import com.a.c.a.x;
/*     */ import com.a.c.a.y;
/*     */ import com.a.c.a.z;
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
/*     */ public class f
/*     */ {
/* 114 */   private String[] b = new String[50];
/* 115 */   private q[] a = new q[50];
/* 116 */   private int gQ = 0;
/*     */   private boolean caseSensitive = false;
/*     */   
/*     */   public f() {}
/*     */   
/*     */   public f(boolean paramBoolean) {
/* 122 */     this.caseSensitive = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void gs() {
/* 130 */     a("min", (q)new v());
/* 131 */     a("max", (q)new u());
/*     */ 
/*     */     
/* 134 */     a("sum", (q)new F());
/* 135 */     a("avg", (q)new h());
/*     */ 
/*     */     
/* 138 */     a("pi", (q)new x());
/* 139 */     a("e", (q)new m());
/* 140 */     a("rand", (q)new z());
/*     */ 
/*     */     
/* 143 */     a("sin", (q)new C());
/* 144 */     a("cos", (q)new k());
/* 145 */     a("tan", (q)new G());
/* 146 */     a("sqrt", (q)new E());
/* 147 */     a("abs", (q)new a());
/* 148 */     a("ceil", (q)new i());
/* 149 */     a("floor", (q)new p());
/* 150 */     a("exp", (q)new n());
/* 151 */     a("lg", (q)new r());
/* 152 */     a("ln", (q)new s());
/* 153 */     a("sign", (q)new B());
/* 154 */     a("round", (q)new A());
/* 155 */     a("fact", (q)new o());
/* 156 */     a("cosh", (q)new l());
/* 157 */     a("sinh", (q)new D());
/* 158 */     a("tanh", (q)new H());
/* 159 */     a("acos", (q)new b());
/* 160 */     a("asin", (q)new d());
/* 161 */     a("atan", (q)new f());
/* 162 */     a("acosh", (q)new c());
/* 163 */     a("asinh", (q)new e());
/* 164 */     a("atanh", (q)new g());
/*     */ 
/*     */     
/* 167 */     a("pow", (q)new y());
/* 168 */     a("mod", (q)new w());
/* 169 */     a("combin", (q)new j());
/*     */ 
/*     */     
/* 172 */     a("log", (q)new t());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public q a(String paramString, int paramInt) {
/* 181 */     for (byte b = 0; b < this.gQ; b++) {
/* 182 */       if (this.a[b].t(paramInt) && ((this.caseSensitive && this.b[b].equals(paramString)) || (!this.caseSensitive && this.b[b].equalsIgnoreCase(paramString)))) {
/* 183 */         return this.a[b];
/*     */       }
/*     */     } 
/* 186 */     throw new RuntimeException("function not found: " + paramString + " " + paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(String paramString, q paramq) {
/* 195 */     if (paramString == null) {
/* 196 */       throw new IllegalArgumentException("function name cannot be null");
/*     */     }
/* 198 */     if (paramq == null) {
/* 199 */       throw new IllegalArgumentException("function cannot be null");
/*     */     }
/* 201 */     for (byte b = 0; b < this.gQ; b++) {
/* 202 */       if ((this.caseSensitive && this.b[b].equals(paramString)) || (!this.caseSensitive && this.b[b].equalsIgnoreCase(paramString))) {
/* 203 */         this.a[b] = paramq;
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 208 */     if (this.gQ == this.b.length) {
/* 209 */       String[] arrayOfString = new String[2 * this.gQ];
/* 210 */       q[] arrayOfQ = new q[arrayOfString.length];
/*     */       
/* 212 */       for (byte b1 = 0; b1 < this.gQ; b1++) {
/* 213 */         arrayOfString[b1] = this.b[b1];
/* 214 */         arrayOfQ[b1] = this.a[b1];
/*     */       } 
/*     */       
/* 217 */       this.b = arrayOfString;
/* 218 */       this.a = arrayOfQ;
/*     */     } 
/*     */     
/* 221 */     this.b[this.gQ] = paramString;
/* 222 */     this.a[this.gQ] = paramq;
/* 223 */     this.gQ++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCaseSensitive() {
/* 230 */     return this.caseSensitive;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] b() {
/* 237 */     String[] arrayOfString = new String[this.gQ];
/*     */     
/* 239 */     for (byte b = 0; b < arrayOfString.length; b++) {
/* 240 */       arrayOfString[b] = this.b[b];
/*     */     }
/* 242 */     return arrayOfString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public q[] a() {
/* 250 */     q[] arrayOfQ = new q[this.gQ];
/*     */     
/* 252 */     for (byte b = 0; b < arrayOfQ.length; b++) {
/* 253 */       arrayOfQ[b] = this.a[b];
/*     */     }
/* 255 */     return arrayOfQ;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(String paramString) {
/* 263 */     for (byte b = 0; b < this.gQ; b++) {
/* 264 */       if ((this.caseSensitive && this.b[b].equals(paramString)) || (!this.caseSensitive && this.b[b].equalsIgnoreCase(paramString))) {
/* 265 */         for (int i = b + 1; i < this.gQ; i++) {
/* 266 */           this.b[i - 1] = this.b[i];
/* 267 */           this.a[i - 1] = this.a[i];
/*     */         } 
/* 269 */         this.gQ--;
/* 270 */         this.b[this.gQ] = null;
/* 271 */         this.a[this.gQ] = null;
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\c\f.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */