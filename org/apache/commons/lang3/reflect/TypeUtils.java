/*      */ package org.apache.commons.lang3.reflect;
/*      */ 
/*      */ import java.lang.reflect.Array;
/*      */ import java.lang.reflect.GenericArrayType;
/*      */ import java.lang.reflect.ParameterizedType;
/*      */ import java.lang.reflect.Type;
/*      */ import java.lang.reflect.TypeVariable;
/*      */ import java.lang.reflect.WildcardType;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Objects;
/*      */ import org.apache.commons.lang3.ArrayUtils;
/*      */ import org.apache.commons.lang3.ClassUtils;
/*      */ import org.apache.commons.lang3.ObjectUtils;
/*      */ import org.apache.commons.lang3.Validate;
/*      */ import org.apache.commons.lang3.builder.Builder;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class TypeUtils
/*      */ {
/*      */   public static class WildcardTypeBuilder
/*      */     implements Builder<WildcardType>
/*      */   {
/*      */     private Type[] upperBounds;
/*      */     private Type[] lowerBounds;
/*      */     
/*      */     private WildcardTypeBuilder() {}
/*      */     
/*      */     public WildcardTypeBuilder withUpperBounds(Type... param1VarArgs) {
/*   69 */       this.upperBounds = param1VarArgs;
/*   70 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WildcardTypeBuilder withLowerBounds(Type... param1VarArgs) {
/*   79 */       this.lowerBounds = param1VarArgs;
/*   80 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public WildcardType build() {
/*   88 */       return new TypeUtils.WildcardTypeImpl(this.upperBounds, this.lowerBounds);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class GenericArrayTypeImpl
/*      */     implements GenericArrayType
/*      */   {
/*      */     private final Type componentType;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private GenericArrayTypeImpl(Type param1Type) {
/*  104 */       this.componentType = param1Type;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Type getGenericComponentType() {
/*  112 */       return this.componentType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/*  120 */       return TypeUtils.toString(this);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(Object param1Object) {
/*  128 */       return (param1Object == this || (param1Object instanceof GenericArrayType && TypeUtils.equals(this, (GenericArrayType)param1Object)));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*  136 */       int i = 1072;
/*  137 */       i |= this.componentType.hashCode();
/*  138 */       return i;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class ParameterizedTypeImpl
/*      */     implements ParameterizedType
/*      */   {
/*      */     private final Class<?> raw;
/*      */ 
/*      */     
/*      */     private final Type useOwner;
/*      */ 
/*      */     
/*      */     private final Type[] typeArguments;
/*      */ 
/*      */ 
/*      */     
/*      */     private ParameterizedTypeImpl(Class<?> param1Class, Type param1Type, Type[] param1ArrayOfType) {
/*  158 */       this.raw = param1Class;
/*  159 */       this.useOwner = param1Type;
/*  160 */       this.typeArguments = Arrays.<Type, Type>copyOf(param1ArrayOfType, param1ArrayOfType.length, Type[].class);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Type getRawType() {
/*  168 */       return this.raw;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Type getOwnerType() {
/*  176 */       return this.useOwner;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Type[] getActualTypeArguments() {
/*  184 */       return (Type[])this.typeArguments.clone();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/*  192 */       return TypeUtils.toString(this);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(Object param1Object) {
/*  200 */       return (param1Object == this || (param1Object instanceof ParameterizedType && TypeUtils.equals(this, (ParameterizedType)param1Object)));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*  208 */       int i = 1136;
/*  209 */       i |= this.raw.hashCode();
/*  210 */       i <<= 4;
/*  211 */       i |= Objects.hashCode(this.useOwner);
/*  212 */       i <<= 8;
/*  213 */       i |= Arrays.hashCode((Object[])this.typeArguments);
/*  214 */       return i;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class WildcardTypeImpl
/*      */     implements WildcardType
/*      */   {
/*      */     private final Type[] upperBounds;
/*      */ 
/*      */     
/*      */     private final Type[] lowerBounds;
/*      */ 
/*      */ 
/*      */     
/*      */     private WildcardTypeImpl(Type[] param1ArrayOfType1, Type[] param1ArrayOfType2) {
/*  232 */       this.upperBounds = (Type[])ObjectUtils.defaultIfNull(param1ArrayOfType1, ArrayUtils.EMPTY_TYPE_ARRAY);
/*  233 */       this.lowerBounds = (Type[])ObjectUtils.defaultIfNull(param1ArrayOfType2, ArrayUtils.EMPTY_TYPE_ARRAY);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Type[] getUpperBounds() {
/*  241 */       return (Type[])this.upperBounds.clone();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Type[] getLowerBounds() {
/*  249 */       return (Type[])this.lowerBounds.clone();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/*  257 */       return TypeUtils.toString(this);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(Object param1Object) {
/*  265 */       return (param1Object == this || (param1Object instanceof WildcardType && TypeUtils.equals(this, (WildcardType)param1Object)));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*  273 */       int i = 18688;
/*  274 */       i |= Arrays.hashCode((Object[])this.upperBounds);
/*  275 */       i <<= 8;
/*  276 */       i |= Arrays.hashCode((Object[])this.lowerBounds);
/*  277 */       return i;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  285 */   public static final WildcardType WILDCARD_ALL = wildcardType().withUpperBounds(new Type[] { Object.class }).build();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAssignable(Type paramType1, Type paramType2) {
/*  309 */     return isAssignable(paramType1, paramType2, (Map<TypeVariable<?>, Type>)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isAssignable(Type paramType1, Type paramType2, Map<TypeVariable<?>, Type> paramMap) {
/*  323 */     if (paramType2 == null || paramType2 instanceof Class) {
/*  324 */       return isAssignable(paramType1, (Class)paramType2);
/*      */     }
/*      */     
/*  327 */     if (paramType2 instanceof ParameterizedType) {
/*  328 */       return isAssignable(paramType1, (ParameterizedType)paramType2, paramMap);
/*      */     }
/*      */     
/*  331 */     if (paramType2 instanceof GenericArrayType) {
/*  332 */       return isAssignable(paramType1, (GenericArrayType)paramType2, paramMap);
/*      */     }
/*      */     
/*  335 */     if (paramType2 instanceof WildcardType) {
/*  336 */       return isAssignable(paramType1, (WildcardType)paramType2, paramMap);
/*      */     }
/*      */     
/*  339 */     if (paramType2 instanceof TypeVariable) {
/*  340 */       return isAssignable(paramType1, (TypeVariable)paramType2, paramMap);
/*      */     }
/*      */     
/*  343 */     throw new IllegalStateException("found an unhandled type: " + paramType2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isAssignable(Type paramType, Class<?> paramClass) {
/*  355 */     if (paramType == null)
/*      */     {
/*  357 */       return (paramClass == null || !paramClass.isPrimitive());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  362 */     if (paramClass == null) {
/*  363 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  367 */     if (paramClass.equals(paramType)) {
/*  368 */       return true;
/*      */     }
/*      */     
/*  371 */     if (paramType instanceof Class)
/*      */     {
/*  373 */       return ClassUtils.isAssignable((Class)paramType, paramClass);
/*      */     }
/*      */     
/*  376 */     if (paramType instanceof ParameterizedType)
/*      */     {
/*  378 */       return isAssignable(getRawType((ParameterizedType)paramType), paramClass);
/*      */     }
/*      */ 
/*      */     
/*  382 */     if (paramType instanceof TypeVariable) {
/*      */ 
/*      */       
/*  385 */       for (Type type : ((TypeVariable)paramType).getBounds()) {
/*  386 */         if (isAssignable(type, paramClass)) {
/*  387 */           return true;
/*      */         }
/*      */       } 
/*      */       
/*  391 */       return false;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  396 */     if (paramType instanceof GenericArrayType) {
/*  397 */       return (paramClass.equals(Object.class) || (paramClass
/*  398 */         .isArray() && 
/*  399 */         isAssignable(((GenericArrayType)paramType).getGenericComponentType(), paramClass
/*  400 */           .getComponentType())));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  405 */     if (paramType instanceof WildcardType) {
/*  406 */       return false;
/*      */     }
/*      */     
/*  409 */     throw new IllegalStateException("found an unhandled type: " + paramType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isAssignable(Type paramType, ParameterizedType paramParameterizedType, Map<TypeVariable<?>, Type> paramMap) {
/*  423 */     if (paramType == null) {
/*  424 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  429 */     if (paramParameterizedType == null) {
/*  430 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  434 */     if (paramParameterizedType.equals(paramType)) {
/*  435 */       return true;
/*      */     }
/*      */ 
/*      */     
/*  439 */     Class<?> clazz = getRawType(paramParameterizedType);
/*      */ 
/*      */     
/*  442 */     Map<TypeVariable<?>, Type> map1 = getTypeArguments(paramType, clazz, (Map<TypeVariable<?>, Type>)null);
/*      */ 
/*      */     
/*  445 */     if (map1 == null) {
/*  446 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  452 */     if (map1.isEmpty()) {
/*  453 */       return true;
/*      */     }
/*      */ 
/*      */     
/*  457 */     Map<TypeVariable<?>, Type> map2 = getTypeArguments(paramParameterizedType, clazz, paramMap);
/*      */ 
/*      */ 
/*      */     
/*  461 */     for (TypeVariable<?> typeVariable : map2.keySet()) {
/*  462 */       Type type1 = unrollVariableAssignments(typeVariable, map2);
/*  463 */       Type type2 = unrollVariableAssignments(typeVariable, map1);
/*      */       
/*  465 */       if (type1 == null && type2 instanceof Class) {
/*      */         continue;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  472 */       if (type2 != null && 
/*  473 */         !type1.equals(type2) && (!(type1 instanceof WildcardType) || 
/*  474 */         !isAssignable(type2, type1, paramMap)))
/*      */       {
/*  476 */         return false;
/*      */       }
/*      */     } 
/*  479 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Type unrollVariableAssignments(TypeVariable<?> paramTypeVariable, Map<TypeVariable<?>, Type> paramMap) {
/*      */     Type type;
/*      */     while (true) {
/*  494 */       type = paramMap.get(paramTypeVariable);
/*  495 */       if (type instanceof TypeVariable && !type.equals(paramTypeVariable)) {
/*  496 */         paramTypeVariable = (TypeVariable)type;
/*      */         continue;
/*      */       } 
/*      */       break;
/*      */     } 
/*  501 */     return type;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isAssignable(Type paramType, GenericArrayType paramGenericArrayType, Map<TypeVariable<?>, Type> paramMap) {
/*  516 */     if (paramType == null) {
/*  517 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  522 */     if (paramGenericArrayType == null) {
/*  523 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  527 */     if (paramGenericArrayType.equals(paramType)) {
/*  528 */       return true;
/*      */     }
/*      */     
/*  531 */     Type type = paramGenericArrayType.getGenericComponentType();
/*      */     
/*  533 */     if (paramType instanceof Class) {
/*  534 */       Class clazz = (Class)paramType;
/*      */ 
/*      */       
/*  537 */       return (clazz.isArray() && 
/*  538 */         isAssignable(clazz.getComponentType(), type, paramMap));
/*      */     } 
/*      */     
/*  541 */     if (paramType instanceof GenericArrayType)
/*      */     {
/*  543 */       return isAssignable(((GenericArrayType)paramType).getGenericComponentType(), type, paramMap);
/*      */     }
/*      */ 
/*      */     
/*  547 */     if (paramType instanceof WildcardType) {
/*      */       
/*  549 */       for (Type type1 : getImplicitUpperBounds((WildcardType)paramType)) {
/*  550 */         if (isAssignable(type1, paramGenericArrayType)) {
/*  551 */           return true;
/*      */         }
/*      */       } 
/*      */       
/*  555 */       return false;
/*      */     } 
/*      */     
/*  558 */     if (paramType instanceof TypeVariable) {
/*      */ 
/*      */       
/*  561 */       for (Type type1 : getImplicitBounds((TypeVariable)paramType)) {
/*  562 */         if (isAssignable(type1, paramGenericArrayType)) {
/*  563 */           return true;
/*      */         }
/*      */       } 
/*      */       
/*  567 */       return false;
/*      */     } 
/*      */     
/*  570 */     if (paramType instanceof ParameterizedType)
/*      */     {
/*      */ 
/*      */       
/*  574 */       return false;
/*      */     }
/*      */     
/*  577 */     throw new IllegalStateException("found an unhandled type: " + paramType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isAssignable(Type paramType, WildcardType paramWildcardType, Map<TypeVariable<?>, Type> paramMap) {
/*  592 */     if (paramType == null) {
/*  593 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  598 */     if (paramWildcardType == null) {
/*  599 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  603 */     if (paramWildcardType.equals(paramType)) {
/*  604 */       return true;
/*      */     }
/*      */     
/*  607 */     Type[] arrayOfType1 = getImplicitUpperBounds(paramWildcardType);
/*  608 */     Type[] arrayOfType2 = getImplicitLowerBounds(paramWildcardType);
/*      */     
/*  610 */     if (paramType instanceof WildcardType) {
/*  611 */       WildcardType wildcardType = (WildcardType)paramType;
/*  612 */       Type[] arrayOfType3 = getImplicitUpperBounds(wildcardType);
/*  613 */       Type[] arrayOfType4 = getImplicitLowerBounds(wildcardType);
/*      */       
/*  615 */       for (Type type : arrayOfType1) {
/*      */ 
/*      */         
/*  618 */         type = substituteTypeVariables(type, paramMap);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  623 */         for (Type type1 : arrayOfType3) {
/*  624 */           if (!isAssignable(type1, type, paramMap)) {
/*  625 */             return false;
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/*  630 */       for (Type type : arrayOfType2) {
/*      */ 
/*      */         
/*  633 */         type = substituteTypeVariables(type, paramMap);
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  638 */         for (Type type1 : arrayOfType4) {
/*  639 */           if (!isAssignable(type, type1, paramMap)) {
/*  640 */             return false;
/*      */           }
/*      */         } 
/*      */       } 
/*  644 */       return true;
/*      */     } 
/*      */     
/*  647 */     for (Type type : arrayOfType1) {
/*      */ 
/*      */       
/*  650 */       if (!isAssignable(paramType, substituteTypeVariables(type, paramMap), paramMap))
/*      */       {
/*  652 */         return false;
/*      */       }
/*      */     } 
/*      */     
/*  656 */     for (Type type : arrayOfType2) {
/*      */ 
/*      */       
/*  659 */       if (!isAssignable(substituteTypeVariables(type, paramMap), paramType, paramMap))
/*      */       {
/*  661 */         return false;
/*      */       }
/*      */     } 
/*  664 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isAssignable(Type paramType, TypeVariable<?> paramTypeVariable, Map<TypeVariable<?>, Type> paramMap) {
/*  679 */     if (paramType == null) {
/*  680 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  685 */     if (paramTypeVariable == null) {
/*  686 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  690 */     if (paramTypeVariable.equals(paramType)) {
/*  691 */       return true;
/*      */     }
/*      */     
/*  694 */     if (paramType instanceof TypeVariable) {
/*      */ 
/*      */ 
/*      */       
/*  698 */       Type[] arrayOfType = getImplicitBounds((TypeVariable)paramType);
/*      */       
/*  700 */       for (Type type : arrayOfType) {
/*  701 */         if (isAssignable(type, paramTypeVariable, paramMap)) {
/*  702 */           return true;
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  707 */     if (paramType instanceof Class || paramType instanceof ParameterizedType || paramType instanceof GenericArrayType || paramType instanceof WildcardType)
/*      */     {
/*  709 */       return false;
/*      */     }
/*      */     
/*  712 */     throw new IllegalStateException("found an unhandled type: " + paramType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Type substituteTypeVariables(Type paramType, Map<TypeVariable<?>, Type> paramMap) {
/*  724 */     if (paramType instanceof TypeVariable && paramMap != null) {
/*  725 */       Type type = paramMap.get(paramType);
/*      */       
/*  727 */       if (type == null) {
/*  728 */         throw new IllegalArgumentException("missing assignment type for type variable " + paramType);
/*      */       }
/*      */       
/*  731 */       return type;
/*      */     } 
/*  733 */     return paramType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Map<TypeVariable<?>, Type> getTypeArguments(ParameterizedType paramParameterizedType) {
/*  750 */     return getTypeArguments(paramParameterizedType, getRawType(paramParameterizedType), (Map<TypeVariable<?>, Type>)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Map<TypeVariable<?>, Type> getTypeArguments(Type paramType, Class<?> paramClass) {
/*  786 */     return getTypeArguments(paramType, paramClass, (Map<TypeVariable<?>, Type>)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Map<TypeVariable<?>, Type> getTypeArguments(Type paramType, Class<?> paramClass, Map<TypeVariable<?>, Type> paramMap) {
/*  799 */     if (paramType instanceof Class) {
/*  800 */       return getTypeArguments((Class)paramType, paramClass, paramMap);
/*      */     }
/*      */     
/*  803 */     if (paramType instanceof ParameterizedType) {
/*  804 */       return getTypeArguments((ParameterizedType)paramType, paramClass, paramMap);
/*      */     }
/*      */     
/*  807 */     if (paramType instanceof GenericArrayType) {
/*  808 */       return getTypeArguments(((GenericArrayType)paramType).getGenericComponentType(), 
/*  809 */           paramClass.isArray() ? paramClass.getComponentType() : paramClass, paramMap);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  814 */     if (paramType instanceof WildcardType) {
/*  815 */       for (Type type : getImplicitUpperBounds((WildcardType)paramType)) {
/*      */         
/*  817 */         if (isAssignable(type, paramClass)) {
/*  818 */           return getTypeArguments(type, paramClass, paramMap);
/*      */         }
/*      */       } 
/*      */       
/*  822 */       return null;
/*      */     } 
/*      */     
/*  825 */     if (paramType instanceof TypeVariable) {
/*  826 */       for (Type type : getImplicitBounds((TypeVariable)paramType)) {
/*      */         
/*  828 */         if (isAssignable(type, paramClass)) {
/*  829 */           return getTypeArguments(type, paramClass, paramMap);
/*      */         }
/*      */       } 
/*      */       
/*  833 */       return null;
/*      */     } 
/*  835 */     throw new IllegalStateException("found an unhandled type: " + paramType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Map<TypeVariable<?>, Type> getTypeArguments(ParameterizedType paramParameterizedType, Class<?> paramClass, Map<TypeVariable<?>, Type> paramMap) {
/*      */     Map<TypeVariable<?>, Type> map;
/*  849 */     Class<?> clazz = getRawType(paramParameterizedType);
/*      */ 
/*      */     
/*  852 */     if (!isAssignable(clazz, paramClass)) {
/*  853 */       return null;
/*      */     }
/*      */     
/*  856 */     Type type = paramParameterizedType.getOwnerType();
/*      */ 
/*      */     
/*  859 */     if (type instanceof ParameterizedType) {
/*      */       
/*  861 */       ParameterizedType parameterizedType = (ParameterizedType)type;
/*  862 */       map = getTypeArguments(parameterizedType, 
/*  863 */           getRawType(parameterizedType), paramMap);
/*      */     } else {
/*      */       
/*  866 */       map = (paramMap == null) ? new HashMap<>() : new HashMap<>(paramMap);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  871 */     Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
/*      */     
/*  873 */     TypeVariable[] arrayOfTypeVariable = (TypeVariable[])clazz.getTypeParameters();
/*      */ 
/*      */     
/*  876 */     for (byte b = 0; b < arrayOfTypeVariable.length; b++) {
/*  877 */       Type type1 = arrayOfType[b];
/*  878 */       map.put(arrayOfTypeVariable[b], map
/*      */           
/*  880 */           .getOrDefault(type1, type1));
/*      */     } 
/*      */ 
/*      */     
/*  884 */     if (paramClass.equals(clazz))
/*      */     {
/*  886 */       return map;
/*      */     }
/*      */ 
/*      */     
/*  890 */     return getTypeArguments(getClosestParentType(clazz, paramClass), paramClass, map);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Map<TypeVariable<?>, Type> getTypeArguments(Class<?> paramClass1, Class<?> paramClass2, Map<TypeVariable<?>, Type> paramMap) {
/*  904 */     if (!isAssignable(paramClass1, paramClass2)) {
/*  905 */       return null;
/*      */     }
/*      */ 
/*      */     
/*  909 */     if (paramClass1.isPrimitive()) {
/*      */       
/*  911 */       if (paramClass2.isPrimitive())
/*      */       {
/*      */         
/*  914 */         return new HashMap<>();
/*      */       }
/*      */ 
/*      */       
/*  918 */       paramClass1 = ClassUtils.primitiveToWrapper(paramClass1);
/*      */     } 
/*      */ 
/*      */     
/*  922 */     HashMap<TypeVariable<?>, Type> hashMap = (paramMap == null) ? new HashMap<>() : new HashMap<>(paramMap);
/*      */ 
/*      */ 
/*      */     
/*  926 */     if (paramClass2.equals(paramClass1)) {
/*  927 */       return hashMap;
/*      */     }
/*      */ 
/*      */     
/*  931 */     return getTypeArguments(getClosestParentType(paramClass1, paramClass2), paramClass2, hashMap);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Map<TypeVariable<?>, Type> determineTypeArguments(Class<?> paramClass, ParameterizedType paramParameterizedType) {
/*  963 */     Validate.notNull(paramClass, "cls is null", new Object[0]);
/*  964 */     Validate.notNull(paramParameterizedType, "superType is null", new Object[0]);
/*      */     
/*  966 */     Class<?> clazz1 = getRawType(paramParameterizedType);
/*      */ 
/*      */     
/*  969 */     if (!isAssignable(paramClass, clazz1)) {
/*  970 */       return null;
/*      */     }
/*      */     
/*  973 */     if (paramClass.equals(clazz1)) {
/*  974 */       return getTypeArguments(paramParameterizedType, clazz1, (Map<TypeVariable<?>, Type>)null);
/*      */     }
/*      */ 
/*      */     
/*  978 */     Type type = getClosestParentType(paramClass, clazz1);
/*      */ 
/*      */     
/*  981 */     if (type instanceof Class) {
/*  982 */       return determineTypeArguments((Class)type, paramParameterizedType);
/*      */     }
/*      */     
/*  985 */     ParameterizedType parameterizedType = (ParameterizedType)type;
/*  986 */     Class<?> clazz2 = getRawType(parameterizedType);
/*      */ 
/*      */     
/*  989 */     Map<TypeVariable<?>, Type> map = determineTypeArguments(clazz2, paramParameterizedType);
/*      */     
/*  991 */     mapTypeVariablesToArguments(paramClass, parameterizedType, map);
/*      */     
/*  993 */     return map;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static <T> void mapTypeVariablesToArguments(Class<T> paramClass, ParameterizedType paramParameterizedType, Map<TypeVariable<?>, Type> paramMap) {
/* 1007 */     Type type = paramParameterizedType.getOwnerType();
/*      */     
/* 1009 */     if (type instanceof ParameterizedType)
/*      */     {
/* 1011 */       mapTypeVariablesToArguments(paramClass, (ParameterizedType)type, paramMap);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1018 */     Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
/*      */ 
/*      */ 
/*      */     
/* 1022 */     TypeVariable[] arrayOfTypeVariable = (TypeVariable[])getRawType(paramParameterizedType).getTypeParameters();
/*      */ 
/*      */     
/* 1025 */     List<?> list = Arrays.asList((Object[])paramClass
/* 1026 */         .getTypeParameters());
/*      */     
/* 1028 */     for (byte b = 0; b < arrayOfType.length; b++) {
/* 1029 */       TypeVariable typeVariable = arrayOfTypeVariable[b];
/* 1030 */       Type type1 = arrayOfType[b];
/*      */ 
/*      */       
/* 1033 */       if (list.contains(type1) && paramMap
/*      */ 
/*      */         
/* 1036 */         .containsKey(typeVariable))
/*      */       {
/* 1038 */         paramMap.put((TypeVariable)type1, paramMap.get(typeVariable));
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Type getClosestParentType(Class<?> paramClass1, Class<?> paramClass2) {
/* 1053 */     if (paramClass2.isInterface()) {
/*      */       
/* 1055 */       Type[] arrayOfType = paramClass1.getGenericInterfaces();
/*      */       
/* 1057 */       Type type = null;
/*      */ 
/*      */       
/* 1060 */       for (Type type1 : arrayOfType) {
/* 1061 */         Class<?> clazz = null;
/*      */         
/* 1063 */         if (type1 instanceof ParameterizedType) {
/* 1064 */           clazz = getRawType((ParameterizedType)type1);
/* 1065 */         } else if (type1 instanceof Class) {
/* 1066 */           clazz = (Class)type1;
/*      */         } else {
/* 1068 */           throw new IllegalStateException("Unexpected generic interface type found: " + type1);
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1074 */         if (isAssignable(clazz, paramClass2) && 
/* 1075 */           isAssignable(type, clazz)) {
/* 1076 */           type = type1;
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/* 1081 */       if (type != null) {
/* 1082 */         return type;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1088 */     return paramClass1.getGenericSuperclass();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isInstance(Object paramObject, Type paramType) {
/* 1100 */     if (paramType == null) {
/* 1101 */       return false;
/*      */     }
/*      */     
/* 1104 */     return (paramObject == null) ? ((!(paramType instanceof Class) || !((Class)paramType).isPrimitive())) : 
/* 1105 */       isAssignable(paramObject.getClass(), paramType, (Map<TypeVariable<?>, Type>)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Type[] normalizeUpperBounds(Type[] paramArrayOfType) {
/* 1130 */     Validate.notNull(paramArrayOfType, "null value specified for bounds array", new Object[0]);
/*      */     
/* 1132 */     if (paramArrayOfType.length < 2) {
/* 1133 */       return paramArrayOfType;
/*      */     }
/*      */     
/* 1136 */     HashSet<Type> hashSet = new HashSet(paramArrayOfType.length);
/*      */     
/* 1138 */     for (Type type : paramArrayOfType) {
/* 1139 */       boolean bool = false;
/*      */       
/* 1141 */       for (Type type1 : paramArrayOfType) {
/* 1142 */         if (type != type1 && isAssignable(type1, type, (Map<TypeVariable<?>, Type>)null)) {
/* 1143 */           bool = true;
/*      */           
/*      */           break;
/*      */         } 
/*      */       } 
/* 1148 */       if (!bool) {
/* 1149 */         hashSet.add(type);
/*      */       }
/*      */     } 
/*      */     
/* 1153 */     return hashSet.<Type>toArray(ArrayUtils.EMPTY_TYPE_ARRAY);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Type[] getImplicitBounds(TypeVariable<?> paramTypeVariable) {
/* 1166 */     Validate.notNull(paramTypeVariable, "typeVariable is null", new Object[0]);
/* 1167 */     Type[] arrayOfType = paramTypeVariable.getBounds();
/*      */     
/* 1169 */     (new Type[1])[0] = Object.class; return (arrayOfType.length == 0) ? new Type[1] : normalizeUpperBounds(arrayOfType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Type[] getImplicitUpperBounds(WildcardType paramWildcardType) {
/* 1183 */     Validate.notNull(paramWildcardType, "wildcardType is null", new Object[0]);
/* 1184 */     Type[] arrayOfType = paramWildcardType.getUpperBounds();
/*      */     
/* 1186 */     (new Type[1])[0] = Object.class; return (arrayOfType.length == 0) ? new Type[1] : normalizeUpperBounds(arrayOfType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Type[] getImplicitLowerBounds(WildcardType paramWildcardType) {
/* 1199 */     Validate.notNull(paramWildcardType, "wildcardType is null", new Object[0]);
/* 1200 */     Type[] arrayOfType = paramWildcardType.getLowerBounds();
/*      */     
/* 1202 */     (new Type[1])[0] = null; return (arrayOfType.length == 0) ? new Type[1] : arrayOfType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean typesSatisfyVariables(Map<TypeVariable<?>, Type> paramMap) {
/* 1219 */     Validate.notNull(paramMap, "typeVarAssigns is null", new Object[0]);
/*      */ 
/*      */     
/* 1222 */     for (Map.Entry<TypeVariable<?>, Type> entry : paramMap.entrySet()) {
/* 1223 */       TypeVariable<?> typeVariable = (TypeVariable)entry.getKey();
/* 1224 */       Type type = (Type)entry.getValue();
/*      */       
/* 1226 */       for (Type type1 : getImplicitBounds(typeVariable)) {
/* 1227 */         if (!isAssignable(type, substituteTypeVariables(type1, paramMap), paramMap))
/*      */         {
/* 1229 */           return false;
/*      */         }
/*      */       } 
/*      */     } 
/* 1233 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Class<?> getRawType(ParameterizedType paramParameterizedType) {
/* 1244 */     Type type = paramParameterizedType.getRawType();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1251 */     if (!(type instanceof Class)) {
/* 1252 */       throw new IllegalStateException("Wait... What!? Type of rawType: " + type);
/*      */     }
/*      */     
/* 1255 */     return (Class)type;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Class<?> getRawType(Type paramType1, Type paramType2) {
/* 1271 */     if (paramType1 instanceof Class)
/*      */     {
/* 1273 */       return (Class)paramType1;
/*      */     }
/*      */     
/* 1276 */     if (paramType1 instanceof ParameterizedType)
/*      */     {
/* 1278 */       return getRawType((ParameterizedType)paramType1);
/*      */     }
/*      */     
/* 1281 */     if (paramType1 instanceof TypeVariable) {
/* 1282 */       if (paramType2 == null) {
/* 1283 */         return null;
/*      */       }
/*      */ 
/*      */       
/* 1287 */       Class clazz = (Class)((TypeVariable<Object>)paramType1).getGenericDeclaration();
/*      */ 
/*      */ 
/*      */       
/* 1291 */       if (!(clazz instanceof Class)) {
/* 1292 */         return null;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1297 */       Map<TypeVariable<?>, Type> map = getTypeArguments(paramType2, clazz);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1302 */       if (map == null) {
/* 1303 */         return null;
/*      */       }
/*      */ 
/*      */       
/* 1307 */       Type type = map.get(paramType1);
/*      */       
/* 1309 */       if (type == null) {
/* 1310 */         return null;
/*      */       }
/*      */ 
/*      */       
/* 1314 */       return getRawType(type, paramType2);
/*      */     } 
/*      */     
/* 1317 */     if (paramType1 instanceof GenericArrayType) {
/*      */       
/* 1319 */       Class<?> clazz = getRawType(((GenericArrayType)paramType1)
/* 1320 */           .getGenericComponentType(), paramType2);
/*      */ 
/*      */       
/* 1323 */       return Array.newInstance(clazz, 0).getClass();
/*      */     } 
/*      */ 
/*      */     
/* 1327 */     if (paramType1 instanceof WildcardType) {
/* 1328 */       return null;
/*      */     }
/*      */     
/* 1331 */     throw new IllegalArgumentException("unknown type: " + paramType1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isArrayType(Type paramType) {
/* 1340 */     return (paramType instanceof GenericArrayType || (paramType instanceof Class && ((Class)paramType).isArray()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Type getArrayComponentType(Type paramType) {
/* 1349 */     if (paramType instanceof Class) {
/* 1350 */       Class clazz = (Class)paramType;
/* 1351 */       return clazz.isArray() ? clazz.getComponentType() : null;
/*      */     } 
/* 1353 */     if (paramType instanceof GenericArrayType) {
/* 1354 */       return ((GenericArrayType)paramType).getGenericComponentType();
/*      */     }
/* 1356 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Type unrollVariables(Map<TypeVariable<?>, Type> paramMap, Type paramType) {
/* 1368 */     if (paramMap == null) {
/* 1369 */       paramMap = Collections.emptyMap();
/*      */     }
/* 1371 */     if (containsTypeVariables(paramType)) {
/* 1372 */       if (paramType instanceof TypeVariable) {
/* 1373 */         return unrollVariables(paramMap, paramMap.get(paramType));
/*      */       }
/* 1375 */       if (paramType instanceof ParameterizedType) {
/* 1376 */         Map<TypeVariable<?>, Type> map; ParameterizedType parameterizedType = (ParameterizedType)paramType;
/*      */         
/* 1378 */         if (parameterizedType.getOwnerType() == null) {
/* 1379 */           map = paramMap;
/*      */         } else {
/* 1381 */           map = new HashMap<>(paramMap);
/* 1382 */           map.putAll(getTypeArguments(parameterizedType));
/*      */         } 
/* 1384 */         Type[] arrayOfType = parameterizedType.getActualTypeArguments();
/* 1385 */         for (byte b = 0; b < arrayOfType.length; b++) {
/* 1386 */           Type type = unrollVariables(map, arrayOfType[b]);
/* 1387 */           if (type != null) {
/* 1388 */             arrayOfType[b] = type;
/*      */           }
/*      */         } 
/* 1391 */         return parameterizeWithOwner(parameterizedType.getOwnerType(), (Class)parameterizedType.getRawType(), arrayOfType);
/*      */       } 
/* 1393 */       if (paramType instanceof WildcardType) {
/* 1394 */         WildcardType wildcardType = (WildcardType)paramType;
/* 1395 */         return wildcardType().withUpperBounds(unrollBounds(paramMap, wildcardType.getUpperBounds()))
/* 1396 */           .withLowerBounds(unrollBounds(paramMap, wildcardType.getLowerBounds())).build();
/*      */       } 
/*      */     } 
/* 1399 */     return paramType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Type[] unrollBounds(Map<TypeVariable<?>, Type> paramMap, Type[] paramArrayOfType) {
/* 1411 */     Type[] arrayOfType = paramArrayOfType;
/* 1412 */     byte b = 0;
/* 1413 */     for (; b < arrayOfType.length; b++) {
/* 1414 */       Type type = unrollVariables(paramMap, arrayOfType[b]);
/* 1415 */       if (type == null) {
/* 1416 */         arrayOfType = (Type[])ArrayUtils.remove((Object[])arrayOfType, b--);
/*      */       } else {
/* 1418 */         arrayOfType[b] = type;
/*      */       } 
/*      */     } 
/* 1421 */     return arrayOfType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean containsTypeVariables(Type paramType) {
/* 1432 */     if (paramType instanceof TypeVariable) {
/* 1433 */       return true;
/*      */     }
/* 1435 */     if (paramType instanceof Class) {
/* 1436 */       return ((((Class)paramType).getTypeParameters()).length > 0);
/*      */     }
/* 1438 */     if (paramType instanceof ParameterizedType) {
/* 1439 */       for (Type type : ((ParameterizedType)paramType).getActualTypeArguments()) {
/* 1440 */         if (containsTypeVariables(type)) {
/* 1441 */           return true;
/*      */         }
/*      */       } 
/* 1444 */       return false;
/*      */     } 
/* 1446 */     if (paramType instanceof WildcardType) {
/* 1447 */       WildcardType wildcardType = (WildcardType)paramType;
/* 1448 */       return (containsTypeVariables(getImplicitLowerBounds(wildcardType)[0]) || 
/* 1449 */         containsTypeVariables(getImplicitUpperBounds(wildcardType)[0]));
/*      */     } 
/* 1451 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final ParameterizedType parameterize(Class<?> paramClass, Type... paramVarArgs) {
/* 1463 */     return parameterizeWithOwner((Type)null, paramClass, paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final ParameterizedType parameterize(Class<?> paramClass, Map<TypeVariable<?>, Type> paramMap) {
/* 1476 */     Validate.notNull(paramClass, "raw class is null", new Object[0]);
/* 1477 */     Validate.notNull(paramMap, "typeArgMappings is null", new Object[0]);
/* 1478 */     return parameterizeWithOwner((Type)null, paramClass, 
/* 1479 */         extractTypeArgumentsFrom(paramMap, (TypeVariable<?>[])paramClass.getTypeParameters()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final ParameterizedType parameterizeWithOwner(Type paramType, Class<?> paramClass, Type... paramVarArgs) {
/*      */     Type type;
/* 1494 */     Validate.notNull(paramClass, "raw class is null", new Object[0]);
/*      */     
/* 1496 */     if (paramClass.getEnclosingClass() == null) {
/* 1497 */       Validate.isTrue((paramType == null), "no owner allowed for top-level %s", new Object[] { paramClass });
/* 1498 */       type = null;
/* 1499 */     } else if (paramType == null) {
/* 1500 */       type = paramClass.getEnclosingClass();
/*      */     } else {
/* 1502 */       Validate.isTrue(isAssignable(paramType, paramClass.getEnclosingClass()), "%s is invalid owner type for parameterized %s", new Object[] { paramType, paramClass });
/*      */       
/* 1504 */       type = paramType;
/*      */     } 
/* 1506 */     Validate.noNullElements((Object[])paramVarArgs, "null type argument at index %s", new Object[0]);
/* 1507 */     Validate.isTrue(((paramClass.getTypeParameters()).length == paramVarArgs.length), "invalid number of type parameters specified: expected %d, got %d", new Object[] {
/* 1508 */           Integer.valueOf((paramClass.getTypeParameters()).length), 
/* 1509 */           Integer.valueOf(paramVarArgs.length)
/*      */         });
/* 1511 */     return new ParameterizedTypeImpl(paramClass, type, paramVarArgs);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final ParameterizedType parameterizeWithOwner(Type paramType, Class<?> paramClass, Map<TypeVariable<?>, Type> paramMap) {
/* 1525 */     Validate.notNull(paramClass, "raw class is null", new Object[0]);
/* 1526 */     Validate.notNull(paramMap, "typeArgMappings is null", new Object[0]);
/* 1527 */     return parameterizeWithOwner(paramType, paramClass, 
/* 1528 */         extractTypeArgumentsFrom(paramMap, (TypeVariable<?>[])paramClass.getTypeParameters()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static Type[] extractTypeArgumentsFrom(Map<TypeVariable<?>, Type> paramMap, TypeVariable<?>[] paramArrayOfTypeVariable) {
/* 1538 */     Type[] arrayOfType = new Type[paramArrayOfTypeVariable.length];
/* 1539 */     byte b = 0;
/* 1540 */     for (TypeVariable<?> typeVariable : paramArrayOfTypeVariable) {
/* 1541 */       Validate.isTrue(paramMap.containsKey(typeVariable), "missing argument mapping for %s", new Object[] { toString(typeVariable) });
/* 1542 */       arrayOfType[b++] = paramMap.get(typeVariable);
/*      */     } 
/* 1544 */     return arrayOfType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static WildcardTypeBuilder wildcardType() {
/* 1553 */     return new WildcardTypeBuilder();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static GenericArrayType genericArrayType(Type paramType) {
/* 1565 */     return new GenericArrayTypeImpl((Type)Validate.notNull(paramType, "componentType is null", new Object[0]));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean equals(Type paramType1, Type paramType2) {
/* 1577 */     if (Objects.equals(paramType1, paramType2)) {
/* 1578 */       return true;
/*      */     }
/* 1580 */     if (paramType1 instanceof ParameterizedType) {
/* 1581 */       return equals((ParameterizedType)paramType1, paramType2);
/*      */     }
/* 1583 */     if (paramType1 instanceof GenericArrayType) {
/* 1584 */       return equals((GenericArrayType)paramType1, paramType2);
/*      */     }
/* 1586 */     if (paramType1 instanceof WildcardType) {
/* 1587 */       return equals((WildcardType)paramType1, paramType2);
/*      */     }
/* 1589 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean equals(ParameterizedType paramParameterizedType, Type paramType) {
/* 1600 */     if (paramType instanceof ParameterizedType) {
/* 1601 */       ParameterizedType parameterizedType = (ParameterizedType)paramType;
/* 1602 */       if (equals(paramParameterizedType.getRawType(), parameterizedType.getRawType()) && 
/* 1603 */         equals(paramParameterizedType.getOwnerType(), parameterizedType.getOwnerType())) {
/* 1604 */         return equals(paramParameterizedType.getActualTypeArguments(), parameterizedType.getActualTypeArguments());
/*      */       }
/*      */     } 
/* 1607 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean equals(GenericArrayType paramGenericArrayType, Type paramType) {
/* 1618 */     return (paramType instanceof GenericArrayType && 
/* 1619 */       equals(paramGenericArrayType.getGenericComponentType(), ((GenericArrayType)paramType).getGenericComponentType()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean equals(WildcardType paramWildcardType, Type paramType) {
/* 1630 */     if (paramType instanceof WildcardType) {
/* 1631 */       WildcardType wildcardType = (WildcardType)paramType;
/* 1632 */       return (equals(getImplicitLowerBounds(paramWildcardType), getImplicitLowerBounds(wildcardType)) && 
/* 1633 */         equals(getImplicitUpperBounds(paramWildcardType), getImplicitUpperBounds(wildcardType)));
/*      */     } 
/* 1635 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean equals(Type[] paramArrayOfType1, Type[] paramArrayOfType2) {
/* 1646 */     if (paramArrayOfType1.length == paramArrayOfType2.length) {
/* 1647 */       for (byte b = 0; b < paramArrayOfType1.length; b++) {
/* 1648 */         if (!equals(paramArrayOfType1[b], paramArrayOfType2[b])) {
/* 1649 */           return false;
/*      */         }
/*      */       } 
/* 1652 */       return true;
/*      */     } 
/* 1654 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(Type paramType) {
/* 1665 */     Validate.notNull(paramType);
/* 1666 */     if (paramType instanceof Class) {
/* 1667 */       return classToString((Class)paramType);
/*      */     }
/* 1669 */     if (paramType instanceof ParameterizedType) {
/* 1670 */       return parameterizedTypeToString((ParameterizedType)paramType);
/*      */     }
/* 1672 */     if (paramType instanceof WildcardType) {
/* 1673 */       return wildcardTypeToString((WildcardType)paramType);
/*      */     }
/* 1675 */     if (paramType instanceof TypeVariable) {
/* 1676 */       return typeVariableToString((TypeVariable)paramType);
/*      */     }
/* 1678 */     if (paramType instanceof GenericArrayType) {
/* 1679 */       return genericArrayTypeToString((GenericArrayType)paramType);
/*      */     }
/* 1681 */     throw new IllegalArgumentException(ObjectUtils.identityToString(paramType));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toLongString(TypeVariable<?> paramTypeVariable) {
/* 1692 */     Validate.notNull(paramTypeVariable, "var is null", new Object[0]);
/* 1693 */     StringBuilder stringBuilder = new StringBuilder();
/* 1694 */     Object object = paramTypeVariable.getGenericDeclaration();
/* 1695 */     if (object instanceof Class) {
/* 1696 */       Class<?> clazz = (Class)object;
/*      */       while (true) {
/* 1698 */         if (clazz.getEnclosingClass() == null) {
/* 1699 */           stringBuilder.insert(0, clazz.getName());
/*      */           break;
/*      */         } 
/* 1702 */         stringBuilder.insert(0, clazz.getSimpleName()).insert(0, '.');
/* 1703 */         clazz = clazz.getEnclosingClass();
/*      */       } 
/* 1705 */     } else if (object instanceof Type) {
/* 1706 */       stringBuilder.append(toString((Type)object));
/*      */     } else {
/* 1708 */       stringBuilder.append(object);
/*      */     } 
/* 1710 */     return stringBuilder.append(':').append(typeVariableToString(paramTypeVariable)).toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> Typed<T> wrap(Type paramType) {
/* 1722 */     return () -> paramType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T> Typed<T> wrap(Class<T> paramClass) {
/* 1734 */     return wrap(paramClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String classToString(Class<?> paramClass) {
/* 1744 */     if (paramClass.isArray()) {
/* 1745 */       return toString(paramClass.getComponentType()) + "[]";
/*      */     }
/*      */     
/* 1748 */     StringBuilder stringBuilder = new StringBuilder();
/*      */     
/* 1750 */     if (paramClass.getEnclosingClass() != null) {
/* 1751 */       stringBuilder.append(classToString(paramClass.getEnclosingClass())).append('.').append(paramClass.getSimpleName());
/*      */     } else {
/* 1753 */       stringBuilder.append(paramClass.getName());
/*      */     } 
/* 1755 */     if ((paramClass.getTypeParameters()).length > 0) {
/* 1756 */       stringBuilder.append('<');
/* 1757 */       appendAllTo(stringBuilder, ", ", (Object[])paramClass.getTypeParameters());
/* 1758 */       stringBuilder.append('>');
/*      */     } 
/* 1760 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String typeVariableToString(TypeVariable<?> paramTypeVariable) {
/* 1770 */     StringBuilder stringBuilder = new StringBuilder(paramTypeVariable.getName());
/* 1771 */     Type[] arrayOfType = paramTypeVariable.getBounds();
/* 1772 */     if (arrayOfType.length > 0 && (arrayOfType.length != 1 || !Object.class.equals(arrayOfType[0]))) {
/* 1773 */       stringBuilder.append(" extends ");
/* 1774 */       appendAllTo(stringBuilder, " & ", paramTypeVariable.getBounds());
/*      */     } 
/* 1776 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String parameterizedTypeToString(ParameterizedType paramParameterizedType) {
/* 1786 */     StringBuilder stringBuilder = new StringBuilder();
/*      */     
/* 1788 */     Type type = paramParameterizedType.getOwnerType();
/* 1789 */     Class clazz = (Class)paramParameterizedType.getRawType();
/*      */     
/* 1791 */     if (type == null) {
/* 1792 */       stringBuilder.append(clazz.getName());
/*      */     } else {
/* 1794 */       if (type instanceof Class) {
/* 1795 */         stringBuilder.append(((Class)type).getName());
/*      */       } else {
/* 1797 */         stringBuilder.append(type.toString());
/*      */       } 
/* 1799 */       stringBuilder.append('.').append(clazz.getSimpleName());
/*      */     } 
/*      */     
/* 1802 */     int[] arrayOfInt = findRecursiveTypes(paramParameterizedType);
/*      */     
/* 1804 */     if (arrayOfInt.length > 0) {
/* 1805 */       appendRecursiveTypes(stringBuilder, arrayOfInt, paramParameterizedType.getActualTypeArguments());
/*      */     } else {
/* 1807 */       appendAllTo(stringBuilder.append('<'), ", ", paramParameterizedType.getActualTypeArguments()).append('>');
/*      */     } 
/*      */     
/* 1810 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   private static void appendRecursiveTypes(StringBuilder paramStringBuilder, int[] paramArrayOfint, Type[] paramArrayOfType) {
/* 1815 */     for (byte b = 0; b < paramArrayOfint.length; b++) {
/* 1816 */       appendAllTo(paramStringBuilder.append('<'), ", ", new String[] { paramArrayOfType[b].toString() }).append('>');
/*      */     } 
/*      */     
/* 1819 */     Type[] arrayOfType = (Type[])ArrayUtils.removeAll((Object[])paramArrayOfType, paramArrayOfint);
/*      */     
/* 1821 */     if (arrayOfType.length > 0) {
/* 1822 */       appendAllTo(paramStringBuilder.append('<'), ", ", arrayOfType).append('>');
/*      */     }
/*      */   }
/*      */   
/*      */   private static int[] findRecursiveTypes(ParameterizedType paramParameterizedType) {
/* 1827 */     Type[] arrayOfType = Arrays.<Type>copyOf(paramParameterizedType.getActualTypeArguments(), (paramParameterizedType
/* 1828 */         .getActualTypeArguments()).length);
/* 1829 */     int[] arrayOfInt = new int[0];
/* 1830 */     for (byte b = 0; b < arrayOfType.length; b++) {
/* 1831 */       if (arrayOfType[b] instanceof TypeVariable && 
/* 1832 */         containsVariableTypeSameParametrizedTypeBound((TypeVariable)arrayOfType[b], paramParameterizedType))
/*      */       {
/* 1834 */         arrayOfInt = ArrayUtils.add(arrayOfInt, b);
/*      */       }
/*      */     } 
/*      */     
/* 1838 */     return arrayOfInt;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean containsVariableTypeSameParametrizedTypeBound(TypeVariable<?> paramTypeVariable, ParameterizedType paramParameterizedType) {
/* 1843 */     return ArrayUtils.contains((Object[])paramTypeVariable.getBounds(), paramParameterizedType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String wildcardTypeToString(WildcardType paramWildcardType) {
/* 1853 */     StringBuilder stringBuilder = (new StringBuilder()).append('?');
/* 1854 */     Type[] arrayOfType1 = paramWildcardType.getLowerBounds();
/* 1855 */     Type[] arrayOfType2 = paramWildcardType.getUpperBounds();
/* 1856 */     if (arrayOfType1.length > 1 || (arrayOfType1.length == 1 && arrayOfType1[0] != null)) {
/* 1857 */       appendAllTo(stringBuilder.append(" super "), " & ", arrayOfType1);
/* 1858 */     } else if (arrayOfType2.length > 1 || (arrayOfType2.length == 1 && !Object.class.equals(arrayOfType2[0]))) {
/* 1859 */       appendAllTo(stringBuilder.append(" extends "), " & ", arrayOfType2);
/*      */     } 
/* 1861 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String genericArrayTypeToString(GenericArrayType paramGenericArrayType) {
/* 1871 */     return String.format("%s[]", new Object[] { toString(paramGenericArrayType.getGenericComponentType()) });
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static <T> StringBuilder appendAllTo(StringBuilder paramStringBuilder, String paramString, T... paramVarArgs) {
/* 1884 */     Validate.notEmpty(Validate.noNullElements((Object[])paramVarArgs));
/* 1885 */     if (paramVarArgs.length > 0) {
/* 1886 */       paramStringBuilder.append(toString(paramVarArgs[0]));
/* 1887 */       for (byte b = 1; b < paramVarArgs.length; b++) {
/* 1888 */         paramStringBuilder.append(paramString).append(toString(paramVarArgs[b]));
/*      */       }
/*      */     } 
/* 1891 */     return paramStringBuilder;
/*      */   }
/*      */   
/*      */   private static <T> String toString(T paramT) {
/* 1895 */     return (paramT instanceof Type) ? toString((Type)paramT) : paramT.toString();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\reflect\TypeUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */