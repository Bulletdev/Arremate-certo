/*     */ package com.google.gson.internal;
/*     */ 
/*     */ import com.google.gson.InstanceCreator;
/*     */ import com.google.gson.JsonIOException;
/*     */ import com.google.gson.internal.reflect.ReflectionAccessor;
/*     */ import com.google.gson.reflect.TypeToken;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.ParameterizedType;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.EnumSet;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Queue;
/*     */ import java.util.Set;
/*     */ import java.util.SortedMap;
/*     */ import java.util.SortedSet;
/*     */ import java.util.TreeMap;
/*     */ import java.util.TreeSet;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ import java.util.concurrent.ConcurrentNavigableMap;
/*     */ import java.util.concurrent.ConcurrentSkipListMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ConstructorConstructor
/*     */ {
/*     */   private final Map<Type, InstanceCreator<?>> instanceCreators;
/*  51 */   private final ReflectionAccessor accessor = ReflectionAccessor.getInstance();
/*     */   
/*     */   public ConstructorConstructor(Map<Type, InstanceCreator<?>> paramMap) {
/*  54 */     this.instanceCreators = paramMap;
/*     */   }
/*     */   
/*     */   public <T> ObjectConstructor<T> get(TypeToken<T> paramTypeToken) {
/*  58 */     final Type type = paramTypeToken.getType();
/*  59 */     Class<?> clazz = paramTypeToken.getRawType();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  64 */     final InstanceCreator typeCreator = this.instanceCreators.get(type);
/*  65 */     if (instanceCreator1 != null) {
/*  66 */       return new ObjectConstructor<T>() {
/*     */           public T construct() {
/*  68 */             return (T)typeCreator.createInstance(type);
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  76 */     final InstanceCreator rawTypeCreator = this.instanceCreators.get(clazz);
/*  77 */     if (instanceCreator2 != null) {
/*  78 */       return new ObjectConstructor<T>() {
/*     */           public T construct() {
/*  80 */             return (T)rawTypeCreator.createInstance(type);
/*     */           }
/*     */         };
/*     */     }
/*     */     
/*  85 */     ObjectConstructor<?> objectConstructor1 = newDefaultConstructor(clazz);
/*  86 */     if (objectConstructor1 != null) {
/*  87 */       return (ObjectConstructor)objectConstructor1;
/*     */     }
/*     */     
/*  90 */     ObjectConstructor<?> objectConstructor2 = newDefaultImplementationConstructor(type, clazz);
/*  91 */     if (objectConstructor2 != null) {
/*  92 */       return (ObjectConstructor)objectConstructor2;
/*     */     }
/*     */ 
/*     */     
/*  96 */     return newUnsafeAllocator(type, (Class)clazz);
/*     */   }
/*     */   
/*     */   private <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> paramClass) {
/*     */     try {
/* 101 */       final Constructor<? super T> constructor = paramClass.getDeclaredConstructor(new Class[0]);
/* 102 */       if (!constructor.isAccessible()) {
/* 103 */         this.accessor.makeAccessible(constructor);
/*     */       }
/* 105 */       return new ObjectConstructor<T>()
/*     */         {
/*     */           public T construct() {
/*     */             try {
/* 109 */               Object[] arrayOfObject = null;
/* 110 */               return constructor.newInstance(arrayOfObject);
/* 111 */             } catch (InstantiationException instantiationException) {
/*     */               
/* 113 */               throw new RuntimeException("Failed to invoke " + constructor + " with no args", instantiationException);
/* 114 */             } catch (InvocationTargetException invocationTargetException) {
/*     */ 
/*     */               
/* 117 */               throw new RuntimeException("Failed to invoke " + constructor + " with no args", invocationTargetException
/* 118 */                   .getTargetException());
/* 119 */             } catch (IllegalAccessException illegalAccessException) {
/* 120 */               throw new AssertionError(illegalAccessException);
/*     */             } 
/*     */           }
/*     */         };
/* 124 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 125 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private <T> ObjectConstructor<T> newDefaultImplementationConstructor(final Type type, Class<? super T> paramClass) {
/* 136 */     if (Collection.class.isAssignableFrom(paramClass)) {
/* 137 */       if (SortedSet.class.isAssignableFrom(paramClass))
/* 138 */         return new ObjectConstructor<T>() {
/*     */             public T construct() {
/* 140 */               return (T)new TreeSet();
/*     */             }
/*     */           }; 
/* 143 */       if (EnumSet.class.isAssignableFrom(paramClass)) {
/* 144 */         return new ObjectConstructor<T>()
/*     */           {
/*     */             public T construct() {
/* 147 */               if (type instanceof ParameterizedType) {
/* 148 */                 Type type = ((ParameterizedType)type).getActualTypeArguments()[0];
/* 149 */                 if (type instanceof Class) {
/* 150 */                   return (T)EnumSet.noneOf((Class<Enum>)type);
/*     */                 }
/* 152 */                 throw new JsonIOException("Invalid EnumSet type: " + type.toString());
/*     */               } 
/*     */               
/* 155 */               throw new JsonIOException("Invalid EnumSet type: " + type.toString());
/*     */             }
/*     */           };
/*     */       }
/* 159 */       if (Set.class.isAssignableFrom(paramClass))
/* 160 */         return new ObjectConstructor<T>() {
/*     */             public T construct() {
/* 162 */               return (T)new LinkedHashSet();
/*     */             }
/*     */           }; 
/* 165 */       if (Queue.class.isAssignableFrom(paramClass)) {
/* 166 */         return new ObjectConstructor<T>() {
/*     */             public T construct() {
/* 168 */               return (T)new ArrayDeque();
/*     */             }
/*     */           };
/*     */       }
/* 172 */       return new ObjectConstructor<T>() {
/*     */           public T construct() {
/* 174 */             return (T)new ArrayList();
/*     */           }
/*     */         };
/*     */     } 
/*     */ 
/*     */     
/* 180 */     if (Map.class.isAssignableFrom(paramClass)) {
/* 181 */       if (ConcurrentNavigableMap.class.isAssignableFrom(paramClass))
/* 182 */         return new ObjectConstructor<T>() {
/*     */             public T construct() {
/* 184 */               return (T)new ConcurrentSkipListMap<Object, Object>();
/*     */             }
/*     */           }; 
/* 187 */       if (ConcurrentMap.class.isAssignableFrom(paramClass))
/* 188 */         return new ObjectConstructor<T>() {
/*     */             public T construct() {
/* 190 */               return (T)new ConcurrentHashMap<Object, Object>();
/*     */             }
/*     */           }; 
/* 193 */       if (SortedMap.class.isAssignableFrom(paramClass))
/* 194 */         return new ObjectConstructor<T>() {
/*     */             public T construct() {
/* 196 */               return (T)new TreeMap<Object, Object>();
/*     */             }
/*     */           }; 
/* 199 */       if (type instanceof ParameterizedType && !String.class.isAssignableFrom(
/* 200 */           TypeToken.get(((ParameterizedType)type).getActualTypeArguments()[0]).getRawType())) {
/* 201 */         return new ObjectConstructor<T>() {
/*     */             public T construct() {
/* 203 */               return (T)new LinkedHashMap<Object, Object>();
/*     */             }
/*     */           };
/*     */       }
/* 207 */       return new ObjectConstructor<T>() {
/*     */           public T construct() {
/* 209 */             return (T)new LinkedTreeMap<Object, Object>();
/*     */           }
/*     */         };
/*     */     } 
/*     */ 
/*     */     
/* 215 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private <T> ObjectConstructor<T> newUnsafeAllocator(final Type type, final Class<? super T> rawType) {
/* 220 */     return new ObjectConstructor<T>() {
/* 221 */         private final UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();
/*     */         
/*     */         public T construct() {
/*     */           try {
/* 225 */             return (T)this.unsafeAllocator.newInstance(rawType);
/*     */           }
/* 227 */           catch (Exception exception) {
/* 228 */             throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". Registering an InstanceCreator with Gson for this type may fix this problem.", exception);
/*     */           } 
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 236 */     return this.instanceCreators.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\ConstructorConstructor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */