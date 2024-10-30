/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.Serializable;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.TreeSet;
/*     */ import java.util.concurrent.locks.ReadWriteLock;
/*     */ import java.util.concurrent.locks.ReentrantReadWriteLock;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.client.CookieStore;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.apache.http.cookie.CookieIdentityComparator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public class BasicCookieStore
/*     */   implements Serializable, CookieStore
/*     */ {
/*     */   private static final long serialVersionUID = -7581093305228232025L;
/*  62 */   private final TreeSet<Cookie> cookies = new TreeSet<Cookie>((Comparator<? super Cookie>)new CookieIdentityComparator());
/*  63 */   private transient ReadWriteLock lock = new ReentrantReadWriteLock();
/*     */ 
/*     */   
/*     */   private void readObject(ObjectInputStream paramObjectInputStream) throws IOException, ClassNotFoundException {
/*  67 */     paramObjectInputStream.defaultReadObject();
/*     */ 
/*     */     
/*  70 */     this.lock = new ReentrantReadWriteLock();
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
/*     */   public void addCookie(Cookie paramCookie) {
/*  85 */     if (paramCookie != null) {
/*  86 */       this.lock.writeLock().lock();
/*     */       
/*     */       try {
/*  89 */         this.cookies.remove(paramCookie);
/*  90 */         if (!paramCookie.isExpired(new Date())) {
/*  91 */           this.cookies.add(paramCookie);
/*     */         }
/*     */       } finally {
/*  94 */         this.lock.writeLock().unlock();
/*     */       } 
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
/*     */   public void addCookies(Cookie[] paramArrayOfCookie) {
/* 110 */     if (paramArrayOfCookie != null) {
/* 111 */       for (Cookie cookie : paramArrayOfCookie) {
/* 112 */         addCookie(cookie);
/*     */       }
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
/*     */   public List<Cookie> getCookies() {
/* 125 */     this.lock.readLock().lock();
/*     */     
/*     */     try {
/* 128 */       return new ArrayList<Cookie>(this.cookies);
/*     */     } finally {
/* 130 */       this.lock.readLock().unlock();
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
/*     */   public boolean clearExpired(Date paramDate) {
/* 144 */     if (paramDate == null) {
/* 145 */       return false;
/*     */     }
/* 147 */     this.lock.writeLock().lock();
/*     */     try {
/* 149 */       boolean bool = false;
/* 150 */       for (Iterator<Cookie> iterator = this.cookies.iterator(); iterator.hasNext();) {
/* 151 */         if (((Cookie)iterator.next()).isExpired(paramDate)) {
/* 152 */           iterator.remove();
/* 153 */           bool = true;
/*     */         } 
/*     */       } 
/* 156 */       return bool;
/*     */     } finally {
/* 158 */       this.lock.writeLock().unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 167 */     this.lock.writeLock().lock();
/*     */     try {
/* 169 */       this.cookies.clear();
/*     */     } finally {
/* 171 */       this.lock.writeLock().unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 177 */     this.lock.readLock().lock();
/*     */     try {
/* 179 */       return this.cookies.toString();
/*     */     } finally {
/* 181 */       this.lock.readLock().unlock();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\BasicCookieStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */