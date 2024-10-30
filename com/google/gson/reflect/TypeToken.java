/*     */ package com.google.gson.reflect;
/*     */ 
/*     */ import com.google.gson.internal.;
/*     */ import java.lang.reflect.GenericArrayType;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Type;
/*     */ import java.lang.reflect.TypeVariable;
/*     */ import java.util.HashMap;
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
/*     */ public class TypeToken<T>
/*     */ {
/*     */   final Class<? super T> rawType;
/*     */   final Type type;
/*     */   final int hashCode;
/*     */   
/*     */   protected TypeToken() {
/*  62 */     this.type = getSuperclassTypeParameter(getClass());
/*  63 */     this.rawType = .Gson.Types.getRawType(this.type);
/*  64 */     this.hashCode = this.type.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   TypeToken(Type paramType) {
/*  72 */     this.type = .Gson.Types.canonicalize((Type).Gson.Preconditions.checkNotNull(paramType));
/*  73 */     this.rawType = .Gson.Types.getRawType(this.type);
/*  74 */     this.hashCode = this.type.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Type getSuperclassTypeParameter(Class<?> paramClass) {
/*  82 */     Type type = paramClass.getGenericSuperclass();
/*  83 */     if (type instanceof Class) {
/*  84 */       throw new RuntimeException("Missing type parameter.");
/*     */     }
/*  86 */     ParameterizedType parameterizedType = (ParameterizedType)type;
/*  87 */     return .Gson.Types.canonicalize(parameterizedType.getActualTypeArguments()[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Class<? super T> getRawType() {
/*  94 */     return this.rawType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final Type getType() {
/* 101 */     return this.type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public boolean isAssignableFrom(Class<?> paramClass) {
/* 112 */     return isAssignableFrom(paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public boolean isAssignableFrom(Type paramType) {
/* 123 */     if (paramType == null) {
/* 124 */       return false;
/*     */     }
/*     */     
/* 127 */     if (this.type.equals(paramType)) {
/* 128 */       return true;
/*     */     }
/*     */     
/* 131 */     if (this.type instanceof Class)
/* 132 */       return this.rawType.isAssignableFrom(.Gson.Types.getRawType(paramType)); 
/* 133 */     if (this.type instanceof ParameterizedType) {
/* 134 */       return isAssignableFrom(paramType, (ParameterizedType)this.type, new HashMap<String, Type>());
/*     */     }
/* 136 */     if (this.type instanceof GenericArrayType) {
/* 137 */       return (this.rawType.isAssignableFrom(.Gson.Types.getRawType(paramType)) && 
/* 138 */         isAssignableFrom(paramType, (GenericArrayType)this.type));
/*     */     }
/* 140 */     throw buildUnexpectedTypeError(this.type, new Class[] { Class.class, ParameterizedType.class, GenericArrayType.class });
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
/*     */   @Deprecated
/*     */   public boolean isAssignableFrom(TypeToken<?> paramTypeToken) {
/* 153 */     return isAssignableFrom(paramTypeToken.getType());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isAssignableFrom(Type<?> paramType, GenericArrayType paramGenericArrayType) {
/* 161 */     Type type = paramGenericArrayType.getGenericComponentType();
/* 162 */     if (type instanceof ParameterizedType) {
/* 163 */       Type<?> type1 = paramType;
/* 164 */       if (paramType instanceof GenericArrayType) {
/* 165 */         type1 = ((GenericArrayType)paramType).getGenericComponentType();
/* 166 */       } else if (paramType instanceof Class) {
/* 167 */         Class<?> clazz = (Class)paramType;
/* 168 */         while (clazz.isArray()) {
/* 169 */           clazz = clazz.getComponentType();
/*     */         }
/* 171 */         type1 = clazz;
/*     */       } 
/* 173 */       return isAssignableFrom(type1, (ParameterizedType)type, new HashMap<String, Type>());
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 178 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isAssignableFrom(Type paramType, ParameterizedType paramParameterizedType, Map<String, Type> paramMap) {
/* 188 */     if (paramType == null) {
/* 189 */       return false;
/*     */     }
/*     */     
/* 192 */     if (paramParameterizedType.equals(paramType)) {
/* 193 */       return true;
/*     */     }
/*     */ 
/*     */     
/* 197 */     Class clazz = .Gson.Types.getRawType(paramType);
/* 198 */     ParameterizedType parameterizedType = null;
/* 199 */     if (paramType instanceof ParameterizedType) {
/* 200 */       parameterizedType = (ParameterizedType)paramType;
/*     */     }
/*     */ 
/*     */     
/* 204 */     if (parameterizedType != null) {
/* 205 */       Type[] arrayOfType = parameterizedType.getActualTypeArguments();
/* 206 */       TypeVariable[] arrayOfTypeVariable = clazz.getTypeParameters();
/* 207 */       for (byte b = 0; b < arrayOfType.length; b++) {
/* 208 */         Type type1 = arrayOfType[b];
/* 209 */         TypeVariable typeVariable = arrayOfTypeVariable[b];
/* 210 */         while (type1 instanceof TypeVariable) {
/* 211 */           TypeVariable typeVariable1 = (TypeVariable)type1;
/* 212 */           type1 = paramMap.get(typeVariable1.getName());
/*     */         } 
/* 214 */         paramMap.put(typeVariable.getName(), type1);
/*     */       } 
/*     */ 
/*     */       
/* 218 */       if (typeEquals(parameterizedType, paramParameterizedType, paramMap)) {
/* 219 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 223 */     for (Type type1 : clazz.getGenericInterfaces()) {
/* 224 */       if (isAssignableFrom(type1, paramParameterizedType, new HashMap<String, Type>(paramMap))) {
/* 225 */         return true;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 230 */     Type type = clazz.getGenericSuperclass();
/* 231 */     return isAssignableFrom(type, paramParameterizedType, new HashMap<String, Type>(paramMap));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean typeEquals(ParameterizedType paramParameterizedType1, ParameterizedType paramParameterizedType2, Map<String, Type> paramMap) {
/* 240 */     if (paramParameterizedType1.getRawType().equals(paramParameterizedType2.getRawType())) {
/* 241 */       Type[] arrayOfType1 = paramParameterizedType1.getActualTypeArguments();
/* 242 */       Type[] arrayOfType2 = paramParameterizedType2.getActualTypeArguments();
/* 243 */       for (byte b = 0; b < arrayOfType1.length; b++) {
/* 244 */         if (!matches(arrayOfType1[b], arrayOfType2[b], paramMap)) {
/* 245 */           return false;
/*     */         }
/*     */       } 
/* 248 */       return true;
/*     */     } 
/* 250 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static AssertionError buildUnexpectedTypeError(Type paramType, Class<?>... paramVarArgs) {
/* 257 */     StringBuilder stringBuilder = new StringBuilder("Unexpected type. Expected one of: ");
/*     */     
/* 259 */     for (Class<?> clazz : paramVarArgs) {
/* 260 */       stringBuilder.append(clazz.getName()).append(", ");
/*     */     }
/* 262 */     stringBuilder.append("but got: ").append(paramType.getClass().getName())
/* 263 */       .append(", for type token: ").append(paramType.toString()).append('.');
/*     */     
/* 265 */     return new AssertionError(stringBuilder.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean matches(Type paramType1, Type paramType2, Map<String, Type> paramMap) {
/* 273 */     return (paramType2.equals(paramType1) || (paramType1 instanceof TypeVariable && paramType2
/*     */       
/* 275 */       .equals(paramMap.get(((TypeVariable)paramType1).getName()))));
/*     */   }
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 280 */     return this.hashCode;
/*     */   }
/*     */   
/*     */   public final boolean equals(Object paramObject) {
/* 284 */     return (paramObject instanceof TypeToken && 
/* 285 */       .Gson.Types.equals(this.type, ((TypeToken)paramObject).type));
/*     */   }
/*     */   
/*     */   public final String toString() {
/* 289 */     return .Gson.Types.typeToString(this.type);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeToken<?> get(Type paramType) {
/* 296 */     return new TypeToken(paramType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> TypeToken<T> get(Class<T> paramClass) {
/* 303 */     return new TypeToken<T>(paramClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeToken<?> getParameterized(Type paramType, Type... paramVarArgs) {
/* 311 */     return new TypeToken(.Gson.Types.newParameterizedTypeWithOwner(null, paramType, paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeToken<?> getArray(Type paramType) {
/* 318 */     return new TypeToken(.Gson.Types.arrayOf(paramType));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\reflect\TypeToken.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */