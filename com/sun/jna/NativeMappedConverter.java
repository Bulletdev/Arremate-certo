/*    */ package com.sun.jna;
/*    */ 
/*    */ import java.lang.ref.Reference;
/*    */ import java.lang.ref.SoftReference;
/*    */ import java.util.Map;
/*    */ import java.util.WeakHashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NativeMappedConverter
/*    */   implements TypeConverter
/*    */ {
/* 34 */   private static final Map<Class<?>, Reference<NativeMappedConverter>> converters = new WeakHashMap<Class<?>, Reference<NativeMappedConverter>>();
/*    */   
/*    */   private final Class<?> type;
/*    */   private final Class<?> nativeType;
/*    */   private final NativeMapped instance;
/*    */   
/*    */   public static NativeMappedConverter getInstance(Class<?> paramClass) {
/* 41 */     synchronized (converters) {
/* 42 */       Reference<NativeMappedConverter> reference = converters.get(paramClass);
/* 43 */       NativeMappedConverter nativeMappedConverter = (reference != null) ? reference.get() : null;
/* 44 */       if (nativeMappedConverter == null) {
/* 45 */         nativeMappedConverter = new NativeMappedConverter(paramClass);
/* 46 */         converters.put(paramClass, new SoftReference<NativeMappedConverter>(nativeMappedConverter));
/*    */       } 
/* 48 */       return nativeMappedConverter;
/*    */     } 
/*    */   }
/*    */   
/*    */   public NativeMappedConverter(Class<?> paramClass) {
/* 53 */     if (!NativeMapped.class.isAssignableFrom(paramClass))
/* 54 */       throw new IllegalArgumentException("Type must derive from " + NativeMapped.class); 
/* 55 */     this.type = paramClass;
/* 56 */     this.instance = defaultValue();
/* 57 */     this.nativeType = this.instance.nativeType();
/*    */   }
/*    */   
/*    */   public NativeMapped defaultValue() {
/* 61 */     if (this.type.isEnum()) {
/* 62 */       return (NativeMapped)this.type.getEnumConstants()[0];
/*    */     }
/*    */     
/* 65 */     return (NativeMapped)Klass.newInstance(this.type);
/*    */   }
/*    */ 
/*    */   
/*    */   public Object fromNative(Object paramObject, FromNativeContext paramFromNativeContext) {
/* 70 */     return this.instance.fromNative(paramObject, paramFromNativeContext);
/*    */   }
/*    */ 
/*    */   
/*    */   public Class<?> nativeType() {
/* 75 */     return this.nativeType;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object toNative(Object paramObject, ToNativeContext paramToNativeContext) {
/* 80 */     if (paramObject == null) {
/* 81 */       if (Pointer.class.isAssignableFrom(this.nativeType)) {
/* 82 */         return null;
/*    */       }
/* 84 */       paramObject = defaultValue();
/*    */     } 
/* 86 */     return ((NativeMapped)paramObject).toNative();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\NativeMappedConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */