/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import java.net.URI;
/*     */ import java.util.AbstractList;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
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
/*     */ public class RedirectLocations
/*     */   extends AbstractList<Object>
/*     */ {
/*  51 */   private final Set<URI> unique = new HashSet<URI>();
/*  52 */   private final List<URI> all = new ArrayList<URI>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(URI paramURI) {
/*  59 */     return this.unique.contains(paramURI);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(URI paramURI) {
/*  66 */     this.unique.add(paramURI);
/*  67 */     this.all.add(paramURI);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean remove(URI paramURI) {
/*  74 */     boolean bool = this.unique.remove(paramURI);
/*  75 */     if (bool) {
/*  76 */       Iterator<URI> iterator = this.all.iterator();
/*  77 */       while (iterator.hasNext()) {
/*  78 */         URI uRI = iterator.next();
/*  79 */         if (uRI.equals(paramURI)) {
/*  80 */           iterator.remove();
/*     */         }
/*     */       } 
/*     */     } 
/*  84 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<URI> getAll() {
/*  95 */     return new ArrayList<URI>(this.all);
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
/*     */   public URI get(int paramInt) {
/* 111 */     return this.all.get(paramInt);
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
/*     */   public int size() {
/* 124 */     return this.all.size();
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
/*     */   public Object set(int paramInt, Object paramObject) {
/* 150 */     URI uRI = this.all.set(paramInt, (URI)paramObject);
/* 151 */     this.unique.remove(uRI);
/* 152 */     this.unique.add((URI)paramObject);
/* 153 */     if (this.all.size() != this.unique.size()) {
/* 154 */       this.unique.addAll(this.all);
/*     */     }
/* 156 */     return uRI;
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
/*     */   public void add(int paramInt, Object paramObject) {
/* 182 */     this.all.add(paramInt, (URI)paramObject);
/* 183 */     this.unique.add((URI)paramObject);
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
/*     */   public URI remove(int paramInt) {
/* 201 */     URI uRI = this.all.remove(paramInt);
/* 202 */     this.unique.remove(uRI);
/* 203 */     if (this.all.size() != this.unique.size()) {
/* 204 */       this.unique.addAll(this.all);
/*     */     }
/* 206 */     return uRI;
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
/*     */   public boolean contains(Object paramObject) {
/* 221 */     return this.unique.contains(paramObject);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\RedirectLocations.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */