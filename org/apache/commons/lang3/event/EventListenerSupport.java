/*     */ package org.apache.commons.lang3.event;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.Array;
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Proxy;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import org.apache.commons.lang3.Validate;
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
/*     */ public class EventListenerSupport<L>
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 3593265990380473632L;
/*  79 */   private List<L> listeners = new CopyOnWriteArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient L proxy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private transient L[] prototypeArray;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T> EventListenerSupport<T> create(Class<T> paramClass) {
/* 109 */     return new EventListenerSupport<>(paramClass);
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
/*     */   public EventListenerSupport(Class<L> paramClass) {
/* 125 */     this(paramClass, Thread.currentThread().getContextClassLoader());
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
/*     */   public EventListenerSupport(Class<L> paramClass, ClassLoader paramClassLoader) {
/* 142 */     this();
/* 143 */     Validate.notNull(paramClass, "Listener interface cannot be null.", new Object[0]);
/* 144 */     Validate.notNull(paramClassLoader, "ClassLoader cannot be null.", new Object[0]);
/* 145 */     Validate.isTrue(paramClass.isInterface(), "Class %s is not an interface", new Object[] { paramClass
/* 146 */           .getName() });
/* 147 */     initializeTransientFields(paramClass, paramClassLoader);
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
/*     */   public L fire() {
/* 166 */     return this.proxy;
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
/*     */   public void addListener(L paramL) {
/* 182 */     addListener(paramL, true);
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
/*     */   public void addListener(L paramL, boolean paramBoolean) {
/* 197 */     Validate.notNull(paramL, "Listener object cannot be null.", new Object[0]);
/* 198 */     if (paramBoolean || !this.listeners.contains(paramL)) {
/* 199 */       this.listeners.add(paramL);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getListenerCount() {
/* 209 */     return this.listeners.size();
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
/*     */   public void removeListener(L paramL) {
/* 221 */     Validate.notNull(paramL, "Listener object cannot be null.", new Object[0]);
/* 222 */     this.listeners.remove(paramL);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public L[] getListeners() {
/* 232 */     return this.listeners.toArray(this.prototypeArray);
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
/*     */   private void writeObject(ObjectOutputStream paramObjectOutputStream) throws IOException {
/*     */     // Byte code:
/*     */     //   0: new java/util/ArrayList
/*     */     //   3: dup
/*     */     //   4: invokespecial <init> : ()V
/*     */     //   7: astore_2
/*     */     //   8: new java/io/ObjectOutputStream
/*     */     //   11: dup
/*     */     //   12: new java/io/ByteArrayOutputStream
/*     */     //   15: dup
/*     */     //   16: invokespecial <init> : ()V
/*     */     //   19: invokespecial <init> : (Ljava/io/OutputStream;)V
/*     */     //   22: astore_3
/*     */     //   23: aload_0
/*     */     //   24: getfield listeners : Ljava/util/List;
/*     */     //   27: invokeinterface iterator : ()Ljava/util/Iterator;
/*     */     //   32: astore #4
/*     */     //   34: aload #4
/*     */     //   36: invokeinterface hasNext : ()Z
/*     */     //   41: ifeq -> 89
/*     */     //   44: aload #4
/*     */     //   46: invokeinterface next : ()Ljava/lang/Object;
/*     */     //   51: astore #5
/*     */     //   53: aload_3
/*     */     //   54: aload #5
/*     */     //   56: invokevirtual writeObject : (Ljava/lang/Object;)V
/*     */     //   59: aload_2
/*     */     //   60: aload #5
/*     */     //   62: invokevirtual add : (Ljava/lang/Object;)Z
/*     */     //   65: pop
/*     */     //   66: goto -> 86
/*     */     //   69: astore #6
/*     */     //   71: new java/io/ObjectOutputStream
/*     */     //   74: dup
/*     */     //   75: new java/io/ByteArrayOutputStream
/*     */     //   78: dup
/*     */     //   79: invokespecial <init> : ()V
/*     */     //   82: invokespecial <init> : (Ljava/io/OutputStream;)V
/*     */     //   85: astore_3
/*     */     //   86: goto -> 34
/*     */     //   89: aload_1
/*     */     //   90: aload_2
/*     */     //   91: aload_0
/*     */     //   92: getfield prototypeArray : [Ljava/lang/Object;
/*     */     //   95: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
/*     */     //   98: invokevirtual writeObject : (Ljava/lang/Object;)V
/*     */     //   101: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #241	-> 0
/*     */     //   #244	-> 8
/*     */     //   #245	-> 23
/*     */     //   #247	-> 53
/*     */     //   #248	-> 59
/*     */     //   #252	-> 66
/*     */     //   #249	-> 69
/*     */     //   #251	-> 71
/*     */     //   #253	-> 86
/*     */     //   #258	-> 89
/*     */     //   #259	-> 101
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   53	66	69	java/io/IOException
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
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/* 270 */     Object[] arrayOfObject = (Object[])paramObjectInputStream.readObject();
/*     */     
/* 272 */     this.listeners = new CopyOnWriteArrayList<>((L[])arrayOfObject);
/*     */ 
/*     */ 
/*     */     
/* 276 */     Class<?> clazz = arrayOfObject.getClass().getComponentType();
/*     */     
/* 278 */     initializeTransientFields((Class)clazz, Thread.currentThread().getContextClassLoader());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initializeTransientFields(Class<L> paramClass, ClassLoader paramClassLoader) {
/* 289 */     Object[] arrayOfObject = (Object[])Array.newInstance(paramClass, 0);
/* 290 */     this.prototypeArray = (L[])arrayOfObject;
/* 291 */     createProxy(paramClass, paramClassLoader);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void createProxy(Class<L> paramClass, ClassLoader paramClassLoader) {
/* 300 */     this.proxy = paramClass.cast(Proxy.newProxyInstance(paramClassLoader, new Class[] { paramClass
/* 301 */           }, createInvocationHandler()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected InvocationHandler createInvocationHandler() {
/* 310 */     return new ProxyInvocationHandler();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private EventListenerSupport() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected class ProxyInvocationHandler
/*     */     implements InvocationHandler
/*     */   {
/*     */     public Object invoke(Object param1Object, Method param1Method, Object[] param1ArrayOfObject) throws Throwable {
/* 332 */       for (Object object : EventListenerSupport.this.listeners) {
/* 333 */         param1Method.invoke(object, param1ArrayOfObject);
/*     */       }
/* 335 */       return null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\event\EventListenerSupport.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */