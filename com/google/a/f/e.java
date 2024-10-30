/*     */ package com.google.a.f;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.x;
/*     */ import com.google.a.o.a.ab;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Iterator;
/*     */ import java.util.Locale;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ public class e
/*     */ {
/*  98 */   private static final Logger logger = Logger.getLogger(e.class.getName());
/*     */   
/*     */   private final String identifier;
/*     */   private final Executor executor;
/*     */   private final i a;
/*     */   private final j a;
/* 104 */   private final d a = (d)new j(this);
/*     */ 
/*     */ 
/*     */   
/*     */   public e() {
/* 109 */     this("default");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e(String paramString) {
/* 119 */     this(paramString, 
/*     */         
/* 121 */         ab.b(), 
/* 122 */         d.a(), a.a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e(i parami) {
/* 133 */     this("default", 
/*     */         
/* 135 */         ab.b(), 
/* 136 */         d.a(), parami);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   e(String paramString, Executor paramExecutor, d paramd, i parami) {
/* 145 */     this.identifier = (String)D.checkNotNull(paramString);
/* 146 */     this.executor = (Executor)D.checkNotNull(paramExecutor);
/* 147 */     this.a = (d)D.checkNotNull(paramd);
/* 148 */     this.a = (d)D.checkNotNull(parami);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String dl() {
/* 157 */     return this.identifier;
/*     */   }
/*     */ 
/*     */   
/*     */   final Executor a() {
/* 162 */     return this.executor;
/*     */   }
/*     */ 
/*     */   
/*     */   void a(Throwable paramThrowable, h paramh) {
/* 167 */     D.checkNotNull(paramThrowable);
/* 168 */     D.checkNotNull(paramh);
/*     */     try {
/* 170 */       this.a.b(paramThrowable, paramh);
/* 171 */     } catch (Throwable throwable) {
/*     */       
/* 173 */       logger.log(Level.SEVERE, 
/*     */           
/* 175 */           String.format(Locale.ROOT, "Exception %s thrown while handling exception: %s", new Object[] { throwable, paramThrowable }), throwable);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void register(Object paramObject) {
/* 186 */     this.a.register(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregister(Object paramObject) {
/* 196 */     this.a.unregister(paramObject);
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
/*     */   public void q(Object paramObject) {
/* 210 */     Iterator<g> iterator = this.a.a(paramObject);
/* 211 */     if (iterator.hasNext()) {
/* 212 */       this.a.a(paramObject, iterator);
/* 213 */     } else if (!(paramObject instanceof c)) {
/*     */       
/* 215 */       q(new c(this, paramObject));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 221 */     return x.a(this).b(this.identifier).toString();
/*     */   }
/*     */   
/*     */   static final class a
/*     */     implements i {
/* 226 */     static final a a = new a();
/*     */ 
/*     */     
/*     */     public void b(Throwable param1Throwable, h param1h) {
/* 230 */       Logger logger = a(param1h);
/* 231 */       if (logger.isLoggable(Level.SEVERE)) {
/* 232 */         logger.log(Level.SEVERE, a(param1h), param1Throwable);
/*     */       }
/*     */     }
/*     */     
/*     */     private static Logger a(h param1h) {
/* 237 */       String str1 = e.class.getName(), str2 = param1h.a().dl(); return Logger.getLogger((new StringBuilder(1 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(".").append(str2).toString());
/*     */     }
/*     */     
/*     */     private static String a(h param1h) {
/* 241 */       Method method = param1h.f();
/*     */       
/* 243 */       String str1 = method.getName();
/*     */       
/* 245 */       String str2 = method.getParameterTypes()[0].getName();
/*     */ 
/*     */       
/* 248 */       String str3 = String.valueOf(param1h.z());
/*     */       
/* 250 */       String str4 = String.valueOf(param1h.y()); return (new StringBuilder(80 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length())).append("Exception thrown by subscriber method ").append(str1).append('(').append(str2).append(')').append(" on subscriber ").append(str3).append(" when dispatching event: ").append(str4).toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\f\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */