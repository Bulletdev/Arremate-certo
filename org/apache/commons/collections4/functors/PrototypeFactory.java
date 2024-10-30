/*     */ package org.apache.commons.collections4.functors;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import org.apache.commons.collections4.Factory;
/*     */ import org.apache.commons.collections4.FunctorException;
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
/*     */ public class PrototypeFactory
/*     */ {
/*     */   public static <T> Factory<T> prototypeFactory(T paramT) {
/*  65 */     if (paramT == null) {
/*  66 */       return ConstantFactory.constantFactory(null);
/*     */     }
/*     */     try {
/*  69 */       Method method = paramT.getClass().getMethod("clone", (Class[])null);
/*  70 */       return new PrototypeCloneFactory<T>(paramT, method);
/*     */     }
/*  72 */     catch (NoSuchMethodException noSuchMethodException) {
/*     */       try {
/*  74 */         paramT.getClass().getConstructor(new Class[] { paramT.getClass() });
/*  75 */         return new InstantiateFactory<T>((Class)paramT.getClass(), new Class[] { paramT.getClass() }, new Object[] { paramT });
/*     */ 
/*     */       
/*     */       }
/*  79 */       catch (NoSuchMethodException noSuchMethodException1) {
/*  80 */         if (paramT instanceof Serializable) {
/*  81 */           return (Factory)new PrototypeSerializationFactory<Serializable>((Serializable)paramT);
/*     */         }
/*     */ 
/*     */         
/*  85 */         throw new IllegalArgumentException("The prototype must be cloneable via a public clone method");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class PrototypeCloneFactory<T>
/*     */     implements Factory<T>
/*     */   {
/*     */     private final T iPrototype;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private transient Method iCloneMethod;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private PrototypeCloneFactory(T param1T, Method param1Method) {
/* 112 */       this.iPrototype = param1T;
/* 113 */       this.iCloneMethod = param1Method;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void findCloneMethod() {
/*     */       try {
/* 121 */         this.iCloneMethod = this.iPrototype.getClass().getMethod("clone", (Class[])null);
/* 122 */       } catch (NoSuchMethodException noSuchMethodException) {
/* 123 */         throw new IllegalArgumentException("PrototypeCloneFactory: The clone method must exist and be public ");
/*     */       } 
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
/*     */     public T create() {
/* 136 */       if (this.iCloneMethod == null) {
/* 137 */         findCloneMethod();
/*     */       }
/*     */       
/*     */       try {
/* 141 */         return (T)this.iCloneMethod.invoke(this.iPrototype, (Object[])null);
/* 142 */       } catch (IllegalAccessException illegalAccessException) {
/* 143 */         throw new FunctorException("PrototypeCloneFactory: Clone method must be public", illegalAccessException);
/* 144 */       } catch (InvocationTargetException invocationTargetException) {
/* 145 */         throw new FunctorException("PrototypeCloneFactory: Clone method threw an exception", invocationTargetException);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class PrototypeSerializationFactory<T extends Serializable>
/*     */     implements Factory<T>
/*     */   {
/*     */     private final T iPrototype;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private PrototypeSerializationFactory(T param1T) {
/* 165 */       this.iPrototype = param1T;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public T create() {
/* 176 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
/* 177 */       ByteArrayInputStream byteArrayInputStream = null;
/*     */       try {
/* 179 */         ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
/* 180 */         objectOutputStream.writeObject(this.iPrototype);
/*     */         
/* 182 */         byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
/* 183 */         ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
/* 184 */         return (T)objectInputStream.readObject();
/*     */       }
/* 186 */       catch (ClassNotFoundException classNotFoundException) {
/* 187 */         throw new FunctorException(classNotFoundException);
/* 188 */       } catch (IOException iOException) {
/* 189 */         throw new FunctorException(iOException);
/*     */       } finally {
/*     */         try {
/* 192 */           if (byteArrayInputStream != null) {
/* 193 */             byteArrayInputStream.close();
/*     */           }
/* 195 */         } catch (IOException iOException) {}
/*     */ 
/*     */         
/*     */         try {
/* 199 */           byteArrayOutputStream.close();
/* 200 */         } catch (IOException iOException) {}
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\functors\PrototypeFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */