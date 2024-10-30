/*     */ package com.a.a;
/*     */ 
/*     */ import com.a.c.c;
/*     */ import com.a.c.d;
/*     */ import com.a.c.e;
/*     */ import com.a.c.f;
/*     */ import com.a.c.o;
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
/*     */ public class j
/*     */ {
/*  99 */   protected String iZ = null;
/* 100 */   protected int[] ag = null;
/*     */   
/* 102 */   protected int gH = 0;
/* 103 */   protected int gI = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j(String paramString, int paramInt) {
/* 112 */     if (paramString == null) {
/* 113 */       throw new IllegalArgumentException("control string cannot be null");
/*     */     }
/* 115 */     this.ag = a(paramString, paramInt);
/* 116 */     this.iZ = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j(int[] paramArrayOfint) {
/* 126 */     if (paramArrayOfint == null) {
/* 127 */       throw new IllegalArgumentException("group array cannot be null");
/*     */     }
/* 129 */     if (paramArrayOfint.length == 0) {
/* 130 */       throw new IllegalArgumentException("group array length cannot be 0");
/*     */     }
/* 132 */     if (paramArrayOfint.length % 2 != 0) {
/* 133 */       throw new IllegalArgumentException("group array must have even length");
/*     */     }
/* 135 */     double d = Math.log(10.0D);
/*     */     
/* 137 */     int i = 0;
/*     */     
/* 139 */     int[] arrayOfInt = new int[paramArrayOfint.length];
/* 140 */     for (byte b1 = 0; b1 < arrayOfInt.length; b1++) {
/* 141 */       arrayOfInt[b1] = paramArrayOfint[b1];
/* 142 */       int k = arrayOfInt[b1];
/* 143 */       if (k < 0) {
/* 144 */         i++;
/* 145 */         k = -k;
/*     */       } 
/* 147 */       i += (int)(Math.log(k) / d) + 1;
/*     */     } 
/*     */     
/* 150 */     this.ag = arrayOfInt;
/*     */     
/* 152 */     StringBuffer stringBuffer = new StringBuffer(i + arrayOfInt.length / 2 + arrayOfInt.length - 1);
/* 153 */     stringBuffer.append(arrayOfInt[0]);
/* 154 */     stringBuffer.append(":");
/* 155 */     stringBuffer.append(arrayOfInt[1]);
/*     */     
/* 157 */     for (byte b2 = 2; b2 < paramArrayOfint.length; b2 += 2) {
/* 158 */       stringBuffer.append(",");
/* 159 */       stringBuffer.append(paramArrayOfint[b2]);
/* 160 */       stringBuffer.append(":");
/* 161 */       stringBuffer.append(paramArrayOfint[b2 + 1]);
/*     */     } 
/*     */     
/* 164 */     this.iZ = stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int[] a(String paramString, int paramInt) {
/* 172 */     String str = paramString;
/* 173 */     int i = str.length();
/*     */     
/* 175 */     byte b1 = 1;
/* 176 */     byte b2 = 0;
/*     */     
/* 178 */     for (byte b3 = 0; b3 < i; b3++) {
/* 179 */       char c = str.charAt(b3);
/*     */       
/* 181 */       if (c == ',' && !b2) {
/* 182 */         b1++;
/* 183 */       } else if (c == '(') {
/* 184 */         b2++;
/* 185 */       } else if (c == ')') {
/* 186 */         b2--;
/*     */       } 
/*     */     } 
/* 189 */     if (b2 != 0) {
/* 190 */       throw new g("round brackets do not balance");
/*     */     }
/* 192 */     int[] arrayOfInt = new int[2 * b1];
/* 193 */     int k = 0;
/* 194 */     byte b4 = 0;
/* 195 */     byte b = -1;
/*     */     
/* 197 */     o o = new o();
/* 198 */     f f = new f();
/* 199 */     f.gs();
/*     */     
/* 201 */     for (byte b5 = 0; b5 <= i; b5++) {
/* 202 */       char c = ' ';
/* 203 */       if (b5 < i) c = str.charAt(b5);
/*     */       
/* 205 */       if (b5 == i || (c == ',' && b2 == 0)) {
/*     */         
/* 207 */         if (b == -1) {
/* 208 */           c c1 = a(str, o, paramInt, k, b5);
/* 209 */           arrayOfInt[b4] = (int)Math.round(c1.a(o, f));
/* 210 */           arrayOfInt[b4 + 1] = arrayOfInt[b4];
/* 211 */           b4 += 2;
/*     */         } else {
/*     */           
/* 214 */           c c1 = a(str, o, paramInt, k, b);
/* 215 */           arrayOfInt[b4++] = (int)Math.round(c1.a(o, f));
/*     */           
/* 217 */           c c2 = a(str, o, paramInt, b + 1, b5);
/* 218 */           arrayOfInt[b4++] = (int)Math.round(c2.a(o, f));
/*     */         } 
/*     */         
/* 221 */         k = b5 + 1;
/* 222 */         b = -1;
/*     */       }
/* 224 */       else if (c == '(') {
/* 225 */         b2++;
/* 226 */       } else if (c == ')') {
/* 227 */         b2--;
/* 228 */       } else if (c == ':') {
/* 229 */         b = b5;
/*     */       } 
/*     */     } 
/* 232 */     return arrayOfInt;
/*     */   }
/*     */   
/*     */   private static c a(String paramString, o paramo, int paramInt1, int paramInt2, int paramInt3) {
/* 236 */     c c = null;
/*     */     
/*     */     try {
/* 239 */       c = e.a(paramString.substring(paramInt2, paramInt3));
/* 240 */     } catch (d d) {
/* 241 */       throw new g("error parsing expression", paramInt2, paramInt3, d);
/*     */     } 
/*     */     
/* 244 */     if (c == null) {
/* 245 */       throw new g("control substring is empty", paramInt2, paramInt3);
/*     */     }
/* 247 */     String[] arrayOfString = c.getVariableNames();
/*     */     
/* 249 */     if (arrayOfString.length > 1)
/* 250 */       throw new g("too many variables", paramInt2, paramInt3); 
/* 251 */     if (arrayOfString.length == 1) {
/* 252 */       paramo.a(arrayOfString[0], paramInt1);
/*     */     }
/* 254 */     return c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String dB() {
/* 261 */     return this.iZ;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int aH() {
/* 268 */     return this.ag.length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int V(int paramInt) {
/* 278 */     if (paramInt < 0 || paramInt >= this.ag.length) {
/* 279 */       throw new IllegalArgumentException("required: (index >= 0 && index < group.length) but: (index = " + paramInt + ", group.length = " + this.ag.length + ")");
/*     */     }
/* 281 */     return this.ag[paramInt];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int aI() {
/* 288 */     int i = 0;
/*     */     
/* 290 */     for (byte b = 0; b < this.ag.length; b += 2) {
/* 291 */       int k = this.ag[b] - this.ag[b + 1];
/* 292 */       if (k < 0) k = -k; 
/* 293 */       i += k + 1;
/*     */     } 
/*     */     
/* 296 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void e(int[] paramArrayOfint) {
/* 306 */     if (paramArrayOfint == null) {
/* 307 */       throw new IllegalArgumentException("specified array cannot be null");
/*     */     }
/* 309 */     if (paramArrayOfint.length < this.ag.length) {
/* 310 */       throw new IllegalArgumentException("specified array is too small");
/*     */     }
/* 312 */     for (byte b = 0; b < this.ag.length; b++) {
/* 313 */       paramArrayOfint[b] = this.ag[b];
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/* 321 */     return (this.gH < this.ag.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int next() {
/* 328 */     int i = this.ag[this.gH];
/* 329 */     int k = this.ag[this.gH + 1];
/*     */     
/* 331 */     if (i <= k) {
/* 332 */       i += this.gI;
/*     */       
/* 334 */       if (i >= k) {
/* 335 */         this.gI = 0;
/* 336 */         this.gH += 2;
/*     */       } else {
/*     */         
/* 339 */         this.gI++;
/*     */       } 
/*     */     } else {
/* 342 */       i -= this.gI;
/*     */       
/* 344 */       if (i <= k) {
/* 345 */         this.gI = 0;
/* 346 */         this.gH += 2;
/*     */       } else {
/*     */         
/* 349 */         this.gI++;
/*     */       } 
/*     */     } 
/* 352 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void j(int paramInt1, int paramInt2) {
/* 361 */     if (paramInt1 < 0) throw new IllegalArgumentException("index_i >= 0 required"); 
/* 362 */     if (paramInt1 % 2 == 1) throw new IllegalArgumentException("index_i must be an even number"); 
/* 363 */     if (paramInt2 < 0) throw new IllegalArgumentException("count_j >= 0 required");
/*     */     
/* 365 */     this.gH = paramInt1;
/* 366 */     this.gI = paramInt2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int aJ() {
/* 373 */     return this.gH;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int aK() {
/* 380 */     return this.gI;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 387 */     this.gH = 0;
/* 388 */     this.gI = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInRange(int paramInt1, int paramInt2) {
/* 396 */     for (byte b = 0; b < this.ag.length; b++) {
/* 397 */       if (this.ag[b] < paramInt1 || this.ag[b] >= paramInt2)
/* 398 */         return false; 
/* 399 */     }  return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\a\j.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */