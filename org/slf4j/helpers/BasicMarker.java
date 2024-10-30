/*     */ package org.slf4j.helpers;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.CopyOnWriteArrayList;
/*     */ import org.slf4j.Marker;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BasicMarker
/*     */   implements Marker
/*     */ {
/*     */   private static final long serialVersionUID = -2849567615646933777L;
/*     */   private final String name;
/*  43 */   private List<Marker> referenceList = new CopyOnWriteArrayList<Marker>();
/*     */   
/*     */   BasicMarker(String paramString) {
/*  46 */     if (paramString == null) {
/*  47 */       throw new IllegalArgumentException("A marker name cannot be null");
/*     */     }
/*  49 */     this.name = paramString;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  53 */     return this.name;
/*     */   }
/*     */   
/*     */   public void add(Marker paramMarker) {
/*  57 */     if (paramMarker == null) {
/*  58 */       throw new IllegalArgumentException("A null value cannot be added to a Marker as reference.");
/*     */     }
/*     */ 
/*     */     
/*  62 */     if (contains(paramMarker)) {
/*     */       return;
/*     */     }
/*  65 */     if (paramMarker.contains(this)) {
/*     */       return;
/*     */     }
/*     */     
/*  69 */     this.referenceList.add(paramMarker);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasReferences() {
/*  74 */     return (this.referenceList.size() > 0);
/*     */   }
/*     */   
/*     */   public boolean hasChildren() {
/*  78 */     return hasReferences();
/*     */   }
/*     */   
/*     */   public Iterator<Marker> iterator() {
/*  82 */     return this.referenceList.iterator();
/*     */   }
/*     */   
/*     */   public boolean remove(Marker paramMarker) {
/*  86 */     return this.referenceList.remove(paramMarker);
/*     */   }
/*     */   
/*     */   public boolean contains(Marker paramMarker) {
/*  90 */     if (paramMarker == null) {
/*  91 */       throw new IllegalArgumentException("Other cannot be null");
/*     */     }
/*     */     
/*  94 */     if (equals(paramMarker)) {
/*  95 */       return true;
/*     */     }
/*     */     
/*  98 */     if (hasReferences()) {
/*  99 */       for (Marker marker : this.referenceList) {
/* 100 */         if (marker.contains(paramMarker)) {
/* 101 */           return true;
/*     */         }
/*     */       } 
/*     */     }
/* 105 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(String paramString) {
/* 112 */     if (paramString == null) {
/* 113 */       throw new IllegalArgumentException("Other cannot be null");
/*     */     }
/*     */     
/* 116 */     if (this.name.equals(paramString)) {
/* 117 */       return true;
/*     */     }
/*     */     
/* 120 */     if (hasReferences()) {
/* 121 */       for (Marker marker : this.referenceList) {
/* 122 */         if (marker.contains(paramString)) {
/* 123 */           return true;
/*     */         }
/*     */       } 
/*     */     }
/* 127 */     return false;
/*     */   }
/*     */   
/* 130 */   private static String OPEN = "[ ";
/* 131 */   private static String CLOSE = " ]";
/* 132 */   private static String SEP = ", ";
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 135 */     if (this == paramObject)
/* 136 */       return true; 
/* 137 */     if (paramObject == null)
/* 138 */       return false; 
/* 139 */     if (!(paramObject instanceof Marker)) {
/* 140 */       return false;
/*     */     }
/* 142 */     Marker marker = (Marker)paramObject;
/* 143 */     return this.name.equals(marker.getName());
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 147 */     return this.name.hashCode();
/*     */   }
/*     */   
/*     */   public String toString() {
/* 151 */     if (!hasReferences()) {
/* 152 */       return getName();
/*     */     }
/* 154 */     Iterator<Marker> iterator = iterator();
/*     */     
/* 156 */     StringBuilder stringBuilder = new StringBuilder(getName());
/* 157 */     stringBuilder.append(' ').append(OPEN);
/* 158 */     while (iterator.hasNext()) {
/* 159 */       Marker marker = iterator.next();
/* 160 */       stringBuilder.append(marker.getName());
/* 161 */       if (iterator.hasNext()) {
/* 162 */         stringBuilder.append(SEP);
/*     */       }
/*     */     } 
/* 165 */     stringBuilder.append(CLOSE);
/*     */     
/* 167 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\slf4j\helpers\BasicMarker.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */