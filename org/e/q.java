/*     */ package org.e;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.util.Collection;
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
/*     */ public class q
/*     */ {
/*     */   private static final int iM = 200;
/*     */   private boolean comma;
/*     */   protected char v;
/*     */   private final i[] a;
/*     */   private int top;
/*     */   protected Appendable e;
/*     */   
/*     */   public q(Appendable paramAppendable) {
/*  99 */     this.comma = false;
/* 100 */     this.v = 'i';
/* 101 */     this.a = new i[200];
/* 102 */     this.top = 0;
/* 103 */     this.e = paramAppendable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private q a(String paramString) throws g {
/* 113 */     if (paramString == null) {
/* 114 */       throw new g("Null pointer");
/*     */     }
/* 116 */     if (this.v == 'o' || this.v == 'a') {
/*     */       try {
/* 118 */         if (this.comma && this.v == 'a') {
/* 119 */           this.e.append(',');
/*     */         }
/* 121 */         this.e.append(paramString);
/* 122 */       } catch (IOException iOException) {
/*     */ 
/*     */ 
/*     */         
/* 126 */         throw new g(iOException);
/*     */       } 
/* 128 */       if (this.v == 'o') {
/* 129 */         this.v = 'k';
/*     */       }
/* 131 */       this.comma = true;
/* 132 */       return this;
/*     */     } 
/* 134 */     throw new g("Value out of sequence.");
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
/*     */   public q a() throws g {
/* 147 */     if (this.v == 'i' || this.v == 'o' || this.v == 'a') {
/* 148 */       h(null);
/* 149 */       a("[");
/* 150 */       this.comma = false;
/* 151 */       return this;
/*     */     } 
/* 153 */     throw new g("Misplaced array.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private q a(char paramChar1, char paramChar2) throws g {
/* 164 */     if (this.v != paramChar1) {
/* 165 */       throw new g((paramChar1 == 'a') ? "Misplaced endArray." : "Misplaced endObject.");
/*     */     }
/*     */ 
/*     */     
/* 169 */     b(paramChar1);
/*     */     try {
/* 171 */       this.e.append(paramChar2);
/* 172 */     } catch (IOException iOException) {
/*     */ 
/*     */ 
/*     */       
/* 176 */       throw new g(iOException);
/*     */     } 
/* 178 */     this.comma = true;
/* 179 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public q b() throws g {
/* 189 */     return a('a', ']');
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public q c() throws g {
/* 199 */     return a('k', '}');
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
/*     */   public q b(String paramString) throws g {
/* 211 */     if (paramString == null) {
/* 212 */       throw new g("Null key.");
/*     */     }
/* 214 */     if (this.v == 'k') {
/*     */       try {
/* 216 */         i i1 = this.a[this.top - 1];
/*     */         
/* 218 */         if (i1.has(paramString)) {
/* 219 */           throw new g("Duplicate key \"" + paramString + "\"");
/*     */         }
/* 221 */         i1.b(paramString, true);
/* 222 */         if (this.comma) {
/* 223 */           this.e.append(',');
/*     */         }
/* 225 */         this.e.append(i.quote(paramString));
/* 226 */         this.e.append(':');
/* 227 */         this.comma = false;
/* 228 */         this.v = 'o';
/* 229 */         return this;
/* 230 */       } catch (IOException iOException) {
/*     */ 
/*     */ 
/*     */         
/* 234 */         throw new g(iOException);
/*     */       } 
/*     */     }
/* 237 */     throw new g("Misplaced key.");
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
/*     */   public q d() throws g {
/* 251 */     if (this.v == 'i') {
/* 252 */       this.v = 'o';
/*     */     }
/* 254 */     if (this.v == 'o' || this.v == 'a') {
/* 255 */       a("{");
/* 256 */       h(new i());
/* 257 */       this.comma = false;
/* 258 */       return this;
/*     */     } 
/* 260 */     throw new g("Misplaced object.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(char paramChar) throws g {
/* 271 */     if (this.top <= 0) {
/* 272 */       throw new g("Nesting error.");
/*     */     }
/* 274 */     byte b = (this.a[this.top - 1] == null) ? 97 : 107;
/* 275 */     if (b != paramChar) {
/* 276 */       throw new g("Nesting error.");
/*     */     }
/* 278 */     this.top--;
/* 279 */     this.v = (this.top == 0) ? 'd' : ((this.a[this.top - 1] == null) ? 'a' : 'k');
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
/*     */   private void h(i parami) throws g {
/* 292 */     if (this.top >= 200) {
/* 293 */       throw new g("Nesting too deep.");
/*     */     }
/* 295 */     this.a[this.top] = parami;
/* 296 */     this.v = (parami == null) ? 'a' : 'k';
/* 297 */     this.top++;
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
/*     */   public static String m(Object paramObject) throws g {
/* 325 */     if (paramObject == null || paramObject.equals(null)) {
/* 326 */       return "null";
/*     */     }
/* 328 */     if (paramObject instanceof n) {
/*     */       String str;
/*     */       try {
/* 331 */         str = ((n)paramObject).eQ();
/* 332 */       } catch (Exception exception) {
/* 333 */         throw new g(exception);
/*     */       } 
/* 335 */       if (str != null) {
/* 336 */         return str;
/*     */       }
/* 338 */       throw new g("Bad value from toJSONString: " + str);
/*     */     } 
/* 340 */     if (paramObject instanceof Number) {
/*     */       
/* 342 */       String str = i.b((Number)paramObject);
/* 343 */       if (i.E.matcher(str).matches())
/*     */       {
/* 345 */         return str;
/*     */       }
/*     */ 
/*     */       
/* 349 */       return i.quote(str);
/*     */     } 
/* 351 */     if (paramObject instanceof Boolean || paramObject instanceof i || paramObject instanceof f)
/*     */     {
/* 353 */       return paramObject.toString();
/*     */     }
/* 355 */     if (paramObject instanceof Map) {
/* 356 */       Map<?, ?> map = (Map)paramObject;
/* 357 */       return (new i(map)).toString();
/*     */     } 
/* 359 */     if (paramObject instanceof Collection) {
/* 360 */       Collection<?> collection = (Collection)paramObject;
/* 361 */       return (new f(collection)).toString();
/*     */     } 
/* 363 */     if (paramObject.getClass().isArray()) {
/* 364 */       return (new f(paramObject)).toString();
/*     */     }
/* 366 */     if (paramObject instanceof Enum) {
/* 367 */       return i.quote(((Enum)paramObject).name());
/*     */     }
/* 369 */     return i.quote(paramObject.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public q a(boolean paramBoolean) throws g {
/* 380 */     return a(paramBoolean ? "true" : "false");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public q a(double paramDouble) throws g {
/* 390 */     return a(Double.valueOf(paramDouble));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public q a(long paramLong) throws g {
/* 400 */     return a(Long.toString(paramLong));
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
/*     */   public q a(Object paramObject) throws g {
/* 412 */     return a(m(paramObject));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\e\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */