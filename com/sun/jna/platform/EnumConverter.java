/*    */ package com.sun.jna.platform;
/*    */ 
/*    */ import com.sun.jna.FromNativeContext;
/*    */ import com.sun.jna.ToNativeContext;
/*    */ import com.sun.jna.TypeConverter;
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
/*    */ public class EnumConverter<T extends Enum<T>>
/*    */   implements TypeConverter
/*    */ {
/*    */   private final Class<T> clazz;
/*    */   
/*    */   public EnumConverter(Class<T> paramClass) {
/* 47 */     this.clazz = paramClass;
/*    */   }
/*    */ 
/*    */   
/*    */   public T fromNative(Object paramObject, FromNativeContext paramFromNativeContext) {
/* 52 */     Integer integer = (Integer)paramObject;
/*    */     
/* 54 */     Enum[] arrayOfEnum = (Enum[])this.clazz.getEnumConstants();
/* 55 */     return (T)arrayOfEnum[integer.intValue()];
/*    */   }
/*    */ 
/*    */   
/*    */   public Integer toNative(Object paramObject, ToNativeContext paramToNativeContext) {
/* 60 */     Enum enum_ = (Enum)this.clazz.cast(paramObject);
/*    */     
/* 62 */     return Integer.valueOf(enum_.ordinal());
/*    */   }
/*    */ 
/*    */   
/*    */   public Class<Integer> nativeType() {
/* 67 */     return Integer.class;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\EnumConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */