/*     */ package com.google.a.n;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.w;
/*     */ import com.google.a.b.y;
/*     */ import com.google.a.d.bW;
/*     */ import com.google.a.d.bj;
/*     */ import java.lang.reflect.GenericArrayType;
/*     */ import java.lang.reflect.GenericDeclaration;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Type;
/*     */ import java.lang.reflect.TypeVariable;
/*     */ import java.lang.reflect.WildcardType;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ public final class k
/*     */ {
/*     */   private final b a;
/*     */   
/*     */   public k() {
/*  60 */     this.a = new b();
/*     */   }
/*     */   
/*     */   private k(b paramb) {
/*  64 */     this.a = paramb;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static k a(Type paramType) {
/*  75 */     return (new k()).a((Map<c, ? extends Type>)a.a(paramType));
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
/*     */   static k b(Type paramType) {
/*  90 */     Type type = d.a.b(paramType);
/*  91 */     return (new k()).a((Map<c, ? extends Type>)a.a(type));
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
/*     */   public k a(Type paramType1, Type paramType2) {
/* 114 */     HashMap<c, Type> hashMap = bW.a();
/* 115 */     a(hashMap, (Type)D.checkNotNull(paramType1), (Type)D.checkNotNull(paramType2));
/* 116 */     return a(hashMap);
/*     */   }
/*     */ 
/*     */   
/*     */   k a(Map<c, ? extends Type> paramMap) {
/* 121 */     return new k(this.a.a(paramMap));
/*     */   }
/*     */ 
/*     */   
/*     */   private static void a(Map<c, Type> paramMap, Type paramType1, Type paramType2) {
/* 126 */     if (paramType1.equals(paramType2)) {
/*     */       return;
/*     */     }
/* 129 */     (new n(paramMap, paramType2)
/*     */       {
/*     */         void a(TypeVariable<?> param1TypeVariable) {
/* 132 */           this.ag.put(new k.c(param1TypeVariable), this.a);
/*     */         }
/*     */ 
/*     */         
/*     */         void a(WildcardType param1WildcardType) {
/* 137 */           if (!(this.a instanceof WildcardType)) {
/*     */             return;
/*     */           }
/* 140 */           WildcardType wildcardType = (WildcardType)this.a;
/* 141 */           Type[] arrayOfType1 = param1WildcardType.getUpperBounds();
/* 142 */           Type[] arrayOfType2 = wildcardType.getUpperBounds();
/* 143 */           Type[] arrayOfType3 = param1WildcardType.getLowerBounds();
/* 144 */           Type[] arrayOfType4 = wildcardType.getLowerBounds();
/* 145 */           D.a((arrayOfType1.length == arrayOfType2.length && arrayOfType3.length == arrayOfType4.length), "Incompatible type: %s vs. %s", param1WildcardType, this.a);
/*     */ 
/*     */           
/*     */           byte b;
/*     */ 
/*     */           
/* 151 */           for (b = 0; b < arrayOfType1.length; b++) {
/* 152 */             k.b(this.ag, arrayOfType1[b], arrayOfType2[b]);
/*     */           }
/* 154 */           for (b = 0; b < arrayOfType3.length; b++) {
/* 155 */             k.b(this.ag, arrayOfType3[b], arrayOfType4[b]);
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         void a(ParameterizedType param1ParameterizedType) {
/* 161 */           if (this.a instanceof WildcardType) {
/*     */             return;
/*     */           }
/* 164 */           ParameterizedType parameterizedType = (ParameterizedType)k.f(ParameterizedType.class, this.a);
/* 165 */           if (param1ParameterizedType.getOwnerType() != null && parameterizedType
/* 166 */             .getOwnerType() != null) {
/* 167 */             k.b(this.ag, param1ParameterizedType
/* 168 */                 .getOwnerType(), parameterizedType.getOwnerType());
/*     */           }
/* 170 */           D.a(param1ParameterizedType
/* 171 */               .getRawType().equals(parameterizedType.getRawType()), "Inconsistent raw type: %s vs. %s", param1ParameterizedType, this.a);
/*     */ 
/*     */ 
/*     */           
/* 175 */           Type[] arrayOfType1 = param1ParameterizedType.getActualTypeArguments();
/* 176 */           Type[] arrayOfType2 = parameterizedType.getActualTypeArguments();
/* 177 */           D.a((arrayOfType1.length == arrayOfType2.length), "%s not compatible with %s", param1ParameterizedType, parameterizedType);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 182 */           for (byte b = 0; b < arrayOfType1.length; b++) {
/* 183 */             k.b(this.ag, arrayOfType1[b], arrayOfType2[b]);
/*     */           }
/*     */         }
/*     */ 
/*     */         
/*     */         void a(GenericArrayType param1GenericArrayType) {
/* 189 */           if (this.a instanceof WildcardType) {
/*     */             return;
/*     */           }
/* 192 */           Type type = o.g(this.a);
/* 193 */           D.a((type != null), "%s is not an array type.", this.a);
/* 194 */           k.b(this.ag, param1GenericArrayType.getGenericComponentType(), type);
/*     */         }
/*     */ 
/*     */         
/*     */         void a(Class<?> param1Class) {
/* 199 */           if (this.a instanceof WildcardType) {
/*     */             return;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 205 */           String str1 = String.valueOf(param1Class), str2 = String.valueOf(this.a); throw new IllegalArgumentException((new StringBuilder(25 + String.valueOf(str1).length() + String.valueOf(str2).length())).append("No type mapping from ").append(str1).append(" to ").append(str2).toString());
/*     */         }
/* 207 */       }).a(new Type[] { paramType1 });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Type a(Type paramType) {
/* 215 */     D.checkNotNull(paramType);
/* 216 */     if (paramType instanceof TypeVariable)
/* 217 */       return this.a.a((TypeVariable)paramType); 
/* 218 */     if (paramType instanceof ParameterizedType)
/* 219 */       return a((ParameterizedType)paramType); 
/* 220 */     if (paramType instanceof GenericArrayType)
/* 221 */       return a((GenericArrayType)paramType); 
/* 222 */     if (paramType instanceof WildcardType) {
/* 223 */       return a((WildcardType)paramType);
/*     */     }
/*     */     
/* 226 */     return paramType;
/*     */   }
/*     */ 
/*     */   
/*     */   Type[] a(Type[] paramArrayOfType) {
/* 231 */     for (byte b1 = 0; b1 < paramArrayOfType.length; b1++) {
/* 232 */       paramArrayOfType[b1] = a(paramArrayOfType[b1]);
/*     */     }
/* 234 */     return paramArrayOfType;
/*     */   }
/*     */   
/*     */   private Type[] b(Type[] paramArrayOfType) {
/* 238 */     Type[] arrayOfType = new Type[paramArrayOfType.length];
/* 239 */     for (byte b1 = 0; b1 < paramArrayOfType.length; b1++) {
/* 240 */       arrayOfType[b1] = a(paramArrayOfType[b1]);
/*     */     }
/* 242 */     return arrayOfType;
/*     */   }
/*     */   
/*     */   private WildcardType a(WildcardType paramWildcardType) {
/* 246 */     Type[] arrayOfType1 = paramWildcardType.getLowerBounds();
/* 247 */     Type[] arrayOfType2 = paramWildcardType.getUpperBounds();
/* 248 */     return new o.h(b(arrayOfType1), b(arrayOfType2));
/*     */   }
/*     */   
/*     */   private Type a(GenericArrayType paramGenericArrayType) {
/* 252 */     Type type1 = paramGenericArrayType.getGenericComponentType();
/* 253 */     Type type2 = a(type1);
/* 254 */     return o.f(type2);
/*     */   }
/*     */   
/*     */   private ParameterizedType a(ParameterizedType paramParameterizedType) {
/* 258 */     Type type1 = paramParameterizedType.getOwnerType();
/* 259 */     Type type2 = (type1 == null) ? null : a(type1);
/* 260 */     Type type3 = a(paramParameterizedType.getRawType());
/*     */     
/* 262 */     Type[] arrayOfType1 = paramParameterizedType.getActualTypeArguments();
/* 263 */     Type[] arrayOfType2 = b(arrayOfType1);
/* 264 */     return o.a(type2, (Class)type3, arrayOfType2);
/*     */   }
/*     */ 
/*     */   
/*     */   private static <T> T e(Class<T> paramClass, Object paramObject) {
/*     */     try {
/* 270 */       return paramClass.cast(paramObject);
/* 271 */     } catch (ClassCastException classCastException) {
/* 272 */       String str1 = String.valueOf(paramObject), str2 = paramClass.getSimpleName(); throw new IllegalArgumentException((new StringBuilder(10 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(" is not a ").append(str2).toString());
/*     */     } 
/*     */   }
/*     */   
/*     */   private static class b
/*     */   {
/*     */     private final bj<k.c, Type> j;
/*     */     
/*     */     b() {
/* 281 */       this.j = bj.f();
/*     */     }
/*     */     
/*     */     private b(bj<k.c, Type> param1bj) {
/* 285 */       this.j = param1bj;
/*     */     }
/*     */ 
/*     */     
/*     */     final b a(Map<k.c, ? extends Type> param1Map) {
/* 290 */       bj.a a = bj.a();
/* 291 */       a.a((Map)this.j);
/* 292 */       for (Map.Entry<k.c, ? extends Type> entry : param1Map.entrySet()) {
/* 293 */         k.c c = (k.c)entry.getKey();
/* 294 */         Type type = (Type)entry.getValue();
/* 295 */         D.a(!c.a(type), "Type variable %s bound to itself", c);
/* 296 */         a.a(c, type);
/*     */       } 
/* 298 */       return new b(a.e());
/*     */     }
/*     */     
/*     */     final Type a(TypeVariable<?> param1TypeVariable) {
/* 302 */       b b1 = this;
/* 303 */       b b2 = new b(this, param1TypeVariable, b1)
/*     */         {
/*     */           public Type a(TypeVariable<?> param2TypeVariable, k.b param2b)
/*     */           {
/* 307 */             if (param2TypeVariable.getGenericDeclaration().equals(this.b.getGenericDeclaration())) {
/* 308 */               return param2TypeVariable;
/*     */             }
/* 310 */             return this.b.a(param2TypeVariable, param2b);
/*     */           }
/*     */         };
/* 313 */       return a(param1TypeVariable, b2);
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
/*     */     Type a(TypeVariable<?> param1TypeVariable, b param1b) {
/* 325 */       Type type = (Type)this.j.get(new k.c(param1TypeVariable));
/* 326 */       if (type == null) {
/* 327 */         Type[] arrayOfType1 = param1TypeVariable.getBounds();
/* 328 */         if (arrayOfType1.length == 0) {
/* 329 */           return param1TypeVariable;
/*     */         }
/* 331 */         Type[] arrayOfType2 = k.a(new k(param1b), arrayOfType1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 360 */         if (o.d.bi && 
/* 361 */           Arrays.equals((Object[])arrayOfType1, (Object[])arrayOfType2)) {
/* 362 */           return param1TypeVariable;
/*     */         }
/* 364 */         return o.a((GenericDeclaration)param1TypeVariable
/* 365 */             .getGenericDeclaration(), param1TypeVariable.getName(), arrayOfType2);
/*     */       } 
/*     */       
/* 368 */       return (new k(param1b)).a(type);
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class a
/*     */     extends n {
/* 374 */     private final Map<k.c, Type> ah = bW.a();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     static bj<k.c, Type> a(Type param1Type) {
/* 381 */       D.checkNotNull(param1Type);
/* 382 */       a a1 = new a();
/* 383 */       a1.a(new Type[] { param1Type });
/* 384 */       return bj.a(a1.ah);
/*     */     }
/*     */ 
/*     */     
/*     */     void a(Class<?> param1Class) {
/* 389 */       a(new Type[] { param1Class.getGenericSuperclass() });
/* 390 */       a(param1Class.getGenericInterfaces());
/*     */     }
/*     */ 
/*     */     
/*     */     void a(ParameterizedType param1ParameterizedType) {
/* 395 */       Class clazz = (Class)param1ParameterizedType.getRawType();
/* 396 */       TypeVariable[] arrayOfTypeVariable = clazz.getTypeParameters();
/* 397 */       Type[] arrayOfType = param1ParameterizedType.getActualTypeArguments();
/* 398 */       D.ab((arrayOfTypeVariable.length == arrayOfType.length));
/* 399 */       for (byte b = 0; b < arrayOfTypeVariable.length; b++) {
/* 400 */         a(new k.c(arrayOfTypeVariable[b]), arrayOfType[b]);
/*     */       }
/* 402 */       a(new Type[] { clazz });
/* 403 */       a(new Type[] { param1ParameterizedType.getOwnerType() });
/*     */     }
/*     */ 
/*     */     
/*     */     void a(TypeVariable<?> param1TypeVariable) {
/* 408 */       a(param1TypeVariable.getBounds());
/*     */     }
/*     */ 
/*     */     
/*     */     void a(WildcardType param1WildcardType) {
/* 413 */       a(param1WildcardType.getUpperBounds());
/*     */     }
/*     */     
/*     */     private void a(k.c param1c, Type param1Type) {
/* 417 */       if (this.ah.containsKey(param1c)) {
/*     */         return;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 426 */       for (Type type = param1Type; type != null; type = this.ah.get(k.c.a(type))) {
/* 427 */         if (param1c.a(type)) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 432 */           for (Type type1 = param1Type; type1 != null; type1 = this.ah.remove(k.c.a(type1)));
/*     */           return;
/*     */         } 
/*     */       } 
/* 436 */       this.ah.put(param1c, param1Type);
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
/*     */   private static class d
/*     */   {
/* 449 */     static final d a = new d();
/*     */     
/*     */     private final AtomicInteger i;
/*     */     
/*     */     private d() {
/* 454 */       this(new AtomicInteger());
/*     */     }
/*     */     
/*     */     private d(AtomicInteger param1AtomicInteger) {
/* 458 */       this.i = param1AtomicInteger;
/*     */     }
/*     */     
/*     */     final Type b(Type param1Type) {
/* 462 */       D.checkNotNull(param1Type);
/* 463 */       if (param1Type instanceof Class) {
/* 464 */         return param1Type;
/*     */       }
/* 466 */       if (param1Type instanceof TypeVariable) {
/* 467 */         return param1Type;
/*     */       }
/* 469 */       if (param1Type instanceof GenericArrayType) {
/* 470 */         GenericArrayType genericArrayType = (GenericArrayType)param1Type;
/* 471 */         return o.f(
/* 472 */             a().b(genericArrayType.getGenericComponentType()));
/*     */       } 
/* 474 */       if (param1Type instanceof ParameterizedType) {
/* 475 */         ParameterizedType parameterizedType = (ParameterizedType)param1Type;
/* 476 */         Class<?> clazz = (Class)parameterizedType.getRawType();
/* 477 */         TypeVariable[] arrayOfTypeVariable = clazz.getTypeParameters();
/* 478 */         Type[] arrayOfType = parameterizedType.getActualTypeArguments();
/* 479 */         for (byte b = 0; b < arrayOfType.length; b++) {
/* 480 */           arrayOfType[b] = a(arrayOfTypeVariable[b]).b(arrayOfType[b]);
/*     */         }
/* 482 */         return o.a(
/* 483 */             a().c(parameterizedType.getOwnerType()), clazz, arrayOfType);
/*     */       } 
/*     */ 
/*     */       
/* 487 */       if (param1Type instanceof WildcardType) {
/* 488 */         WildcardType wildcardType = (WildcardType)param1Type;
/* 489 */         Type[] arrayOfType = wildcardType.getLowerBounds();
/* 490 */         if (arrayOfType.length == 0) {
/* 491 */           return a(wildcardType.getUpperBounds());
/*     */         }
/*     */         
/* 494 */         return param1Type;
/*     */       } 
/*     */       
/* 497 */       throw new AssertionError("must have been one of the known types");
/*     */     }
/*     */ 
/*     */     
/*     */     TypeVariable<?> a(Type[] param1ArrayOfType) {
/* 502 */       int i = this.i.incrementAndGet(); String str2 = w.a('&').join((Object[])param1ArrayOfType), str1 = (new StringBuilder(33 + String.valueOf(str2).length())).append("capture#").append(i).append("-of ? extends ").append(str2).toString();
/* 503 */       return o.a(d.class, str1, param1ArrayOfType);
/*     */     }
/*     */     
/*     */     private d a(TypeVariable<?> param1TypeVariable) {
/* 507 */       return new d(this, this.i, param1TypeVariable)
/*     */         {
/*     */           TypeVariable<?> a(Type[] param2ArrayOfType) {
/* 510 */             LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList((Object[])param2ArrayOfType));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 517 */             linkedHashSet.addAll(Arrays.asList(this.d.getBounds()));
/* 518 */             if (linkedHashSet.size() > 1) {
/* 519 */               linkedHashSet.remove(Object.class);
/*     */             }
/* 521 */             return super.a((Type[])linkedHashSet.toArray((Object[])new Type[0]));
/*     */           }
/*     */         };
/*     */     }
/*     */     
/*     */     private d a() {
/* 527 */       return new d(this.i);
/*     */     }
/*     */     
/*     */     private Type c(Type param1Type) {
/* 531 */       if (param1Type == null) {
/* 532 */         return null;
/*     */       }
/* 534 */       return b(param1Type);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class c
/*     */   {
/*     */     private final TypeVariable<?> c;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     c(TypeVariable<?> param1TypeVariable) {
/* 555 */       this.c = (TypeVariable)D.checkNotNull(param1TypeVariable);
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 560 */       return y.a(new Object[] { this.c.getGenericDeclaration(), this.c.getName() });
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 565 */       if (param1Object instanceof c) {
/* 566 */         c c1 = (c)param1Object;
/* 567 */         return a(c1.c);
/*     */       } 
/* 569 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 575 */       return this.c.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     static c a(Type param1Type) {
/* 580 */       if (param1Type instanceof TypeVariable) {
/* 581 */         return new c((TypeVariable)param1Type);
/*     */       }
/* 583 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean a(Type param1Type) {
/* 592 */       if (param1Type instanceof TypeVariable) {
/* 593 */         return a((TypeVariable)param1Type);
/*     */       }
/* 595 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     private boolean a(TypeVariable<?> param1TypeVariable) {
/* 600 */       return (this.c.getGenericDeclaration().equals(param1TypeVariable.getGenericDeclaration()) && this.c
/* 601 */         .getName().equals(param1TypeVariable.getName()));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\n\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */