/*     */ package org.passay;
/*     */ 
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
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
/*     */ public class r
/*     */   implements D
/*     */ {
/*     */   public static final int iV = 5;
/*     */   public static final int iW = 3;
/*     */   protected final H a;
/*     */   protected int iX;
/*     */   protected boolean dt;
/*     */   protected boolean dq;
/*     */   
/*     */   public r(H paramH) {
/*  41 */     this(paramH, 5, false, true);
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
/*     */   
/*     */   public r(H paramH, int paramInt, boolean paramBoolean) {
/*  54 */     this(paramH, paramInt, paramBoolean, true);
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
/*     */ 
/*     */   
/*     */   public r(H paramH, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/*  68 */     if (paramInt < 3) {
/*  69 */       throw new IllegalArgumentException(String.format("sequence length must be >= %s", new Object[] { Integer.valueOf(3) }));
/*     */     }
/*  71 */     this.a = paramH;
/*  72 */     this.iX = paramInt;
/*  73 */     this.dt = paramBoolean1;
/*  74 */     this.dq = paramBoolean2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int cb() {
/*  85 */     return this.iX;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public H a() {
/*  96 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public E a(x paramx) {
/* 103 */     E e = new E(true);
/* 104 */     String str = paramx.getPassword();
/* 105 */     int i = str.length() - this.iX + 1;
/*     */ 
/*     */ 
/*     */     
/* 109 */     for (byte b = 0; b < (this.a.a()).length; b++) {
/* 110 */       for (byte b1 = 0; b1 < i; b1++) {
/* 111 */         a a = a(this.a.a()[b], str.charAt(b1));
/* 112 */         if (a != null) {
/* 113 */           byte b2 = b1;
/* 114 */           while (a.gE()) {
/* 115 */             char c = str.charAt(++b2);
/* 116 */             if (a.matches(c)) {
/* 117 */               a.c(c);
/*     */             }
/*     */           } 
/*     */ 
/*     */           
/* 122 */           if (a.cc() == this.iX) {
/* 123 */             a(e, a.fg());
/*     */           }
/* 125 */           a.reset();
/* 126 */           b2 = b1;
/* 127 */           while (a.gF()) {
/* 128 */             char c = str.charAt(++b2);
/* 129 */             if (a.matches(c)) {
/* 130 */               a.c(c);
/*     */             }
/*     */           } 
/*     */ 
/*     */           
/* 135 */           if (a.cc() == this.iX) {
/* 136 */             a(e, a.fg());
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 141 */     return e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 148 */     return 
/* 149 */       String.format("%s@%h::length=%d,wrap=%s,reportAllFailures=%s", new Object[] {
/*     */           
/* 151 */           getClass().getName(), 
/* 152 */           Integer.valueOf(hashCode()), 
/* 153 */           Integer.valueOf(this.iX), 
/* 154 */           Boolean.valueOf(this.dt), 
/* 155 */           Boolean.valueOf(this.dq)
/*     */         });
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
/*     */ 
/*     */   
/*     */   private a a(h paramh, char paramChar) {
/* 170 */     for (byte b = 0; b < paramh.length(); b++) {
/* 171 */       if (paramh.a(b, paramChar)) {
/* 172 */         a a = new a(this, paramh, b, this.iX, this.dt);
/* 173 */         a.c(paramChar);
/* 174 */         return a;
/*     */       } 
/*     */     } 
/* 177 */     return null;
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
/*     */   private void a(E paramE, String paramString) {
/* 189 */     if (this.dq || paramE.bB().isEmpty()) {
/* 190 */       LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
/* 191 */       linkedHashMap.put("sequence", paramString);
/* 192 */       paramE.aR(false);
/* 193 */       paramE.bB().add(new F(this.a.getErrorCode(), (Map)linkedHashMap));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class a
/*     */   {
/*     */     private final h a;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int start;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private final int length;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int iY;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int iZ;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private int position;
/*     */ 
/*     */ 
/*     */     
/*     */     private final StringBuilder c;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     a(r this$0, h param1h, int param1Int1, int param1Int2, boolean param1Boolean) {
/* 238 */       this.a = (r)param1h;
/* 239 */       this.start = param1Int1;
/* 240 */       this.length = param1Int2;
/* 241 */       this.iZ = this.start - this.length;
/* 242 */       this.iY = this.start + this.length;
/* 243 */       if (this.iZ < -1 && !param1Boolean) {
/* 244 */         this.iZ = -1;
/*     */       }
/* 246 */       if (this.iY >= param1h.length() && !param1Boolean) {
/* 247 */         this.iY = param1h.length();
/*     */       }
/* 249 */       this.position = this.start;
/* 250 */       this.c = new StringBuilder(this.length);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean gE() {
/* 261 */       return (++this.position < this.iY);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean gF() {
/* 272 */       return (--this.position > this.iZ);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void reset() {
/* 279 */       this.position = this.start;
/* 280 */       this.c.delete(1, this.length);
/*     */     }
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
/*     */     public boolean matches(char param1Char) {
/*     */       int i;
/* 295 */       if (this.position < 0) {
/* 296 */         i = this.a.length() + this.position;
/* 297 */       } else if (this.position >= this.a.length()) {
/* 298 */         i = this.position - this.a.length();
/*     */       } else {
/* 300 */         i = this.position;
/*     */       } 
/* 302 */       return this.a.a(i, param1Char);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void c(char param1Char) {
/* 313 */       this.c.append(param1Char);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int cc() {
/* 324 */       return this.c.length();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String fg() {
/* 335 */       return this.c.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\r.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */