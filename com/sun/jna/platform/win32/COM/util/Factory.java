/*     */ package com.sun.jna.platform.win32.COM.util;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.COMException;
/*     */ import com.sun.jna.platform.win32.COM.IDispatch;
/*     */ import com.sun.jna.platform.win32.COM.IDispatchCallback;
/*     */ import com.sun.jna.platform.win32.COM.util.annotation.ComObject;
/*     */ import com.sun.jna.platform.win32.Guid;
/*     */ import com.sun.jna.platform.win32.OaIdl;
/*     */ import com.sun.jna.platform.win32.OleAuto;
/*     */ import com.sun.jna.platform.win32.Variant;
/*     */ import com.sun.jna.platform.win32.WinDef;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import com.sun.jna.ptr.IntByReference;
/*     */ import java.lang.reflect.InvocationHandler;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Proxy;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.TimeoutException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Factory
/*     */   extends ObjectFactory
/*     */ {
/*     */   private ComThread comThread;
/*     */   
/*     */   public Factory() {
/*  61 */     this(new ComThread("Default Factory COM Thread", 5000L, new Thread.UncaughtExceptionHandler()
/*     */           {
/*     */             public void uncaughtException(Thread param1Thread, Throwable param1Throwable) {}
/*     */           }));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Factory(ComThread paramComThread) {
/*  70 */     this.comThread = paramComThread;
/*     */   }
/*     */   
/*     */   private class ProxyObject2
/*     */     implements InvocationHandler {
/*     */     private final Object delegate;
/*     */     
/*     */     public ProxyObject2(Object param1Object) {
/*  78 */       this.delegate = param1Object;
/*     */     }
/*     */ 
/*     */     
/*     */     public Object invoke(Object param1Object, final Method method, final Object[] args) throws Throwable {
/*  83 */       if (args != null) {
/*  84 */         for (byte b = 0; b < args.length; b++) {
/*  85 */           if (args[b] != null && 
/*  86 */             Proxy.isProxyClass(args[b].getClass())) {
/*  87 */             InvocationHandler invocationHandler = Proxy.getInvocationHandler(args[b]);
/*  88 */             if (invocationHandler instanceof ProxyObject2) {
/*  89 */               args[b] = ((ProxyObject2)invocationHandler).delegate;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/*  95 */       return Factory.this.runInComThread(new Callable()
/*     */           {
/*     */             public Object call() throws Exception {
/*  98 */               return method.invoke(Factory.ProxyObject2.this.delegate, args);
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */   
/*     */   private class CallbackProxy2
/*     */     extends CallbackProxy {
/*     */     public CallbackProxy2(ObjectFactory param1ObjectFactory, Class<?> param1Class, IComEventCallbackListener param1IComEventCallbackListener) {
/* 107 */       super(param1ObjectFactory, param1Class, param1IComEventCallbackListener);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public WinNT.HRESULT Invoke(OaIdl.DISPID param1DISPID, Guid.REFIID param1REFIID, WinDef.LCID param1LCID, WinDef.WORD param1WORD, OleAuto.DISPPARAMS.ByReference param1ByReference, Variant.VARIANT.ByReference param1ByReference1, OaIdl.EXCEPINFO.ByReference param1ByReference2, IntByReference param1IntByReference) {
/* 114 */       ComThread.setComThread(true);
/*     */       try {
/* 116 */         return super.Invoke(param1DISPID, param1REFIID, param1LCID, param1WORD, param1ByReference, param1ByReference1, param1ByReference2, param1IntByReference);
/*     */       } finally {
/* 118 */         ComThread.setComThread(false);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public <T> T createProxy(Class<T> paramClass, IDispatch paramIDispatch) {
/* 125 */     Object object = super.createProxy((Class)paramClass, paramIDispatch);
/* 126 */     ProxyObject2 proxyObject2 = new ProxyObject2(object);
/* 127 */     return (T)Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass }, proxyObject2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Guid.GUID discoverClsId(final ComObject annotation) {
/* 133 */     return runInComThread(new Callable<Guid.GUID>() {
/*     */           public Guid.GUID call() throws Exception {
/* 135 */             return Factory.this.discoverClsId(annotation);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T fetchObject(final Class<T> comInterface) throws COMException {
/* 143 */     return runInComThread(new Callable<T>() {
/*     */           public T call() throws Exception {
/* 145 */             return Factory.this.fetchObject(comInterface);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T createObject(final Class<T> comInterface) {
/* 153 */     return runInComThread(new Callable<T>() {
/*     */           public T call() throws Exception {
/* 155 */             return Factory.this.createObject(comInterface);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   IDispatchCallback createDispatchCallback(Class<?> paramClass, IComEventCallbackListener paramIComEventCallbackListener) {
/* 162 */     return new CallbackProxy2(this, paramClass, paramIComEventCallbackListener);
/*     */   }
/*     */ 
/*     */   
/*     */   public IRunningObjectTable getRunningObjectTable() {
/* 167 */     return super.getRunningObjectTable();
/*     */   }
/*     */   
/*     */   private <T> T runInComThread(Callable<T> paramCallable) {
/*     */     try {
/* 172 */       return this.comThread.execute(paramCallable);
/* 173 */     } catch (TimeoutException timeoutException) {
/* 174 */       throw new RuntimeException(timeoutException);
/* 175 */     } catch (InterruptedException interruptedException) {
/* 176 */       throw new RuntimeException(interruptedException);
/* 177 */     } catch (ExecutionException executionException) {
/* 178 */       Throwable throwable = executionException.getCause();
/* 179 */       if (throwable instanceof RuntimeException) {
/* 180 */         appendStacktrace(executionException, throwable);
/* 181 */         throw (RuntimeException)throwable;
/* 182 */       }  if (throwable instanceof InvocationTargetException) {
/* 183 */         throwable = ((InvocationTargetException)throwable).getTargetException();
/* 184 */         if (throwable instanceof RuntimeException) {
/* 185 */           appendStacktrace(executionException, throwable);
/* 186 */           throw (RuntimeException)throwable;
/*     */         } 
/*     */       } 
/* 189 */       throw new RuntimeException(executionException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void appendStacktrace(Exception paramException, Throwable paramThrowable) {
/* 198 */     StackTraceElement[] arrayOfStackTraceElement1 = paramException.getStackTrace();
/* 199 */     StackTraceElement[] arrayOfStackTraceElement2 = paramThrowable.getStackTrace();
/* 200 */     StackTraceElement[] arrayOfStackTraceElement3 = new StackTraceElement[arrayOfStackTraceElement1.length + arrayOfStackTraceElement2.length];
/* 201 */     System.arraycopy(arrayOfStackTraceElement1, 0, arrayOfStackTraceElement3, arrayOfStackTraceElement2.length, arrayOfStackTraceElement1.length);
/* 202 */     System.arraycopy(arrayOfStackTraceElement2, 0, arrayOfStackTraceElement3, 0, arrayOfStackTraceElement2.length);
/* 203 */     paramThrowable.setStackTrace(arrayOfStackTraceElement3);
/*     */   }
/*     */   
/*     */   public ComThread getComThread() {
/* 207 */     return this.comThread;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\CO\\util\Factory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */