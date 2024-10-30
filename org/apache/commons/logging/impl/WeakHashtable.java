/*     */ package org.apache.commons.logging.impl;
/*     */ 
/*     */ import java.lang.ref.ReferenceQueue;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Enumeration;
/*     */ import java.util.HashSet;
/*     */ import java.util.Hashtable;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class WeakHashtable
/*     */   extends Hashtable
/*     */ {
/*     */   private static final long serialVersionUID = -1546036869799732453L;
/*     */   private static final int MAX_CHANGES_BEFORE_PURGE = 100;
/*     */   private static final int PARTIAL_PURGE_COUNT = 10;
/* 129 */   private final ReferenceQueue queue = new ReferenceQueue();
/*     */   
/* 131 */   private int changeCount = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsKey(Object paramObject) {
/* 144 */     Referenced referenced = new Referenced(paramObject);
/* 145 */     return super.containsKey(referenced);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Enumeration elements() {
/* 152 */     purge();
/* 153 */     return super.elements();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set entrySet() {
/* 160 */     purge();
/* 161 */     Set set = super.entrySet();
/* 162 */     HashSet hashSet = new HashSet();
/* 163 */     for (Map.Entry<?, ?> entry : set) {
/*     */       
/* 165 */       Referenced referenced = (Referenced)entry.getKey();
/* 166 */       Object object1 = referenced.getValue();
/* 167 */       Object object2 = entry.getValue();
/* 168 */       if (object1 != null) {
/* 169 */         Entry entry1 = new Entry(object1, object2);
/* 170 */         hashSet.add(entry1);
/*     */       } 
/*     */     } 
/* 173 */     return hashSet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object get(Object paramObject) {
/* 181 */     Referenced referenced = new Referenced(paramObject);
/* 182 */     return super.get(referenced);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Enumeration keys() {
/* 189 */     purge();
/* 190 */     Enumeration enumeration = super.keys();
/* 191 */     return new Enumeration(this, enumeration) { private final Enumeration val$enumer;
/*     */         public boolean hasMoreElements() {
/* 193 */           return this.val$enumer.hasMoreElements();
/*     */         } private final WeakHashtable this$0;
/*     */         public Object nextElement() {
/* 196 */           WeakHashtable.Referenced referenced = this.val$enumer.nextElement();
/* 197 */           return referenced.getValue();
/*     */         } }
/*     */       ;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set keySet() {
/* 206 */     purge();
/* 207 */     Set set = super.keySet();
/* 208 */     HashSet hashSet = new HashSet();
/* 209 */     for (Referenced referenced : set) {
/*     */       
/* 211 */       Object object = referenced.getValue();
/* 212 */       if (object != null) {
/* 213 */         hashSet.add(object);
/*     */       }
/*     */     } 
/* 216 */     return hashSet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized Object put(Object paramObject1, Object paramObject2) {
/* 224 */     if (paramObject1 == null) {
/* 225 */       throw new NullPointerException("Null keys are not allowed");
/*     */     }
/* 227 */     if (paramObject2 == null) {
/* 228 */       throw new NullPointerException("Null values are not allowed");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 233 */     if (this.changeCount++ > 100) {
/* 234 */       purge();
/* 235 */       this.changeCount = 0;
/*     */     
/*     */     }
/* 238 */     else if (this.changeCount % 10 == 0) {
/* 239 */       purgeOne();
/*     */     } 
/*     */     
/* 242 */     Referenced referenced = new Referenced(paramObject1, this.queue);
/* 243 */     return super.put(referenced, paramObject2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void putAll(Map paramMap) {
/* 250 */     if (paramMap != null) {
/* 251 */       Set set = paramMap.entrySet();
/* 252 */       for (Map.Entry entry : set)
/*     */       {
/* 254 */         put(entry.getKey(), entry.getValue());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection values() {
/* 263 */     purge();
/* 264 */     return super.values();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized Object remove(Object paramObject) {
/* 273 */     if (this.changeCount++ > 100) {
/* 274 */       purge();
/* 275 */       this.changeCount = 0;
/*     */     
/*     */     }
/* 278 */     else if (this.changeCount % 10 == 0) {
/* 279 */       purgeOne();
/*     */     } 
/* 281 */     return super.remove(new Referenced(paramObject));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 288 */     purge();
/* 289 */     return super.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 296 */     purge();
/* 297 */     return super.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 304 */     purge();
/* 305 */     return super.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void rehash() {
/* 313 */     purge();
/* 314 */     super.rehash();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void purge() {
/* 322 */     ArrayList arrayList = new ArrayList();
/* 323 */     synchronized (this.queue) {
/*     */       WeakKey weakKey;
/* 325 */       while ((weakKey = (WeakKey)this.queue.poll()) != null) {
/* 326 */         arrayList.add(weakKey.getReferenced());
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 333 */     int i = arrayList.size();
/* 334 */     for (byte b = 0; b < i; b++) {
/* 335 */       super.remove(arrayList.get(b));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void purgeOne() {
/* 344 */     synchronized (this.queue) {
/* 345 */       WeakKey weakKey = (WeakKey)this.queue.poll();
/* 346 */       if (weakKey != null) {
/* 347 */         super.remove(weakKey.getReferenced());
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private static final class Entry
/*     */     implements Map.Entry
/*     */   {
/*     */     private final Object key;
/*     */     private final Object value;
/*     */     
/*     */     private Entry(Object param1Object1, Object param1Object2) {
/* 359 */       this.key = param1Object1;
/* 360 */       this.value = param1Object2;
/*     */     }
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 364 */       boolean bool = false;
/* 365 */       if (param1Object != null && param1Object instanceof Map.Entry) {
/* 366 */         Map.Entry entry = (Map.Entry)param1Object;
/* 367 */         bool = (((getKey() == null) ? (entry.getKey() == null) : getKey().equals(entry.getKey())) && ((getValue() == null) ? (entry.getValue() == null) : getValue().equals(entry.getValue()))) ? true : false;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 374 */       return bool;
/*     */     }
/*     */     
/*     */     public int hashCode() {
/* 378 */       return ((getKey() == null) ? 0 : getKey().hashCode()) ^ ((getValue() == null) ? 0 : getValue().hashCode());
/*     */     }
/*     */ 
/*     */     
/*     */     public Object setValue(Object param1Object) {
/* 383 */       throw new UnsupportedOperationException("Entry.setValue is not supported.");
/*     */     }
/*     */     
/*     */     public Object getValue() {
/* 387 */       return this.value;
/*     */     }
/*     */     
/*     */     public Object getKey() {
/* 391 */       return this.key;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class Referenced
/*     */   {
/*     */     private final WeakReference reference;
/*     */ 
/*     */     
/*     */     private final int hashCode;
/*     */ 
/*     */     
/*     */     private Referenced(Object param1Object) {
/* 406 */       this.reference = new WeakReference(param1Object);
/*     */ 
/*     */       
/* 409 */       this.hashCode = param1Object.hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private Referenced(Object param1Object, ReferenceQueue param1ReferenceQueue) {
/* 417 */       this.reference = new WeakHashtable.WeakKey(param1Object, param1ReferenceQueue, this);
/*     */ 
/*     */       
/* 420 */       this.hashCode = param1Object.hashCode();
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 425 */       return this.hashCode;
/*     */     }
/*     */     
/*     */     private Object getValue() {
/* 429 */       return this.reference.get();
/*     */     }
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 433 */       boolean bool = false;
/* 434 */       if (param1Object instanceof Referenced) {
/* 435 */         Referenced referenced = (Referenced)param1Object;
/* 436 */         Object object1 = getValue();
/* 437 */         Object object2 = referenced.getValue();
/* 438 */         if (object1 == null) {
/* 439 */           bool = (object2 == null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 447 */           bool = (bool && hashCode() == referenced.hashCode());
/*     */ 
/*     */         
/*     */         }
/*     */         else {
/*     */ 
/*     */ 
/*     */           
/* 455 */           bool = object1.equals(object2);
/*     */         } 
/*     */       } 
/* 458 */       return bool;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final class WeakKey
/*     */     extends WeakReference
/*     */   {
/*     */     private final WeakHashtable.Referenced referenced;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private WeakKey(Object param1Object, ReferenceQueue param1ReferenceQueue, WeakHashtable.Referenced param1Referenced) {
/* 474 */       super((T)param1Object, param1ReferenceQueue);
/* 475 */       this.referenced = param1Referenced;
/*     */     }
/*     */     
/*     */     private WeakHashtable.Referenced getReferenced() {
/* 479 */       return this.referenced;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\logging\impl\WeakHashtable.class
 * Java compiler version: 2 (46.0)
 * JD-Core Version:       1.1.3
 */