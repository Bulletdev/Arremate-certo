/*     */ package com.google.a.f;
/*     */ 
/*     */ import com.google.a.a.d;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.O;
/*     */ import com.google.a.b.x;
/*     */ import com.google.a.b.y;
/*     */ import com.google.a.c.d;
/*     */ import com.google.a.c.f;
/*     */ import com.google.a.d.aV;
/*     */ import com.google.a.d.bH;
/*     */ import com.google.a.d.bS;
/*     */ import com.google.a.d.bW;
/*     */ import com.google.a.d.bZ;
/*     */ import com.google.a.d.bh;
/*     */ import com.google.a.d.bt;
/*     */ import com.google.a.d.dj;
/*     */ import com.google.a.m.p;
/*     */ import com.google.a.n.m;
/*     */ import com.google.a.o.a.au;
/*     */ import com.google.c.a.i;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentMap;
/*     */ import java.util.concurrent.CopyOnWriteArraySet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class j
/*     */ {
/*  65 */   private final ConcurrentMap<Class<?>, CopyOnWriteArraySet<g>> d = bW.d();
/*     */   
/*     */   @i
/*     */   private final e a;
/*     */   
/*     */   j(e parame) {
/*  71 */     this.a = (e)D.checkNotNull(parame);
/*     */   }
/*     */ 
/*     */   
/*     */   void register(Object paramObject) {
/*  76 */     bZ<Class<?>, g> bZ = a(paramObject);
/*     */     
/*  78 */     for (Map.Entry entry : bZ.asMap().entrySet()) {
/*  79 */       Class<?> clazz = (Class)entry.getKey();
/*  80 */       Collection collection = (Collection)entry.getValue();
/*     */       
/*  82 */       CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet)this.d.get(clazz);
/*     */       
/*  84 */       if (copyOnWriteArraySet == null) {
/*  85 */         CopyOnWriteArraySet copyOnWriteArraySet1 = new CopyOnWriteArraySet();
/*     */         
/*  87 */         copyOnWriteArraySet = (CopyOnWriteArraySet)x.a(this.d.putIfAbsent(clazz, copyOnWriteArraySet1), copyOnWriteArraySet1);
/*     */       } 
/*     */       
/*  90 */       copyOnWriteArraySet.addAll(collection);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void unregister(Object paramObject) {
/*  96 */     bZ<Class<?>, g> bZ = a(paramObject);
/*     */     
/*  98 */     for (Map.Entry entry : bZ.asMap().entrySet()) {
/*  99 */       Class clazz = (Class)entry.getKey();
/* 100 */       Collection<?> collection = (Collection)entry.getValue();
/*     */       
/* 102 */       CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet)this.d.get(clazz);
/* 103 */       if (copyOnWriteArraySet == null || !copyOnWriteArraySet.removeAll(collection)) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 108 */         String str = String.valueOf(paramObject); throw new IllegalArgumentException((new StringBuilder(65 + String.valueOf(str).length())).append("missing event subscriber for an annotated method. Is ").append(str).append(" registered?").toString());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @d
/*     */   Set<g> a(Class<?> paramClass) {
/* 119 */     return (Set<g>)x.a(this.d.get(paramClass), bt.n());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Iterator<g> a(Object paramObject) {
/* 127 */     bt<Class<?>> bt = a(paramObject.getClass());
/*     */ 
/*     */     
/* 130 */     ArrayList arrayList = bS.a(bt.size());
/*     */     
/* 132 */     for (dj<Class<?>> dj = bt.b(); dj.hasNext(); ) { Class clazz = dj.next();
/* 133 */       CopyOnWriteArraySet copyOnWriteArraySet = (CopyOnWriteArraySet)this.d.get(clazz);
/* 134 */       if (copyOnWriteArraySet != null)
/*     */       {
/* 136 */         arrayList.add(copyOnWriteArraySet.iterator());
/*     */       } }
/*     */ 
/*     */     
/* 140 */     return bH.a(arrayList.iterator());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 150 */   private static final com.google.a.c.j<Class<?>, bh<Method>> c = d.a()
/* 151 */     .c()
/* 152 */     .a(new f<Class<?>, bh<Method>>()
/*     */       {
/*     */         public bh<Method> d(Class<?> param1Class) throws Exception
/*     */         {
/* 156 */           return j.c(param1Class);
/*     */         }
/*     */       });
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private bZ<Class<?>, g> a(Object paramObject) {
/* 164 */     aV aV = aV.a();
/* 165 */     Class<?> clazz = paramObject.getClass();
/* 166 */     for (dj<Method> dj = a(clazz).b(); dj.hasNext(); ) { Method method = dj.next();
/* 167 */       Class[] arrayOfClass = method.getParameterTypes();
/* 168 */       Class clazz1 = arrayOfClass[0];
/* 169 */       aV.put(clazz1, g.a(this.a, paramObject, method)); }
/*     */     
/* 171 */     return (bZ<Class<?>, g>)aV;
/*     */   }
/*     */   
/*     */   private static bh<Method> a(Class<?> paramClass) {
/*     */     try {
/* 176 */       return (bh<Method>)c.h(paramClass);
/* 177 */     } catch (au au) {
/* 178 */       O.a(au.getCause());
/* 179 */       throw au;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static bh<Method> b(Class<?> paramClass) {
/* 184 */     Set set = m.a(paramClass).a().G();
/* 185 */     HashMap<a, Method> hashMap = bW.a();
/* 186 */     for (Class clazz : set) {
/* 187 */       for (Method method : clazz.getDeclaredMethods()) {
/* 188 */         if (method.isAnnotationPresent((Class)f.class) && !method.isSynthetic()) {
/*     */           
/* 190 */           Class[] arrayOfClass = method.getParameterTypes();
/* 191 */           D.a((arrayOfClass.length == 1), "Method %s has @Subscribe annotation but has %s parameters. Subscriber methods must have exactly 1 parameter.", method, arrayOfClass.length);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 198 */           D.a(
/* 199 */               !arrayOfClass[0].isPrimitive(), "@Subscribe method %s's parameter is %s. Subscriber methods cannot accept primitives. Consider changing the parameter to %s.", method, arrayOfClass[0]
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 204 */               .getName(), 
/* 205 */               p.wrap(arrayOfClass[0]).getSimpleName());
/*     */           
/* 207 */           a a = new a(method);
/* 208 */           if (!hashMap.containsKey(a)) {
/* 209 */             hashMap.put(a, method);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 214 */     return bh.a(hashMap.values());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 219 */   private static final com.google.a.c.j<Class<?>, bt<Class<?>>> d = d.a()
/* 220 */     .c()
/* 221 */     .a(new f<Class<?>, bt<Class<?>>>()
/*     */       {
/*     */ 
/*     */         
/*     */         public bt<Class<?>> b(Class<?> param1Class)
/*     */         {
/* 227 */           return bt.a(
/* 228 */               m.a(param1Class).a().G());
/*     */         }
/*     */       });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @d
/*     */   static bt<Class<?>> a(Class<?> paramClass) {
/*     */     try {
/* 239 */       return (bt<Class<?>>)d.h(paramClass);
/* 240 */     } catch (au au) {
/* 241 */       throw O.a(au.getCause());
/*     */     } 
/*     */   }
/*     */   
/*     */   private static final class a
/*     */   {
/*     */     private final String name;
/*     */     private final List<Class<?>> T;
/*     */     
/*     */     a(Method param1Method) {
/* 251 */       this.name = param1Method.getName();
/* 252 */       this.T = Arrays.asList(param1Method.getParameterTypes());
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 257 */       return y.a(new Object[] { this.name, this.T });
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 262 */       if (param1Object instanceof a) {
/* 263 */         a a1 = (a)param1Object;
/* 264 */         return (this.name.equals(a1.name) && this.T.equals(a1.T));
/*     */       } 
/* 266 */       return false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\f\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */