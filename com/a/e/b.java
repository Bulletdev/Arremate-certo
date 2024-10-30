/*     */ package com.a.e;
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
/*     */ public class b
/*     */ {
/*  36 */   protected a a = null;
/*  37 */   protected a b = null;
/*  38 */   protected int size = 0;
/*     */ 
/*     */   
/*     */   public static class a
/*     */   {
/*  43 */     protected b a = null;
/*  44 */     protected a c = null;
/*  45 */     protected a d = null;
/*  46 */     protected Object aw = null;
/*     */     
/*     */     protected a(b param1b, Object param1Object) {
/*  49 */       this.a = param1b;
/*  50 */       this.aw = param1Object;
/*     */     }
/*     */     
/*     */     public b a() {
/*  54 */       return this.a;
/*     */     }
/*     */     
/*     */     public a c() {
/*  58 */       return this.c;
/*     */     }
/*     */     
/*     */     public a d() {
/*  62 */       return this.d;
/*     */     }
/*     */     
/*     */     public Object J() {
/*  66 */       return this.aw;
/*     */     }
/*     */     
/*     */     public void z(Object param1Object) {
/*  70 */       this.aw = param1Object;
/*     */     }
/*     */     
/*     */     public void A(Object param1Object) {
/*  74 */       this.a.a(this, param1Object);
/*     */     }
/*     */     
/*     */     public void B(Object param1Object) {
/*  78 */       this.a.b(this, param1Object);
/*     */     }
/*     */     
/*     */     public void remove() {
/*  82 */       this.a.a(this);
/*     */     }
/*     */   }
/*     */   
/*     */   protected a a(Object paramObject) {
/*  87 */     return new a(this, paramObject);
/*     */   }
/*     */   
/*     */   protected void a(a parama, Object paramObject) {
/*  91 */     a a1 = a(paramObject);
/*     */     
/*  93 */     if (this.size == 0) {
/*  94 */       this.a = a1;
/*  95 */       this.b = a1;
/*     */     
/*     */     }
/*  98 */     else if (parama == this.a) {
/*  99 */       a1.c = this.a;
/* 100 */       this.a.d = a1;
/* 101 */       this.a = a1;
/*     */     } else {
/*     */       
/* 104 */       parama.d.c = a1;
/* 105 */       a1.d = parama.d;
/* 106 */       parama.d = a1;
/* 107 */       a1.c = parama;
/*     */     } 
/*     */ 
/*     */     
/* 111 */     this.size++;
/*     */   }
/*     */   
/*     */   protected void b(a parama, Object paramObject) {
/* 115 */     a a1 = a(paramObject);
/*     */     
/* 117 */     if (this.size == 0) {
/* 118 */       this.a = a1;
/* 119 */       this.b = a1;
/*     */     
/*     */     }
/* 122 */     else if (parama == this.b) {
/* 123 */       a1.d = this.b;
/* 124 */       this.b.c = a1;
/* 125 */       this.b = a1;
/*     */     } else {
/*     */       
/* 128 */       parama.c.d = a1;
/* 129 */       a1.c = parama.c;
/* 130 */       parama.c = a1;
/* 131 */       a1.d = parama;
/*     */     } 
/*     */ 
/*     */     
/* 135 */     this.size++;
/*     */   }
/*     */   
/*     */   protected Object a(a parama) {
/* 139 */     if (this.size == 0) {
/* 140 */       return null;
/*     */     }
/* 142 */     Object object = parama.aw;
/*     */     
/* 144 */     if (parama == this.a) {
/* 145 */       this.a = this.a.c;
/*     */       
/* 147 */       if (this.a == null) {
/* 148 */         this.b = null;
/*     */       } else {
/* 150 */         this.a.d = null;
/*     */       } 
/* 152 */     } else if (parama == this.b) {
/* 153 */       this.b = this.b.d;
/* 154 */       this.b.c = null;
/*     */     } else {
/*     */       
/* 157 */       parama.d.c = parama.c;
/* 158 */       parama.c.d = parama.d;
/*     */     } 
/*     */     
/* 161 */     parama.a = null;
/* 162 */     this.size--;
/* 163 */     return object;
/*     */   }
/*     */   
/*     */   public a a() {
/* 167 */     return this.a;
/*     */   }
/*     */   
/*     */   public a b() {
/* 171 */     return this.b;
/*     */   }
/*     */   
/*     */   public void x(Object paramObject) {
/* 175 */     a(this.a, paramObject);
/*     */   }
/*     */   
/*     */   public void y(Object paramObject) {
/* 179 */     b(this.b, paramObject);
/*     */   }
/*     */   
/*     */   public Object H() {
/* 183 */     return a(this.a);
/*     */   }
/*     */   
/*     */   public Object I() {
/* 187 */     return a(this.b);
/*     */   }
/*     */   
/*     */   public int size() {
/* 191 */     return this.size;
/*     */   }
/*     */   
/*     */   public boolean isEmpty() {
/* 195 */     return (this.size == 0);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 199 */     StringBuffer stringBuffer = new StringBuffer(6 * this.size);
/* 200 */     stringBuffer.append("[");
/* 201 */     a a1 = this.a;
/*     */     
/* 203 */     if (a1 != null) {
/* 204 */       stringBuffer.append(a1.aw);
/* 205 */       a1 = a1.c;
/*     */     } 
/*     */     
/* 208 */     while (a1 != null) {
/* 209 */       stringBuffer.append(", ");
/* 210 */       stringBuffer.append(a1.aw);
/* 211 */       a1 = a1.c;
/*     */     } 
/*     */     
/* 214 */     return stringBuffer.append("]").toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\e\b.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */