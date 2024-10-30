/*     */ package org.apache.commons.lang3;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.ObjectStreamClass;
/*     */ import java.io.OutputStream;
/*     */ import java.io.Serializable;
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
/*     */ public class SerializationUtils
/*     */ {
/*     */   public static <T extends Serializable> T clone(T paramT) {
/*  78 */     if (paramT == null) {
/*  79 */       return null;
/*     */     }
/*  81 */     byte[] arrayOfByte = serialize((Serializable)paramT);
/*  82 */     ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
/*     */     
/*  84 */     try (ClassLoaderAwareObjectInputStream null = new ClassLoaderAwareObjectInputStream(byteArrayInputStream, paramT
/*  85 */           .getClass().getClassLoader())) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  92 */       Serializable serializable = (Serializable)classLoaderAwareObjectInputStream.readObject();
/*  93 */       return (T)serializable;
/*     */     }
/*  95 */     catch (ClassNotFoundException classNotFoundException) {
/*  96 */       throw new SerializationException("ClassNotFoundException while reading cloned object data", classNotFoundException);
/*  97 */     } catch (IOException iOException) {
/*  98 */       throw new SerializationException("IOException while reading or closing cloned object data", iOException);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends Serializable> T roundtrip(T paramT) {
/* 115 */     return (T)deserialize(serialize((Serializable)paramT));
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
/*     */   public static void serialize(Serializable paramSerializable, OutputStream paramOutputStream) {
/* 136 */     Validate.notNull(paramOutputStream, "The OutputStream must not be null", new Object[0]);
/* 137 */     try (ObjectOutputStream null = new ObjectOutputStream(paramOutputStream)) {
/* 138 */       objectOutputStream.writeObject(paramSerializable);
/* 139 */     } catch (IOException iOException) {
/* 140 */       throw new SerializationException(iOException);
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
/*     */   
/*     */   public static byte[] serialize(Serializable paramSerializable) {
/* 153 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
/* 154 */     serialize(paramSerializable, byteArrayOutputStream);
/* 155 */     return byteArrayOutputStream.toByteArray();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> T deserialize(InputStream paramInputStream) {
/* 189 */     Validate.notNull(paramInputStream, "The InputStream must not be null", new Object[0]);
/* 190 */     try (ObjectInputStream null = new ObjectInputStream(paramInputStream)) {
/*     */       
/* 192 */       Object object = objectInputStream.readObject();
/* 193 */       return (T)object;
/* 194 */     } catch (ClassNotFoundException|IOException classNotFoundException) {
/* 195 */       throw new SerializationException(classNotFoundException);
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
/*     */   public static <T> T deserialize(byte[] paramArrayOfbyte) {
/* 218 */     Validate.notNull(paramArrayOfbyte, "The byte[] must not be null", new Object[0]);
/* 219 */     return deserialize(new ByteArrayInputStream(paramArrayOfbyte));
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
/*     */   static class ClassLoaderAwareObjectInputStream
/*     */     extends ObjectInputStream
/*     */   {
/* 236 */     private static final Map<String, Class<?>> primitiveTypes = new HashMap<>();
/*     */     private final ClassLoader classLoader;
/*     */     
/*     */     static {
/* 240 */       primitiveTypes.put("byte", byte.class);
/* 241 */       primitiveTypes.put("short", short.class);
/* 242 */       primitiveTypes.put("int", int.class);
/* 243 */       primitiveTypes.put("long", long.class);
/* 244 */       primitiveTypes.put("float", float.class);
/* 245 */       primitiveTypes.put("double", double.class);
/* 246 */       primitiveTypes.put("boolean", boolean.class);
/* 247 */       primitiveTypes.put("char", char.class);
/* 248 */       primitiveTypes.put("void", void.class);
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
/*     */     
/*     */     ClassLoaderAwareObjectInputStream(InputStream param1InputStream, ClassLoader param1ClassLoader) throws IOException {
/* 261 */       super(param1InputStream);
/* 262 */       this.classLoader = param1ClassLoader;
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
/*     */     
/*     */     protected Class<?> resolveClass(ObjectStreamClass param1ObjectStreamClass) throws IOException, ClassNotFoundException {
/* 275 */       String str = param1ObjectStreamClass.getName();
/*     */       try {
/* 277 */         return Class.forName(str, false, this.classLoader);
/* 278 */       } catch (ClassNotFoundException classNotFoundException) {
/*     */         try {
/* 280 */           return Class.forName(str, false, Thread.currentThread().getContextClassLoader());
/* 281 */         } catch (ClassNotFoundException classNotFoundException1) {
/* 282 */           Class<?> clazz = primitiveTypes.get(str);
/* 283 */           if (clazz != null) {
/* 284 */             return clazz;
/*     */           }
/* 286 */           throw classNotFoundException1;
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\SerializationUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */