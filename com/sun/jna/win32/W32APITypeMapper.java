/*    */ package com.sun.jna.win32;
/*    */ 
/*    */ import com.sun.jna.DefaultTypeMapper;
/*    */ import com.sun.jna.FromNativeContext;
/*    */ import com.sun.jna.StringArray;
/*    */ import com.sun.jna.ToNativeContext;
/*    */ import com.sun.jna.ToNativeConverter;
/*    */ import com.sun.jna.TypeConverter;
/*    */ import com.sun.jna.TypeMapper;
/*    */ import com.sun.jna.WString;
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
/*    */ public class W32APITypeMapper
/*    */   extends DefaultTypeMapper
/*    */ {
/* 44 */   public static final TypeMapper UNICODE = (TypeMapper)new W32APITypeMapper(true);
/*    */   
/* 46 */   public static final TypeMapper ASCII = (TypeMapper)new W32APITypeMapper(false);
/*    */   
/* 48 */   public static final TypeMapper DEFAULT = Boolean.getBoolean("w32.ascii") ? ASCII : UNICODE;
/*    */   
/*    */   protected W32APITypeMapper(boolean paramBoolean) {
/* 51 */     if (paramBoolean) {
/* 52 */       TypeConverter typeConverter1 = new TypeConverter()
/*    */         {
/*    */           public Object toNative(Object param1Object, ToNativeContext param1ToNativeContext) {
/* 55 */             if (param1Object == null)
/* 56 */               return null; 
/* 57 */             if (param1Object instanceof String[]) {
/* 58 */               return new StringArray((String[])param1Object, true);
/*    */             }
/* 60 */             return new WString(param1Object.toString());
/*    */           }
/*    */           
/*    */           public Object fromNative(Object param1Object, FromNativeContext param1FromNativeContext) {
/* 64 */             if (param1Object == null)
/* 65 */               return null; 
/* 66 */             return param1Object.toString();
/*    */           }
/*    */           
/*    */           public Class<?> nativeType() {
/* 70 */             return WString.class;
/*    */           }
/*    */         };
/* 73 */       addTypeConverter(String.class, typeConverter1);
/* 74 */       addToNativeConverter(String[].class, (ToNativeConverter)typeConverter1);
/*    */     } 
/* 76 */     TypeConverter typeConverter = new TypeConverter()
/*    */       {
/*    */         public Object toNative(Object param1Object, ToNativeContext param1ToNativeContext) {
/* 79 */           return Integer.valueOf(Boolean.TRUE.equals(param1Object) ? 1 : 0);
/*    */         }
/*    */         
/*    */         public Object fromNative(Object param1Object, FromNativeContext param1FromNativeContext) {
/* 83 */           return (((Integer)param1Object).intValue() != 0) ? Boolean.TRUE : Boolean.FALSE;
/*    */         }
/*    */ 
/*    */         
/*    */         public Class<?> nativeType() {
/* 88 */           return Integer.class;
/*    */         }
/*    */       };
/* 91 */     addTypeConverter(Boolean.class, typeConverter);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\win32\W32APITypeMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */