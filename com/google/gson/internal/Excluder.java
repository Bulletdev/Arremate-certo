/*     */ package com.google.gson.internal;
/*     */ 
/*     */ import com.google.gson.ExclusionStrategy;
/*     */ import com.google.gson.FieldAttributes;
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.TypeAdapter;
/*     */ import com.google.gson.TypeAdapterFactory;
/*     */ import com.google.gson.annotations.Expose;
/*     */ import com.google.gson.annotations.Since;
/*     */ import com.google.gson.annotations.Until;
/*     */ import com.google.gson.reflect.TypeToken;
/*     */ import com.google.gson.stream.JsonReader;
/*     */ import com.google.gson.stream.JsonWriter;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Excluder
/*     */   implements TypeAdapterFactory, Cloneable
/*     */ {
/*     */   private static final double IGNORE_VERSIONS = -1.0D;
/*  52 */   public static final Excluder DEFAULT = new Excluder();
/*     */   
/*  54 */   private double version = -1.0D;
/*  55 */   private int modifiers = 136;
/*     */   private boolean serializeInnerClasses = true;
/*     */   private boolean requireExpose;
/*  58 */   private List<ExclusionStrategy> serializationStrategies = Collections.emptyList();
/*  59 */   private List<ExclusionStrategy> deserializationStrategies = Collections.emptyList();
/*     */   
/*     */   protected Excluder clone() {
/*     */     try {
/*  63 */       return (Excluder)super.clone();
/*  64 */     } catch (CloneNotSupportedException cloneNotSupportedException) {
/*  65 */       throw new AssertionError(cloneNotSupportedException);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Excluder withVersion(double paramDouble) {
/*  70 */     Excluder excluder = clone();
/*  71 */     excluder.version = paramDouble;
/*  72 */     return excluder;
/*     */   }
/*     */   
/*     */   public Excluder withModifiers(int... paramVarArgs) {
/*  76 */     Excluder excluder = clone();
/*  77 */     excluder.modifiers = 0;
/*  78 */     for (int i : paramVarArgs) {
/*  79 */       excluder.modifiers |= i;
/*     */     }
/*  81 */     return excluder;
/*     */   }
/*     */   
/*     */   public Excluder disableInnerClassSerialization() {
/*  85 */     Excluder excluder = clone();
/*  86 */     excluder.serializeInnerClasses = false;
/*  87 */     return excluder;
/*     */   }
/*     */   
/*     */   public Excluder excludeFieldsWithoutExposeAnnotation() {
/*  91 */     Excluder excluder = clone();
/*  92 */     excluder.requireExpose = true;
/*  93 */     return excluder;
/*     */   }
/*     */ 
/*     */   
/*     */   public Excluder withExclusionStrategy(ExclusionStrategy paramExclusionStrategy, boolean paramBoolean1, boolean paramBoolean2) {
/*  98 */     Excluder excluder = clone();
/*  99 */     if (paramBoolean1) {
/* 100 */       excluder.serializationStrategies = new ArrayList<ExclusionStrategy>(this.serializationStrategies);
/* 101 */       excluder.serializationStrategies.add(paramExclusionStrategy);
/*     */     } 
/* 103 */     if (paramBoolean2) {
/* 104 */       excluder.deserializationStrategies = new ArrayList<ExclusionStrategy>(this.deserializationStrategies);
/*     */       
/* 106 */       excluder.deserializationStrategies.add(paramExclusionStrategy);
/*     */     } 
/* 108 */     return excluder;
/*     */   }
/*     */   
/*     */   public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> type) {
/* 112 */     Class<?> clazz = type.getRawType();
/* 113 */     boolean bool = excludeClassChecks(clazz);
/*     */     
/* 115 */     final boolean skipSerialize = (bool || excludeClassInStrategy(clazz, true)) ? true : false;
/* 116 */     final boolean skipDeserialize = (bool || excludeClassInStrategy(clazz, false)) ? true : false;
/*     */     
/* 118 */     if (!bool1 && !bool2) {
/* 119 */       return null;
/*     */     }
/*     */     
/* 122 */     return new TypeAdapter<T>()
/*     */       {
/*     */         private TypeAdapter<T> delegate;
/*     */         
/*     */         public T read(JsonReader param1JsonReader) throws IOException {
/* 127 */           if (skipDeserialize) {
/* 128 */             param1JsonReader.skipValue();
/* 129 */             return null;
/*     */           } 
/* 131 */           return (T)delegate().read(param1JsonReader);
/*     */         }
/*     */         
/*     */         public void write(JsonWriter param1JsonWriter, T param1T) throws IOException {
/* 135 */           if (skipSerialize) {
/* 136 */             param1JsonWriter.nullValue();
/*     */             return;
/*     */           } 
/* 139 */           delegate().write(param1JsonWriter, param1T);
/*     */         }
/*     */         
/*     */         private TypeAdapter<T> delegate() {
/* 143 */           TypeAdapter<T> typeAdapter = this.delegate;
/* 144 */           return (typeAdapter != null) ? typeAdapter : (this
/*     */             
/* 146 */             .delegate = gson.getDelegateAdapter(Excluder.this, type));
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public boolean excludeField(Field paramField, boolean paramBoolean) {
/* 152 */     if ((this.modifiers & paramField.getModifiers()) != 0) {
/* 153 */       return true;
/*     */     }
/*     */     
/* 156 */     if (this.version != -1.0D && 
/* 157 */       !isValidVersion(paramField.<Since>getAnnotation(Since.class), paramField.<Until>getAnnotation(Until.class))) {
/* 158 */       return true;
/*     */     }
/*     */     
/* 161 */     if (paramField.isSynthetic()) {
/* 162 */       return true;
/*     */     }
/*     */     
/* 165 */     if (this.requireExpose) {
/* 166 */       Expose expose = paramField.<Expose>getAnnotation(Expose.class);
/* 167 */       if (expose == null || (paramBoolean ? !expose.serialize() : !expose.deserialize())) {
/* 168 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 172 */     if (!this.serializeInnerClasses && isInnerClass(paramField.getType())) {
/* 173 */       return true;
/*     */     }
/*     */     
/* 176 */     if (isAnonymousOrLocal(paramField.getType())) {
/* 177 */       return true;
/*     */     }
/*     */     
/* 180 */     List<ExclusionStrategy> list = paramBoolean ? this.serializationStrategies : this.deserializationStrategies;
/* 181 */     if (!list.isEmpty()) {
/* 182 */       FieldAttributes fieldAttributes = new FieldAttributes(paramField);
/* 183 */       for (ExclusionStrategy exclusionStrategy : list) {
/* 184 */         if (exclusionStrategy.shouldSkipField(fieldAttributes)) {
/* 185 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 190 */     return false;
/*     */   }
/*     */   
/*     */   private boolean excludeClassChecks(Class<?> paramClass) {
/* 194 */     if (this.version != -1.0D && !isValidVersion(paramClass.<Since>getAnnotation(Since.class), paramClass.<Until>getAnnotation(Until.class))) {
/* 195 */       return true;
/*     */     }
/*     */     
/* 198 */     if (!this.serializeInnerClasses && isInnerClass(paramClass)) {
/* 199 */       return true;
/*     */     }
/*     */     
/* 202 */     if (isAnonymousOrLocal(paramClass)) {
/* 203 */       return true;
/*     */     }
/*     */     
/* 206 */     return false;
/*     */   }
/*     */   
/*     */   public boolean excludeClass(Class<?> paramClass, boolean paramBoolean) {
/* 210 */     return (excludeClassChecks(paramClass) || 
/* 211 */       excludeClassInStrategy(paramClass, paramBoolean));
/*     */   }
/*     */   
/*     */   private boolean excludeClassInStrategy(Class<?> paramClass, boolean paramBoolean) {
/* 215 */     List<ExclusionStrategy> list = paramBoolean ? this.serializationStrategies : this.deserializationStrategies;
/* 216 */     for (ExclusionStrategy exclusionStrategy : list) {
/* 217 */       if (exclusionStrategy.shouldSkipClass(paramClass)) {
/* 218 */         return true;
/*     */       }
/*     */     } 
/* 221 */     return false;
/*     */   }
/*     */   
/*     */   private boolean isAnonymousOrLocal(Class<?> paramClass) {
/* 225 */     return (!Enum.class.isAssignableFrom(paramClass) && (paramClass
/* 226 */       .isAnonymousClass() || paramClass.isLocalClass()));
/*     */   }
/*     */   
/*     */   private boolean isInnerClass(Class<?> paramClass) {
/* 230 */     return (paramClass.isMemberClass() && !isStatic(paramClass));
/*     */   }
/*     */   
/*     */   private boolean isStatic(Class<?> paramClass) {
/* 234 */     return ((paramClass.getModifiers() & 0x8) != 0);
/*     */   }
/*     */   
/*     */   private boolean isValidVersion(Since paramSince, Until paramUntil) {
/* 238 */     return (isValidSince(paramSince) && isValidUntil(paramUntil));
/*     */   }
/*     */   
/*     */   private boolean isValidSince(Since paramSince) {
/* 242 */     if (paramSince != null) {
/* 243 */       double d = paramSince.value();
/* 244 */       if (d > this.version) {
/* 245 */         return false;
/*     */       }
/*     */     } 
/* 248 */     return true;
/*     */   }
/*     */   
/*     */   private boolean isValidUntil(Until paramUntil) {
/* 252 */     if (paramUntil != null) {
/* 253 */       double d = paramUntil.value();
/* 254 */       if (d <= this.version) {
/* 255 */         return false;
/*     */       }
/*     */     } 
/* 258 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\Excluder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */