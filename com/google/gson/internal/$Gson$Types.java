/*     */ package com.google.gson.internal;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Array;
/*     */ import java.lang.reflect.GenericArrayType;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Type;
/*     */ import java.lang.reflect.TypeVariable;
/*     */ import java.lang.reflect.WildcardType;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.Properties;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class $Gson$Types
/*     */ {
/*  40 */   static final Type[] EMPTY_TYPE_ARRAY = new Type[0];
/*     */   
/*     */   private $Gson$Types() {
/*  43 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ParameterizedType newParameterizedTypeWithOwner(Type paramType1, Type paramType2, Type... paramVarArgs) {
/*  54 */     return new ParameterizedTypeImpl(paramType1, paramType2, paramVarArgs);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static GenericArrayType arrayOf(Type paramType) {
/*  64 */     return new GenericArrayTypeImpl(paramType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WildcardType subtypeOf(Type paramType) {
/*     */     Type[] arrayOfType;
/*  75 */     if (paramType instanceof WildcardType) {
/*  76 */       arrayOfType = ((WildcardType)paramType).getUpperBounds();
/*     */     } else {
/*  78 */       arrayOfType = new Type[] { paramType };
/*     */     } 
/*  80 */     return new WildcardTypeImpl(arrayOfType, EMPTY_TYPE_ARRAY);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static WildcardType supertypeOf(Type paramType) {
/*     */     Type[] arrayOfType;
/*  90 */     if (paramType instanceof WildcardType) {
/*  91 */       arrayOfType = ((WildcardType)paramType).getLowerBounds();
/*     */     } else {
/*  93 */       arrayOfType = new Type[] { paramType };
/*     */     } 
/*  95 */     return new WildcardTypeImpl(new Type[] { Object.class }, arrayOfType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Type canonicalize(Type paramType) {
/* 104 */     if (paramType instanceof Class) {
/* 105 */       Class clazz = (Class)paramType;
/* 106 */       return clazz.isArray() ? new GenericArrayTypeImpl(canonicalize(clazz.getComponentType())) : clazz;
/*     */     } 
/* 108 */     if (paramType instanceof ParameterizedType) {
/* 109 */       ParameterizedType parameterizedType = (ParameterizedType)paramType;
/* 110 */       return new ParameterizedTypeImpl(parameterizedType.getOwnerType(), parameterizedType
/* 111 */           .getRawType(), parameterizedType.getActualTypeArguments());
/*     */     } 
/* 113 */     if (paramType instanceof GenericArrayType) {
/* 114 */       GenericArrayType genericArrayType = (GenericArrayType)paramType;
/* 115 */       return new GenericArrayTypeImpl(genericArrayType.getGenericComponentType());
/*     */     } 
/* 117 */     if (paramType instanceof WildcardType) {
/* 118 */       WildcardType wildcardType = (WildcardType)paramType;
/* 119 */       return new WildcardTypeImpl(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
/*     */     } 
/*     */ 
/*     */     
/* 123 */     return paramType;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Class<?> getRawType(Type paramType) {
/* 128 */     if (paramType instanceof Class)
/*     */     {
/* 130 */       return (Class)paramType;
/*     */     }
/* 132 */     if (paramType instanceof ParameterizedType) {
/* 133 */       ParameterizedType parameterizedType = (ParameterizedType)paramType;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 138 */       Type type = parameterizedType.getRawType();
/* 139 */       $Gson$Preconditions.checkArgument(type instanceof Class);
/* 140 */       return (Class)type;
/*     */     } 
/* 142 */     if (paramType instanceof GenericArrayType) {
/* 143 */       Type type = ((GenericArrayType)paramType).getGenericComponentType();
/* 144 */       return Array.newInstance(getRawType(type), 0).getClass();
/*     */     } 
/* 146 */     if (paramType instanceof TypeVariable)
/*     */     {
/*     */       
/* 149 */       return Object.class;
/*     */     }
/* 151 */     if (paramType instanceof WildcardType) {
/* 152 */       return getRawType(((WildcardType)paramType).getUpperBounds()[0]);
/*     */     }
/*     */     
/* 155 */     String str = (paramType == null) ? "null" : paramType.getClass().getName();
/* 156 */     throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + paramType + "> is of type " + str);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean equal(Object paramObject1, Object paramObject2) {
/* 162 */     return (paramObject1 == paramObject2 || (paramObject1 != null && paramObject1.equals(paramObject2)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean equals(Type paramType1, Type paramType2) {
/* 169 */     if (paramType1 == paramType2)
/*     */     {
/* 171 */       return true;
/*     */     }
/* 173 */     if (paramType1 instanceof Class)
/*     */     {
/* 175 */       return paramType1.equals(paramType2);
/*     */     }
/* 177 */     if (paramType1 instanceof ParameterizedType) {
/* 178 */       if (!(paramType2 instanceof ParameterizedType)) {
/* 179 */         return false;
/*     */       }
/*     */ 
/*     */       
/* 183 */       ParameterizedType parameterizedType1 = (ParameterizedType)paramType1;
/* 184 */       ParameterizedType parameterizedType2 = (ParameterizedType)paramType2;
/* 185 */       return (equal(parameterizedType1.getOwnerType(), parameterizedType2.getOwnerType()) && parameterizedType1
/* 186 */         .getRawType().equals(parameterizedType2.getRawType()) && 
/* 187 */         Arrays.equals((Object[])parameterizedType1.getActualTypeArguments(), (Object[])parameterizedType2.getActualTypeArguments()));
/*     */     } 
/* 189 */     if (paramType1 instanceof GenericArrayType) {
/* 190 */       if (!(paramType2 instanceof GenericArrayType)) {
/* 191 */         return false;
/*     */       }
/*     */       
/* 194 */       GenericArrayType genericArrayType1 = (GenericArrayType)paramType1;
/* 195 */       GenericArrayType genericArrayType2 = (GenericArrayType)paramType2;
/* 196 */       return equals(genericArrayType1.getGenericComponentType(), genericArrayType2.getGenericComponentType());
/*     */     } 
/* 198 */     if (paramType1 instanceof WildcardType) {
/* 199 */       if (!(paramType2 instanceof WildcardType)) {
/* 200 */         return false;
/*     */       }
/*     */       
/* 203 */       WildcardType wildcardType1 = (WildcardType)paramType1;
/* 204 */       WildcardType wildcardType2 = (WildcardType)paramType2;
/* 205 */       return (Arrays.equals((Object[])wildcardType1.getUpperBounds(), (Object[])wildcardType2.getUpperBounds()) && 
/* 206 */         Arrays.equals((Object[])wildcardType1.getLowerBounds(), (Object[])wildcardType2.getLowerBounds()));
/*     */     } 
/* 208 */     if (paramType1 instanceof TypeVariable) {
/* 209 */       if (!(paramType2 instanceof TypeVariable)) {
/* 210 */         return false;
/*     */       }
/* 212 */       TypeVariable typeVariable1 = (TypeVariable)paramType1;
/* 213 */       TypeVariable typeVariable2 = (TypeVariable)paramType2;
/* 214 */       return (typeVariable1.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable1
/* 215 */         .getName().equals(typeVariable2.getName()));
/*     */     } 
/*     */ 
/*     */     
/* 219 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   static int hashCodeOrZero(Object paramObject) {
/* 224 */     return (paramObject != null) ? paramObject.hashCode() : 0;
/*     */   }
/*     */   
/*     */   public static String typeToString(Type paramType) {
/* 228 */     return (paramType instanceof Class) ? ((Class)paramType).getName() : paramType.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Type getGenericSupertype(Type paramType, Class<?> paramClass1, Class<?> paramClass2) {
/* 237 */     if (paramClass2 == paramClass1) {
/* 238 */       return paramType;
/*     */     }
/*     */ 
/*     */     
/* 242 */     if (paramClass2.isInterface()) {
/* 243 */       Class[] arrayOfClass = paramClass1.getInterfaces(); byte b; int i;
/* 244 */       for (b = 0, i = arrayOfClass.length; b < i; b++) {
/* 245 */         if (arrayOfClass[b] == paramClass2)
/* 246 */           return paramClass1.getGenericInterfaces()[b]; 
/* 247 */         if (paramClass2.isAssignableFrom(arrayOfClass[b])) {
/* 248 */           return getGenericSupertype(paramClass1.getGenericInterfaces()[b], arrayOfClass[b], paramClass2);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 254 */     if (!paramClass1.isInterface()) {
/* 255 */       while (paramClass1 != Object.class) {
/* 256 */         Class<?> clazz = paramClass1.getSuperclass();
/* 257 */         if (clazz == paramClass2)
/* 258 */           return paramClass1.getGenericSuperclass(); 
/* 259 */         if (paramClass2.isAssignableFrom(clazz)) {
/* 260 */           return getGenericSupertype(paramClass1.getGenericSuperclass(), clazz, paramClass2);
/*     */         }
/* 262 */         paramClass1 = clazz;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 267 */     return paramClass2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Type getSupertype(Type paramType, Class<?> paramClass1, Class<?> paramClass2) {
/* 278 */     if (paramType instanceof WildcardType)
/*     */     {
/* 280 */       paramType = ((WildcardType)paramType).getUpperBounds()[0];
/*     */     }
/* 282 */     $Gson$Preconditions.checkArgument(paramClass2.isAssignableFrom(paramClass1));
/* 283 */     return resolve(paramType, paramClass1, 
/* 284 */         getGenericSupertype(paramType, paramClass1, paramClass2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Type getArrayComponentType(Type paramType) {
/* 292 */     return (paramType instanceof GenericArrayType) ? ((GenericArrayType)paramType)
/* 293 */       .getGenericComponentType() : ((Class)paramType)
/* 294 */       .getComponentType();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Type getCollectionElementType(Type paramType, Class<?> paramClass) {
/* 302 */     Type type = getSupertype(paramType, paramClass, Collection.class);
/*     */     
/* 304 */     if (type instanceof WildcardType) {
/* 305 */       type = ((WildcardType)type).getUpperBounds()[0];
/*     */     }
/* 307 */     if (type instanceof ParameterizedType) {
/* 308 */       return ((ParameterizedType)type).getActualTypeArguments()[0];
/*     */     }
/* 310 */     return Object.class;
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
/*     */   public static Type[] getMapKeyAndValueTypes(Type paramType, Class<?> paramClass) {
/* 323 */     if (paramType == Properties.class) {
/* 324 */       return new Type[] { String.class, String.class };
/*     */     }
/*     */     
/* 327 */     Type type = getSupertype(paramType, paramClass, Map.class);
/*     */     
/* 329 */     if (type instanceof ParameterizedType) {
/* 330 */       ParameterizedType parameterizedType = (ParameterizedType)type;
/* 331 */       return parameterizedType.getActualTypeArguments();
/*     */     } 
/* 333 */     return new Type[] { Object.class, Object.class };
/*     */   }
/*     */   
/*     */   public static Type resolve(Type paramType1, Class<?> paramClass, Type paramType2) {
/* 337 */     return resolve(paramType1, paramClass, paramType2, new HashSet<TypeVariable>());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Type resolve(Type paramType1, Class<?> paramClass, Type paramType2, Collection<TypeVariable> paramCollection) {
/* 344 */     while (paramType2 instanceof TypeVariable) {
/* 345 */       TypeVariable<?> typeVariable = (TypeVariable)paramType2;
/* 346 */       if (paramCollection.contains(typeVariable))
/*     */       {
/* 348 */         return paramType2;
/*     */       }
/* 350 */       paramCollection.add(typeVariable);
/*     */       
/* 352 */       paramType2 = resolveTypeVariable(paramType1, paramClass, typeVariable);
/* 353 */       if (paramType2 == typeVariable) {
/* 354 */         return paramType2;
/*     */       }
/*     */     } 
/* 357 */     if (paramType2 instanceof Class && ((Class)paramType2).isArray()) {
/* 358 */       Class clazz = (Class)paramType2;
/* 359 */       Class<?> clazz1 = clazz.getComponentType();
/* 360 */       Type type = resolve(paramType1, paramClass, clazz1, paramCollection);
/* 361 */       return (clazz1 == type) ? clazz : 
/*     */         
/* 363 */         arrayOf(type);
/*     */     } 
/* 365 */     if (paramType2 instanceof GenericArrayType) {
/* 366 */       GenericArrayType genericArrayType = (GenericArrayType)paramType2;
/* 367 */       Type type1 = genericArrayType.getGenericComponentType();
/* 368 */       Type type2 = resolve(paramType1, paramClass, type1, paramCollection);
/* 369 */       return (type1 == type2) ? genericArrayType : 
/*     */         
/* 371 */         arrayOf(type2);
/*     */     } 
/* 373 */     if (paramType2 instanceof ParameterizedType) {
/* 374 */       ParameterizedType parameterizedType = (ParameterizedType)paramType2;
/* 375 */       Type type1 = parameterizedType.getOwnerType();
/* 376 */       Type type2 = resolve(paramType1, paramClass, type1, paramCollection);
/* 377 */       boolean bool = (type2 != type1) ? true : false;
/*     */       
/* 379 */       Type[] arrayOfType = parameterizedType.getActualTypeArguments(); byte b; int i;
/* 380 */       for (b = 0, i = arrayOfType.length; b < i; b++) {
/* 381 */         Type type = resolve(paramType1, paramClass, arrayOfType[b], paramCollection);
/* 382 */         if (type != arrayOfType[b]) {
/* 383 */           if (!bool) {
/* 384 */             arrayOfType = (Type[])arrayOfType.clone();
/* 385 */             bool = true;
/*     */           } 
/* 387 */           arrayOfType[b] = type;
/*     */         } 
/*     */       } 
/*     */       
/* 391 */       return bool ? 
/* 392 */         newParameterizedTypeWithOwner(type2, parameterizedType.getRawType(), arrayOfType) : parameterizedType;
/*     */     } 
/*     */     
/* 395 */     if (paramType2 instanceof WildcardType) {
/* 396 */       WildcardType wildcardType = (WildcardType)paramType2;
/* 397 */       Type[] arrayOfType1 = wildcardType.getLowerBounds();
/* 398 */       Type[] arrayOfType2 = wildcardType.getUpperBounds();
/*     */       
/* 400 */       if (arrayOfType1.length == 1) {
/* 401 */         Type type = resolve(paramType1, paramClass, arrayOfType1[0], paramCollection);
/* 402 */         if (type != arrayOfType1[0]) {
/* 403 */           return supertypeOf(type);
/*     */         }
/* 405 */       } else if (arrayOfType2.length == 1) {
/* 406 */         Type type = resolve(paramType1, paramClass, arrayOfType2[0], paramCollection);
/* 407 */         if (type != arrayOfType2[0]) {
/* 408 */           return subtypeOf(type);
/*     */         }
/*     */       } 
/* 411 */       return wildcardType;
/*     */     } 
/*     */     
/* 414 */     return paramType2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static Type resolveTypeVariable(Type paramType, Class<?> paramClass, TypeVariable<?> paramTypeVariable) {
/* 420 */     Class<?> clazz = declaringClassOf(paramTypeVariable);
/*     */ 
/*     */     
/* 423 */     if (clazz == null) {
/* 424 */       return paramTypeVariable;
/*     */     }
/*     */     
/* 427 */     Type type = getGenericSupertype(paramType, paramClass, clazz);
/* 428 */     if (type instanceof ParameterizedType) {
/* 429 */       int i = indexOf((Object[])clazz.getTypeParameters(), paramTypeVariable);
/* 430 */       return ((ParameterizedType)type).getActualTypeArguments()[i];
/*     */     } 
/*     */     
/* 433 */     return paramTypeVariable;
/*     */   } private static int indexOf(Object[] paramArrayOfObject, Object paramObject) {
/*     */     byte b;
/*     */     int i;
/* 437 */     for (b = 0, i = paramArrayOfObject.length; b < i; b++) {
/* 438 */       if (paramObject.equals(paramArrayOfObject[b])) {
/* 439 */         return b;
/*     */       }
/*     */     } 
/* 442 */     throw new NoSuchElementException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Class<?> declaringClassOf(TypeVariable<?> paramTypeVariable) {
/* 450 */     Object object = paramTypeVariable.getGenericDeclaration();
/* 451 */     return (object instanceof Class) ? (Class)object : null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static void checkNotPrimitive(Type paramType) {
/* 457 */     $Gson$Preconditions.checkArgument((!(paramType instanceof Class) || !((Class)paramType).isPrimitive()));
/*     */   }
/*     */   
/*     */   private static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
/*     */     private final Type ownerType;
/*     */     private final Type rawType;
/*     */     private final Type[] typeArguments;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     public ParameterizedTypeImpl(Type param1Type1, Type param1Type2, Type... param1VarArgs) {
/* 467 */       if (param1Type2 instanceof Class) {
/* 468 */         Class clazz = (Class)param1Type2;
/*     */         
/* 470 */         boolean bool = (Modifier.isStatic(clazz.getModifiers()) || clazz.getEnclosingClass() == null) ? true : false;
/* 471 */         $Gson$Preconditions.checkArgument((param1Type1 != null || bool));
/*     */       } 
/*     */       
/* 474 */       this.ownerType = (param1Type1 == null) ? null : $Gson$Types.canonicalize(param1Type1);
/* 475 */       this.rawType = $Gson$Types.canonicalize(param1Type2);
/* 476 */       this.typeArguments = (Type[])param1VarArgs.clone(); byte b; int i;
/* 477 */       for (b = 0, i = this.typeArguments.length; b < i; b++) {
/* 478 */         $Gson$Preconditions.checkNotNull(this.typeArguments[b]);
/* 479 */         $Gson$Types.checkNotPrimitive(this.typeArguments[b]);
/* 480 */         this.typeArguments[b] = $Gson$Types.canonicalize(this.typeArguments[b]);
/*     */       } 
/*     */     }
/*     */     
/*     */     public Type[] getActualTypeArguments() {
/* 485 */       return (Type[])this.typeArguments.clone();
/*     */     }
/*     */     
/*     */     public Type getRawType() {
/* 489 */       return this.rawType;
/*     */     }
/*     */     
/*     */     public Type getOwnerType() {
/* 493 */       return this.ownerType;
/*     */     }
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 497 */       return (param1Object instanceof ParameterizedType && 
/* 498 */         $Gson$Types.equals(this, (ParameterizedType)param1Object));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/* 502 */       return Arrays.hashCode((Object[])this.typeArguments) ^ this.rawType
/* 503 */         .hashCode() ^ 
/* 504 */         $Gson$Types.hashCodeOrZero(this.ownerType);
/*     */     }
/*     */     
/*     */     public String toString() {
/* 508 */       int i = this.typeArguments.length;
/* 509 */       if (i == 0) {
/* 510 */         return $Gson$Types.typeToString(this.rawType);
/*     */       }
/*     */       
/* 513 */       StringBuilder stringBuilder = new StringBuilder(30 * (i + 1));
/* 514 */       stringBuilder.append($Gson$Types.typeToString(this.rawType)).append("<").append($Gson$Types.typeToString(this.typeArguments[0]));
/* 515 */       for (byte b = 1; b < i; b++) {
/* 516 */         stringBuilder.append(", ").append($Gson$Types.typeToString(this.typeArguments[b]));
/*     */       }
/* 518 */       return stringBuilder.append(">").toString();
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class GenericArrayTypeImpl
/*     */     implements Serializable, GenericArrayType {
/*     */     private final Type componentType;
/*     */     private static final long serialVersionUID = 0L;
/*     */     
/*     */     public GenericArrayTypeImpl(Type param1Type) {
/* 528 */       this.componentType = $Gson$Types.canonicalize(param1Type);
/*     */     }
/*     */     
/*     */     public Type getGenericComponentType() {
/* 532 */       return this.componentType;
/*     */     }
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 536 */       return (param1Object instanceof GenericArrayType && 
/* 537 */         $Gson$Types.equals(this, (GenericArrayType)param1Object));
/*     */     }
/*     */     
/*     */     public int hashCode() {
/* 541 */       return this.componentType.hashCode();
/*     */     }
/*     */     
/*     */     public String toString() {
/* 545 */       return $Gson$Types.typeToString(this.componentType) + "[]";
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class WildcardTypeImpl
/*     */     implements Serializable, WildcardType
/*     */   {
/*     */     private final Type upperBound;
/*     */     
/*     */     private final Type lowerBound;
/*     */     
/*     */     private static final long serialVersionUID = 0L;
/*     */ 
/*     */     
/*     */     public WildcardTypeImpl(Type[] param1ArrayOfType1, Type[] param1ArrayOfType2) {
/* 561 */       $Gson$Preconditions.checkArgument((param1ArrayOfType2.length <= 1));
/* 562 */       $Gson$Preconditions.checkArgument((param1ArrayOfType1.length == 1));
/*     */       
/* 564 */       if (param1ArrayOfType2.length == 1) {
/* 565 */         $Gson$Preconditions.checkNotNull(param1ArrayOfType2[0]);
/* 566 */         $Gson$Types.checkNotPrimitive(param1ArrayOfType2[0]);
/* 567 */         $Gson$Preconditions.checkArgument((param1ArrayOfType1[0] == Object.class));
/* 568 */         this.lowerBound = $Gson$Types.canonicalize(param1ArrayOfType2[0]);
/* 569 */         this.upperBound = Object.class;
/*     */       } else {
/*     */         
/* 572 */         $Gson$Preconditions.checkNotNull(param1ArrayOfType1[0]);
/* 573 */         $Gson$Types.checkNotPrimitive(param1ArrayOfType1[0]);
/* 574 */         this.lowerBound = null;
/* 575 */         this.upperBound = $Gson$Types.canonicalize(param1ArrayOfType1[0]);
/*     */       } 
/*     */     }
/*     */     
/*     */     public Type[] getUpperBounds() {
/* 580 */       return new Type[] { this.upperBound };
/*     */     }
/*     */     
/*     */     public Type[] getLowerBounds() {
/* 584 */       (new Type[1])[0] = this.lowerBound; return (this.lowerBound != null) ? new Type[1] : $Gson$Types.EMPTY_TYPE_ARRAY;
/*     */     }
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 588 */       return (param1Object instanceof WildcardType && 
/* 589 */         $Gson$Types.equals(this, (WildcardType)param1Object));
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 594 */       return ((this.lowerBound != null) ? (31 + this.lowerBound.hashCode()) : 1) ^ 31 + this.upperBound
/* 595 */         .hashCode();
/*     */     }
/*     */     
/*     */     public String toString() {
/* 599 */       if (this.lowerBound != null)
/* 600 */         return "? super " + $Gson$Types.typeToString(this.lowerBound); 
/* 601 */       if (this.upperBound == Object.class) {
/* 602 */         return "?";
/*     */       }
/* 604 */       return "? extends " + $Gson$Types.typeToString(this.upperBound);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\$Gson$Types.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */